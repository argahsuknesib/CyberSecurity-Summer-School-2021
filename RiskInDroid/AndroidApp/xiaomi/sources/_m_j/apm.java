package _m_j;

import _m_j.ape;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class apm extends ape<apm> {
    protected LinkedHashMap<String, ajx> O00000o0 = null;

    public apm(api api) {
        super(api);
    }

    public final int O00000Oo() {
        LinkedHashMap<String, ajx> linkedHashMap = this.O00000o0;
        if (linkedHashMap == null) {
            return 0;
        }
        return linkedHashMap.size();
    }

    public final Iterator<ajx> O00000o0() {
        LinkedHashMap<String, ajx> linkedHashMap = this.O00000o0;
        return linkedHashMap == null ? ape.O000000o.O000000o() : linkedHashMap.values().iterator();
    }

    public final void O000000o(JsonGenerator jsonGenerator, akf akf) throws IOException, JsonProcessingException {
        jsonGenerator.O00000o();
        LinkedHashMap<String, ajx> linkedHashMap = this.O00000o0;
        if (linkedHashMap != null) {
            for (Map.Entry next : linkedHashMap.entrySet()) {
                jsonGenerator.O000000o((String) next.getKey());
                ((apa) next.getValue()).O000000o(jsonGenerator, akf);
            }
        }
        jsonGenerator.O00000oO();
    }

    public final void O000000o(JsonGenerator jsonGenerator, akf akf, aoi aoi) throws IOException, JsonProcessingException {
        aoi.O00000Oo(this, jsonGenerator);
        LinkedHashMap<String, ajx> linkedHashMap = this.O00000o0;
        if (linkedHashMap != null) {
            for (Map.Entry next : linkedHashMap.entrySet()) {
                jsonGenerator.O000000o((String) next.getKey());
                ((apa) next.getValue()).O000000o(jsonGenerator, akf);
            }
        }
        aoi.O00000oO(this, jsonGenerator);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0032  */
    public boolean equals(Object obj) {
        ajx ajx;
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        apm apm = (apm) obj;
        if (apm.O00000Oo() != O00000Oo()) {
            return false;
        }
        LinkedHashMap<String, ajx> linkedHashMap = this.O00000o0;
        if (linkedHashMap != null) {
            for (Map.Entry next : linkedHashMap.entrySet()) {
                String str = (String) next.getKey();
                ajx ajx2 = (ajx) next.getValue();
                LinkedHashMap<String, ajx> linkedHashMap2 = apm.O00000o0;
                if (linkedHashMap2 != null) {
                    ajx = linkedHashMap2.get(str);
                } else {
                    ajx = null;
                }
                if (ajx == null || !ajx.equals(ajx2)) {
                    return false;
                }
                while (r2.hasNext()) {
                }
            }
        }
        return true;
    }

    public int hashCode() {
        LinkedHashMap<String, ajx> linkedHashMap = this.O00000o0;
        if (linkedHashMap == null) {
            return -1;
        }
        return linkedHashMap.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((O00000Oo() << 4) + 32);
        sb.append("{");
        LinkedHashMap<String, ajx> linkedHashMap = this.O00000o0;
        if (linkedHashMap != null) {
            int i = 0;
            for (Map.Entry next : linkedHashMap.entrySet()) {
                if (i > 0) {
                    sb.append(",");
                }
                i++;
                apo.O000000o(sb, (String) next.getKey());
                sb.append(':');
                sb.append(((ajx) next.getValue()).toString());
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public final ajx O000000o(String str, ajx ajx) {
        if (this.O00000o0 == null) {
            this.O00000o0 = new LinkedHashMap<>();
        }
        return this.O00000o0.put(str, ajx);
    }
}
