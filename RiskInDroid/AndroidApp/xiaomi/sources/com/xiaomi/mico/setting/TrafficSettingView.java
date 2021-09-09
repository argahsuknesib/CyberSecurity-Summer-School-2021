package com.xiaomi.mico.setting;

import _m_j.ahh;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.xiaomi.mico.R2;
import com.xiaomi.mico.api.model.ThirdPartyResponse;
import com.xiaomi.mico.common.widget.TimePicker;
import com.xiaomi.mico.common.widget.TitleDesAndMore;
import com.xiaomi.mico.common.widget.TitleDescAndIcon;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class TrafficSettingView extends LinearLayout {
    TitleDescAndIcon homeAddress;
    private String mArriveTime = "";
    private ThirdPartyResponse.TrafficAddress mHomeAddress;
    private int mMode = 0;
    private ThirdPartyResponse.TrafficAddress mOfficeAddress;
    private List<ThirdPartyResponse.PlateInfo> mPlateInfo;
    private ThirdPartyResponse.TrafficInfo mTrafficInfo;
    TitleDescAndIcon micoAddress;
    TitleDescAndIcon officeAddress;
    TitleDesAndMore plateNumber;
    TitleDesAndMore reachTime;
    private int selectedMicoAddress = 2;
    TitleDesAndMore trafficStyle;

    public TrafficSettingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.micoAddress = (TitleDescAndIcon) findViewById(R.id.mico_address);
        this.micoAddress.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.setting.$$Lambda$TrafficSettingView$9ZiUMJsgD5Kc3btDufxaZ8WFnk */

            public final void onClick(View view) {
                TrafficSettingView.this.lambda$onFinishInflate$0$TrafficSettingView(view);
            }
        });
        this.homeAddress = (TitleDescAndIcon) findViewById(R.id.home_address);
        this.homeAddress.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.setting.$$Lambda$TrafficSettingView$Fi_QxGF2W2vK5qzRFovXPwjyRcM */

            public final void onClick(View view) {
                TrafficSettingView.this.lambda$onFinishInflate$1$TrafficSettingView(view);
            }
        });
        this.officeAddress = (TitleDescAndIcon) findViewById(R.id.office_address);
        this.officeAddress.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.setting.$$Lambda$TrafficSettingView$YEjFedKxE_j3m80P9NtkDwhD0xk */

            public final void onClick(View view) {
                TrafficSettingView.this.lambda$onFinishInflate$2$TrafficSettingView(view);
            }
        });
        this.plateNumber = (TitleDesAndMore) findViewById(R.id.plate_number);
        this.plateNumber.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.setting.$$Lambda$TrafficSettingView$9CO0hTaQKy4t73yOYWzTvycP6fM */

            public final void onClick(View view) {
                TrafficSettingView.this.lambda$onFinishInflate$3$TrafficSettingView(view);
            }
        });
        this.reachTime = (TitleDesAndMore) findViewById(R.id.reach_time);
        this.reachTime.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.setting.$$Lambda$TrafficSettingView$oQ1aCq6LzGbRW9yftKqtjFjgn3I */

            public final void onClick(View view) {
                TrafficSettingView.this.lambda$onFinishInflate$4$TrafficSettingView(view);
            }
        });
        this.trafficStyle = (TitleDesAndMore) findViewById(R.id.traffic_style);
        this.trafficStyle.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.setting.$$Lambda$TrafficSettingView$oFHId3CErxQ2vYAJoy1K1gvhbRc */

            public final void onClick(View view) {
                TrafficSettingView.this.lambda$onFinishInflate$5$TrafficSettingView(view);
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    public void setData(ThirdPartyResponse.TrafficInfo trafficInfo) {
        this.mTrafficInfo = trafficInfo;
        if (!TextUtils.isEmpty(trafficInfo.origination)) {
            this.mHomeAddress = ThirdPartyResponse.TrafficAddress.from(trafficInfo.origination);
            if (!(this.mHomeAddress.lng == 0.0d && this.mHomeAddress.lat == 0.0d)) {
                setHomeAddress(this.mHomeAddress);
                if (!TextUtils.isEmpty(trafficInfo.destination)) {
                    this.mOfficeAddress = ThirdPartyResponse.TrafficAddress.from(trafficInfo.destination);
                    if (!(this.mOfficeAddress.lat == 0.0d && this.mOfficeAddress.lng == 0.0d)) {
                        setOfficeAddress(this.mOfficeAddress);
                        if (!TextUtils.isEmpty(trafficInfo.speakerLocation)) {
                            ThirdPartyResponse.TrafficAddress from = ThirdPartyResponse.TrafficAddress.from(trafficInfo.speakerLocation);
                            ThirdPartyResponse.TrafficAddress trafficAddress = this.mHomeAddress;
                            if (trafficAddress != null && trafficAddress.lat == from.lat && this.mHomeAddress.lng == from.lng) {
                                this.selectedMicoAddress = 0;
                            } else {
                                ThirdPartyResponse.TrafficAddress trafficAddress2 = this.mOfficeAddress;
                                if (trafficAddress2 != null && trafficAddress2.lat == from.lat && this.mOfficeAddress.lng == from.lng) {
                                    this.selectedMicoAddress = 1;
                                }
                            }
                        }
                        if (this.selectedMicoAddress < 2) {
                            this.micoAddress.setDescription(getResources().getStringArray(R.array.traffic_mico_address)[this.selectedMicoAddress]);
                        } else {
                            this.micoAddress.setDescription(getResources().getString(R.string.setting_traffic_unknown));
                        }
                        this.mMode = trafficInfo.navigationMode.intValue();
                        setTrafficMode(this.mMode);
                        this.mArriveTime = trafficInfo.arriveTime;
                        this.reachTime.setDescription(this.mArriveTime);
                        if (trafficInfo.plateNumberList == null && trafficInfo.plateNumberList.size() > 0) {
                            this.plateNumber.setDescription(trafficInfo.plateNumberList.get(0));
                            return;
                        }
                        return;
                    }
                }
                this.officeAddress.setDescription(getContext().getString(R.string.setting_traffic_home_default));
                if (!TextUtils.isEmpty(trafficInfo.speakerLocation)) {
                }
                if (this.selectedMicoAddress < 2) {
                }
                this.mMode = trafficInfo.navigationMode.intValue();
                setTrafficMode(this.mMode);
                this.mArriveTime = trafficInfo.arriveTime;
                this.reachTime.setDescription(this.mArriveTime);
                if (trafficInfo.plateNumberList == null) {
                    return;
                }
                return;
            }
        }
        this.homeAddress.setDescription(getContext().getString(R.string.setting_traffic_home_default));
        if (!TextUtils.isEmpty(trafficInfo.destination)) {
        }
        this.officeAddress.setDescription(getContext().getString(R.string.setting_traffic_home_default));
        if (!TextUtils.isEmpty(trafficInfo.speakerLocation)) {
        }
        if (this.selectedMicoAddress < 2) {
        }
        this.mMode = trafficInfo.navigationMode.intValue();
        setTrafficMode(this.mMode);
        this.mArriveTime = trafficInfo.arriveTime;
        this.reachTime.setDescription(this.mArriveTime);
        if (trafficInfo.plateNumberList == null) {
        }
    }

    /* renamed from: onViewClicked */
    public void lambda$onFinishInflate$5$TrafficSettingView(View view) {
        int id = view.getId();
        if (id == R.id.mico_address) {
            new MLAlertDialog.Builder(getContext()).O000000o((int) R.array.traffic_mico_address, this.selectedMicoAddress, new DialogInterface.OnClickListener(R.array.traffic_mico_address) {
                /* class com.xiaomi.mico.setting.$$Lambda$TrafficSettingView$Ir_wtmRueCy8mTLvE6MvINfaOo0 */
                private final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    TrafficSettingView.this.lambda$onViewClicked$6$TrafficSettingView(this.f$1, dialogInterface, i);
                }
            }).O00000o().show();
        } else if (id == R.id.home_address) {
            Intent intent = new Intent(getContext(), AddressSelectionActivity.class);
            intent.putExtra("custome_title", getContext().getString(R.string.setting_traffic_home));
            ThirdPartyResponse.TrafficAddress trafficAddress = this.mHomeAddress;
            if (trafficAddress != null) {
                intent.putExtra("SELECTED_ADDRESS", trafficAddress.toPOIResponse());
            }
            ((Activity) getContext()).startActivityForResult(intent, 991);
        } else if (id == R.id.office_address) {
            Intent intent2 = new Intent(getContext(), AddressSelectionActivity.class);
            intent2.putExtra("custome_title", getContext().getString(R.string.setting_traffic_office));
            ThirdPartyResponse.TrafficAddress trafficAddress2 = this.mOfficeAddress;
            if (trafficAddress2 != null) {
                intent2.putExtra("SELECTED_ADDRESS", trafficAddress2.toPOIResponse());
            }
            ((Activity) getContext()).startActivityForResult(intent2, 992);
        } else if (id == R.id.traffic_style) {
            new MLAlertDialog.Builder(getContext()).O000000o((int) R.array.traffic_style, this.mMode, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.mico.setting.$$Lambda$TrafficSettingView$d5QxuNyfOnBADmtFf4C5MrR0diw */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    TrafficSettingView.this.lambda$onViewClicked$7$TrafficSettingView(dialogInterface, i);
                }
            }).O00000o().show();
        } else if (id == R.id.plate_number) {
            Intent intent3 = new Intent(getContext(), PlateNumberActivity.class);
            ThirdPartyResponse.TrafficInfo trafficInfo = this.mTrafficInfo;
            if (!(trafficInfo == null || trafficInfo.plateInfoList == null)) {
                intent3.putExtra("PLATENUMBER_INFO", (Serializable) this.mTrafficInfo.plateInfoList);
            }
            ((Activity) getContext()).startActivityForResult(intent3, R2.attr.name);
        } else if (id == R.id.reach_time) {
            inputReachTime();
        }
    }

    public /* synthetic */ void lambda$onViewClicked$6$TrafficSettingView(int i, DialogInterface dialogInterface, int i2) {
        this.micoAddress.setDescription(getResources().getStringArray(i)[i2]);
        this.selectedMicoAddress = i2;
        dialogInterface.dismiss();
    }

    public /* synthetic */ void lambda$onViewClicked$7$TrafficSettingView(DialogInterface dialogInterface, int i) {
        setTrafficMode(i);
        dialogInterface.dismiss();
    }

    public ThirdPartyResponse.TrafficAddress getHomeAddress() {
        return this.mHomeAddress;
    }

    public void setHomeAddress(ThirdPartyResponse.TrafficAddress trafficAddress) {
        this.mHomeAddress = trafficAddress;
        this.homeAddress.setDescription(String.format("%s %s %s", trafficAddress.city, trafficAddress.district, trafficAddress.name));
    }

    public void setOfficeAddress(ThirdPartyResponse.TrafficAddress trafficAddress) {
        this.mOfficeAddress = trafficAddress;
        this.officeAddress.setDescription(String.format("%s %s %s", trafficAddress.city, trafficAddress.district, trafficAddress.name));
    }

    public ThirdPartyResponse.TrafficAddress getOfficeAddress() {
        return this.mOfficeAddress;
    }

    public ThirdPartyResponse.TrafficAddress getMicoAddress() {
        if (this.selectedMicoAddress == 0) {
            return this.mHomeAddress;
        }
        return this.mOfficeAddress;
    }

    private void inputReachTime() {
        TimePicker timePicker = new TimePicker(getContext());
        timePicker.setIs24HourView(Boolean.TRUE);
        if (!TextUtils.isEmpty(this.mArriveTime)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
            try {
                simpleDateFormat.parse(this.mArriveTime);
                timePicker.setCurrentHour(Integer.valueOf(simpleDateFormat.getCalendar().get(11)));
                timePicker.setCurrentMinute(Integer.valueOf(simpleDateFormat.getCalendar().get(12)));
            } catch (ParseException e) {
                ahh.O000000o(e);
            }
        }
        new MLAlertDialog.Builder(getContext()).O000000o((int) R.string.setting_traffic_reach_time).O000000o(timePicker, 0, getResources().getDimensionPixelSize(R.dimen.passport_dialog_title_vertical_padding), 0, 0).O00000Oo((int) R.string.common_cancel, $$Lambda$TrafficSettingView$YeCUPws1wN0VzTijrxvvlIa7w.INSTANCE).O000000o((int) R.string.common_confirm, new DialogInterface.OnClickListener(timePicker) {
            /* class com.xiaomi.mico.setting.$$Lambda$TrafficSettingView$GPSCLDrk1LFVIA8WLBJQCbc6tcg */
            private final /* synthetic */ TimePicker f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                TrafficSettingView.this.lambda$inputReachTime$9$TrafficSettingView(this.f$1, dialogInterface, i);
            }
        }).O00000o().show();
    }

    public /* synthetic */ void lambda$inputReachTime$9$TrafficSettingView(TimePicker timePicker, DialogInterface dialogInterface, int i) {
        String format = String.format("%02d:%02d", timePicker.getCurrentHour(), timePicker.getCurrentMinute());
        this.reachTime.setDescription(format);
        this.mArriveTime = format;
    }

    public void setTrafficMode(int i) {
        int i2 = 0;
        if (i < 0 || i > 3) {
            i = 0;
        }
        this.trafficStyle.setDescription(getContext().getResources().getStringArray(R.array.traffic_style)[i]);
        TitleDesAndMore titleDesAndMore = this.plateNumber;
        if (i != 0) {
            i2 = 8;
        }
        titleDesAndMore.setVisibility(i2);
        this.mMode = i;
    }

    public int getMode() {
        return this.mMode;
    }

    public String getArriveTime() {
        return this.mArriveTime;
    }

    public List<ThirdPartyResponse.PlateInfo> getPlateInfo() {
        return this.mPlateInfo;
    }

    public void setPlateInfo(List<ThirdPartyResponse.PlateInfo> list) {
        this.mPlateInfo = list;
    }

    public boolean isMicoAddressIllegal() {
        ThirdPartyResponse.TrafficAddress trafficAddress;
        if (this.selectedMicoAddress == 0 && ((trafficAddress = this.mHomeAddress) == null || (trafficAddress.lng == 0.0d && this.mHomeAddress.lat == 0.0d))) {
            return true;
        }
        if (this.selectedMicoAddress != 1) {
            return false;
        }
        ThirdPartyResponse.TrafficAddress trafficAddress2 = this.mOfficeAddress;
        if (trafficAddress2 == null || (trafficAddress2.lng == 0.0d && this.mOfficeAddress.lat == 0.0d)) {
            return true;
        }
        return false;
    }
}
