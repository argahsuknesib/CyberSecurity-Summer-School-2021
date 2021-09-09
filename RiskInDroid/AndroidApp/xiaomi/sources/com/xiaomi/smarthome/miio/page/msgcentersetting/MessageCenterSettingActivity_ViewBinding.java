package com.xiaomi.smarthome.miio.page.msgcentersetting;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.widget.ListItemView;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;

public class MessageCenterSettingActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private MessageCenterSettingActivity f9937O000000o;
    private View O00000Oo;
    private View O00000o;
    private View O00000o0;
    private View O00000oO;
    private View O00000oo;
    private View O0000O0o;
    private View O0000OOo;
    private View O0000Oo;
    private View O0000Oo0;
    private View O0000OoO;
    private View O0000Ooo;
    private View O0000o0;
    private View O0000o00;
    private View O0000o0O;

    public MessageCenterSettingActivity_ViewBinding(final MessageCenterSettingActivity messageCenterSettingActivity, View view) {
        this.f9937O000000o = messageCenterSettingActivity;
        View findRequiredView = Utils.findRequiredView(view, R.id.module_a_3_return_btn, "field 'moduleA3ReturnBtn' and method 'onClick'");
        messageCenterSettingActivity.moduleA3ReturnBtn = (ImageView) Utils.castView(findRequiredView, R.id.module_a_3_return_btn, "field 'moduleA3ReturnBtn'", ImageView.class);
        this.O00000Oo = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.msgcentersetting.MessageCenterSettingActivity_ViewBinding.AnonymousClass1 */

            public final void doClick(View view) {
                messageCenterSettingActivity.onClick(view);
            }
        });
        messageCenterSettingActivity.moduleA3ReturnTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'moduleA3ReturnTitle'", TextView.class);
        messageCenterSettingActivity.moduleA3ReturnMoreMoreBtn = (ImageView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_more_more_btn, "field 'moduleA3ReturnMoreMoreBtn'", ImageView.class);
        messageCenterSettingActivity.titleBar = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.title_bar, "field 'titleBar'", FrameLayout.class);
        messageCenterSettingActivity.deviceShareItemTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.device_share_item_title, "field 'deviceShareItemTitle'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.device_share_item_btn, "field 'deviceShareItemBtn' and method 'onClick'");
        messageCenterSettingActivity.deviceShareItemBtn = (SwitchButton) Utils.castView(findRequiredView2, R.id.device_share_item_btn, "field 'deviceShareItemBtn'", SwitchButton.class);
        this.O00000o0 = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.msgcentersetting.MessageCenterSettingActivity_ViewBinding.AnonymousClass7 */

            public final void doClick(View view) {
                messageCenterSettingActivity.onClick(view);
            }
        });
        View findRequiredView3 = Utils.findRequiredView(view, R.id.device_share_item, "field 'deviceShareItem' and method 'onClick'");
        messageCenterSettingActivity.deviceShareItem = (ListItemView) Utils.castView(findRequiredView3, R.id.device_share_item, "field 'deviceShareItem'", ListItemView.class);
        this.O00000o = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.msgcentersetting.MessageCenterSettingActivity_ViewBinding.AnonymousClass8 */

            public final void doClick(View view) {
                messageCenterSettingActivity.onClick(view);
            }
        });
        messageCenterSettingActivity.familyInvitationItemTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.family_invitation_item_title, "field 'familyInvitationItemTitle'", TextView.class);
        View findRequiredView4 = Utils.findRequiredView(view, R.id.family_invitation_btn, "field 'familyInvitationBtn' and method 'onClick'");
        messageCenterSettingActivity.familyInvitationBtn = (SwitchButton) Utils.castView(findRequiredView4, R.id.family_invitation_btn, "field 'familyInvitationBtn'", SwitchButton.class);
        this.O00000oO = findRequiredView4;
        findRequiredView4.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.msgcentersetting.MessageCenterSettingActivity_ViewBinding.AnonymousClass9 */

            public final void doClick(View view) {
                messageCenterSettingActivity.onClick(view);
            }
        });
        View findRequiredView5 = Utils.findRequiredView(view, R.id.family_invitation_item, "field 'familyInvitationItem' and method 'onClick'");
        messageCenterSettingActivity.familyInvitationItem = (ListItemView) Utils.castView(findRequiredView5, R.id.family_invitation_item, "field 'familyInvitationItem'", ListItemView.class);
        this.O00000oo = findRequiredView5;
        findRequiredView5.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.msgcentersetting.MessageCenterSettingActivity_ViewBinding.AnonymousClass10 */

            public final void doClick(View view) {
                messageCenterSettingActivity.onClick(view);
            }
        });
        messageCenterSettingActivity.shopItemTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.shop_item_title, "field 'shopItemTitle'", TextView.class);
        View findRequiredView6 = Utils.findRequiredView(view, R.id.shop_item_btn, "field 'shopItemBtn' and method 'onClick'");
        messageCenterSettingActivity.shopItemBtn = (SwitchButton) Utils.castView(findRequiredView6, R.id.shop_item_btn, "field 'shopItemBtn'", SwitchButton.class);
        this.O0000O0o = findRequiredView6;
        findRequiredView6.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.msgcentersetting.MessageCenterSettingActivity_ViewBinding.AnonymousClass11 */

            public final void doClick(View view) {
                messageCenterSettingActivity.onClick(view);
            }
        });
        View findRequiredView7 = Utils.findRequiredView(view, R.id.shop_item, "field 'shopItem' and method 'onClick'");
        messageCenterSettingActivity.shopItem = (ListItemView) Utils.castView(findRequiredView7, R.id.shop_item, "field 'shopItem'", ListItemView.class);
        this.O0000OOo = findRequiredView7;
        findRequiredView7.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.msgcentersetting.MessageCenterSettingActivity_ViewBinding.AnonymousClass12 */

            public final void doClick(View view) {
                messageCenterSettingActivity.onClick(view);
            }
        });
        messageCenterSettingActivity.pushSilentItemTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.push_silent_item_title, "field 'pushSilentItemTitle'", TextView.class);
        View findRequiredView8 = Utils.findRequiredView(view, R.id.push_silent_item_btn, "field 'pushSilentItemBtn' and method 'onClick'");
        messageCenterSettingActivity.pushSilentItemBtn = (SwitchButton) Utils.castView(findRequiredView8, R.id.push_silent_item_btn, "field 'pushSilentItemBtn'", SwitchButton.class);
        this.O0000Oo0 = findRequiredView8;
        findRequiredView8.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.msgcentersetting.MessageCenterSettingActivity_ViewBinding.AnonymousClass13 */

            public final void doClick(View view) {
                messageCenterSettingActivity.onClick(view);
            }
        });
        View findRequiredView9 = Utils.findRequiredView(view, R.id.push_silent_item, "field 'pushSilentItem' and method 'onClick'");
        messageCenterSettingActivity.pushSilentItem = (ListItemView) Utils.castView(findRequiredView9, R.id.push_silent_item, "field 'pushSilentItem'", ListItemView.class);
        this.O0000Oo = findRequiredView9;
        findRequiredView9.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.msgcentersetting.MessageCenterSettingActivity_ViewBinding.AnonymousClass14 */

            public final void doClick(View view) {
                messageCenterSettingActivity.onClick(view);
            }
        });
        messageCenterSettingActivity.pushSilentTimeItemTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.push_silent_time_item_title, "field 'pushSilentTimeItemTitle'", TextView.class);
        messageCenterSettingActivity.pushSilentTimeTv = (TextView) Utils.findRequiredViewAsType(view, R.id.push_silent_time_tv, "field 'pushSilentTimeTv'", TextView.class);
        View findRequiredView10 = Utils.findRequiredView(view, R.id.push_silent_time_item, "field 'pushSilentTimeItem' and method 'onClick'");
        messageCenterSettingActivity.pushSilentTimeItem = (ListItemView) Utils.castView(findRequiredView10, R.id.push_silent_time_item, "field 'pushSilentTimeItem'", ListItemView.class);
        this.O0000OoO = findRequiredView10;
        findRequiredView10.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.msgcentersetting.MessageCenterSettingActivity_ViewBinding.AnonymousClass2 */

            public final void doClick(View view) {
                messageCenterSettingActivity.onClick(view);
            }
        });
        View findRequiredView11 = Utils.findRequiredView(view, R.id.push_device_item_btn, "field 'pushDeviceItemBtn' and method 'onClick'");
        messageCenterSettingActivity.pushDeviceItemBtn = (SwitchButton) Utils.castView(findRequiredView11, R.id.push_device_item_btn, "field 'pushDeviceItemBtn'", SwitchButton.class);
        this.O0000Ooo = findRequiredView11;
        findRequiredView11.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.msgcentersetting.MessageCenterSettingActivity_ViewBinding.AnonymousClass3 */

            public final void doClick(View view) {
                messageCenterSettingActivity.onClick(view);
            }
        });
        View findRequiredView12 = Utils.findRequiredView(view, R.id.push_home_device_item, "field 'pushHomeDeviceItem' and method 'onClick'");
        messageCenterSettingActivity.pushHomeDeviceItem = (ListItemView) Utils.castView(findRequiredView12, R.id.push_home_device_item, "field 'pushHomeDeviceItem'", ListItemView.class);
        this.O0000o00 = findRequiredView12;
        findRequiredView12.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.msgcentersetting.MessageCenterSettingActivity_ViewBinding.AnonymousClass4 */

            public final void doClick(View view) {
                messageCenterSettingActivity.onClick(view);
            }
        });
        View findRequiredView13 = Utils.findRequiredView(view, R.id.push_share_device_item, "field 'pushShareDeviceItem' and method 'onClick'");
        messageCenterSettingActivity.pushShareDeviceItem = (ListItemView) Utils.castView(findRequiredView13, R.id.push_share_device_item, "field 'pushShareDeviceItem'", ListItemView.class);
        this.O0000o0 = findRequiredView13;
        findRequiredView13.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.msgcentersetting.MessageCenterSettingActivity_ViewBinding.AnonymousClass5 */

            public final void doClick(View view) {
                messageCenterSettingActivity.onClick(view);
            }
        });
        View findRequiredView14 = Utils.findRequiredView(view, R.id.push_device_item, "method 'onClick'");
        this.O0000o0O = findRequiredView14;
        findRequiredView14.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.msgcentersetting.MessageCenterSettingActivity_ViewBinding.AnonymousClass6 */

            public final void doClick(View view) {
                messageCenterSettingActivity.onClick(view);
            }
        });
    }

    public void unbind() {
        MessageCenterSettingActivity messageCenterSettingActivity = this.f9937O000000o;
        if (messageCenterSettingActivity != null) {
            this.f9937O000000o = null;
            messageCenterSettingActivity.moduleA3ReturnBtn = null;
            messageCenterSettingActivity.moduleA3ReturnTitle = null;
            messageCenterSettingActivity.moduleA3ReturnMoreMoreBtn = null;
            messageCenterSettingActivity.titleBar = null;
            messageCenterSettingActivity.deviceShareItemTitle = null;
            messageCenterSettingActivity.deviceShareItemBtn = null;
            messageCenterSettingActivity.deviceShareItem = null;
            messageCenterSettingActivity.familyInvitationItemTitle = null;
            messageCenterSettingActivity.familyInvitationBtn = null;
            messageCenterSettingActivity.familyInvitationItem = null;
            messageCenterSettingActivity.shopItemTitle = null;
            messageCenterSettingActivity.shopItemBtn = null;
            messageCenterSettingActivity.shopItem = null;
            messageCenterSettingActivity.pushSilentItemTitle = null;
            messageCenterSettingActivity.pushSilentItemBtn = null;
            messageCenterSettingActivity.pushSilentItem = null;
            messageCenterSettingActivity.pushSilentTimeItemTitle = null;
            messageCenterSettingActivity.pushSilentTimeTv = null;
            messageCenterSettingActivity.pushSilentTimeItem = null;
            messageCenterSettingActivity.pushDeviceItemBtn = null;
            messageCenterSettingActivity.pushHomeDeviceItem = null;
            messageCenterSettingActivity.pushShareDeviceItem = null;
            this.O00000Oo.setOnClickListener(null);
            this.O00000Oo = null;
            this.O00000o0.setOnClickListener(null);
            this.O00000o0 = null;
            this.O00000o.setOnClickListener(null);
            this.O00000o = null;
            this.O00000oO.setOnClickListener(null);
            this.O00000oO = null;
            this.O00000oo.setOnClickListener(null);
            this.O00000oo = null;
            this.O0000O0o.setOnClickListener(null);
            this.O0000O0o = null;
            this.O0000OOo.setOnClickListener(null);
            this.O0000OOo = null;
            this.O0000Oo0.setOnClickListener(null);
            this.O0000Oo0 = null;
            this.O0000Oo.setOnClickListener(null);
            this.O0000Oo = null;
            this.O0000OoO.setOnClickListener(null);
            this.O0000OoO = null;
            this.O0000Ooo.setOnClickListener(null);
            this.O0000Ooo = null;
            this.O0000o00.setOnClickListener(null);
            this.O0000o00 = null;
            this.O0000o0.setOnClickListener(null);
            this.O0000o0 = null;
            this.O0000o0O.setOnClickListener(null);
            this.O0000o0O = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
