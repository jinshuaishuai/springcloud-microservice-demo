package com.jin.constant;
/**
 * 用于封装前端页面的分页参数
 * @author shuai.jin
 * @datetime 2019年2月27日 上午00:38:11
 *
 */
public class Pagination {
	private static final Integer DEFAULT_PAGE_SIZE = 10;

    private static final Integer DEFAULT_CURRENT = 1;

    private Integer current = DEFAULT_CURRENT;

    private Integer pageSize = DEFAULT_PAGE_SIZE;

    private Long total;
}
