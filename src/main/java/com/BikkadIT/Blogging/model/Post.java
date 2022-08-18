package com.BikkadIT.Blogging.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "posts")
@Data
@NoArgsConstructor
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer postId;
	
	@Column(name= "post_tital", length = 100, nullable= false)
	private String tital;
	
	@Column(length = 1000)
	private String content;
	
	private String imageName;
	
	private Date addDate;
	
	@ManyToOne
	@JoinColumn(name = "catagory_id")
	private Catagory catagory;
	
	@ManyToOne
	private User user;
	
	
}
