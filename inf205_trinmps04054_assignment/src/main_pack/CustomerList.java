/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_pack;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author manhtri
 */
public class CustomerList {
    private LinkedList<Customer> cus_ll = new LinkedList();
    private ArrayList<Customer> cus_al = new ArrayList();

    public void addCustomer(String[] data){
        addToAL_Cus(data);
        addToLL_Cus(data);
    }
    
    public void addToAL_Cus(String[] data){
        System.out.println(data[0] + " ");
        System.out.println(data[1] + " ");
        System.out.println(data[2] + " ");       
        Customer customer = new Customer(data[0], data[1], data[2]);
        getCus_al().add(customer);
        System.out.println("Customer Data added to ArrayList!");
    }
    
    
     public void addToLL_Cus(String[] data){
        System.out.println(data[0] + " ");
        System.out.println(data[1] + " ");
        System.out.println(data[2] + " ");       
        Customer customer = new Customer(data[0], data[1], data[2]);
        getCus_ll().add(customer);
        System.out.println("Customer Data added to LinkedList!");
    }
    
    public void getCusListDetail(ArrayList<Customer> cus_al){
        System.out.println("Print Customer ArrayList details.");
        for (Customer each : cus_al) {
            System.out.print("[Address: " + each );
            each.printCustomer();
        }
    }
    
     public void getCusListDetail(LinkedList<Customer> cus_ll){
         System.out.println("Print Customer Linked List details.");
        for (Customer each : cus_ll) {
            System.out.print("[Address: " + each );
            each.printCustomer();
        }
    }

    /**
     * @return the cus_ll
     */
    public LinkedList<Customer> getCus_ll() {
        return cus_ll;
    }

    /**
     * @param cus_ll the cus_ll to set
     */
    public void setCus_ll(LinkedList<Customer> cus_ll) {
        this.cus_ll = cus_ll;
    }

    /**
     * @return the cus_al
     */
    public ArrayList<Customer> getCus_al() {
        return cus_al;
    }

    /**
     * @param cus_al the cus_al to set
     */
    public void setCus_al(ArrayList<Customer> cus_al) {
        this.cus_al = cus_al;
    }
    
    public Customer search(String code){
        Customer customer = new Customer();
        boolean found = false;
        for(int i = 0; i < getCus_ll().size(); i++){
            if(getCus_ll().get(i).getCcode().equals(code)){
                found = true;
                customer = getCus_ll().get(i);
                break;
            }
        }
        if(found){
            return customer;
        }
        else{
            return null;
        }
    }

   
    
    
}
