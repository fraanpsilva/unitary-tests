package br.com.fraanps.apifortests.services.exceptions;

public class ObjectNotfoundException extends RuntimeException {

    public ObjectNotfoundException(String message) {
        super(message);
    }
}
