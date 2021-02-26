package com.springboot;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@ApiResponses(value = {
        @ApiResponse(code = 200, message = "SUCCESS", response = Employee.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "UNAUTHORIZED!", response = ErrorResponse.class),
        @ApiResponse(code = 403, message = "FORBIDDEN!", response = ErrorResponse.class),
        @ApiResponse(code = 404, message = "NOT FOUND")
})
//similiarly
//@PreAuthorize('hasRole('User')')
//you can also add below, but its not mandatory
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DefaultApiResponses {
}