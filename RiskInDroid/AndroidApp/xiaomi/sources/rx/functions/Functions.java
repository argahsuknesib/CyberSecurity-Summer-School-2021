package rx.functions;

public final class Functions {
    private Functions() {
        throw new IllegalStateException("No instances!");
    }

    public static <R> FuncN<R> fromFunc(final Func0 func0) {
        return new FuncN<R>() {
            /* class rx.functions.Functions.AnonymousClass1 */

            public final R call(Object... objArr) {
                if (objArr.length == 0) {
                    return func0.call();
                }
                throw new IllegalArgumentException("Func0 expecting 0 arguments.");
            }
        };
    }

    public static <T0, R> FuncN<R> fromFunc(final Func1 func1) {
        return new FuncN<R>() {
            /* class rx.functions.Functions.AnonymousClass2 */

            public final R call(Object... objArr) {
                if (objArr.length == 1) {
                    return func1.call(objArr[0]);
                }
                throw new IllegalArgumentException("Func1 expecting 1 argument.");
            }
        };
    }

    public static <T0, T1, R> FuncN<R> fromFunc(final Func2 func2) {
        return new FuncN<R>() {
            /* class rx.functions.Functions.AnonymousClass3 */

            public final R call(Object... objArr) {
                if (objArr.length == 2) {
                    return func2.call(objArr[0], objArr[1]);
                }
                throw new IllegalArgumentException("Func2 expecting 2 arguments.");
            }
        };
    }

    public static <T0, T1, T2, R> FuncN<R> fromFunc(final Func3 func3) {
        return new FuncN<R>() {
            /* class rx.functions.Functions.AnonymousClass4 */

            public final R call(Object... objArr) {
                if (objArr.length == 3) {
                    return func3.call(objArr[0], objArr[1], objArr[2]);
                }
                throw new IllegalArgumentException("Func3 expecting 3 arguments.");
            }
        };
    }

    public static <T0, T1, T2, T3, R> FuncN<R> fromFunc(final Func4 func4) {
        return new FuncN<R>() {
            /* class rx.functions.Functions.AnonymousClass5 */

            public final R call(Object... objArr) {
                if (objArr.length == 4) {
                    return func4.call(objArr[0], objArr[1], objArr[2], objArr[3]);
                }
                throw new IllegalArgumentException("Func4 expecting 4 arguments.");
            }
        };
    }

    public static <T0, T1, T2, T3, T4, R> FuncN<R> fromFunc(final Func5 func5) {
        return new FuncN<R>() {
            /* class rx.functions.Functions.AnonymousClass6 */

            public final R call(Object... objArr) {
                if (objArr.length == 5) {
                    return func5.call(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4]);
                }
                throw new IllegalArgumentException("Func5 expecting 5 arguments.");
            }
        };
    }

    public static <T0, T1, T2, T3, T4, T5, R> FuncN<R> fromFunc(final Func6 func6) {
        return new FuncN<R>() {
            /* class rx.functions.Functions.AnonymousClass7 */

            public final R call(Object... objArr) {
                if (objArr.length == 6) {
                    return func6.call(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5]);
                }
                throw new IllegalArgumentException("Func6 expecting 6 arguments.");
            }
        };
    }

    public static <T0, T1, T2, T3, T4, T5, T6, R> FuncN<R> fromFunc(final Func7 func7) {
        return new FuncN<R>() {
            /* class rx.functions.Functions.AnonymousClass8 */

            public final R call(Object... objArr) {
                if (objArr.length == 7) {
                    return func7.call(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6]);
                }
                throw new IllegalArgumentException("Func7 expecting 7 arguments.");
            }
        };
    }

    public static <T0, T1, T2, T3, T4, T5, T6, T7, R> FuncN<R> fromFunc(final Func8 func8) {
        return new FuncN<R>() {
            /* class rx.functions.Functions.AnonymousClass9 */

            public final R call(Object... objArr) {
                if (objArr.length == 8) {
                    return func8.call(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7]);
                }
                throw new IllegalArgumentException("Func8 expecting 8 arguments.");
            }
        };
    }

    public static <T0, T1, T2, T3, T4, T5, T6, T7, T8, R> FuncN<R> fromFunc(final Func9 func9) {
        return new FuncN<R>() {
            /* class rx.functions.Functions.AnonymousClass10 */

            public final R call(Object... objArr) {
                if (objArr.length == 9) {
                    return func9.call(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7], objArr[8]);
                }
                throw new IllegalArgumentException("Func9 expecting 9 arguments.");
            }
        };
    }

    public static FuncN<Void> fromAction(final Action0 action0) {
        return new FuncN<Void>() {
            /* class rx.functions.Functions.AnonymousClass11 */

            public final Void call(Object... objArr) {
                if (objArr.length == 0) {
                    action0.call();
                    return null;
                }
                throw new IllegalArgumentException("Action0 expecting 0 arguments.");
            }
        };
    }

    public static <T0> FuncN<Void> fromAction(final Action1<? super T0> action1) {
        return new FuncN<Void>() {
            /* class rx.functions.Functions.AnonymousClass12 */

            public final Void call(Object... objArr) {
                if (objArr.length == 1) {
                    action1.call(objArr[0]);
                    return null;
                }
                throw new IllegalArgumentException("Action1 expecting 1 argument.");
            }
        };
    }

    public static <T0, T1> FuncN<Void> fromAction(final Action2<? super T0, ? super T1> action2) {
        return new FuncN<Void>() {
            /* class rx.functions.Functions.AnonymousClass13 */

            public final Void call(Object... objArr) {
                if (objArr.length == 2) {
                    action2.call(objArr[0], objArr[1]);
                    return null;
                }
                throw new IllegalArgumentException("Action3 expecting 2 arguments.");
            }
        };
    }

    public static <T0, T1, T2> FuncN<Void> fromAction(final Action3<? super T0, ? super T1, ? super T2> action3) {
        return new FuncN<Void>() {
            /* class rx.functions.Functions.AnonymousClass14 */

            public final Void call(Object... objArr) {
                if (objArr.length == 3) {
                    action3.call(objArr[0], objArr[1], objArr[2]);
                    return null;
                }
                throw new IllegalArgumentException("Action3 expecting 3 arguments.");
            }
        };
    }
}
