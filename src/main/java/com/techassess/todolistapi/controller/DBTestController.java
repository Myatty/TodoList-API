package com.techassess.todolistapi.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DBTestController {

    private final JdbcTemplate jdbcTemplate;

    public DBTestController(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/db-test")
    public String test(){
        String result = jdbcTemplate.queryForObject("SELECT 'DB OK' AS message", String.class);
        return result;
    }
}
