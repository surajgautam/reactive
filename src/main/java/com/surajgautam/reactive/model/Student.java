package com.surajgautam.reactive.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document("students")
public class Student implements Serializable {
    @Id
    private String id;
    private String fullName;
    private String universityName;
}
