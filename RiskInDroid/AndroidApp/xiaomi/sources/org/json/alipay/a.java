package org.json.alipay;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f15440a;

    public a() {
        this.f15440a = new ArrayList();
    }

    public a(Object obj) {
        this();
        if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            for (int i = 0; i < length; i++) {
                this.f15440a.add(Array.get(obj, i));
            }
            return;
        }
        throw new JSONException("JSONArray initial value should be a string or collection or array.");
    }

    public a(String str) {
        this(new c(str));
    }

    public a(Collection collection) {
        this.f15440a = collection == null ? new ArrayList() : new ArrayList(collection);
    }

    public a(c cVar) {
        this();
        char c;
        Object obj;
        ArrayList arrayList;
        char c2 = cVar.c();
        if (c2 == '[') {
            c = ']';
        } else if (c2 == '(') {
            c = ')';
        } else {
            throw cVar.a("A JSONArray text must start with '['");
        }
        if (cVar.c() != ']') {
            do {
                cVar.a();
                if (cVar.c() == ',') {
                    cVar.a();
                    arrayList = this.f15440a;
                    obj = null;
                } else {
                    cVar.a();
                    arrayList = this.f15440a;
                    obj = cVar.d();
                }
                arrayList.add(obj);
                char c3 = cVar.c();
                if (c3 != ')') {
                    if (c3 != ',' && c3 != ';') {
                        if (c3 != ']') {
                            throw cVar.a("Expected a ',' or ']'");
                        }
                    }
                }
                if (c != c3) {
                    throw cVar.a("Expected a '" + Character.valueOf(c) + "'");
                }
                return;
            } while (cVar.c() != ']');
        }
    }

    private String a(String str) {
        int size = this.f15440a.size();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuffer.append(str);
            }
            stringBuffer.append(b.a(this.f15440a.get(i)));
        }
        return stringBuffer.toString();
    }

    public final int a() {
        return this.f15440a.size();
    }

    public final Object a(int i) {
        Object obj = (i < 0 || i >= this.f15440a.size()) ? null : this.f15440a.get(i);
        if (obj != null) {
            return obj;
        }
        throw new JSONException("JSONArray[" + i + "] not found.");
    }

    public String toString() {
        try {
            return "[" + a(",") + ']';
        } catch (Exception unused) {
            return null;
        }
    }
}
