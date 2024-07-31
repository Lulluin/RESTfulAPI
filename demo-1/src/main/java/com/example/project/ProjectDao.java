package com.example.project;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProjectDao {

	void insertMPay(PortVO vo);
	
	PortVO selectPayment(String mpaynum);
	
	PortVO selectGym(int mpaynum);
	
}
