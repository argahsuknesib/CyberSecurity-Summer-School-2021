package com.xiaomi.smarthome.listcamera.adapter;

import _m_j.axs;
import _m_j.axz;
import _m_j.aya;
import _m_j.cki;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.fno;
import _m_j.ggb;
import _m_j.gpc;
import _m_j.gtg;
import _m_j.gth;
import _m_j.gti;
import _m_j.gtj;
import _m_j.gtm;
import _m_j.hxi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.fastvideo.VideoView;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.library.common.widget.ExpandableItemIndicator;
import com.xiaomi.smarthome.listcamera.CameraHorizontalActivity;
import com.xiaomi.smarthome.listcamera.adapter.CameraLargeAdapter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class CameraLargeAdapter extends aya<O00000Oo, O000000o> {

    /* renamed from: O000000o  reason: collision with root package name */
    public List<O00000Oo> f9412O000000o;
    public int O00000Oo;
    private Context O00000o;
    public boolean O00000o0;
    private HashSet<String> O00000oO;
    private long O00000oo;
    private O00000Oo O0000O0o;
    private Queue<O00000o> O0000OOo;

    public enum ViewType {
        CHILD_OPERATION,
        CHILD_SETTING
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O000000o(View view) {
    }

    public final /* bridge */ /* synthetic */ void onBindChildViewHolder(RecyclerView.O000OOo0 o000OOo0, int i, int i2, int i3) {
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gth.O000000o(java.lang.String, boolean):_m_j.gth$O00000o0
     arg types: [java.lang.String, int]
     candidates:
      _m_j.gth.O000000o(int, java.io.OutputStream):void
      _m_j.gth.O000000o(android.content.Context, com.xiaomi.smarthome.device.Device):void
      _m_j.gth.O000000o(com.xiaomi.smarthome.device.Device, com.xiaomi.smarthome.fastvideo.VideoView):void
      _m_j.gth.O000000o(java.lang.String, boolean):_m_j.gth$O00000o0 */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01ce  */
    public final /* synthetic */ void onBindGroupViewHolder(RecyclerView.O000OOo0 o000OOo0, int i, int i2) {
        O00000Oo o00000Oo = (O00000Oo) o000OOo0;
        if (!this.O00000o0) {
            List<gti.O000000o> O00000o02 = gti.O000000o().O00000o0();
            if (O00000o02.size() > i) {
                Device O000000o2 = fno.O000000o().O000000o(O00000o02.get(i).f18248O000000o);
                if (O000000o2 == null || O000000o2.model.contains("mxiang.camera.mwc10") || O000000o2.model.contains("mxiang.camera.mwc11")) {
                    cki.O00000o("CameraLargeAdapter", "device == null");
                    return;
                }
                o00000Oo.O0000oo0.setTag(O000000o2);
                o00000Oo.O0000o0o.setOnClickListener(new View.OnClickListener(o00000Oo, O000000o2) {
                    /* class com.xiaomi.smarthome.listcamera.adapter.$$Lambda$CameraLargeAdapter$K4Re68FJnazZLBodIwtqhDlfPls */
                    private final /* synthetic */ CameraLargeAdapter.O00000Oo f$1;
                    private final /* synthetic */ Device f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void onClick(View view) {
                        CameraLargeAdapter.this.O00000oO(this.f$1, this.f$2, view);
                    }
                });
                o00000Oo.O00000o0.setVisibility(4);
                PluginPackageInfo O0000Oo = CoreApi.O000000o().O0000Oo(O000000o2.model);
                boolean z = true;
                boolean O00000o03 = O0000Oo != null ? O0000Oo.O00000o0() : true;
                if (!O00000o03) {
                    o00000Oo.O0000o00.setVisibility(8);
                    o00000Oo.O0000OOo.setVisibility(0);
                    o00000Oo.O0000OOo.setText((int) R.string.unsupport_camera_play);
                }
                if (O000000o2.isShared()) {
                    o00000Oo.f9417O000000o.setText((int) R.string.shared_device_room_name);
                } else {
                    Room O0000o00 = ggb.O00000Oo().O0000o00(O000000o2.did);
                    if (O0000o00 == null || TextUtils.isEmpty(O0000o00.getName())) {
                        o00000Oo.f9417O000000o.setText((int) R.string.room_default);
                    } else {
                        o00000Oo.f9417O000000o.setText(O0000o00.getName());
                    }
                }
                o00000Oo.O00000Oo.setText(O000000o2.name);
                o00000Oo.f9417O000000o.setOnClickListener(new View.OnClickListener(o00000Oo, O000000o2) {
                    /* class com.xiaomi.smarthome.listcamera.adapter.$$Lambda$CameraLargeAdapter$jYz8KQb4I9x7Sl2HHoooAsvLnD8 */
                    private final /* synthetic */ CameraLargeAdapter.O00000Oo f$1;
                    private final /* synthetic */ Device f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void onClick(View view) {
                        CameraLargeAdapter.this.O00000o(this.f$1, this.f$2, view);
                    }
                });
                if (O000000o2.isOnline) {
                    o00000Oo.O0000o0.setText((int) R.string.device_online);
                } else {
                    o00000Oo.O0000o0.setText((int) R.string.offline_device);
                }
                if (!O000000o2.isOnline) {
                    o00000Oo.O0000o00.setVisibility(8);
                    o00000Oo.O00000o0.setVisibility(4);
                    o00000Oo.O0000oO0.setVisibility(0);
                    o00000Oo.O00000oo.setVisibility(8);
                } else {
                    o00000Oo.O0000oO0.setVisibility(8);
                }
                gtg.O000000o();
                gth.O00000o0 O00000Oo2 = gth.O000000o().O00000Oo(O000000o2.did);
                if (O00000Oo2 == null || !O00000Oo2.O0000Oo0) {
                    if (gth.O000000o().O00000Oo(O000000o2.did) == null) {
                        gth.O000000o().O000000o(O000000o2.did, false);
                    }
                    o00000Oo.O0000OoO.setVisibility(0);
                    o00000Oo.O0000Oo0.setVisibility(0);
                    o00000Oo.O0000Oo.setVisibility(0);
                    if (O00000o03) {
                        o00000Oo.O0000OOo.setVisibility(8);
                    }
                    if (O00000Oo2 == null) {
                        O00000Oo2 = gth.O000000o().O00000Oo(O000000o2.did);
                    }
                    if (O00000Oo2 == null || !O00000Oo2.O0000Oo) {
                        o00000Oo.O0000o0.setVisibility(0);
                        o00000Oo.O0000Oo0.setImageResource(R.drawable.camera_icon_btn_play_2);
                        if (O000000o2.isOnline && O00000o03) {
                            o00000Oo.O0000o00.setVisibility(0);
                        }
                    } else {
                        o00000Oo.O0000Oo0.setImageResource(R.drawable.camera_icon_btn_stop_2);
                        o00000Oo.O0000o00.setVisibility(8);
                        o00000Oo.O0000o0.setVisibility(8);
                    }
                    if (O00000Oo2 == null || !O00000Oo2.O0000OOo) {
                        o00000Oo.O0000Oo.setImageResource(R.drawable.camera_icon_unmute);
                    } else {
                        o00000Oo.O0000Oo.setImageResource(R.drawable.camera_icon_mute);
                    }
                    if (!gtj.O000000o().f18250O000000o) {
                        gtj O000000o3 = gtj.O000000o();
                        if (O000000o3.O00000o && O000000o3.O00000oo) {
                            o00000Oo.O0000OoO.setEnabled(true);
                            o00000Oo.O0000Oo0.setEnabled(true);
                            o00000Oo.O0000Oo.setEnabled(true);
                            o00000Oo.O0000Ooo.setVisibility(8);
                            if (o00000Oo.O0000oOO) {
                                gth.O000000o().O000000o(O000000o2, o00000Oo.O00000oo, o00000Oo.O0000Ooo);
                                if (gth.O000000o().O00000Oo(O000000o2)) {
                                    if (o00000Oo.O00000oO == null) {
                                        O000000o(o00000Oo);
                                    }
                                    gth.O000000o().O000000o(O000000o2, o00000Oo.O00000oO);
                                    o00000Oo.O00000oo.setVisibility(8);
                                }
                            }
                        }
                    }
                    o00000Oo.O0000OoO.setEnabled(false);
                    o00000Oo.O0000Oo0.setEnabled(false);
                    o00000Oo.O0000Oo.setEnabled(false);
                    o00000Oo.O0000Ooo.setVisibility(8);
                    if (o00000Oo.O0000oOO) {
                    }
                } else {
                    o00000Oo.O0000OoO.setVisibility(8);
                    o00000Oo.O0000Oo0.setVisibility(8);
                    o00000Oo.O0000Oo.setVisibility(8);
                    o00000Oo.O0000Ooo.setVisibility(8);
                    o00000Oo.O0000oo0.setTag(null);
                    o00000Oo.O00000oo.setVisibility(0);
                    if (!O000000o2.isOnline) {
                        if (O00000o03) {
                            o00000Oo.O0000OOo.setVisibility(8);
                        }
                        o00000Oo.O00000oo.setScaleType(ImageView.ScaleType.CENTER);
                    } else {
                        PluginPackageInfo O0000Oo2 = CoreApi.O000000o().O0000Oo(O000000o2.model);
                        o00000Oo.O00000oo.setImageResource(0);
                        o00000Oo.O0000OOo.setVisibility(0);
                        if (O0000Oo2 != null) {
                            o00000Oo.O0000OOo.setText((int) R.string.unsupport_camera_play);
                        } else {
                            o00000Oo.O0000OOo.setText((int) R.string.undownload_camera_play);
                        }
                    }
                }
                o00000Oo.O0000OoO.setOnClickListener(new View.OnClickListener(O000000o2, o00000Oo) {
                    /* class com.xiaomi.smarthome.listcamera.adapter.$$Lambda$CameraLargeAdapter$lbg5FqBxl1axAv_Pp5noF1AxL6s */
                    private final /* synthetic */ Device f$1;
                    private final /* synthetic */ CameraLargeAdapter.O00000Oo f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void onClick(View view) {
                        CameraLargeAdapter.this.O00000Oo(this.f$1, this.f$2, view);
                    }
                });
                o00000Oo.O0000O0o.setOnClickListener(new View.OnClickListener(O000000o2) {
                    /* class com.xiaomi.smarthome.listcamera.adapter.$$Lambda$CameraLargeAdapter$7WOGnRZxkIhu5E9RMLg6hQ1BIQ */
                    private final /* synthetic */ Device f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        CameraLargeAdapter.O00000o0(CameraLargeAdapter.O00000Oo.this, this.f$1, view);
                    }
                });
                o00000Oo.O00000o0.setOnClickListener($$Lambda$CameraLargeAdapter$spj33BsvBdv4kAnQ64OjkUyMdI.INSTANCE);
                o00000Oo.O0000Oo.setOnClickListener(new View.OnClickListener(O000000o2, o00000Oo) {
                    /* class com.xiaomi.smarthome.listcamera.adapter.$$Lambda$CameraLargeAdapter$PUIwGNziwj5KedPNY_Q3o65FeLA */
                    private final /* synthetic */ Device f$1;
                    private final /* synthetic */ CameraLargeAdapter.O00000Oo f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void onClick(View view) {
                        CameraLargeAdapter.this.O000000o(this.f$1, this.f$2, view);
                    }
                });
                o00000Oo.O0000Oo0.setOnClickListener(new View.OnClickListener(o00000Oo, O000000o2) {
                    /* class com.xiaomi.smarthome.listcamera.adapter.$$Lambda$CameraLargeAdapter$MfsmvktcwANOfcK5oaVjXSQHdGw */
                    private final /* synthetic */ CameraLargeAdapter.O00000Oo f$1;
                    private final /* synthetic */ Device f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void onClick(View view) {
                        CameraLargeAdapter.this.O00000Oo(this.f$1, this.f$2, view);
                    }
                });
                o00000Oo.O0000o00.setOnClickListener(new View.OnClickListener(o00000Oo, O000000o2) {
                    /* class com.xiaomi.smarthome.listcamera.adapter.$$Lambda$CameraLargeAdapter$lW71KWIOqmlee2iTZyk_yC5rdX8 */
                    private final /* synthetic */ CameraLargeAdapter.O00000Oo f$1;
                    private final /* synthetic */ Device f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void onClick(View view) {
                        CameraLargeAdapter.this.O000000o(this.f$1, this.f$2, view);
                    }
                });
                if (o00000Oo.O0000o0O != null) {
                    int expandStateFlags = o00000Oo.getExpandStateFlags();
                    if ((Integer.MIN_VALUE & expandStateFlags) != 0) {
                        if ((expandStateFlags & 4) == 0) {
                            z = false;
                        }
                        o00000Oo.O0000o0O.setExpandedState$25decb5(z);
                    }
                }
            }
        }
    }

    public final /* synthetic */ boolean onCheckCanExpandOrCollapseGroup(RecyclerView.O000OOo0 o000OOo0, int i, int i2, int i3, boolean z) {
        O00000Oo o00000Oo = (O00000Oo) o000OOo0;
        if (System.currentTimeMillis() - this.O00000oo < 500 || o00000Oo.O0000o.getVisibility() != 0) {
            return false;
        }
        this.O00000oo = System.currentTimeMillis();
        View view = o00000Oo.O0000o;
        View view2 = o00000Oo.O0000oo0;
        if (view == null || view.getVisibility() == 8) {
            return false;
        }
        view2.getGlobalVisibleRect(new Rect());
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect.contains(i2, i3);
    }

    public final int getGroupCount() {
        return gti.O000000o().O00000o0.size();
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0071 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0072  */
    public final int getChildCount(int i) {
        Device O00000o02;
        boolean z;
        List<gti.O000000o> O00000o03 = gti.O000000o().O00000o0();
        if (i >= O00000o03.size() || (O00000o02 = fno.O000000o().O00000o0(O00000o03.get(i).f18248O000000o)) == null) {
            return 0;
        }
        Map<String, Long> map = gtg.O000000o().O0000Oo;
        if (O00000o02 != null && map.containsKey(O00000o02.model)) {
            PluginPackageInfo O0000Oo = CoreApi.O000000o().O0000Oo(O00000o02.model);
            Long l = map.get(O00000o02.model);
            if (l != null && (O0000Oo == null ? l.longValue() == 0 : !(((long) O0000Oo.O00000oO()) < l.longValue() && O0000Oo.O00000Oo() > 100))) {
                z = true;
                if (z) {
                    return 0;
                }
                return O00000o03.get(i).O00000oO.size() + 1;
            }
        }
        z = false;
        if (z) {
        }
    }

    public final int getChildItemViewType(int i, int i2) {
        if (i2 >= gti.O000000o().O00000o0().get(i).O00000oO.size()) {
            return ViewType.CHILD_SETTING.ordinal();
        }
        return ViewType.CHILD_OPERATION.ordinal();
    }

    public final long getGroupId(int i) {
        List<gti.O000000o> O00000o02 = gti.O000000o().O00000o0();
        if (i < 0 || i >= O00000o02.size()) {
            return 0;
        }
        return (long) O00000o02.get(i).hashCode();
    }

    public final long getChildId(int i, int i2) {
        int hashCode;
        List<gti.O000000o> O00000o02 = gti.O000000o().O00000o0();
        if (i2 < O00000o02.get(i).O00000oO.size()) {
            hashCode = O00000o02.get(i).O00000oO.get(i2).hashCode();
        } else {
            hashCode = ViewType.CHILD_OPERATION.hashCode();
        }
        return (long) hashCode;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000oO(O00000Oo o00000Oo, Device device, View view) {
        O00000oO(o00000Oo, device);
        gth.O000000o().O000000o(this.O00000o, device, 1, new Intent());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o(O00000Oo o00000Oo, Device device, View view) {
        O00000oO(o00000Oo, device);
        gth.O000000o().O000000o(this.O00000o, device, 1, new Intent());
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(Device device, O00000Oo o00000Oo, View view) {
        Intent intent = new Intent(this.O00000o, CameraHorizontalActivity.class);
        intent.putExtra("did", device.did);
        intent.putExtra("isAutoPlay", true);
        gpc.O000000o(o00000Oo.O00000o0, 4);
        this.O00000o.startActivity(intent);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O00000o0(O00000Oo o00000Oo, Device device, View view) {
        if (o00000Oo.O0000o.getVisibility() == 0) {
            gpc.O000000o(o00000Oo.O00000o0, 4);
            gpc.O000000o(o00000Oo.O0000o, 4);
            return;
        }
        gth.O00000o0 O00000Oo2 = gth.O000000o().O00000Oo(device.did);
        if (O00000Oo2 != null && O00000Oo2.O0000Oo) {
            gpc.O000000o(o00000Oo.O00000o0);
            o00000Oo.O0000oOo.removeCallbacksAndMessages(null);
            o00000Oo.O0000oOo.postDelayed(new Runnable(device) {
                /* class com.xiaomi.smarthome.listcamera.adapter.$$Lambda$CameraLargeAdapter$gmI272XaHdV3rRhg7WTuKXGXPw */
                private final /* synthetic */ Device f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    CameraLargeAdapter.O00000oo(CameraLargeAdapter.O00000Oo.this, this.f$1);
                }
            }, 3000);
        }
        gpc.O000000o(o00000Oo.O0000o);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O00000oo(O00000Oo o00000Oo, Device device) {
        gth.O00000o0 O00000Oo2;
        if (o00000Oo.O0000oo0.getTag() == device && (O00000Oo2 = gth.O000000o().O00000Oo(device.did)) != null && O00000Oo2.O0000Oo) {
            gpc.O000000o(o00000Oo.O00000o0, 4);
            gpc.O000000o(o00000Oo.O0000o, 4);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(Device device, O00000Oo o00000Oo, View view) {
        gth.O000000o().O00000o(device);
        if (gth.O000000o().O000000o(device)) {
            gth O000000o2 = gth.O000000o();
            Context context = this.O00000o;
            ProgressBar progressBar = o00000Oo.O0000Ooo;
            gth.O00000o0 O00000Oo2 = O000000o2.O00000Oo(device.did);
            if (O00000Oo2 != null) {
                O000000o2.O000000o(context, device, O00000Oo2.O0000OOo);
                if (!O00000Oo2.O0000Oo) {
                    O00000Oo2.O0000Oo = true;
                    progressBar.setVisibility(0);
                    progressBar.startAnimation(AnimationUtils.loadAnimation(context, R.anim.rotate_loading));
                    O00000Oo2.O00000o = progressBar;
                }
            }
            o00000Oo.O00000oo.setVisibility(8);
        }
        if (gth.O000000o().O00000o0(device)) {
            o00000Oo.O0000Oo.setImageResource(R.drawable.camera_icon_mute);
            return;
        }
        o00000Oo.O0000Oo.setImageResource(R.drawable.camera_icon_unmute);
        O00000o0(o00000Oo, device);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(O00000Oo o00000Oo, Device device, View view) {
        O000000o(o00000Oo, device);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(O00000Oo o00000Oo, Device device, View view) {
        O000000o(o00000Oo, device);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
     arg types: [java.lang.String, int]
     candidates:
      _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
      _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt */
    private void O000000o(final O00000Oo o00000Oo, final Device device) {
        gth.O00000o0 O00000Oo2;
        if (gth.O000000o().O000000o(device)) {
            O00000oO(o00000Oo, device);
            gpc.O000000o(o00000Oo.O00000o0, 4);
            if (o00000Oo.O0000o.getVisibility() != 0) {
                gpc.O000000o(o00000Oo.O0000o, 0);
            }
        } else if (device == null || device.isSetPinCode == 0 || this.O00000oO.contains(device.did)) {
            if (this.O0000OOo.size() >= 3) {
                O00000o poll = this.O0000OOo.poll();
                if (poll.f9418O000000o.O0000oo0.getTag() == poll.O00000Oo && (O00000Oo2 = gth.O000000o().O00000Oo(poll.O00000Oo.did)) != null && O00000Oo2.O0000Oo) {
                    poll.f9418O000000o.O0000Oo0.performClick();
                }
            }
            O00000Oo(o00000Oo, device);
            gpc.O000000o(o00000Oo.O00000o0);
            gpc.O000000o(o00000Oo.O0000o);
            o00000Oo.O0000oOo.removeCallbacksAndMessages(null);
            o00000Oo.O0000oOo.postDelayed(new Runnable() {
                /* class com.xiaomi.smarthome.listcamera.adapter.CameraLargeAdapter.AnonymousClass1 */

                public final void run() {
                    gth.O00000o0 O00000Oo2;
                    if (o00000Oo.O0000oo0.getTag() == device && (O00000Oo2 = gth.O000000o().O00000Oo(device.did)) != null && O00000Oo2.O0000Oo) {
                        gpc.O000000o(o00000Oo.O00000o0, 4);
                        gpc.O000000o(o00000Oo.O0000o, 4);
                    }
                }
            }, 3000);
        } else {
            fbt fbt = new fbt(this.O00000o, "DevicePinVerifyEnterActivity");
            fbt.O000000o("extra_device_did", device.did);
            fbt.O000000o("verfy_pincode_first", true);
            fbt.O000000o(100);
            fbs.O000000o(fbt);
            this.O0000O0o = o00000Oo;
            return;
        }
        if (gth.O000000o().O000000o(device)) {
            o00000Oo.O0000Oo0.setImageResource(R.drawable.camera_icon_btn_stop_2);
            o00000Oo.O0000o00.setVisibility(8);
            o00000Oo.O0000o0.setVisibility(8);
            return;
        }
        o00000Oo.O0000Oo0.setImageResource(R.drawable.camera_icon_btn_play_2);
        o00000Oo.O0000o00.setVisibility(0);
        o00000Oo.O0000o0.setVisibility(0);
    }

    private void O000000o(final O00000Oo o00000Oo) {
        final Device device = (Device) o00000Oo.O0000oo0.getTag();
        if (device != null) {
            gth.O000000o().O00000Oo(device.did);
            o00000Oo.O00000oO = new VideoView(this.O00000o);
            int measuredWidth = o00000Oo.O00000oo.getMeasuredWidth();
            int i = (measuredWidth * 9) / 16;
            VideoView videoView = o00000Oo.O00000oO;
            videoView.O00000Oo.O000000o();
            videoView.O00000oO = false;
            ViewGroup.LayoutParams layoutParams = videoView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(measuredWidth, i);
            }
            layoutParams.width = measuredWidth;
            layoutParams.height = i;
            videoView.setLayoutParams(layoutParams);
            o00000Oo.O00000oO.setVideoViewListener(new VideoView.O000000o() {
                /* class com.xiaomi.smarthome.listcamera.adapter.CameraLargeAdapter.AnonymousClass2 */

                public final void onVideoViewClick() {
                    if (o00000Oo.O00000o0.getVisibility() == 0) {
                        gpc.O000000o(o00000Oo.O00000o0, 4);
                        gpc.O000000o(o00000Oo.O0000o, 4);
                    } else if (o00000Oo.O00000o0.getVisibility() != 0) {
                        gth.O00000o0 O00000Oo2 = gth.O000000o().O00000Oo(device.did);
                        if (O00000Oo2 != null && O00000Oo2.O0000Oo) {
                            gpc.O000000o(o00000Oo.O00000o0);
                            o00000Oo.O0000oOo.removeCallbacksAndMessages(null);
                            o00000Oo.O0000oOo.postDelayed(new Runnable() {
                                /* class com.xiaomi.smarthome.listcamera.adapter.CameraLargeAdapter.AnonymousClass2.AnonymousClass1 */

                                public final void run() {
                                    gth.O00000o0 O00000Oo;
                                    if (o00000Oo.O0000oo0.getTag() == device && (O00000Oo = gth.O000000o().O00000Oo(device.did)) != null && O00000Oo.O0000Oo) {
                                        gpc.O000000o(o00000Oo.O00000o0, 4);
                                        gpc.O000000o(o00000Oo.O0000o, 4);
                                    }
                                }
                            }, 3000);
                        }
                        gpc.O000000o(o00000Oo.O0000o);
                    }
                }
            });
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            layoutParams2.gravity = 17;
            o00000Oo.O00000o.addView(o00000Oo.O00000oO, layoutParams2);
        }
    }

    private void O00000Oo(O00000Oo o00000Oo, Device device) {
        if (o00000Oo.O00000oO == null) {
            O000000o(o00000Oo);
        }
        gth.O000000o().O000000o(device, o00000Oo.O00000oO);
        gth.O000000o().O000000o(this.O00000o, device, o00000Oo.O0000Ooo);
        this.O0000OOo.offer(new O00000o(o00000Oo, device));
        hxi.O00000o.O0000o0o(device.isSetPinCode == 0 ? 1 : 2);
        if (!gth.O000000o().O00000o0(device)) {
            O00000o0(o00000Oo, device);
        }
    }

    private static void O00000Oo(O00000Oo o00000Oo) {
        o00000Oo.O00000o.removeAllViews();
        o00000Oo.O00000oO = null;
    }

    private void O00000o0(O00000Oo o00000Oo, Device device) {
        gth.O00000o0 O00000Oo2;
        for (O00000o next : this.O0000OOo) {
            if (next.f9418O000000o == o00000Oo && next.O00000Oo == device) {
                cki.O00000o("CameraLargeAdapter", "muteOthers continue" + device.name);
            } else if (next.f9418O000000o.O0000oo0.getTag() == next.O00000Oo && (O00000Oo2 = gth.O000000o().O00000Oo(next.O00000Oo.did)) != null && !O00000Oo2.O0000OOo) {
                next.f9418O000000o.O0000Oo.performClick();
                cki.O00000o("CameraLargeAdapter", "muteOthers hited" + next.O00000Oo.name);
            }
        }
    }

    private void O00000o(O00000Oo o00000Oo, Device device) {
        Iterator<O00000o> it = this.O0000OOo.iterator();
        while (it.hasNext()) {
            O00000o next = it.next();
            if (next.f9418O000000o == o00000Oo && next.O00000Oo == device) {
                it.remove();
                cki.O00000o("CameraLargeAdapter", "removeItem hited");
            }
        }
        cki.O00000o("CameraLargeAdapter", "removeItem playintQueue.size=" + this.O0000OOo.size());
    }

    private void O00000oO(O00000Oo o00000Oo, Device device) {
        gth.O000000o().O00000Oo(device, o00000Oo.O00000oO);
        gth.O000000o().O000000o(this.O00000o, device);
        O00000Oo(o00000Oo);
        O00000o(o00000Oo, device);
    }

    public final void onViewAttachedToWindow(RecyclerView.O000OOo0 o000OOo0) {
        super.onViewAttachedToWindow(o000OOo0);
        if (o000OOo0 instanceof O00000Oo) {
            O00000Oo o00000Oo = (O00000Oo) o000OOo0;
            Device device = (Device) o00000Oo.O0000oo0.getTag();
            boolean z = true;
            o00000Oo.O0000oOO = true;
            if (device != null) {
                gth.O000000o().O000000o(device, o00000Oo.O00000oo, o00000Oo.O0000Ooo);
                if (this.O00000Oo == 0) {
                    if (gth.O000000o().O00000Oo(device)) {
                        O00000Oo(o00000Oo, device);
                        o00000Oo.O00000oo.setVisibility(8);
                    } else if (gth.O000000o().O000000o(device)) {
                        O00000Oo(o00000Oo, device);
                        o00000Oo.O0000Ooo.setVisibility(0);
                    } else {
                        o00000Oo.O0000Ooo.setVisibility(8);
                    }
                } else if (gth.O000000o().O000000o(device)) {
                    Iterator<O00000Oo> it = this.f9412O000000o.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().equals(o00000Oo)) {
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (!z) {
                        this.f9412O000000o.add(o00000Oo);
                    }
                } else {
                    o00000Oo.O0000Ooo.setVisibility(8);
                }
            }
        }
    }

    public final void onViewDetachedFromWindow(RecyclerView.O000OOo0 o000OOo0) {
        if (o000OOo0 instanceof O00000Oo) {
            O00000Oo o00000Oo = (O00000Oo) o000OOo0;
            Device device = (Device) o00000Oo.O0000oo0.getTag();
            o00000Oo.O0000oOO = false;
            if (!(device == null || o00000Oo == null || o00000Oo.O0000Oo0 == null || (!gth.O000000o().O000000o(device) && !gth.O000000o().O00000Oo(device)))) {
                o00000Oo.O0000Oo0.performClick();
            }
        }
        super.onViewDetachedFromWindow(o000OOo0);
    }

    public static abstract class O00000o0 extends axz implements axs {

        /* renamed from: O000000o  reason: collision with root package name */
        private int f9419O000000o;
        public View O0000oo0;

        public O00000o0(View view) {
            super(view);
            this.O0000oo0 = view;
        }

        public int getExpandStateFlags() {
            return this.f9419O000000o;
        }

        public void setExpandStateFlags(int i) {
            this.f9419O000000o = i;
        }

        public View getSwipeableContainerView() {
            return this.O0000oo0;
        }
    }

    public static class O000000o extends O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        ViewType f9416O000000o;

        public O000000o(View view, ViewType viewType) {
            super(view);
            this.f9416O000000o = viewType;
        }
    }

    public static class O0000O0o extends O000000o {
        public LinearLayout O00000Oo;

        public O0000O0o(View view) {
            super(view, ViewType.CHILD_SETTING);
            this.O00000Oo = (LinearLayout) view.findViewById(R.id.setting_device);
        }
    }

    public static class O00000Oo extends O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public TextView f9417O000000o;
        public TextView O00000Oo;
        public FrameLayout O00000o;
        public View O00000o0;
        public VideoView O00000oO;
        public ImageView O00000oo;
        public ImageView O0000O0o;
        public TextView O0000OOo;
        public ImageView O0000Oo;
        public ImageView O0000Oo0;
        public ImageView O0000OoO;
        public ProgressBar O0000Ooo;
        public View O0000o;
        public TextView O0000o0;
        public ImageView O0000o00;
        public ExpandableItemIndicator O0000o0O;
        public View O0000o0o;
        public ImageView O0000oO;
        public View O0000oO0;
        public boolean O0000oOO = false;
        public Handler O0000oOo = new Handler(Looper.getMainLooper());

        public O00000Oo(View view) {
            super(view);
            if (view instanceof ViewGroup) {
                this.f9417O000000o = (TextView) view.findViewById(R.id.title);
                this.O00000Oo = (TextView) view.findViewById(R.id.device_name);
                this.O00000o0 = view.findViewById(R.id.btn_large_view);
                this.O00000o = (FrameLayout) view.findViewById(R.id.video_view_container);
                this.O00000oo = (ImageView) view.findViewById(R.id.video_view_cover);
                this.O0000O0o = (ImageView) view.findViewById(R.id.video_view_cover_corner);
                this.O0000OOo = (TextView) view.findViewById(R.id.video_unsupport_view);
                this.O0000Oo0 = (ImageView) view.findViewById(R.id.pause_button);
                this.O0000Oo = (ImageView) view.findViewById(R.id.mute_button);
                this.O0000o00 = (ImageView) view.findViewById(R.id.ivPlayCenter);
                this.O0000o0 = (TextView) view.findViewById(R.id.tvStatus);
                this.O0000OoO = (ImageView) view.findViewById(R.id.full_screen_button);
                this.O0000Ooo = (ProgressBar) view.findViewById(R.id.camera_loading);
                this.O0000o0o = view.findViewById(R.id.cloud_storage_container_large);
                this.O0000o = view.findViewById(R.id.control_indicator_large);
                this.O0000oO0 = view.findViewById(R.id.fl_Offline);
                this.O0000oO = (ImageView) view.findViewById(R.id.fl_Offline_img);
            }
        }
    }

    class O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        O00000Oo f9418O000000o;
        Device O00000Oo;

        public O00000o(O00000Oo o00000Oo, Device device) {
            this.f9418O000000o = o00000Oo;
            this.O00000Oo = device;
        }
    }

    public final /* synthetic */ RecyclerView.O000OOo0 onCreateChildViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(this.O00000o);
        if (i == ViewType.CHILD_OPERATION.ordinal()) {
            return new gtm(from.inflate((int) R.layout.device_control_child_view, (ViewGroup) null));
        }
        return new O0000O0o(from.inflate((int) R.layout.camera_device_control_adjust, (ViewGroup) null));
    }

    public final /* synthetic */ RecyclerView.O000OOo0 onCreateGroupViewHolder(ViewGroup viewGroup, int i) {
        return new O00000Oo(LayoutInflater.from(this.O00000o).inflate((int) R.layout.camera_large_view_group_layout, (ViewGroup) null));
    }
}
