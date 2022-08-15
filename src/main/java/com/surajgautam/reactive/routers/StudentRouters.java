package com.surajgautam.reactive.routers;

import com.surajgautam.reactive.handlers.StudentHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;

@Configuration
@RequiredArgsConstructor
public class StudentRouters {

    private final StudentHandler handler;

    @Bean
    public RouterFunction<ServerResponse> getStudents() {
        return RouterFunctions.route(GET("/students/{id}"), request ->
                this.handler.getStudentById(request.pathVariable("id")));
    }

    @Bean
    public RouterFunction<ServerResponse> createStudent() {
        return RouterFunctions.route(POST("/students"), this.handler::createStudent);
    }

}
