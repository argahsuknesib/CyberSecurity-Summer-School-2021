package org.apache.commons.lang.exception;

import _m_j.jcz;
import _m_j.jda;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class NestableDelegate implements Serializable {

    /* renamed from: O000000o  reason: collision with root package name */
    public static boolean f15431O000000o = true;
    public static boolean O00000Oo = true;
    static Class O00000o = null;
    public static boolean O00000o0 = true;
    private static final long serialVersionUID = 1;
    public Throwable nestable = null;

    public NestableDelegate(jda jda) {
        this.nestable = (Throwable) jda;
    }

    public final String O000000o(int i) {
        Throwable O00000Oo2 = O00000Oo(i);
        Class cls = O00000o;
        if (cls == null) {
            cls = O000000o("_m_j.jda");
            O00000o = cls;
        }
        if (cls.isInstance(O00000Oo2)) {
            return ((jda) O00000Oo2).getMessage(0);
        }
        return O00000Oo2.getMessage();
    }

    private static Class O000000o(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public final Throwable O00000Oo(int i) {
        if (i == 0) {
            return this.nestable;
        }
        return jcz.O00000o0(this.nestable)[i];
    }

    public final int O000000o(Class cls, int i) {
        if (cls == null) {
            return -1;
        }
        if (i >= 0) {
            Throwable[] O00000o02 = jcz.O00000o0(this.nestable);
            if (i < O00000o02.length) {
                if (O00000o0) {
                    while (i < O00000o02.length) {
                        if (cls.isAssignableFrom(O00000o02[i].getClass())) {
                            return i;
                        }
                        i++;
                    }
                } else {
                    while (i < O00000o02.length) {
                        if (cls.equals(O00000o02[i].getClass())) {
                            return i;
                        }
                        i++;
                    }
                }
                return -1;
            }
            StringBuffer stringBuffer = new StringBuffer("The start index was out of bounds: ");
            stringBuffer.append(i);
            stringBuffer.append(" >= ");
            stringBuffer.append(O00000o02.length);
            throw new IndexOutOfBoundsException(stringBuffer.toString());
        }
        throw new IndexOutOfBoundsException("The start index was out of bounds: ".concat(String.valueOf(i)));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.io.PrintWriter.<init>(java.io.OutputStream, boolean):void}
     arg types: [java.io.PrintStream, int]
     candidates:
      ClspMth{java.io.PrintWriter.<init>(java.io.File, java.lang.String):void throws java.io.FileNotFoundException, java.io.UnsupportedEncodingException}
      ClspMth{java.io.PrintWriter.<init>(java.lang.String, java.lang.String):void throws java.io.FileNotFoundException, java.io.UnsupportedEncodingException}
      ClspMth{java.io.PrintWriter.<init>(java.io.Writer, boolean):void}
      ClspMth{java.io.PrintWriter.<init>(java.io.OutputStream, boolean):void} */
    public final void O000000o(PrintStream printStream) {
        synchronized (printStream) {
            PrintWriter printWriter = new PrintWriter((OutputStream) printStream, false);
            O000000o(printWriter);
            printWriter.flush();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.io.PrintWriter.<init>(java.io.Writer, boolean):void}
     arg types: [java.io.StringWriter, int]
     candidates:
      ClspMth{java.io.PrintWriter.<init>(java.io.File, java.lang.String):void throws java.io.FileNotFoundException, java.io.UnsupportedEncodingException}
      ClspMth{java.io.PrintWriter.<init>(java.io.OutputStream, boolean):void}
      ClspMth{java.io.PrintWriter.<init>(java.lang.String, java.lang.String):void throws java.io.FileNotFoundException, java.io.UnsupportedEncodingException}
      ClspMth{java.io.PrintWriter.<init>(java.io.Writer, boolean):void} */
    public final void O000000o(PrintWriter printWriter) {
        String str;
        Throwable th = this.nestable;
        if (!jcz.O000000o()) {
            ArrayList arrayList = new ArrayList();
            while (th != null) {
                StringWriter stringWriter = new StringWriter();
                PrintWriter printWriter2 = new PrintWriter((Writer) stringWriter, true);
                if (th instanceof jda) {
                    ((jda) th).printPartialStackTrace(printWriter2);
                } else {
                    th.printStackTrace(printWriter2);
                }
                arrayList.add(jcz.O000000o(stringWriter.getBuffer().toString()));
                th = jcz.O000000o(th);
            }
            if (!f15431O000000o) {
                Collections.reverse(arrayList);
                str = "Rethrown as: ";
            } else {
                str = "Caused by: ";
            }
            if (O00000Oo) {
                O000000o(arrayList);
            }
            synchronized (printWriter) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    for (String println : (String[]) it.next()) {
                        printWriter.println(println);
                    }
                    if (it.hasNext()) {
                        printWriter.print(str);
                    }
                }
            }
        } else if (th instanceof jda) {
            ((jda) th).printPartialStackTrace(printWriter);
        } else {
            th.printStackTrace(printWriter);
        }
    }

    private static void O000000o(List list) {
        for (int size = list.size() - 1; size > 0; size--) {
            String[] strArr = (String[]) list.get(size);
            ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
            jcz.O000000o(arrayList, new ArrayList(Arrays.asList((String[]) list.get(size - 1))));
            int length = strArr.length - arrayList.size();
            if (length > 0) {
                StringBuffer stringBuffer = new StringBuffer("\t... ");
                stringBuffer.append(length);
                stringBuffer.append(" more");
                arrayList.add(stringBuffer.toString());
                list.set(size, arrayList.toArray(new String[arrayList.size()]));
            }
        }
    }

    public final String[] O000000o() {
        Throwable[] O00000o02 = jcz.O00000o0(this.nestable);
        String[] strArr = new String[O00000o02.length];
        for (int i = 0; i < O00000o02.length; i++) {
            Class cls = O00000o;
            if (cls == null) {
                cls = O000000o("_m_j.jda");
                O00000o = cls;
            }
            strArr[i] = cls.isInstance(O00000o02[i]) ? ((jda) O00000o02[i]).getMessage(0) : O00000o02[i].getMessage();
        }
        return strArr;
    }
}
