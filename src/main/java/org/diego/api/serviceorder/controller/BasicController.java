package org.diego.api.serviceorder.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BasicController {

    protected ResponseEntity<Object> responseStatus(HttpStatus status, Object body) {
        return ResponseEntity.status(status).body(body);
    }

    protected ResponseEntity<Object> responseSucess(Object body) {
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }
}
