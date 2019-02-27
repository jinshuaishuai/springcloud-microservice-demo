package com.jin.service;

import java.util.List;

import com.jin.entity.Book;


public interface BookService {
	/**
	 * 添加一本图书
	 * @param book
	 * @return 
	 */
	public Integer addBook(Book book);
	/**
	 * 根据id查询一本图书
	 * @param id
	 * @return
	 */
	public Book queryBookById(Long id);
	
	/**
	 * 查询说有的图书
	 * @return
	 */
	public List<Book> listAllBook();
	
	/**
	 * 修改图书信息
	 * @param book
	 */
	public void updateBook(Book book);
	
	public void sayHello();
}
