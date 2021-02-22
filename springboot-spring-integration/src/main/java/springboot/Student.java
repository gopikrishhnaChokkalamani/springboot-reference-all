package springboot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

//@Data
@Getter
@Setter
@AllArgsConstructor
public class Student implements Serializable {

  private static final long serialVersionUID = 1L;

  private int id;

  private String name;

  private int age;

  private String department;

  private List<String> subjects;
}
