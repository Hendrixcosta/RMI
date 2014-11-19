/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Hendrix
 */
public class view_aluno {

    public Controle controle_view;
    
    //construtor
    public view_aluno(Controle controle) throws IOException {
        controle_view = controle;
        opcao();
    }
    
    
    public void opcao () throws IOException {
        int opc;
        
       do {
            opc = Integer.parseInt(JOptionPane.showInputDialog(null, ""
                    + "1 - Adicionar\n"
                    + "2 - Listar\n"
                    + "3 - Editar\n"
                    + "4 - Remover\n"
                    + "5 - Sair"));
            
            switch (opc){
                
                case 1:
                    int matricula = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a matricula: "));
                    String nome = JOptionPane.showInputDialog("Entre com o nome do Aluno: ");
                    if (controle_view.Adicionar(matricula, nome)){
                        JOptionPane.showMessageDialog(null, "Aluno adicionado com Sucesso!");
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Aluno nao adicionado");
                    }
                                 
                break;
                    
                case 2:
                    
                    String lista = controle_view.Listar();
                    JOptionPane.showMessageDialog(null, lista);
                break;
                    
                case 3:
                    int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Entre com o codigo do aluno a ser alterado:"));
                    String nome_novo = JOptionPane.showInputDialog("Entre com o novo nome do Aluno: ");
                    if (controle_view.Editar(codigo, nome_novo)){
                        JOptionPane.showMessageDialog(null, "Aluno Modificado com sucesso!");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Aluno não modificado");
                    }
                   
                break;
                    
                case 4:
                    int aux = Integer.parseInt(JOptionPane.showInputDialog("Entre com o código do Aluno para remover: "));
                    if (controle_view.Excluir(aux)){
                        JOptionPane.showMessageDialog(null, "Aluno Excluido com sucesso!");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Aluno não Excluido");
                    }
                   
                break;
                
               
            }
       }while (opc!=5);
    
    }

}
    
    
    
    
 

