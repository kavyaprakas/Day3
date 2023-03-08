package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	@Autowired
	StudentRepository serviceRepository;
	@Autowired
	StudentService service;
	@GetMapping("/getvalues")
	List<details>getList(){
		return serviceRepository.findAll();
		
	}
@PostMapping("/post")
public details create(@RequestBody details det) {
	return serviceRepository.save(det);
}
@GetMapping("/getvalues/{id}")
	public Optional<details>getbyid(@PathVariable int id){
		return service.getdetails(id);
	}
	@PutMapping("/student")
	public String update(@RequestBody details det) {
		return service.updateDetails(det);
	}
	@DeleteMapping("/student")
	public String delete(@RequestParam int id) {
		return service.deleteDetails(id);
	}
	@GetMapping("/student/{offset}/{pageSize}")
	public List<details>detailsWithPagination(@PathVariable int offset,@PathVariable int PageSize){
		return service.setPages(offset,PageSize);
	}
	@GetMapping("/student/{field}")
	public List<details>detailsSortList(@PathVariable String field){
		return service.getSort(field);
	}
	@GetMapping("/sortandpage/{offset}/{pagesize}/{field}")
	public Page<details>sortPagination(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String field){
	return service.dosortandPage(offset, pagesize, field);
	}
}

