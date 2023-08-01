package com.ssd.blog.serviceimpl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ssd.blog.entity.Customer;
import com.ssd.blog.entity.ImdbData;
import com.ssd.blog.payload.PagningAndSortingResponse;
import com.ssd.blog.repository.CustomerRepository;
import com.ssd.blog.repository.ImdbRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {
	@Autowired
    private CustomerRepository customerRepository;

    public void saveCustomersToDatabase(MultipartFile file){
        if(ExcelUploadService.isValidExcelFile(file)){
            try {
                List<Customer> customers = ExcelUploadService.getCustomersDataFromExcel(file.getInputStream());
                this.customerRepository.saveAll(customers);
            } catch (IOException e) {
                throw new IllegalArgumentException("The file is not a valid excel file");
            }
        }
    }

    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }
   
	public PagningAndSortingResponse getCustomerList(int pageNo,int size,String sortBy,String sortDir){
		
	      Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
	                : Sort.by(sortBy).descending();
		
		Pageable pageable = PageRequest.of(pageNo,size,sort);
		Page<Customer>  page  =customerRepository.findAll(pageable);
		PagningAndSortingResponse pagningAndSortingResponse =new PagningAndSortingResponse();
		pagningAndSortingResponse.setCustomerdata(page.getContent());
		pagningAndSortingResponse.setLast(page.isLast());
		pagningAndSortingResponse.setPageNo(page.getNumber());
		pagningAndSortingResponse.setPageSize(page.getSize());
		pagningAndSortingResponse.setTotalElements(page.getNumberOfElements());
		pagningAndSortingResponse.setTotalPages(page.getTotalPages());
		
		return pagningAndSortingResponse;
	}

}
