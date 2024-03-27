package org.diego.api.serviceorder.controller;

import com.sun.istack.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class BasicController<T> {

    protected ResponseEntity<T> responseStatus(HttpStatus httpStatus, T body) {
        return ResponseEntity.status(httpStatus).body(body);
    }

    protected ResponseEntity<T> responseSuccess(T body) {
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    protected ResponseEntity<List<T>> responseListSuccess(List<T> body) {
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    protected ResponseEntity<T> responseNoContent() {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    protected ResponseEntity<List<T>> responseListNoContent() {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    public  ResponseEntity<T> responseEntity(@NotNull Optional<T> optional) {
        return optional.isPresent() ? responseSuccess(optional.get()) : responseNoContent();
    }
}
