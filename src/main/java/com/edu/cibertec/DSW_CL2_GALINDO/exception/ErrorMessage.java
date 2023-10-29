package com.edu.cibertec.DSW_CL2_GALINDO.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class ErrorMessage {
    private Integer code;
    private Date dateError;
    private String mensaje;
    private String description;
}
