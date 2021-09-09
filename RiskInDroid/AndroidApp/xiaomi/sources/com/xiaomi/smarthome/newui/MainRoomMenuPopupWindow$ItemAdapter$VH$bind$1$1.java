package com.xiaomi.smarthome.newui;

import _m_j.iuh;
import _m_j.iwc;
import _m_j.ixe;
import android.content.Intent;
import com.xiaomi.smarthome.newui.widget.topnavi.PageBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Landroid/content/Intent;"}, k = 3, mv = {1, 5, 1}, xi = 48)
final class MainRoomMenuPopupWindow$ItemAdapter$VH$bind$1$1 extends Lambda implements iwc<Intent, iuh> {
    final /* synthetic */ PageBean $page;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MainRoomMenuPopupWindow$ItemAdapter$VH$bind$1$1(PageBean pageBean) {
        super(1);
        this.$page = pageBean;
    }

    public final /* synthetic */ Object invoke(Object obj) {
        Intent intent = (Intent) obj;
        ixe.O00000o(intent, "it");
        intent.putExtra("main_extra_room_selected_id", this.$page.O00000Oo);
        return iuh.f1631O000000o;
    }
}
