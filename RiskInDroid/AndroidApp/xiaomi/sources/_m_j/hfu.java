package _m_j;

import _m_j.ext;
import _m_j.hcc;
import _m_j.hfr;
import _m_j.hfv;
import android.animation.Animator;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.miio.camera.match.CameraDevice;
import com.xiaomi.smarthome.newui.adapter.DviceEditInterface;
import com.xiaomi.smarthome.newui.card.State;
import com.xiaomi.smarthome.newui.mainpage.EditMaskView;
import com.xiaomi.smarthome.newui.mainpage.MainGridViewHolder$bind$2$2;
import com.xiaomi.smarthome.newui.mainpage.devicepage.model.MainPageDeviceModel;
import com.xiaomi.smarthome.newui.widget.GridItemAnimView;
import java.lang.Character;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010'\u001a\u00020(2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0018H\u0002J\b\u0010,\u001a\u00020*H\u0002J(\u0010-\u001a\u00020(2\u0006\u0010.\u001a\u00020*2\u0006\u0010/\u001a\u00020\u00032\u0006\u0010+\u001a\u0002002\u0006\u00101\u001a\u00020\nH\u0002J\b\u00102\u001a\u00020(H\u0002J\b\u00103\u001a\u00020(H\u0002J\u0018\u00104\u001a\u00020(2\u0006\u00105\u001a\u00020\n2\u0006\u00106\u001a\u00020*H\u0002J*\u00107\u001a\u00020(2\u0018\u00108\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\n0:092\u0006\u0010<\u001a\u00020*H\u0002J\u0010\u0010=\u001a\u00020(2\u0006\u0010>\u001a\u00020?H\u0002J\b\u0010@\u001a\u00020*H\u0002J2\u0010A\u001a\u00020(2\u0006\u00105\u001a\u00020\n2\u0018\u00108\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\n0:092\u0006\u0010<\u001a\u00020BH\u0002J\u0010\u0010C\u001a\u00020(2\u0006\u00105\u001a\u00020\nH\u0002R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u00020 8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u00020&8\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/xiaomi/smarthome/newui/mainpage/MainGridViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "cardEditor", "Lcom/xiaomi/smarthome/newui/adapter/DviceEditInterface;", "dragHelper", "Landroidx/recyclerview/widget/ItemTouchHelper;", "(Landroid/view/View;Lcom/xiaomi/smarthome/newui/adapter/DviceEditInterface;Landroidx/recyclerview/widget/ItemTouchHelper;)V", "SHOW_PINCODE_NEW", "", "animTracer", "Lcom/xiaomi/smarthome/newui/mainpage/AnimSupportDeviceModelDiffCallback$AnimTracer;", "bleOfflineTipIv", "Landroid/widget/ImageView;", "bleOfflineTipIvVS", "Landroid/view/ViewStub;", "checkBox", "Landroid/widget/CheckBox;", "checkBoxVS", "descDeviceState", "Landroid/widget/TextView;", "descSplitTv", "deviceModel", "Lcom/xiaomi/smarthome/newui/mainpage/devicepage/model/MainPageDeviceModel;", "deviceNameTv", "editModeMask", "Lcom/xiaomi/smarthome/newui/mainpage/EditMaskView;", "gridItemAnimView", "Lcom/xiaomi/smarthome/newui/widget/GridItemAnimView;", "gridItemAnimViewVS", "iconIv", "Lcom/facebook/drawee/view/SimpleDraweeView;", "isNewTv", "isNewVs", "roomNameTv", "switchIv", "switchIvContainer", "Landroid/widget/FrameLayout;", "bind", "", "canJumpToCard", "", "device", "enterEditMode", "jumpPlugin", "isIrDevice", "it", "Lcom/xiaomi/smarthome/device/Device;", "roomName", "makeRoomNameFixSize", "makeRoomNameMatchParent", "playBgAnim", "did", "isOn", "playSwitchAnim", "allStatus", "", "Lkotlin/Pair;", "Lcom/xiaomi/smarthome/newui/card/State;", "isCurrentOn", "setupRoomNameViewWeight", "weight", "", "shouldShowRoomName", "toggleButton", "Ljava/util/concurrent/atomic/AtomicBoolean;", "toggleInvoked", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class hfu extends RecyclerView.O000OOo0 {

    /* renamed from: O000000o  reason: collision with root package name */
    public final FrameLayout f18874O000000o;
    public final SimpleDraweeView O00000Oo;
    private final DviceEditInterface O00000o;
    public GridItemAnimView O00000o0;
    private final gs O00000oO;
    private hfr.O000000o O00000oo;
    private final String O0000O0o = "grid_holder_show_pincode_new";
    private final TextView O0000OOo;
    private final TextView O0000Oo;
    private final TextView O0000Oo0;
    private final TextView O0000OoO;
    private final SimpleDraweeView O0000Ooo;
    private final ViewStub O0000o;
    private final ViewStub O0000o0;
    private final EditMaskView O0000o00;
    private final ViewStub O0000o0O;
    private final ViewStub O0000o0o;
    private ImageView O0000oO;
    private CheckBox O0000oO0;
    private ImageView O0000oOO;
    private MainPageDeviceModel O0000oOo;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public hfu(View view, DviceEditInterface dviceEditInterface, gs gsVar) {
        super(view);
        ixe.O00000o(view, "itemView");
        ixe.O00000o(dviceEditInterface, "cardEditor");
        this.O00000o = dviceEditInterface;
        this.O00000oO = gsVar;
        View findViewById = view.findViewById(R.id.tv_room_name);
        ixe.O00000Oo(findViewById, "itemView.findViewById(R.id.tv_room_name)");
        this.O0000OOo = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_device_state_split);
        ixe.O00000Oo(findViewById2, "itemView.findViewById(R.id.tv_device_state_split)");
        this.O0000Oo0 = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.tv_device_state);
        ixe.O00000Oo(findViewById3, "itemView.findViewById(R.id.tv_device_state)");
        this.O0000Oo = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.tv_device_name);
        ixe.O00000Oo(findViewById4, "itemView.findViewById(R.id.tv_device_name)");
        this.O0000OoO = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.icon);
        ixe.O00000Oo(findViewById5, "itemView.findViewById(R.id.icon)");
        this.O0000Ooo = (SimpleDraweeView) findViewById5;
        View findViewById6 = view.findViewById(R.id.shortcut_container);
        ixe.O00000Oo(findViewById6, "itemView.findViewById(R.id.shortcut_container)");
        this.f18874O000000o = (FrameLayout) findViewById6;
        View findViewById7 = view.findViewById(R.id.shortcut);
        ixe.O00000Oo(findViewById7, "itemView.findViewById(R.id.shortcut)");
        this.O00000Oo = (SimpleDraweeView) findViewById7;
        View findViewById8 = view.findViewById(R.id.edit_mask);
        ixe.O00000Oo(findViewById8, "itemView.findViewById(R.id.edit_mask)");
        this.O0000o00 = (EditMaskView) findViewById8;
        View findViewById9 = view.findViewById(R.id.ckb_edit_selected_vs);
        ixe.O00000Oo(findViewById9, "itemView.findViewById(R.id.ckb_edit_selected_vs)");
        this.O0000o0 = (ViewStub) findViewById9;
        View findViewById10 = view.findViewById(R.id.isnew_vs);
        ixe.O00000Oo(findViewById10, "itemView.findViewById(R.id.isnew_vs)");
        this.O0000o0O = (ViewStub) findViewById10;
        View findViewById11 = view.findViewById(R.id.offline_tip_iv_vs);
        ixe.O00000Oo(findViewById11, "itemView.findViewById(R.id.offline_tip_iv_vs)");
        this.O0000o0o = (ViewStub) findViewById11;
        View findViewById12 = view.findViewById(R.id.grid_anim_view_vs);
        ixe.O00000Oo(findViewById12, "itemView.findViewById(R.id.grid_anim_view_vs)");
        this.O0000o = (ViewStub) findViewById12;
        View inflate = this.O0000o.inflate();
        if (inflate != null) {
            this.O00000o0 = (GridItemAnimView) inflate;
            if (Build.VERSION.SDK_INT >= 29) {
                this.O0000Ooo.setForceDarkAllowed(false);
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.xiaomi.smarthome.newui.widget.GridItemAnimView");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.iyw.O000000o(java.lang.String, java.lang.String, boolean):boolean
     arg types: [java.lang.String, java.lang.String, int]
     candidates:
      _m_j.iyx.O000000o(java.lang.CharSequence, int, int):int
      _m_j.iyx.O000000o(java.lang.CharSequence, java.lang.CharSequence, boolean):boolean
      _m_j.iyw.O000000o(java.lang.String, java.lang.String, boolean):boolean */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x035b  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x035d  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0360  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x0365  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x0373  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0375  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x039a  */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x039c  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x039f  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x03a5  */
    public final void O000000o(MainPageDeviceModel mainPageDeviceModel, hfr.O000000o o000000o) {
        String str;
        hgf hgf;
        boolean z;
        hgf hgf2;
        Pair pair;
        State state;
        CharSequence charSequence;
        Object obj;
        boolean z2;
        CharSequence charSequence2;
        int i;
        String str2;
        int intValue;
        hgf hgf3;
        hgf hgf4;
        hgf hgf5;
        int i2;
        int i3;
        MainPageDeviceModel mainPageDeviceModel2 = mainPageDeviceModel;
        hfr.O000000o o000000o2 = o000000o;
        ixe.O00000o(mainPageDeviceModel2, "deviceModel");
        ixe.O00000o(o000000o2, "animTracer");
        this.O0000oOo = mainPageDeviceModel2;
        this.O00000oo = o000000o2;
        String str3 = mainPageDeviceModel2.O0000Oo0;
        String str4 = mainPageDeviceModel2.O0000O0o;
        boolean z3 = mainPageDeviceModel2.O0000OOo;
        if (z3) {
            str = mainPageDeviceModel2.O0000o0O;
        } else {
            str = this.itemView.getContext().getString(R.string.code_device_offline);
            ixe.O00000Oo(str, "itemView.context.getString(R.string.code_device_offline)");
        }
        hgf hgf6 = mainPageDeviceModel2.O0000o0o;
        boolean z4 = mainPageDeviceModel2.f10251O000000o;
        boolean z5 = mainPageDeviceModel2.O00000Oo;
        boolean z6 = mainPageDeviceModel2.O00000o0;
        boolean z7 = mainPageDeviceModel2.O00000o;
        String str5 = mainPageDeviceModel2.O00000oo;
        this.O0000OoO.setAlpha(z3 ? 1.0f : 0.5f);
        if (z4) {
            this.O0000OoO.setText((int) R.string.phone_ir_device);
            hgf = hgf6;
        } else {
            TextView textView = this.O0000OoO;
            hfs hfs = hfs.f18870O000000o;
            ixe.O00000o(str4, "withBrandName");
            CharSequence charSequence3 = str4;
            if (!(charSequence3.length() == 0)) {
                str2 = hfs.O00000Oo.get(str4);
                if (str2 != null) {
                    hgf = hgf6;
                } else {
                    ixe.O00000o(str4, "string");
                    if (TextUtils.isEmpty(charSequence3)) {
                        intValue = 0;
                    } else {
                        Integer num = hfs.O00000o.get(str4);
                        if (num == null) {
                            char[] charArray = str4.toCharArray();
                            ixe.O00000Oo(charArray, "(this as java.lang.String).toCharArray()");
                            int length = charArray.length;
                            int i4 = 0;
                            int i5 = 0;
                            int i6 = 0;
                            int i7 = 0;
                            while (i4 < length) {
                                char c = charArray[i4];
                                int i8 = i4 + 1;
                                Character.UnicodeBlock of = Character.UnicodeBlock.of(c);
                                char[] cArr = charArray;
                                if (of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || of == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B || of == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || of == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS || of == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
                                    i5++;
                                } else {
                                    Character.UnicodeBlock of2 = Character.UnicodeBlock.of(c);
                                    if (of2 == Character.UnicodeBlock.BASIC_LATIN || of2 == Character.UnicodeBlock.LATIN_EXTENDED_A || of2 == Character.UnicodeBlock.LATIN_EXTENDED_B) {
                                        i6++;
                                    } else {
                                        i7++;
                                    }
                                }
                                i4 = i8;
                                charArray = cArr;
                            }
                            num = Integer.valueOf((i5 * 2) + i6 + (i7 * 2));
                            hfs.O00000o.put(str4, num);
                        }
                        intValue = num.intValue();
                    }
                    if (intValue <= 8) {
                        hfs.O00000Oo.put(str4, str4);
                    } else {
                        String[] strArr = hfs.O00000o0;
                        int length2 = strArr.length;
                        int i9 = 0;
                        while (i9 < length2) {
                            int i10 = length2;
                            String str6 = strArr[i9];
                            int i11 = i9 + 1;
                            String[] strArr2 = strArr;
                            if (iyo.O000000o(str4, str6, false)) {
                                i2 = i11;
                                if (str4.length() > str6.length()) {
                                    String substring = str4.substring(str6.length());
                                    ixe.O00000Oo(substring, "(this as java.lang.String).substring(startIndex)");
                                    CharSequence charSequence4 = substring;
                                    int length3 = charSequence4.length() - 1;
                                    int i12 = 0;
                                    boolean z8 = false;
                                    while (true) {
                                        if (i12 > length3) {
                                            hgf = hgf3;
                                            break;
                                        }
                                        if (!z8) {
                                            hgf = hgf3;
                                            i3 = i12;
                                        } else {
                                            hgf = hgf3;
                                            i3 = length3;
                                        }
                                        boolean z9 = ixe.O000000o(charSequence4.charAt(i3)) <= 0;
                                        if (z8) {
                                            if (!z9) {
                                                break;
                                            }
                                            length3--;
                                        } else if (!z9) {
                                            hgf3 = hgf;
                                            z8 = true;
                                        } else {
                                            i12++;
                                        }
                                        hgf3 = hgf;
                                    }
                                    String obj2 = charSequence4.subSequence(i12, length3 + 1).toString();
                                    hfs.O00000Oo.put(str4, obj2);
                                    str2 = obj2;
                                } else {
                                    hgf5 = hgf3;
                                }
                            } else {
                                hgf5 = hgf3;
                                i2 = i11;
                            }
                            length2 = i10;
                            strArr = strArr2;
                            i9 = i2;
                            hgf6 = hgf5;
                        }
                        hgf4 = hgf3;
                        hfs.O00000Oo.put(str4, str4);
                        str2 = str4;
                    }
                }
                textView.setText(str2);
            }
            hgf4 = hgf6;
            str2 = str4;
            textView.setText(str2);
        }
        if (z4) {
            this.O0000Ooo.setImageResource(R.drawable.device_icon_ir_nor);
        } else {
            if (mainPageDeviceModel2.O0000Oo.length() == 0) {
                DeviceFactory.O00000Oo(mainPageDeviceModel2.O00000oO, this.O0000Ooo);
            } else {
                DeviceFactory.O000000o(mainPageDeviceModel2.O0000Oo, this.O0000Ooo);
            }
        }
        this.O0000o00.setShouldMask(this.O00000o.O0000oO() || this.O00000o.O00000o());
        if (this.O00000o.O00000Oo()) {
            if (this.O0000oO0 == null) {
                this.O0000oO0 = (CheckBox) this.O0000o0.inflate();
            }
            CheckBox checkBox = this.O0000oO0;
            if (checkBox != null) {
                checkBox.setChecked(this.O00000o.O0000Oo0().contains(str5));
            }
            CheckBox checkBox2 = this.O0000oO0;
            if (checkBox2 != null) {
                checkBox2.setVisibility(0);
            }
        } else {
            CheckBox checkBox3 = this.O0000oO0;
            if (checkBox3 != null) {
                checkBox3.setVisibility(8);
            }
        }
        if (this.O00000o.O00000Oo() || !z7) {
            ImageView imageView = this.O0000oO;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        } else {
            if (this.O0000oO == null) {
                this.O0000oO = (ImageView) this.O0000o0O.inflate();
            }
            ImageView imageView2 = this.O0000oO;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
        }
        if (this.O00000o.O00000Oo() || !z5 || mainPageDeviceModel2.O0000o0 != 0) {
            ImageView imageView3 = this.O0000oOO;
            if (imageView3 != null) {
                imageView3.setVisibility(8);
            }
        } else {
            if (this.O0000oOO == null) {
                this.O0000oOO = (ImageView) this.O0000o0o.inflate();
            }
            ImageView imageView4 = this.O0000oOO;
            if (imageView4 != null) {
                imageView4.setVisibility(z6 ? 8 : 0);
            }
        }
        TextView textView2 = this.O0000Oo;
        textView2.setTextColor(textView2.getResources().getColor(z3 ? R.color.mj_color_gray_lighter : R.color.mj_color_orange_normal));
        this.O0000OOo.setAlpha(z3 ? 1.0f : 0.5f);
        this.O0000Oo0.setAlpha(z3 ? 1.0f : 0.5f);
        if (z4) {
            int O00000oo2 = fqw.O00000oo();
            String quantityString = this.itemView.getResources().getQuantityString(R.plurals.ir_device_count_2, O00000oo2, Integer.valueOf(O00000oo2));
            ixe.O00000Oo(quantityString, "itemView.resources.getQuantityString(R.plurals.ir_device_count_2, cnt, cnt)");
            this.O0000OOo.setVisibility(0);
            this.O0000OOo.setText((int) R.string.phone);
            this.O0000Oo0.setVisibility(0);
            this.O0000Oo.setVisibility(0);
            TextView textView3 = this.O0000Oo;
            ixh ixh = ixh.f1644O000000o;
            z = true;
            String format = String.format("%s%d", Arrays.copyOf(new Object[]{quantityString, Integer.valueOf(O00000oo2)}, 2));
            ixe.O00000Oo(format, "java.lang.String.format(format, *args)");
            textView3.setText(format);
            O000000o(0);
        } else {
            z = true;
            CharSequence charSequence5 = str;
            if ((charSequence5.length() > 0) && O000000o()) {
                if (str3.length() > 0) {
                    this.O0000Oo0.setVisibility(0);
                    if (!(charSequence5.length() <= 0)) {
                        O000000o(0);
                    } else {
                        O000000o(1000);
                    }
                    charSequence2 = str3;
                    if (!(charSequence2.length() != 0) || !O000000o()) {
                        i = 8;
                        this.O0000OOo.setVisibility(8);
                    } else {
                        this.O0000OOo.setVisibility(0);
                        this.O0000OOo.setText(charSequence2);
                        i = 8;
                    }
                    if (!(charSequence5.length() != 0)) {
                        this.O0000Oo.setVisibility(i);
                    } else {
                        this.O0000Oo.setVisibility(0);
                        this.O0000Oo.setText(charSequence5);
                    }
                }
            }
            this.O0000Oo0.setVisibility(8);
            if (!(charSequence5.length() <= 0)) {
            }
            charSequence2 = str3;
            if (!(charSequence2.length() != 0)) {
            }
            i = 8;
            this.O0000OOo.setVisibility(8);
            if (!(charSequence5.length() != 0)) {
            }
        }
        if (hgf == null) {
            pair = null;
            hgf2 = hgf;
        } else {
            hgf2 = hgf;
            List<Pair<State, String>> list = hgf2.O00000Oo;
            if (list == null) {
                pair = null;
            } else {
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (hgf2.f18897O000000o == ((Pair) obj).first) {
                        z2 = true;
                        continue;
                    } else {
                        z2 = false;
                        continue;
                    }
                    if (z2) {
                        break;
                    }
                }
                pair = (Pair) obj;
            }
        }
        if (pair == null) {
            state = null;
        } else {
            state = (State) pair.first;
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean(state == State.SELECTED);
        if (!this.O00000o.O00000Oo() && mainPageDeviceModel2.O0000o0 != 0) {
            this.f18874O000000o.setVisibility(0);
            SimpleDraweeView simpleDraweeView = this.O00000Oo;
            fbb O000000o2 = faw.O000000o();
            simpleDraweeView.setImageURI(O000000o2 == null ? null : O000000o2.getCardIconPath("grid_lock_unable"));
            this.O00000Oo.setContentDescription(this.itemView.getResources().getString(R.string.mj_talkback_device_main_need_psd));
            this.f18874O000000o.setOnClickListener(null);
        } else if (this.O00000o.O00000Oo() || pair == null) {
            if (!this.O00000o.O00000Oo()) {
                if (mainPageDeviceModel2.O0000OoO.length() != 0) {
                    z = false;
                }
                if (!z) {
                    this.f18874O000000o.setVisibility(0);
                    this.O00000Oo.setImageURI(hfw.O000000o(mainPageDeviceModel2.O0000OoO));
                    this.O00000Oo.setContentDescription(this.itemView.getResources().getString(R.string.operation_open_close));
                    this.f18874O000000o.setOnClickListener(null);
                }
            }
            this.f18874O000000o.setVisibility(8);
            this.f18874O000000o.setOnClickListener(null);
        } else {
            this.f18874O000000o.setVisibility(0);
            this.O00000Oo.setImageURI(hfw.O000000o((String) pair.second));
            SimpleDraweeView simpleDraweeView2 = this.O00000Oo;
            if (atomicBoolean.get()) {
                charSequence = this.itemView.getResources().getString(R.string.mj_talkback_device_on);
            } else {
                charSequence = this.itemView.getResources().getString(R.string.mj_talkback_device_off);
            }
            simpleDraweeView2.setContentDescription(charSequence);
            hzf.O00000oo(this.f18874O000000o);
            this.f18874O000000o.setOnClickListener(new O000000o(mainPageDeviceModel, this, str5, o000000o, hgf2, atomicBoolean));
        }
        this.itemView.setOnClickListener(new View.OnClickListener(str5, mainPageDeviceModel, str3, z4) {
            /* class _m_j.$$Lambda$hfu$H2bjw1JzUO7bB0tJ3SV4XJ7BMyk */
            private final /* synthetic */ String f$1;
            private final /* synthetic */ MainPageDeviceModel f$2;
            private final /* synthetic */ String f$3;
            private final /* synthetic */ boolean f$4;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
            }

            public final void onClick(View view) {
                hfu.O000000o(hfu.this, this.f$1, this.f$2, this.f$3, this.f$4, view);
            }
        });
        this.itemView.setOnLongClickListener(new View.OnLongClickListener(str5, z7, mainPageDeviceModel2) {
            /* class _m_j.$$Lambda$hfu$zE1DQGdKNaTMthw1y2y89FUylek */
            private final /* synthetic */ String f$1;
            private final /* synthetic */ boolean f$2;
            private final /* synthetic */ MainPageDeviceModel f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final boolean onLongClick(View view) {
                return hfu.O000000o(hfu.this, this.f$1, this.f$2, this.f$3, view);
            }
        });
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/xiaomi/smarthome/newui/mainpage/MainGridViewHolder$bind$1", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o implements View.OnClickListener {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ MainPageDeviceModel f18875O000000o;
        final /* synthetic */ hfu O00000Oo;
        final /* synthetic */ hfr.O000000o O00000o;
        final /* synthetic */ String O00000o0;
        final /* synthetic */ hgf O00000oO;
        final /* synthetic */ AtomicBoolean O00000oo;

        O000000o(MainPageDeviceModel mainPageDeviceModel, hfu hfu, String str, hfr.O000000o o000000o, hgf hgf, AtomicBoolean atomicBoolean) {
            this.f18875O000000o = mainPageDeviceModel;
            this.O00000Oo = hfu;
            this.O00000o0 = str;
            this.O00000o = o000000o;
            this.O00000oO = hgf;
            this.O00000oo = atomicBoolean;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: _m_j.hcc$O000000o} */
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean
         arg types: [android.content.Context, java.lang.String, java.lang.String, int]
         candidates:
          _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String
          _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean */
        /* JADX WARNING: Multi-variable type inference failed */
        public final void onClick(View view) {
            hcc.O000000o o000000o;
            Object obj;
            hcc gridCard;
            Object obj2;
            boolean z;
            boolean z2;
            ixe.O00000o(view, "v");
            if (this.f18875O000000o.O0000o0 != 0) {
                this.O00000Oo.itemView.performClick();
            } else if (!gof.O00000o0()) {
                this.O00000Oo.itemView.getContext();
                gqg.O000000o((int) R.string.popup_select_loc_no_network);
            } else {
                Device O000000o2 = fno.O000000o().O000000o(this.O00000o0);
                if (O000000o2 != null) {
                    if (!O000000o2.isBinded()) {
                        Context applicationContext = view.getContext().getApplicationContext();
                        ixe.O00000Oo(applicationContext, "v.context.applicationContext");
                        ixe.O00000o(applicationContext, "context");
                        ixe.O00000o(O000000o2, "cd");
                        if (!O000000o2.isBinded()) {
                            DeviceRouterFactory.getDeviceWrapper().bindDevice(O000000o2, applicationContext, new hfv.O000000o(applicationContext));
                            return;
                        }
                        return;
                    }
                    hfr.O000000o o000000o2 = this.O00000o;
                    String str = this.O00000o0;
                    ixe.O00000o(str, "did");
                    o000000o2.O00000Oo.removeMessages(str.hashCode());
                    Message obtain = Message.obtain();
                    obtain.what = str.hashCode();
                    obtain.obj = str;
                    hfr.O000000o.O00000Oo o00000Oo = o000000o2.O00000Oo;
                    double d = (double) GridItemAnimView.O00000Oo;
                    Double.isNaN(d);
                    o00000Oo.sendMessageDelayed(obtain, (long) (d * 1.5d));
                    hfu hfu = this.O00000Oo;
                    String str2 = this.O00000o0;
                    Iterable iterable = this.O00000oO.O00000Oo;
                    AtomicBoolean atomicBoolean = this.O00000oo;
                    boolean andSet = atomicBoolean.getAndSet(!atomicBoolean.get());
                    Iterable iterable2 = iterable;
                    Iterator it = iterable2.iterator();
                    while (true) {
                        o000000o = null;
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        if (((Pair) obj).first == State.SELECTED) {
                            z2 = true;
                            continue;
                        } else {
                            z2 = false;
                            continue;
                        }
                        if (z2) {
                            break;
                        }
                    }
                    Pair pair = (Pair) obj;
                    String str3 = pair == null ? null : pair.second;
                    if (str3 != null) {
                        Iterator it2 = iterable2.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                obj2 = null;
                                break;
                            }
                            obj2 = it2.next();
                            if (((Pair) obj2).first == State.NOR) {
                                z = true;
                                continue;
                            } else {
                                z = false;
                                continue;
                            }
                            if (z) {
                                break;
                            }
                        }
                        Pair pair2 = (Pair) obj2;
                        String str4 = pair2 == null ? null : pair2.second;
                        if (str4 != null) {
                            if (!andSet) {
                                str4 = str3;
                            }
                            hfu.O00000Oo.setImageURI(hfw.O000000o(str4));
                            if (gpy.O00000o0(CommonApplication.getAppContext(), "prefs_lite_config", "lite_config_click_sound", true)) {
                                if (andSet) {
                                    gtt O000000o3 = gtt.O000000o();
                                    if (!O000000o3.O0000O0o && O000000o3.f18273O000000o != null && gpy.O00000o0(CommonApplication.getAppContext(), "prefs_lite_config", "lite_config_click_sound", true)) {
                                        try {
                                            O000000o3.f18273O000000o.play(O000000o3.O00000o0, 1.0f, 1.0f, 0, 0, 1.0f);
                                        } catch (Exception unused) {
                                        }
                                    }
                                } else {
                                    gtt.O000000o().O00000Oo();
                                }
                            }
                        }
                    }
                    int left = hfu.f18874O000000o.getLeft() + (hfu.f18874O000000o.getWidth() / 2);
                    int top = hfu.f18874O000000o.getTop() + (hfu.f18874O000000o.getHeight() / 2);
                    hfu.O00000o0.setVisibility(0);
                    hfu.O00000o0.setTag(str2);
                    GridItemAnimView gridItemAnimView = hfu.O00000o0;
                    int i = andSet ? 4 : 3;
                    Animator.AnimatorListener o00000Oo2 = new O00000Oo(hfu, str2);
                    gridItemAnimView.f10308O000000o = i;
                    gridItemAnimView.O00000o0 = (float) left;
                    gridItemAnimView.O00000o = (float) top;
                    if (gridItemAnimView.O0000OoO.isRunning()) {
                        gridItemAnimView.O0000OoO.end();
                    }
                    gridItemAnimView.O0000OoO.removeAllListeners();
                    gridItemAnimView.O0000OoO.addListener(o00000Oo2);
                    gridItemAnimView.O0000OoO.start();
                    Device O000000o4 = fno.O000000o().O000000o(str2);
                    if (O000000o4 != null && (gridCard = faw.O00000o0().getGridCard(O000000o4)) != null) {
                        List O000000o5 = gridCard.O000000o();
                        ixe.O00000Oo(O000000o5, "card.getGridItems()");
                        Object O00000o02 = iuo.O00000o0(O000000o5);
                        if (O00000o02 instanceof hcc.O000000o) {
                            o000000o = O00000o02;
                        }
                        if (o000000o != null) {
                            ham.O000000o(O000000o4, 0, Integer.MAX_VALUE);
                            faw.O00000o0().toggleButton(O000000o4, 0, o000000o, new O00000o0(O000000o4, hby.f18766O000000o));
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void O000000o(hfu hfu, String str, MainPageDeviceModel mainPageDeviceModel, String str2, boolean z, View view) {
        hfu hfu2 = hfu;
        String str3 = str;
        MainPageDeviceModel mainPageDeviceModel2 = mainPageDeviceModel;
        String str4 = str2;
        View view2 = view;
        ixe.O00000o(hfu2, "this$0");
        ixe.O00000o(str3, "$did");
        ixe.O00000o(mainPageDeviceModel2, "$deviceModel");
        ixe.O00000o(str4, "$roomName");
        if (!hfu2.O00000o.O0000oO() && !hfu2.O00000o.O00000o()) {
            if (hfu2.O00000o.O00000Oo()) {
                if (hfu2.O0000oO0 == null) {
                    hfu2.O0000oO0 = (CheckBox) hfu2.O0000o0.inflate();
                }
                CheckBox checkBox = hfu2.O0000oO0;
                if (checkBox != null) {
                    checkBox.setVisibility(0);
                    checkBox.setChecked(!checkBox.isChecked());
                    if (checkBox.isChecked()) {
                        hfu2.O00000o.O0000Oo0().add(str3);
                    } else {
                        hfu2.O00000o.O0000Oo0().remove(str3);
                    }
                    hfu2.O00000o.O000000o(str3, checkBox.isChecked());
                    return;
                }
                return;
            }
            ixe.O00000Oo(view2, "it");
            hak.O000000o(view2, MainGridViewHolder$bind$2$2.f10244O000000o);
            gzr O0000oO02 = hfu2.O00000o.O0000oO0();
            Device O000000o2 = fno.O000000o().O000000o(str3);
            if (O000000o2 != null) {
                if ((gpy.O00000o0(CommonApplication.getAppContext(), "prefs_lite_config", "lite_config_device_card_shortcut", false) && mainPageDeviceModel2.O0000o0 == 0) && O0000oO02 != null) {
                    RectF O0000OOo2 = hzf.O0000OOo(view);
                    ixe.O00000Oo(O0000OOo2, "getLocationOnScreen(it)");
                    int i = 2;
                    hfu2.itemView.getLocationOnScreen(new int[2]);
                    O0000oO02.onClickCommonUseDevice(O000000o2, O0000OOo2, str4);
                    int O0000o0o2 = hfu2.O00000o.O0000o0o();
                    int adapterPosition = hfu.getAdapterPosition();
                    int O0000o002 = hfu2.O00000o.O0000o00();
                    if (O000000o2 != null) {
                        hxk hxk = hxi.O00000o;
                        String str5 = O000000o2.model;
                        boolean O00000o2 = fno.O000000o().O00000o(O000000o2);
                        String str6 = O000000o2.did;
                        if (O0000o0o2 == 0) {
                            hyg hyg = hxk.f952O000000o;
                            Object[] objArr = new Object[14];
                            objArr[0] = "model";
                            objArr[1] = str5;
                            objArr[2] = "room";
                            objArr[3] = str4;
                            objArr[4] = "share";
                            if (!O00000o2) {
                                i = 1;
                            }
                            objArr[5] = Integer.valueOf(i);
                            objArr[6] = "from";
                            objArr[7] = Integer.valueOf(O0000o0o2);
                            objArr[8] = "serial";
                            objArr[9] = Integer.valueOf(adapterPosition);
                            objArr[10] = "total";
                            objArr[11] = Integer.valueOf(O0000o002);
                            objArr[12] = "did";
                            objArr[13] = str6;
                            hyg.O000000o("home_model_float", objArr);
                            return;
                        }
                        hyg hyg2 = hxk.f952O000000o;
                        Object[] objArr2 = new Object[10];
                        objArr2[0] = "model";
                        objArr2[1] = str5;
                        objArr2[2] = "room";
                        objArr2[3] = str4;
                        objArr2[4] = "share";
                        if (!O00000o2) {
                            i = 1;
                        }
                        objArr2[5] = Integer.valueOf(i);
                        objArr2[6] = "from";
                        objArr2[7] = Integer.valueOf(O0000o0o2);
                        objArr2[8] = "did";
                        objArr2[9] = str6;
                        hyg2.O000000o("home_model_float", objArr2);
                    }
                } else if (O000000o2.pinCodeType != 1 || !O000000o2.isOwner() || (O000000o2 instanceof CameraDevice)) {
                    hfu2.O000000o(z, view2, O000000o2, str4);
                } else {
                    hxi.O00000o.O000000o((Integer) null);
                    new MLAlertDialog.Builder(view.getContext()).O00000Oo((int) R.string.device_more_security_new_feature_hint).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener(z, view, O000000o2, str2) {
                        /* class _m_j.$$Lambda$hfu$lldkyeSxYv_C9YWlIkQUBbX65xI */
                        private final /* synthetic */ boolean f$1;
                        private final /* synthetic */ View f$2;
                        private final /* synthetic */ Device f$3;
                        private final /* synthetic */ String f$4;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                            this.f$4 = r5;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            hfu.O000000o(hfu.this, this.f$1, this.f$2, this.f$3, this.f$4, dialogInterface, i);
                        }
                    }).O000000o((int) R.string.dialog_btn_allow, new DialogInterface.OnClickListener(view2) {
                        /* class _m_j.$$Lambda$hfu$dxKlcjWcXkRU0KOhHDuJJsP30oQ */
                        private final /* synthetic */ View f$0;

                        {
                            this.f$0 = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            hfu.O000000o(this.f$0, dialogInterface, i);
                        }
                    }).O00000o0().O00000oo();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void O000000o(hfu hfu, boolean z, View view, Device device, String str, DialogInterface dialogInterface, int i) {
        ixe.O00000o(hfu, "this$0");
        ixe.O00000o(device, "$device");
        ixe.O00000o(str, "$roomName");
        ixe.O00000Oo(view, "it");
        hfu.O000000o(z, view, device, str);
        hxi.O00000o.O000000o((Integer) 0);
    }

    /* access modifiers changed from: private */
    public static final void O000000o(View view, DialogInterface dialogInterface, int i) {
        fbs.O000000o(new fbt(view.getContext(), "DevicePinVerifyClearActivity"));
        hxi.O00000o.O000000o((Integer) 1);
    }

    /* access modifiers changed from: private */
    public static final boolean O000000o(hfu hfu, String str, boolean z, MainPageDeviceModel mainPageDeviceModel, View view) {
        boolean z2;
        hfu hfu2 = hfu;
        String str2 = str;
        MainPageDeviceModel mainPageDeviceModel2 = mainPageDeviceModel;
        ixe.O00000o(hfu2, "this$0");
        ixe.O00000o(str2, "$did");
        ixe.O00000o(mainPageDeviceModel2, "$deviceModel");
        if (hfu2.O00000o.O0000oO() || hfu2.O00000o.O00000o()) {
            return false;
        }
        if ((hfu2.O00000o.O00000o0() || hfu2.O00000o.O00000oO() == DviceEditInterface.HostPage.TRANSFER_GUIDE_PAGE) && hfu2.O00000o.O0000o0o() != 2) {
            gs gsVar = hfu2.O00000oO;
            if (gsVar != null) {
                gsVar.O00000Oo(hfu2);
            }
            if (hfu2.O00000o.O0000oO0() != null && !hfu2.O00000o.O00000Oo()) {
                hfu2.O00000o.O0000oO0().enterEditMode(hfu2.O00000o);
                hfu2.O00000o.O0000o0();
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                hfu2.O00000o.O000000o(str2, true);
                CheckBox checkBox = hfu2.O0000oO0;
                if (checkBox != null) {
                    checkBox.setChecked(true);
                }
            }
            if (z) {
                htw O000000o2 = htv.O000000o();
                if (O000000o2 != null) {
                    O000000o2.cleanScrollToDid();
                }
                Device O000000o3 = fno.O000000o().O000000o(str2);
                if (O000000o3 != null && O000000o3.isNew) {
                    if (O000000o3 instanceof BleDevice) {
                        ((BleDevice) O000000o3).O000000o(false);
                    } else {
                        O000000o3.isNew = false;
                    }
                }
            }
            hxk hxk = hxi.O00000o;
            String str3 = mainPageDeviceModel2.O00000oO;
            int O0000o0o2 = hfu2.O00000o.O0000o0o();
            int adapterPosition = hfu.getAdapterPosition();
            int O0000o002 = hfu2.O00000o.O0000o00();
            if (O0000o0o2 == 0) {
                hxk.f952O000000o.O000000o("home_longpress_plugin", "model", str3, "from", Integer.valueOf(O0000o0o2), "serial", Integer.valueOf(adapterPosition), "total", Integer.valueOf(O0000o002), "did", str2);
            } else {
                hxk.f952O000000o.O000000o("home_longpress_plugin", "model", str3, "from", Integer.valueOf(O0000o0o2), "did", str2);
            }
            return true;
        }
        if (!ggb.O00000Oo().O0000Oo0().isOwner()) {
            gqg.O00000Oo((int) R.string.share_family_none_editable);
        }
        return true;
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/xiaomi/smarthome/newui/mainpage/MainGridViewHolder$playBgAnim$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O00000Oo implements Animator.AnimatorListener {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ hfu f18876O000000o;
        final /* synthetic */ String O00000Oo;

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }

        O00000Oo(hfu hfu, String str) {
            this.f18876O000000o = hfu;
            this.O00000Oo = str;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
         arg types: [java.lang.Object, java.lang.String]
         candidates:
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
        public final void onAnimationEnd(Animator animator) {
            if (ixe.O000000o(this.f18876O000000o.O00000o0.getTag(), (Object) this.O00000Oo)) {
                this.f18876O000000o.O00000o0.setVisibility(8);
                this.f18876O000000o.O00000o0.setTag(null);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/xiaomi/smarthome/newui/mainpage/MainGridViewHolder$toggleInvoked$1", "Lcom/xiaomi/smarthome/newui/card/AsyncTimeoutCallback;", "Ljava/lang/Void;", "onFailure", "", "error", "Lcom/xiaomi/smarthome/frame/Error;", "onSuccess", "result", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O00000o0 extends hby<Void> {
        final /* synthetic */ Device O00000Oo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        O00000o0(Device device, int i) {
            super(i);
            this.O00000Oo = device;
        }

        public final void onFailure(fso fso) {
            hza.O000000o((Application) ServiceApplication.getApplication());
            ham.O000000o(this.O00000Oo, 2, fso == null ? -9999 : fso.f17063O000000o);
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            hza.O000000o((Application) ServiceApplication.getApplication());
            ham.O000000o(this.O00000Oo, 1, 0);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(boolean, com.xiaomi.smarthome.frame.core.CoreApi$O000O0o0):void
     arg types: [int, _m_j.fqp$1]
     candidates:
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.account.OAuthAccount, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.frame.server_compact.ServerBean, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.youpin.login.entity.account.LoginMiAccount, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.util.List<com.xiaomi.smarthome.core.server.internal.device.BatchRpcParam>, _m_j.fsm<org.json.JSONObject, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.util.Locale, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.bluetooth.IBleChannelReader):com.xiaomi.smarthome.core.server.bluetooth.IBleChannelWriter
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(long, long):java.lang.String
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.frame.core.CoreApi$O0000o00):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.frame.core.CoreApi$O0000o0):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.frame.core.CoreApi$O0000o):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.frame.core.CoreApi$O00oOooO):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest, com.xiaomi.smarthome.core.server.bluetooth.SearchResponse):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, byte[]):byte[]
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(boolean, com.xiaomi.smarthome.frame.core.CoreApi$O000O0o0):void */
    private final void O000000o(boolean z, View view, Device device, String str) {
        Device device2 = device;
        if (z) {
            Context context = view.getContext();
            if (!CoreApi.O000000o().O0000Ooo()) {
                gty.O000000o().startLogin(context, 1, null);
                return;
            }
            String O000000o2 = fqw.O000000o();
            if (TextUtils.isEmpty(O000000o2)) {
                return;
            }
            if (!CoreApi.O000000o().O00000o(O000000o2)) {
                CoreApi.O000000o().O000000o(true, (CoreApi.O000O0o0) new CoreApi.O000O0o0() {
                    /* class _m_j.fqp.AnonymousClass1 */

                    public final void O000000o(boolean z) {
                        if (z) {
                            fno.O000000o().O0000Ooo();
                        }
                    }
                });
                izb.O000000o(context, (int) R.string.toast_failed_retry, 0).show();
                return;
            }
            fqw.O00000o();
            fqw.O000000o(context, (Intent) null);
            return;
        }
        ext.O000000o o000000o = ext.f15931O000000o;
        eyc O000000o3 = ext.O000000o.O000000o(device);
        Context context2 = view.getContext();
        if (context2 != null) {
            Handler handler = ((BaseActivity) context2).mHandler;
            Context context3 = view.getContext();
            Context context4 = view.getContext();
            if (context4 != null) {
                O000000o3.onItemClick(view, handler, device, context3, (BaseActivity) context4);
                int O0000o0o2 = this.O00000o.O0000o0o();
                int adapterPosition = getAdapterPosition();
                int O0000o002 = this.O00000o.O0000o00();
                if (device2 != null) {
                    hxk hxk = hxi.O00000o;
                    String str2 = device2.model;
                    boolean O00000o2 = fno.O000000o().O00000o(device2);
                    String str3 = device2.did;
                    int i = 2;
                    if (O0000o0o2 == 0) {
                        hyg hyg = hxk.f952O000000o;
                        Object[] objArr = new Object[14];
                        objArr[0] = "model";
                        objArr[1] = str2;
                        objArr[2] = "room";
                        objArr[3] = str;
                        objArr[4] = "share";
                        if (!O00000o2) {
                            i = 1;
                        }
                        objArr[5] = Integer.valueOf(i);
                        objArr[6] = "from";
                        objArr[7] = Integer.valueOf(O0000o0o2);
                        objArr[8] = "serial";
                        objArr[9] = Integer.valueOf(adapterPosition);
                        objArr[10] = "total";
                        objArr[11] = Integer.valueOf(O0000o002);
                        objArr[12] = "did";
                        objArr[13] = str3;
                        hyg.O000000o("home_model_click", objArr);
                        return;
                    }
                    hyg hyg2 = hxk.f952O000000o;
                    Object[] objArr2 = new Object[10];
                    objArr2[0] = "model";
                    objArr2[1] = str2;
                    objArr2[2] = "room";
                    objArr2[3] = str;
                    objArr2[4] = "share";
                    if (!O00000o2) {
                        i = 1;
                    }
                    objArr2[5] = Integer.valueOf(i);
                    objArr2[6] = "from";
                    objArr2[7] = Integer.valueOf(O0000o0o2);
                    objArr2[8] = "did";
                    objArr2[9] = str3;
                    hyg2.O000000o("home_model_click", objArr2);
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.xiaomi.smarthome.framework.page.BaseActivity");
        }
        throw new NullPointerException("null cannot be cast to non-null type com.xiaomi.smarthome.framework.page.BaseActivity");
    }

    private final boolean O000000o() {
        int O0000o0o2 = this.O00000o.O0000o0o();
        return O0000o0o2 == 0 || O0000o0o2 == 3 || O0000o0o2 == 6 || O0000o0o2 == 7;
    }

    private final void O000000o(int i) {
        ViewGroup.LayoutParams layoutParams = this.O0000OOo.getLayoutParams();
        if (layoutParams != null) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            float f = (float) i;
            if (!(f == layoutParams2.weight)) {
                layoutParams2.weight = f;
                this.O0000OOo.requestLayout();
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    }
}
