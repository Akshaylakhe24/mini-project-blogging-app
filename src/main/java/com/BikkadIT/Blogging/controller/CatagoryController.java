package com.BikkadIT.Blogging.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.Blogging.paylods.ApiResponse;
import com.BikkadIT.Blogging.paylods.CatagoryDto;
import com.BikkadIT.Blogging.service.CatagoryServiceI;

@RestController
@RequestMapping("/api/catagories")
public class CatagoryController {
	
	@Autowired
	private CatagoryServiceI catagoryServiceI;
	
	//create
	
	@PostMapping("/")
	public ResponseEntity<CatagoryDto>createCatagory(@Valid @RequestBody CatagoryDto catagoryDto){
		
		CatagoryDto createCatagory = this.catagoryServiceI.createCatagory(catagoryDto);
		return new ResponseEntity<CatagoryDto>(createCatagory,HttpStatus.CREATED);
		
	}
	
	// update
	
	@PutMapping("/{catId}")
	public ResponseEntity<CatagoryDto>updateCatagory(@Valid @RequestBody CatagoryDto catagoryDto, 
			@PathVariable Integer catId){
		
		CatagoryDto updatedCatagory = this.catagoryServiceI.updateCatagory(catagoryDto,catId);
		return new ResponseEntity<CatagoryDto>(updatedCatagory,HttpStatus.OK);
	
	}
	
	//delete
	
	@DeleteMapping("/{catId}")
	public ResponseEntity<ApiResponse>deleteCatagory(@PathVariable Integer catId){
		
		this.catagoryServiceI.deleteCatagory(catId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("catagory is deleted successfully",  true),HttpStatus.OK);
	
	}
	
	//get 
	
	@GetMapping("/{catId}")
	public ResponseEntity<CatagoryDto>getCatagory(@PathVariable Integer catId){
		CatagoryDto catagoryDto = this.catagoryServiceI.getCatagory(catId);
		
		return new ResponseEntity<CatagoryDto>(catagoryDto,HttpStatus.OK);
	
	}
	
	//getAll
	
	@GetMapping("/")
	public ResponseEntity<List<CatagoryDto>> getcatagories(){
		List<CatagoryDto>catagories = this.catagoryServiceI.getCatagories();
		return ResponseEntity.ok(catagories);
	}
	
}