package javax.validation;

public class ConstraintDeclarationException extends ValidationException {
    public ConstraintDeclarationException(String str) {
        super(str);
    }

    public ConstraintDeclarationException() {
    }

    public ConstraintDeclarationException(String str, Throwable th) {
        super(str, th);
    }

    public ConstraintDeclarationException(Throwable th) {
        super(th);
    }
}
