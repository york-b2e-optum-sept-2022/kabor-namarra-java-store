package net.yorksolutions.javastore;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.UUID;

public class Product {
//    Integer id;
//    String productName;
//    String displayName;
//    Float price;


    public UUID id;
    @JsonProperty
    public String product_name;
    @JsonProperty
    public Double price;
    @JsonProperty
    public Double sale;

    public Boolean onSale;

    public Product(String product_name, Double price, Double sale) {
        this.id = UUID.randomUUID();
        this.setProduct_name(product_name);
        this.setPrice(price,sale);
        this.setSale(sale);
        this.setOnSale(sale);
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name.toLowerCase().replace(" ","");

    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price, Double sale) {
        if(price > 0){
            this.price = price - (price * (sale/100));
        }else {
            this.price = 0D;
        }
    }

    public Double getSale() {
        return sale;
    }

    public void setSale(Double sale) {
        this.sale = sale;
    }

    public Boolean getOnSale() {
        return onSale;
    }

    public void setOnSale(Double sale) {
        if(sale > 0D){
            this.onSale = true;
        }else{
            this.onSale = false;
        }

    }

    //    @Override
//    public String toString() {
//        return "Product{" +
//                "id=" + id +
//                ", product_name='" + product_name + '\'' +
//                ", price=" + price +
//                ", sale=" + sale +
//                ", onSale=" + onSale +
//                '}';
//    }

}
