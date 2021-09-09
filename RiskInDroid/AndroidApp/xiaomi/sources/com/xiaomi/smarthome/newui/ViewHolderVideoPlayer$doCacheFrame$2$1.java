package com.xiaomi.smarthome.newui;

import _m_j.iuh;
import _m_j.iwb;
import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
final class ViewHolderVideoPlayer$doCacheFrame$2$1 extends Lambda implements iwb<iuh> {
    final /* synthetic */ Bitmap $blur;
    final /* synthetic */ String $did;
    final /* synthetic */ ViewHolderVideoPlayer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ViewHolderVideoPlayer$doCacheFrame$2$1(ViewHolderVideoPlayer viewHolderVideoPlayer, String str, Bitmap bitmap) {
        super(0);
        this.this$0 = viewHolderVideoPlayer;
        this.$did = str;
        this.$blur = bitmap;
    }

    public final /* synthetic */ Object invoke() {
        this.this$0.O00000Oo.O000000o(this.$did, this.$blur, true);
        return iuh.f1631O000000o;
    }
}
