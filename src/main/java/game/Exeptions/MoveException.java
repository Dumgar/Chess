package game.Exeptions;

/**
 * Created by raulett on 01.03.2016.
 */
public class MoveException extends Throwable {
    public MoveException(String s){
         new Throwable(s);
    }
    public MoveException(){};
}
