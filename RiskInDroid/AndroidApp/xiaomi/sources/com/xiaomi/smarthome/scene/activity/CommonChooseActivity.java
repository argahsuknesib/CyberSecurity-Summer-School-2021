package com.xiaomi.smarthome.scene.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.scene.activity.SceneItemChooseFragment;
import java.util.ArrayList;
import java.util.List;

public abstract class CommonChooseActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    protected String f10653O000000o;
    protected TextView O00000Oo;
    protected List<Device> O00000o = new ArrayList();
    protected SceneItemChooseFragment O00000o0;

    /* access modifiers changed from: protected */
    public abstract List<SceneItemChooseFragment.ItemData> O000000o();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f10653O000000o = getIntent().getStringExtra("extra_did");
        setContentView((int) R.layout.scene_mirouter_setting_activity);
        this.O00000Oo = (TextView) findViewById(R.id.module_a_3_return_title);
        View findViewById = findViewById(R.id.module_a_3_return_btn);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.CommonChooseActivity.AnonymousClass1 */

                public final void onClick(View view) {
                    CommonChooseActivity.this.setResult();
                    CommonChooseActivity.this.finish();
                }
            });
        }
        initFragment();
    }

    public void initFragment() {
        this.O00000o0 = (SceneItemChooseFragment) getSupportFragmentManager().O000000o((int) R.id.device_choose_fragment);
        if (this.O00000o0 != null) {
            SceneItemChooseFragment.ItemData itemData = null;
            List<SceneItemChooseFragment.ItemData> O000000o2 = O000000o();
            for (SceneItemChooseFragment.ItemData next : O000000o2) {
                String str = this.f10653O000000o;
                if (str != null && !str.isEmpty() && this.f10653O000000o.equalsIgnoreCase(next.f10832O000000o)) {
                    itemData = next;
                }
            }
            if (itemData == null && !O000000o2.isEmpty()) {
                itemData = O000000o2.get(0);
            }
            SceneItemChooseFragment sceneItemChooseFragment = this.O00000o0;
            sceneItemChooseFragment.f10831O000000o = O000000o2;
            sceneItemChooseFragment.O00000o0 = itemData;
            sceneItemChooseFragment.O00000o.notifyDataSetChanged();
        }
    }

    public void onBackPressed() {
        setResult();
        finish();
    }

    public void setResult() {
        SceneItemChooseFragment sceneItemChooseFragment = this.O00000o0;
        if (sceneItemChooseFragment == null || sceneItemChooseFragment.O00000o0 == null) {
            setResult(0);
            return;
        }
        Intent intent = new Intent();
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.O00000o0.O00000o0);
        intent.putParcelableArrayListExtra("item_choose_result", arrayList);
        setResult(-1, intent);
    }
}
