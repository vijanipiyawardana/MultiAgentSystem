/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vijani.model;

import java.util.Date;

/**
 *
 * @author vijani
 */
public class Order {
    private String orderNumber;
    private Date orderDate;
    private int quantity;
    private String juiceType;
    private String comment;

    public Order(String orderNumber, Date orderDate, int quantity, String juiceType) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.quantity = quantity;
        this.juiceType = juiceType;
    }
    public boolean isCleaned = false;
    public boolean isProcessed = false;
    public boolean isPacked = false;
    public boolean stockChecked = false;
    public boolean stockAvailable = false;

    @Override
    public String toString() {
        return "Order{" + "isCleaned=" + isCleaned + ", isProcessed=" + isProcessed + ", isPacked=" + isPacked + ", stockChecked=" + stockChecked + ", stockAvailable=" + stockAvailable + '}';
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    
    
    
    
}
