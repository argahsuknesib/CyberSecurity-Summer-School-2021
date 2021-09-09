package com.hzy.tvmao.model.legacy.api;

import com.kookong.app.data.ProgramData;
import java.util.Comparator;

final class r implements Comparator<ProgramData.PairProgram> {
    r() {
    }

    /* renamed from: a */
    public final int compare(ProgramData.PairProgram pairProgram, ProgramData.PairProgram pairProgram2) {
        if (pairProgram.ishd > pairProgram2.ishd) {
            return -1;
        }
        return pairProgram.ishd == pairProgram2.ishd ? 0 : 1;
    }
}
