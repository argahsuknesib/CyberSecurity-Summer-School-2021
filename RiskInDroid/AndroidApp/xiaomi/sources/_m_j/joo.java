package _m_j;

import _m_j.jol;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class joo implements jol, Closeable {

    /* renamed from: O000000o  reason: collision with root package name */
    private final int f2000O000000o = 1179403647;
    private final FileChannel O00000Oo;

    public joo(File file) throws FileNotFoundException {
        if (file == null || !file.exists()) {
            throw new IllegalArgumentException("File is null or does not exist");
        }
        this.O00000Oo = new FileInputStream(file).getChannel();
    }

    public final List<String> O000000o() throws IOException {
        jol.O00000Oo o00000Oo;
        long j;
        long j2;
        long j3;
        this.O00000Oo.position(0L);
        ArrayList arrayList = new ArrayList();
        this.O00000Oo.position(0L);
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        if (O00000Oo(allocate, 0) == 1179403647) {
            short O00000oO = O00000oO(allocate, 4);
            boolean z = O00000oO(allocate, 5) == 2;
            if (O00000oO == 1) {
                o00000Oo = new jom(z, this);
            } else if (O00000oO == 2) {
                o00000Oo = new jon(z, this);
            } else {
                throw new IllegalStateException("Invalid class type!");
            }
            ByteBuffer allocate2 = ByteBuffer.allocate(8);
            allocate2.order(o00000Oo.f1997O000000o ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
            long j4 = (long) o00000Oo.O00000oo;
            if (j4 == 65535) {
                j4 = o00000Oo.O000000o().f1998O000000o;
            }
            long j5 = 0;
            while (true) {
                if (j5 >= j4) {
                    j = j4;
                    j2 = 0;
                    break;
                }
                jol.O00000o0 O000000o2 = o00000Oo.O000000o(j5);
                j = j4;
                if (O000000o2.f1999O000000o == 2) {
                    j2 = O000000o2.O00000Oo;
                    break;
                }
                j5++;
                j4 = j;
            }
            if (j2 == 0) {
                return Collections.unmodifiableList(arrayList);
            }
            ArrayList<Long> arrayList2 = new ArrayList<>();
            long j6 = 0;
            int i = 0;
            while (true) {
                jol.O000000o O000000o3 = o00000Oo.O000000o(j2, i);
                if (O000000o3.f1996O000000o == 1) {
                    arrayList2.add(Long.valueOf(O000000o3.O00000Oo));
                    j3 = 5;
                } else {
                    j3 = 5;
                    if (O000000o3.f1996O000000o == 5) {
                        j6 = O000000o3.O00000Oo;
                    }
                }
                i++;
                if (O000000o3.f1996O000000o == 0) {
                    break;
                }
            }
            if (j6 != 0) {
                long O000000o4 = O000000o(o00000Oo, j, j6);
                for (Long longValue : arrayList2) {
                    arrayList.add(O00000o(allocate2, longValue.longValue() + O000000o4));
                }
                return arrayList;
            }
            throw new IllegalStateException("String table offset not found!");
        }
        throw new IllegalArgumentException("Invalid ELF Magic!");
    }

    private static long O000000o(jol.O00000Oo o00000Oo, long j, long j2) throws IOException {
        for (long j3 = 0; j3 < j; j3++) {
            jol.O00000o0 O000000o2 = o00000Oo.O000000o(j3);
            if (O000000o2.f1999O000000o == 1 && O000000o2.O00000o0 <= j2 && j2 <= O000000o2.O00000o0 + O000000o2.O00000o) {
                return (j2 - O000000o2.O00000o0) + O000000o2.O00000Oo;
            }
        }
        throw new IllegalStateException("Could not map vma to file offset!");
    }

    public final void close() throws IOException {
        this.O00000Oo.close();
    }

    private String O00000o(ByteBuffer byteBuffer, long j) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            long j2 = 1 + j;
            short O00000oO = O00000oO(byteBuffer, j);
            if (O00000oO == 0) {
                return sb.toString();
            }
            sb.append((char) O00000oO);
            j = j2;
        }
    }

    /* access modifiers changed from: protected */
    public final long O000000o(ByteBuffer byteBuffer, long j) throws IOException {
        O000000o(byteBuffer, j, 8);
        return byteBuffer.getLong();
    }

    /* access modifiers changed from: protected */
    public final long O00000Oo(ByteBuffer byteBuffer, long j) throws IOException {
        O000000o(byteBuffer, j, 4);
        return ((long) byteBuffer.getInt()) & 4294967295L;
    }

    /* access modifiers changed from: protected */
    public final int O00000o0(ByteBuffer byteBuffer, long j) throws IOException {
        O000000o(byteBuffer, j, 2);
        return byteBuffer.getShort() & 65535;
    }

    private short O00000oO(ByteBuffer byteBuffer, long j) throws IOException {
        O000000o(byteBuffer, j, 1);
        return (short) (byteBuffer.get() & 255);
    }

    private void O000000o(ByteBuffer byteBuffer, long j, int i) throws IOException {
        byteBuffer.position(0);
        byteBuffer.limit(i);
        long j2 = 0;
        while (j2 < ((long) i)) {
            int read = this.O00000Oo.read(byteBuffer, j + j2);
            if (read != -1) {
                j2 += (long) read;
            } else {
                throw new EOFException();
            }
        }
        byteBuffer.position(0);
    }
}
