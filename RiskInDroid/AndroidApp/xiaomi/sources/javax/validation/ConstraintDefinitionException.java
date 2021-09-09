package javax.validation;

public class ConstraintDefinitionException extends ValidationException {
    public ConstraintDefinitionException(String str) {
        super(str);
    }

    public ConstraintDefinitionException() {
    }

    public ConstraintDefinitionException(String str, Throwable th) {
        super(str, th);
    }

    public ConstraintDefinitionException(Throwable th) {
        super(th);
    }
}
