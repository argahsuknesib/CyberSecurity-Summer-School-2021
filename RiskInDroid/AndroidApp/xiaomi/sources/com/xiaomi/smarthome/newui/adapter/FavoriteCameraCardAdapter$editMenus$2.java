package com.xiaomi.smarthome.newui.adapter;

import _m_j.hbp;
import _m_j.iuh;
import _m_j.iuo;
import _m_j.iwb;
import _m_j.iwc;
import _m_j.ixe;
import android.view.View;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.newui.page.AbstractEditPage;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "Lcom/xiaomi/smarthome/newui/page/AbstractEditPage$EditMenu;"}, k = 3, mv = {1, 5, 1}, xi = 48)
final class FavoriteCameraCardAdapter$editMenus$2 extends Lambda implements iwb<List<? extends AbstractEditPage.O000000o>> {
    final /* synthetic */ FavoriteCameraCardAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FavoriteCameraCardAdapter$editMenus$2(FavoriteCameraCardAdapter favoriteCameraCardAdapter) {
        super(0);
        this.this$0 = favoriteCameraCardAdapter;
    }

    public final /* synthetic */ Object invoke() {
        final FavoriteCameraCardAdapter favoriteCameraCardAdapter = this.this$0;
        final FavoriteCameraCardAdapter favoriteCameraCardAdapter2 = this.this$0;
        final FavoriteCameraCardAdapter favoriteCameraCardAdapter3 = this.this$0;
        final FavoriteCameraCardAdapter favoriteCameraCardAdapter4 = this.this$0;
        return iuo.O000000o((Object[]) new AbstractEditPage.O000000o[]{new AbstractEditPage.O000000o(R.string.menu_edit_pin, R.drawable.ic_main_edit_pin_top_selector, new iwc<View, iuh>() {
            /* class com.xiaomi.smarthome.newui.adapter.FavoriteCameraCardAdapter$editMenus$2.AnonymousClass1 */

            public final /* synthetic */ Object invoke(Object obj) {
                ixe.O00000o((View) obj, "it");
                favoriteCameraCardAdapter.O00000o();
                return iuh.f1631O000000o;
            }
        }, new iwb<Boolean>() {
            /* class com.xiaomi.smarthome.newui.adapter.FavoriteCameraCardAdapter$editMenus$2.AnonymousClass2 */

            public final /* synthetic */ Object invoke() {
                boolean z = !favoriteCameraCardAdapter2.O0000OoO.isEmpty();
                ((hbp) favoriteCameraCardAdapter2.O0000oOO.O000000o()).O000000o(z, FavoriteCameraCardAdapter$editMenus$2$2$1$1.f10164O000000o);
                return Boolean.valueOf(z);
            }
        }), new AbstractEditPage.O000000o(R.string.menu_edit_common_camrea_del, R.drawable.ic_main_edit_common_camera_del_selector, new iwc<View, iuh>() {
            /* class com.xiaomi.smarthome.newui.adapter.FavoriteCameraCardAdapter$editMenus$2.AnonymousClass3 */

            public final /* synthetic */ Object invoke(Object obj) {
                View view = (View) obj;
                ixe.O00000o(view, "it");
                favoriteCameraCardAdapter3.O00000Oo(view);
                return iuh.f1631O000000o;
            }
        }, new iwb<Boolean>() {
            /* class com.xiaomi.smarthome.newui.adapter.FavoriteCameraCardAdapter$editMenus$2.AnonymousClass4 */

            public final /* synthetic */ Object invoke() {
                boolean z = !favoriteCameraCardAdapter4.O0000OoO.isEmpty();
                ((hbp) favoriteCameraCardAdapter4.O0000oOo.O000000o()).O000000o(z, FavoriteCameraCardAdapter$editMenus$2$4$1$1.f10165O000000o);
                return Boolean.valueOf(z);
            }
        })});
    }
}
