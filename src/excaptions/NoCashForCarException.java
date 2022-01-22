package excaptions;

public class NoCashForCarException extends Exception{
    public NoCashForCarException() {
        super("Kupujący nie ma wystarczającej ilości pieniędzy");
        System.out.println("Kupujący nie ma wystarczającej ilości pieniędzy");
    }
}
