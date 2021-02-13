package com.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/redis")
public class RedisController {

  @Autowired
  private StudentRepository studentRepository;

  @PostMapping
  @CacheEvict(value="students", beforeInvocation = true)
  public Student saveStudentInformation(@RequestBody Student student) {
    //studentService.save(student);
    return studentRepository.save(student);
  }

  @GetMapping
  @Cacheable(value="students", unless = "#result==null")
  public Iterable<Student> fetchAll() {
    return studentRepository.findAll();
  }

  //@Cacheable(key="#id", value="students", unless = "#result.id < 1200")
  @GetMapping(path = "{id}")
  public Student fetchStudent(@PathVariable("id") long id) {
    Optional<Student> student = studentRepository.findById(id);
    return student.isPresent() ? student.get() : null;
  }

  //@CacheEvict - Delete from Cache. Use it with DeleteMapping
  //@CachePut - Update a Cache. Use it with PutMapping
}
