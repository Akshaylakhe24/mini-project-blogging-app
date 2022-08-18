package com.BikkadIT.Blogging.services.Impl;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIT.Blogging.exceptions.ResourceNotFoundException;
import com.BikkadIT.Blogging.model.Catagory;
import com.BikkadIT.Blogging.model.Post;
import com.BikkadIT.Blogging.model.User;
import com.BikkadIT.Blogging.paylods.PostDto;
import com.BikkadIT.Blogging.repository.CatagoryRepo;
import com.BikkadIT.Blogging.repository.PostRepo;
import com.BikkadIT.Blogging.repository.UserRepo;
import com.BikkadIT.Blogging.service.PostServiceI;

@Service
public class PostServiceImpl implements PostServiceI {

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CatagoryRepo catagoryRepo;
	
	
	
	@Override
	public PostDto createPost(PostDto postDto,Integer userId, Integer catagoryId) {
		// TODO Auto-generated method stub
		
		
		
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "User id", userId));
		
		Catagory catagory = this.catagoryRepo.findById(catagoryId)
				.orElseThrow(()-> new ResourceNotFoundException("Catagory", "catagory id", catagoryId));
		
		Post post = this.modelMapper.map(postDto, Post.class);
		post.setImageName("default.png");
		post.setAddDate(new Date());
		post.setUser(user);
		post.setCatagory(catagory);
		
		Post newPost = this.postRepo.save(post);
		
		return this.modelMapper.map(newPost,PostDto.class);
	}

	@Override
	public Post updatePost(PostDto postDto, Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePost(Integer postId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Post> getAllPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post getPostbyId(Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getPostByCatagory(Integer catagoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getPostByUser(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> SearchPosts(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
