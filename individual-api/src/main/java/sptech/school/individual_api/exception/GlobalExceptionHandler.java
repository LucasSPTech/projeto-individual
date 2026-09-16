package sptech.school.individual_api.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sptech.school.individual_api.dto.StandardErrorResponse;

import java.time.LocalDateTime;
import java.time.ZoneId;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DataBaseAccessException.class)
    public ResponseEntity<StandardErrorResponse> handleDataBaseAccess(DataBaseAccessException exception, HttpServletRequest request) {
        exception.printStackTrace();

        StandardErrorResponse error = new StandardErrorResponse(
                LocalDateTime.now(ZoneId.of("America/Sao_Paulo")),
                500,
                "Internal Server Error",
                "Internal error communicating with the database",
                request.getRequestURI()
        );

        return ResponseEntity.internalServerError().body(error);
    }

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<StandardErrorResponse> handleInvalidRequest(InvalidRequestException exception, HttpServletRequest request) {
        exception.printStackTrace();

        StandardErrorResponse error = new StandardErrorResponse(
                LocalDateTime.now(ZoneId.of("America/Sao_Paulo")),
                400,
                "Bad Request",
                "Invalid request parameters",
                request.getRequestURI()
        );

        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(TravelsNotFoundException.class)
    public ResponseEntity<StandardErrorResponse> handleTravelsNotFound(TravelsNotFoundException exception, HttpServletRequest request) {
        exception.printStackTrace();

        StandardErrorResponse error = new StandardErrorResponse(
                LocalDateTime.now(ZoneId.of("America/Sao_Paulo")),
                404,
                "Not Found",
                "Travels not found",
                request.getRequestURI()
        );

        return ResponseEntity.status(404).body(error);
    }
}