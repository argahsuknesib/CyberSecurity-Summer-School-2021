package com.squareup.okhttp.internal.framed;

import _m_j.jax;
import _m_j.jaz;
import _m_j.jbc;
import _m_j.jbf;
import _m_j.jbg;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import okio.ByteString;

class NameValueBlockReader {
    public int compressedLimit;
    private final jbf inflaterSource;
    private final jaz source = jbg.O000000o(this.inflaterSource);

    public NameValueBlockReader(jaz jaz) {
        this.inflaterSource = new jbf(new jbc(jaz) {
            /* class com.squareup.okhttp.internal.framed.NameValueBlockReader.AnonymousClass1 */

            public long read(jax jax, long j) throws IOException {
                if (NameValueBlockReader.this.compressedLimit == 0) {
                    return -1;
                }
                long read = super.read(jax, Math.min(j, (long) NameValueBlockReader.this.compressedLimit));
                if (read == -1) {
                    return -1;
                }
                NameValueBlockReader nameValueBlockReader = NameValueBlockReader.this;
                nameValueBlockReader.compressedLimit = (int) (((long) nameValueBlockReader.compressedLimit) - read);
                return read;
            }
        }, new Inflater() {
            /* class com.squareup.okhttp.internal.framed.NameValueBlockReader.AnonymousClass2 */

            public int inflate(byte[] bArr, int i, int i2) throws DataFormatException {
                int inflate = super.inflate(bArr, i, i2);
                if (inflate != 0 || !needsDictionary()) {
                    return inflate;
                }
                setDictionary(Spdy3.DICTIONARY);
                return super.inflate(bArr, i, i2);
            }
        });
    }

    public List<Header> readNameValueBlock(int i) throws IOException {
        this.compressedLimit += i;
        int O0000Oo0 = this.source.O0000Oo0();
        if (O0000Oo0 < 0) {
            throw new IOException("numberOfPairs < 0: ".concat(String.valueOf(O0000Oo0)));
        } else if (O0000Oo0 <= 1024) {
            ArrayList arrayList = new ArrayList(O0000Oo0);
            int i2 = 0;
            while (i2 < O0000Oo0) {
                ByteString O0000O0o = readByteString().O0000O0o();
                ByteString readByteString = readByteString();
                if (O0000O0o.O0000OOo() != 0) {
                    arrayList.add(new Header(O0000O0o, readByteString));
                    i2++;
                } else {
                    throw new IOException("name.size == 0");
                }
            }
            doneReading();
            return arrayList;
        } else {
            throw new IOException("numberOfPairs > 1024: ".concat(String.valueOf(O0000Oo0)));
        }
    }

    private ByteString readByteString() throws IOException {
        return this.source.O00000o((long) this.source.O0000Oo0());
    }

    private void doneReading() throws IOException {
        if (this.compressedLimit > 0) {
            this.inflaterSource.O000000o();
            if (this.compressedLimit != 0) {
                throw new IOException("compressedLimit > 0: " + this.compressedLimit);
            }
        }
    }

    public void close() throws IOException {
        this.source.close();
    }
}
