package com.jin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jin.entity.Book;
import com.jin.service.BookService;

import lombok.extern.slf4j.Slf4j;

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
	@PostMapping("/addBook")
	public Integer addBook(@RequestBody Book book) {
		
		log.info("addBook方法请求入参为:--------->{}",book);
		return bookService.addBook(book);
	}
	@GetMapping("/listBooks")
	public List<Book> listBooks() {
		List<Book> listAllBook = bookService.listAllBook();
		log.info("查询出的所有图书信息为:-------------->{}",listAllBook);
		return listAllBook;
	}
}
