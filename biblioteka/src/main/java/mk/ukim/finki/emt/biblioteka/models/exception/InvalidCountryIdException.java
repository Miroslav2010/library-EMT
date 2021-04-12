package mk.ukim.finki.emt.biblioteka.models.exception;

public class InvalidCountryIdException extends RuntimeException{
    public InvalidCountryIdException(){
        super("Invalid country id");
    }
}
