/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_pack;

import java.io.Serializable;

/**
 *
 * @author ManhTri
 */
public class Order implements Serializable{
    private Customer customer;
    private Product product;
    private String o_code;
    private String quantity;
    private String total;
    private String c_code;
    private String p_code;
    
    public Order(Product orderProduct, Customer orderCustomer, String orderCode,  String orderQuantity, String orderTotal){
        o_code = orderCode;
        product = orderProduct;
        customer = orderCustomer;
        quantity = orderQuantity;
        total = orderTotal;
    }
    /**
     * @return the o_code
     */
    public String getO_code() {
        return o_code;
    }

    /**
     * @param o_code the o_code to set
     */
    public void setO_code(String o_code) {
        this.o_code = o_code;
    }

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * @return the quantity
     */
    public String getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the total
     */
    public String getTotal() {
                
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(String total) {
        this.total = total;
    }
    
    public void printOrder(){
        System.out.print("Data: Order Code: " + getO_code());
        System.out.print("/Product Code: " + getProduct().getProdCode());
        System.out.print("/Customer Code: " + getCustomer().getCcode());
        System.out.print("/Quantity: " + getQuantity());
        System.out.print("/Price: " + getProduct().getPrice() );
        System.out.println("/Sold: " + getQuantity() + "]");
        System.out.println("************************************************");
    }
    
    
}
