package com.xiaomi.mico.setting;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.xiaomi.mico.api.model.ThirdPartyResponse;
import com.xiaomi.mico.base.MicoBaseActivity;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.mico.common.widget.SlidingButton;
import com.xiaomi.mico.common.widget.TitleBar;
import com.xiaomi.mico.common.widget.TitleDesAndMore;
import com.xiaomi.mico.common.widget.dialog.InputViewDialog;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import java.io.Serializable;

public class EditPlateNumberActivity extends MicoBaseActivity {
    private ThirdPartyResponse.PlateInfo mPlateInfo;
    TitleDesAndMore name;
    TitleDesAndMore number;
    SlidingButton switcher;
    TitleBar titleBar;

    static /* synthetic */ void lambda$inputPlateNumber$3(DialogInterface dialogInterface, int i) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_edit_plate_number);
        this.titleBar = (TitleBar) findViewById(R.id.title_bar);
        this.switcher = (SlidingButton) findViewById(R.id.switcher);
        this.name = (TitleDesAndMore) findViewById(R.id.name);
        this.number = (TitleDesAndMore) findViewById(R.id.number);
        this.titleBar.setOnLeftIconClickListener(new TitleBar.OnLeftIconClickListener() {
            /* class com.xiaomi.mico.setting.$$Lambda$EditPlateNumberActivity$IiiGhwf1FB00g9sdSsuMCDwirpI */

            public final void onLeftIconClick() {
                EditPlateNumberActivity.this.lambda$onCreate$0$EditPlateNumberActivity();
            }
        });
        this.titleBar.setOnRightButtonClickListener(new TitleBar.OnRightButtonClickListener() {
            /* class com.xiaomi.mico.setting.$$Lambda$EditPlateNumberActivity$PV9IPmNd0haqL2Q2DEa161u8JI */

            public final void onRightButtonClick() {
                EditPlateNumberActivity.this.lambda$onCreate$1$EditPlateNumberActivity();
            }
        });
        this.number.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.setting.EditPlateNumberActivity.AnonymousClass1 */

            public void onClick(View view) {
                EditPlateNumberActivity.this.inputPlateNumber();
            }
        });
        this.name.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.setting.$$Lambda$EditPlateNumberActivity$9yNUtxE5UZ9cWYYIxAn1kJHHzsM */

            public final void onClick(View view) {
                EditPlateNumberActivity.this.lambda$onCreate$2$EditPlateNumberActivity(view);
            }
        });
        Serializable serializableExtra = getIntent().getSerializableExtra("PLATENUMBER_INFO");
        if (serializableExtra != null && (serializableExtra instanceof ThirdPartyResponse.PlateInfo)) {
            this.mPlateInfo = (ThirdPartyResponse.PlateInfo) serializableExtra;
            this.switcher.setChecked(this.mPlateInfo.newEnergy, false);
            this.name.setDescription(this.mPlateInfo.name);
            this.number.setDescription(this.mPlateInfo.number);
        }
    }

    public /* synthetic */ void lambda$onCreate$0$EditPlateNumberActivity() {
        setResult(0);
        finish();
    }

    public /* synthetic */ void lambda$onCreate$1$EditPlateNumberActivity() {
        ThirdPartyResponse.PlateInfo plateInfo = new ThirdPartyResponse.PlateInfo();
        ThirdPartyResponse.PlateInfo plateInfo2 = this.mPlateInfo;
        if (plateInfo2 != null) {
            plateInfo.index = plateInfo2.index;
        }
        plateInfo.name = this.name.getDescription();
        plateInfo.newEnergy = this.switcher.isChecked();
        plateInfo.number = this.number.getDescription();
        if (TextUtils.isEmpty(plateInfo.number) || plateInfo.number.equals(getString(R.string.setting_not_set))) {
            ToastUtil.showToast((int) R.string.imput_plate_number_error);
        } else if (TextUtils.isEmpty(plateInfo.name) || plateInfo.name.equals(getString(R.string.setting_not_set))) {
            ToastUtil.showToast((int) R.string.imput_plate_name_error);
        } else {
            Intent intent = new Intent();
            intent.putExtra("PLATENUMBER_INFO", plateInfo);
            setResult(-1, intent);
            finish();
        }
    }

    public /* synthetic */ void lambda$onCreate$2$EditPlateNumberActivity(View view) {
        inputName();
    }

    private void inputName() {
        new InputViewDialog(getContext()).setTitle((int) R.string.traffic_plate_number_comment).setInitText(this.name.isDefaultValueChanged() ? this.name.getDescription() : "").setMaxInputLength(20).setListener(new InputViewDialog.Listener() {
            /* class com.xiaomi.mico.setting.EditPlateNumberActivity.AnonymousClass2 */

            public void onFinish(String str) {
                EditPlateNumberActivity.this.name.setDescription(str);
            }
        }).show();
    }

    public void inputPlateNumber() {
        InputPlateNumberView inputPlateNumberView = (InputPlateNumberView) LayoutInflater.from(getContext()).inflate((int) R.layout.input_plate_number_view, (ViewGroup) null);
        inputPlateNumberView.setPlateNumber(this.number.isDefaultValueChanged() ? this.number.getDescription() : "");
        new MLAlertDialog.Builder(getContext()).O000000o((int) R.string.imput_plate_number_hint).O000000o(inputPlateNumberView).O00000Oo((int) R.string.common_cancel, $$Lambda$EditPlateNumberActivity$Ep0p4xx3VkqEVueOz_WLDTUv6o.INSTANCE).O000000o((int) R.string.common_confirm, new DialogInterface.OnClickListener(inputPlateNumberView) {
            /* class com.xiaomi.mico.setting.$$Lambda$EditPlateNumberActivity$LsL4f5bN7a1fk5gSLTzRMTVmUls */
            private final /* synthetic */ InputPlateNumberView f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                EditPlateNumberActivity.this.lambda$inputPlateNumber$4$EditPlateNumberActivity(this.f$1, dialogInterface, i);
            }
        }).O00000o().show();
    }

    public /* synthetic */ void lambda$inputPlateNumber$4$EditPlateNumberActivity(InputPlateNumberView inputPlateNumberView, DialogInterface dialogInterface, int i) {
        if (inputPlateNumberView.isNumberValid()) {
            this.number.setDescription(inputPlateNumberView.getPlateNumber());
            dialogInterface.dismiss();
            return;
        }
        Toast.makeText(getContext(), (int) R.string.imput_plate_number_error, 1).show();
    }
}
