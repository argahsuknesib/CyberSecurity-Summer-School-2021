package com.xiaomi.smarthome.framework.page;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class PictureShareActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private PictureShareActivity f7782O000000o;

    public PictureShareActivity_ViewBinding(PictureShareActivity pictureShareActivity, View view) {
        this.f7782O000000o = pictureShareActivity;
        pictureShareActivity.wxShare = (TextView) Utils.findRequiredViewAsType(view, R.id.wx_share, "field 'wxShare'", TextView.class);
        pictureShareActivity.friendsShare = (TextView) Utils.findRequiredViewAsType(view, R.id.friends_share, "field 'friendsShare'", TextView.class);
        pictureShareActivity.weiboShare = (TextView) Utils.findRequiredViewAsType(view, R.id.weibo_share, "field 'weiboShare'", TextView.class);
    }

    public void unbind() {
        PictureShareActivity pictureShareActivity = this.f7782O000000o;
        if (pictureShareActivity != null) {
            this.f7782O000000o = null;
            pictureShareActivity.wxShare = null;
            pictureShareActivity.friendsShare = null;
            pictureShareActivity.weiboShare = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
