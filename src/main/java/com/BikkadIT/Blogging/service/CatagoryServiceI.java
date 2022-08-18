package com.BikkadIT.Blogging.service;

import java.util.List;

import com.BikkadIT.Blogging.paylods.CatagoryDto;

public interface CatagoryServiceI {


	//create
	
	CatagoryDto createCatagory (CatagoryDto catgoryDto);
	
	//update
	
	CatagoryDto updateCatagory(CatagoryDto catagoryDto, Integer catagoryId);
	
	//delete
	
	void deleteCatagory(Integer catagoryId);
	
	//get
	
	CatagoryDto getCatagory(Integer catagoryId);
	
	//get All
	
	List<CatagoryDto> getCatagories();
	

	
}
