package com.xiaomi.smarthome.miio.dialog;

import _m_j.dz;
import _m_j.ee;
import _m_j.ei;
import _m_j.gri;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.xiaomi.smarthome.R;

public class BleGatewayMeshDialog extends dz {

    /* renamed from: O000000o  reason: collision with root package name */
    public O000000o f9716O000000o;
    private int O00000Oo;
    private boolean O00000o0;
    @BindView(4885)
    Button mBtnAgree;
    @BindView(4969)
    Button mBtnCancel;
    @BindView(5088)
    TextView mContent;
    @BindView(5400)
    View mMiddleLine;

    public interface O000000o {
        void O000000o();
    }

    public static BleGatewayMeshDialog O000000o(int i, boolean z) {
        BleGatewayMeshDialog bleGatewayMeshDialog = new BleGatewayMeshDialog();
        Bundle bundle = new Bundle();
        bundle.putInt("type", i);
        bundle.putBoolean("isMesh", z);
        bleGatewayMeshDialog.setArguments(bundle);
        return bleGatewayMeshDialog;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.O00000Oo = getArguments().getInt("type");
            this.O00000o0 = getArguments().getBoolean("isMesh");
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate((int) R.layout.dialog_blegateway_mesh, viewGroup, false);
        ButterKnife.bind(this, inflate);
        int i = this.O00000Oo;
        if (i == 1) {
            this.mContent.setText((int) R.string.ble_mesh_dialog_close_tip);
        } else if (i == 2) {
            this.mBtnAgree.setText((int) R.string.ble_mesh_dialog_ok);
            this.mContent.setText((int) R.string.ble_mesh_dialog_download_xiaoai_app);
        } else if (i == 3) {
            this.mBtnAgree.setVisibility(8);
            this.mMiddleLine.setVisibility(8);
            this.mBtnCancel.setText((int) R.string.ble_mesh_dialog_know);
            this.mContent.setText((int) R.string.ble_mesh_dialog_update_hardware);
            this.mBtnCancel.setBackgroundResource(R.drawable.dialog_btn_selector);
        } else if (i == 4) {
            this.mBtnAgree.setText((int) R.string.ble_mesh_dialog_ok);
            if (this.O00000o0) {
                this.mContent.setText((int) R.string.ble_mesh_dialog_goto_app_mesh);
            } else {
                this.mContent.setText((int) R.string.ble_mesh_dialog_goto_app);
            }
        }
        this.mBtnCancel.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.dialog.BleGatewayMeshDialog.AnonymousClass1 */

            public final void onClick(View view) {
                BleGatewayMeshDialog.this.dismiss();
            }
        });
        this.mBtnAgree.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.dialog.BleGatewayMeshDialog.AnonymousClass2 */

            public final void onClick(View view) {
                if (BleGatewayMeshDialog.this.f9716O000000o != null) {
                    BleGatewayMeshDialog.this.f9716O000000o.O000000o();
                }
                BleGatewayMeshDialog.this.dismiss();
            }
        });
        return inflate;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.getWindow().requestFeature(1);
        onCreateDialog.setCancelable(false);
        onCreateDialog.setCanceledOnTouchOutside(false);
        onCreateDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        return onCreateDialog;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.drawable.InsetDrawable.<init>(android.graphics.drawable.Drawable, int, int, int, int):void}
     arg types: [android.graphics.drawable.ColorDrawable, int, int, int, int]
     candidates:
      ClspMth{android.graphics.drawable.InsetDrawable.<init>(android.graphics.drawable.Drawable, float, float, float, float):void}
      ClspMth{android.graphics.drawable.InsetDrawable.<init>(android.graphics.drawable.Drawable, int, int, int, int):void} */
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            Window window = dialog.getWindow();
            window.setGravity(80);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) new ColorDrawable(0), gri.O000000o(8.0f), gri.O000000o(8.0f), gri.O000000o(8.0f), gri.O000000o(8.0f)));
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void show(ee eeVar, String str) {
        ei O000000o2 = eeVar.O000000o();
        O000000o2.O000000o(this, str);
        O000000o2.O00000o0();
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }

    public void onDestroyView() {
        super.onDestroyView();
    }
}
