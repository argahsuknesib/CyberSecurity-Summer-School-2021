package _m_j;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.miio.db.record.MessageRecord;
import org.json.JSONException;
import org.json.JSONObject;

public final class gug extends gum {

    public class O000000o extends gul {

        /* renamed from: O000000o  reason: collision with root package name */
        String f18282O000000o;

        public final void O000000o(XQProgressDialog xQProgressDialog) {
        }

        public final boolean O00000Oo() {
            return false;
        }

        public O000000o() {
        }

        public final long O000000o() {
            return this.O00000oo.receiveTime;
        }

        public final void O000000o(SimpleDraweeView simpleDraweeView) {
            if (TextUtils.isEmpty(this.O00000oo.img_url) || this.O00000oo.img_url.equals("0")) {
                simpleDraweeView.setController((PipelineDraweeController) ((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setImageRequest(ImageRequestBuilder.newBuilderWithSource(gqd.O000000o((int) R.drawable.message_center_icon_news_default)).setPostprocessor(new gnz(simpleDraweeView.getResources().getColor(R.color.mj_color_orange_normal))).build())).setOldController(simpleDraweeView.getController())).build());
                return;
            }
            gyl.O000000o();
            gyl.O00000Oo(this.O00000oo.img_url, simpleDraweeView, new gnz(simpleDraweeView.getResources().getColor(R.color.mj_color_green_normal)));
        }

        public final void O000000o(TextView textView) {
            if (!O00000o(textView)) {
                textView.setText(this.O00000oo.title);
            }
        }

        public final void O00000Oo(TextView textView) {
            if (!O0000OOo()) {
                textView.setText(gou.O000000o(this.O00000oo.receiveTime * 1000) + " " + this.O00000oo.content);
            } else if (this.O0000O0o == null || this.O0000O0o.isNull("content")) {
                textView.setText(gou.O000000o(this.O00000oo.receiveTime * 1000) + " " + this.O00000oo.title);
            } else {
                textView.setText(gou.O000000o(this.O00000oo.receiveTime * 1000) + " " + this.O0000O0o.optString("content"));
            }
        }

        public final void O00000o0(TextView textView) {
            textView.setVisibility(8);
        }

        public final String O00000o0() {
            if (this.O00000oo == null) {
                return null;
            }
            return this.O00000oo.msgId;
        }

        public final void O000000o(Activity activity) {
            gug.O000000o(this.O0000O0o);
        }
    }

    public static boolean O000000o(JSONObject jSONObject) {
        Device O000000o2;
        if (jSONObject == null) {
            return false;
        }
        String optString = jSONObject.optString("subtype");
        if (TextUtils.isEmpty(optString)) {
            return false;
        }
        if (TextUtils.equals(optString, "scene_log")) {
            Bundle bundle = new Bundle();
            bundle.putInt("com.xiaomi.smarthome.request_code", 8);
            fvj.O000000o("SmartHomeMainActivity", bundle);
            return true;
        } else if (TextUtils.equals(optString, "device")) {
            String optString2 = jSONObject.optString("device_id");
            if (TextUtils.isEmpty(optString2) || (O000000o2 = fno.O000000o().O000000o(optString2)) == null || !O000000o2.isOnline) {
                return false;
            }
            String optString3 = jSONObject.optString("model");
            if (!TextUtils.isEmpty(optString3) && !TextUtils.equals(optString3, O000000o2.model)) {
                return false;
            }
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.setAction("android.intent.action.VIEW");
            intent.setPackage(ServiceApplication.getAppContext().getPackageName());
            intent.setData(Uri.parse("https://home.mi.com/device/" + optString3 + "?did=" + optString2));
            ServiceApplication.getAppContext().startActivity(intent);
            return true;
        } else if (TextUtils.equals(optString, "scene")) {
            return O000000o();
        } else {
            if (TextUtils.equals(optString, "device_list")) {
                fvj.O000000o("SmartHomeMainActivity", null, true, 67108864);
                return false;
            }
            if (TextUtils.equals(optString, "update")) {
                fvj.O000000o("UpdateActivity", null, true, 67108864);
            }
            return false;
        }
    }

    public static boolean O000000o() {
        Bundle bundle = new Bundle();
        bundle.putInt("com.xiaomi.smarthome.request_code", 3);
        fvj.O000000o("SmartHomeMainActivity", bundle);
        return true;
    }

    public final gul O000000o(MessageRecord messageRecord) {
        try {
            String optString = new JSONObject(messageRecord.params).optString("subtype");
            O000000o o000000o = new O000000o();
            try {
                o000000o.O00000oo = messageRecord;
                o000000o.f18282O000000o = optString;
                return o000000o;
            } catch (JSONException unused) {
                return o000000o;
            }
        } catch (JSONException unused2) {
            return null;
        }
    }
}
