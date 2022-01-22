package excaptions;

public class NoSpaceInGarageException extends Exception{
    public NoSpaceInGarageException() {
        super("Kupujący nie ma miejsca w garazu");
        System.out.println("Kupujący nie ma miejsca w garazu");
    }
}
