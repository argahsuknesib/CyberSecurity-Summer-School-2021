package _m_j;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ+\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011H\u0002¢\u0006\u0002\u0010\u0012J+\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011¢\u0006\u0002\u0010\u0014J!\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011¢\u0006\u0002\u0010\u0016J\u001f\u0010\u0017\u001a\u00020\u000b2\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0011\"\u00020\u0006¢\u0006\u0002\u0010\u0018J\u001f\u0010\u0019\u001a\u00020\u000b2\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0011\"\u00020\u0006¢\u0006\u0002\u0010\u0018J\b\u0010\u001a\u001a\u00020\u0005H\u0016J\u0019\u0010\u001a\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011¢\u0006\u0002\u0010\u001bJ\u001f\u0010\u001c\u001a\u00020\u000b2\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0011\"\u00020\u0006¢\u0006\u0002\u0010\u0018R*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0004¢\u0006\u0002\n\u0000R6\u0010\b\u001a*\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\t0\u0004j\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\t`\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/xiaomi/smarthome/LogDumper;", "", "()V", "dumpables", "Ljava/util/HashMap;", "", "Lcom/xiaomi/smarthome/Dumpable;", "Lkotlin/collections/HashMap;", "dumpablesRef", "Ljava/lang/ref/WeakReference;", "clear", "", "dump", "dumpable", "pw", "Ljava/io/PrintWriter;", "args", "", "(Lcom/xiaomi/smarthome/Dumpable;Ljava/io/PrintWriter;[Ljava/lang/String;)V", "tag", "(Ljava/lang/String;Ljava/io/PrintWriter;[Ljava/lang/String;)V", "dumpAll", "(Ljava/io/PrintWriter;[Ljava/lang/String;)V", "register", "([Lcom/xiaomi/smarthome/Dumpable;)V", "registerRef", "toString", "([Ljava/lang/String;)Ljava/lang/String;", "unregister", "smarthome-home_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class eyg {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final eyg f15944O000000o = new eyg();
    private static final HashMap<String, exv> O00000Oo = new HashMap<>();
    private static final HashMap<String, WeakReference<exv>> O00000o0 = new HashMap<>();

    private eyg() {
    }

    public static void O000000o(exv... exvArr) {
        ixe.O00000o(exvArr, "dumpable");
        int i = 0;
        while (i <= 0) {
            exv exv = exvArr[0];
            i++;
            String O000000o2 = exv.O000000o();
            ixe.O00000Oo(O000000o2, "dump.dumpTag");
            O00000Oo.put(O000000o2, exv);
        }
    }

    public static void O00000Oo(exv... exvArr) {
        ixe.O00000o(exvArr, "dumpable");
        int i = 0;
        while (i <= 0) {
            i++;
            O00000Oo.remove(exvArr[0].O000000o());
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.iuy.O00000Oo(java.util.Collection, java.lang.Iterable):java.util.List<T>
     arg types: [java.util.Collection<_m_j.exv>, java.util.List]
     candidates:
      _m_j.iuy.O00000Oo(java.lang.Iterable, java.lang.Object):int
      _m_j.iuy.O00000Oo(java.lang.Iterable, java.util.Collection):C
      _m_j.iuy.O00000Oo(java.util.Collection, java.lang.Iterable):java.util.List<T> */
    private static void O000000o(PrintWriter printWriter, String[] strArr) {
        ixe.O00000o(printWriter, "pw");
        ixe.O00000o(strArr, "args");
        Collection<exv> values = O00000Oo.values();
        ixe.O00000Oo(values, "dumpables.values");
        Collection<WeakReference<exv>> values2 = O00000o0.values();
        ixe.O00000Oo(values2, "dumpablesRef.values");
        Collection arrayList = new ArrayList();
        for (WeakReference weakReference : values2) {
            exv exv = (exv) weakReference.get();
            if (exv != null) {
                arrayList.add(exv);
            }
        }
        for (exv exv2 : iuo.O00000Oo((Collection) values, (Iterable) ((List) arrayList))) {
            ixe.O00000Oo(exv2, "dumpable");
            printWriter.println("DUMP '" + exv2.O000000o() + "' START ............................");
            exv2.O000000o(printWriter, strArr);
            printWriter.println("DUMP '" + exv2.O000000o() + "' END ..............................");
        }
    }

    public final String toString() {
        String[] strArr = new String[0];
        ixe.O00000o(strArr, "args");
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        O000000o(printWriter, strArr);
        printWriter.flush();
        String stringWriter2 = stringWriter.toString();
        ixe.O00000Oo(stringWriter2, "stringWriter.toString()");
        return stringWriter2;
    }
}
