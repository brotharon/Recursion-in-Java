/**
 * Exception built for BinarySearch and LinearSearch classes to terminate
 * program if the target is not found.
 *
 * @author Calvin Evans
 * @version 8/4/2017
 */
public class ItemNotFoundException extends Exception{

    public ItemNotFoundException(){
        super();
    }

    public ItemNotFoundException(String message){
        super(message);
    }
}
