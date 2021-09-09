package com.xiaomi.smarthome.newui;

import _m_j.gty;
import _m_j.hak;
import _m_j.iuh;
import _m_j.iwc;
import _m_j.ixe;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;"}, k = 3, mv = {1, 5, 1}, xi = 48)
final class RoomDeviceRecycler$changeToLogout$logoutButtonAdapter$2 extends Lambda implements iwc<View, iuh> {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final RoomDeviceRecycler$changeToLogout$logoutButtonAdapter$2 f10120O000000o = new RoomDeviceRecycler$changeToLogout$logoutButtonAdapter$2();

    RoomDeviceRecycler$changeToLogout$logoutButtonAdapter$2() {
        super(1);
    }

    public final /* synthetic */ Object invoke(Object obj) {
        View view = (View) obj;
        ixe.O00000o(view, "it");
        view.setOnClickListener($$Lambda$RoomDeviceRecycler$changeToLogout$logoutButtonAdapter$2$5DZXFWMHjwaGQJoX4SLrRLTn644.INSTANCE);
        return iuh.f1631O000000o;
    }

    /* access modifiers changed from: private */
    public static final void O000000o(View view) {
        ixe.O00000Oo(view, "view");
        hak.O000000o(view, RoomDeviceRecycler$changeToLogout$logoutButtonAdapter$2$1$1.f10121O000000o);
        gty.O000000o().startLogin(view.getContext(), 1, null);
    }
}
