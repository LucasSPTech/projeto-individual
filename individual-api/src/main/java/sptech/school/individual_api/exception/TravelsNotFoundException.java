package sptech.school.individual_api.exception;

public class TravelsNotFoundException extends RuntimeException {
    public TravelsNotFoundException() {
        super("No travels to return!");
    }
}
