/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_pack;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author ManhTri
 */
public class FileHandler<T> {
    
   public void writeToFile(String path, ArrayList<T> arl) throws IOException{
        
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(path), true));
        try {
            for (T item : arl) {
                oos.writeObject(item);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            
            oos.close();
        }
        System.out.println("Data write!");
        

    }
    
    public ArrayList<T> readFromFile(String path ) throws FileNotFoundException, IOException, ClassNotFoundException{
         ArrayList<T> obList= new ArrayList();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(path)));
        try {
            while (true) {
                obList.add((T)ois.readObject());
            }
        } catch (EOFException e) {
            
        } finally {
            ois.close();
        }
        return obList;
        
    }
    
    public void writeToFile(String path, LinkedList<T> ssl) throws IOException{
        
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(path), true));
        try {
            for(int i = 0; i < ssl.size(); i++){
                oos.writeObject(ssl.get(i));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            
            oos.close();
        }
        System.out.println("Data write!");
        

    }
    
    public LinkedList<T> readFromFile_LL(String path  ) throws FileNotFoundException, IOException, ClassNotFoundException{
         LinkedList<T> obList = new LinkedList();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(path)));
        try {
            while (true) {
                obList.add((T)ois.readObject());
            }
        } catch (EOFException e) {
            
        } finally {
            ois.close();
        }
        return obList;
        
    }
    
}
