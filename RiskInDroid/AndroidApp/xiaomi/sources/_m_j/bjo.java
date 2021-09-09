package _m_j;

import java.util.UUID;

public final class bjo extends bjl implements bjc {
    private UUID O0000Oo;
    private UUID O0000OoO;
    private byte[] O0000Ooo;

    public bjo(UUID uuid, UUID uuid2, byte[] bArr, bjr bjr) {
        super(bjr);
        this.O0000Oo = uuid;
        this.O0000OoO = uuid2;
        this.O0000Ooo = bArr;
    }

    public final void O0000Oo0() {
        int O00000oO = O00000oO();
        if (O00000oO == 0) {
            O00000o0(-1);
        } else if (O00000oO == 2) {
            O0000o0();
        } else if (O00000oO != 19) {
            O00000o0(-1);
        } else {
            O0000o0();
        }
    }

    private void O0000o0() {
        if (!O00000Oo(this.O0000Oo, this.O0000OoO, this.O0000Ooo)) {
            O00000o0(-1);
        } else {
            O0000Ooo();
        }
    }

    public final void O000000o(int i) {
        O0000o00();
        if (i == 0) {
            O00000o0(0);
        } else {
            O00000o0(-1);
        }
    }
}
