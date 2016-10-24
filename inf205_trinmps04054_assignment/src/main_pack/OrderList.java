/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_pack;

import java.util.LinkedList;

/**
 *
 * @author manhtri
 */
public class OrderList {
    private LinkedList<Order> oList = new LinkedList();
    //ProductList prodList = new ProductList();
    //CustomerList cusList = new CustomerList();
    
    public void addOrder(String[] data, ProductList prodList,CustomerList cusList ){
        //data[1] is Porduct Code
        Product product = prodList.search(data[1]);
        //data[2] is Customer code
        Customer customer = cusList.search(data[2]);
        if(product != null && customer != null){
            //data[0] order code
            //data[3] quantity
            //calculate total
            Double o_total = (Double.parseDouble(product.getPrice())*Double.parseDouble(data[3]));
            
            prodList.getProductList_ll().add(product);
            String total = o_total.toString();
            //data[4] total
            Order order = new Order(product, customer, data[0], data[3], total);
            oList.add(order);
            
            //remove product from product list
            prodList.getProductList_ll().remove(product);
            
            //Update number of product in stock
            Integer numInStock_int = Integer.parseInt(product.getNumInStock()) - Integer.parseInt(order.getQuantity());
            product.setNumInStock(numInStock_int.toString());
            
            
        }else if(product == null && customer != null){
            System.out.println("Invalid Product Code");
        }else if(product != null && customer == null){
            System.out.println("Invalid Customer Code");
        }else{
            System.out.println("No valid customer and product code!");
        }
        
        cusList.search(data[2]);
        
    }
    
    public void updateNumInStock(){
        
    }
    
    
    
    public void getDetail(LinkedList<Order> ll_o){
       for(int i = 0; i < oList.size(); i++){
            System.out.print("[Address: " + oList.get(i));
            oList.get(i).printOrder();
        } 
    }
    
    
    
    
    /**
     * @return the ll_o
     */
    public LinkedList<Order> getOList() {
        return oList;
    }

    /**
     * @param ll_o the ll_o to set
     */
    public void setOList(LinkedList<Order> ll_o) {
        this.oList = ll_o;
    }
}
