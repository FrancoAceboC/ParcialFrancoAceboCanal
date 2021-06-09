package ar.edu.utn.parcial.futbolmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FutbolManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FutbolManagerApplication.class, args);
    }

}
