package com.example.springmysql;

import com.example.springmysql.dao.TicketRepository;
import com.example.springmysql.model.Ticket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication

public class SpringMysqlApplication {
  //  private static final Logger logger = LoggerFactory.getLogger(SpringMysqlApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(SpringMysqlApplication.class, args);
    }

}
