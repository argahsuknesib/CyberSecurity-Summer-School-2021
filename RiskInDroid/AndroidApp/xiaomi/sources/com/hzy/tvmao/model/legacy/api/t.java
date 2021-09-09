package com.hzy.tvmao.model.legacy.api;

import com.hzy.tvmao.model.legacy.api.data.UIProgramData;
import java.util.Comparator;

final class t implements Comparator<UIProgramData.ProgramItem> {
    t() {
    }

    /* renamed from: a */
    public final int compare(UIProgramData.ProgramItem programItem, UIProgramData.ProgramItem programItem2) {
        if (programItem.getFirstItem().ilike > programItem2.getFirstItem().ilike) {
            return -1;
        }
        return programItem.getFirstItem().ilike == programItem2.getFirstItem().ilike ? 0 : 1;
    }
}
