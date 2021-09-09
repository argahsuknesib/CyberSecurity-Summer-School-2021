package rx.functions;

import java.util.concurrent.Callable;

public interface Func0<R> extends Callable<R>, Function {
    R call();
}
