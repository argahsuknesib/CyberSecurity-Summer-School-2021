package javax.validation;

public class GroupDefinitionException extends ValidationException {
    public GroupDefinitionException(String str) {
        super(str);
    }

    public GroupDefinitionException() {
    }

    public GroupDefinitionException(String str, Throwable th) {
        super(str, th);
    }

    public GroupDefinitionException(Throwable th) {
        super(th);
    }
}
