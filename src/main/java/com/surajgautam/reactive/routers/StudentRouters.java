package com.surajgautam.reactive.routers;

import com.surajgautam.reactive.handlers.StudentHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration
@RequiredArgsConstructor
public class StudentRouters {

    private final StudentHandler handler;

    @Bean
    public RouterFunction<ServerResponse> getStudents() {
        return RouterFunctions.route(GET("students/{id}"), request -> {
            final Long id = Long.parseLong(request.pathVariable("id"));
            return this.handler.getStudentById(id);
        });
    }

}
