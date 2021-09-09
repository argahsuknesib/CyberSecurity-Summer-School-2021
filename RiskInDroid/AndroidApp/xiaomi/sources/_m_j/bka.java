package _m_j;

import android.content.Intent;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public final class bka extends bjz {
    private static final String[] O00000o = {"action.character_changed"};

    private bka(bkf bkf) {
        super(bkf);
    }

    public static bka O000000o(bkf bkf) {
        return new bka(bkf);
    }

    /* access modifiers changed from: package-private */
    public final List<String> O000000o() {
        return Arrays.asList(O00000o);
    }

    /* access modifiers changed from: package-private */
    public final boolean O000000o(Intent intent) {
        String stringExtra = intent.getStringExtra("extra.mac");
        UUID uuid = (UUID) intent.getSerializableExtra("extra.service.uuid");
        UUID uuid2 = (UUID) intent.getSerializableExtra("extra.character.uuid");
        byte[] byteArrayExtra = intent.getByteArrayExtra("extra.byte.value");
        for (bkm O000000o2 : O000000o(bkh.class)) {
            O000000o2.O000000o(stringExtra, uuid, uuid2, byteArrayExtra);
        }
        return true;
    }
}
