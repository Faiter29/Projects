package sk.stuba.fei.uim.oop.assignment3.vynimky;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class VynimkyOvladaca {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(Prazdny.class)
    public void handleNotFoundException() {}

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ZlyVyber.class)
    public void handleIllegalOperationException() {}
}
