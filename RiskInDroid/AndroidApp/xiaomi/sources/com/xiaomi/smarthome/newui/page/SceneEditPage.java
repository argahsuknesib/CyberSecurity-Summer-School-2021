package com.xiaomi.smarthome.newui.page;

import _m_j.ixe;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.xiaomi.smarthome.newui.page.AbstractEditPage;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/xiaomi/smarthome/newui/page/SceneEditPage;", "Lcom/xiaomi/smarthome/newui/page/AbstractEditPage;", "activity", "Landroidx/fragment/app/FragmentActivity;", "initTitle", "", "callback", "Lcom/xiaomi/smarthome/newui/page/SceneEditPage$IExitCallBack;", "menus", "", "Lcom/xiaomi/smarthome/newui/page/AbstractEditPage$EditMenu;", "(Landroidx/fragment/app/FragmentActivity;Ljava/lang/String;Lcom/xiaomi/smarthome/newui/page/SceneEditPage$IExitCallBack;Ljava/util/List;)V", "getCallback", "()Lcom/xiaomi/smarthome/newui/page/SceneEditPage$IExitCallBack;", "getInitTitle", "()Ljava/lang/String;", "getMenus", "()Ljava/util/List;", "onExit", "", "onSelectButtonClick", "view", "Landroid/view/View;", "IExitCallBack", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SceneEditPage extends AbstractEditPage {
    private final String O0000OOo;
    private final List<AbstractEditPage.O000000o> O0000Oo;
    private final O000000o O0000Oo0;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/xiaomi/smarthome/newui/page/SceneEditPage$IExitCallBack;", "", "onExit", "", "onSelectButtonClick", "view", "Landroid/view/View;", "isSelectAll", "", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface O000000o {
        void O000000o(View view, boolean z);

        void O00000oO();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SceneEditPage(FragmentActivity fragmentActivity, String str, O000000o o000000o, List<AbstractEditPage.O000000o> list) {
        super(fragmentActivity, str, list);
        ixe.O00000o(fragmentActivity, "activity");
        ixe.O00000o(str, "initTitle");
        ixe.O00000o(o000000o, "callback");
        ixe.O00000o(list, "menus");
        this.O0000OOo = str;
        this.O0000Oo0 = o000000o;
        this.O0000Oo = list;
    }

    public final void O000000o() {
        this.O0000Oo0.O00000oO();
    }

    public final void O000000o(View view) {
        ixe.O00000o(view, "view");
        this.O0000Oo0.O000000o(view, !view.isSelected());
    }
}
