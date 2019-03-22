package com.example.demo.controller;

import ch.qos.logback.classic.Logger;
import com.example.demo.data.TestRepository;
import com.example.demo.data.entity.User;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping(value = "/getUserList")
    public List<User> getUserList() {
        return testRepository.findAll();
    }

    @GetMapping(value = "/addUser")
    public User addUser(@RequestParam("age") String age, @RequestParam("name") String name) {
        User user = new User();
        user.setAge(age);
        user.setName(name);

        return testRepository.save(user);
    }


    @GetMapping(value = "/findUser/{id}")
    public User findUser(@PathVariable("id") Integer id) {
        String sql = "select * from user where id = ?";
        RowMapper<User> rowMapper=new BeanPropertyRowMapper<User>(User.class);
        return jdbcTemplate.queryForObject(sql, rowMapper,id);

//        return testRepository.findById(id).get();
    }

    @GetMapping(value = "/findUserByAge")
    public List<User> findByAge(@RequestParam("age") String age) {
        return testRepository.findByAge(age);
    }

    @GetMapping(value = "/updateUser/{id}")
    public void updateUser(@PathVariable("id") Integer id, @RequestParam("name") String name) {
        testRepository.updateNameById(id, name);
    }

    @GetMapping(value = "/delUser/{id}")
    public void delUser(@PathVariable("id") Integer id) {
        testRepository.deleteById(id);
    }
}
