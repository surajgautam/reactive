package com.surajgautam.reactive.handlers;

import com.surajgautam.reactive.model.Student;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class StudentHandler {
    public Mono<ServerResponse> getStudentById(final Long id) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(getStudent(id), Student.class);
    }

    private Mono<Student> getStudent(final Long id) {
        return Mono.just(new Student(id, "Suraj Gautam", "UTA Dallas"));
    }
}
