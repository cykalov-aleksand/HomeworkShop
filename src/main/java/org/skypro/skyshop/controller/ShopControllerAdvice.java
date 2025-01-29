package org.skypro.skyshop.controller;

import org.skypro.skyshop.model.error.ShopError;
import org.skypro.skyshop.service.NoSuchProductException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ShopControllerAdvice extends NoSuchProductException {

   @ExceptionHandler(NoSuchProductException.class)
    public ResponseEntity<String> noSuchProductHandler
            (NoSuchProductException e) {
        ShopError error = new ShopError("Код ошибки 414", "Не верно введен ID продукта, либо данный продукт отсутствует в магазине");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Код ошибки HTTP - "+HttpStatus.NOT_FOUND+"    "+ error.toString());
    }

}
