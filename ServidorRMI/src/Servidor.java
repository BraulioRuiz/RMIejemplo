
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

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
    public int calcularFrecuenciaCarMax(int edad) throws RemoteException{
        return 200-edad;
    }
}
