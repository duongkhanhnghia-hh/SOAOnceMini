package com.uet.qpn.soaonce.model;

import java.io.Serializable;

public class Book implements Serializable {
    private String name;
    private int quantityInStock;
    private String author;
    private String code;


    public Book(){

    }
    public Book(String name, int quantityInStock, String author, String code) {
        this.name = name;
        this.quantityInStock = quantityInStock;
        this.author = author;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
