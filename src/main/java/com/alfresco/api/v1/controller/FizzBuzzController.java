package com.alfresco.api.v1.controller;

import com.alfresco.api.v1.dto.ErrorDto;
import com.alfresco.api.v1.dto.FizzBuzzDto;
import com.alfresco.service.FizzBuzzService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Validated
@Api(tags = "FizzBuzz")
public class FizzBuzzController {

    private final FizzBuzzService service;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorDto.class),
            @ApiResponse(code = 500, message = "Internal server error", response = ErrorDto.class)
    })
    @ApiOperation(value = "Transforms a contiguous range of integers to a FizzBuzz string", response = FizzBuzzDto.class)
    @GetMapping("/fizz-buzz-values")
    public FizzBuzzDto getFizzBuzzString(@ApiParam(value = "start number", required = true) @NotNull @RequestParam(value = "startNumber") Integer startNumber,
                                         @ApiParam(value = "end number", required = true) @NotNull @RequestParam(value = "endNumber") Integer endNumber) {
        return service.transformRangeAndReport(startNumber, endNumber);
    }
}
