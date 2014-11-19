
import java.io.IOException;
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

    public static void main(String[] args) {
        try {
            
            //cria um registrno no serviço de nome na porta 1234
            Registry registro = LocateRegistry.createRegistry(1234);
            
            //atualiza o registro criado na porta 1245 passando o nome e o objeto 
            //como parametros novos à associação
            registro.rebind("rmiRemoto", new Metodos());
            System.out.println("Servidor aberto " + registro.toString());

        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir o servidor");
            System.out.println(ex.getMessage());
        }
    }
}
