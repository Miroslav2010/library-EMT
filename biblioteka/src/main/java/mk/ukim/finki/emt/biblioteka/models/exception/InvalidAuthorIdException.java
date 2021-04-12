package mk.ukim.finki.emt.biblioteka.models.exception;

public class InvalidAuthorIdException extends RuntimeException{
    public InvalidAuthorIdException() {
        super("Invalid author Id");
    }
}
