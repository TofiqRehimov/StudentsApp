package org.example.studentsapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.studentsapp.util.Enums.ResponseStatuss;
@Getter
@Setter
@AllArgsConstructor

public class ErrorDto {
    private String message;
    private ResponseStatuss status;

}
