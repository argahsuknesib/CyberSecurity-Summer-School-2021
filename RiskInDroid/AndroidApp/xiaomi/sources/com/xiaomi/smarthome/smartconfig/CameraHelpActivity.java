package com.xiaomi.smarthome.smartconfig;

import _m_j.gnk;
import _m_j.hua;
import _m_j.hub;
import _m_j.huc;
import _m_j.hud;
import _m_j.hue;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.CloseableImage;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.smartconfig.callback.ConfigKeyValuePair;
import com.xiaomi.smarthome.smartconfig.callback.ConfigNetRequest;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class CameraHelpActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private SimpleDraweeView f11405O000000o;
    private DataSource<CloseableReference<CloseableImage>> O00000Oo;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_camera_help);
        String stringExtra = getIntent().getStringExtra("model");
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.follow_me);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.CameraHelpActivity.AnonymousClass1 */

            public final void onClick(View view) {
                CameraHelpActivity.this.finish();
            }
        });
        this.f11405O000000o = (SimpleDraweeView) findViewById(R.id.image);
        findViewById(R.id.knows).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.CameraHelpActivity.AnonymousClass2 */

            public final void onClick(View view) {
                CameraHelpActivity.this.finish();
            }
        });
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("model", stringExtra);
        } catch (Exception e) {
            e.printStackTrace();
        }
        arrayList.add(new ConfigKeyValuePair("data", jSONObject.toString()));
        ConfigNetRequest.O000000o o000000o = new ConfigNetRequest.O000000o();
        o000000o.f11489O000000o = "POST";
        ConfigNetRequest.O000000o O000000o2 = o000000o.O000000o("/plugin/get_model_guide_pic");
        O000000o2.O00000o0 = arrayList;
        ConfigNetRequest O000000o3 = O000000o2.O000000o();
        final AnonymousClass4 r0 = new hua<String, hud>() {
            /* class com.xiaomi.smarthome.smartconfig.CameraHelpActivity.AnonymousClass4 */

            public final /* synthetic */ void O000000o(Object obj) {
                String str = (String) obj;
                gnk.O00000o0(String.format("onSuccess %s", str));
                if (!TextUtils.isEmpty(str)) {
                    CameraHelpActivity.this.loadGuidePic(str);
                }
            }

            public final void O000000o(hud hud) {
                gnk.O00000o0(String.format("onFailure %s", hud));
            }
        };
        final AnonymousClass5 r1 = new hub<String>() {
            /* class com.xiaomi.smarthome.smartconfig.CameraHelpActivity.AnonymousClass5 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return jSONObject.optString("guide_pic", "");
            }
        };
        SmartConfigRouterFactory.getSmartConfigManager().sendSmartHomeRequest(O000000o3, new huc() {
            /* class com.xiaomi.smarthome.smartconfig.CameraHelpActivity.AnonymousClass6 */

            public final void O000000o(String str) {
                hue.O000000o().O000000o(str, r1, r0);
            }

            public final void O000000o(int i, String str) {
                hua hua = r0;
                if (hua != null) {
                    hua.O00000Oo(new hud(i, str));
                }
            }
        });
    }

    public void loadGuidePic(final String str) {
        if (this.f11405O000000o.getHierarchy() == null) {
            this.f11405O000000o.setHierarchy(new GenericDraweeHierarchyBuilder(this.f11405O000000o.getResources()).setFadeDuration(200).setPlaceholderImage(this.f11405O000000o.getResources().getDrawable(R.drawable.device_list_phone_no)).setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).build());
        }
        if (!TextUtils.isEmpty(str) && str.startsWith("http")) {
            this.f11405O000000o.setImageURI(Uri.parse(str));
            DraweeController controller = this.f11405O000000o.getController();
            if (controller instanceof AbstractDraweeController) {
                ((AbstractDraweeController) controller).addControllerListener(new BaseControllerListener() {
                    /* class com.xiaomi.smarthome.smartconfig.CameraHelpActivity.AnonymousClass3 */

                    public final void onFailure(String str, Throwable th) {
                        Fresco.getImagePipeline().evictFromMemoryCache(Uri.parse(str));
                        Fresco.getImagePipeline().evictFromDiskCache(Uri.parse(str));
                    }
                });
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        DataSource<CloseableReference<CloseableImage>> dataSource = this.O00000Oo;
        if (dataSource != null) {
            dataSource.close();
        }
    }
}
