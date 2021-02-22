package com.springboot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Frozen;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;

@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

  //you can move these two primary keys to another call and add it as reference variable
  //just add @PrimaryKey here and @PrimaryKeyClass on that class

  //primary key type is important for cassandra to determine the parition key
  //here in this case, the partition key will be the id in the column datamodel inside the node
  //if you change both to CLUSTERED, then that parition key will be geenrated as
  //a clustered key of both id and name
  @PrimaryKeyColumn(name = "id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
  private int id;
  
  @PrimaryKeyColumn(name = "name", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
  private String name;
  
  @Column(value = "created_time")
  private Date createdTime = new Date();
  
  @Frozen
  //@CassandraType(type = CassandraType.Name.TEXT, userTypeName = "category")
  private Category category;
}
