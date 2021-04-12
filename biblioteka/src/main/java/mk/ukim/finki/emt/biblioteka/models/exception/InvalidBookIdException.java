package mk.ukim.finki.emt.biblioteka.models.exception;

public class InvalidBookIdException extends RuntimeException{
    public InvalidBookIdException() {
        super("Invalid book id");
    }
}
