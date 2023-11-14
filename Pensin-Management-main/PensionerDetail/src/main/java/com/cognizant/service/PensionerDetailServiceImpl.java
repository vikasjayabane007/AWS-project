package com.cognizant.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.dao.PensionerDetailDao;

import com.cognizant.model.PensionerDetail;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PensionerDetailServiceImpl implements PensionerDetailService{
	@Autowired
	private PensionerDetailDao dao;
	
	@Transactional
	@Override
	
	public PensionerDetail getById(long aadharnumber)   {
		log.info("getById method called");
		Optional<PensionerDetail> pensiondetail = dao.findById( aadharnumber);
		return pensiondetail.orElse(null);
	}

}
