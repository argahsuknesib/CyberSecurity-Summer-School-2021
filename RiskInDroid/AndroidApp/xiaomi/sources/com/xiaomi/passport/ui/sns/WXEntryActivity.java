package com.xiaomi.passport.ui.sns;

import _m_j.eft;
import _m_j.egt;
import _m_j.eig;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014¨\u0006\u0007"}, d2 = {"Lcom/xiaomi/passport/ui/sns/WXEntryActivity;", "Landroid/app/Activity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public final class WXEntryActivity extends Activity {

    /* renamed from: O000000o  reason: collision with root package name */
    private HashMap f6326O000000o;

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.f6326O000000o;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i) {
        if (this.f6326O000000o == null) {
            this.f6326O000000o = new HashMap();
        }
        View view = (View) this.f6326O000000o.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f6326O000000o.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        egt egt = egt.f15254O000000o;
        eft O000000o2 = egt.O000000o("WECHAT_AUTH_PROVIDER");
        if (!(O000000o2 instanceof eig)) {
            O000000o2 = null;
        }
        eig eig = (eig) O000000o2;
        if (eig != null) {
            eig.O000000o(this, getIntent());
        }
        finish();
    }
}
