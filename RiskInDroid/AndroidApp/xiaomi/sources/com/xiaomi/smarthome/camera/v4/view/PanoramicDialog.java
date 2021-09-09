package com.xiaomi.smarthome.camera.v4.view;

import _m_j.dz;
import _m_j.ee;
import _m_j.ei;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.xiaomi.smarthome.R;

public class PanoramicDialog extends dz {
    @BindView(6562)
    ImageView mBtn1;
    @BindView(6563)
    ImageView mBtn2;
    @BindView(6564)
    ImageView mBtn3;
    private PanoramicClickListener mClickListener;
    private String mCurrentChoose = "1";
    private String mModel;
    private String mPanoramType;

    public interface PanoramicClickListener {
        void onClick(String str);
    }

    @OnClick({6562, 6563, 6564, 6651, 6472})
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn1) {
            this.mCurrentChoose = "0";
            chooseBtn(this.mCurrentChoose);
        } else if (id == R.id.btn2) {
            this.mCurrentChoose = "1";
            chooseBtn(this.mCurrentChoose);
        } else if (id == R.id.btn3) {
            this.mCurrentChoose = "2";
            chooseBtn(this.mCurrentChoose);
        } else {
            if (id != R.id.cancel) {
                if (id == R.id.agree) {
                    PanoramicClickListener panoramicClickListener = this.mClickListener;
                    if (panoramicClickListener != null) {
                        panoramicClickListener.onClick(this.mCurrentChoose);
                    }
                } else {
                    return;
                }
            }
            dismiss();
        }
    }

    public PanoramicDialog setClickListener(PanoramicClickListener panoramicClickListener) {
        this.mClickListener = panoramicClickListener;
        return this;
    }

    public static PanoramicDialog newInstance(String str, String str2) {
        PanoramicDialog panoramicDialog = new PanoramicDialog();
        Bundle bundle = new Bundle();
        bundle.putString("model", str);
        bundle.putString("did", str2);
        panoramicDialog.setArguments(bundle);
        return panoramicDialog;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.mModel = getArguments().getString("model");
            this.mPanoramType = getArguments().getString("did");
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate((int) R.layout.dialog_camera_panormic, viewGroup, false);
        ButterKnife.bind(this, inflate);
        initView();
        return inflate;
    }

    private void initView() {
        String str = this.mPanoramType;
        this.mCurrentChoose = str;
        chooseBtn(str);
    }

    private void chooseBtn(String str) {
        if (TextUtils.equals(str, "0")) {
            this.mBtn1.setSelected(true);
            this.mBtn2.setSelected(false);
            this.mBtn3.setSelected(false);
        } else if (TextUtils.equals(str, "2")) {
            this.mBtn1.setSelected(false);
            this.mBtn2.setSelected(false);
            this.mBtn3.setSelected(true);
        } else {
            this.mBtn1.setSelected(false);
            this.mBtn2.setSelected(true);
            this.mBtn3.setSelected(false);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.getWindow().requestFeature(1);
        onCreateDialog.setCancelable(true);
        onCreateDialog.setCanceledOnTouchOutside(true);
        onCreateDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        return onCreateDialog;
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            Window window = dialog.getWindow();
            window.setGravity(80);
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
