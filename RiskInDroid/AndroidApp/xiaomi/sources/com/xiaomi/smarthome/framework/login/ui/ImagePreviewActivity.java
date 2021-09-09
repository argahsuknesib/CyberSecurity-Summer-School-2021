package com.xiaomi.smarthome.framework.login.ui;

import _m_j.gqd;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;

public class ImagePreviewActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private SimpleDraweeView f7580O000000o;
    private String O00000Oo;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.O00000Oo = getIntent().getStringExtra("url");
        setContentView((int) R.layout.image_preview_activity);
        this.f7580O000000o = (SimpleDraweeView) findViewById(R.id.image);
        View findViewById = findViewById(R.id.module_a_3_return_btn);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.login.ui.$$Lambda$ImagePreviewActivity$nfpjAYMcRd4Tq5CDgPt31GWzf5I */

                public final void onClick(View view) {
                    ImagePreviewActivity.this.O000000o(view);
                }
            });
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f7580O000000o.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = i;
            layoutParams.height = i;
        }
        this.f7580O000000o.setLayoutParams(layoutParams);
        this.f7580O000000o.setHierarchy(new GenericDraweeHierarchyBuilder(this.f7580O000000o.getResources()).setFadeDuration(200).setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY).build());
        if (TextUtils.isEmpty(this.O00000Oo)) {
            this.f7580O000000o.setImageURI(gqd.O000000o((int) R.drawable.user_default));
        } else {
            this.f7580O000000o.setImageURI(Uri.parse(this.O00000Oo));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        onBackPressed();
    }
}
