package com.xiaomi.smarthome.newui;

import _m_j.ayq;
import _m_j.ft;
import _m_j.go;
import _m_j.gpc;
import _m_j.gzl;
import _m_j.gzr;
import _m_j.gzu;
import _m_j.gzv;
import _m_j.hat;
import _m_j.hbg;
import _m_j.hbo;
import _m_j.hbs;
import _m_j.hft;
import _m_j.hgb;
import _m_j.hgd;
import _m_j.hgg;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.newui.mainpage.MviRecyclerView;
import com.xiaomi.smarthome.newui.mainpage.devicepage.model.MainPageDeviceModel;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import java.lang.ref.WeakReference;
import java.util.List;

public class DeviceRecycler extends MviRecyclerView<hgg, hgb> implements hgg {

    /* renamed from: O000000o  reason: collision with root package name */
    gzu f10087O000000o;
    hft O00000Oo;
    PublishSubject<Boolean> O00000o;
    public gzv O00000o0;
    private hbs O00000oo;
    private gzl O0000O0o;
    private final BroadcastReceiver O0000OOo;

    public DeviceRecycler(Context context) {
        this(context, null);
    }

    public DeviceRecycler(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DeviceRecycler(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O00000o0 = gzv.O000000o();
        this.O00000o = PublishSubject.create();
        this.O0000OOo = new BroadcastReceiver() {
            /* class com.xiaomi.smarthome.newui.DeviceRecycler.AnonymousClass2 */

            public final void onReceive(Context context, Intent intent) {
                if (intent != null) {
                    String action = intent.getAction();
                    if (TextUtils.equals("action_on_logout", action)) {
                        DeviceRecycler.this.O00000o0.O00000o0();
                    } else if (TextUtils.equals(action, "action_room_selected")) {
                        DeviceRecycler.this.O00000o0.O000000o(intent.getStringExtra("extra_room_selected_id"));
                        DeviceRecycler.this.f10087O000000o.notifyDataSetChanged();
                    }
                }
            }
        };
        setItemViewCacheSize(5);
        setHasFixedSize(false);
        setNestedScrollingEnabled(true);
        setLayoutManager(new GridLayoutManager(getContext()) {
            /* class com.xiaomi.smarthome.newui.DeviceRecycler.AnonymousClass1 */

            public final boolean supportsPredictiveItemAnimations() {
                return false;
            }
        });
        go goVar = new go();
        goVar.O0000o00 = false;
        setItemAnimator(goVar);
        hbs hbs = new hbs(new hbg(gpc.O000000o(8.0f)), (byte) 0);
        hbs.O0000OOo = "fix_place_holder";
        this.O0000O0o = new gzl();
        this.f10087O000000o = new gzu();
        this.O00000Oo = new hft();
        this.O00000oo = new hbs(new hbo(), (byte) 0);
        this.O0000O0o.O000000o(this.f10087O000000o);
        this.O0000O0o.O000000o(this.O00000Oo);
        this.O0000O0o.O000000o(this.O00000oo);
        this.O0000O0o.O000000o(hbs);
        this.O0000O0o.O000000o(new hat(CommonApplication.getAppContext().getResources().getDimensionPixelOffset(R.dimen.bottom_bar_edit_height)));
        this.O0000O0o.O00000Oo(new hbo());
        setAdapter(this.O0000O0o);
    }

    public void setPage(gzr gzr) {
        this.O00000Oo.O00000Oo = new WeakReference<>(gzr);
    }

    public final Observable<Boolean> O00000Oo() {
        return this.O00000o;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_room_selected");
        intentFilter.addAction("action_on_logout");
        ft.O000000o(CommonApplication.getAppContext()).O000000o(this.O0000OOo, intentFilter);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ft.O000000o(CommonApplication.getAppContext()).O000000o(this.O0000OOo);
        this.O00000o0.O00000o0();
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        RecyclerView.O000000o adapter = getAdapter();
        if (adapter instanceof gzl) {
            ((gzl) adapter).O000000o(this);
        }
    }

    public void O000000o(hgd hgd) {
        List<MainPageDeviceModel> list = hgd.f18895O000000o;
        this.O00000Oo.O000000o(hgd.O00000Oo, hgd.f18895O000000o);
        this.O00000oo.O000000o(list.isEmpty());
        ((hbs) this.O0000O0o.O000000o("fix_place_holder")).O000000o(list.size() > 0);
    }

    public /* synthetic */ ayq createPresenter() {
        return new hgb();
    }
}
