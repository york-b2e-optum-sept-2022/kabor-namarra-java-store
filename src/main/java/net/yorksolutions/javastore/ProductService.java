package net.yorksolutions.javastore;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {
    ArrayList<Product> storeMenu;

    ArrayList<Product> filteredStore;

    public ProductService(){
        this.storeMenu = new ArrayList<>();
    }

    public ArrayList<Product> get(){
        return this.storeMenu;
    }

    public void add(Product p){
        this.storeMenu.add(p);
    }

    public void remove(UUID product_id){
        this.storeMenu = new ArrayList<>(this.storeMenu.stream().filter(p -> {
            return  !(p.id.equals(product_id));
        }).collect(Collectors.toList()));
    }

    public void update(UUID product_id, Product newProduct){
        newProduct.id = product_id;
        this.storeMenu = new ArrayList<>(this.storeMenu.stream().filter(p -> {
            return  !(p.id.equals(product_id));
        }).collect(Collectors.toList()));
        this.storeMenu.add(newProduct);
    }

    public ArrayList<Product> over(Double price) {
        this.filteredStore = new ArrayList<>(this.storeMenu.stream().filter(p -> {
            return p.getPrice() > price;
        }).collect(Collectors.toList()));
        return this.filteredStore;
    }

    public ArrayList<Product> under(Double price){
        this.filteredStore = new ArrayList<>(this.storeMenu.stream().filter(p -> {
            return p.getPrice() <= price;
        }).collect(Collectors.toList()));
        return this.filteredStore;
    }


    public Double average(){
        double totalPrice = 0.0;
        for(Product p: this.storeMenu){
            totalPrice += p.getPrice();
        }

        return totalPrice/this.storeMenu.size();
    }

    public Double median(){

        int s = this.storeMenu.size();
        Double[] prices = new Double[s];

        int i =0;
        for(Product p: this.storeMenu){
            prices[i] = p.getPrice();
            i++;
        }

        Arrays.sort(prices);

        if (s % 2 != 0)
            return (double)prices[s / 2];

        return (double)(prices[(s - 1) / 2] + prices[s / 2]) / 2.0;
    }
}
