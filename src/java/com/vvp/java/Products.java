/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vvp.java;

import java.util.HashMap;

/**
 *
 * @author ehs
 */
public class Products {
    int pid,stock;
    double price;
    String ProductName, description, images;
    static HashMap<Integer,Products> products = new HashMap<Integer, Products>();

    public static void initData(){
        Products p1 = new Products(1,5,800.00,"Bag");
        Products p2 = new Products(2,5,400.00,"JSP Complete Reference");
        Products p3 = new Products(3,5,5.00,"Cello Pen");
        products.put(new Integer(1), p1);
        products.put(new Integer(2), p2);
        products.put(new Integer(3), p3);
    }
    public Products(int pid, int stock, double price, String ProductName) {
        this.pid = pid;
        this.stock = stock;
        this.price = price;
        this.ProductName = ProductName;
    }

    public String getProductName() {
        return ProductName;
    }

    public Products(int pid) {
        this.pid = pid;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    

}
