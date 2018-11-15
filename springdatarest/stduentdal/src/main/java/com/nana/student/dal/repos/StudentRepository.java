package com.nana.student.dal.repos;

import com.nana.student.dal.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
