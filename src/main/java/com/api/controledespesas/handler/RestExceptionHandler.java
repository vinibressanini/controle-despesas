package com.api.controledespesas.handler;

import com.api.controledespesas.exception.BadRequestException;
import com.api.controledespesas.exception.BadRequestExceptionDetails;
import com.api.controledespesas.exception.ValidationExceptionDetails;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestExceptionDetails> handleBadRequestException (BadRequestException bre) {

        return new ResponseEntity<>(
                BadRequestExceptionDetails.builder()
                        .title("Bad Request Exception, check the documentation")
                        .status(HttpStatus.BAD_REQUEST.value())
                        .details(bre.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build()
                        ,HttpStatus.BAD_REQUEST);

    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<FieldError>  fieldErrors = exception.getBindingResult().getFieldErrors();
        String fields = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(","));
        String fieldsMessage = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(","));

        return new ResponseEntity<>(
                ValidationExceptionDetails.builder()
                        .title("Bad Request Exception, Invalid Fields")
                        .status(HttpStatus.BAD_REQUEST.value())
                        .details("Check the field(s) errors")
                        .timestamp(LocalDateTime.now())
                        .fieldsMessage(fieldsMessage)
                        .fields(fields)
                        .build(),HttpStatus.BAD_REQUEST);

    }


}
