package com.naveenkc.restaurant;

public class RestaurantList {
    private String name;
    private String phone;
    private String web;
    private  String hours;
    private String price;
    private String price_range;
    private String restId;
    private  String cuisines;
    private String address;
    private String state;
    private String postal;
    private  String street;
    private String geo;
    private String menu;







    public RestaurantList(String name,String phone,String web,String price,String price_range,String restId,String cuisines,String address,
                          String state,String postal,String street,String geo,String menu){
        this.name = name;
        this.phone = phone;
        this.web = web;
        this.price=price;
        this.price_range = price_range;
        this.restId = restId;
        this.cuisines = cuisines;
        this.address=address;
        this.state = state;
        this.postal = postal;
        this.street = street;
        this.geo=geo;
        this.menu = menu;




    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice_range() {
        return price_range;
    }

    public void setPrice_range(String price_range) {
        this.price_range = price_range;
    }

    public String getRestId() {
        return restId;
    }

    public void setRestId(String restId) {
        this.restId = restId;
    }

    public String getCuisines() {
        return cuisines;
    }

    public void setCuisines(String cuisines) {
        this.cuisines = cuisines;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getGeo() {
        return geo;
    }

    public void setGeo(String geo) {
        this.geo = geo;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }
}

