package com.xiaomi.smarthome.miio.camera.cloudstorage;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils;
import java.util.Locale;

public class CloudVideoIntroActivity extends BaseActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_cloud_video_intro);
        String stringExtra = getIntent().getStringExtra("extra_device_did");
        ImageView imageView = (ImageView) findViewById(R.id.iv_cv_title);
        ImageView imageView2 = (ImageView) findViewById(R.id.iv_cv_intro_img_1);
        ImageView imageView3 = (ImageView) findViewById(R.id.iv_cv_intro_img_2);
        String language = getResources().getConfiguration().locale.getLanguage();
        String language2 = Locale.getDefault().getLanguage();
        if (!"zh".equalsIgnoreCase(language) || !"zh".equalsIgnoreCase(language2)) {
            imageView.setImageResource(R.drawable.cloud_video_intro_title_en);
            imageView2.setImageResource(R.drawable.cloud_video_intro_img_1_en);
            imageView3.setImageResource(R.drawable.cloud_video_intro_img_2_en);
        } else {
            imageView.setImageResource(R.drawable.cloud_video_intro_title);
            imageView2.setImageResource(R.drawable.cloud_video_intro_img_1);
            imageView3.setImageResource(R.drawable.cloud_video_intro_img_2);
        }
        findViewById(R.id.tv_buy).setOnClickListener(new View.OnClickListener(stringExtra) {
            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoIntroActivity$5mqfOlGOG80wqvBz0QxynXaYp4 */
            private final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                CloudVideoIntroActivity.this.lambda$onCreate$0$CloudVideoIntroActivity(this.f$1, view);
            }
        });
    }

    public /* synthetic */ void lambda$onCreate$0$CloudVideoIntroActivity(String str, View view) {
        CloudVideoNetUtils.getInstance().openCloudVideoBuyPage(getContext(), str);
    }
}
