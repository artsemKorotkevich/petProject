package by.innowise.by.innowise.petProject.exception;

import lombok.Data;

@Data
public class RestExceptionDto {
    private String message;
    private Throwable cause;
    private String localizedMessage;

    public RestExceptionDto() {
    }

    public RestExceptionDto(String message, Throwable cause, String localizedMessage) {
        this.message = message;
        this.cause = cause;
        this.localizedMessage = localizedMessage;
    }

    public RestExceptionDto(RuntimeException ex) {
        this.message = ex.getMessage();
        this.cause = ex.getCause();
        this.localizedMessage = ex.getLocalizedMessage();
    }
}
