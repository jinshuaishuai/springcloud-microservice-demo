package com.jin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jin.entity.Book;

/**
 * 图书Mapper
 * @author shuai.jin
 * @since	2019-1-27 21:10
 *
 */
@Mapper
public interface BookMapper {
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
	
	
	
	
}
