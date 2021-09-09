package _m_j;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

public class OOO0OO0 extends DataSetObservable {

    /* renamed from: O000000o  reason: collision with root package name */
    static final String f12316O000000o = "OOO0OO0";
    private static final Object O0000O0o = new Object();
    private static final Map<String, OOO0OO0> O0000OOo = new HashMap();
    public final Object O00000Oo = new Object();
    final Context O00000o;
    public final List<O000000o> O00000o0 = new ArrayList();
    final String O00000oO;
    boolean O00000oo = true;
    private Intent O0000Oo;
    private final List<O00000o> O0000Oo0 = new ArrayList();
    private O00000Oo O0000OoO = new O00000o0();
    private int O0000Ooo = 50;
    private boolean O0000o0 = true;
    private boolean O0000o00 = false;
    private boolean O0000o0O = false;
    private O0000O0o O0000o0o;

    public interface O00000Oo {
        void O000000o(List<O000000o> list, List<O00000o> list2);
    }

    public interface O0000O0o {
        boolean O000000o();
    }

    public static OOO0OO0 O000000o(Context context, String str) {
        OOO0OO0 ooo0oo0;
        synchronized (O0000O0o) {
            ooo0oo0 = O0000OOo.get(str);
            if (ooo0oo0 == null) {
                ooo0oo0 = new OOO0OO0(context, str);
                O0000OOo.put(str, ooo0oo0);
            }
        }
        return ooo0oo0;
    }

    private OOO0OO0(Context context, String str) {
        this.O00000o = context.getApplicationContext();
        if (TextUtils.isEmpty(str) || str.endsWith(".xml")) {
            this.O00000oO = str;
            return;
        }
        this.O00000oO = str + ".xml";
    }

    public final int O000000o() {
        int size;
        synchronized (this.O00000Oo) {
            O00000o();
            size = this.O00000o0.size();
        }
        return size;
    }

    public final ResolveInfo O000000o(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.O00000Oo) {
            O00000o();
            resolveInfo = this.O00000o0.get(i).f12317O000000o;
        }
        return resolveInfo;
    }

    public final int O000000o(ResolveInfo resolveInfo) {
        synchronized (this.O00000Oo) {
            O00000o();
            List<O000000o> list = this.O00000o0;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i).f12317O000000o == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    public final Intent O00000Oo(int i) {
        synchronized (this.O00000Oo) {
            if (this.O0000Oo == null) {
                return null;
            }
            O00000o();
            O000000o o000000o = this.O00000o0.get(i);
            ComponentName componentName = new ComponentName(o000000o.f12317O000000o.activityInfo.packageName, o000000o.f12317O000000o.activityInfo.name);
            Intent intent = new Intent(this.O0000Oo);
            intent.setComponent(componentName);
            if (this.O0000o0o != null) {
                new Intent(intent);
                if (this.O0000o0o.O000000o()) {
                    return null;
                }
            }
            O000000o(new O00000o(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public final ResolveInfo O00000Oo() {
        synchronized (this.O00000Oo) {
            O00000o();
            if (this.O00000o0.isEmpty()) {
                return null;
            }
            ResolveInfo resolveInfo = this.O00000o0.get(0).f12317O000000o;
            return resolveInfo;
        }
    }

    private void O00000oO() {
        if (!this.O0000o00) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        } else if (this.O0000o0) {
            this.O0000o0 = false;
            if (!TextUtils.isEmpty(this.O00000oO)) {
                new O0000OOo().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList(this.O0000Oo0), this.O00000oO);
            }
        }
    }

    public final int O00000o0() {
        int size;
        synchronized (this.O00000Oo) {
            O00000o();
            size = this.O0000Oo0.size();
        }
        return size;
    }

    public final void O00000o() {
        boolean O0000O0o2 = O0000O0o() | O0000OOo();
        O0000Oo0();
        if (O0000O0o2) {
            O00000oo();
            notifyChanged();
        }
    }

    private boolean O00000oo() {
        if (this.O0000OoO == null || this.O0000Oo == null || this.O00000o0.isEmpty() || this.O0000Oo0.isEmpty()) {
            return false;
        }
        this.O0000OoO.O000000o(this.O00000o0, Collections.unmodifiableList(this.O0000Oo0));
        return true;
    }

    private boolean O0000O0o() {
        if (!this.O0000o0O || this.O0000Oo == null) {
            return false;
        }
        this.O0000o0O = false;
        this.O00000o0.clear();
        List<ResolveInfo> queryIntentActivities = this.O00000o.getPackageManager().queryIntentActivities(this.O0000Oo, 0);
        int size = queryIntentActivities.size();
        for (int i = 0; i < size; i++) {
            this.O00000o0.add(new O000000o(queryIntentActivities.get(i)));
        }
        return true;
    }

    private boolean O0000OOo() {
        if (!this.O00000oo || !this.O0000o0 || TextUtils.isEmpty(this.O00000oO)) {
            return false;
        }
        this.O00000oo = false;
        this.O0000o00 = true;
        O0000Oo();
        return true;
    }

    public final boolean O000000o(O00000o o00000o) {
        boolean add = this.O0000Oo0.add(o00000o);
        if (add) {
            this.O0000o0 = true;
            O0000Oo0();
            O00000oO();
            O00000oo();
            notifyChanged();
        }
        return add;
    }

    private void O0000Oo0() {
        int size = this.O0000Oo0.size() - this.O0000Ooo;
        if (size > 0) {
            this.O0000o0 = true;
            for (int i = 0; i < size; i++) {
                this.O0000Oo0.remove(0);
            }
        }
    }

    public static final class O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final ComponentName f12318O000000o;
        public final long O00000Oo;
        public final float O00000o0;

        public O00000o(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

        public O00000o(ComponentName componentName, long j, float f) {
            this.f12318O000000o = componentName;
            this.O00000Oo = j;
            this.O00000o0 = f;
        }

        public final int hashCode() {
            ComponentName componentName = this.f12318O000000o;
            int hashCode = componentName == null ? 0 : componentName.hashCode();
            long j = this.O00000Oo;
            return ((((hashCode + 31) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + Float.floatToIntBits(this.O00000o0);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            O00000o o00000o = (O00000o) obj;
            ComponentName componentName = this.f12318O000000o;
            if (componentName == null) {
                if (o00000o.f12318O000000o != null) {
                    return false;
                }
            } else if (!componentName.equals(o00000o.f12318O000000o)) {
                return false;
            }
            return this.O00000Oo == o00000o.O00000Oo && Float.floatToIntBits(this.O00000o0) == Float.floatToIntBits(o00000o.O00000o0);
        }

        public final String toString() {
            return "[" + "; activity:" + this.f12318O000000o + "; time:" + this.O00000Oo + "; weight:" + new BigDecimal((double) this.O00000o0) + "]";
        }
    }

    public static final class O000000o implements Comparable<O000000o> {

        /* renamed from: O000000o  reason: collision with root package name */
        public final ResolveInfo f12317O000000o;
        public float O00000Oo;

        public final /* synthetic */ int compareTo(Object obj) {
            return Float.floatToIntBits(((O000000o) obj).O00000Oo) - Float.floatToIntBits(this.O00000Oo);
        }

        public O000000o(ResolveInfo resolveInfo) {
            this.f12317O000000o = resolveInfo;
        }

        public final int hashCode() {
            return Float.floatToIntBits(this.O00000Oo) + 31;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && Float.floatToIntBits(this.O00000Oo) == Float.floatToIntBits(((O000000o) obj).O00000Oo);
        }

        public final String toString() {
            return "[" + "resolveInfo:" + this.f12317O000000o.toString() + "; weight:" + new BigDecimal((double) this.O00000Oo) + "]";
        }
    }

    static final class O00000o0 implements O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        private final Map<ComponentName, O000000o> f12319O000000o = new HashMap();

        O00000o0() {
        }

        public final void O000000o(List<O000000o> list, List<O00000o> list2) {
            Map<ComponentName, O000000o> map = this.f12319O000000o;
            map.clear();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                O000000o o000000o = list.get(i);
                o000000o.O00000Oo = 0.0f;
                map.put(new ComponentName(o000000o.f12317O000000o.activityInfo.packageName, o000000o.f12317O000000o.activityInfo.name), o000000o);
            }
            float f = 1.0f;
            for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
                O00000o o00000o = list2.get(size2);
                O000000o o000000o2 = map.get(o00000o.f12318O000000o);
                if (o000000o2 != null) {
                    o000000o2.O00000Oo += o00000o.O00000o0 * f;
                    f *= 0.95f;
                }
            }
            Collections.sort(list);
        }
    }

    private void O0000Oo() {
        try {
            FileInputStream openFileInput = this.O00000o.openFileInput(this.O00000oO);
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(openFileInput, "UTF-8");
                int i = 0;
                while (i != 1 && i != 2) {
                    i = newPullParser.next();
                }
                if ("historical-records".equals(newPullParser.getName())) {
                    List<O00000o> list = this.O0000Oo0;
                    list.clear();
                    while (true) {
                        int next = newPullParser.next();
                        if (next != 1) {
                            if (!(next == 3 || next == 4)) {
                                if ("historical-record".equals(newPullParser.getName())) {
                                    list.add(new O00000o(newPullParser.getAttributeValue(null, "activity"), Long.parseLong(newPullParser.getAttributeValue(null, "time")), Float.parseFloat(newPullParser.getAttributeValue(null, "weight"))));
                                } else {
                                    throw new XmlPullParserException("Share records file not well-formed.");
                                }
                            }
                        } else if (openFileInput != null) {
                            try {
                                openFileInput.close();
                                return;
                            } catch (IOException unused) {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                } else {
                    throw new XmlPullParserException("Share records file does not start with historical-records tag.");
                }
            } catch (XmlPullParserException e) {
                String str = f12316O000000o;
                Log.e(str, "Error reading historical recrod file: " + this.O00000oO, e);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException unused2) {
                    }
                }
            } catch (IOException e2) {
                String str2 = f12316O000000o;
                Log.e(str2, "Error reading historical recrod file: " + this.O00000oO, e2);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException unused3) {
                    }
                }
            } catch (Throwable th) {
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException unused5) {
        }
    }

    final class O0000OOo extends AsyncTask<Object, Void, Void> {
        O0000OOo() {
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x006b, code lost:
            if (r15 != null) goto L_0x006d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
            r15.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x008d, code lost:
            if (r15 == null) goto L_0x00ca;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00aa, code lost:
            if (r15 == null) goto L_0x00ca;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00c7, code lost:
            if (r15 == null) goto L_0x00ca;
         */
        /* renamed from: O000000o */
        public Void doInBackground(Object... objArr) {
            List list = (List) objArr[0];
            String str = (String) objArr[1];
            try {
                FileOutputStream openFileOutput = OOO0OO0.this.O00000o.openFileOutput(str, 0);
                XmlSerializer newSerializer = Xml.newSerializer();
                try {
                    newSerializer.setOutput(openFileOutput, null);
                    newSerializer.startDocument("UTF-8", Boolean.TRUE);
                    newSerializer.startTag(null, "historical-records");
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        O00000o o00000o = (O00000o) list.remove(0);
                        newSerializer.startTag(null, "historical-record");
                        newSerializer.attribute(null, "activity", o00000o.f12318O000000o.flattenToString());
                        newSerializer.attribute(null, "time", String.valueOf(o00000o.O00000Oo));
                        newSerializer.attribute(null, "weight", String.valueOf(o00000o.O00000o0));
                        newSerializer.endTag(null, "historical-record");
                    }
                    newSerializer.endTag(null, "historical-records");
                    newSerializer.endDocument();
                    OOO0OO0.this.O00000oo = true;
                } catch (IllegalArgumentException e) {
                    String str2 = OOO0OO0.f12316O000000o;
                    Log.e(str2, "Error writing historical record file: " + OOO0OO0.this.O00000oO, e);
                    OOO0OO0.this.O00000oo = true;
                } catch (IllegalStateException e2) {
                    String str3 = OOO0OO0.f12316O000000o;
                    Log.e(str3, "Error writing historical record file: " + OOO0OO0.this.O00000oO, e2);
                    OOO0OO0.this.O00000oo = true;
                } catch (IOException e3) {
                    String str4 = OOO0OO0.f12316O000000o;
                    Log.e(str4, "Error writing historical record file: " + OOO0OO0.this.O00000oO, e3);
                    OOO0OO0.this.O00000oo = true;
                } catch (Throwable th) {
                    OOO0OO0.this.O00000oo = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException unused) {
                        }
                    }
                    throw th;
                }
                return null;
            } catch (FileNotFoundException e4) {
                Log.e(OOO0OO0.f12316O000000o, "Error writing historical record file: ".concat(String.valueOf(str)), e4);
                return null;
            }
        }
    }
}
