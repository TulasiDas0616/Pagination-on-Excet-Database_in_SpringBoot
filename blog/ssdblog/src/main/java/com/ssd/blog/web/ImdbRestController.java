package com.ssd.blog.web;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssd.blog.payload.PagningAndSortingResponse;
import com.ssd.blog.serviceimpl.ImdbServiceImpl;
@RestController
@RequestMapping()
public class ImdbRestController {
	@Autowired
	public ImdbServiceImpl imdbServiceImpl;
	
	
	@GetMapping("/pagination")
	public ResponseEntity<PagningAndSortingResponse> getAllMovies(	
			@RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = "genre", required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = "ASC", required = false) String sortDir){
		
		PagningAndSortingResponse movieList = imdbServiceImpl.getAllMovies(pageNo, pageSize, sortBy, sortDir);
		
		return new ResponseEntity<PagningAndSortingResponse>(movieList,HttpStatus.OK);
	}

}
