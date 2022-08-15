package com.surajgautam.reactive.repository;

import com.surajgautam.reactive.model.Student;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface StudentRepository extends ReactiveMongoRepository<Student, String> {

}
