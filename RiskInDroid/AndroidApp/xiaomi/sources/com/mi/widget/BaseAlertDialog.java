package com.mi.widget;

import _m_j.ccr;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public class BaseAlertDialog extends Dialog {

    /* renamed from: O000000o */
    public static final int positive = 2132152172;

    /* renamed from: O00000Oo */
    public static final int negative = 2132151709;
    public static final String O00000o0 = "BaseAlertDialog";
    public CommonButton O00000o;
    public CommonButton O00000oO;
    public CommonButton O00000oo;
    public RelativeLayout O0000O0o;
    public View O0000OOo;
    AnimatorSet O0000Oo = new AnimatorSet();
    public View O0000Oo0;
    private TextView O0000OoO;
    private ImageView O0000Ooo;
    private Context O0000o0;
    private TextView O0000o00;
    private View.OnClickListener O0000o0O = new View.OnClickListener() {
        /* class com.mi.widget.BaseAlertDialog.AnonymousClass2 */

        public final void onClick(View view) {
            ccr.O00000Oo(BaseAlertDialog.O00000o0, "dialog dismiss");
            BaseAlertDialog.this.dismiss();
        }
    };

    public BaseAlertDialog(Context context) {
        super(context, 2132739084);
        setContentView((int) R.layout.base_dialog);
        this.O0000OoO = (TextView) findViewById(R.id.title);
        this.O0000Ooo = (ImageView) findViewById(R.id.icon);
        this.O0000o00 = (TextView) findViewById(R.id.message);
        this.O00000o = (CommonButton) findViewById(R.id.positive);
        this.O00000oO = (CommonButton) findViewById(R.id.negative);
        this.O00000oo = (CommonButton) findViewById(R.id.neutral);
        this.O0000OOo = findViewById(R.id.bottomBar);
        this.O0000Oo0 = findViewById(R.id.bottomBar1);
        this.O0000O0o = (RelativeLayout) findViewById(R.id.basedialog_parent_layout);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        Window window = getWindow();
        layoutParams.copyFrom(window.getAttributes());
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.gravity = 80;
        window.setAttributes(layoutParams);
        this.O0000o0 = context;
        setOnShowListener(new DialogInterface.OnShowListener() {
            /* class com.mi.widget.BaseAlertDialog.AnonymousClass1 */

            public final void onShow(DialogInterface dialogInterface) {
                BaseAlertDialog.this.O0000O0o.setVisibility(0);
                BaseAlertDialog baseAlertDialog = BaseAlertDialog.this;
                baseAlertDialog.O0000O0o.setPivotX(((float) baseAlertDialog.O0000O0o.getMeasuredWidth()) / 2.0f);
                baseAlertDialog.O0000O0o.setPivotY(((float) baseAlertDialog.O0000O0o.getMeasuredHeight()) / 2.0f);
                baseAlertDialog.O0000Oo.playTogether(ObjectAnimator.ofFloat(baseAlertDialog.O0000O0o, "translationY", 300.0f, 0.0f).setDuration(300L), ObjectAnimator.ofFloat(baseAlertDialog.O0000O0o, "alpha", 0.0f, 1.0f).setDuration(450L));
                baseAlertDialog.O0000Oo.setDuration((long) Math.abs(300));
                baseAlertDialog.O0000Oo.start();
            }
        });
    }

    public void setTitle(int i) {
        this.O0000OoO.setVisibility(0);
        this.O0000OoO.setText(i);
    }

    public final void O000000o(View view) {
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
    }

    public class O000000o implements View.OnClickListener {
        private View.OnClickListener O00000Oo;

        public O000000o(View.OnClickListener onClickListener) {
            this.O00000Oo = onClickListener;
        }

        public final void onClick(View view) {
            View.OnClickListener onClickListener = this.O00000Oo;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            BaseAlertDialog.this.dismiss();
        }
    }

    public void dismiss() {
        super.dismiss();
    }
}
