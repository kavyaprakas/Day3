package com.example.demo;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class StudentService {
@Autowired
StudentRepository repository;
public Optional<details>getdetails(int id){
	return repository.findById(id);
}
public String updateDetails(details det) {
	repository.save(det);
	return "updated";
}

public String deleteDetails(int id) {
	repository.deleteById(id);
	return "Id deleted";
}
public List<details>setPages(@PathVariable int offset,@PathVariable int pageSize){
	Page<details>page=repository.findAll(PageRequest.of(offset, pageSize));
	return page.getContent();
}
public List<details>getSort(String field){
	return repository.findAll(Sort.by(Sort.Direction.ASC,field));
}
public Page<details>dosortandPage(int offset,int pageSize,String field){
Pageable pageable=PageRequest.of(offset,pageSize,Sort.by(Direction.ASC,field));
return repository.findAll(pageable);
}
}
