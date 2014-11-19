
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import javax.swing.JTextArea;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hendrix
 */
public interface Interface extends Remote {

    public boolean Adicionar(int matricula, String nome) throws IOException;
    public String Listar() throws FileNotFoundException, IOException, RemoteException;
    public boolean Editar(int codigo, String nome_novo) throws FileNotFoundException, IOException, RemoteException;
    public boolean Excluir(int codigo) throws FileNotFoundException, IOException, RemoteException;
}
