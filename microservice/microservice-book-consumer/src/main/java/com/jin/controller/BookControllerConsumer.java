package com.jin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.jin.constant.UrlConstant;
import com.jin.entity.Book;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/consumer")
@Slf4j
public class BookControllerConsumer {
	
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping(value = "/listBooks", produces = "application/json")
	public List<Book> listAllBooks() {
		
		
		List<Book> books = restTemplate.getForObject(UrlConstant.URL_PREFIX + "/listBooks",List.class);
		log.info("调用listAllBooks接口,查询出的数据为:------->{}",books);
		return books;
	}
	
	@GetMapping(value = "/queryBookById/{id}")
	public Book getBookById(@PathVariable("id") String id) {
		log.info("getBookById方法入参为:------->{}",id);
		Book book = restTemplate.getForObject(UrlConstant.URL_PREFIX + "/queryBookById/" + id, Book.class);
		log.info("查询出的结果为:------------->{}",book);
		return book;
	}
}
