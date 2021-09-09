package com.xiaomi.smarthome.newui.page;

import _m_j.gp;
import _m_j.hak;
import _m_j.hgp;
import _m_j.iuh;
import _m_j.iuo;
import _m_j.iwb;
import _m_j.iwc;
import _m_j.ixe;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\b&\u0018\u00002\u00020\u0001:\u0005ABCDEB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ \u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020&H\u0002J\u0018\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0002J\b\u0010,\u001a\u00020\"H\u0016J(\u0010-\u001a\u00020\"2\u0006\u0010%\u001a\u00020&2\u0006\u0010$\u001a\u00020\u00152\u0006\u0010#\u001a\u00020 2\u0006\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020\u001bH\u0014J\u0010\u00101\u001a\u00020\"2\u0006\u00102\u001a\u000203H\u0016J\u0010\u00104\u001a\u00020\u00152\u0006\u00105\u001a\u00020\u0011H\u0014J\b\u00106\u001a\u00020\"H&J\u0010\u00107\u001a\u00020\"2\u0006\u00108\u001a\u00020\u0015H\u0002J\u0010\u00109\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0015H&J\u0016\u0010:\u001a\u00020\"2\u0006\u0010;\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u001bJ\u0016\u0010=\u001a\u00020\"2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0007H\u0002J\b\u0010?\u001a\u00020\"H\u0016J\f\u0010@\u001a\u00020\u001e*\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X.¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lcom/xiaomi/smarthome/newui/page/AbstractEditPage;", "Lcom/xiaomi/smarthome/newui/page/IPage;", "activity", "Landroidx/fragment/app/FragmentActivity;", "initTitle", "", "menus", "", "Lcom/xiaomi/smarthome/newui/page/AbstractEditPage$EditMenu;", "menuGravity", "Lcom/xiaomi/smarthome/newui/page/AbstractEditPage$MenuGravity;", "(Landroidx/fragment/app/FragmentActivity;Ljava/lang/String;Ljava/util/List;Lcom/xiaomi/smarthome/newui/page/AbstractEditPage$MenuGravity;)V", "displayWidth", "", "getDisplayWidth", "()I", "editMenu", "Landroid/view/ViewGroup;", "editMenuItemAnimator", "Lcom/xiaomi/smarthome/newui/page/EditMenuItemAnimator;", "editTitle", "Landroid/view/View;", "editTitleIndicator", "Landroid/widget/ImageView;", "editTitleTv", "Landroid/widget/TextView;", "isDismissed", "", "menusInner", "", "Lcom/xiaomi/smarthome/newui/page/AbstractEditPage$EditMenuInner;", "recycler", "Landroidx/recyclerview/widget/RecyclerView;", "alignCenter", "", "parent", "view", "outRect", "Landroid/graphics/Rect;", "dip2px", "context", "Landroid/content/Context;", "dpValue", "", "dismiss", "getItemOffsets", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "interceptTouchEvent", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreateView", "container", "onExit", "onFinishInflate", "root", "onSelectButtonClick", "refresh", "title", "isSelectAll", "render", "newMenus", "show", "mapToInner", "EditMenu", "EditMenuInner", "MenuAdapter", "MenuGravity", "SimpleDiffCallback", "smarthome-widget_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class AbstractEditPage extends IPage {

    /* renamed from: O000000o  reason: collision with root package name */
    final MenuGravity f10258O000000o;
    RecyclerView O00000Oo;
    public List<O00000Oo> O00000o0;
    private final FragmentActivity O0000OOo;
    private final List<O000000o> O0000Oo;
    private final String O0000Oo0;
    private boolean O0000OoO;
    private ViewGroup O0000Ooo;
    private TextView O0000o0;
    private View O0000o00;
    private ImageView O0000o0O;
    private final hgp O0000o0o;

    /* access modifiers changed from: private */
    public static final void O00000Oo(View view) {
    }

    public abstract void O000000o();

    public abstract void O000000o(View view);

    /* access modifiers changed from: protected */
    public final boolean O00000o() {
        return false;
    }

    public /* synthetic */ AbstractEditPage(FragmentActivity fragmentActivity, String str, List list) {
        this(fragmentActivity, str, list, MenuGravity.LEFT);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AbstractEditPage(FragmentActivity fragmentActivity, String str, List<O000000o> list, MenuGravity menuGravity) {
        super(fragmentActivity);
        ixe.O00000o(fragmentActivity, "activity");
        ixe.O00000o(str, "initTitle");
        ixe.O00000o(list, "menus");
        ixe.O00000o(menuGravity, "menuGravity");
        this.O0000OOo = fragmentActivity;
        this.O0000Oo0 = str;
        this.O0000Oo = list;
        this.f10258O000000o = menuGravity;
        this.O00000o0 = new ArrayList();
        this.O0000o0o = new hgp();
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/xiaomi/smarthome/newui/page/AbstractEditPage$MenuGravity;", "", "(Ljava/lang/String;I)V", "LEFT", "CENTER", "smarthome-widget_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class MenuGravity extends Enum<MenuGravity> {
        private static final /* synthetic */ MenuGravity[] $VALUES = $values();
        public static final MenuGravity CENTER = new MenuGravity("CENTER", 1);
        public static final MenuGravity LEFT = new MenuGravity("LEFT", 0);

        private static final /* synthetic */ MenuGravity[] $values() {
            return new MenuGravity[]{LEFT, CENTER};
        }

        private MenuGravity(String str, int i) {
        }

        public static MenuGravity valueOf(String str) {
            ixe.O00000o(str, "value");
            return (MenuGravity) Enum.valueOf(MenuGravity.class, str);
        }

        public static MenuGravity[] values() {
            MenuGravity[] menuGravityArr = $VALUES;
            return (MenuGravity[]) Arrays.copyOf(menuGravityArr, menuGravityArr.length);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\\\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\u0002\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0006\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\u0010\u000fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J$\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\u0002\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0006HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003Jb\u0010\u001d\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032#\b\u0002\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\u0002\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u00062\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\r2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R,\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\u0002\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016¨\u0006#"}, d2 = {"Lcom/xiaomi/smarthome/newui/page/AbstractEditPage$EditMenu;", "", "name", "", "icon", "block", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "view", "", "display", "Lkotlin/Function0;", "", "enable", "(IILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getBlock", "()Lkotlin/jvm/functions/Function1;", "getDisplay", "()Lkotlin/jvm/functions/Function0;", "getEnable", "getIcon", "()I", "getName", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "smarthome-widget_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final int f10261O000000o;
        final int O00000Oo;
        final iwb<Boolean> O00000o;
        final iwc<View, iuh> O00000o0;
        final iwb<Boolean> O00000oO;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof O000000o)) {
                return false;
            }
            O000000o o000000o = (O000000o) obj;
            return this.f10261O000000o == o000000o.f10261O000000o && this.O00000Oo == o000000o.O00000Oo && ixe.O000000o(this.O00000o0, o000000o.O00000o0) && ixe.O000000o(this.O00000o, o000000o.O00000o) && ixe.O000000o(this.O00000oO, o000000o.O00000oO);
        }

        public final int hashCode() {
            return (((((((Integer.valueOf(this.f10261O000000o).hashCode() * 31) + Integer.valueOf(this.O00000Oo).hashCode()) * 31) + this.O00000o0.hashCode()) * 31) + this.O00000o.hashCode()) * 31) + this.O00000oO.hashCode();
        }

        public final String toString() {
            return "EditMenu(name=" + this.f10261O000000o + ", icon=" + this.O00000Oo + ", block=" + this.O00000o0 + ", display=" + this.O00000o + ", enable=" + this.O00000oO + ')';
        }

        /* JADX WARN: Type inference failed for: r4v0, types: [_m_j.iwc<android.view.View, _m_j.iuh>, _m_j.iwc<? super android.view.View, _m_j.iuh>, java.lang.Object] */
        /* JADX WARNING: Unknown variable types count: 1 */
        public O000000o(int i, int i2, iwc<? super View, iuh> r4, iwb<Boolean> iwb, iwb<Boolean> iwb2) {
            ixe.O00000o(r4, "block");
            ixe.O00000o(iwb, "display");
            ixe.O00000o(iwb2, "enable");
            this.f10261O000000o = i;
            this.O00000Oo = i2;
            this.O00000o0 = r4;
            this.O00000o = iwb;
            this.O00000oO = iwb2;
        }

        public /* synthetic */ O000000o(int i, int i2, iwc iwc, iwb iwb) {
            this(i, i2, iwc, iwb, AbstractEditPage$EditMenu$2.f10259O000000o);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BL\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\u0002\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0002\u0010\u000eJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J$\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\u0002\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\fHÆ\u0003J\t\u0010\u001b\u001a\u00020\fHÆ\u0003JV\u0010\u001c\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032#\b\u0002\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\u0002\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R,\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\u0002\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015¨\u0006\""}, d2 = {"Lcom/xiaomi/smarthome/newui/page/AbstractEditPage$EditMenuInner;", "", "name", "", "icon", "block", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "view", "", "display", "", "enable", "(IILkotlin/jvm/functions/Function1;ZZ)V", "getBlock", "()Lkotlin/jvm/functions/Function1;", "getDisplay", "()Z", "getEnable", "getIcon", "()I", "getName", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "smarthome-widget_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    static final class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        final int f10262O000000o;
        final int O00000Oo;
        final boolean O00000o;
        final iwc<View, iuh> O00000o0;
        final boolean O00000oO;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof O00000Oo)) {
                return false;
            }
            O00000Oo o00000Oo = (O00000Oo) obj;
            return this.f10262O000000o == o00000Oo.f10262O000000o && this.O00000Oo == o00000Oo.O00000Oo && ixe.O000000o(this.O00000o0, o00000Oo.O00000o0) && this.O00000o == o00000Oo.O00000o && this.O00000oO == o00000Oo.O00000oO;
        }

        public final int hashCode() {
            int hashCode = ((((Integer.valueOf(this.f10262O000000o).hashCode() * 31) + Integer.valueOf(this.O00000Oo).hashCode()) * 31) + this.O00000o0.hashCode()) * 31;
            boolean z = this.O00000o;
            if (z) {
                z = true;
            }
            int i = (hashCode + (z ? 1 : 0)) * 31;
            boolean z2 = this.O00000oO;
            if (z2) {
                z2 = true;
            }
            return i + (z2 ? 1 : 0);
        }

        public final String toString() {
            return "EditMenuInner(name=" + this.f10262O000000o + ", icon=" + this.O00000Oo + ", block=" + this.O00000o0 + ", display=" + this.O00000o + ", enable=" + this.O00000oO + ')';
        }

        /* JADX WARN: Type inference failed for: r4v0, types: [_m_j.iwc<android.view.View, _m_j.iuh>, _m_j.iwc<? super android.view.View, _m_j.iuh>, java.lang.Object] */
        /* JADX WARNING: Unknown variable types count: 1 */
        public O00000Oo(int i, int i2, iwc<? super View, iuh> r4, boolean z, boolean z2) {
            ixe.O00000o(r4, "block");
            this.f10262O000000o = i;
            this.O00000Oo = i2;
            this.O00000o0 = r4;
            this.O00000o = z;
            this.O00000oO = z2;
        }
    }

    private static O00000Oo O000000o(O000000o o000000o) {
        return new O00000Oo(o000000o.f10261O000000o, o000000o.O00000Oo, o000000o.O00000o0, o000000o.O00000o.invoke().booleanValue(), o000000o.O00000oO.invoke().booleanValue());
    }

    public final void e_() {
        this.O00000o0.clear();
        List<O00000Oo> list = this.O00000o0;
        Iterable<O000000o> iterable = this.O0000Oo;
        Collection arrayList = new ArrayList(iuo.O000000o(iterable, 10));
        for (O000000o O000000o2 : iterable) {
            arrayList.add(O000000o(O000000o2));
        }
        Collection arrayList2 = new ArrayList();
        for (Object next : (List) arrayList) {
            if (((O00000Oo) next).O00000o) {
                arrayList2.add(next);
            }
        }
        list.addAll((List) arrayList2);
        super.e_();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    /* access modifiers changed from: protected */
    public final View O000000o(ViewGroup viewGroup) {
        ixe.O00000o(viewGroup, "container");
        View inflate = LayoutInflater.from(this.O0000OOo).inflate((int) R.layout.edit_action_bar_main_page, viewGroup, false);
        ixe.O00000Oo(inflate, "root");
        View findViewById = inflate.findViewById(R.id.edit_title);
        ixe.O00000Oo(findViewById, "root.findViewById(R.id.edit_title)");
        this.O0000o00 = findViewById;
        View view = this.O0000o00;
        if (view != null) {
            View findViewById2 = view.findViewById(R.id.title);
            ixe.O00000Oo(findViewById2, "editTitle.findViewById(R.id.title)");
            this.O0000o0 = (TextView) findViewById2;
            View view2 = this.O0000o00;
            if (view2 != null) {
                View findViewById3 = view2.findViewById(R.id.indicator);
                ixe.O00000Oo(findViewById3, "editTitle.findViewById(R.id.indicator)");
                this.O0000o0O = (ImageView) findViewById3;
                ImageView imageView = this.O0000o0O;
                if (imageView != null) {
                    imageView.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.newui.page.$$Lambda$AbstractEditPage$XM2i1din7O9x6mj8GHlnqCaNf64 */

                        public final void onClick(View view) {
                            AbstractEditPage.O000000o(AbstractEditPage.this, view);
                        }
                    });
                    View view3 = this.O0000o00;
                    if (view3 != null) {
                        view3.findViewById(R.id.complete).setOnClickListener(new View.OnClickListener() {
                            /* class com.xiaomi.smarthome.newui.page.$$Lambda$AbstractEditPage$75emZJtCFRLsA2GQ6zJDN0F_jGY */

                            public final void onClick(View view) {
                                AbstractEditPage.O00000Oo(AbstractEditPage.this, view);
                            }
                        });
                        TextView textView = this.O0000o0;
                        if (textView != null) {
                            textView.setText(this.O0000Oo0);
                            View findViewById4 = inflate.findViewById(R.id.edit_menu);
                            ixe.O00000Oo(findViewById4, "root.findViewById(R.id.edit_menu)");
                            this.O0000Ooo = (ViewGroup) findViewById4;
                            View findViewById5 = inflate.findViewById(R.id.recycler);
                            ixe.O00000Oo(findViewById5, "root.findViewById(R.id.recycler)");
                            this.O00000Oo = (RecyclerView) findViewById5;
                            RecyclerView recyclerView = this.O00000Oo;
                            if (recyclerView != null) {
                                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.O0000OOo);
                                linearLayoutManager.setOrientation(0);
                                iuh iuh = iuh.f1631O000000o;
                                recyclerView.setLayoutManager(linearLayoutManager);
                                RecyclerView recyclerView2 = this.O00000Oo;
                                if (recyclerView2 != null) {
                                    recyclerView2.addItemDecoration(new O0000O0o(this));
                                    RecyclerView recyclerView3 = this.O00000Oo;
                                    if (recyclerView3 != null) {
                                        recyclerView3.setAdapter(new O00000o0(this));
                                        View view4 = this.O0000o00;
                                        if (view4 != null) {
                                            view4.setTranslationY(-((float) O000000o(this.O0000OOo, 86.0f)));
                                            View view5 = this.O0000o00;
                                            if (view5 != null) {
                                                view5.animate().translationY(0.0f);
                                                View view6 = this.O0000o00;
                                                if (view6 != null) {
                                                    view6.setOnClickListener($$Lambda$AbstractEditPage$hhfxxN7k4MioD2HsV3mE97ZUSUk.INSTANCE);
                                                    if (this.O0000Oo.isEmpty()) {
                                                        ViewGroup viewGroup2 = this.O0000Ooo;
                                                        if (viewGroup2 != null) {
                                                            viewGroup2.setVisibility(8);
                                                        } else {
                                                            ixe.O000000o("editMenu");
                                                            throw null;
                                                        }
                                                    } else {
                                                        ViewGroup viewGroup3 = this.O0000Ooo;
                                                        if (viewGroup3 != null) {
                                                            viewGroup3.setTranslationY((float) O000000o(this.O0000OOo, 90.0f));
                                                            ViewGroup viewGroup4 = this.O0000Ooo;
                                                            if (viewGroup4 != null) {
                                                                viewGroup4.animate().translationY(0.0f);
                                                            } else {
                                                                ixe.O000000o("editMenu");
                                                                throw null;
                                                            }
                                                        } else {
                                                            ixe.O000000o("editMenu");
                                                            throw null;
                                                        }
                                                    }
                                                    return inflate;
                                                }
                                                ixe.O000000o("editTitle");
                                                throw null;
                                            }
                                            ixe.O000000o("editTitle");
                                            throw null;
                                        }
                                        ixe.O000000o("editTitle");
                                        throw null;
                                    }
                                    ixe.O000000o("recycler");
                                    throw null;
                                }
                                ixe.O000000o("recycler");
                                throw null;
                            }
                            ixe.O000000o("recycler");
                            throw null;
                        }
                        ixe.O000000o("editTitleTv");
                        throw null;
                    }
                    ixe.O000000o("editTitle");
                    throw null;
                }
                ixe.O000000o("editTitleIndicator");
                throw null;
            }
            ixe.O000000o("editTitle");
            throw null;
        }
        ixe.O000000o("editTitle");
        throw null;
    }

    /* access modifiers changed from: private */
    public static final void O000000o(AbstractEditPage abstractEditPage, View view) {
        ixe.O00000o(abstractEditPage, "this$0");
        ixe.O00000Oo(view, "it");
        abstractEditPage.O000000o(view);
    }

    /* access modifiers changed from: private */
    public static final void O00000Oo(AbstractEditPage abstractEditPage, View view) {
        ixe.O00000o(abstractEditPage, "this$0");
        abstractEditPage.O00000Oo();
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/xiaomi/smarthome/newui/page/AbstractEditPage$onFinishInflate$4", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "smarthome-widget_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O0000O0o extends RecyclerView.O0000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ AbstractEditPage f10266O000000o;

        O0000O0o(AbstractEditPage abstractEditPage) {
            this.f10266O000000o = abstractEditPage;
        }

        public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
            ixe.O00000o(rect, "outRect");
            ixe.O00000o(view, "view");
            ixe.O00000o(recyclerView, "parent");
            ixe.O00000o(o000OO0o, "state");
            AbstractEditPage abstractEditPage = this.f10266O000000o;
            ixe.O00000o(rect, "outRect");
            ixe.O00000o(view, "view");
            ixe.O00000o(recyclerView, "parent");
            ixe.O00000o(o000OO0o, "state");
            if (abstractEditPage.f10258O000000o == MenuGravity.LEFT) {
                Context context = view.getContext();
                ixe.O00000Oo(context, "view.context");
                rect.left = AbstractEditPage.O000000o(context, 26.0f);
                Context context2 = view.getContext();
                ixe.O00000Oo(context2, "view.context");
                rect.right = AbstractEditPage.O000000o(context2, 26.0f);
                return;
            }
            RecyclerView recyclerView2 = abstractEditPage.O00000Oo;
            Integer num = null;
            if (recyclerView2 != null) {
                RecyclerView.O000000o adapter = recyclerView2.getAdapter();
                if (adapter != null) {
                    num = Integer.valueOf(adapter.getItemCount());
                }
                if (num != null) {
                    int intValue = num.intValue();
                    int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
                    Context context3 = view.getContext();
                    ixe.O00000Oo(context3, "view.context");
                    int O000000o2 = AbstractEditPage.O000000o(context3, 46.0f);
                    Context context4 = view.getContext();
                    ixe.O00000Oo(context4, "view.context");
                    int O000000o3 = AbstractEditPage.O000000o(context4, 26.0f);
                    Object systemService = CommonApplication.getAppContext().getSystemService("window");
                    if (systemService != null) {
                        Point point = new Point();
                        ((WindowManager) systemService).getDefaultDisplay().getRealSize(point);
                        int i = (point.x - (O000000o2 * intValue)) - (O000000o3 * 2);
                        boolean z = false;
                        boolean z2 = childAdapterPosition == 0;
                        if (childAdapterPosition == intValue - 1) {
                            z = true;
                        }
                        int i2 = i / (intValue + 1);
                        if (z2 && z) {
                            int i3 = i2 + O000000o3;
                            rect.left = i3;
                            rect.right = i3;
                        } else if (z2) {
                            rect.left = O000000o3 + i2;
                            rect.right = i2 / 2;
                        } else if (z) {
                            rect.right = O000000o3 + i2;
                            rect.left = i2 / 2;
                        } else {
                            int i4 = i2 / 2;
                            rect.right = i4;
                            rect.left = i4;
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
                    }
                }
            } else {
                ixe.O000000o("recycler");
                throw null;
            }
        }
    }

    public final void O000000o(String str, boolean z) {
        ixe.O00000o(str, "title");
        TextView textView = this.O0000o0;
        if (textView != null) {
            textView.setText(str);
            ImageView imageView = this.O0000o0O;
            if (imageView != null) {
                imageView.setSelected(z);
                Iterable<O000000o> iterable = this.O0000Oo;
                Collection arrayList = new ArrayList(iuo.O000000o(iterable, 10));
                for (O000000o O000000o2 : iterable) {
                    arrayList.add(O000000o(O000000o2));
                }
                Collection arrayList2 = new ArrayList();
                for (Object next : (List) arrayList) {
                    if (((O00000Oo) next).O00000o) {
                        arrayList2.add(next);
                    }
                }
                O000000o((List) arrayList2);
                return;
            }
            ixe.O000000o("editTitleIndicator");
            throw null;
        }
        ixe.O000000o("editTitleTv");
        throw null;
    }

    private final void O000000o(List<O00000Oo> list) {
        if (list.isEmpty()) {
            RecyclerView recyclerView = this.O00000Oo;
            if (recyclerView != null) {
                recyclerView.setItemAnimator(null);
            } else {
                ixe.O000000o("recycler");
                throw null;
            }
        } else {
            RecyclerView recyclerView2 = this.O00000Oo;
            if (recyclerView2 == null) {
                ixe.O000000o("recycler");
                throw null;
            } else if (!ixe.O000000o(recyclerView2.getItemAnimator(), this.O0000o0o)) {
                RecyclerView recyclerView3 = this.O00000Oo;
                if (recyclerView3 != null) {
                    recyclerView3.setItemAnimator(this.O0000o0o);
                } else {
                    ixe.O000000o("recycler");
                    throw null;
                }
            }
        }
        RecyclerView recyclerView4 = this.O00000Oo;
        if (recyclerView4 != null) {
            RecyclerView.O000000o adapter = recyclerView4.getAdapter();
            if (adapter != null) {
                gp.O00000Oo O000000o2 = gp.O000000o(new O00000o(this.O00000o0, list));
                ixe.O00000Oo(O000000o2, "calculateDiff(SimpleDiffCallback(menusInner, newMenus))");
                this.O00000o0.clear();
                this.O00000o0.addAll(list);
                O000000o2.O000000o(adapter);
                return;
            }
            return;
        }
        ixe.O000000o("recycler");
        throw null;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/xiaomi/smarthome/newui/page/AbstractEditPage$SimpleDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "from", "", "Lcom/xiaomi/smarthome/newui/page/AbstractEditPage$EditMenuInner;", "to", "(Ljava/util/List;Ljava/util/List;)V", "areContentsTheSame", "", "p0", "", "p1", "areItemsTheSame", "getNewListSize", "getOldListSize", "smarthome-widget_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    static final class O00000o extends gp.O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        private final List<O00000Oo> f10263O000000o;
        private final List<O00000Oo> O00000Oo;

        public O00000o(List<O00000Oo> list, List<O00000Oo> list2) {
            ixe.O00000o(list, "from");
            ixe.O00000o(list2, "to");
            this.f10263O000000o = list;
            this.O00000Oo = list2;
        }

        public final boolean O000000o(int i, int i2) {
            return this.f10263O000000o.get(i).f10262O000000o == this.O00000Oo.get(i2).f10262O000000o;
        }

        public final int O000000o() {
            return this.f10263O000000o.size();
        }

        public final int O00000Oo() {
            return this.O00000Oo.size();
        }

        public final boolean O00000Oo(int i, int i2) {
            O00000Oo o00000Oo = this.f10263O000000o.get(i);
            O00000Oo o00000Oo2 = this.O00000Oo.get(i2);
            return o00000Oo.O00000Oo == o00000Oo2.O00000Oo && o00000Oo.O00000o == o00000Oo2.O00000o && o00000Oo.O00000oO == o00000Oo2.O00000oO;
        }
    }

    public final void O00000Oo() {
        if (!this.O0000OoO) {
            this.O0000OoO = true;
            View view = this.O0000o00;
            if (view != null) {
                view.animate().translationY(-((float) O000000o(this.O0000OOo, 86.0f))).withEndAction(new Runnable() {
                    /* class com.xiaomi.smarthome.newui.page.$$Lambda$AbstractEditPage$PJapfVxyFumQSKM4KQaBi8Yo1jY */

                    public final void run() {
                        AbstractEditPage.O000000o(AbstractEditPage.this);
                    }
                });
                if (true ^ this.O0000Oo.isEmpty()) {
                    ViewGroup viewGroup = this.O0000Ooo;
                    if (viewGroup != null) {
                        viewGroup.animate().translationY((float) O000000o(this.O0000OOo, 90.0f));
                    } else {
                        ixe.O000000o("editMenu");
                        throw null;
                    }
                }
                O000000o();
                return;
            }
            ixe.O000000o("editTitle");
            throw null;
        }
    }

    /* access modifiers changed from: private */
    public static final void O000000o(AbstractEditPage abstractEditPage) {
        ixe.O00000o(abstractEditPage, "this$0");
        super.O00000Oo();
    }

    public final void O000000o(Configuration configuration) {
        ixe.O00000o(configuration, "newConfig");
        super.O000000o(configuration);
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016J \u0010\u000b\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0006H\u0016¨\u0006\u000f"}, d2 = {"Lcom/xiaomi/smarthome/newui/page/AbstractEditPage$MenuAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/xiaomi/smarthome/newui/page/AbstractEditPage$MenuAdapter$VH;", "Lcom/xiaomi/smarthome/newui/page/AbstractEditPage;", "(Lcom/xiaomi/smarthome/newui/page/AbstractEditPage;)V", "getItemCount", "", "onBindViewHolder", "", "viewHolder", "pos", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "VH", "smarthome-widget_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    final class O00000o0 extends RecyclerView.O000000o<O000000o> {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ AbstractEditPage f10264O000000o;

        public O00000o0(AbstractEditPage abstractEditPage) {
            ixe.O00000o(abstractEditPage, "this$0");
            this.f10264O000000o = abstractEditPage;
        }

        public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            O000000o o000000o = (O000000o) o000OOo0;
            ixe.O00000o(o000000o, "viewHolder");
            o000000o.O000000o(this.f10264O000000o.O00000o0.get(i));
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            ixe.O00000o(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.main_edit_menu_item, viewGroup, false);
            ixe.O00000Oo(inflate, "from(parent.context).inflate(R.layout.main_edit_menu_item, parent, false)");
            return new O000000o(this, inflate);
        }

        public final int getItemCount() {
            return this.f10264O000000o.O00000o0.size();
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/xiaomi/smarthome/newui/page/AbstractEditPage$MenuAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "item", "Landroid/view/View;", "(Lcom/xiaomi/smarthome/newui/page/AbstractEditPage$MenuAdapter;Landroid/view/View;)V", "menuItem", "Landroid/widget/TextView;", "bind", "", "menu", "Lcom/xiaomi/smarthome/newui/page/AbstractEditPage$EditMenuInner;", "smarthome-widget_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public final class O000000o extends RecyclerView.O000OOo0 {

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ O00000o0 f10265O000000o;
            private final TextView O00000Oo;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public O000000o(O00000o0 o00000o0, View view) {
                super(view);
                ixe.O00000o(o00000o0, "this$0");
                ixe.O00000o(view, "item");
                this.f10265O000000o = o00000o0;
                View findViewById = this.itemView.findViewById(R.id.menu_item);
                ixe.O00000Oo(findViewById, "itemView.findViewById(R.id.menu_item)");
                this.O00000Oo = (TextView) findViewById;
            }

            public final void O000000o(O00000Oo o00000Oo) {
                ixe.O00000o(o00000Oo, "menu");
                this.O00000Oo.setCompoundDrawablesWithIntrinsicBounds(0, o00000Oo.O00000Oo, 0, 0);
                this.O00000Oo.setText(this.itemView.getResources().getText(o00000Oo.f10262O000000o));
                this.itemView.setOnClickListener(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0025: INVOKE  
                      (wrap: android.view.View : 0x001e: IGET  (r0v3 android.view.View) = (r3v0 'this' com.xiaomi.smarthome.newui.page.AbstractEditPage$O00000o0$O000000o A[THIS]) com.xiaomi.smarthome.newui.page.AbstractEditPage.O00000o0.O000000o.itemView android.view.View)
                      (wrap: com.xiaomi.smarthome.newui.page.-$$Lambda$AbstractEditPage$O00000o0$O000000o$nrBVt2uGIumgqV9B2OSoRDqf7MI : 0x0022: CONSTRUCTOR  (r1v4 com.xiaomi.smarthome.newui.page.-$$Lambda$AbstractEditPage$O00000o0$O000000o$nrBVt2uGIumgqV9B2OSoRDqf7MI) = (r4v0 'o00000Oo' com.xiaomi.smarthome.newui.page.AbstractEditPage$O00000Oo) call: com.xiaomi.smarthome.newui.page.-$$Lambda$AbstractEditPage$O00000o0$O000000o$nrBVt2uGIumgqV9B2OSoRDqf7MI.<init>(com.xiaomi.smarthome.newui.page.AbstractEditPage$O00000Oo):void type: CONSTRUCTOR)
                     type: VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void in method: com.xiaomi.smarthome.newui.page.AbstractEditPage.O00000o0.O000000o.O000000o(com.xiaomi.smarthome.newui.page.AbstractEditPage$O00000Oo):void, dex: classes5.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                    	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:268)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:257)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                    	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:268)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:257)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0022: CONSTRUCTOR  (r1v4 com.xiaomi.smarthome.newui.page.-$$Lambda$AbstractEditPage$O00000o0$O000000o$nrBVt2uGIumgqV9B2OSoRDqf7MI) = (r4v0 'o00000Oo' com.xiaomi.smarthome.newui.page.AbstractEditPage$O00000Oo) call: com.xiaomi.smarthome.newui.page.-$$Lambda$AbstractEditPage$O00000o0$O000000o$nrBVt2uGIumgqV9B2OSoRDqf7MI.<init>(com.xiaomi.smarthome.newui.page.AbstractEditPage$O00000Oo):void type: CONSTRUCTOR in method: com.xiaomi.smarthome.newui.page.AbstractEditPage.O00000o0.O000000o.O000000o(com.xiaomi.smarthome.newui.page.AbstractEditPage$O00000Oo):void, dex: classes5.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 63 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.xiaomi.smarthome.newui.page.-$$Lambda$AbstractEditPage$O00000o0$O000000o$nrBVt2uGIumgqV9B2OSoRDqf7MI, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 69 more
                    */
                /*
                    this = this;
                    java.lang.String r0 = "menu"
                    _m_j.ixe.O00000o(r4, r0)
                    android.widget.TextView r0 = r3.O00000Oo
                    int r1 = r4.O00000Oo
                    r2 = 0
                    r0.setCompoundDrawablesWithIntrinsicBounds(r2, r1, r2, r2)
                    android.widget.TextView r0 = r3.O00000Oo
                    android.view.View r1 = r3.itemView
                    android.content.res.Resources r1 = r1.getResources()
                    int r2 = r4.f10262O000000o
                    java.lang.CharSequence r1 = r1.getText(r2)
                    r0.setText(r1)
                    android.view.View r0 = r3.itemView
                    com.xiaomi.smarthome.newui.page.-$$Lambda$AbstractEditPage$O00000o0$O000000o$nrBVt2uGIumgqV9B2OSoRDqf7MI r1 = new com.xiaomi.smarthome.newui.page.-$$Lambda$AbstractEditPage$O00000o0$O000000o$nrBVt2uGIumgqV9B2OSoRDqf7MI
                    r1.<init>(r4)
                    r0.setOnClickListener(r1)
                    android.view.View r0 = r3.itemView
                    boolean r1 = r4.O00000oO
                    r0.setEnabled(r1)
                    android.widget.TextView r0 = r3.O00000Oo
                    boolean r4 = r4.O00000oO
                    r0.setEnabled(r4)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smarthome.newui.page.AbstractEditPage.O00000o0.O000000o.O000000o(com.xiaomi.smarthome.newui.page.AbstractEditPage$O00000Oo):void");
            }

            /* access modifiers changed from: private */
            public static final void O000000o(O00000Oo o00000Oo, View view) {
                ixe.O00000o(o00000Oo, "$menu");
                ixe.O00000Oo(view, "it");
                hak.O000000o(view, AbstractEditPage$MenuAdapter$VH$bind$1$1.f10260O000000o);
                o00000Oo.O00000o0.invoke(view);
            }
        }
    }

    static int O000000o(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
