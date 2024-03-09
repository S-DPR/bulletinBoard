package org.example.bulletinboard.restController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GenericRestController {
    protected ResponseEntity response(Object result){
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
