package com.BikkadIT.Blogging.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.Blogging.model.Post;
import com.BikkadIT.Blogging.paylods.PostDto;
import com.BikkadIT.Blogging.service.PostServiceI;

@RestController
@RequestMapping("/api/")
public class PostController {
	
	@Autowired
	private PostServiceI postservice;
	
	//create
	
	@PostMapping("/user/{userId}/catagory/{catagoryId}/posts")
	public ResponseEntity<PostDto> createPost(
			@RequestBody PostDto postDto,
			@PathVariable Integer userId,
			@PathVariable Integer catagoryId){
		
		PostDto createPost = this.postservice.createPost (postDto, userId, catagoryId);
		return new ResponseEntity<PostDto>(createPost,HttpStatus.CREATED);
		
		
	}

}
