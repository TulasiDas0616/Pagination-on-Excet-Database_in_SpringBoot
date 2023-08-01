package com.ssd.blog.serviceimpl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ssd.blog.entity.ImdbData;
import com.ssd.blog.payload.PagningAndSortingResponse;
import com.ssd.blog.repository.ImdbRepository;
@Service
public class ImdbServiceImpl {
	@Autowired
	public ImdbRepository imdbRepository;
	
	public PagningAndSortingResponse getAllMovies(int pageNo,int size,String sortBy,String sortDir){
		
	      Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
	                : Sort.by(sortBy).descending();
		
		Pageable pageable = PageRequest.of(pageNo,size,sort);
		Page<ImdbData>  page  =imdbRepository.findAll(pageable);
		PagningAndSortingResponse pagningAndSortingResponse =new PagningAndSortingResponse();
		pagningAndSortingResponse.setListdata(page.getContent());
		pagningAndSortingResponse.setLast(page.isLast());
		pagningAndSortingResponse.setPageNo(page.getNumber());
		pagningAndSortingResponse.setPageSize(page.getSize());
		pagningAndSortingResponse.setTotalElements(page.getNumberOfElements());
		pagningAndSortingResponse.setTotalPages(page.getTotalPages());
		
		return pagningAndSortingResponse;
	}
	
	
}
