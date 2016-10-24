/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_pack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author ManhTri
 */
public class ProductList {
    private ArrayList<Product> productList_ar = new ArrayList();
    private LinkedList<Product> productList_ll = new LinkedList();
    
    public void addProduct(String[] data){
        System.out.println("Add data to ArrayList");
        addToAL(data);
        System.out.println("Add data to LinkedList");
        addToLL(data);
    }
    
    public void addToAL(String[] data){              
        System.out.println(data[0] + " ");
        System.out.println(data[1] + " ");
        System.out.println(data[2] + " ");
        System.out.println(data[3] + " ");
        System.out.println(data[4] + " ");
        System.out.println(data[5] + " ");    
        Product product = new Product(data[0], data[1], data[2], data[3], data[4], data[5]);
        getProductList_ar().add(product);
        System.out.println("Data added to ArrayList!");
    }
    
    public void addToLL(String[] data){
        System.out.println(data[0] + " ");
        System.out.println(data[1] + " ");
        System.out.println(data[2] + " ");
        System.out.println(data[3] + " ");
        System.out.println(data[4] + " ");
        System.out.println(data[5] + " ");
        Product product = new Product(data[0], data[1], data[2], data[3], data[4], data[5]);       
        getProductList_ll().add(product);
        System.out.println("Data added to LinkedList!");
    }
    
    public void getDetail(ArrayList<Product> productList){
        for (Product item : productList) {
            System.out.print("[Address: " + item );
            item.printProduct();
        }
    }
    
    public void getDetail(LinkedList<Product> prodList){        
        for(int i = 0; i < prodList.size(); i++){
            System.out.print("[Address: " + prodList.get(i));
            prodList.get(i).printProduct();
        }
    }
    
    public void sort(){
        
    }
    
    public Product search(String code){
        Product product = null;
        boolean found = false;
        for(int i = 0; i < getProductList_ll().size(); i++){
            if(getProductList_ll().get(i).getProdCode().equals(code)){
                found = true;
                product = getProductList_ll().get(i);
                break;
            }
        }
        if(found){
            return product;
        }
        else{
            return null;
        }
        
    }

   
    public ArrayList<Product> getProductList_ar() {
        return productList_ar;
    }

    /**
     * @param productList_ar the productList_ar to set
     */
    public void setProductList_ar(ArrayList<Product> productList_ar) {
        this.productList_ar = productList_ar;
    }

    /**
     * @return the productList_ll
     */
    public LinkedList<Product> getProductList_ll() {
        return productList_ll;
    }

    /**
     * @param productList_ll the productList_ll to set
     */
    public void setProductList_ll(LinkedList<Product> productList_ll) {
        this.productList_ll = productList_ll;
    }

   
}
