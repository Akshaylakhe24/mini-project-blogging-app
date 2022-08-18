package com.BikkadIT.Blogging.paylods;

import java.util.Date;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostDto {
	
	private String tital;
	
	private String content;
	
	private String imageName;
	
	private Date addedDate;
	
	
	private CatagoryDto category;
	
	private UserDto user;
	


}
