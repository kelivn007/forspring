package com.example.demo.data;

import com.example.demo.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface TestRepository extends JpaRepository<User, Integer> {

    @Modifying
    @Query(value = "update user set name = :name where id = :id", nativeQuery = true)
    void updateNameById(@Param("id") Integer id, @Param("name") String name);

    List<User> findByAge(String age);
}
