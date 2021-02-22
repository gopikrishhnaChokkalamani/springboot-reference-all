package com.springboot;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface ProductRepository extends CassandraRepository<Product, Serializable> {
}

//cassandra repository - resulting data will be a list, also supports pageable
//crudrepository - iterable
//jparepository - list, also supports pageable