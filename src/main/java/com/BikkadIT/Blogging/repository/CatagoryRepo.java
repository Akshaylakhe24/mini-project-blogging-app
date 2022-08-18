package com.BikkadIT.Blogging.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BikkadIT.Blogging.model.Catagory;

public interface CatagoryRepo extends JpaRepository<Catagory, Integer> {

}
