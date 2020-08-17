package com.ddd.justeatit.domain.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface UsersRepository extends JpaRepository<Users, Long> {
    @Query("select u from Users u order by u.id desc")
    Stream<Users> findAllDesc();
}