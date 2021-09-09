package miuix.reflect;

public class NoSuchFieldException extends ReflectionException {
    private static final long serialVersionUID = -7034897190745766943L;

    public NoSuchFieldException() {
    }

    public NoSuchFieldException(String str) {
        super(str);
    }

    public NoSuchFieldException(String str, Throwable th) {
        super(str, th);
    }

    public NoSuchFieldException(Throwable th) {
        super(th);
    }
}
