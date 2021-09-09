package org.apache.commons.lang3.exception;

import _m_j.jde;
import _m_j.jdh;
import _m_j.jdi;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class DefaultExceptionContext implements jdh, Serializable {
    private static final long serialVersionUID = 20110706;
    private final List<Pair<String, Object>> contextValues = new ArrayList();

    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public DefaultExceptionContext addContextValue(String str, Object obj) {
        this.contextValues.add(new ImmutablePair(str, obj));
        return this;
    }

    public List<Object> getContextValues(String str) {
        ArrayList arrayList = new ArrayList();
        for (Pair next : this.contextValues) {
            if (jde.O000000o(str, (CharSequence) next.getKey())) {
                arrayList.add(next.getValue());
            }
        }
        return arrayList;
    }

    public Object getFirstContextValue(String str) {
        for (Pair next : this.contextValues) {
            if (jde.O000000o(str, (CharSequence) next.getKey())) {
                return next.getValue();
            }
        }
        return null;
    }

    public Set<String> getContextLabels() {
        HashSet hashSet = new HashSet();
        for (Pair<String, Object> key : this.contextValues) {
            hashSet.add(key.getKey());
        }
        return hashSet;
    }

    public List<Pair<String, Object>> getContextEntries() {
        return this.contextValues;
    }

    public String getFormattedExceptionMessage(String str) {
        String str2;
        StringBuilder sb = new StringBuilder(256);
        if (str != null) {
            sb.append(str);
        }
        if (this.contextValues.size() > 0) {
            if (sb.length() > 0) {
                sb.append(10);
            }
            sb.append("Exception Context:\n");
            int i = 0;
            for (Pair next : this.contextValues) {
                sb.append("\t[");
                i++;
                sb.append(i);
                sb.append(':');
                sb.append((String) next.getKey());
                sb.append("=");
                Object value = next.getValue();
                if (value == null) {
                    sb.append("null");
                } else {
                    try {
                        str2 = value.toString();
                    } catch (Exception e) {
                        str2 = "Exception thrown on toString(): " + jdi.O000000o(e);
                    }
                    sb.append(str2);
                }
                sb.append("]\n");
            }
            sb.append("---------------------------------");
        }
        return sb.toString();
    }

    public /* synthetic */ jdh setContextValue(String str, Object obj) {
        Iterator<Pair<String, Object>> it = this.contextValues.iterator();
        while (it.hasNext()) {
            if (jde.O000000o(str, (CharSequence) it.next().getKey())) {
                it.remove();
            }
        }
        addContextValue(str, obj);
        return this;
    }
}
