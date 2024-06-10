package br.com.msclients.exception;

public class CpfUniqueViolationException extends RuntimeException{
    public CpfUniqueViolationException(String msg) {
        super(msg);
    }
}
