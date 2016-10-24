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
public class Product implements Serializable{
    private String prodCode;
    private String prodName;   
    private String prodCat;
    private String numInStock;
    private String price;
    private String sold;
    
    
    
    public Product(String new_prodCode,String new_prodName, String new_prodCat, String new_numInStock, String new_price, String sold){       
        prodCode = new_prodCode;
        prodName = new_prodName;
        prodCat = new_prodCat;
        numInStock = new_numInStock;
        price = new_price;
        this.sold = sold;
    }
    
    public Product(){
        this("", "", "","", "","");
    }
    /**
     * @return the prodName
     */
    public String getProdName() {
        return prodName;
    }

    /**
     * @param prodName the prodName to set
     */
    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    /**
     * @return the prodCode
     */
    public String getProdCode() {
        return prodCode;
    }

    /**
     * @param prodCode the prodCode to set
     */
    public void setProdCode(String prodCode) {
        this.prodCode = prodCode;
    }

    /**
     * @return the prodCat
     */
    public String getProdCat() {
        return prodCat;
    }

    /**
     * @param prodCat the prodCat to set
     */
    public void setProdCat(String prodCat) {
        this.prodCat = prodCat;
    }

    /**
     * @return the numInStock
     */
    public String getNumInStock() {
        return numInStock;
    }

    /**
     * @param numInStock the numInStock to set
     */
    public void setNumInStock(String numInStock) {
        this.numInStock = numInStock;
    }

    /**
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(String price) {
        this.price = price;
    }
    
    public void updateProductInfo(String prodName, String prodCate, String price, String numInStock){
        setProdName(prodName);
        setProdCat(prodCate);
        setPrice(price);
        setNumInStock(numInStock);
    }
    
    public void printProduct() {
        System.out.print("Data: Product Code: " + getProdCode());
        System.out.print("/Product Name: " + getProdName());
        System.out.print("/Product Category: " + getProdCat());
        System.out.print("/Number In Stock: " + getNumInStock());
        System.out.print("/Price: " + getPrice() + "]");
        System.out.println("/Sold: " + getSold() + "]");
        System.out.println("************************************************");
    }

   

    /**
     * @return the sold
     */
    public String getSold() {
        return sold;
    }

    /**
     * @param sold the sold to set
     */
    public void setSold(String sold) {
        this.sold = sold;
    }
    
    
}
