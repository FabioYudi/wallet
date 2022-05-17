package com.wallet.transferencia.helper;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHelper {

    public static final String EMPTY = "";

    public static ResponseEntity Created(){
        return Success(EMPTY);
    }

    public static <T> ResponseEntity Created(String message){
        return ResponseEntity.created(null).body(
                DefaultResponse.created(message)
        );
    }

    public static ResponseEntity SuccessOrNotFound(boolean expression){
        return (expression ? Success() : NotFound());
    }

    public static ResponseEntity Success(){
        return Success(EMPTY);
    }

    public static <T> ResponseEntity Success(T body){
        return ResponseEntity.ok().body(
                DefaultResponse.success(body)
        );
    }

    public static ResponseEntity Conflict(){
        return Conflict(EMPTY);
    }

    public static <T> ResponseEntity Conflict(T body){
        return new ResponseEntity(body, HttpStatus.CONFLICT);
    }

    public static ResponseEntity BadRequest(){
        return BadRequest(EMPTY);
    }

    public static ResponseEntity NotFound(){
        return NotFound(EMPTY);
    }

    public static <T> ResponseEntity NotFound(String message){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                DefaultResponse.notFound(message)
        );
    }

    public static <T> ResponseEntity NoContent(String message){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                DefaultResponse.noContent(message)
        );
    }

    public static <T> ResponseEntity BadRequest(String message){
        return ResponseEntity.badRequest().body(
                DefaultResponse.badRequest(message)
        );
    }

}


class DefaultResponse<T> {
    private final int status;
    private final String message;
    private final T content;
    private final Boolean hasError;

    DefaultResponse(int status, String message, T content, Boolean hasError) {
        this.status = status;
        this.message = message;
        this.content = content;
        this.hasError = hasError;
    }

    public static <T> DefaultResponse badRequest(String message){
        return new DefaultResponse(
                HttpStatus.BAD_REQUEST.value(),
                message,
                ResponseHelper.EMPTY,
                Boolean.TRUE);
    }

    public static <T> DefaultResponse success(T body){
        return new DefaultResponse(
                HttpStatus.OK.value(),
                "SUCCESS",
                body,
                Boolean.FALSE);
    }

    public static <T> DefaultResponse created(String message){
        return new DefaultResponse(
                HttpStatus.CREATED.value(),
                message,
                ResponseHelper.EMPTY,
                Boolean.FALSE);
    }

    public static <T> DefaultResponse notFound(String message){
        return new DefaultResponse(
                HttpStatus.NOT_FOUND.value(),
                message,
                ResponseHelper.EMPTY,
                Boolean.FALSE);
    }

    public static <T> DefaultResponse noContent(String message){
        return new DefaultResponse(
                HttpStatus.NO_CONTENT.value(),
                message,
                ResponseHelper.EMPTY,
                Boolean.FALSE);
    }



    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getContent() {
        return content;
    }
}