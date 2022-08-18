package com.BikkadIT.Blogging.paylods;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CatagoryDto {
	
	private Integer  catagoryId;
	
	@NotBlank
	@Size(min = 4, message = "min size is 4")
	private String catagoryTital;
	
	@NotBlank
	@Size(min = 10, message = "min size is 10")
	private String catagoryDesrecption;

	
}
