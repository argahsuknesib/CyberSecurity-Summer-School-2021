package _m_j;

import _m_j.bvh;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

public final class bvk {
    /* access modifiers changed from: private */
    public static final Object O00000o0 = new Object();

    /* renamed from: O000000o  reason: collision with root package name */
    private final Object f13309O000000o = new Object();
    private File O00000Oo;
    private HashMap<File, O000000o> O00000o = new HashMap<>();

    public bvk(String str) {
        if (str == null || str.length() <= 0) {
            throw new RuntimeException("Directory can not be empty");
        }
        this.O00000Oo = new File(str);
    }

    private File O00000Oo() {
        File file;
        synchronized (this.f13309O000000o) {
            file = this.O00000Oo;
        }
        return file;
    }

    /* access modifiers changed from: private */
    public static File O00000Oo(File file) {
        return new File(file.getPath() + ".bak");
    }

    static final class O000000o implements bvh {
        private static final Object O00000oo = new Object();
        /* access modifiers changed from: package-private */

        /* renamed from: O000000o  reason: collision with root package name */
        public Map f13310O000000o;
        boolean O00000Oo = false;
        private final File O00000o;
        private final File O00000o0;
        private final int O00000oO;
        /* access modifiers changed from: private */
        public WeakHashMap<Object, Object> O0000O0o;

        O000000o(File file, Map map) {
            this.O00000o0 = file;
            this.O00000o = bvk.O00000Oo(file);
            this.O00000oO = 0;
            this.f13310O000000o = map == null ? new HashMap() : map;
            this.O0000O0o = new WeakHashMap<>();
        }

        private static FileOutputStream O000000o(File file) {
            try {
                return new FileOutputStream(file);
            } catch (FileNotFoundException unused) {
                if (!file.getParentFile().mkdir()) {
                    return null;
                }
                try {
                    return new FileOutputStream(file);
                } catch (FileNotFoundException unused2) {
                    return null;
                }
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.bug.O000000o(java.util.Map, java.lang.String, org.xmlpull.v1.XmlSerializer):void
         arg types: [java.util.Map, ?[OBJECT, ARRAY], _m_j.bvg]
         candidates:
          _m_j.bug.O000000o(org.xmlpull.v1.XmlPullParser, java.lang.String, java.lang.String[]):java.util.HashMap
          _m_j.bug.O000000o(java.lang.Object, java.lang.String, org.xmlpull.v1.XmlSerializer):void
          _m_j.bug.O000000o(java.util.List, java.lang.String, org.xmlpull.v1.XmlSerializer):void
          _m_j.bug.O000000o(int[], java.lang.String, org.xmlpull.v1.XmlSerializer):void
          _m_j.bug.O000000o(java.util.Map, java.lang.String, org.xmlpull.v1.XmlSerializer):void */
        /* access modifiers changed from: private */
        public boolean O00000oO() {
            if (this.O00000o0.exists()) {
                if (this.O00000o.exists()) {
                    this.O00000o0.delete();
                } else if (!this.O00000o0.renameTo(this.O00000o)) {
                    return false;
                }
            }
            try {
                FileOutputStream O000000o2 = O000000o(this.O00000o0);
                if (O000000o2 == null) {
                    return false;
                }
                Map map = this.f13310O000000o;
                bvg bvg = new bvg();
                bvg.setOutput(O000000o2, "utf-8");
                bvg.startDocument(null, Boolean.TRUE);
                bvg.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
                bug.O000000o(map, (String) null, (XmlSerializer) bvg);
                bvg.endDocument();
                O000000o2.close();
                this.O00000o.delete();
                return true;
            } catch (IOException | XmlPullParserException unused) {
                if (this.O00000o0.exists()) {
                    this.O00000o0.delete();
                }
                return false;
            }
        }

        public final long O000000o(String str) {
            long longValue;
            synchronized (this) {
                Long l = (Long) this.f13310O000000o.get(str);
                longValue = l != null ? l.longValue() : 0;
            }
            return longValue;
        }

        public final String O000000o(String str, String str2) {
            String str3;
            synchronized (this) {
                str3 = (String) this.f13310O000000o.get(str);
                if (str3 == null) {
                    str3 = str2;
                }
            }
            return str3;
        }

        public final boolean O000000o() {
            File file = this.O00000o0;
            return file != null && new File(file.getAbsolutePath()).exists();
        }

        public final Map<String, ?> O00000Oo() {
            HashMap hashMap;
            synchronized (this) {
                hashMap = new HashMap(this.f13310O000000o);
            }
            return hashMap;
        }

        public final boolean O00000o() {
            boolean z;
            synchronized (this) {
                z = this.O00000Oo;
            }
            return z;
        }

        public final bvh.O000000o O00000o0() {
            return new C0096O000000o();
        }

        /* renamed from: _m_j.bvk$O000000o$O000000o  reason: collision with other inner class name */
        public final class C0096O000000o implements bvh.O000000o {
            private final Map<String, Object> O00000Oo = new HashMap();
            private boolean O00000o0 = false;

            public C0096O000000o() {
            }

            public final bvh.O000000o O000000o() {
                synchronized (this) {
                    this.O00000o0 = true;
                }
                return this;
            }

            public final bvh.O000000o O000000o(String str, float f) {
                synchronized (this) {
                    this.O00000Oo.put(str, Float.valueOf(f));
                }
                return this;
            }

            public final bvh.O000000o O000000o(String str, int i) {
                synchronized (this) {
                    this.O00000Oo.put(str, Integer.valueOf(i));
                }
                return this;
            }

            public final bvh.O000000o O000000o(String str, long j) {
                synchronized (this) {
                    this.O00000Oo.put(str, Long.valueOf(j));
                }
                return this;
            }

            public final bvh.O000000o O000000o(String str, String str2) {
                synchronized (this) {
                    this.O00000Oo.put(str, str2);
                }
                return this;
            }

            public final bvh.O000000o O000000o(String str, boolean z) {
                synchronized (this) {
                    this.O00000Oo.put(str, Boolean.valueOf(z));
                }
                return this;
            }

            public final boolean O00000Oo() {
                boolean z;
                ArrayList arrayList;
                HashSet hashSet;
                boolean O00000o02;
                synchronized (bvk.O00000o0) {
                    z = O000000o.this.O0000O0o.size() > 0;
                    arrayList = null;
                    if (z) {
                        arrayList = new ArrayList();
                        hashSet = new HashSet(O000000o.this.O0000O0o.keySet());
                    } else {
                        hashSet = null;
                    }
                    synchronized (this) {
                        if (this.O00000o0) {
                            O000000o.this.f13310O000000o.clear();
                            this.O00000o0 = false;
                        }
                        for (Map.Entry next : this.O00000Oo.entrySet()) {
                            String str = (String) next.getKey();
                            Object value = next.getValue();
                            if (value == this) {
                                O000000o.this.f13310O000000o.remove(str);
                            } else {
                                O000000o.this.f13310O000000o.put(str, value);
                            }
                            if (z) {
                                arrayList.add(str);
                            }
                        }
                        this.O00000Oo.clear();
                    }
                    O00000o02 = O000000o.this.O00000oO();
                    if (O00000o02) {
                        O000000o o000000o = O000000o.this;
                        synchronized (o000000o) {
                            o000000o.O00000Oo = true;
                        }
                    }
                }
                if (z) {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        arrayList.get(size);
                        Iterator it = hashSet.iterator();
                        while (it.hasNext()) {
                            it.next();
                        }
                    }
                }
                return O00000o02;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
        r0 = O00000Oo(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0040, code lost:
        if (r0.exists() == false) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0042, code lost:
        r1.delete();
        r0.renameTo(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004c, code lost:
        if (r1.exists() == false) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004e, code lost:
        r1.canRead();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0051, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0056, code lost:
        if (r1.exists() == false) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005c, code lost:
        if (r1.canRead() == false) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r0 = new java.io.FileInputStream(r1);
        r3 = android.util.Xml.newPullParser();
        r3.setInput(r0, null);
        r3 = (java.util.HashMap) _m_j.bug.O000000o(r3, new java.lang.String[1]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0078, code lost:
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        r0 = new java.io.FileInputStream(r1);
        r3 = new byte[r0.available()];
        r0.read(r3);
        new java.lang.String(r3, 0, r3.length, "UTF-8");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0091, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0092, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0096, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0097, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x009d, code lost:
        if (r8 != null) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x009f, code lost:
        if (r2 != null) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        monitor-enter(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        r8.f13310O000000o = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00a9, code lost:
        r8 = r7.O00000o.get(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00b1, code lost:
        if (r8 == null) goto L_0x00b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00b3, code lost:
        r8 = new _m_j.bvk.O000000o(r1, r2);
        r7.O00000o.put(r1, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00be, code lost:
        return r8;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x0079 */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x009d  */
    public final bvh O000000o(String str) {
        HashMap hashMap;
        File O00000Oo2 = O00000Oo();
        String str2 = str + ".xml";
        if (str2.indexOf(File.separatorChar) < 0) {
            File file = new File(O00000Oo2, str2);
            synchronized (O00000o0) {
                O000000o o000000o = this.O00000o.get(file);
                if (o000000o != null && !o000000o.O00000o()) {
                    return o000000o;
                }
            }
        } else {
            throw new IllegalArgumentException("File " + str2 + " contains a path separator");
        }
        HashMap hashMap2 = hashMap;
        synchronized (O00000o0) {
        }
    }
}
