package org.example.sgabsadmin;

import org.example.sgabsadmin.entites.Produit;
import org.example.sgabsadmin.repositories.ProduitRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SgabsAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(SgabsAdminApplication.class, args);
    }

}
