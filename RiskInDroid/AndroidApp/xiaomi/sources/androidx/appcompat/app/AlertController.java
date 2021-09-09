package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.xiaomi.smarthome.R;
import java.lang.ref.WeakReference;

public final class AlertController {

    /* renamed from: O000000o  reason: collision with root package name */
    final Context f2634O000000o;
    final AppCompatDialog O00000Oo;
    final int O00000o;
    final Window O00000o0;
    CharSequence O00000oO;
    CharSequence O00000oo;
    public ListView O0000O0o;
    View O0000OOo;
    int O0000Oo;
    int O0000Oo0;
    int O0000OoO;
    int O0000Ooo;
    Message O0000o;
    boolean O0000o0 = false;
    int O0000o00;
    public Button O0000o0O;
    CharSequence O0000o0o;
    public Button O0000oO;
    Drawable O0000oO0;
    CharSequence O0000oOO;
    Message O0000oOo;
    public Button O0000oo;
    Drawable O0000oo0;
    CharSequence O0000ooO;
    Message O0000ooo;
    int O000O00o = 0;
    Drawable O000O0OO;
    ImageView O000O0Oo;
    View O000O0o;
    TextView O000O0o0;
    ListAdapter O000O0oO;
    int O000O0oo = -1;
    int O000OO;
    int O000OO00;
    int O000OO0o;
    int O000OOOo;
    int O000OOo;
    int O000OOo0;
    boolean O000OOoO;
    int O000OOoo = 0;
    final View.OnClickListener O000Oo0 = new View.OnClickListener() {
        /* class androidx.appcompat.app.AlertController.AnonymousClass1 */

        public final void onClick(View view) {
            Message message;
            if (view == AlertController.this.O0000o0O && AlertController.this.O0000o != null) {
                message = Message.obtain(AlertController.this.O0000o);
            } else if (view != AlertController.this.O0000oO || AlertController.this.O0000oOo == null) {
                message = (view != AlertController.this.O0000oo || AlertController.this.O0000ooo == null) ? null : Message.obtain(AlertController.this.O0000ooo);
            } else {
                message = Message.obtain(AlertController.this.O0000oOo);
            }
            if (message != null) {
                message.sendToTarget();
            }
            AlertController.this.O000Oo00.obtainMessage(1, AlertController.this.O00000Oo).sendToTarget();
        }
    };
    Handler O000Oo00;
    TextView O00oOoOo;
    Drawable O00oOooO;
    NestedScrollView O00oOooo;

    static final class O000000o extends Handler {

        /* renamed from: O000000o  reason: collision with root package name */
        private WeakReference<DialogInterface> f2645O000000o;

        public O000000o(DialogInterface dialogInterface) {
            this.f2645O000000o = new WeakReference<>(dialogInterface);
        }

        public final void handleMessage(Message message) {
            int i = message.what;
            if (i == -3 || i == -2 || i == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.f2645O000000o.get(), message.what);
            } else if (i == 1) {
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    public AlertController(Context context, AppCompatDialog appCompatDialog, Window window) {
        this.f2634O000000o = context;
        this.O00000Oo = appCompatDialog;
        this.O00000o0 = window;
        this.O000Oo00 = new O000000o(appCompatDialog);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{16842994, R.attr.buttonIconDimen, R.attr.buttonPanelSideLayout, R.attr.horizontalProgressLayout, R.attr.layout, R.attr.listItemLayout, R.attr.listLayout, R.attr.multiChoiceItemLayout, R.attr.progressLayout, R.attr.showTitle, R.attr.singleChoiceItemLayout}, R.attr.alertDialogStyle, 0);
        this.O000OO00 = obtainStyledAttributes.getResourceId(0, 0);
        this.O000OO0o = obtainStyledAttributes.getResourceId(2, 0);
        this.O000OO = obtainStyledAttributes.getResourceId(6, 0);
        this.O000OOOo = obtainStyledAttributes.getResourceId(7, 0);
        this.O000OOo0 = obtainStyledAttributes.getResourceId(10, 0);
        this.O000OOo = obtainStyledAttributes.getResourceId(5, 0);
        this.O000OOoO = obtainStyledAttributes.getBoolean(9, true);
        this.O00000o = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
        appCompatDialog.supportRequestWindowFeature(1);
    }

    static boolean O000000o(View view) {
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

    public final void O000000o(CharSequence charSequence) {
        this.O00000oO = charSequence;
        TextView textView = this.O00oOoOo;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public final void O00000Oo(View view) {
        this.O0000OOo = view;
        this.O0000Oo0 = 0;
        this.O0000o0 = false;
    }

    public final void O000000o(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (onClickListener != null) {
            message = this.O000Oo00.obtainMessage(i, onClickListener);
        }
        if (i == -3) {
            this.O0000ooO = charSequence;
            this.O0000ooo = message;
            this.O00oOooO = drawable;
        } else if (i == -2) {
            this.O0000oOO = charSequence;
            this.O0000oOo = message;
            this.O0000oo0 = drawable;
        } else if (i == -1) {
            this.O0000o0o = charSequence;
            this.O0000o = message;
            this.O0000oO0 = drawable;
        } else {
            throw new IllegalArgumentException("Button does not exist");
        }
    }

    public final void O000000o(int i) {
        this.O000O0OO = null;
        this.O000O00o = i;
        ImageView imageView = this.O000O0Oo;
        if (imageView == null) {
            return;
        }
        if (i != 0) {
            imageView.setVisibility(0);
            this.O000O0Oo.setImageResource(this.O000O00o);
            return;
        }
        imageView.setVisibility(8);
    }

    static ViewGroup O000000o(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    static void O000000o(View view, View view2, View view3) {
        int i = 0;
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            if (!view.canScrollVertically(1)) {
                i = 4;
            }
            view3.setVisibility(i);
        }
    }

    static void O000000o(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    public static class RecycleListView extends ListView {

        /* renamed from: O000000o  reason: collision with root package name */
        final int f2646O000000o;
        final int O00000Oo;

        public RecycleListView(Context context) {
            this(context, null);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.paddingBottomNoButtons, R.attr.paddingTopNoTitle});
            this.O00000Oo = obtainStyledAttributes.getDimensionPixelOffset(0, -1);
            this.f2646O000000o = obtainStyledAttributes.getDimensionPixelOffset(1, -1);
        }
    }

    public static class AlertParams {

        /* renamed from: O000000o  reason: collision with root package name */
        public final Context f2640O000000o;
        public final LayoutInflater O00000Oo;
        public Drawable O00000o;
        public int O00000o0 = 0;
        public int O00000oO = 0;
        public CharSequence O00000oo;
        public View O0000O0o;
        public CharSequence O0000OOo;
        public Drawable O0000Oo;
        public CharSequence O0000Oo0;
        public DialogInterface.OnClickListener O0000OoO;
        public CharSequence O0000Ooo;
        public DialogInterface.OnClickListener O0000o;
        public DialogInterface.OnClickListener O0000o0;
        public Drawable O0000o00;
        public CharSequence O0000o0O;
        public Drawable O0000o0o;
        public DialogInterface.OnCancelListener O0000oO;
        public boolean O0000oO0;
        public DialogInterface.OnDismissListener O0000oOO;
        public DialogInterface.OnKeyListener O0000oOo;
        public ListAdapter O0000oo;
        public CharSequence[] O0000oo0;
        public DialogInterface.OnClickListener O0000ooO;
        public int O0000ooo;
        public int O000O00o;
        public int O000O0OO;
        public int O000O0Oo;
        public boolean O000O0o;
        public boolean[] O000O0o0;
        public boolean O000O0oO;
        public int O000O0oo = -1;
        public String O000OO;
        public DialogInterface.OnMultiChoiceClickListener O000OO00;
        public Cursor O000OO0o;
        public String O000OOOo;
        public AdapterView.OnItemSelectedListener O000OOo;
        public boolean O000OOo0;
        public boolean O000OOoO = true;
        public boolean O00oOoOo = false;
        public View O00oOooO;
        public int O00oOooo;

        public AlertParams(Context context) {
            this.f2640O000000o = context;
            this.O0000oO0 = true;
            this.O00000Oo = (LayoutInflater) context.getSystemService("layout_inflater");
        }
    }

    static class O00000Oo extends ArrayAdapter<CharSequence> {
        public final long getItemId(int i) {
            return (long) i;
        }

        public final boolean hasStableIds() {
            return true;
        }

        public O00000Oo(Context context, int i, CharSequence[] charSequenceArr) {
            super(context, i, 16908308, charSequenceArr);
        }
    }
}
