package kg.ItAcademy.plannerhub.exception;

public class PlannerException extends RuntimeException{
    private String message;

    public PlannerException(String message){
        super("Вы не можете сделать это: " + message);
    }
}
