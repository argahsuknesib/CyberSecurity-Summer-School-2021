package _m_j;

import _m_j.dpd;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.xiaomi.smarthome.R;
import java.io.FileInputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public final class ewc extends euk<ewr, vr> {
    public final int O000000o() {
        return 100;
    }

    public final int O00000Oo() {
        return R.layout.virtual_view;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dow.O000000o(byte[], boolean):int
     arg types: [byte[], int]
     candidates:
      _m_j.dow.O000000o(int, _m_j.dpf$O000000o):boolean
      _m_j.dow.O000000o(byte[], boolean):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.don.O000000o(java.lang.String, boolean):android.view.View
     arg types: [java.lang.String, int]
     candidates:
      _m_j.don.O000000o(_m_j.dom, int):void
      _m_j.don.O000000o(java.lang.String, boolean):android.view.View */
    public final /* synthetic */ void O000000o(vr vrVar, Object obj, int i) {
        ewr ewr = (ewr) obj;
        LinearLayout linearLayout = (LinearLayout) vrVar.itemView.findViewById(R.id.layout_container);
        String str = ewr.O0000o0O;
        String str2 = ewr.O0000o0o;
        byte[] O000000o2 = O000000o(exa.f15909O000000o + "/" + str + ".out");
        if (O000000o2 != null) {
            eui.O00000o0();
            dow.O000000o(O000000o2, true);
            if (!TextUtils.isEmpty(str2)) {
                byte[] O000000o3 = O000000o(exa.f15909O000000o + "/" + str2 + ".out");
                if (O000000o3 != null) {
                    eui.O00000o0();
                    dow.O000000o(O000000o3, true);
                }
            }
            View O000000o4 = eui.O00000Oo().O0000OoO().O000000o(str, true);
            dpb dpb = (dpb) O000000o4;
            try {
                dpb.getVirtualView().O000000o(new JSONObject(new Gson().toJson(ewr)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            dpd.O000000o O000O0oo = dpb.getVirtualView().O000O0oo();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(O000O0oo.f14826O000000o, O000O0oo.O00000Oo);
            layoutParams.leftMargin = O000O0oo.O00000o;
            layoutParams.topMargin = O000O0oo.O0000OOo;
            layoutParams.rightMargin = O000O0oo.O00000oo;
            layoutParams.bottomMargin = O000O0oo.O0000Oo;
            linearLayout.removeAllViews();
            linearLayout.addView(O000000o4, layoutParams);
            RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) linearLayout.getLayoutParams();
            layoutParams2.bottomMargin = dul.O000000o(linearLayout.getContext(), 35.0f);
            linearLayout.setLayoutParams(layoutParams2);
        }
    }

    public final /* bridge */ /* synthetic */ void O00000Oo(vr vrVar, Object obj, int i) {
        super.O00000Oo(vrVar, (ewr) obj, i);
    }

    private static byte[] O000000o(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            fileInputStream.close();
            return bArr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
