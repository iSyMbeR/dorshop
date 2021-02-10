package pl.dorshop.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.dorshop.shop.model.Product;
import pl.dorshop.shop.model.User;
import pl.dorshop.shop.model.UserType;
import pl.dorshop.shop.service.UserService;

import java.util.List;

@SpringBootApplication
public class ShopApplication {


    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class, args);
    }

}
