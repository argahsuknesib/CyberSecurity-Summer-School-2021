package com.smarthome.uwb.ui.manager;

import _m_j.hxi;
import _m_j.iuh;
import _m_j.iuo;
import _m_j.iwb;
import _m_j.iwc;
import _m_j.ixe;
import android.content.Context;
import android.view.View;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.newui.page.AbstractEditPage;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "Lcom/xiaomi/smarthome/newui/page/AbstractEditPage$EditMenu;"}, k = 3, mv = {1, 5, 1}, xi = 48)
final class UwbManagerTagActivity$editMenus$2 extends Lambda implements iwb<List<? extends AbstractEditPage.O000000o>> {
    final /* synthetic */ UwbManagerTagActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UwbManagerTagActivity$editMenus$2(UwbManagerTagActivity uwbManagerTagActivity) {
        super(0);
        this.this$0 = uwbManagerTagActivity;
    }

    public final /* synthetic */ Object invoke() {
        final UwbManagerTagActivity uwbManagerTagActivity = this.this$0;
        final UwbManagerTagActivity uwbManagerTagActivity2 = this.this$0;
        final UwbManagerTagActivity uwbManagerTagActivity3 = this.this$0;
        final UwbManagerTagActivity uwbManagerTagActivity4 = this.this$0;
        return iuo.O000000o((Object[]) new AbstractEditPage.O000000o[]{new AbstractEditPage.O000000o(R.string.menu_edit_rename, R.drawable.icon_edit_uwb_rename, new iwc<View, iuh>() {
            /* class com.smarthome.uwb.ui.manager.UwbManagerTagActivity$editMenus$2.AnonymousClass1 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
             arg types: [java.lang.String, java.util.List<_m_j.ddw$O000000o>]
             candidates:
              _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
              _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
              _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
              _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
            public final /* synthetic */ Object invoke(Object obj) {
                View view = (View) obj;
                ixe.O00000o(view, "it");
                ManagerUwbTagController managerUwbTagController = uwbManagerTagActivity.controller;
                if (managerUwbTagController != null) {
                    Context context = view.getContext();
                    ixe.O00000Oo(context, "it.context");
                    managerUwbTagController.O00000Oo(context, uwbManagerTagActivity.getSelectItems());
                    hxi.O00000o.f952O000000o.O000000o("uwb_manager_rename_click", new Object[0]);
                    UwbLogUtil.d("UwbManagerTagActivity", ixe.O000000o("rename devices: ", (Object) uwbManagerTagActivity.getSelectItems()));
                    return iuh.f1631O000000o;
                }
                ixe.O000000o("controller");
                throw null;
            }
        }, AnonymousClass2.f5750O000000o, new iwb<Boolean>() {
            /* class com.smarthome.uwb.ui.manager.UwbManagerTagActivity$editMenus$2.AnonymousClass3 */

            public final /* synthetic */ Object invoke() {
                boolean z = false;
                if (uwbManagerTagActivity2.getSelectItems().size() == 1 && uwbManagerTagActivity2.getSelectItems().get(0).O0000Oo) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
        }), new AbstractEditPage.O000000o(R.string.menu_edit_delete, R.drawable.delete_button, new iwc<View, iuh>() {
            /* class com.smarthome.uwb.ui.manager.UwbManagerTagActivity$editMenus$2.AnonymousClass4 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
             arg types: [java.lang.String, java.util.List<_m_j.ddw$O000000o>]
             candidates:
              _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
              _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
              _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
              _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
            public final /* synthetic */ Object invoke(Object obj) {
                View view = (View) obj;
                ixe.O00000o(view, "it");
                ManagerUwbTagController managerUwbTagController = uwbManagerTagActivity3.controller;
                if (managerUwbTagController != null) {
                    Context context = view.getContext();
                    ixe.O00000Oo(context, "it.context");
                    managerUwbTagController.O000000o(context, uwbManagerTagActivity3.getSelectItems());
                    hxi.O00000o.f952O000000o.O000000o("uwb_manager_delete_click", new Object[0]);
                    UwbLogUtil.d("UwbManagerTagActivity", ixe.O000000o("delete devices: ", (Object) uwbManagerTagActivity3.getSelectItems()));
                    return iuh.f1631O000000o;
                }
                ixe.O000000o("controller");
                throw null;
            }
        }, AnonymousClass5.f5751O000000o, new iwb<Boolean>() {
            /* class com.smarthome.uwb.ui.manager.UwbManagerTagActivity$editMenus$2.AnonymousClass6 */

            public final /* synthetic */ Object invoke() {
                return Boolean.valueOf(!uwbManagerTagActivity4.checkedItems.isEmpty());
            }
        })});
    }
}
