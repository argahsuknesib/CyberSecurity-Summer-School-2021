package com.smarthome.uwb.ui.widget;

import _m_j.ddu;
import _m_j.etx;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.fqs;
import _m_j.fqy;
import _m_j.fsm;
import _m_j.fso;
import _m_j.fss;
import _m_j.ftn;
import _m_j.gfr;
import _m_j.gpb;
import _m_j.gqb;
import _m_j.gsy;
import _m_j.hvg;
import _m_j.hxc;
import _m_j.iuf;
import _m_j.iuo;
import _m_j.ixe;
import _m_j.ixh;
import _m_j.iyo;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.RemoteException;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.smarthome.uwb.ui.widget.OfflinePage;
import com.xiaomi.router.miio.miioplugin.IPluginRequest;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.device.MiTVDevice;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.newui.page.IPage;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 &2\u00020\u0001:\u0001&B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J<\u0010\u0007\u001a\u00020\b2\"\u0010\t\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0002J\b\u0010\u0012\u001a\u00020\bH\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fH\u0002J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0014J\"\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\fH\u0003J\u0010\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/smarthome/uwb/ui/widget/OfflinePage;", "Lcom/xiaomi/smarthome/newui/page/IPage;", "activity", "Landroidx/fragment/app/FragmentActivity;", "device", "Lcom/xiaomi/smarthome/device/Device;", "(Landroidx/fragment/app/FragmentActivity;Lcom/xiaomi/smarthome/device/Device;)V", "checkDeviceRssi", "", "callback", "Lcom/xiaomi/smarthome/frame/AsyncCallback;", "Lkotlin/Pair;", "", "Lorg/json/JSONObject;", "Lcom/xiaomi/smarthome/frame/Error;", "did", "", "type", "dismiss", "getPluginIcon", "model", "getResoursUri", "Landroid/net/Uri;", "resource", "initView", "root", "Landroid/view/View;", "onCreateView", "container", "Landroid/view/ViewGroup;", "setIconByUrl", "imageView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "placeHolder", "setOfflineReasonByDeviceType", "offlineDescTv", "Landroid/widget/TextView;", "show", "Companion", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class OfflinePage extends IPage {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final O000000o f5756O000000o = new O000000o((byte) 0);
    private static final List<Pair<Integer, Integer>> O0000OOo;
    private static final List<Pair<Integer, Integer>> O0000Oo;
    private static final List<Pair<Integer, Integer>> O0000Oo0;
    private static final List<Pair<Integer, Integer>> O0000OoO;
    private static final List<Pair<Integer, Integer>> O0000Ooo;
    private static final List<Pair<Integer, Integer>> O0000o0;
    private static final List<Pair<Integer, Integer>> O0000o00;
    private static final List<Pair<Integer, Integer>> O0000o0O;
    public final FragmentActivity O00000Oo;
    public final Device O00000o0;

    /* access modifiers changed from: private */
    public static final void O000000o(View view) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OfflinePage(FragmentActivity fragmentActivity, Device device) {
        super(fragmentActivity);
        ixe.O00000o(fragmentActivity, "activity");
        ixe.O00000o(device, "device");
        this.O00000Oo = fragmentActivity;
        this.O00000o0 = device;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t0\bX\u0004¢\u0006\u0002\n\u0000R \u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t0\bX\u0004¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t0\bX\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t0\bX\u0004¢\u0006\u0002\n\u0000R \u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t0\bX\u0004¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t0\bX\u0004¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t0\bX\u0004¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/smarthome/uwb/ui/widget/OfflinePage$Companion;", "", "()V", "INVALID_RES_ID", "", "TAG", "", "bleOfflineDesc", "", "Lkotlin/Pair;", "elseOfflineDesc", "elseOfflineDescForBluetooh", "iRfflineDesc", "nBIotOfflineDesc", "tvOfflineDesc", "wifiOfflineDesc", "zigbeeOfflineDesc", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o {
        public /* synthetic */ O000000o(byte b) {
            this();
        }

        private O000000o() {
        }
    }

    static {
        Integer valueOf = Integer.valueOf((int) R.string.offline_reason_desc_1);
        Integer valueOf2 = Integer.valueOf((int) R.string.offline_reason_desc_2);
        Integer valueOf3 = Integer.valueOf((int) R.string.offline_reason_desc_3);
        Integer valueOf4 = Integer.valueOf((int) R.string.desc_reconnect);
        O0000OOo = iuo.O000000o((Object[]) new Pair[]{iuf.O000000o(valueOf, -1), iuf.O000000o(valueOf2, -1), iuf.O000000o(valueOf3, valueOf4), iuf.O000000o(Integer.valueOf((int) R.string.offline_reason_desc_4), -1)});
        Integer valueOf5 = Integer.valueOf((int) R.string.offline_reason_desc_5);
        Integer valueOf6 = Integer.valueOf((int) R.string.offline_reason_desc_6);
        O0000Oo0 = iuo.O000000o((Object[]) new Pair[]{iuf.O000000o(valueOf, -1), iuf.O000000o(valueOf5, -1), iuf.O000000o(valueOf6, valueOf4)});
        O0000Oo = iuo.O000000o((Object[]) new Pair[]{iuf.O000000o(valueOf, -1), iuf.O000000o(valueOf6, valueOf4), iuf.O000000o(Integer.valueOf((int) R.string.offline_reason_desc_7), -1)});
        O0000OoO = iuo.O000000o(iuf.O000000o(valueOf5, -1));
        Integer valueOf7 = Integer.valueOf((int) R.string.offline_reason_desc_8);
        O0000Ooo = iuo.O000000o((Object[]) new Pair[]{iuf.O000000o(valueOf7, -1), iuf.O000000o(valueOf6, valueOf4)});
        O0000o00 = iuo.O000000o((Object[]) new Pair[]{iuf.O000000o(Integer.valueOf((int) R.string.offline_reason_desc_9), -1), iuf.O000000o(valueOf2, -1)});
        O0000o0 = iuo.O000000o((Object[]) new Pair[]{iuf.O000000o(valueOf7, -1), iuf.O000000o(valueOf6, valueOf4)});
        O0000o0O = iuo.O000000o((Object[]) new Pair[]{iuf.O000000o(valueOf7, -1), iuf.O000000o(valueOf6, Integer.valueOf((int) R.string.retry_network))});
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.iyx.O000000o(java.lang.CharSequence, java.lang.String, int, boolean, int):int
     arg types: [java.lang.String, java.lang.String, int, int, int]
     candidates:
      _m_j.iyx.O000000o(java.lang.CharSequence, java.lang.CharSequence, int, int, boolean):boolean
      _m_j.iyw.O000000o(java.lang.String, java.lang.String, int, int, boolean):boolean
      _m_j.iyx.O000000o(java.lang.CharSequence, java.lang.String, int, boolean, int):int */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0242  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0268  */
    public final View O000000o(ViewGroup viewGroup) {
        List<Pair<Integer, Integer>> list;
        View view;
        View view2;
        SimpleDraweeView simpleDraweeView;
        ixe.O00000o(viewGroup, "container");
        View inflate = LayoutInflater.from(this.O00000Oo).inflate((int) R.layout.uwb_offline_dialog_view, (ViewGroup) null);
        ixe.O00000Oo(inflate, "root");
        SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) inflate.findViewById(R.id.device_icon);
        TextView textView = (TextView) inflate.findViewById(R.id.offline_reason);
        TextView textView2 = (TextView) inflate.findViewById(R.id.more_reason);
        View findViewById = inflate.findViewById(R.id.close);
        TextView textView3 = (TextView) inflate.findViewById(R.id.back);
        View findViewById2 = inflate.findViewById(R.id.float_main);
        findViewById2.setOnClickListener($$Lambda$OfflinePage$h1sT0OstUit8g4aqaBwghW3S8U.INSTANCE);
        Locale O00000o02 = ftn.O00000o0(this.O00000Oo);
        ixe.O00000Oo(O00000o02, "getGlobalSettingLocale(activity)");
        gqb.O000000o(this.O00000Oo, O00000o02, (int) R.string.device_is_offline, (TextView) inflate.findViewById(R.id.offline_desc));
        gqb.O000000o(this.O00000Oo, O00000o02, (int) R.string.action_back_main, textView3);
        ixe.O00000Oo(textView, "offlineReasonTv");
        if (ixe.O000000o(gpb.O000000o(this.O00000o0.model), MiTVDevice.class)) {
            list = O0000o00;
        } else {
            int i = this.O00000o0.pid;
            if (i == 0) {
                list = O0000OOo;
            } else if (i == 3) {
                list = O0000Oo0;
            } else if (i == 6) {
                list = O0000o0O;
            } else if (i == 13) {
                list = O0000Ooo;
            } else if (i == 15) {
                list = O0000OoO;
            } else if (i != 16) {
                list = O0000o0;
            } else {
                list = O0000Oo;
            }
        }
        Locale O00000o03 = ftn.O00000o0(this.O00000Oo);
        ixe.O00000Oo(O00000o03, "getGlobalSettingLocale(activity)");
        SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf("");
        if (list.size() == 1) {
            valueOf.append((CharSequence) gqb.O000000o(this.O00000Oo, O00000o03, ((Number) ((Pair) list.get(0)).first).intValue()));
            textView.setTextAlignment(4);
            textView.setGravity(17);
        } else {
            int size = list.size() - 1;
            if (size >= 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    Pair pair = (Pair) list.get(i2);
                    view = findViewById2;
                    valueOf.append((CharSequence) String.valueOf(i3)).append((CharSequence) ".");
                    FragmentActivity fragmentActivity = this.O00000Oo;
                    view2 = inflate;
                    String O000000o2 = gqb.O000000o(fragmentActivity, ftn.O00000o0(fragmentActivity), ((Number) pair.first).intValue());
                    if (-1 == ((Number) pair.second).intValue()) {
                        valueOf.append((CharSequence) O000000o2);
                        simpleDraweeView = simpleDraweeView2;
                    } else {
                        FragmentActivity fragmentActivity2 = this.O00000Oo;
                        String O000000o3 = gqb.O000000o(fragmentActivity2, ftn.O00000o0(fragmentActivity2), ((Number) pair.second).intValue());
                        ixh ixh = ixh.f1644O000000o;
                        ixe.O00000Oo(O000000o2, "descTex");
                        String format = String.format(O000000o2, Arrays.copyOf(new Object[]{O000000o3}, 1));
                        ixe.O00000Oo(format, "java.lang.String.format(format, *args)");
                        valueOf.append((CharSequence) format);
                        String spannableStringBuilder = valueOf.toString();
                        ixe.O00000Oo(spannableStringBuilder, "sb.toString()");
                        ixe.O00000Oo(O000000o3, "reconnectArgs");
                        simpleDraweeView = simpleDraweeView2;
                        int O000000o4 = iyo.O000000o((CharSequence) spannableStringBuilder, O000000o3, 0, false, 6);
                        valueOf.setSpan(new O0000OOo(this, textView), O000000o4, O000000o3.length() + O000000o4, 33);
                    }
                    if (i2 != list.size() - 1) {
                        valueOf.append((CharSequence) "\n");
                    }
                    if (i3 > size) {
                        break;
                    }
                    i2 = i3;
                    simpleDraweeView2 = simpleDraweeView;
                    inflate = view2;
                    findViewById2 = view;
                }
                textView.setHighlightColor(0);
                textView.setText(valueOf);
                textView.setMovementMethod(LinkMovementMethod.getInstance());
                String O000000o5 = gqb.O000000o(this.O00000Oo, O00000o02, (int) R.string.more_offline_reason);
                SpannableStringBuilder valueOf2 = SpannableStringBuilder.valueOf(O000000o5);
                valueOf2.setSpan(new UnderlineSpan(), 0, O000000o5.length(), 33);
                textView2.setHighlightColor(0);
                textView2.setTextColor(-10066330);
                textView2.setText(valueOf2);
                textView2.setOnClickListener(new View.OnClickListener() {
                    /* class com.smarthome.uwb.ui.widget.$$Lambda$OfflinePage$4RCZk8TnCBeLkf11Be78aH2F1Pg */

                    public final void onClick(View view) {
                        OfflinePage.O00000Oo(OfflinePage.this, view);
                    }
                });
                findViewById.setOnClickListener(new View.OnClickListener() {
                    /* class com.smarthome.uwb.ui.widget.$$Lambda$OfflinePage$iigjFai1H2Ls0VVNJC_s4yw2OSg */

                    public final void onClick(View view) {
                        OfflinePage.O00000o0(OfflinePage.this, view);
                    }
                });
                textView3.setOnClickListener(new View.OnClickListener() {
                    /* class com.smarthome.uwb.ui.widget.$$Lambda$OfflinePage$ploYopBwKwOD5manxpgXiVb5Vo */

                    public final void onClick(View view) {
                        OfflinePage.O00000o(OfflinePage.this, view);
                    }
                });
                if (!TextUtils.isEmpty(this.O00000o0.model)) {
                    ddu.O000000o(this.O00000o0.model, new O00000o0(this, simpleDraweeView));
                }
                View view3 = view2;
                TextView textView4 = (TextView) view3.findViewById(R.id.offline_rssi);
                textView4.setVisibility(8);
                if (this.O00000o0.pid == 0) {
                    fsm o00000o = new O00000o(this, textView4);
                    String str = this.O00000o0.did;
                    ixe.O00000Oo(str, "device.did");
                    JSONObject jSONObject = new JSONObject();
                    try {
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(str);
                        jSONObject.put("dids", jSONArray);
                        jSONObject.put("type", 0);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    CoreApi.O000000o().O000000o((Context) null, new NetRequest.O000000o().O000000o("GET").O00000Oo("/v2/device/devicerssi").O000000o(iuo.O000000o(new KeyValuePair("data", new O00000Oo().toString()))).O000000o(), new fss(str) {
                        /* class com.smarthome.uwb.ui.widget.$$Lambda$OfflinePage$GSttXWZ6jPCojyYWJdtBQMCPU8 */
                        private final /* synthetic */ String f$0;

                        {
                            this.f$0 = r1;
                        }

                        public final Object parse(JSONObject jSONObject) {
                            return OfflinePage.O000000o(this.f$0, jSONObject);
                        }
                    }, Crypto.RC4, o00000o);
                }
                view.animate().translationY(0.0f);
                return view3;
            }
        }
        simpleDraweeView = simpleDraweeView2;
        view2 = inflate;
        view = findViewById2;
        textView.setHighlightColor(0);
        textView.setText(valueOf);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        String O000000o52 = gqb.O000000o(this.O00000Oo, O00000o02, (int) R.string.more_offline_reason);
        SpannableStringBuilder valueOf22 = SpannableStringBuilder.valueOf(O000000o52);
        valueOf22.setSpan(new UnderlineSpan(), 0, O000000o52.length(), 33);
        textView2.setHighlightColor(0);
        textView2.setTextColor(-10066330);
        textView2.setText(valueOf22);
        textView2.setOnClickListener(new View.OnClickListener() {
            /* class com.smarthome.uwb.ui.widget.$$Lambda$OfflinePage$4RCZk8TnCBeLkf11Be78aH2F1Pg */

            public final void onClick(View view) {
                OfflinePage.O00000Oo(OfflinePage.this, view);
            }
        });
        findViewById.setOnClickListener(new View.OnClickListener() {
            /* class com.smarthome.uwb.ui.widget.$$Lambda$OfflinePage$iigjFai1H2Ls0VVNJC_s4yw2OSg */

            public final void onClick(View view) {
                OfflinePage.O00000o0(OfflinePage.this, view);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() {
            /* class com.smarthome.uwb.ui.widget.$$Lambda$OfflinePage$ploYopBwKwOD5manxpgXiVb5Vo */

            public final void onClick(View view) {
                OfflinePage.O00000o(OfflinePage.this, view);
            }
        });
        if (!TextUtils.isEmpty(this.O00000o0.model)) {
        }
        View view32 = view2;
        TextView textView42 = (TextView) view32.findViewById(R.id.offline_rssi);
        textView42.setVisibility(8);
        if (this.O00000o0.pid == 0) {
        }
        view.animate().translationY(0.0f);
        return view32;
    }

    public final void e_() {
        super.e_();
        View view = this.O00000oO;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.smarthome.uwb.ui.widget.$$Lambda$OfflinePage$UehOIQALIibYQeSOB0tKGSavw */

                public final void onClick(View view) {
                    OfflinePage.O000000o(OfflinePage.this, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static final void O000000o(OfflinePage offlinePage, View view) {
        ixe.O00000o(offlinePage, "this$0");
        offlinePage.O00000Oo();
    }

    /* access modifiers changed from: private */
    public static final void O000000o(OfflinePage offlinePage) {
        ixe.O00000o(offlinePage, "this$0");
        super.O00000Oo();
    }

    /* access modifiers changed from: private */
    public static final void O00000Oo(OfflinePage offlinePage, View view) {
        String str;
        ixe.O00000o(offlinePage, "this$0");
        Intent intent = new Intent();
        hvg.O000000o(offlinePage.O00000Oo).O000000o(offlinePage.O00000o0.model);
        hxc.O000000o().O000000o(offlinePage.O00000o0.model, 9);
        intent.setClassName(offlinePage.O00000Oo.getPackageName(), "com.xiaomi.smarthome.miio.activity.DeviceOfflineDetailActivity");
        intent.putExtra("extra_model", offlinePage.O00000o0.model);
        intent.putExtra("did", offlinePage.O00000o0.did);
        fqy.O000000o(intent, 9);
        if (ixe.O000000o(gpb.O000000o(offlinePage.O00000o0.model), MiTVDevice.class)) {
            str = "TV_etc";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(offlinePage.O00000o0.pid);
            str = sb.toString();
        }
        intent.putExtra("arg_device_type", str);
        intent.addFlags(268435456);
        offlinePage.O00000Oo.startActivity(intent);
    }

    /* access modifiers changed from: private */
    public static final void O00000o0(OfflinePage offlinePage, View view) {
        ixe.O00000o(offlinePage, "this$0");
        offlinePage.O00000Oo();
    }

    /* access modifiers changed from: private */
    public static final void O00000o(OfflinePage offlinePage, View view) {
        ixe.O00000o(offlinePage, "this$0");
        fbt fbt = new fbt(offlinePage.O00000Oo, "SmartHomeMainActivity");
        fbt.O00000Oo(603979776);
        fbs.O000000o(fbt);
        offlinePage.O00000Oo();
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"com/smarthome/uwb/ui/widget/OfflinePage$initView$5", "Lcom/xiaomi/smarthome/frame/AsyncCallback;", "Lcom/smarthome/uwb/ui/auth/DeviceImageApi$DeviceImageEntity;", "Lcom/xiaomi/smarthome/frame/Error;", "onFailure", "", "error", "onSuccess", "entity", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O00000o0 extends fsm<ddu.O000000o, fso> {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ OfflinePage f5758O000000o;
        final /* synthetic */ SimpleDraweeView O00000Oo;

        public final /* synthetic */ void onSuccess(Object obj) {
            ddu.O000000o o000000o = (ddu.O000000o) obj;
            ixe.O00000o(o000000o, "entity");
            if (!this.f5758O000000o.O00000Oo.isDestroyed()) {
                return;
            }
            if (!TextUtils.isEmpty(o000000o.f14524O000000o)) {
                AbstractDraweeController build = ((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setUri(o000000o.f14524O000000o).setAutoPlayAnimations(true)).build();
                ixe.O00000Oo(build, "newDraweeControllerBuilder()\n                                .setUri(entity.image)\n                                .setAutoPlayAnimations(true)\n                                .build()");
                this.O00000Oo.setController(build);
                return;
            }
            OfflinePage offlinePage = this.f5758O000000o;
            String str = offlinePage.O00000o0.model;
            ixe.O00000Oo(str, "device.model");
            SimpleDraweeView simpleDraweeView = this.O00000Oo;
            ixe.O00000Oo(simpleDraweeView, "deviceIcon");
            OfflinePage.O000000o(offlinePage, str, simpleDraweeView);
        }

        O00000o0(OfflinePage offlinePage, SimpleDraweeView simpleDraweeView) {
            this.f5758O000000o = offlinePage;
            this.O00000Oo = simpleDraweeView;
        }

        public final void onFailure(fso fso) {
            if (this.f5758O000000o.O00000Oo.isDestroyed()) {
                OfflinePage offlinePage = this.f5758O000000o;
                String str = offlinePage.O00000o0.model;
                ixe.O00000Oo(str, "device.model");
                SimpleDraweeView simpleDraweeView = this.O00000Oo;
                ixe.O00000Oo(simpleDraweeView, "deviceIcon");
                OfflinePage.O000000o(offlinePage, str, simpleDraweeView);
            }
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016J\u001e\u0010\t\u001a\u00020\u00072\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002H\u0016¨\u0006\u000b"}, d2 = {"com/smarthome/uwb/ui/widget/OfflinePage$initView$6", "Lcom/xiaomi/smarthome/frame/AsyncCallback;", "Lkotlin/Pair;", "", "Lorg/json/JSONObject;", "Lcom/xiaomi/smarthome/frame/Error;", "onFailure", "", "error", "onSuccess", "result", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O00000o extends fsm<Pair<? extends Integer, ? extends JSONObject>, fso> {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ OfflinePage f5757O000000o;
        final /* synthetic */ TextView O00000Oo;

        O00000o(OfflinePage offlinePage, TextView textView) {
            this.f5757O000000o = offlinePage;
            this.O00000Oo = textView;
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            Pair pair = (Pair) obj;
            if (pair != null && !this.f5757O000000o.O00000Oo.isDestroyed()) {
                int intValue = ((Number) pair.first).intValue();
                String optString = ((JSONObject) pair.second).optString("note");
                if (intValue != 0 && !TextUtils.isEmpty(optString)) {
                    this.O00000Oo.setVisibility(0);
                    this.O00000Oo.setText(gqb.O000000o(this.f5757O000000o.O00000Oo, ftn.O00000o0(this.f5757O000000o.O00000Oo), (int) R.string.device_rssi_check));
                    TextView textView = this.O00000Oo;
                    textView.postDelayed(new Runnable(textView, optString) {
                        /* class com.smarthome.uwb.ui.widget.$$Lambda$OfflinePage$O00000o$ZGLCd06SV2p2TraX3VWv9nO_Xiw */
                        private final /* synthetic */ TextView f$1;
                        private final /* synthetic */ String f$2;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void run() {
                            OfflinePage.O00000o.O000000o(OfflinePage.this, this.f$1, this.f$2);
                        }
                    }, 1500);
                }
            }
        }

        /* access modifiers changed from: private */
        public static final void O000000o(OfflinePage offlinePage, TextView textView, String str) {
            ixe.O00000o(offlinePage, "this$0");
            if (!offlinePage.O00000Oo.isDestroyed()) {
                textView.setText(str);
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
         arg types: [java.lang.String, java.lang.String]
         candidates:
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
        public final void onFailure(fso fso) {
            if (!this.f5757O000000o.O00000Oo.isDestroyed() && gfr.f17662O000000o) {
                gsy.O00000Oo("OfflinePage", ixe.O000000o("onFailure: ", (Object) (fso == null ? null : fso.O00000Oo)));
            }
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/smarthome/uwb/ui/widget/OfflinePage$checkDeviceRssi$params$1", "", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O00000Oo {
        O00000Oo() {
        }
    }

    /* access modifiers changed from: private */
    public static final Pair O000000o(String str, JSONObject jSONObject) {
        ixe.O00000o(str, "$did");
        gsy.O00000Oo("OfflinePage", jSONObject.toString());
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return iuf.O000000o(Integer.valueOf(jSONObject2.getInt("net_stat")), jSONObject2);
        } catch (Exception unused) {
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/smarthome/uwb/ui/widget/OfflinePage$setOfflineReasonByDeviceType$clickableSpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O0000OOo extends ClickableSpan {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ OfflinePage f5760O000000o;
        final /* synthetic */ TextView O00000Oo;

        O0000OOo(OfflinePage offlinePage, TextView textView) {
            this.f5760O000000o = offlinePage;
            this.O00000Oo = textView;
        }

        public final void onClick(View view) {
            ixe.O00000o(view, "widget");
            if (this.f5760O000000o.O00000o0.pid == 6) {
                IPluginRequest O00000Oo2 = etx.O000000o().O00000Oo();
                if (O00000Oo2 != null) {
                    try {
                        O00000Oo2.visualSecureBind(this.f5760O000000o.O00000o0.did);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                this.f5760O000000o.O00000Oo.finish();
                return;
            }
            hvg.O000000o(this.f5760O000000o.O00000Oo).O000000o(this.f5760O000000o.O00000o0.model);
            Intent intent = new Intent();
            hxc.O000000o().O000000o(this.f5760O000000o.O00000o0.model, 9);
            intent.setClassName(this.f5760O000000o.O00000Oo.getPackageName(), "com.xiaomi.smarthome.device.choosedevice.ResetPageRoute");
            intent.putExtra("extra_model", this.f5760O000000o.O00000o0.model);
            fqy.O000000o(intent, 9);
            intent.addFlags(268435456);
            this.f5760O000000o.O00000Oo.startActivity(intent);
        }

        public final void updateDrawState(TextPaint textPaint) {
            ixe.O00000o(textPaint, "ds");
            super.updateDrawState(textPaint);
            textPaint.setColor(this.O00000Oo.getResources().getColor(R.color.mj_color_green_normal));
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/smarthome/uwb/ui/widget/OfflinePage$setIconByUrl$1", "Lcom/facebook/drawee/controller/BaseControllerListener;", "", "onFailure", "", "id", "", "throwable", "", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O0000O0o extends BaseControllerListener<Object> {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ String f5759O000000o;

        O0000O0o(String str) {
            this.f5759O000000o = str;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
         arg types: [java.lang.String, java.lang.String]
         candidates:
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
        public final void onFailure(String str, Throwable th) {
            ixe.O00000o(str, "id");
            ixe.O00000o(th, "throwable");
            gsy.O000000o(6, "Failure", ixe.O000000o(str, (Object) " decode failed"));
            Fresco.getImagePipeline().evictFromMemoryCache(Uri.parse(this.f5759O000000o));
            Fresco.getImagePipeline().evictFromDiskCache(Uri.parse(this.f5759O000000o));
        }
    }

    private static Uri O000000o(int i) {
        Uri parse = Uri.parse("res://" + ((Object) gfr.O0000O0o) + '/' + i);
        ixe.O00000Oo(parse, "parse(\"res://\" + GlobalSetting.PACKAGE_NAME + \"/\" + resource)");
        return parse;
    }

    public final void O00000Oo() {
        ViewPropertyAnimator translationY;
        View findViewById;
        ViewPropertyAnimator animate;
        View view = this.O00000oO;
        ViewPropertyAnimator viewPropertyAnimator = null;
        View findViewById2 = view == null ? null : view.findViewById(R.id.container);
        if (!(findViewById2 == null || (animate = findViewById2.animate()) == null)) {
            animate.alpha(0.0f);
        }
        View view2 = this.O00000oO;
        if (!(view2 == null || (findViewById = view2.findViewById(R.id.float_main)) == null)) {
            viewPropertyAnimator = findViewById.animate();
        }
        if (viewPropertyAnimator != null && (translationY = viewPropertyAnimator.translationY(500.0f)) != null) {
            translationY.withEndAction(new Runnable() {
                /* class com.smarthome.uwb.ui.widget.$$Lambda$OfflinePage$iVTaK5DkpkZTz0jeouXTUfEKuXs */

                public final void run() {
                    OfflinePage.O000000o(OfflinePage.this);
                }
            });
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.iyw.O000000o(java.lang.String, java.lang.String, boolean):boolean
     arg types: [java.lang.String, java.lang.String, int]
     candidates:
      _m_j.iyx.O000000o(java.lang.CharSequence, int, int):int
      _m_j.iyx.O000000o(java.lang.CharSequence, java.lang.CharSequence, boolean):boolean
      _m_j.iyw.O000000o(java.lang.String, java.lang.String, boolean):boolean */
    static /* synthetic */ void O000000o(OfflinePage offlinePage, String str, SimpleDraweeView simpleDraweeView) {
        String str2;
        PluginDeviceInfo O00000oO;
        if (simpleDraweeView.getHierarchy() == null) {
            simpleDraweeView.setHierarchy(new GenericDraweeHierarchyBuilder(simpleDraweeView.getResources()).setFadeDuration(200).setPlaceholderImage(simpleDraweeView.getResources().getDrawable(R.drawable.device_list_phone_no)).setActualImageScaleType(ScalingUtils.ScaleType.FIT_START).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_START).build());
        }
        Boolean bool = null;
        if (!CoreApi.O000000o().O00000o(str) || (O00000oO = CoreApi.O000000o().O00000oO(str)) == null) {
            str2 = null;
        } else {
            str2 = O00000oO.O0000o0();
        }
        if (str2 != null) {
            bool = Boolean.valueOf(iyo.O000000o(str2, "http", false));
        }
        if (ixe.O000000o(bool, Boolean.TRUE)) {
            simpleDraweeView.setImageURI(Uri.parse(str2));
            DraweeController controller = simpleDraweeView.getController();
            if (controller != null && (controller instanceof AbstractDraweeController)) {
                ((AbstractDraweeController) controller).addControllerListener(new O0000O0o(str2));
                return;
            }
            return;
        }
        int O000000o2 = fqs.O000000o(str);
        if (O000000o2 != 0) {
            simpleDraweeView.setImageURI(O000000o(O000000o2));
        } else {
            simpleDraweeView.setImageURI(O000000o((int) R.drawable.device_list_phone_no));
        }
    }
}
