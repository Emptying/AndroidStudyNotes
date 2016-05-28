package com.empty.listview;

/**
 * Created by Emptying on 2016/5/27.
 */
public class Books {
    private String BookName;
    private String Author;
    private double Price;
    public Books(String BookName,String Author,Double Price){
        this.BookName = BookName;
        this.Author = Author;
        this.Price = Price;
    }

    public Books(){

    }

    public void setBookName(String BookName){
        this.BookName = BookName;
    }
    public void setAuthor(String Author){
        this.Author = Author;
    }
    public void setPrice(double Price){
        this.Price = Price;
    }

    public String getBookName(){
        return BookName;
    }
    public String getAuthor(){
        return Author;
    }
    public double getPrice(){
        return Price;
    }

}
