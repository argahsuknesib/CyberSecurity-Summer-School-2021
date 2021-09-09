package com.squareup.okhttp.internal.framed;

import _m_j.jax;
import _m_j.jaz;
import _m_j.jbg;
import _m_j.jbn;
import android.support.v4.app.NotificationCompat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okio.ByteString;

final class Hpack {
    public static final Map<ByteString, Integer> NAME_TO_FIRST_INDEX = nameToFirstIndex();
    public static final Header[] STATIC_HEADER_TABLE = {new Header(Header.TARGET_AUTHORITY, ""), new Header(Header.TARGET_METHOD, "GET"), new Header(Header.TARGET_METHOD, "POST"), new Header(Header.TARGET_PATH, "/"), new Header(Header.TARGET_PATH, "/index.html"), new Header(Header.TARGET_SCHEME, "http"), new Header(Header.TARGET_SCHEME, "https"), new Header(Header.RESPONSE_STATUS, "200"), new Header(Header.RESPONSE_STATUS, "204"), new Header(Header.RESPONSE_STATUS, "206"), new Header(Header.RESPONSE_STATUS, "304"), new Header(Header.RESPONSE_STATUS, "400"), new Header(Header.RESPONSE_STATUS, "404"), new Header(Header.RESPONSE_STATUS, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};

    private Hpack() {
    }

    static final class Reader {
        Header[] dynamicTable = new Header[8];
        int dynamicTableByteCount = 0;
        int headerCount = 0;
        private final List<Header> headerList = new ArrayList();
        private int headerTableSizeSetting;
        private int maxDynamicTableByteCount;
        int nextHeaderIndex = (this.dynamicTable.length - 1);
        private final jaz source;

        Reader(int i, jbn jbn) {
            this.headerTableSizeSetting = i;
            this.maxDynamicTableByteCount = i;
            this.source = jbg.O000000o(jbn);
        }

        /* access modifiers changed from: package-private */
        public final int maxDynamicTableByteCount() {
            return this.maxDynamicTableByteCount;
        }

        /* access modifiers changed from: package-private */
        public final void headerTableSizeSetting(int i) {
            this.headerTableSizeSetting = i;
            this.maxDynamicTableByteCount = i;
            adjustDynamicTableByteCount();
        }

        private void adjustDynamicTableByteCount() {
            int i = this.maxDynamicTableByteCount;
            int i2 = this.dynamicTableByteCount;
            if (i >= i2) {
                return;
            }
            if (i == 0) {
                clearDynamicTable();
            } else {
                evictToRecoverBytes(i2 - i);
            }
        }

        private void clearDynamicTable() {
            this.headerList.clear();
            Arrays.fill(this.dynamicTable, (Object) null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private int evictToRecoverBytes(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    if (length < this.nextHeaderIndex || i <= 0) {
                        Header[] headerArr = this.dynamicTable;
                        int i3 = this.nextHeaderIndex;
                        System.arraycopy(headerArr, i3 + 1, headerArr, i3 + 1 + i2, this.headerCount);
                        this.nextHeaderIndex += i2;
                    } else {
                        i -= this.dynamicTable[length].hpackSize;
                        this.dynamicTableByteCount -= this.dynamicTable[length].hpackSize;
                        this.headerCount--;
                        i2++;
                    }
                }
                Header[] headerArr2 = this.dynamicTable;
                int i32 = this.nextHeaderIndex;
                System.arraycopy(headerArr2, i32 + 1, headerArr2, i32 + 1 + i2, this.headerCount);
                this.nextHeaderIndex += i2;
            }
            return i2;
        }

        /* access modifiers changed from: package-private */
        public final void readHeaders() throws IOException {
            while (!this.source.O00000o()) {
                byte O0000O0o = this.source.O0000O0o() & 255;
                if (O0000O0o == 128) {
                    throw new IOException("index == 0");
                } else if ((O0000O0o & 128) == 128) {
                    readIndexedHeader(readInt(O0000O0o, 127) - 1);
                } else if (O0000O0o == 64) {
                    readLiteralHeaderWithIncrementalIndexingNewName();
                } else if ((O0000O0o & 64) == 64) {
                    readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(O0000O0o, 63) - 1);
                } else if ((O0000O0o & 32) == 32) {
                    this.maxDynamicTableByteCount = readInt(O0000O0o, 31);
                    int i = this.maxDynamicTableByteCount;
                    if (i < 0 || i > this.headerTableSizeSetting) {
                        throw new IOException("Invalid dynamic table size update " + this.maxDynamicTableByteCount);
                    }
                    adjustDynamicTableByteCount();
                } else if (O0000O0o == 16 || O0000O0o == 0) {
                    readLiteralHeaderWithoutIndexingNewName();
                } else {
                    readLiteralHeaderWithoutIndexingIndexedName(readInt(O0000O0o, 15) - 1);
                }
            }
        }

        public final List<Header> getAndResetHeaderList() {
            ArrayList arrayList = new ArrayList(this.headerList);
            this.headerList.clear();
            return arrayList;
        }

        private void readIndexedHeader(int i) throws IOException {
            if (isStaticHeader(i)) {
                this.headerList.add(Hpack.STATIC_HEADER_TABLE[i]);
                return;
            }
            int dynamicTableIndex = dynamicTableIndex(i - Hpack.STATIC_HEADER_TABLE.length);
            if (dynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (dynamicTableIndex <= headerArr.length - 1) {
                    this.headerList.add(headerArr[dynamicTableIndex]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        private int dynamicTableIndex(int i) {
            return this.nextHeaderIndex + 1 + i;
        }

        private void readLiteralHeaderWithoutIndexingIndexedName(int i) throws IOException {
            this.headerList.add(new Header(getName(i), readByteString()));
        }

        private void readLiteralHeaderWithoutIndexingNewName() throws IOException {
            this.headerList.add(new Header(Hpack.checkLowercase(readByteString()), readByteString()));
        }

        private void readLiteralHeaderWithIncrementalIndexingIndexedName(int i) throws IOException {
            insertIntoDynamicTable(-1, new Header(getName(i), readByteString()));
        }

        private void readLiteralHeaderWithIncrementalIndexingNewName() throws IOException {
            insertIntoDynamicTable(-1, new Header(Hpack.checkLowercase(readByteString()), readByteString()));
        }

        private ByteString getName(int i) {
            if (isStaticHeader(i)) {
                return Hpack.STATIC_HEADER_TABLE[i].name;
            }
            return this.dynamicTable[dynamicTableIndex(i - Hpack.STATIC_HEADER_TABLE.length)].name;
        }

        private boolean isStaticHeader(int i) {
            return i >= 0 && i <= Hpack.STATIC_HEADER_TABLE.length - 1;
        }

        private void insertIntoDynamicTable(int i, Header header) {
            this.headerList.add(header);
            int i2 = header.hpackSize;
            if (i != -1) {
                i2 -= this.dynamicTable[dynamicTableIndex(i)].hpackSize;
            }
            int i3 = this.maxDynamicTableByteCount;
            if (i2 > i3) {
                clearDynamicTable();
                return;
            }
            int evictToRecoverBytes = evictToRecoverBytes((this.dynamicTableByteCount + i2) - i3);
            if (i == -1) {
                int i4 = this.headerCount + 1;
                Header[] headerArr = this.dynamicTable;
                if (i4 > headerArr.length) {
                    Header[] headerArr2 = new Header[(headerArr.length * 2)];
                    System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                    this.nextHeaderIndex = this.dynamicTable.length - 1;
                    this.dynamicTable = headerArr2;
                }
                int i5 = this.nextHeaderIndex;
                this.nextHeaderIndex = i5 - 1;
                this.dynamicTable[i5] = header;
                this.headerCount++;
            } else {
                this.dynamicTable[i + dynamicTableIndex(i) + evictToRecoverBytes] = header;
            }
            this.dynamicTableByteCount += i2;
        }

        private int readByte() throws IOException {
            return this.source.O0000O0o() & 255;
        }

        /* access modifiers changed from: package-private */
        public final int readInt(int i, int i2) throws IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int readByte = readByte();
                if ((readByte & NotificationCompat.FLAG_HIGH_PRIORITY) == 0) {
                    return i2 + (readByte << i4);
                }
                i2 += (readByte & 127) << i4;
                i4 += 7;
            }
        }

        /* access modifiers changed from: package-private */
        public final ByteString readByteString() throws IOException {
            int readByte = readByte();
            boolean z = (readByte & NotificationCompat.FLAG_HIGH_PRIORITY) == 128;
            int readInt = readInt(readByte, 127);
            if (z) {
                return ByteString.O000000o(Huffman.get().decode(this.source.O0000OOo((long) readInt)));
            }
            return this.source.O00000o((long) readInt);
        }
    }

    private static Map<ByteString, Integer> nameToFirstIndex() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(STATIC_HEADER_TABLE.length);
        int i = 0;
        while (true) {
            Header[] headerArr = STATIC_HEADER_TABLE;
            if (i >= headerArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(headerArr[i].name)) {
                linkedHashMap.put(STATIC_HEADER_TABLE[i].name, Integer.valueOf(i));
            }
            i++;
        }
    }

    static final class Writer {
        private final jax out;

        Writer(jax jax) {
            this.out = jax;
        }

        /* access modifiers changed from: package-private */
        public final void writeHeaders(List<Header> list) throws IOException {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ByteString O0000O0o = list.get(i).name.O0000O0o();
                Integer num = Hpack.NAME_TO_FIRST_INDEX.get(O0000O0o);
                if (num != null) {
                    writeInt(num.intValue() + 1, 15, 0);
                    writeByteString(list.get(i).value);
                } else {
                    this.out.O0000Oo(0);
                    writeByteString(O0000O0o);
                    writeByteString(list.get(i).value);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void writeInt(int i, int i2, int i3) throws IOException {
            if (i < i2) {
                this.out.O0000Oo(i | i3);
                return;
            }
            this.out.O0000Oo(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.out.O0000Oo(128 | (i4 & 127));
                i4 >>>= 7;
            }
            this.out.O0000Oo(i4);
        }

        /* access modifiers changed from: package-private */
        public final void writeByteString(ByteString byteString) throws IOException {
            writeInt(byteString.O0000OOo(), 127, 0);
            this.out.O00000o0(byteString);
        }
    }

    public static ByteString checkLowercase(ByteString byteString) throws IOException {
        int O0000OOo = byteString.O0000OOo();
        int i = 0;
        while (i < O0000OOo) {
            byte O000000o2 = byteString.O000000o(i);
            if (O000000o2 < 65 || O000000o2 > 90) {
                i++;
            } else {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.O000000o());
            }
        }
        return byteString;
    }
}
