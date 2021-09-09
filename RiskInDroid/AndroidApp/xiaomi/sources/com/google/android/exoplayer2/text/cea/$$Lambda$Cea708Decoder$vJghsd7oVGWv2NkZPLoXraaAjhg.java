package com.google.android.exoplayer2.text.cea;

import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import java.util.Comparator;

/* renamed from: com.google.android.exoplayer2.text.cea.-$$Lambda$Cea708Decoder$vJghsd7oVGWv2NkZPLoXraaAjhg  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$Cea708Decoder$vJghsd7oVGWv2NkZPLoXraaAjhg implements Comparator {
    public static final /* synthetic */ $$Lambda$Cea708Decoder$vJghsd7oVGWv2NkZPLoXraaAjhg INSTANCE = new $$Lambda$Cea708Decoder$vJghsd7oVGWv2NkZPLoXraaAjhg();

    private /* synthetic */ $$Lambda$Cea708Decoder$vJghsd7oVGWv2NkZPLoXraaAjhg() {
    }

    public final int compare(Object obj, Object obj2) {
        return Integer.compare(((Cea708Decoder.Cea708CueInfo) obj).priority, ((Cea708Decoder.Cea708CueInfo) obj2).priority);
    }
}
