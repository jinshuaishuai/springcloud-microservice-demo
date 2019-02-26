package com.jin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import com.jin.entity.Book;
import com.jin.service.BookService;

/**
 * 图书Controller
 * @author shuai.jin
 * @since	2019-1-27 21:22
 *
 */
@Slf4j
@RestController
@RequestMapping("/book")
public class BookController {
	
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/queryBookById/{id}")
	public Book queryBookById(@PathVariable("id") Long id) {
		log.info("入参为:-------------->{}",id);
		Book book = bookService.queryBookById(id);
		
		return book;
		
	}
}
