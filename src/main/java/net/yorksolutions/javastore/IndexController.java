package net.yorksolutions.javastore;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class IndexController {
    ProductService productService;
//    StoreService storeService;

    public IndexController(ProductService productService){
        this.productService = productService;
    }
//    public IndexController(StoreService storeService){
//        this.storeService = storeService;
//    }

    // HTTP Request:
    //   method: GET
    //   url: http://localhost:8081/api/hello
    //   headers?
    //   body?

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/get")
    public Iterable<Product> getProducts(){
        return this.productService.get();
    }
    @GetMapping("/over/{price}")
    public Iterable<Product> getProductsOver(@PathVariable Double price){
        return this.productService.over(price);
    }
    @GetMapping("/under/{price}")
    public Iterable<Product> getProductsUnder(@PathVariable Double price){
        return this.productService.under(price);
    }

    @GetMapping("/average")
    public Double getAveragePrice(){
        return this.productService.average();
    }
    @GetMapping("/median")
    public Double getMedianPrice(){
        return this.productService.median();
    }

    // HTTP Request:
    //   method: POST
    //   url: http://localhost:8081/api/hello
    @PostMapping("/add")
    public void saveProduct(@RequestBody Product p){
        productService.add(p);
    }

//    @PostMapping("/add")
//    public void saveStore(@RequestBody Store p){
//        storeService.add(p);
//    }
//    @GetMapping("/get")
//    public Iterable<Store> getProducts(){
//        return this.storeService.get();
//    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable UUID id){
        productService.remove(id);
    }

    @PutMapping("/update/{id}")
    public void updateProduct(@PathVariable UUID id, @RequestBody Product p){
        productService.update(id,p);
    }




}
