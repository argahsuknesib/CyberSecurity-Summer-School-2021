package _m_j;

import java.util.UUID;

public final class bjm extends bjl implements bjd {
    private UUID O0000Oo;
    private UUID O0000OoO;

    public bjm(UUID uuid, UUID uuid2, bjr bjr) {
        super(bjr);
        this.O0000Oo = uuid;
        this.O0000OoO = uuid2;
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

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bjl.O000000o(java.util.UUID, java.util.UUID, boolean):boolean
     arg types: [java.util.UUID, java.util.UUID, int]
     candidates:
      _m_j.bjl.O000000o(java.util.UUID, java.util.UUID, java.util.UUID):boolean
      _m_j.bjl.O000000o(java.util.UUID, java.util.UUID, byte[]):boolean
      _m_j.bit.O000000o(java.util.UUID, java.util.UUID, java.util.UUID):boolean
      _m_j.bit.O000000o(java.util.UUID, java.util.UUID, byte[]):boolean
      _m_j.bjl.O000000o(java.util.UUID, java.util.UUID, boolean):boolean */
    private void O0000o0() {
        if (!O000000o(this.O0000Oo, this.O0000OoO, false)) {
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
