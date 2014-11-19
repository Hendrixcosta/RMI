
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
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
public class Metodos extends UnicastRemoteObject implements Interface{

    public List<Aluno> alunos = new ArrayList<>();
    
    public Metodos() throws RemoteException, IOException, FileNotFoundException, ClassNotFoundException {   
        try {
            recuperar();
        }
        catch (Exception ex){
            System.out.println("Erro 08: "+ex.getMessage());
        }
        
    }
    
    
    @Override
    public boolean Adicionar(int matricula, String nome) throws IOException {
        boolean status = false;
        try {
            Aluno aluno_aux = new Aluno(nome, matricula);
            if (alunos.add(aluno_aux)){
                gravar();
                return true;
            }
            
        } catch (IOException e) {
            System.out.println("Erro 01: " + e.getMessage());
        }
        return false;
    } 
    
    @Override
    public String Listar ()throws FileNotFoundException, IOException, RemoteException {
        try {
            int i;
            String lista_alunos ="";
            for (i=0; i<alunos.size(); i++){
                lista_alunos=lista_alunos + alunos.get(i).getNome() + " \t " + alunos.get(i).getMatricula() + "\n" ;
            }
        
                return lista_alunos;
        }catch(Exception ex) {
                System.out.println("Erro 02: "+ ex.getMessage());
        }
        return null;
    }
    
    @Override
    public boolean Excluir(int codigo) throws FileNotFoundException, IOException, RemoteException {
    
        try {
            int i;
            Aluno aluno_aux;

            for (i=0; i<alunos.size(); i++){

            aluno_aux=alunos.get(i);
            if (aluno_aux.getMatricula()==codigo){
                        alunos.remove(i);
                        gravar();
                        return true;
                    }
                }
                return false; 
        }catch (Exception ex){
            System.out.println("Erro 07: " + ex.getMessage());
        }
        return false;
    }
    
    @Override
    public boolean Editar(int codigo, String nome_novo) throws FileNotFoundException, IOException, RemoteException {
        
        try {
            int i;
        
            Aluno aluno_aux;
        
            for (i=0; i<alunos.size(); i++){

                aluno_aux=alunos.get(i);
                if (aluno_aux.getMatricula()==codigo){
                    aluno_aux.setNome(nome_novo);
                    gravar();
                    return true;
                }
            }
            return false;
        }catch (Exception ex){
            System.out.println("erro 05: "+ ex.getMessage());    
        }    
        return false;
    }
    
        
    
    
    
    public void recuperar () throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream("arquivo.dat");
        ObjectInputStream obj_rec = new ObjectInputStream(file);    
        alunos = (ArrayList)obj_rec.readObject();
    }
              
    
    public void gravar () throws FileNotFoundException, IOException {
        FileOutputStream file = new FileOutputStream("arquivo.dat");
        ObjectOutputStream obj_gravar = new ObjectOutputStream(file);
        obj_gravar.writeObject(alunos);
        obj_gravar.flush();
        obj_gravar.close();        
    }
    

    
       
    
 
     
       
    
     
     

     
     
     
}

        
    

    

