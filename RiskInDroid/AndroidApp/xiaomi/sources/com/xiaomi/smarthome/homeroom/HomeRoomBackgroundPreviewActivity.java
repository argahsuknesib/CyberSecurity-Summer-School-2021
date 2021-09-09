package com.xiaomi.smarthome.homeroom;

import _m_j.ggb;
import _m_j.gku;
import _m_j.gwg;
import _m_j.hxi;
import _m_j.hzf;
import _m_j.ixe;
import android.content.Context;
import android.content.Intent;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0012\u0010\u0012\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0010H\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/xiaomi/smarthome/homeroom/HomeRoomBackgroundPreviewActivity;", "Lcom/xiaomi/smarthome/framework/page/BaseActivity;", "()V", "showConfirmBtn", "", "getShowConfirmBtn", "()Z", "setShowConfirmBtn", "(Z)V", "wallpaperNamePrefix", "", "getWallpaperNamePrefix", "()Ljava/lang/String;", "setWallpaperNamePrefix", "(Ljava/lang/String;)V", "initViews", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setSystemBar", "smarthome-home_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class HomeRoomBackgroundPreviewActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f8872O000000o = "";
    private boolean O00000Oo = true;

    public final void _$_clearFindViewByIdCache() {
    }

    public final String getWallpaperNamePrefix() {
        return this.f8872O000000o;
    }

    public final void setWallpaperNamePrefix(String str) {
        this.f8872O000000o = str;
    }

    public final boolean getShowConfirmBtn() {
        return this.O00000Oo;
    }

    public final void setShowConfirmBtn(boolean z) {
        this.O00000Oo = z;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_home_room_background_preview);
        this.f8872O000000o = getIntent().getStringExtra("wallpaperNamePrefix");
        this.O00000Oo = getIntent().getBooleanExtra("showConfirmBtn", true);
        initViews();
    }

    public final void setSystemBar() {
        gwg.O00000Oo(getWindow());
        gwg.O000000o(getWindow(), (byte) 1, !gku.O000000o(getContext()), null);
    }

    public final void initViews() {
        String stringExtra = getIntent().getStringExtra("roomName");
        if (stringExtra == null) {
            stringExtra = "";
        }
        ((ImageView) findViewById(R.id.back)).setOnClickListener(new View.OnClickListener(stringExtra) {
            /* class com.xiaomi.smarthome.homeroom.$$Lambda$HomeRoomBackgroundPreviewActivity$M9HGXKSD6F_B3H2ENSZmuMvpDpo */
            private final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                HomeRoomBackgroundPreviewActivity.O000000o(HomeRoomBackgroundPreviewActivity.this, this.f$1, view);
            }
        });
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R.id.sd_bg);
        PointF pointF = new PointF(0.0f, 0.0f);
        ((GenericDraweeHierarchy) simpleDraweeView.getHierarchy()).setActualImageFocusPoint(pointF);
        ((GenericDraweeHierarchy) simpleDraweeView.getHierarchy()).setPlaceholderImageFocusPoint(pointF);
        int i = 0;
        ggb.O0000O0o.O000000o(simpleDraweeView, this.f8872O000000o, new boolean[0]);
        TextView textView = (TextView) findViewById(R.id.btn_confirm);
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        if (layoutParams != null) {
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += hzf.O00000Oo((Context) this);
            if (!this.O00000Oo) {
                i = 8;
            }
            textView.setVisibility(i);
            textView.setOnClickListener(new View.OnClickListener(stringExtra) {
                /* class com.xiaomi.smarthome.homeroom.$$Lambda$HomeRoomBackgroundPreviewActivity$GZPyWDTgqMuB0SKgdRmedj7C8GQ */
                private final /* synthetic */ String f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    HomeRoomBackgroundPreviewActivity.O00000Oo(HomeRoomBackgroundPreviewActivity.this, this.f$1, view);
                }
            });
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hxk.O000000o(java.lang.String, boolean, java.lang.String):void
     arg types: [java.lang.String, int, java.lang.String]
     candidates:
      _m_j.hxk.O000000o(int, long, java.lang.String):void
      _m_j.hxk.O000000o(int, java.lang.String, java.lang.String):void
      _m_j.hxk.O000000o(java.lang.String, int, java.lang.String):void
      _m_j.hxk.O000000o(java.lang.String, java.lang.String, long):void
      _m_j.hxk.O000000o(java.lang.String, java.lang.String, java.lang.String):void
      _m_j.hxk.O000000o(java.lang.String, java.lang.String, boolean):void
      _m_j.hxk.O000000o(java.lang.String, boolean, java.lang.String):void */
    /* access modifiers changed from: private */
    public static final void O000000o(HomeRoomBackgroundPreviewActivity homeRoomBackgroundPreviewActivity, String str, View view) {
        ixe.O00000o(homeRoomBackgroundPreviewActivity, "this$0");
        ixe.O00000o(str, "$roomName");
        homeRoomBackgroundPreviewActivity.onBackPressed();
        hxi.O00000o.O000000o(str, true, "back");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hxk.O000000o(java.lang.String, boolean, java.lang.String):void
     arg types: [java.lang.String, int, java.lang.String]
     candidates:
      _m_j.hxk.O000000o(int, long, java.lang.String):void
      _m_j.hxk.O000000o(int, java.lang.String, java.lang.String):void
      _m_j.hxk.O000000o(java.lang.String, int, java.lang.String):void
      _m_j.hxk.O000000o(java.lang.String, java.lang.String, long):void
      _m_j.hxk.O000000o(java.lang.String, java.lang.String, java.lang.String):void
      _m_j.hxk.O000000o(java.lang.String, java.lang.String, boolean):void
      _m_j.hxk.O000000o(java.lang.String, boolean, java.lang.String):void */
    /* access modifiers changed from: private */
    public static final void O00000Oo(HomeRoomBackgroundPreviewActivity homeRoomBackgroundPreviewActivity, String str, View view) {
        ixe.O00000o(homeRoomBackgroundPreviewActivity, "this$0");
        ixe.O00000o(str, "$roomName");
        Intent intent = new Intent();
        intent.putExtra("wallpaperNamePrefix", homeRoomBackgroundPreviewActivity.getWallpaperNamePrefix());
        homeRoomBackgroundPreviewActivity.setResult(-1, intent);
        homeRoomBackgroundPreviewActivity.finish();
        hxi.O00000o.O000000o(str, false, homeRoomBackgroundPreviewActivity.getWallpaperNamePrefix());
    }

    public final void onBackPressed() {
        super.onBackPressed();
        setResult(0);
        finish();
    }
}
