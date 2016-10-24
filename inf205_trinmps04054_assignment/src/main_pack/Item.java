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
public class Item {
    private Product product;
    //public Customer customer;
    //public Order order;
    private Item link;
    
    public Item(){
        
    }
    
    public Item(Product newProduct, Item newLink){
        product = newProduct;
        link = newLink;
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
     * @return the link
     */
    public Item getLink() {
        return link;
    }

    /**
     * @param link the link to set
     */
    public void setLink(Item link) {
        this.link = link;
    }
    
    
    
}
