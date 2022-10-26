package net.yorksolutions.javastore;

public class Store {

    public String storeName;

    public String city;

    public Integer rating;

    public Boolean michelin;


    public Store(String storeName, String city, Integer rating){
        this.setStoreName(storeName);
        this.setCity(city);
        this.setRating(rating);
        this.setMichelin(rating);
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Boolean getMichelin() {
        return michelin;
    }

    public void setMichelin(Integer rating) {
        if(rating == 5) {
            this.michelin = true;
        }else{
            this.michelin = false;
        }
    }
}
