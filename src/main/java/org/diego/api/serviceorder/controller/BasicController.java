package org.diego.api.serviceorder.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class BasicController {

    protected ResponseEntity<Object> responseStatus(HttpStatus status, Object body) {
        return ResponseEntity.status(status).body(body);
    }

    protected ResponseEntity<Object> responseSucess(Object body) {
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    protected ResponseEntity<List<?>> responseListSucess(List<?> body) {
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    protected ResponseEntity<Object> responseNoContent() {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    protected ResponseEntity<List<?>> responseListNoContent() {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
