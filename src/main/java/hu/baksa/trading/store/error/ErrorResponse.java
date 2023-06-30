package hu.baksa.trading.store.error;

import org.springframework.http.HttpStatus;

public record ErrorResponse(HttpStatus status, String message) {
}
