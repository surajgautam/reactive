package com.surajgautam.reactive.model;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student implements Serializable {
    private long id;
    private String fullName;
    private String universityName;
}
