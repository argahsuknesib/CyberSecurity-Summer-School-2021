package bolts;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AggregateException extends Exception {
    private static final long serialVersionUID = 1;
    private List<Throwable> innerThrowables;

    public AggregateException(String str, Throwable[] thArr) {
        this(str, Arrays.asList(thArr));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AggregateException(String str, List<? extends Throwable> list) {
        super(str, (list == null || list.size() <= 0) ? null : (Throwable) list.get(0));
        this.innerThrowables = Collections.unmodifiableList(list);
    }

    public AggregateException(List<? extends Throwable> list) {
        this("There were multiple errors.", list);
    }

    public List<Throwable> getInnerThrowables() {
        return this.innerThrowables;
    }

    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        int i = -1;
        for (Throwable printStackTrace : this.innerThrowables) {
            printStream.append((CharSequence) "\n");
            printStream.append((CharSequence) "  Inner throwable #");
            i++;
            printStream.append((CharSequence) Integer.toString(i));
            printStream.append((CharSequence) ": ");
            printStackTrace.printStackTrace(printStream);
            printStream.append((CharSequence) "\n");
        }
    }

    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        int i = -1;
        for (Throwable printStackTrace : this.innerThrowables) {
            printWriter.append((CharSequence) "\n");
            printWriter.append((CharSequence) "  Inner throwable #");
            i++;
            printWriter.append((CharSequence) Integer.toString(i));
            printWriter.append((CharSequence) ": ");
            printStackTrace.printStackTrace(printWriter);
            printWriter.append((CharSequence) "\n");
        }
    }

    @Deprecated
    public List<Exception> getErrors() {
        ArrayList arrayList = new ArrayList();
        List<Throwable> list = this.innerThrowables;
        if (list == null) {
            return arrayList;
        }
        for (Throwable next : list) {
            if (next instanceof Exception) {
                arrayList.add((Exception) next);
            } else {
                arrayList.add(new Exception(next));
            }
        }
        return arrayList;
    }

    @Deprecated
    public Throwable[] getCauses() {
        List<Throwable> list = this.innerThrowables;
        return (Throwable[]) list.toArray(new Throwable[list.size()]);
    }
}
