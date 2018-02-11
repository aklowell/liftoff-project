package com.example.southside.models.data;

import com.example.southside.models.Activity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ActivityDao extends CrudRepository<Activity, Integer> {

    List<Activity> findByEAges(String eAges);

    List<Activity> findByESubject(String eSubject);

    List<Activity> findByEWhere(String eWhere);

}
