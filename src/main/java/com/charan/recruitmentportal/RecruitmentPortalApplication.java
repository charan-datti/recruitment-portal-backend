package com.charan.recruitmentportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.hibernate.autoconfigure.HibernateJpaAutoConfiguration;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication(
        exclude = {
                DataSourceAutoConfiguration.class,
                HibernateJpaAutoConfiguration.class
        }
)

public class RecruitmentPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecruitmentPortalApplication.class, args);
    }
}
