package com.xiasuhuei321.loadingdialog.view;

import _m_j.ihu;
import _m_j.ihv;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

public class LoadingDialog implements ihv {
    private static ihu O0000oO0 = new ihu(Speed.SPEED_TWO, "加载中...", "加载成功", "加载失败");

    /* renamed from: O000000o  reason: collision with root package name */
    public final String f12145O000000o = "LoadingDialog";
    public Context O00000Oo;
    private LVCircularRing O00000o;
    public boolean O00000o0 = true;
    private Dialog O00000oO;
    private LinearLayout O00000oo;
    private TextView O0000O0o;
    private RightDiaView O0000OOo;
    private String O0000Oo;
    private WrongDiaView O0000Oo0;
    private String O0000OoO;
    private List<View> O0000Ooo;
    private int O0000o = 0;
    private boolean O0000o0 = true;
    private boolean O0000o00 = true;
    private int O0000o0O = 1;
    private long O0000o0o = 1000;
    private LoadCircleView O0000oO;
    @SuppressLint({"HandlerLeak"})
    private Handler O0000oOO = new Handler() {
        /* class com.xiasuhuei321.loadingdialog.view.LoadingDialog.AnonymousClass3 */

        public final void handleMessage(Message message) {
            LoadingDialog.this.O000000o();
        }
    };

    public enum Speed {
        SPEED_ONE,
        SPEED_TWO
    }

    public LoadingDialog(Context context) {
        this.O00000Oo = context;
        View inflate = LayoutInflater.from(context).inflate((int) R.layout.loading_dialog_view, (ViewGroup) null);
        this.O00000oo = (LinearLayout) inflate.findViewById(R.id.dialog_view);
        this.O00000o = (LVCircularRing) inflate.findViewById(R.id.lv_circularring);
        this.O0000O0o = (TextView) inflate.findViewById(R.id.loading_text);
        this.O0000OOo = (RightDiaView) inflate.findViewById(R.id.rdv_right);
        this.O0000Oo0 = (WrongDiaView) inflate.findViewById(R.id.wv_wrong);
        this.O0000oO = (LoadCircleView) inflate.findViewById(R.id.lcv_circleload);
        this.O0000Ooo = new ArrayList();
        this.O0000Ooo.add(this.O00000o);
        this.O0000Ooo.add(this.O0000OOo);
        this.O0000Ooo.add(this.O0000Oo0);
        this.O0000Ooo.add(this.O0000oO);
        this.O0000OOo.setOnDrawFinishListener(this);
        this.O0000Oo0.setOnDrawFinishListener(this);
        this.O00000oO = new Dialog(context) {
            /* class com.xiasuhuei321.loadingdialog.view.LoadingDialog.AnonymousClass1 */

            public final void onBackPressed() {
                if (!LoadingDialog.this.O00000o0) {
                    LoadingDialog.this.O000000o();
                }
            }
        };
        this.O00000oO.setCancelable(!this.O00000o0);
        this.O00000oO.setContentView(this.O00000oo, new LinearLayout.LayoutParams(-1, -1));
        this.O00000oO.setOnDismissListener(new DialogInterface.OnDismissListener() {
            /* class com.xiasuhuei321.loadingdialog.view.LoadingDialog.AnonymousClass2 */

            public final void onDismiss(DialogInterface dialogInterface) {
                LoadingDialog.this.O00000Oo = null;
            }
        });
        ihu ihu = O0000oO0;
        if (ihu != null) {
            boolean z = ihu.O00000oo;
            this.O00000o0 = z;
            this.O00000oO.setCancelable(!z);
            int i = O0000oO0.O00000Oo;
            this.O0000Oo0.setRepeatTime(i);
            this.O0000OOo.setRepeatTime(i);
            int i2 = O0000oO0.O00000o0;
            if (i2 >= 0) {
                ViewGroup.LayoutParams layoutParams = this.O0000OOo.getLayoutParams();
                layoutParams.height = i2;
                layoutParams.width = i2;
                this.O0000OOo.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = this.O0000Oo0.getLayoutParams();
                layoutParams2.height = i2;
                layoutParams2.width = i2;
                this.O0000Oo0.setLayoutParams(layoutParams2);
                ViewGroup.LayoutParams layoutParams3 = this.O00000o.getLayoutParams();
                layoutParams3.height = i2;
                layoutParams3.width = i2;
            }
            float f = (float) O0000oO0.O00000o;
            if (f >= 0.0f) {
                this.O0000O0o.setTextSize(2, f);
            }
            long j = O0000oO0.O00000oO;
            if (j >= 0) {
                this.O0000o0o = j;
            }
            if (!O0000oO0.f1306O000000o) {
                this.O0000o0 = false;
                this.O0000o00 = false;
            }
            String str = O0000oO0.O0000O0o;
            if (str != null) {
                this.O0000O0o.setVisibility(0);
                this.O0000O0o.setText(str);
            } else {
                this.O0000O0o.setVisibility(8);
            }
            this.O0000Oo = O0000oO0.O0000OOo;
            this.O0000OoO = O0000oO0.O0000Oo0;
            int i3 = O0000oO0.O0000Oo;
            if (i3 < 3) {
                this.O0000o = i3;
                return;
            }
            throw new IllegalArgumentException("Your style is wrong: style = ".concat(String.valueOf(i3)));
        }
    }

    public final void O000000o(View view) {
        if (view instanceof WrongDiaView) {
            this.O0000oOO.sendEmptyMessageDelayed(2, this.O0000o0o);
        } else {
            this.O0000oOO.sendEmptyMessageDelayed(1, this.O0000o0o);
        }
    }

    public final void O000000o() {
        this.O0000oOO.removeCallbacksAndMessages(null);
        if (this.O00000oO != null) {
            LVCircularRing lVCircularRing = this.O00000o;
            if (lVCircularRing.O00000o0 != null) {
                lVCircularRing.clearAnimation();
                lVCircularRing.O00000o0.setRepeatCount(1);
                lVCircularRing.O00000o0.cancel();
                lVCircularRing.O00000o0.end();
            }
            this.O00000oO.dismiss();
        }
    }
}
