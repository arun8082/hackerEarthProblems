package com.spring.batch.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.batch.dao.bean.CustomerBean;

//@Repository
public interface CustomerRepo extends JpaRepository<CustomerBean, Long> {

}
