package com.example.southside.models.data;


import com.example.southside.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;



@Repository
@Transactional
public interface UserDao extends CrudRepository<User, Integer> {
}
