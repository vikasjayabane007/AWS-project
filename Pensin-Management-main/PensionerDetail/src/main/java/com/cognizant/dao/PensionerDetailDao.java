package com.cognizant.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.model.PensionerDetail;

@Repository
public interface PensionerDetailDao extends JpaRepository<PensionerDetail,Long> {

}
