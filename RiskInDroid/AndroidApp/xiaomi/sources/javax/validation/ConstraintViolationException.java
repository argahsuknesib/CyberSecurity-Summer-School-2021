package javax.validation;

import java.util.HashSet;
import java.util.Set;

public class ConstraintViolationException extends ValidationException {
    private final Set<Object<?>> constraintViolations;

    public ConstraintViolationException(String str, Set<? extends Object<?>> set) {
        super(str);
        if (set == null) {
            this.constraintViolations = null;
        } else {
            this.constraintViolations = new HashSet(set);
        }
    }

    public ConstraintViolationException(Set<? extends Object<?>> set) {
        this(null, set);
    }

    public Set<Object<?>> getConstraintViolations() {
        return this.constraintViolations;
    }
}
