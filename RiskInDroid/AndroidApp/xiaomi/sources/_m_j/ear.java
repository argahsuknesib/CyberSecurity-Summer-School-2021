package _m_j;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.service.bg;

final class ear extends ContentObserver {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ eao f15131O000000o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ear(eao eao, Handler handler) {
        super(handler);
        this.f15131O000000o = eao;
    }

    public final void onChange(boolean z) {
        eao eao = this.f15131O000000o;
        Integer unused = eao.O0000Ooo = Integer.valueOf(bg.a(eao.f15127O000000o).a());
        if (this.f15131O000000o.O0000Ooo.intValue() != 0) {
            this.f15131O000000o.f15127O000000o.getContentResolver().unregisterContentObserver(this);
            if (emf.O000000o(this.f15131O000000o.f15127O000000o)) {
                this.f15131O000000o.O00000o();
            }
        }
    }
}
