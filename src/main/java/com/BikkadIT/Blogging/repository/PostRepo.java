package com.BikkadIT.Blogging.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BikkadIT.Blogging.model.Catagory;
import com.BikkadIT.Blogging.model.Post;
import com.BikkadIT.Blogging.model.User;

public interface PostRepo extends JpaRepository<Post, Integer> {

	List<Post> findAllByUser(User user);
	List<Post> findByCatagory(Catagory catagory);

}
