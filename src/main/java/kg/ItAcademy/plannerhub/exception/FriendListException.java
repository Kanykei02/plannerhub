package kg.ItAcademy.plannerhub.exception;

public class FriendListException extends RuntimeException{
    private String message;

    public FriendListException (String message){
        super("Вы не можете сделать это: " + message);
    }
}
