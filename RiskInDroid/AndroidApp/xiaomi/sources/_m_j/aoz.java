package _m_j;

import _m_j.ape;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class aoz extends ape<aoz> {
    protected ArrayList<ajx> O00000o0;

    public aoz(api api) {
        super(api);
    }

    public final int O00000Oo() {
        ArrayList<ajx> arrayList = this.O00000o0;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final Iterator<ajx> O00000o0() {
        ArrayList<ajx> arrayList = this.O00000o0;
        return arrayList == null ? ape.O000000o.O000000o() : arrayList.iterator();
    }

    public final void O000000o(JsonGenerator jsonGenerator, akf akf) throws IOException, JsonProcessingException {
        jsonGenerator.O00000Oo();
        ArrayList<ajx> arrayList = this.O00000o0;
        if (arrayList != null) {
            Iterator<ajx> it = arrayList.iterator();
            while (it.hasNext()) {
                ((apa) it.next()).O000000o(jsonGenerator, akf);
            }
        }
        jsonGenerator.O00000o0();
    }

    public final void O000000o(JsonGenerator jsonGenerator, akf akf, aoi aoi) throws IOException, JsonProcessingException {
        aoi.O00000o0(this, jsonGenerator);
        ArrayList<ajx> arrayList = this.O00000o0;
        if (arrayList != null) {
            Iterator<ajx> it = arrayList.iterator();
            while (it.hasNext()) {
                ((apa) it.next()).O000000o(jsonGenerator, akf);
            }
        }
        aoi.O00000oo(this, jsonGenerator);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        aoz aoz = (aoz) obj;
        ArrayList<ajx> arrayList = this.O00000o0;
        if (arrayList == null || arrayList.size() == 0) {
            return aoz.O00000Oo() == 0;
        }
        ArrayList<ajx> arrayList2 = this.O00000o0;
        int size = arrayList2.size();
        if (aoz.O00000Oo() != size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!aoz.O00000o0.get(i).equals(arrayList2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        ArrayList<ajx> arrayList = this.O00000o0;
        if (arrayList == null) {
            return 1;
        }
        int size = arrayList.size();
        Iterator<ajx> it = this.O00000o0.iterator();
        while (it.hasNext()) {
            ajx next = it.next();
            if (next != null) {
                size ^= next.hashCode();
            }
        }
        return size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((O00000Oo() << 4) + 16);
        sb.append('[');
        ArrayList<ajx> arrayList = this.O00000o0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (i > 0) {
                    sb.append(',');
                }
                sb.append(this.O00000o0.get(i).toString());
            }
        }
        sb.append(']');
        return sb.toString();
    }

    private aoz O00000Oo(ajx ajx) {
        if (this.O00000o0 == null) {
            this.O00000o0 = new ArrayList<>();
        }
        this.O00000o0.add(ajx);
        return this;
    }

    public final aoz O000000o(ajx ajx) {
        if (ajx == null) {
            ajx = api.O000000o();
        }
        O00000Oo(ajx);
        return this;
    }
}
