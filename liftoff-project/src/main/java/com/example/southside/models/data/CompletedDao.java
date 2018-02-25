package com.example.southside.models.data;

import com.example.southside.models.Completed;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface CompletedDao extends CrudRepository<Completed, Integer> {
}
