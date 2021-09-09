package bsh;

public class InterpreterError extends RuntimeException {
    public InterpreterError(String str) {
        super(str);
    }
}
