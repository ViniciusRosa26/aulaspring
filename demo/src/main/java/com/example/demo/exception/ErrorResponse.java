package com.example.demo.exception;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ErrorResponse extends Exception {

    private String message;
    private String status;
}
