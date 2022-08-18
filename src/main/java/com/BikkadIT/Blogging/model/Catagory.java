package com.BikkadIT.Blogging.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "catagories")
@Data
@NoArgsConstructor
public class Catagory {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer catagoryId;
	
	@Column(name = "tital", length = 100, nullable= false)
	private String catagoryTital;
	
	@Column(name = "descreption")
	private String catagoryDesrecption;
	
	
	@OneToMany(mappedBy = "catagory", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Post> post = new ArrayList<>();
	
}
