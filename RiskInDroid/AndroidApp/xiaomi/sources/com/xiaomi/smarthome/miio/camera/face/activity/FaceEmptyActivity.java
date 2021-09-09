package com.xiaomi.smarthome.miio.camera.face.activity;

import _m_j.gqg;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.miio.camera.face.FaceManager;
import com.xiaomi.smarthome.miio.camera.face.util.FaceUtils;

public class FaceEmptyActivity extends FaceManagerBaseActivity implements View.OnClickListener {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_face_empty);
        ((TextView) findViewById(R.id.title_bar_title)).setText((int) R.string.type_in_face);
        findViewById(R.id.title_bar_more).setVisibility(8);
        findViewById(R.id.title_bar_return).setOnClickListener(this);
        findViewById(R.id.btn_album).setOnClickListener(this);
        findViewById(R.id.btn_camera).setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.title_bar_return) {
            finish();
        } else if (view.getId() == R.id.btn_album) {
            String str = XmPluginHostApi.instance().getDeviceByDid(mFaceManager.getDeviceId()).userId;
            FaceUtils.tryChoosePicture(this, mFaceManager.getDeviceId() + str);
        } else if (view.getId() == R.id.btn_camera) {
            FaceUtils.tryJumpFaceCamera(this);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if ((i == 101 || i == 102) && i2 == -1) {
            FaceUtils.processMarkFace(getContext(), intent.getStringExtra("faceId"), mFaceManager, new FaceManager.IFaceCallback() {
                /* class com.xiaomi.smarthome.miio.camera.face.activity.FaceEmptyActivity.AnonymousClass1 */

                public void onSuccess(Object obj, Object obj2) {
                    gqg.O00000Oo((int) R.string.action_success);
                    Intent intent = new Intent(FaceEmptyActivity.this.getContext(), FaceManagerActivity.class);
                    if (FaceManagerBaseActivity.mFaceManager != null && FaceManagerBaseActivity.mFaceManager.getDevice().getModel().equals("chuangmi.camera.ipc022")) {
                        String str = XmPluginHostApi.instance().getDeviceByDid(FaceManagerBaseActivity.mFaceManager.getDeviceId()).userId;
                        FaceUtils.setNeedGotoManage(FaceManagerBaseActivity.mFaceManager.getDeviceId() + str);
                        intent.setClass(FaceEmptyActivity.this.getContext(), FaceManager2Activity.class);
                    }
                    FaceEmptyActivity.this.startActivity(intent);
                    FaceEmptyActivity.this.finish();
                }

                public void onFailure(int i, String str) {
                    gqg.O00000Oo((int) R.string.action_fail);
                }
            });
        }
    }
}
