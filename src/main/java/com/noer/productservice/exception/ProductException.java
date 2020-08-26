package com.noer.productservice.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Setter
@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProductException extends RuntimeException {
    private static final long serialVersionUID = 4L;
    private String message;
    public ProductException( String message) {
        this.message = message;
    }
}
