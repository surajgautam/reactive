package com.surajgautam.reactive.handlers;

import com.surajgautam.reactive.model.Student;
import com.surajgautam.reactive.model.StudentRequest;
import com.surajgautam.reactive.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class StudentHandler {

    private final StudentRepository repository;

    public Mono<ServerResponse> getStudentById(final String id) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.repository.findById(id).log(), Student.class);
    }

    public Mono<ServerResponse> createStudent(final ServerRequest request) {
        return request.bodyToMono(StudentRequest.class)
                .flatMap(studentRequest -> this.repository.save(map(studentRequest))
                        .flatMap(student -> ServerResponse.status(HttpStatus.CREATED).build())
                        .onErrorResume(throwable -> {
                            throwable.printStackTrace();
                            return ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                        }));
    }

    private Student map(final StudentRequest studentRequest) {
        final Student student = new Student();
        student.setId(UUID.randomUUID().toString());
        student.setFullName(studentRequest.getFullName());
        student.setUniversityName(studentRequest.getUniversityName());
        return student;
    }

    public Mono<ServerResponse> getStudents() {
        return ServerResponse.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.repository.findAll(), Student.class);
    }
}
