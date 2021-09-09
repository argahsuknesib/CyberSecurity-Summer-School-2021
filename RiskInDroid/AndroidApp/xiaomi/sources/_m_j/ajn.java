package _m_j;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class ajn extends ajm {
    protected int O00000o = 1;
    protected final JsonParser[] O00000o0;

    private ajn(JsonParser[] jsonParserArr) {
        super(jsonParserArr[0]);
        this.O00000o0 = jsonParserArr;
    }

    public static ajn O000000o(JsonParser jsonParser, JsonParser jsonParser2) {
        boolean z = jsonParser instanceof ajn;
        if (z || (jsonParser2 instanceof ajn)) {
            ArrayList arrayList = new ArrayList();
            if (z) {
                ((ajn) jsonParser).O000000o(arrayList);
            } else {
                arrayList.add(jsonParser);
            }
            if (jsonParser2 instanceof ajn) {
                ((ajn) jsonParser2).O000000o(arrayList);
            } else {
                arrayList.add(jsonParser2);
            }
            return new ajn((JsonParser[]) arrayList.toArray(new JsonParser[arrayList.size()]));
        }
        return new ajn(new JsonParser[]{jsonParser, jsonParser2});
    }

    private void O000000o(List<JsonParser> list) {
        int length = this.O00000o0.length;
        for (int i = this.O00000o - 1; i < length; i++) {
            JsonParser jsonParser = this.O00000o0[i];
            if (jsonParser instanceof ajn) {
                ((ajn) jsonParser).O000000o(list);
            } else {
                list.add(jsonParser);
            }
        }
    }

    public final void close() throws IOException {
        do {
            this.O00000Oo.close();
        } while (O000O0OO());
    }

    public final JsonToken O00000Oo() throws IOException, JsonParseException {
        JsonToken O00000Oo = this.O00000Oo.O00000Oo();
        if (O00000Oo != null) {
            return O00000Oo;
        }
        while (O000O0OO()) {
            JsonToken O00000Oo2 = this.O00000Oo.O00000Oo();
            if (O00000Oo2 != null) {
                return O00000Oo2;
            }
        }
        return null;
    }

    private boolean O000O0OO() {
        int i = this.O00000o;
        JsonParser[] jsonParserArr = this.O00000o0;
        if (i >= jsonParserArr.length) {
            return false;
        }
        this.O00000o = i + 1;
        this.O00000Oo = jsonParserArr[i];
        return true;
    }
}
