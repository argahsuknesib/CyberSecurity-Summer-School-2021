package _m_j;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;
import java.util.Arrays;

public final class ajl implements aim {

    /* renamed from: O000000o  reason: collision with root package name */
    protected O00000Oo f12405O000000o = new O000000o();
    protected O00000Oo O00000Oo = new O00000o0();
    protected int O00000o = 0;
    protected boolean O00000o0 = true;

    public interface O00000Oo {
        void O000000o(JsonGenerator jsonGenerator, int i) throws IOException, JsonGenerationException;

        boolean O000000o();
    }

    public final void O000000o(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        jsonGenerator.O000000o(' ');
    }

    public final void O00000Oo(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        jsonGenerator.O000000o('{');
        if (!this.O00000Oo.O000000o()) {
            this.O00000o++;
        }
    }

    public final void O0000OOo(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        this.O00000Oo.O000000o(jsonGenerator, this.O00000o);
    }

    public final void O00000o(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        if (this.O00000o0) {
            jsonGenerator.O00000o0(" : ");
        } else {
            jsonGenerator.O000000o(':');
        }
    }

    public final void O00000o0(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        jsonGenerator.O000000o(',');
        this.O00000Oo.O000000o(jsonGenerator, this.O00000o);
    }

    public final void O000000o(JsonGenerator jsonGenerator, int i) throws IOException, JsonGenerationException {
        if (!this.O00000Oo.O000000o()) {
            this.O00000o--;
        }
        if (i > 0) {
            this.O00000Oo.O000000o(jsonGenerator, this.O00000o);
        } else {
            jsonGenerator.O000000o(' ');
        }
        jsonGenerator.O000000o('}');
    }

    public final void O00000oO(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        if (!this.f12405O000000o.O000000o()) {
            this.O00000o++;
        }
        jsonGenerator.O000000o('[');
    }

    public final void O0000O0o(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        this.f12405O000000o.O000000o(jsonGenerator, this.O00000o);
    }

    public final void O00000oo(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        jsonGenerator.O000000o(',');
        this.f12405O000000o.O000000o(jsonGenerator, this.O00000o);
    }

    public final void O00000Oo(JsonGenerator jsonGenerator, int i) throws IOException, JsonGenerationException {
        if (!this.f12405O000000o.O000000o()) {
            this.O00000o--;
        }
        if (i > 0) {
            this.f12405O000000o.O000000o(jsonGenerator, this.O00000o);
        } else {
            jsonGenerator.O000000o(' ');
        }
        jsonGenerator.O000000o(']');
    }

    public static class O000000o implements O00000Oo {
        public final boolean O000000o() {
            return true;
        }

        public final void O000000o(JsonGenerator jsonGenerator, int i) throws IOException, JsonGenerationException {
            jsonGenerator.O000000o(' ');
        }
    }

    public static class O00000o0 implements O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        static final String f12406O000000o;
        static final char[] O00000Oo;

        public final boolean O000000o() {
            return false;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{java.util.Arrays.fill(char[], char):void}
         arg types: [char[], int]
         candidates:
          ClspMth{java.util.Arrays.fill(double[], double):void}
          ClspMth{java.util.Arrays.fill(byte[], byte):void}
          ClspMth{java.util.Arrays.fill(long[], long):void}
          ClspMth{java.util.Arrays.fill(boolean[], boolean):void}
          ClspMth{java.util.Arrays.fill(short[], short):void}
          ClspMth{java.util.Arrays.fill(java.lang.Object[], java.lang.Object):void}
          ClspMth{java.util.Arrays.fill(int[], int):void}
          ClspMth{java.util.Arrays.fill(float[], float):void}
          ClspMth{java.util.Arrays.fill(char[], char):void} */
        static {
            String str;
            try {
                str = System.getProperty("line.separator");
            } catch (Throwable unused) {
                str = null;
            }
            if (str == null) {
                str = "\n";
            }
            f12406O000000o = str;
            char[] cArr = new char[64];
            O00000Oo = cArr;
            Arrays.fill(cArr, ' ');
        }

        public final void O000000o(JsonGenerator jsonGenerator, int i) throws IOException, JsonGenerationException {
            jsonGenerator.O00000o0(f12406O000000o);
            int i2 = i + i;
            while (i2 > 64) {
                jsonGenerator.O000000o(O00000Oo, 64);
                i2 -= O00000Oo.length;
            }
            jsonGenerator.O000000o(O00000Oo, i2);
        }
    }
}
