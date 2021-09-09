package _m_j;

import android.graphics.Bitmap;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/xiaomi/passport/ui/internal/Captcha;", "", "bitmap", "Landroid/graphics/Bitmap;", "ick", "", "captchaUrl", "(Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;)V", "getBitmap", "()Landroid/graphics/Bitmap;", "getCaptchaUrl", "()Ljava/lang/String;", "getIck", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public final class efz {

    /* renamed from: O000000o  reason: collision with root package name */
    public final Bitmap f15237O000000o;
    public final String O00000Oo;
    final String O00000o0;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof efz)) {
            return false;
        }
        efz efz = (efz) obj;
        return ixe.O000000o(this.f15237O000000o, efz.f15237O000000o) && ixe.O000000o(this.O00000Oo, efz.O00000Oo) && ixe.O000000o(this.O00000o0, efz.O00000o0);
    }

    public final int hashCode() {
        Bitmap bitmap = this.f15237O000000o;
        int i = 0;
        int hashCode = (bitmap != null ? bitmap.hashCode() : 0) * 31;
        String str = this.O00000Oo;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.O00000o0;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public final String toString() {
        return "Captcha(bitmap=" + this.f15237O000000o + ", ick=" + this.O00000Oo + ", captchaUrl=" + this.O00000o0 + ")";
    }

    public efz(Bitmap bitmap, String str, String str2) {
        ixe.O00000o0(str, "ick");
        ixe.O00000o0(str2, "captchaUrl");
        this.f15237O000000o = bitmap;
        this.O00000Oo = str;
        this.O00000o0 = str2;
    }
}
