package com.BikkadIT.Blogging.services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIT.Blogging.exceptions.ResourceNotFoundException;
import com.BikkadIT.Blogging.model.Catagory;
import com.BikkadIT.Blogging.paylods.CatagoryDto;
import com.BikkadIT.Blogging.repository.CatagoryRepo;
import com.BikkadIT.Blogging.service.CatagoryServiceI;

@Service
public class CatagoryServiceImpl implements CatagoryServiceI {

	@Autowired
	private CatagoryRepo catagoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CatagoryDto createCatagory(CatagoryDto catgoryDto) {
		// TODO Auto-generated method stub
		Catagory cat = this.modelMapper.map(catgoryDto, Catagory.class);
		Catagory addedCat = this.catagoryRepo.save(cat);
		return this.modelMapper.map(addedCat, CatagoryDto.class);
	
	}

	@Override
	public CatagoryDto updateCatagory(CatagoryDto catagoryDto, Integer catagoryId) {
		// TODO Auto-generated method stub
		Catagory cat = this.catagoryRepo.findById(catagoryId)
				.orElseThrow(()-> new ResourceNotFoundException("Catagory","Catagory Id", catagoryId));
	
		cat.setCatagoryTital(catagoryDto.getCatagoryTital());
		cat.setCatagoryDesrecption(catagoryDto.getCatagoryDesrecption());		
		Catagory updatedcat = this.catagoryRepo.save(cat);
		
		return this.modelMapper.map(updatedcat, CatagoryDto.class);
	}

	@Override
	public void deleteCatagory(Integer catagoryId) {
		// TODO Auto-generated method stub
		
		Catagory cat = this.catagoryRepo.findById(catagoryId)
				.orElseThrow(()-> new ResourceNotFoundException("Catagory", "catagory", catagoryId));
				this.catagoryRepo.delete(cat);
		
	}

	@Override
	public CatagoryDto getCatagory(Integer catagoryId) {
		// TODO Auto-generated method stub
		
		Catagory cat = this.catagoryRepo.findById(catagoryId)
				.orElseThrow(()-> new ResourceNotFoundException("Catagory", "catagory", catagoryId));
		
		return this.modelMapper.map(cat, CatagoryDto.class);
	}

	@Override
	public List<CatagoryDto> getCatagories() {
		// TODO Auto-generated method stub
		List<Catagory> catagories = this.catagoryRepo.findAll();
		List<CatagoryDto> catDtos = catagories.stream()
				.map((cat)-> this.modelMapper.map(cat, CatagoryDto.class)).collect(Collectors.toList());
		
		return catDtos;
	}

	
}

