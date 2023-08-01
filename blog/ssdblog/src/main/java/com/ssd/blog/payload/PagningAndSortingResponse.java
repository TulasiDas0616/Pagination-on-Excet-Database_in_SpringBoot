package com.ssd.blog.payload;

import java.util.List;

import com.ssd.blog.entity.Customer;
import com.ssd.blog.entity.ImdbData;

public class PagningAndSortingResponse {
	private List<ImdbData> listdata;
	private List<PostDto> content;
	private List<Customer> customerdata;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;
	public List<ImdbData> getListdata() {
		return listdata;
	}
	public void setListdata(List<ImdbData> listdata) {
		this.listdata = listdata;
	}
	public List<PostDto> getContent() {
		return content;
	}
	public void setContent(List<PostDto> content) {
		this.content = content;
	}
	public List<Customer> getCustomerdata() {
		return customerdata;
	}
	public void setCustomerdata(List<Customer> customerdata) {
		this.customerdata = customerdata;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public long getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public boolean isLast() {
		return last;
	}
	public void setLast(boolean last) {
		this.last = last;
	}
	public PagningAndSortingResponse(List<ImdbData> listdata, List<PostDto> content, List<Customer> customerdata,
			int pageNo, int pageSize, long totalElements, int totalPages, boolean last) {
		super();
		this.listdata = listdata;
		this.content = content;
		this.customerdata = customerdata;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.totalElements = totalElements;
		this.totalPages = totalPages;
		this.last = last;
	}
	public PagningAndSortingResponse() {
		super();
	}
	
}
