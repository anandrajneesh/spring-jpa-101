package com.gluecoders.databasesqlexample.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
        //"com.gluecoders.databasesqlexample.basics"
        //,"com.gluecoders.databasesqlexample.customids"
        //,"com.gluecoders.databasesqlexample.onetomany"
        //,"com.gluecoders.databasesqlexample.onetoone"
        //,
         "com.gluecoders.databasesqlexample.manytomany"
})
@EnableJpaRepositories(basePackages = {
        //"com.gluecoders.databasesqlexample.basics"
        //,"com.gluecoders.databasesqlexample.customids"
        //,"com.gluecoders.databasesqlexample.onetomany"
        //,"com.gluecoders.databasesqlexample.onetoone"
        //,
         "com.gluecoders.databasesqlexample.manytomany"
})
@EntityScan(basePackages = {
        //"com.gluecoders.databasesqlexample.basics"
        //,"com.gluecoders.databasesqlexample.customids"
        //,"com.gluecoders.databasesqlexample.onetomany"
        //,"com.gluecoders.databasesqlexample.onetoone"
        //,
        "com.gluecoders.databasesqlexample.manytomany"
})
public class DatabaseSqlExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatabaseSqlExampleApplication.class, args);
    }

}
