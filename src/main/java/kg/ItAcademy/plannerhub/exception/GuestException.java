package kg.ItAcademy.plannerhub.exception;

public class GuestException extends RuntimeException{
    private String message;

    public GuestException(String message){
        super("Вы не можете сделать это: " + message);
    }
}
