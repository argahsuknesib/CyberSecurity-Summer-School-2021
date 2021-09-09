package _m_j;

import com.drew.imaging.png.PngProcessingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class wr {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final byte[] f2582O000000o = {-119, 80, 78, 71, 13, 10, 26, 10};

    public static Iterable<wq> O000000o(xm xmVar, Set<ws> set) throws PngProcessingException, IOException {
        xmVar.f2595O000000o = true;
        byte[] bArr = f2582O000000o;
        if (Arrays.equals(bArr, xmVar.O000000o(bArr.length))) {
            ArrayList arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                int O0000OOo = xmVar.O0000OOo();
                if (O0000OOo >= 0) {
                    ws wsVar = new ws(xmVar.O000000o(4));
                    boolean z3 = set == null || set.contains(wsVar);
                    byte[] O000000o2 = xmVar.O000000o(O0000OOo);
                    xmVar.O000000o(4L);
                    if (!z3 || !hashSet.contains(wsVar) || wsVar.O0000oO) {
                        if (wsVar.equals(ws.f2583O000000o)) {
                            z2 = true;
                        } else if (!z2) {
                            throw new PngProcessingException(String.format("First chunk should be '%s', but '%s' was observed", ws.f2583O000000o, wsVar));
                        }
                        if (wsVar.equals(ws.O00000o)) {
                            z = true;
                        }
                        if (z3) {
                            arrayList.add(new wq(wsVar, O000000o2));
                        }
                        hashSet.add(wsVar);
                    } else {
                        throw new PngProcessingException(String.format("Observed multiple instances of PNG chunk '%s', for which multiples are not allowed", wsVar));
                    }
                } else {
                    throw new PngProcessingException("PNG chunk length exceeds maximum");
                }
            }
            return arrayList;
        }
        throw new PngProcessingException("PNG signature mismatch");
    }
}
