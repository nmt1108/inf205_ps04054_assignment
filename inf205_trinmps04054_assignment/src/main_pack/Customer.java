/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_pack;

/**
 *
 * @author ManhTri
 */
public class Customer {
    private String ccode;
    private String cname;    
    private String cphone;
    
    public Customer(String newCcode,String newName, String newPhone){       
        ccode = newCcode;
        cname = newName;
        cphone = newPhone;
    }
    
    public Customer(){
        this("", "", "");
    }
    
    
    public void printCustomer() {
        System.out.print(" Data: Customer Code: " + getCcode());
        System.out.print("/Customer Name: " + getCname());
        System.out.print("/Customer Phone: " + getCphone());        
        System.out.println("************************************************");
    }

    /**
     * @return the ccode
     */
    public String getCcode() {
        return ccode;
    }

    /**
     * @param ccode the ccode to set
     */
    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    /**
     * @return the cname
     */
    public String getCname() {
        return cname;
    }

    /**
     * @param cname the cname to set
     */
    public void setCname(String cname) {
        this.cname = cname;
    }

    /**
     * @return the cphone
     */
    public String getCphone() {
        return cphone;
    }

    /**
     * @param cphone the cphone to set
     */
    public void setCphone(String cphone) {
        this.cphone = cphone;
    }

    
    
}
