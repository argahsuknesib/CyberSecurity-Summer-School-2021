package com.xiaomi.smarthome.notify_permission;

import _m_j.hja;
import _m_j.ixe;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.newui.page.IPage;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\fH\u0014J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/xiaomi/smarthome/notify_permission/NotifySnakeBar;", "Lcom/xiaomi/smarthome/newui/page/IPage;", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)V", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "afterInflate", "", "root", "Landroid/view/View;", "interceptKeyEvent", "", "interceptTouchEvent", "onCreateView", "container", "Landroid/view/ViewGroup;", "smarthome-scene_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class NotifySnakeBar extends IPage {

    /* renamed from: O000000o  reason: collision with root package name */
    private final FragmentActivity f10502O000000o;

    public final boolean O00000o() {
        return false;
    }

    public final boolean O0000O0o() {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NotifySnakeBar(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        ixe.O00000o(fragmentActivity, "activity");
        this.f10502O000000o = fragmentActivity;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final View O000000o(ViewGroup viewGroup) {
        ixe.O00000o(viewGroup, "container");
        View inflate = LayoutInflater.from(this.f10502O000000o).inflate((int) R.layout.notify_open_tip, viewGroup, false);
        ixe.O00000Oo(inflate, "root");
        inflate.findViewById(R.id.snake_bar).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.notify_permission.$$Lambda$NotifySnakeBar$HOBSreLLkiDGlA3ybmFWS1aXIA */

            public final void onClick(View view) {
                NotifySnakeBar.O000000o(NotifySnakeBar.this, view);
            }
        });
        inflate.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.notify_permission.$$Lambda$NotifySnakeBar$IRLJBnIJCDXGnXme8lJgyc8fjfc */

            public final void onClick(View view) {
                NotifySnakeBar.O00000Oo(NotifySnakeBar.this, view);
            }
        });
        return inflate;
    }

    /* access modifiers changed from: private */
    public static final void O000000o(NotifySnakeBar notifySnakeBar, View view) {
        ixe.O00000o(notifySnakeBar, "this$0");
        hja.O000000o o000000o = hja.f18973O000000o;
        hja.O000000o.O00000Oo(notifySnakeBar.f10502O000000o);
    }

    /* access modifiers changed from: private */
    public static final void O00000Oo(NotifySnakeBar notifySnakeBar, View view) {
        ixe.O00000o(notifySnakeBar, "this$0");
        notifySnakeBar.O00000Oo();
        hja.O000000o o000000o = hja.f18973O000000o;
        hja.O000000o.O000000o((Context) notifySnakeBar.f10502O000000o);
    }
}
