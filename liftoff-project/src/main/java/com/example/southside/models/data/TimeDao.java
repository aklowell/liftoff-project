package com.example.southside.models.data;

import com.example.southside.models.Time;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface TimeDao extends CrudRepository<Time, Integer> {
}
