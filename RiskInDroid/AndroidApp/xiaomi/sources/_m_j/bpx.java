package _m_j;

import android.text.TextUtils;
import com.lidroid.xutils.db.sqlite.ColumnDbType;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class bpx {

    /* renamed from: O000000o  reason: collision with root package name */
    private final List<String> f13190O000000o = new ArrayList();

    public static bpx O000000o(String str, String str2, Object obj) {
        bpx bpx = new bpx();
        bpx.O000000o(null, str, str2, obj);
        return bpx;
    }

    public final bpx O00000Oo(String str, String str2, Object obj) {
        O000000o(this.f13190O000000o.size() == 0 ? null : "AND", str, str2, obj);
        return this;
    }

    public final bpx O00000o0(String str, String str2, Object obj) {
        O000000o(this.f13190O000000o.size() == 0 ? null : "OR", str, str2, obj);
        return this;
    }

    public final bpx O000000o(String str) {
        this.f13190O000000o.add(" ".concat(String.valueOf(str)));
        return this;
    }

    public final int O000000o() {
        return this.f13190O000000o.size();
    }

    public final String toString() {
        if (this.f13190O000000o.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String append : this.f13190O000000o) {
            sb.append(append);
        }
        return sb.toString();
    }

    private void O000000o(String str, String str2, String str3, Object obj) {
        StringBuilder sb = new StringBuilder();
        if (this.f13190O000000o.size() > 0) {
            sb.append(" ");
        }
        if (!TextUtils.isEmpty(str)) {
            sb.append(String.valueOf(str) + " ");
        }
        sb.append(str2);
        if ("!=".equals(str3)) {
            str3 = "<>";
        } else if ("==".equals(str3)) {
            str3 = "=";
        }
        if (obj != null) {
            sb.append(" " + str3 + " ");
            int i = 0;
            Iterable<Object> iterable = null;
            if ("IN".equalsIgnoreCase(str3)) {
                if (obj instanceof Iterable) {
                    iterable = (Iterable) obj;
                } else if (obj.getClass().isArray()) {
                    ArrayList arrayList = new ArrayList();
                    int length = Array.getLength(obj);
                    while (i < length) {
                        arrayList.add(Array.get(obj, i));
                        i++;
                    }
                    iterable = arrayList;
                }
                if (iterable != null) {
                    StringBuffer stringBuffer = new StringBuffer("(");
                    for (Object O000000o2 : iterable) {
                        Object O000000o3 = bpz.O000000o(O000000o2);
                        if (ColumnDbType.TEXT.equals(bpi.O00000Oo(O000000o3.getClass()))) {
                            String obj2 = O000000o3.toString();
                            if (obj2.indexOf(39) != -1) {
                                obj2 = obj2.replace("'", "''");
                            }
                            stringBuffer.append("'" + obj2 + "'");
                        } else {
                            stringBuffer.append(O000000o3);
                        }
                        stringBuffer.append(",");
                    }
                    stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                    stringBuffer.append(")");
                    sb.append(stringBuffer.toString());
                } else {
                    throw new IllegalArgumentException("value must be an Array or an Iterable.");
                }
            } else if ("BETWEEN".equalsIgnoreCase(str3)) {
                if (obj instanceof Iterable) {
                    iterable = (Iterable) obj;
                } else if (obj.getClass().isArray()) {
                    ArrayList arrayList2 = new ArrayList();
                    int length2 = Array.getLength(obj);
                    while (i < length2) {
                        arrayList2.add(Array.get(obj, i));
                        i++;
                    }
                    iterable = arrayList2;
                }
                if (iterable != null) {
                    Iterator it = iterable.iterator();
                    if (it.hasNext()) {
                        Object next = it.next();
                        if (it.hasNext()) {
                            Object next2 = it.next();
                            Object O000000o4 = bpz.O000000o(next);
                            Object O000000o5 = bpz.O000000o(next2);
                            if (ColumnDbType.TEXT.equals(bpi.O00000Oo(O000000o4.getClass()))) {
                                String obj3 = O000000o4.toString();
                                if (obj3.indexOf(39) != -1) {
                                    obj3 = obj3.replace("'", "''");
                                }
                                String obj4 = O000000o5.toString();
                                if (obj4.indexOf(39) != -1) {
                                    obj4 = obj4.replace("'", "''");
                                }
                                sb.append("'" + obj3 + "'");
                                sb.append(" AND ");
                                sb.append("'" + obj4 + "'");
                            } else {
                                sb.append(O000000o4);
                                sb.append(" AND ");
                                sb.append(O000000o5);
                            }
                        } else {
                            throw new IllegalArgumentException("value must have tow items.");
                        }
                    } else {
                        throw new IllegalArgumentException("value must have tow items.");
                    }
                } else {
                    throw new IllegalArgumentException("value must be an Array or an Iterable.");
                }
            } else {
                Object O000000o6 = bpz.O000000o(obj);
                if (ColumnDbType.TEXT.equals(bpi.O00000Oo(O000000o6.getClass()))) {
                    String obj5 = O000000o6.toString();
                    if (obj5.indexOf(39) != -1) {
                        obj5 = obj5.replace("'", "''");
                    }
                    sb.append("'" + obj5 + "'");
                } else {
                    sb.append(O000000o6);
                }
            }
        } else if ("=".equals(str3)) {
            sb.append(" IS NULL");
        } else if ("<>".equals(str3)) {
            sb.append(" IS NOT NULL");
        } else {
            sb.append(" " + str3 + " NULL");
        }
        this.f13190O000000o.add(sb.toString());
    }
}
