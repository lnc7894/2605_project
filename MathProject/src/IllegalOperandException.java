/**
* Creates an Illegal Operand Error
* @author Jeongbin Cho
* @version 1.0
**/

public class IllegalOperandException extends Exception {

    public IllegalOperandException(String msg) {
        super(msg);
    }
    public IllegalOperandException() {
        super();
    }
}
