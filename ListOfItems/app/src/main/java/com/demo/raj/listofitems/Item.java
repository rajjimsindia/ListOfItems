package com.demo.raj.listofitems;

/**
 * Created by raj on 2/4/2016.
 */
public class Item {

    // title of the item
    private String title;

    // description of the item
    String desc;

    // image url of the item
    String url;

    // default constructor
    public Item(){}

    // Sets the Item object attributes
    public Item(String title, String description, String imgUrl){
        this.title = title;
        this.desc = description;
        this.url = imgUrl;
    }

    // Getters
    public String getTitle(){
        return this.title;
    }

    public String getDesc(){
        return this.desc;
    }

    public String getUrl(){
        return this.url;
    }
}
