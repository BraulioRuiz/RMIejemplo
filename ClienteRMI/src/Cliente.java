

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ayax9
 */
public class Cliente {
    public static void main(String[] args){
        Cliente client = new Cliente();
        client.connectServer();
    }
    public void connectServer(){
        try{
            Registry registro = LocateRegistry.getRegistry("127.0.0.1",7777);
            InterfasRMI interfaz = (InterfasRMI) registro.lookup("RemotoRMI");            
            int nombre;
            Scanner sc = new Scanner(System.in);
            nombre = sc.nextInt();
            System.out.println(interfaz.calcularFrecuenciaCarMax(nombre));
        }catch(NotBoundException | RemoteException e){
            System.out.println(e);
        }
    }
}
