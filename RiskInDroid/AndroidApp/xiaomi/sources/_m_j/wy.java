package _m_j;

import com.drew.imaging.riff.RiffProcessingException;
import java.io.IOException;

public final class wy {
    private void O000000o(xm xmVar, int i, wx wxVar) throws IOException {
        while (xmVar.O000000o() < ((long) i)) {
            String str = new String(xmVar.O000000o(4));
            int O0000OOo = xmVar.O0000OOo();
            if (!str.equals("LIST") && !str.equals("RIFF")) {
                if (wxVar.O00000Oo(str)) {
                    wxVar.O000000o(str, xmVar.O000000o(O0000OOo));
                } else {
                    xmVar.O000000o((long) O0000OOo);
                }
                if (O0000OOo % 2 == 1) {
                    xmVar.O000000o(1L);
                }
            } else if (wxVar.O00000o0(new String(xmVar.O000000o(4)))) {
                O000000o(xmVar, O0000OOo - 4, wxVar);
            } else {
                xmVar.O000000o((long) (O0000OOo - 4));
            }
        }
    }

    public final void O000000o(xm xmVar, wx wxVar) throws RiffProcessingException, IOException {
        xmVar.f2595O000000o = false;
        String O00000Oo = xmVar.O00000Oo(4);
        if (O00000Oo.equals("RIFF")) {
            int O0000OOo = xmVar.O0000OOo() - 4;
            if (wxVar.O000000o(xmVar.O00000Oo(4))) {
                O000000o(xmVar, O0000OOo, wxVar);
                return;
            }
            return;
        }
        throw new RiffProcessingException("Invalid RIFF header: ".concat(String.valueOf(O00000Oo)));
    }
}
