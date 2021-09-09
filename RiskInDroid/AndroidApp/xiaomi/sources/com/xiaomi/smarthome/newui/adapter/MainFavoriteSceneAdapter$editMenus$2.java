package com.xiaomi.smarthome.newui.adapter;

import _m_j.hah;
import _m_j.hbm;
import _m_j.iuh;
import _m_j.iuo;
import _m_j.iwb;
import _m_j.iwc;
import _m_j.ixe;
import android.view.View;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.newui.page.AbstractEditPage;
import com.xiaomi.smarthome.scene.bean.CommonUsedScene;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "Lcom/xiaomi/smarthome/newui/page/AbstractEditPage$EditMenu;"}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class MainFavoriteSceneAdapter$editMenus$2 extends Lambda implements iwb<List<? extends AbstractEditPage.O000000o>> {
    final /* synthetic */ hbm this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MainFavoriteSceneAdapter$editMenus$2(hbm hbm) {
        super(0);
        this.this$0 = hbm;
    }

    public final /* synthetic */ Object invoke() {
        final hbm hbm = this.this$0;
        final hbm hbm2 = this.this$0;
        final hbm hbm3 = this.this$0;
        final hbm hbm4 = this.this$0;
        final hbm hbm5 = this.this$0;
        final hbm hbm6 = this.this$0;
        return iuo.O000000o((Object[]) new AbstractEditPage.O000000o[]{new AbstractEditPage.O000000o(R.string.menu_edit_pin, R.drawable.ic_main_edit_pin_top_selector, new iwc<View, iuh>() {
            /* class com.xiaomi.smarthome.newui.adapter.MainFavoriteSceneAdapter$editMenus$2.AnonymousClass1 */

            public final /* synthetic */ Object invoke(Object obj) {
                ixe.O00000o((View) obj, "it");
                hbm.O00000o();
                return iuh.f1631O000000o;
            }
        }, new iwb<Boolean>() {
            /* class com.xiaomi.smarthome.newui.adapter.MainFavoriteSceneAdapter$editMenus$2.AnonymousClass2 */

            public final /* synthetic */ Object invoke() {
                return Boolean.valueOf(!hbm2.O0000Oo.isEmpty());
            }
        }), new AbstractEditPage.O000000o(R.string.menu_edit_common_del, R.drawable.ic_main_edit_common_del_selector, new iwc<View, iuh>() {
            /* class com.xiaomi.smarthome.newui.adapter.MainFavoriteSceneAdapter$editMenus$2.AnonymousClass3 */

            public final /* synthetic */ Object invoke(Object obj) {
                View view = (View) obj;
                ixe.O00000o(view, "it");
                hbm3.O00000Oo(view);
                return iuh.f1631O000000o;
            }
        }, new iwb<Boolean>() {
            /* class com.xiaomi.smarthome.newui.adapter.MainFavoriteSceneAdapter$editMenus$2.AnonymousClass4 */

            public final /* synthetic */ Object invoke() {
                return Boolean.valueOf(!hbm4.O0000Oo.isEmpty());
            }
        }), new AbstractEditPage.O000000o(R.string.menu_edit_rename, R.drawable.ic_main_edit_rename_selector, new iwc<View, iuh>() {
            /* class com.xiaomi.smarthome.newui.adapter.MainFavoriteSceneAdapter$editMenus$2.AnonymousClass5 */

            public final /* synthetic */ Object invoke(Object obj) {
                View view = (View) obj;
                ixe.O00000o(view, "it");
                hbm hbm = hbm5;
                CommonUsedScene commonUsedScene = hbm.O00000Oo().get(0);
                hbm.O0000Oo0.indexOf(commonUsedScene);
                hah.O000000o(view.getContext(), commonUsedScene.O00000Oo, view.getResources().getString(R.string.menu_edit_rename), "", new hbm.O00000o(commonUsedScene, hbm, view));
                return iuh.f1631O000000o;
            }
        }, new iwb<Boolean>() {
            /* class com.xiaomi.smarthome.newui.adapter.MainFavoriteSceneAdapter$editMenus$2.AnonymousClass6 */

            public final /* synthetic */ Object invoke() {
                boolean z = false;
                if (hbm6.O00000Oo().size() == 1) {
                    List<CommonUsedScene> O00000Oo = hbm6.O00000Oo();
                    ixe.O00000o0(O00000Oo, "receiver$0");
                    if (O00000Oo.isEmpty()) {
                        throw new NoSuchElementException("List is empty.");
                    } else if (O00000Oo.get(0).O00000o0 != 2) {
                        z = true;
                    }
                }
                return Boolean.valueOf(z);
            }
        })});
    }
}
