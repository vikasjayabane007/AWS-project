package com.cognizant.processpension.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.processpension.model.PensionDetail;

@Repository
public interface ProcessPensionDao extends JpaRepository<PensionDetail,Long> {

}
