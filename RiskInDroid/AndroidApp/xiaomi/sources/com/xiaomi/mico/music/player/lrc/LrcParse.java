package com.xiaomi.mico.music.player.lrc;

import java.util.List;

interface LrcParse {
    List<LrcRow> getLrcRows(String str);
}
