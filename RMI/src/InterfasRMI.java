
import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ayax9
 */
public interface InterfasRMI extends Remote {
    public String crearGrafica(int[] datos) throws RemoteException;
    
}
