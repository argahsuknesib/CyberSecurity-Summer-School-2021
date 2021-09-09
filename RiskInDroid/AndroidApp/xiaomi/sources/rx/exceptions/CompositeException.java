package rx.exceptions;

import android.support.v4.app.NotificationCompat;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public final class CompositeException extends RuntimeException {
    private static final long serialVersionUID = 3026362227162912146L;
    private Throwable cause;
    private final List<Throwable> exceptions;
    private final String message;

    @Deprecated
    public CompositeException(String str, Collection<? extends Throwable> collection) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            for (Throwable th : collection) {
                if (th instanceof CompositeException) {
                    linkedHashSet.addAll(((CompositeException) th).getExceptions());
                } else if (th != null) {
                    linkedHashSet.add(th);
                } else {
                    linkedHashSet.add(new NullPointerException());
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException());
        }
        arrayList.addAll(linkedHashSet);
        this.exceptions = Collections.unmodifiableList(arrayList);
        this.message = this.exceptions.size() + " exceptions occurred. ";
    }

    public CompositeException(Collection<? extends Throwable> collection) {
        this(null, collection);
    }

    public CompositeException(Throwable... thArr) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        if (thArr != null) {
            for (Throwable th : thArr) {
                if (th instanceof CompositeException) {
                    linkedHashSet.addAll(((CompositeException) th).getExceptions());
                } else if (th != null) {
                    linkedHashSet.add(th);
                } else {
                    linkedHashSet.add(new NullPointerException());
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException());
        }
        arrayList.addAll(linkedHashSet);
        this.exceptions = Collections.unmodifiableList(arrayList);
        this.message = this.exceptions.size() + " exceptions occurred. ";
    }

    public final List<Throwable> getExceptions() {
        return this.exceptions;
    }

    public final String getMessage() {
        return this.message;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:9|(4:12|(2:14|32)(2:15|33)|31|10)|16|17|18|19|30) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0054 */
    public final synchronized Throwable getCause() {
        if (this.cause == null) {
            Throwable compositeExceptionCausalChain = new CompositeExceptionCausalChain();
            HashSet hashSet = new HashSet();
            Iterator<Throwable> it = this.exceptions.iterator();
            Throwable th = compositeExceptionCausalChain;
            while (it.hasNext()) {
                Throwable next = it.next();
                if (!hashSet.contains(next)) {
                    hashSet.add(next);
                    for (Throwable next2 : getListOfCauses(next)) {
                        if (hashSet.contains(next2)) {
                            next = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");
                        } else {
                            hashSet.add(next2);
                        }
                    }
                    th.initCause(next);
                    th = getRootCause(th);
                }
            }
            this.cause = compositeExceptionCausalChain;
        }
        return this.cause;
    }

    public final void printStackTrace() {
        printStackTrace(System.err);
    }

    public final void printStackTrace(PrintStream printStream) {
        printStackTrace(new WrappedPrintStream(printStream));
    }

    public final void printStackTrace(PrintWriter printWriter) {
        printStackTrace(new WrappedPrintWriter(printWriter));
    }

    private void printStackTrace(PrintStreamOrWriter printStreamOrWriter) {
        StringBuilder sb = new StringBuilder((int) NotificationCompat.FLAG_HIGH_PRIORITY);
        sb.append(this);
        sb.append(10);
        for (StackTraceElement append : getStackTrace()) {
            sb.append("\tat ");
            sb.append(append);
            sb.append(10);
        }
        int i = 1;
        for (Throwable appendStackTrace : this.exceptions) {
            sb.append("  ComposedException ");
            sb.append(i);
            sb.append(" :\n");
            appendStackTrace(sb, appendStackTrace, "\t");
            i++;
        }
        synchronized (printStreamOrWriter.lock()) {
            printStreamOrWriter.println(sb.toString());
        }
    }

    private void appendStackTrace(StringBuilder sb, Throwable th, String str) {
        while (true) {
            sb.append(str);
            sb.append(th);
            sb.append(10);
            for (StackTraceElement append : th.getStackTrace()) {
                sb.append("\t\tat ");
                sb.append(append);
                sb.append(10);
            }
            if (th.getCause() != null) {
                sb.append("\tCaused by: ");
                th = th.getCause();
                str = "";
            } else {
                return;
            }
        }
    }

    static abstract class PrintStreamOrWriter {
        /* access modifiers changed from: package-private */
        public abstract Object lock();

        /* access modifiers changed from: package-private */
        public abstract void println(Object obj);

        PrintStreamOrWriter() {
        }
    }

    static final class WrappedPrintStream extends PrintStreamOrWriter {
        private final PrintStream printStream;

        WrappedPrintStream(PrintStream printStream2) {
            this.printStream = printStream2;
        }

        /* access modifiers changed from: package-private */
        public final Object lock() {
            return this.printStream;
        }

        /* access modifiers changed from: package-private */
        public final void println(Object obj) {
            this.printStream.println(obj);
        }
    }

    static final class WrappedPrintWriter extends PrintStreamOrWriter {
        private final PrintWriter printWriter;

        WrappedPrintWriter(PrintWriter printWriter2) {
            this.printWriter = printWriter2;
        }

        /* access modifiers changed from: package-private */
        public final Object lock() {
            return this.printWriter;
        }

        /* access modifiers changed from: package-private */
        public final void println(Object obj) {
            this.printWriter.println(obj);
        }
    }

    static final class CompositeExceptionCausalChain extends RuntimeException {
        private static final long serialVersionUID = 3875212506787802066L;

        public final String getMessage() {
            return "Chain of Causes for CompositeException In Order Received =>";
        }

        CompositeExceptionCausalChain() {
        }
    }

    private List<Throwable> getListOfCauses(Throwable th) {
        ArrayList arrayList = new ArrayList();
        Throwable cause2 = th.getCause();
        if (cause2 != null && cause2 != th) {
            while (true) {
                arrayList.add(cause2);
                Throwable cause3 = cause2.getCause();
                if (cause3 == null || cause3 == cause2) {
                    break;
                }
                cause2 = cause2.getCause();
            }
        }
        return arrayList;
    }

    private Throwable getRootCause(Throwable th) {
        Throwable cause2 = th.getCause();
        if (cause2 == null || cause2 == th) {
            return th;
        }
        while (true) {
            Throwable cause3 = cause2.getCause();
            if (cause3 == null || cause3 == cause2) {
                return cause2;
            }
            cause2 = cause2.getCause();
        }
        return cause2;
    }
}
