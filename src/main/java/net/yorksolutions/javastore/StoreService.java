package net.yorksolutions.javastore;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StoreService {

    ArrayList<Store> storeInCity;

    public StoreService(){
        this.storeInCity = new ArrayList<>();
    }

    public void add(Store p){
        this.storeInCity.add(p);
    }

    public ArrayList<Store> get(){
        return this.storeInCity;
    }
}
