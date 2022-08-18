package com.BikkadIT.Blogging.service;

import java.util.List;

import com.BikkadIT.Blogging.model.Post;
import com.BikkadIT.Blogging.paylods.PostDto;

public interface PostServiceI {
	
	//create
	
	PostDto createPost(PostDto postDto,Integer useId, Integer catagoryId);
	
	//update
	
	Post updatePost(PostDto postDto, Integer postId);

	//delete
	
	void deletePost(Integer postId);
	
	//get all post
	
	List<Post> getAllPost();
	
	//get single post
	
	Post getPostbyId(Integer postId);
	
	//get all post by category
	
	List<Post> getPostByCatagory(Integer catagoryId);
	
	//get post by user
	
	List<Post> getPostByUser(Integer userId);
	
	//Search post
	
	List<Post>SearchPosts (String keyword);
	
	
}
