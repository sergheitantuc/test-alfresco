package com.alfresco.api.v1.error;

import com.alfresco.api.v1.controller.FizzBuzzController;
import com.alfresco.api.v1.dto.ErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j
@ControllerAdvice(basePackageClasses = {FizzBuzzController.class})
@Component
@ResponseBody
public class ServiceExceptionHandler {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    public ErrorDto handledException (HttpServletRequest request, MethodArgumentTypeMismatchException ex) {
        return ErrorDto.builder()
                .message(ex.getParameter().getParameterName() + " must be an integer")
                .build();
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    public ErrorDto handledException (HttpServletRequest request, MissingServletRequestParameterException ex) {
        return ErrorDto.builder()
                .message(ex.getMessage())
                .build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorDto handledException (HttpServletRequest request, Exception ex) {
        log.error("An unexpected error occurred.", ex);
        return ErrorDto.builder()
                .message("An unexpected error occurred and your request couldn't be handled.")
                .build();
    }
}
