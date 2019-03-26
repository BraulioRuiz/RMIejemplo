
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JFrame;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ayax9
 */
public class Servidor extends UnicastRemoteObject implements InterfasRMI{
    public Servidor() throws RemoteException {
        /*try{
            InterfasRMI i = new ImplementacionRMI();
            Naming.rebind("rmi://localhost//saludo", i);
        }catch(Exception e){
        
        }*/
        super();
    }
    public static void main(String[] args){
        try{
            Registry registro = LocateRegistry.createRegistry(7777);
            registro.rebind("RemotoRMI", new Servidor());
            System.out.println("servidor Activo");        
        }catch(RemoteException ex){
            System.out.println(ex.getMessage());
        }
    }

   @Override
    public String crearGrafica(int[] datos) throws RemoteException{
        try{
            DefaultCategoryDataset dtsc = new DefaultCategoryDataset();
            dtsc.setValue(datos[0], "Dia1", "Lunes");
            dtsc.setValue(datos[1], "Dia2", "Martes");
            dtsc.setValue(datos[2], "Dia3", "Miercoles");
            dtsc.setValue(datos[3], "Dia4", "Jueves");
            dtsc.setValue(datos[4], "Dia5", "Viernes");
            dtsc.setValue(datos[5], "Dia6", "Sabado");
            dtsc.setValue(datos[6], "Dia7", "Domingo");
            JFreeChart ch = ChartFactory.createBarChart("Grafica de barras 3D", "Dias", "Horas", dtsc,PlotOrientation.VERTICAL, true, true, false);
            JFrame ventana = new JFrame("Grafica");
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ChartPanel cp = new ChartPanel(ch);
            ventana.add(cp);
            ventana.setSize(400,300);
            ventana.setVisible(true);
            ventana.setLocationRelativeTo(null);
            return "Grafica exitosa";
        }catch(Exception e){
            return "Error al crear la Grafica";
        }
    }
}
