package com.xiaomi.smarthome.mibrain.anothernamesetting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.multikey.PowerMultikeyActivity;
import java.util.ArrayList;
import java.util.List;

public class AnotherNameMultiKeyActivity extends PowerMultikeyActivity {
    private LinearLayout O00000Oo;

    public static void startActivity(Activity activity, String str, String str2) {
        Intent intent = new Intent(activity, AnotherNameMultiKeyActivity.class);
        intent.putExtra("from", 1);
        intent.putExtra("device_id", str);
        intent.putExtra("device_mac", str2);
        activity.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.mAdapter != null) {
            this.mAdapter.O00000o0 = new PowerMultikeyActivity.O000000o() {
                /* class com.xiaomi.smarthome.mibrain.anothernamesetting.$$Lambda$AnotherNameMultiKeyActivity$xjO1rIHa2_ItQXklR4bw6tkO3rU */

                public final void onItemClick(List list, int i) {
                    AnotherNameMultiKeyActivity.this.O000000o(list, i);
                }
            };
        }
        this.mTitleTv.setText((int) R.string.voice_another_name_setting);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(List list, int i) {
        ArrayList arrayList = (ArrayList) list;
        requestUpdate(arrayList);
        Intent intent = new Intent(this, AnotherNameEditActivity.class);
        intent.putExtra("key_alias_did", this.mDevice.did);
        intent.putExtra("key_multi_btn", true);
        intent.putExtra("key_multi_btn_name_position", i);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("key_multi_btn_name_bean_list", arrayList);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void onBackPressed() {
        LinearLayout linearLayout = this.O00000Oo;
        if (linearLayout == null || linearLayout.getVisibility() != 0) {
            super.onBackPressed();
        } else {
            this.O00000Oo.setVisibility(8);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.module_a_3_return_btn) {
            onBackPressed();
        } else if (id == R.id.module_a_3_right_iv_setting_btn) {
            if (this.O00000Oo == null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
                this.O00000Oo = (LinearLayout) View.inflate(this, R.layout.another_name_guide, null);
                this.O00000Oo.setLayoutParams(layoutParams);
                ((ViewGroup) findViewById(16908290)).addView(this.O00000Oo);
                this.O00000Oo.findViewById(R.id.guide_cancel).setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.mibrain.anothernamesetting.$$Lambda$AnotherNameMultiKeyActivity$n1WWULcVyjHbB_0IcjNXQ2MxLzo */

                    public final void onClick(View view) {
                        AnotherNameMultiKeyActivity.this.O000000o(view);
                    }
                });
            }
            this.O00000Oo.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        this.O00000Oo.setVisibility(8);
    }
}
