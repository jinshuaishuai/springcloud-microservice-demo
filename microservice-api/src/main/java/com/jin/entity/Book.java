package com.jin.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Book {
	
	private Long id;
	
	private String bookName;
	
	private String author;
	
	private String dbSource;
	
	
}
