package com.surajgautam.reactive.handlers;

import com.surajgautam.reactive.model.Student;
import com.surajgautam.reactive.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class StudentHandler {

    private final StudentRepository repository;

    public Mono<ServerResponse> getStudentById(final Long id) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.repository.findById(id).log(), Student.class);
    }
}
