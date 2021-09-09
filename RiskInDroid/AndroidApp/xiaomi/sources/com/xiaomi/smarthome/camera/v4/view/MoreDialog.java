package com.xiaomi.smarthome.camera.v4.view;

import _m_j.chr;
import _m_j.cid;
import _m_j.civ;
import _m_j.gqg;
import _m_j.gwg;
import _m_j.izb;
import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.view.MultiStateTextView;
import com.xiaomi.smarthome.device.api.Callback;

public class MoreDialog extends AlertDialog implements View.OnClickListener {
    public Context mContext;
    private View.OnClickListener mListener;
    public cid mijiaCameraDevice;
    public IMoreDialogListener moreDialogListener;
    public MultiStateTextView mstvSleep;
    private boolean showAlbum = false;

    public interface IMoreDialogListener {
        void onPowerStateChanged(boolean z);
    }

    public MoreDialog(Context context, cid cid, View.OnClickListener onClickListener) {
        super(context);
        this.mijiaCameraDevice = cid;
        this.mListener = onClickListener;
        this.mContext = context;
    }

    public MoreDialog(Context context, int i, cid cid, View.OnClickListener onClickListener, boolean z) {
        super(context, i);
        this.mijiaCameraDevice = cid;
        getWindow().getAttributes().windowAnimations = R.style.dialog_anim;
        this.mListener = onClickListener;
        this.mContext = context;
        this.showAlbum = z;
    }

    public void dismiss() {
        super.dismiss();
        this.mListener = null;
    }

    public void show() {
        super.show();
        init();
        initViews();
    }

    private void init() {
        getWindow().setContentView((int) R.layout.dialog_more);
    }

    private void initViews() {
        gwg.O00000Oo(getWindow());
        findViewById(R.id.tvCancel).setOnClickListener(this);
        findViewById(R.id.tvPIP).setOnClickListener(this);
        findViewById(R.id.tvCalibration).setOnClickListener(this);
        findViewById(R.id.tvMotionTrack).setOnClickListener(this);
        if (this.showAlbum) {
            findViewById(R.id.tvAlbum2).setVisibility(0);
            findViewById(R.id.tvAlbum2).setOnClickListener(this);
        } else {
            findViewById(R.id.tvAlbum2).setVisibility(8);
            findViewById(R.id.tvAlbum2).setOnClickListener(null);
        }
        this.mstvSleep = (MultiStateTextView) findViewById(R.id.mstvSleep);
        this.mstvSleep.addState(new MultiStateTextView.StateItem(R.string.wake_up, R.drawable.widget_item_more_sleep_stop, new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.view.MoreDialog.AnonymousClass1 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.cll.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
             arg types: [java.lang.String, int, com.xiaomi.smarthome.camera.v4.view.MoreDialog$1$1]
             candidates:
              _m_j.cll.O000000o(java.lang.String, java.lang.Object, com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
              _m_j.cll.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void */
            public void onClick(View view) {
                chr.O000000o(chr.O000oo);
                if (MoreDialog.this.mijiaCameraDevice.isReadOnlyShared()) {
                    izb.O000000o(MoreDialog.this.mContext, (int) R.string.auth_fail_read_only, 0).show();
                } else if (MoreDialog.this.mijiaCameraDevice != null && MoreDialog.this.mijiaCameraDevice.O000000o() != null) {
                    MoreDialog.this.mijiaCameraDevice.O000000o().O000000o("power", true, (Callback<Void>) new Callback<Void>() {
                        /* class com.xiaomi.smarthome.camera.v4.view.MoreDialog.AnonymousClass1.AnonymousClass1 */

                        public void onSuccess(Void voidR) {
                            MoreDialog.this.dismiss();
                            boolean z = true;
                            MoreDialog.this.mstvSleep.setCurrentState(1);
                            civ.O000000o("MoreDialog", "set wakeup success");
                            MoreDialog.this.mijiaCameraDevice.O00000Oo().O000000o("power");
                            if (MoreDialog.this.moreDialogListener != null) {
                                IMoreDialogListener iMoreDialogListener = MoreDialog.this.moreDialogListener;
                                if (MoreDialog.this.mstvSleep.getCurrentState() != 1) {
                                    z = false;
                                }
                                iMoreDialogListener.onPowerStateChanged(z);
                            }
                        }

                        public void onFailure(int i, String str) {
                            MoreDialog.this.dismiss();
                            MoreDialog.this.getContext();
                            gqg.O000000o((int) R.string.action_fail);
                            civ.O000000o("MoreDialog", "set wakeup failed:" + i + " s:" + str);
                        }
                    });
                }
            }
        }));
        if (this.mijiaCameraDevice.getModel().equals("chuangmi.camera.021a04")) {
            this.mstvSleep.addState(new MultiStateTextView.StateItem(R.string.camera_setting_wulizhebi_title, R.drawable.widget_item_more_sleep, new View.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.v4.view.MoreDialog.AnonymousClass2 */

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: _m_j.cll.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
                 arg types: [java.lang.String, int, com.xiaomi.smarthome.camera.v4.view.MoreDialog$2$1]
                 candidates:
                  _m_j.cll.O000000o(java.lang.String, java.lang.Object, com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
                  _m_j.cll.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void */
                public void onClick(View view) {
                    chr.O000000o(chr.O0000Ooo);
                    chr.O000000o(chr.O000oo);
                    if (MoreDialog.this.mijiaCameraDevice.isReadOnlyShared()) {
                        izb.O000000o(MoreDialog.this.mContext, (int) R.string.auth_fail_read_only, 0).show();
                    } else if (MoreDialog.this.mijiaCameraDevice != null && MoreDialog.this.mijiaCameraDevice.O000000o() != null) {
                        MoreDialog.this.mijiaCameraDevice.O000000o().O000000o("power", false, (Callback<Void>) new Callback<Void>() {
                            /* class com.xiaomi.smarthome.camera.v4.view.MoreDialog.AnonymousClass2.AnonymousClass1 */

                            public void onSuccess(Void voidR) {
                                MoreDialog.this.dismiss();
                                boolean z = false;
                                MoreDialog.this.mstvSleep.setCurrentState(0);
                                MoreDialog.this.mijiaCameraDevice.O00000Oo().O000000o("power");
                                civ.O000000o("MoreDialog", "set sleep success");
                                if (MoreDialog.this.moreDialogListener != null) {
                                    IMoreDialogListener iMoreDialogListener = MoreDialog.this.moreDialogListener;
                                    if (MoreDialog.this.mstvSleep.getCurrentState() == 1) {
                                        z = true;
                                    }
                                    iMoreDialogListener.onPowerStateChanged(z);
                                }
                            }

                            public void onFailure(int i, String str) {
                                MoreDialog.this.dismiss();
                                MoreDialog.this.getContext();
                                gqg.O000000o((int) R.string.action_fail);
                                civ.O000000o("MoreDialog", "set sleep failed:" + i + " s:" + str);
                            }
                        });
                    }
                }
            }));
        } else {
            this.mstvSleep.addState(new MultiStateTextView.StateItem(R.string.sleep, R.drawable.widget_item_more_sleep, new View.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.v4.view.MoreDialog.AnonymousClass3 */

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: _m_j.cll.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
                 arg types: [java.lang.String, int, com.xiaomi.smarthome.camera.v4.view.MoreDialog$3$1]
                 candidates:
                  _m_j.cll.O000000o(java.lang.String, java.lang.Object, com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
                  _m_j.cll.O000000o(java.lang.String, boolean, com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void */
                public void onClick(View view) {
                    chr.O000000o(chr.O0000Ooo);
                    chr.O000000o(chr.O000oo);
                    if (MoreDialog.this.mijiaCameraDevice.isReadOnlyShared()) {
                        izb.O000000o(MoreDialog.this.mContext, (int) R.string.auth_fail_read_only, 0).show();
                    } else if (MoreDialog.this.mijiaCameraDevice != null && MoreDialog.this.mijiaCameraDevice.O000000o() != null) {
                        MoreDialog.this.mijiaCameraDevice.O000000o().O000000o("power", false, (Callback<Void>) new Callback<Void>() {
                            /* class com.xiaomi.smarthome.camera.v4.view.MoreDialog.AnonymousClass3.AnonymousClass1 */

                            public void onSuccess(Void voidR) {
                                MoreDialog.this.dismiss();
                                boolean z = false;
                                MoreDialog.this.mstvSleep.setCurrentState(0);
                                MoreDialog.this.mijiaCameraDevice.O00000Oo().O000000o("power");
                                civ.O000000o("MoreDialog", "set sleep success");
                                if (MoreDialog.this.moreDialogListener != null) {
                                    IMoreDialogListener iMoreDialogListener = MoreDialog.this.moreDialogListener;
                                    if (MoreDialog.this.mstvSleep.getCurrentState() == 1) {
                                        z = true;
                                    }
                                    iMoreDialogListener.onPowerStateChanged(z);
                                }
                            }

                            public void onFailure(int i, String str) {
                                MoreDialog.this.dismiss();
                                MoreDialog.this.getContext();
                                gqg.O000000o((int) R.string.action_fail);
                                civ.O000000o("MoreDialog", "set sleep failed:" + i + " s:" + str);
                            }
                        });
                    }
                }
            }));
        }
        cid cid = this.mijiaCameraDevice;
        if (cid != null && cid.O000000o() != null) {
            this.mstvSleep.setCurrentState(this.mijiaCameraDevice.O000000o().O000000o("power", false) ? 1 : 0);
        }
    }

    public void onClick(View view) {
        View.OnClickListener onClickListener = this.mListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }
}
