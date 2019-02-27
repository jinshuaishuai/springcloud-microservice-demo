package com.jin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jin.entity.Book;
import com.jin.mapper.BookMapper;
import com.jin.service.BookService;
/**
 * 图书服务实现类
 * @author shuai.jin
 * @see		BookService
 * @since	2019-1-27 21:19
 *
 */

@Service
public class BookServiceImpl implements BookService {
	
	
	@Autowired
	private BookMapper bookMapper;
	
	@Transactional
	@Override
	public Integer addBook(Book book) {
		return bookMapper.addBook(book);

	}

	@Override
	public Book queryBookById(Long id) {
		
		return bookMapper.queryBookById(id);
	}

	@Override
	public List<Book> listAllBook() {
		
		return bookMapper.listAllBook();
	}

	@Transactional
	@Override
	public void updateBook(Book book) {
		bookMapper.updateBook(book);
	}

	@Override
	public void sayHello() {
		System.out.println("hello");
	}

}
