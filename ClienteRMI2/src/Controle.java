

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hendrix
 */
public class Controle {

    //contrutor para iniciar a visao 
    public Controle() throws IOException {
        System.out.println("contrutor controle");
        view_aluno visao = new view_aluno(this);
    }

    //metodo de conexao remota
    public Interface conecta () throws RemoteException, NotBoundException{
        
            System.out.println("conectando no servidor...");
            
            //registra
            Registry registro = LocateRegistry.getRegistry("187.120.112.202", 1234);
            Interface interface_remota = (Interface) registro.lookup("rmiRemoto");
            return interface_remota;
    }
    
    
    public boolean Adicionar(int matricula, String nome) {

        try {
            Interface interface_remota = conecta();
            if (interface_remota.Adicionar(matricula, nome))
            {
                return true;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public String Listar (){

        try {
            Interface interface_remota = conecta();
            return interface_remota.Listar();
            
        } catch (Exception ex) {
            System.out.println("erro 03: "+ex.getMessage());
        }
        return "null";
    }

    public boolean Editar(int codigo, String nome_novo) {
        boolean status = false;
        try {
            Interface interface_remota = conecta();
            status = interface_remota.Editar(codigo, nome_novo);            
        } catch (NotBoundException | IOException ex) {
            System.out.println("Erro 06: "+ ex.getMessage());
        }
        return status;
    }

    public boolean Excluir(int codigo) {
        boolean status = false;
        try {
            Interface interface_remota = conecta();
            if (status = interface_remota.Excluir(codigo)){
                return true;
            }
            
        } catch (NotBoundException | IOException ex) {
            System.out.println("Erro 07: " + ex.getMessage());
        }
        return false;
    }

}
