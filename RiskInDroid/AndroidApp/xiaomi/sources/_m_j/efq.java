package _m_j;

import _m_j.ego;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Message;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import com.xiaomi.passport.ui.AlertControllerWrapper;
import com.xiaomi.passport.ui.internal.MenuBuilder;
import com.xiaomi.smarthome.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class efq implements MenuBuilder.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    public final int f15225O000000o;
    public final Window O00000Oo;
    public CharSequence O00000o;
    public ViewGroup O00000o0;
    public CharSequence O00000oO;
    public TextView O00000oo;
    public TextView O0000O0o;
    public View O0000OOo;
    public ArrayList<AlertControllerWrapper.AlertParams.O000000o> O0000Oo;
    public View O0000Oo0;
    public DialogInterface.OnClickListener O0000OoO;
    public Button O0000Ooo;
    public Message O0000o;
    public Message O0000o0;
    public CharSequence O0000o00;
    public Button O0000o0O;
    public CharSequence O0000o0o;
    public CharSequence O0000oO;
    public Button O0000oO0;
    public Message O0000oOO;
    public Handler O0000oOo;
    public DialogInterface O0000oo;
    public ScrollView O0000oo0;
    public Context O0000ooO;
    public View.OnClickListener O0000ooo = new View.OnClickListener() {
        /* class _m_j.efq.AnonymousClass1 */

        public final void onClick(View view) {
            Message message;
            if (view == efq.this.O0000Ooo && efq.this.O0000o0 != null) {
                message = Message.obtain(efq.this.O0000o0);
            } else if (view != efq.this.O0000o0O || efq.this.O0000o == null) {
                message = (view != efq.this.O0000oO0 || efq.this.O0000oOO == null) ? null : Message.obtain(efq.this.O0000oOO);
            } else {
                message = Message.obtain(efq.this.O0000o);
            }
            if (message != null) {
                message.sendToTarget();
            }
            efq.this.O0000oOo.obtainMessage(1, efq.this.O0000oo).sendToTarget();
        }
    };
    private final Runnable O000O00o = new Runnable() {
        /* class _m_j.efq.AnonymousClass2 */

        public final void run() {
            efq efq = efq.this;
            MenuBuilder menuBuilder = new MenuBuilder(efq.O0000ooO);
            menuBuilder.O000000o(efq);
            efq efq2 = efq.this;
            for (int i = 0; i < efq2.O0000Oo.size(); i++) {
                AlertControllerWrapper.AlertParams.O000000o o000000o = efq2.O0000Oo.get(i);
                menuBuilder.add(0, o000000o.O00000o0, 0, o000000o.f6214O000000o).setIcon(o000000o.O00000Oo).setShowAsAction(2);
            }
            efq efq3 = efq.this;
            if (menuBuilder != efq3.O00oOooO) {
                efq3.O00oOooO = menuBuilder;
            }
        }
    };
    private ego.O000000o O000O0OO = new ego.O000000o() {
        /* class _m_j.efq.AnonymousClass3 */
    };
    MenuBuilder O00oOooO;
    private int O00oOooo = -1;

    static final class O000000o extends Handler {

        /* renamed from: O000000o  reason: collision with root package name */
        private WeakReference<DialogInterface> f15229O000000o;

        public O000000o(DialogInterface dialogInterface) {
            this.f15229O000000o = new WeakReference<>(dialogInterface);
        }

        public final void handleMessage(Message message) {
            int i = message.what;
            if (i == -3 || i == -2 || i == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.f15229O000000o.get(), message.what);
            } else if (i == 1) {
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    public efq(Context context, DialogInterface dialogInterface, Window window) {
        this.O0000ooO = context;
        this.O0000oo = dialogInterface;
        this.O00000Oo = window;
        this.O0000oOo = new O000000o(dialogInterface);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{R.attr.passport_horizontalProgressLayout, R.attr.passport_layout, R.attr.passport_progressLayout}, 16842845, 0);
        this.f15225O000000o = obtainStyledAttributes.getResourceId(1, R.layout.passport_alert_dialog);
        obtainStyledAttributes.recycle();
    }

    public static boolean O000000o(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (O000000o(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public final boolean O000000o(MenuItem menuItem) {
        DialogInterface.OnClickListener onClickListener = this.O0000OoO;
        if (onClickListener == null) {
            return true;
        }
        onClickListener.onClick(this.O0000oo, menuItem.getItemId());
        return true;
    }
}
