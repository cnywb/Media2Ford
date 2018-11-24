package com.agenda.common;

import java.util.List;

@SuppressWarnings("serial")
public class Pagination extends SimplePage implements java.io.Serializable{
	
	/**
	 * 当前页的数据
	 */
	@SuppressWarnings("unchecked")
	private List list = null;
	
	public Pagination() {
	}

	public Pagination(int pageNo, int pageSize, int totalCount) {
		super(pageNo, pageSize, totalCount);
	}

	@SuppressWarnings("unchecked")
	public Pagination(int pageNo, int pageSize, int totalCount, List list) {
		super(pageNo, pageSize, totalCount);
		this.list = list;
	}

	public int getFirstResult() {
		return (pageNo - 1) * pageSize;
	}


	

	@SuppressWarnings("unchecked")
	public List getList() {
		return list;
	}

	@SuppressWarnings("unchecked")
	public void setList(List list) {
		this.list = list;
	}
}
