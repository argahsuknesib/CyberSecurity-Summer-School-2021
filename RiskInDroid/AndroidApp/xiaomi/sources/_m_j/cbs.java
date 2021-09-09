package _m_j;

import _m_j.cbu;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 @2\u00020\u0001:\u0001@B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0000H&J\u001a\u0010\u001a\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001c\u001a\u00020\tH\u0002J\u0012\u0010\u001d\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u001e\u001a\u00020\u0016H\u0002J\u0012\u0010\u001f\u001a\u00020\u00162\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010\"\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010#\u001a\u00020\u00162\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J&\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020!H\u0016J\b\u0010,\u001a\u00020\u0016H\u0016J\u0012\u0010-\u001a\u00020\u00002\b\b\u0001\u0010.\u001a\u00020\u0004H\u0016J\u0018\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u0004H\u0016J\u0010\u00102\u001a\u00020\u00002\u0006\u00103\u001a\u00020\u0004H\u0016J\u0010\u00104\u001a\u00020\u00002\u0006\u00105\u001a\u00020\tH\u0016J\u0010\u00106\u001a\u00020\u00002\u0006\u00107\u001a\u00020\u0004H\u0016J\u0010\u00108\u001a\u00020\u00002\u0006\u00109\u001a\u00020\u0012H\u0016J\u0010\u0010:\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\u0012H\u0016J\b\u0010<\u001a\u00020\u0004H&J\u0010\u0010=\u001a\u00020\u00002\u0006\u0010>\u001a\u00020?H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\u00048\u0004@\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/mi/global/shop/voice/dialog/BaseDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "mAnimStyle", "", "mContext", "Landroid/content/Context;", "mDialogStyle", "mDimAmount", "", "mHeight", "mLayoutResId", "getMLayoutResId", "()I", "setMLayoutResId", "(I)V", "mMargin", "mOutCancel", "", "mShowBottomEnable", "mWidth", "convertView", "", "holder", "Lcom/mi/global/shop/voice/dialog/ViewHolder;", "dialogFragment", "dp2px", "context", "dipValue", "getScreenWidth", "initParams", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onAttach", "onCreate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onSaveInstanceState", "outState", "onStart", "setAnimStyle", "animStyle", "setDialogSize", "width", "height", "setDialogStyle", "theme", "setDimAmount", "dimAmount", "setMargin", "margin", "setOutCancel", "outCancel", "setShowBottom", "showBottom", "setUpLayoutId", "show", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "Companion", "shopsdk_release"}, k = 1, mv = {1, 1, 15})
public abstract class cbs extends dz {
    public static final O000000o O00000oO = new O000000o((byte) 0);

    /* renamed from: O000000o  reason: collision with root package name */
    private boolean f13604O000000o = true;
    private boolean O00000Oo;
    public int O00000o;
    protected int O00000o0;
    private Context O00000oo;
    private int O0000O0o;
    private int O0000OOo;
    private int O0000Oo;
    private int O0000Oo0;
    private float O0000OoO = 0.5f;
    private HashMap O0000Ooo;

    public abstract int O000000o();

    public abstract void O000000o(cbu cbu, cbs cbs);

    public void O00000o0() {
        HashMap hashMap = this.O0000Ooo;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        O00000o0();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/mi/global/shop/voice/dialog/BaseDialogFragment$Companion;", "", "()V", "TAG", "", "shopsdk_release"}, k = 1, mv = {1, 1, 15})
    public static final class O000000o {
        private O000000o() {
        }

        public /* synthetic */ O000000o(byte b) {
            this();
        }
    }

    public void onAttach(Context context) {
        Log.e("BaseDialogFragment", "BaseDialogFragment.onAttach() called. ");
        super.onAttach(context);
        this.O00000oo = context;
    }

    public void onCreate(Bundle bundle) {
        Log.e("BaseDialogFragment", "BaseDialogFragment.onCreate() called. ");
        super.onCreate(bundle);
        int i = this.O0000Oo;
        if (i != 0) {
            setStyle(1, i);
        }
        this.O00000o0 = O000000o();
    }

    public void onSaveInstanceState(Bundle bundle) {
        ixe.O00000o0(bundle, "outState");
        bundle.putInt("layoutId", this.O00000o0);
        bundle.putInt("dialogStyle", this.O0000Oo);
        super.onSaveInstanceState(bundle);
        Log.e("BaseDialogFragment", "BaseDialogFragment.onSaveInstanceState() called. ");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [android.app.Dialog, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [android.content.res.Resources, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    public void onActivityCreated(Bundle bundle) {
        Log.e("BaseDialogFragment", "BaseDialogFragment.onActivityCreated() called.  savedInstanceState = ".concat(String.valueOf(bundle)));
        super.onActivityCreated(bundle);
        Dialog dialog = getDialog();
        ixe.O000000o((Object) dialog, "dialog");
        Window window = dialog.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = this.O0000OoO;
            if (this.O0000O0o == 0) {
                Context context = getContext();
                if (context == null) {
                    ixe.O000000o();
                }
                Resources resources = context.getResources();
                ixe.O000000o((Object) resources, "context!!.resources");
                attributes.width = resources.getDisplayMetrics().widthPixels - (O000000o(getContext(), (float) this.O00000o) * 2);
            } else {
                attributes.width = O000000o(getContext(), (float) this.O0000O0o);
            }
            if (this.O0000OOo != 0) {
                attributes.height = O000000o(getContext(), (float) this.O0000OOo);
            } else if (this.O0000Oo == 0) {
                attributes.height = -2;
            } else {
                attributes.height = -1;
            }
            Log.e("BaseDialogFragment", "BaseDialogFragment.initParams() called. height = " + attributes.height + "  width = " + attributes.width + "  mDialogStyle = " + this.O0000Oo);
            if (this.O00000Oo) {
                attributes.gravity = 80;
            }
            int i = this.O0000Oo0;
            if (i != 0) {
                window.setWindowAnimations(i);
            }
            window.setAttributes(attributes);
        }
        setCancelable(this.f13604O000000o);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [android.view.View, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Dialog dialog;
        Window window;
        ixe.O00000o0(layoutInflater, "inflater");
        Log.e("BaseDialogFragment", "BaseDialogFragment.onCreateView() called. savedInstanceState = ".concat(String.valueOf(bundle)));
        if (!(this.O0000Oo != 0 || (dialog = getDialog()) == null || (window = dialog.getWindow()) == null)) {
            window.setBackgroundDrawableResource(17170445);
        }
        if (bundle != null) {
            this.O00000o0 = bundle.getInt("layoutId");
            this.O0000Oo = bundle.getInt("dialogStyle");
        }
        View inflate = layoutInflater.inflate(this.O00000o0, viewGroup, false);
        cbu.O000000o o000000o = cbu.f13605O000000o;
        ixe.O000000o((Object) inflate, "rootView");
        ixe.O00000o0(inflate, "view");
        O000000o(new cbu(inflate), this);
        return inflate;
    }

    public void onStart() {
        Log.e("BaseDialogFragment", "BaseDialogFragment.onStart() called. ");
        super.onStart();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [_m_j.ei, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    public final cbs O000000o(ee eeVar) {
        ixe.O00000o0(eeVar, "fragmentManager");
        try {
            super.show(eeVar, "");
        } catch (Exception unused) {
            ei O000000o2 = eeVar.O000000o();
            ixe.O000000o((Object) O000000o2, "fragmentManager.beginTransaction()");
            O000000o2.O000000o(this, "");
            O000000o2.O00000o0();
        }
        return this;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [android.content.res.Resources, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    private static int O000000o(Context context, float f) {
        if (context == null) {
            ixe.O000000o();
        }
        Resources resources = context.getResources();
        ixe.O000000o((Object) resources, "context!!.resources");
        return (int) ((f * resources.getDisplayMetrics().density) + 0.5f);
    }
}
