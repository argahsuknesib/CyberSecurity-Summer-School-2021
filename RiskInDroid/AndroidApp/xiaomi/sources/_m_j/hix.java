package _m_j;

import android.content.Context;
import android.content.Intent;
import com.xiaomi.idm.tap.dispatcher.impl.AbstractActionExecutor;
import com.xiaomi.smarthome.nfctag.ui.NFCOpenDeviceActivity;

public final class hix extends AbstractActionExecutor {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f18967O000000o;
    private String O00000Oo;
    private Context O00000o;
    private String O00000o0;

    public hix(Context context, String str, String str2, String str3) {
        this.O00000o = context;
        this.f18967O000000o = str;
        this.O00000o0 = str2;
        this.O00000Oo = str3;
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
    public final boolean execute() {
        Context context = this.O00000o;
        if (context == null) {
            return false;
        }
        Intent intent = new Intent(context, NFCOpenDeviceActivity.class);
        intent.setAction("com.xiaomi.smarthome.action.viewdevice");
        intent.putExtra("user_model", this.O00000o0);
        intent.putExtra("device_id", this.f18967O000000o);
        intent.putExtra("nfc_extra_data", this.O00000Oo);
        intent.putExtra("from_main_activity", true);
        this.O00000o.startActivity(intent);
        return true;
    }
}
