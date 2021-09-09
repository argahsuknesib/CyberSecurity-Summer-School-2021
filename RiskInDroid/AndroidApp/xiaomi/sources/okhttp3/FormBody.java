package okhttp3;

import _m_j.jax;
import _m_j.jay;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.Util;

public final class FormBody extends RequestBody {
    private static final MediaType CONTENT_TYPE = MediaType.get("application/x-www-form-urlencoded");
    private final List<String> encodedNames;
    private final List<String> encodedValues;

    FormBody(List<String> list, List<String> list2) {
        this.encodedNames = Util.immutableList(list);
        this.encodedValues = Util.immutableList(list2);
    }

    public final int size() {
        return this.encodedNames.size();
    }

    public final String encodedName(int i) {
        return this.encodedNames.get(i);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: okhttp3.HttpUrl.percentDecode(java.lang.String, boolean):java.lang.String
     arg types: [java.lang.String, int]
     candidates:
      okhttp3.HttpUrl.percentDecode(java.util.List<java.lang.String>, boolean):java.util.List<java.lang.String>
      okhttp3.HttpUrl.percentDecode(java.lang.String, boolean):java.lang.String */
    public final String name(int i) {
        return HttpUrl.percentDecode(encodedName(i), true);
    }

    public final String encodedValue(int i) {
        return this.encodedValues.get(i);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: okhttp3.HttpUrl.percentDecode(java.lang.String, boolean):java.lang.String
     arg types: [java.lang.String, int]
     candidates:
      okhttp3.HttpUrl.percentDecode(java.util.List<java.lang.String>, boolean):java.util.List<java.lang.String>
      okhttp3.HttpUrl.percentDecode(java.lang.String, boolean):java.lang.String */
    public final String value(int i) {
        return HttpUrl.percentDecode(encodedValue(i), true);
    }

    public final MediaType contentType() {
        return CONTENT_TYPE;
    }

    public final long contentLength() {
        return writeOrCountBytes(null, true);
    }

    public final void writeTo(jay jay) throws IOException {
        writeOrCountBytes(jay, false);
    }

    private long writeOrCountBytes(jay jay, boolean z) {
        jax jax;
        if (z) {
            jax = new jax();
        } else {
            jax = jay.O000000o();
        }
        int size = this.encodedNames.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                jax.O0000Oo(38);
            }
            jax.O00000Oo(this.encodedNames.get(i));
            jax.O0000Oo(61);
            jax.O00000Oo(this.encodedValues.get(i));
        }
        if (!z) {
            return 0;
        }
        long j = jax.O00000Oo;
        jax.O0000oOo();
        return j;
    }

    public static final class Builder {
        private final Charset charset;
        private final List<String> names;
        private final List<String> values;

        public Builder() {
            this(null);
        }

        public Builder(Charset charset2) {
            this.names = new ArrayList();
            this.values = new ArrayList();
            this.charset = charset2;
        }

        public final Builder add(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (str2 != null) {
                this.names.add(HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.charset));
                this.values.add(HttpUrl.canonicalize(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.charset));
                return this;
            } else {
                throw new NullPointerException("value == null");
            }
        }

        public final Builder addEncoded(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (str2 != null) {
                this.names.add(HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.charset));
                this.values.add(HttpUrl.canonicalize(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.charset));
                return this;
            } else {
                throw new NullPointerException("value == null");
            }
        }

        public final FormBody build() {
            return new FormBody(this.names, this.values);
        }
    }
}
