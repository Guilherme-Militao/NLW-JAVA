package com.militao.certification_nlw.seed;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CreatSeed {

    private final JdbcTemplate jdbcTemplate;

    public CreatSeed(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public static void main(String[] args) {


        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5434/pg_nlw");
        dataSource.setUsername("admin   ");
        dataSource.setPassword("admin");


        CreatSeed creatSeed = new CreatSeed(dataSource);
        creatSeed.run(args);
    }

    public void run(String... args){

        excuteSqlfile("src/main/resources/static/create.sql");
    }
    public void excuteSqlfile(String filePath){

        try {
            String sqlScript = new String(Files.readAllBytes(Paths.get(filePath)));

            jdbcTemplate.execute(sqlScript);

            System.out.println("Script criado com sucesso!");
        }catch (IOException e){
            System.err.println("Erro ao ler arquivo: "+ e.getMessage());
        }

    }

}
