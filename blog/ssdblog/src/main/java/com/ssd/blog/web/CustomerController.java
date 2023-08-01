package com.ssd.blog.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssd.blog.entity.Customer;
import com.ssd.blog.payload.PagningAndSortingResponse;
import com.ssd.blog.serviceimpl.CustomerService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("customers")
public class CustomerController {
	@Autowired
    private CustomerService customerService;

    @PostMapping("/upload-customers-data")
    public ResponseEntity<?> uploadCustomersData(@RequestParam("file")MultipartFile file){
        this.customerService.saveCustomersToDatabase(file);
        return ResponseEntity
                .ok(Map.of("Message" , " Customers data uploaded and saved to database successfully"));
    }

    @GetMapping("/getting-data")
    public ResponseEntity<List<Customer>> getCustomers(){
        return new ResponseEntity<>(customerService.getCustomers(), HttpStatus.FOUND);
    }
    @GetMapping("/pagination")
	public ResponseEntity<PagningAndSortingResponse> getAllMovies(	
			@RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = "firstName", required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = "ASC", required = false) String sortDir){
		
		PagningAndSortingResponse CustomerListtt = customerService.getCustomerList(pageNo, pageSize, sortBy, sortDir);
		
		return new ResponseEntity<PagningAndSortingResponse>(CustomerListtt,HttpStatus.OK);
	}
}
