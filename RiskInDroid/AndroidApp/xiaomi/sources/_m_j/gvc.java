package _m_j;

import _m_j.gug;
import _m_j.guh;
import _m_j.guj;
import _m_j.guk;
import _m_j.gur;
import _m_j.guv;
import _m_j.gux;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.family.api.MessageApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.messagecenter.ui.MessageCenterActivity;
import com.xiaomi.smarthome.messagecenter.ui.MessageCenterDeviceListActivityNew;
import com.xiaomi.smarthome.miio.page.MessageCenterListActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public final class gvc extends RecyclerView.O000000o<RecyclerView.O000OOo0> {

    /* renamed from: O000000o  reason: collision with root package name */
    public final WeakReference<Activity> f18330O000000o;
    XQProgressDialog O00000Oo;
    public SparseBooleanArray O00000o = new SparseBooleanArray();
    public boolean O00000o0 = false;
    public List<gul> O00000oO = new ArrayList();
    private List<O000000o> O00000oo = new ArrayList();

    public gvc(Activity activity) {
        this.f18330O000000o = new WeakReference<>(activity);
    }

    public final void O000000o(List<gul> list) {
        this.O00000oo = O00000Oo(list);
        notifyDataSetChanged();
    }

    private static List<O000000o> O00000Oo(List<gul> list) {
        gur.O000000o o000000o;
        guk.O000000o o000000o2;
        guv.O000000o o000000o3;
        if (list == null) {
            list = new ArrayList<>();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        guv.O000000o o000000o4 = null;
        guk.O000000o o000000o5 = null;
        gur.O000000o o000000o6 = null;
        for (int i = 0; i < list.size(); i++) {
            gul gul = list.get(i);
            if (gul != null) {
                if (gul instanceof guv.O000000o) {
                    if (o000000o4 == null) {
                        o000000o3 = (guv.O000000o) gul;
                    } else if (o000000o4.O00000oo.receiveTime < gul.O000000o()) {
                        o000000o3 = (guv.O000000o) gul;
                    }
                    o000000o4 = o000000o3;
                } else if (gul instanceof guk.O000000o) {
                    if (o000000o5 == null) {
                        o000000o2 = (guk.O000000o) gul;
                    } else if (o000000o5.O00000oo.receiveTime < gul.O000000o()) {
                        o000000o2 = (guk.O000000o) gul;
                    }
                    o000000o5 = o000000o2;
                } else if (gul instanceof gur.O000000o) {
                    if (o000000o6 == null) {
                        o000000o = (gur.O000000o) gul;
                    } else if (o000000o6.O00000oo.receiveTime < gul.O000000o()) {
                        o000000o = (gur.O000000o) gul;
                    }
                    o000000o6 = o000000o;
                } else if (gul instanceof guh.O000000o) {
                    guh.O000000o o000000o7 = (guh.O000000o) gul;
                    if (fno.O000000o().O000000o(o000000o7.O00000Oo) == null) {
                        Home O00000o2 = ggb.O00000Oo().O00000o(String.valueOf(o000000o7.O00000o0));
                        if (O00000o2 != null) {
                            if (O00000o2.isOwner()) {
                            }
                        }
                    }
                    if (CoreApi.O000000o().O00000oO(o000000o7.f18285O000000o) != null) {
                        O0000O0o o0000O0o = new O0000O0o();
                        o0000O0o.O00000o0 = o000000o7;
                        arrayList2.add(o0000O0o);
                    }
                } else if (gul instanceof gux.O000000o) {
                    O000O0o0 o000O0o0 = new O000O0o0();
                    o000O0o0.O00000o0 = gul;
                    arrayList3.add(o000O0o0);
                } else if (gul instanceof gug.O000000o) {
                    O00000o0 o00000o0 = new O00000o0();
                    o00000o0.O00000o0 = gul;
                    arrayList3.add(o00000o0);
                } else if (gul instanceof guj.O000000o) {
                    O0000o00 o0000o00 = new O0000o00();
                    o0000o00.O00000o0 = gul;
                    arrayList3.add(o0000o00);
                }
            }
        }
        O0000Oo0 o0000Oo0 = new O0000Oo0();
        o0000Oo0.O00000o0 = o000000o4;
        arrayList.add(o0000Oo0);
        O0000o o0000o = new O0000o();
        o0000o.O00000o0 = o000000o5;
        arrayList.add(o0000o);
        if (o000000o6 != null) {
            O000O00o o000O00o = new O000O00o();
            o000O00o.O00000o0 = o000000o6;
            arrayList.add(o000O00o);
        }
        arrayList.addAll(arrayList2);
        arrayList.addAll(arrayList3);
        return arrayList;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new O0000OOo(LayoutInflater.from(ServiceApplication.getAppContext()).inflate((int) R.layout.message_center_group_item, viewGroup, false));
        }
        if (i == 3) {
            return new O00000o(LayoutInflater.from(ServiceApplication.getAppContext()).inflate((int) R.layout.message_item, viewGroup, false));
        }
        if (i == 4) {
            return new O00000Oo(LayoutInflater.from(ServiceApplication.getAppContext()).inflate((int) R.layout.message_item, viewGroup, false));
        }
        if (i == 5) {
            return new O000O0OO(LayoutInflater.from(ServiceApplication.getAppContext()).inflate((int) R.layout.message_item, viewGroup, false));
        }
        if (i == 6) {
            return new O0000o0(LayoutInflater.from(ServiceApplication.getAppContext()).inflate((int) R.layout.message_center_group_item, viewGroup, false));
        }
        if (i == 7) {
            return new O00oOooO(LayoutInflater.from(ServiceApplication.getAppContext()).inflate((int) R.layout.message_center_group_item, viewGroup, false));
        }
        if (i == 11) {
            return new O0000Oo(LayoutInflater.from(ServiceApplication.getAppContext()).inflate((int) R.layout.message_item, viewGroup, false));
        }
        return null;
    }

    public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        gur.O000000o o000000o;
        guk.O000000o o000000o2;
        guv.O000000o o000000o3;
        RecyclerView.O000OOo0 o000OOo02 = o000OOo0;
        int i2 = i;
        if (o000OOo02 instanceof O0000OOo) {
            O0000OOo o0000OOo = (O0000OOo) o000OOo02;
            ((ImageView) o0000OOo.itemView.findViewById(R.id.device_icon)).setImageResource(R.drawable.msg_center_group_icon_device_share);
            ((TextView) o0000OOo.itemView.findViewById(R.id.device_item)).setText((int) R.string.miio_setting_share);
            TextView textView = (TextView) o0000OOo.itemView.findViewById(R.id.device_item_info);
            O0000Oo0 o0000Oo0 = (O0000Oo0) O000000o(i2);
            if (o0000Oo0 == null || o0000Oo0.O00000o0 == null) {
                textView.setText((int) R.string.miio_no_message);
            } else {
                o0000Oo0.O00000o0.O00000oO(textView);
            }
            o0000OOo.itemView.findViewById(R.id.right_fl).setVisibility(8);
            o0000OOo.itemView.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.gvc.AnonymousClass1 */

                public final void onClick(View view) {
                    Intent intent = new Intent(ServiceApplication.getAppContext(), MessageCenterListActivity.class);
                    intent.putExtra("message_type", 1);
                    intent.putExtra("message_title", ServiceApplication.getAppContext().getString(R.string.miio_setting_share));
                    intent.addFlags(268435456);
                    ServiceApplication.getAppContext().startActivity(intent);
                    hxi.O00000o.f952O000000o.O000000o("message_device_share", new Object[0]);
                }
            });
            O000000o(0, o0000OOo.itemView.findViewById(R.id.number_icon));
            if (!(o0000Oo0 == null || o0000Oo0.O00000o0 == null || (o000000o3 = o0000Oo0.O00000o0) == null || !o000000o3.O00000o())) {
                O000000o(1, o0000OOo.itemView.findViewById(R.id.number_icon));
            }
            o0000OOo.itemView.findViewById(R.id.list_space).setVisibility(8);
        } else if (o000OOo02 instanceof O0000o0) {
            O0000o0 o0000o0 = (O0000o0) o000OOo02;
            ((ImageView) o0000o0.itemView.findViewById(R.id.device_icon)).setImageResource(R.drawable.msg_center_group_icon_home_share);
            ((TextView) o0000o0.itemView.findViewById(R.id.device_item)).setText((int) R.string.home_share);
            TextView textView2 = (TextView) o0000o0.itemView.findViewById(R.id.device_item_info);
            O0000o o0000o = (O0000o) O000000o(i2);
            if (o0000o == null || o0000o.O00000o0 == null) {
                textView2.setText((int) R.string.miio_no_message);
            } else {
                o0000o.O00000o0.O00000oO(textView2);
            }
            o0000o0.itemView.findViewById(R.id.right_fl).setVisibility(8);
            o0000o0.itemView.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.gvc.AnonymousClass2 */

                public final void onClick(View view) {
                    Intent intent = new Intent(ServiceApplication.getAppContext(), MessageCenterListActivity.class);
                    intent.putExtra("message_type", 8);
                    intent.putExtra("message_title", ServiceApplication.getAppContext().getString(R.string.home_share));
                    intent.addFlags(268435456);
                    ServiceApplication.getAppContext().startActivity(intent);
                    hxi.O00000o.f952O000000o.O000000o("message_device_hshare", new Object[0]);
                }
            });
            O000000o(0, o0000o0.itemView.findViewById(R.id.number_icon));
            if (!(o0000o == null || o0000o.O00000o0 == null || (o000000o2 = o0000o.O00000o0) == null || !o000000o2.O00000o())) {
                O000000o(1, o0000o0.itemView.findViewById(R.id.number_icon));
            }
            try {
                if (O000000o(i2 + 1) instanceof O000O00o) {
                    o0000o0.itemView.findViewById(R.id.list_space).setVisibility(8);
                } else {
                    o0000o0.itemView.findViewById(R.id.list_space).setVisibility(0);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (o000OOo02 instanceof O00000o) {
            O00000o o00000o = (O00000o) o000OOo02;
            O000000o O000000o2 = O000000o(i2);
            if (O000000o2 != null && (O000000o2 instanceof O0000O0o)) {
                O0000O0o o0000O0o = (O0000O0o) O000000o2;
                if (o0000O0o.O00000o0 != null) {
                    guh.O000000o o000000o4 = o0000O0o.O00000o0;
                    if (o000000o4 instanceof guh.O000000o) {
                        guh.O000000o o000000o5 = o000000o4;
                        String str = o000000o5.f18285O000000o;
                        if (CoreApi.O000000o().O00000oO(str) != null) {
                            DeviceFactory.O00000Oo(str, o00000o.O00000Oo);
                            CharSequence O000000o3 = O00000o.O000000o(o000000o5, o00000o.O00000oO);
                            o000000o5.O000000o(o00000o.O00000oo);
                            o00000o.O00000oo.setText(String.format("%s | %s", gou.O000000o(o000000o5.O00000oo.receiveTime * 1000), o00000o.O00000oo.getText()));
                            o00000o.O00000o.setVisibility(8);
                            o00000o.itemView.findViewById(R.id.arrow).setVisibility(0);
                            String O000000o4 = fqt.O000000o(fno.O000000o().O000000o(o000000o5.O00000Oo));
                            if (TextUtils.isEmpty(O000000o4)) {
                                o00000o.O0000O0o.setVisibility(8);
                            } else {
                                o00000o.O0000O0o.setVisibility(0);
                                o00000o.O0000O0o.setText(O000000o4);
                            }
                            o00000o.itemView.setOnClickListener(new View.OnClickListener(o000000o5, O000000o3, i2) {
                                /* class _m_j.gvc.O00000o.AnonymousClass1 */

                                /* renamed from: O000000o  reason: collision with root package name */
                                final /* synthetic */ guh.O000000o f18343O000000o;
                                final /* synthetic */ CharSequence O00000Oo;
                                final /* synthetic */ int O00000o0;

                                {
                                    this.f18343O000000o = r2;
                                    this.O00000Oo = r3;
                                    this.O00000o0 = r4;
                                }

                                public final void onClick(View view) {
                                    Intent intent = new Intent(ServiceApplication.getAppContext(), MessageCenterDeviceListActivityNew.class);
                                    intent.putExtra("device_id", this.f18343O000000o.O00000Oo);
                                    intent.putExtra("title_name", this.O00000Oo);
                                    intent.putExtra("device_model", this.f18343O000000o.f18285O000000o);
                                    intent.addFlags(268435456);
                                    ServiceApplication.getAppContext().startActivity(intent);
                                    hxi.O00000o.f952O000000o.O000000o("message_device_list", "serial", Integer.valueOf(this.O00000o0 - 2));
                                }
                            });
                            O000000o(0, o00000o.itemView.findViewById(R.id.number_icon));
                            if (o000000o4 != null && o000000o4.O00000o()) {
                                O000000o(1, o00000o.itemView.findViewById(R.id.number_icon));
                            }
                        }
                    }
                }
            }
        } else if (o000OOo02 instanceof O00000Oo) {
            O00000Oo o00000Oo = (O00000Oo) o000OOo02;
            O00000o0 o00000o0 = (O00000o0) O000000o(i2);
            gul gul = o00000o0.O00000o0;
            Context appContext = ServiceApplication.getAppContext();
            gul.O000000o(o00000Oo.O00000oO);
            gul.O00000Oo(o00000Oo.O00000oo);
            gul.O000000o(o00000Oo.O00000Oo);
            if (gul.O00000o()) {
                o00000Oo.O00000oO.setTextColor(appContext.getResources().getColor(R.color.mj_color_black_80_transparent));
                o00000Oo.O00000oo.setTextColor(appContext.getResources().getColor(R.color.mj_color_black_50_transparent));
            } else {
                o00000Oo.O00000oO.setTextColor(appContext.getResources().getColor(R.color.mj_color_gray_lighter));
                o00000Oo.O00000oo.setTextColor(appContext.getResources().getColor(R.color.mj_color_gray_lighter));
            }
            o00000Oo.itemView.findViewById(R.id.arrow).setVisibility(8);
            o00000Oo.O00000o.setOnClickListener(new View.OnClickListener(i2, gul) {
                /* class _m_j.gvc.O00000Oo.AnonymousClass1 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ int f18336O000000o;
                final /* synthetic */ gul O00000Oo;

                {
                    this.f18336O000000o = r2;
                    this.O00000Oo = r3;
                }

                public final void onClick(View view) {
                    boolean z = gvc.this.O00000o.get(this.f18336O000000o);
                    if (gvc.this.f18330O000000o.get() != null && (gvc.this.f18330O000000o.get() instanceof MessageCenterActivity)) {
                        ((MessageCenterActivity) gvc.this.f18330O000000o.get()).setSelected(this.O00000Oo.O00000o0(), !z);
                    }
                    if (!z) {
                        gvc.this.O00000o.put(this.f18336O000000o, true);
                    } else {
                        gvc.this.O00000o.delete(this.f18336O000000o);
                    }
                }
            });
            if (gvc.this.O00000o0) {
                o00000Oo.f18335O000000o.setVisibility(0);
                o00000Oo.O00000o.setVisibility(0);
                o00000Oo.O00000o0.setVisibility(8);
                o00000Oo.itemView.setOnClickListener(new View.OnClickListener() {
                    /* class _m_j.gvc.O00000Oo.AnonymousClass2 */

                    public final void onClick(View view) {
                        O00000Oo.this.O00000o.performClick();
                    }
                });
                if (gvc.this.O00000o.get(i2)) {
                    o00000Oo.O00000o.setChecked(true);
                } else {
                    o00000Oo.O00000o.setChecked(false);
                }
            } else {
                o00000Oo.f18335O000000o.setVisibility(0);
                o00000Oo.O00000o.setVisibility(8);
                o00000Oo.O00000o0.setVisibility(0);
                if (!gul.O00000Oo()) {
                    o00000Oo.O00000o0.setTextColor(ServiceApplication.getAppContext().getResources().getColor(R.color.mj_color_gray_lighter));
                    float f = ServiceApplication.getAppContext().getResources().getDisplayMetrics().density;
                    int i3 = (int) (f * 15.0f);
                    int i4 = (int) (f * 7.0f);
                    o00000Oo.O00000o0.setPadding(i3, i4, i3, i4);
                    o00000Oo.O00000o0.setBackgroundResource(0);
                    gul.O00000o0(o00000Oo.O00000o0);
                    if (o00000Oo.O00000o0.getVisibility() == 8) {
                        o00000Oo.f18335O000000o.setVisibility(8);
                    }
                } else {
                    o00000Oo.O00000o0.setTextColor(ServiceApplication.getAppContext().getResources().getColorStateList(R.color.selector_common_text));
                    o00000Oo.O00000o0.setBackgroundResource(R.drawable.selector_common_btn);
                    float f2 = ServiceApplication.getAppContext().getResources().getDisplayMetrics().density;
                    int i5 = (int) (f2 * 15.0f);
                    int i6 = (int) (f2 * 7.0f);
                    o00000Oo.O00000o0.setPadding(i5, i6, i5, i6);
                    o00000Oo.O00000o0.setText((int) R.string.smarthome_share_accept);
                    o00000Oo.O00000o0.setOnClickListener(new View.OnClickListener(gul) {
                        /* class _m_j.gvc.O00000Oo.AnonymousClass3 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ gul f18338O000000o;

                        {
                            this.f18338O000000o = r2;
                        }

                        public final void onClick(View view) {
                            gvc.this.O00000Oo = new XQProgressDialog(gvc.this.f18330O000000o.get());
                            gvc.this.O00000Oo.setCancelable(false);
                            gvc.this.O00000Oo.setMessage(ServiceApplication.getAppContext().getResources().getString(R.string.loading_share_info));
                            gvc.this.O00000Oo.show();
                            gvc.this.O00000Oo.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                /* class _m_j.gvc.O00000Oo.AnonymousClass3.AnonymousClass1 */

                                public final void onDismiss(DialogInterface dialogInterface) {
                                }
                            });
                            this.f18338O000000o.O000000o(gvc.this.O00000Oo);
                        }
                    });
                }
                o00000Oo.itemView.setOnClickListener(new View.OnClickListener(i2) {
                    /* class _m_j.gvc.O00000Oo.AnonymousClass4 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ int f18340O000000o;

                    {
                        this.f18340O000000o = r2;
                    }

                    public final void onClick(View view) {
                        List<gul> list = gvc.this.O00000oO;
                        if (this.f18340O000000o < list.size()) {
                            list.get(this.f18340O000000o).O000000o(gvc.this.f18330O000000o.get());
                        }
                    }
                });
                o00000Oo.itemView.setOnLongClickListener(new View.OnLongClickListener(o00000o0, i2) {
                    /* class _m_j.gvc.O00000Oo.AnonymousClass5 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ O00000o0 f18341O000000o;
                    final /* synthetic */ int O00000Oo;

                    {
                        this.f18341O000000o = r2;
                        this.O00000Oo = r3;
                    }

                    public final boolean onLongClick(View view) {
                        if (this.f18341O000000o.O00000Oo && !gvc.this.O00000o0) {
                            if (!gvc.this.O00000o.get(this.O00000Oo)) {
                                O00000Oo.this.O00000o.performClick();
                            }
                            if (gvc.this.f18330O000000o.get() != null && (gvc.this.f18330O000000o.get() instanceof MessageCenterActivity)) {
                                ((MessageCenterActivity) gvc.this.f18330O000000o.get()).showDeleteBars();
                            }
                            gvc.this.O00000o0 = true;
                            gvc.this.notifyDataSetChanged();
                        }
                        return true;
                    }
                });
            }
        } else if (o000OOo02 instanceof O000O0OO) {
            O000O0OO o000o0oo = (O000O0OO) o000OOo02;
            O000O0o0 o000O0o0 = (O000O0o0) O000000o(i2);
            gul gul2 = o000O0o0.O00000o0;
            Context appContext2 = ServiceApplication.getAppContext();
            gul2.O000000o(o000o0oo.O00000oO);
            gul2.O00000Oo(o000o0oo.O00000oo);
            gul2.O000000o(o000o0oo.O00000Oo);
            if (gul2.O00000o()) {
                o000o0oo.O00000oO.setTextColor(appContext2.getResources().getColor(R.color.mj_color_black_80_transparent));
                o000o0oo.O00000oo.setTextColor(appContext2.getResources().getColor(R.color.mj_color_black_50_transparent));
            } else {
                o000o0oo.O00000oO.setTextColor(appContext2.getResources().getColor(R.color.mj_color_gray_lighter));
                o000o0oo.O00000oo.setTextColor(appContext2.getResources().getColor(R.color.mj_color_gray_lighter));
            }
            o000o0oo.itemView.findViewById(R.id.arrow).setVisibility(8);
            o000o0oo.O00000o.setOnClickListener(new View.OnClickListener(i2, gul2) {
                /* class _m_j.gvc.O000O0OO.AnonymousClass1 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ int f18349O000000o;
                final /* synthetic */ gul O00000Oo;

                {
                    this.f18349O000000o = r2;
                    this.O00000Oo = r3;
                }

                public final void onClick(View view) {
                    boolean z = gvc.this.O00000o.get(this.f18349O000000o);
                    if (gvc.this.f18330O000000o.get() != null && (gvc.this.f18330O000000o.get() instanceof MessageCenterActivity)) {
                        ((MessageCenterActivity) gvc.this.f18330O000000o.get()).setSelected(this.O00000Oo.O00000o0(), !z);
                    }
                    if (!z) {
                        gvc.this.O00000o.put(this.f18349O000000o, true);
                    } else {
                        gvc.this.O00000o.delete(this.f18349O000000o);
                    }
                }
            });
            if (gvc.this.O00000o0) {
                o000o0oo.f18348O000000o.setVisibility(0);
                o000o0oo.O00000o.setVisibility(0);
                o000o0oo.O00000o0.setVisibility(8);
                o000o0oo.itemView.setOnClickListener(new View.OnClickListener() {
                    /* class _m_j.gvc.O000O0OO.AnonymousClass2 */

                    public final void onClick(View view) {
                        O000O0OO.this.O00000o.performClick();
                    }
                });
                if (gvc.this.O00000o.get(i2)) {
                    o000o0oo.O00000o.setChecked(true);
                } else {
                    o000o0oo.O00000o.setChecked(false);
                }
            } else {
                o000o0oo.f18348O000000o.setVisibility(0);
                o000o0oo.O00000o.setVisibility(8);
                o000o0oo.O00000o0.setVisibility(0);
                if (!gul2.O00000Oo()) {
                    o000o0oo.O00000o0.setTextColor(ServiceApplication.getAppContext().getResources().getColor(R.color.mj_color_gray_lighter));
                    float f3 = ServiceApplication.getAppContext().getResources().getDisplayMetrics().density;
                    int i7 = (int) (f3 * 15.0f);
                    int i8 = (int) (f3 * 7.0f);
                    o000o0oo.O00000o0.setPadding(i7, i8, i7, i8);
                    o000o0oo.O00000o0.setBackgroundResource(0);
                    gul2.O00000o0(o000o0oo.O00000o0);
                    if (o000o0oo.O00000o0.getVisibility() == 8) {
                        o000o0oo.f18348O000000o.setVisibility(8);
                    }
                } else {
                    o000o0oo.O00000o0.setTextColor(ServiceApplication.getAppContext().getResources().getColorStateList(R.color.selector_common_text));
                    o000o0oo.O00000o0.setBackgroundResource(R.drawable.selector_common_btn);
                    float f4 = ServiceApplication.getAppContext().getResources().getDisplayMetrics().density;
                    int i9 = (int) (f4 * 15.0f);
                    int i10 = (int) (f4 * 7.0f);
                    o000o0oo.O00000o0.setPadding(i9, i10, i9, i10);
                    o000o0oo.O00000o0.setText((int) R.string.smarthome_share_accept);
                    o000o0oo.O00000o0.setOnClickListener(new View.OnClickListener(gul2) {
                        /* class _m_j.gvc.O000O0OO.AnonymousClass3 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ gul f18351O000000o;

                        {
                            this.f18351O000000o = r2;
                        }

                        public final void onClick(View view) {
                            gvc.this.O00000Oo = new XQProgressDialog(gvc.this.f18330O000000o.get());
                            gvc.this.O00000Oo.setCancelable(false);
                            gvc.this.O00000Oo.setMessage(ServiceApplication.getAppContext().getResources().getString(R.string.loading_share_info));
                            gvc.this.O00000Oo.show();
                            gvc.this.O00000Oo.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                /* class _m_j.gvc.O000O0OO.AnonymousClass3.AnonymousClass1 */

                                public final void onDismiss(DialogInterface dialogInterface) {
                                }
                            });
                            this.f18351O000000o.O000000o(gvc.this.O00000Oo);
                        }
                    });
                }
                o000o0oo.itemView.setOnClickListener(new View.OnClickListener(i2) {
                    /* class _m_j.gvc.O000O0OO.AnonymousClass4 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ int f18353O000000o;

                    {
                        this.f18353O000000o = r2;
                    }

                    public final void onClick(View view) {
                        List<gul> list = gvc.this.O00000oO;
                        if (this.f18353O000000o < list.size()) {
                            list.get(this.f18353O000000o).O000000o(gvc.this.f18330O000000o.get());
                        }
                    }
                });
                o000o0oo.itemView.setOnLongClickListener(new View.OnLongClickListener(o000O0o0, i2) {
                    /* class _m_j.gvc.O000O0OO.AnonymousClass5 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ O000O0o0 f18354O000000o;
                    final /* synthetic */ int O00000Oo;

                    {
                        this.f18354O000000o = r2;
                        this.O00000Oo = r3;
                    }

                    public final boolean onLongClick(View view) {
                        if (this.f18354O000000o.O00000Oo && !gvc.this.O00000o0) {
                            if (!gvc.this.O00000o.get(this.O00000Oo)) {
                                O000O0OO.this.O00000o.performClick();
                            }
                            if (gvc.this.f18330O000000o.get() != null && (gvc.this.f18330O000000o.get() instanceof MessageCenterActivity)) {
                                ((MessageCenterActivity) gvc.this.f18330O000000o.get()).showDeleteBars();
                            }
                            gvc.this.O00000o0 = true;
                            gvc.this.notifyDataSetChanged();
                        }
                        return true;
                    }
                });
            }
        } else if (o000OOo02 instanceof O00oOooO) {
            O00oOooO o00oOooO = (O00oOooO) o000OOo02;
            final ImageView imageView = (ImageView) o00oOooO.itemView.findViewById(R.id.device_icon);
            imageView.setImageResource(R.drawable.msg_center_group_icon_provider_debug);
            ((TextView) o00oOooO.itemView.findViewById(R.id.device_item)).setText((int) R.string.home_provider_whole_house_intelligence);
            TextView textView3 = (TextView) o00oOooO.itemView.findViewById(R.id.device_item_info);
            final O000O00o o000O00o = (O000O00o) O000000o(i2);
            if (o000O00o == null || o000O00o.O00000o0 == null) {
                textView3.setText((int) R.string.miio_no_message);
            } else {
                o000O00o.O00000o0.O00000oO(textView3);
            }
            o00oOooO.itemView.findViewById(R.id.right_fl).setVisibility(8);
            o00oOooO.itemView.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.gvc.AnonymousClass3 */

                public final void onClick(View view) {
                    O000O00o o000O00o = o000O00o;
                    if (!(o000O00o == null || o000O00o.O00000o0 == null)) {
                        if (TextUtils.isEmpty(o000O00o.O00000o0.O00000o0)) {
                            hte.O000000o(ServiceApplication.getAppContext(), "h5 url empty");
                            return;
                        } else {
                            MessageApi.instance.getMessageListOfType(ServiceApplication.getAppContext(), Integer.parseInt("10"), 0, 100, null);
                            hjp.O000000o(o000O00o.O00000o0.O00000o0, imageView.getResources().getString(R.string.home_provider_debug), new boolean[0]);
                        }
                    }
                    hxi.O00000o.f952O000000o.O000000o("message_service_application", new Object[0]);
                }
            });
            O000000o(0, o00oOooO.itemView.findViewById(R.id.number_icon));
            if (!(o000O00o == null || o000O00o.O00000o0 == null || (o000000o = o000O00o.O00000o0) == null || !o000000o.O00000o())) {
                O000000o(1, o00oOooO.itemView.findViewById(R.id.number_icon));
            }
            o00oOooO.itemView.findViewById(R.id.list_space).setVisibility(0);
        } else if (o000OOo02 instanceof O0000Oo) {
            O0000Oo o0000Oo = (O0000Oo) o000OOo02;
            O000000o O000000o5 = O000000o(i2);
            if (O000000o5 != null && (O000000o5 instanceof O0000o00)) {
                O0000o00 o0000o00 = (O0000o00) O000000o5;
                if (o0000o00.O00000o0 != null) {
                    gul gul3 = o0000o00.O00000o0;
                    if (gul3 instanceof guj.O000000o) {
                        guj.O000000o o000000o6 = (guj.O000000o) gul3;
                        o0000Oo.O00000oO.setText(DeviceFactory.O0000OoO(o000000o6.f18296O000000o));
                        o000000o6.O00000Oo(o0000Oo.O0000O0o);
                        o000000o6.O00000o(o0000Oo.O00000oo);
                        o000000o6.O000000o(o0000Oo.O00000Oo);
                        O000000o(0, o0000Oo.itemView.findViewById(R.id.number_icon));
                        if (gul3 != null && gul3.O00000o()) {
                            O000000o(1, o0000Oo.itemView.findViewById(R.id.number_icon));
                        }
                        o0000Oo.itemView.setOnClickListener(new View.OnClickListener(gul3, o000000o6) {
                            /* class _m_j.gvc.O0000Oo.AnonymousClass1 */

                            /* renamed from: O000000o  reason: collision with root package name */
                            final /* synthetic */ gul f18346O000000o;
                            final /* synthetic */ guj.O000000o O00000Oo;

                            {
                                this.f18346O000000o = r2;
                                this.O00000Oo = r3;
                            }

                            public final void onClick(View view) {
                                Activity activity = gvc.this.f18330O000000o.get();
                                guq.O000000o(this.f18346O000000o.O00000o0());
                                if (activity != null) {
                                    Intent intent = new Intent(activity, MessageCenterDeviceListActivityNew.class);
                                    intent.putExtra("device_id", this.O00000Oo.O00000Oo);
                                    intent.putExtra("device_model", this.O00000Oo.f18296O000000o);
                                    intent.putExtra("message_type", "11");
                                    activity.startActivity(intent);
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    private static void O000000o(int i, View view) {
        if (view != null) {
            if (i == 0) {
                try {
                    view.setVisibility(4);
                } catch (Throwable unused) {
                }
            } else {
                TextView textView = (TextView) view;
                textView.setVisibility(0);
                if (i <= 99) {
                    textView.setText("");
                    return;
                }
                textView.setText("");
                textView.setBackgroundResource(R.drawable.red_point_num);
            }
        }
    }

    private O000000o O000000o(int i) {
        List<O000000o> list = this.O00000oo;
        if (i < 0 || i >= list.size()) {
            return null;
        }
        return list.get(i);
    }

    public final int getItemCount() {
        return this.O00000oo.size();
    }

    public final int getItemViewType(int i) {
        List<O000000o> list = this.O00000oo;
        if (i < 0 || i >= list.size()) {
            return 0;
        }
        return list.get(i).f18334O000000o;
    }

    class O0000OOo extends RecyclerView.O000OOo0 {
        public O0000OOo(View view) {
            super(view);
        }
    }

    class O0000o0 extends RecyclerView.O000OOo0 {
        public O0000o0(View view) {
            super(view);
        }
    }

    class O00oOooO extends RecyclerView.O000OOo0 {
        public O00oOooO(View view) {
            super(view);
        }
    }

    class O0000Oo extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        View f18345O000000o;
        SimpleDraweeView O00000Oo;
        CheckBox O00000o;
        TextView O00000o0;
        TextView O00000oO;
        TextView O00000oo;
        TextView O0000O0o;
        View O0000OOo;

        public O0000Oo(View view) {
            super(view);
            this.O00000Oo = (SimpleDraweeView) view.findViewById(R.id.device_icon);
            this.O00000Oo.setHierarchy(new GenericDraweeHierarchyBuilder(this.O00000Oo.getResources()).setFadeDuration(200).setActualImageScaleType(ScalingUtils.ScaleType.CENTER_INSIDE).setPlaceholderImageScaleType(ScalingUtils.ScaleType.CENTER_INSIDE).build());
            this.O00000o0 = (TextView) view.findViewById(R.id.right_tv);
            this.O00000o = (CheckBox) view.findViewById(R.id.ratio_btn);
            this.O00000oO = (TextView) view.findViewById(R.id.device_item);
            this.O00000oo = (TextView) view.findViewById(R.id.device_item_info);
            this.O0000O0o = (TextView) view.findViewById(R.id.device_home_room_info);
            this.f18345O000000o = view.findViewById(R.id.right_fl);
            this.O0000OOo = view.findViewById(R.id.new_message_tag);
            this.O00000o.setVisibility(8);
        }
    }

    class O00000o extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        View f18342O000000o;
        SimpleDraweeView O00000Oo;
        CheckBox O00000o;
        TextView O00000o0;
        TextView O00000oO;
        TextView O00000oo;
        TextView O0000O0o;

        public O00000o(View view) {
            super(view);
            this.O00000Oo = (SimpleDraweeView) view.findViewById(R.id.device_icon);
            this.O00000Oo.setHierarchy(new GenericDraweeHierarchyBuilder(this.O00000Oo.getResources()).setFadeDuration(200).setActualImageScaleType(ScalingUtils.ScaleType.CENTER_INSIDE).setPlaceholderImageScaleType(ScalingUtils.ScaleType.CENTER_INSIDE).build());
            this.O00000o0 = (TextView) view.findViewById(R.id.right_tv);
            this.O00000o = (CheckBox) view.findViewById(R.id.ratio_btn);
            this.O00000oO = (TextView) view.findViewById(R.id.device_item);
            this.O00000oo = (TextView) view.findViewById(R.id.device_item_info);
            this.O0000O0o = (TextView) view.findViewById(R.id.device_home_room_info);
            this.f18342O000000o = view.findViewById(R.id.right_fl);
        }

        static CharSequence O000000o(guh.O000000o o000000o, TextView textView) {
            PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(o000000o.f18285O000000o);
            if (O00000oO2 == null) {
                return null;
            }
            Device O000000o2 = fno.O000000o().O000000o(o000000o.O00000Oo);
            if (O000000o2 == null || TextUtils.isEmpty(O000000o2.getName())) {
                boolean z = true;
                if (o000000o.O00000oo != null && !TextUtils.isEmpty(o000000o.O00000oo.params)) {
                    try {
                        JSONObject jSONObject = new JSONObject(o000000o.O00000oo.params);
                        if (!jSONObject.isNull("body")) {
                            JSONObject optJSONObject = jSONObject.optJSONObject("body");
                            if (!optJSONObject.isNull("name")) {
                                String optString = optJSONObject.optString("name");
                                if (!TextUtils.isEmpty(optString)) {
                                    textView.setText(optString);
                                    z = false;
                                }
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
                if (z) {
                    textView.setText(O00000oO2.O0000Oo0());
                }
                return textView.getText();
            }
            textView.setText(O000000o2.getName());
            return O000000o2.getName();
        }
    }

    class O00000Oo extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        View f18335O000000o;
        SimpleDraweeView O00000Oo;
        CheckBox O00000o;
        TextView O00000o0;
        TextView O00000oO;
        TextView O00000oo;

        public O00000Oo(View view) {
            super(view);
            this.O00000Oo = (SimpleDraweeView) view.findViewById(R.id.device_icon);
            this.O00000Oo.setHierarchy(new GenericDraweeHierarchyBuilder(this.O00000Oo.getResources()).setFadeDuration(200).setActualImageScaleType(ScalingUtils.ScaleType.CENTER_INSIDE).setPlaceholderImageScaleType(ScalingUtils.ScaleType.CENTER_INSIDE).build());
            this.O00000o0 = (TextView) view.findViewById(R.id.right_tv);
            this.O00000o = (CheckBox) view.findViewById(R.id.ratio_btn);
            this.O00000oO = (TextView) view.findViewById(R.id.device_item);
            this.O00000oo = (TextView) view.findViewById(R.id.device_item_info);
            this.f18335O000000o = view.findViewById(R.id.right_fl);
        }
    }

    class O000O0OO extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        View f18348O000000o;
        SimpleDraweeView O00000Oo;
        CheckBox O00000o;
        TextView O00000o0;
        TextView O00000oO;
        TextView O00000oo;

        public O000O0OO(View view) {
            super(view);
            this.O00000Oo = (SimpleDraweeView) view.findViewById(R.id.device_icon);
            this.O00000Oo.setHierarchy(new GenericDraweeHierarchyBuilder(this.O00000Oo.getResources()).setFadeDuration(200).setActualImageScaleType(ScalingUtils.ScaleType.CENTER_INSIDE).setPlaceholderImageScaleType(ScalingUtils.ScaleType.CENTER_INSIDE).build());
            this.O00000o0 = (TextView) view.findViewById(R.id.right_tv);
            this.O00000o = (CheckBox) view.findViewById(R.id.ratio_btn);
            this.O00000oO = (TextView) view.findViewById(R.id.device_item);
            this.O00000oo = (TextView) view.findViewById(R.id.device_item_info);
            this.f18348O000000o = view.findViewById(R.id.right_fl);
        }
    }

    public final List<gul> O000000o() {
        List<O000000o> list = this.O00000oo;
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            O000000o o000000o = list.get(i);
            if (o000000o != null && o000000o.O00000Oo && (o000000o instanceof O00000o0)) {
                arrayList.add(((O00000o0) o000000o).O00000o0);
            }
        }
        return arrayList;
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        protected final int f18334O000000o;
        protected boolean O00000Oo;

        /* synthetic */ O000000o(int i, byte b) {
            this(i);
        }

        private O000000o(int i) {
            this.O00000Oo = false;
            this.f18334O000000o = i;
        }
    }

    static class O0000Oo0 extends O000000o {
        public guv.O000000o O00000o0;

        /* synthetic */ O0000Oo0() {
            this(1);
        }

        private O0000Oo0(int i) {
            super(1, (byte) 0);
        }
    }

    static class O0000O0o extends O000000o {
        public guh.O000000o O00000o0;

        /* synthetic */ O0000O0o() {
            this(3);
        }

        private O0000O0o(int i) {
            super(3, (byte) 0);
        }
    }

    static class O0000o extends O000000o {
        public guk.O000000o O00000o0;

        /* synthetic */ O0000o() {
            this(6);
        }

        private O0000o(int i) {
            super(6, (byte) 0);
        }
    }

    static class O000O00o extends O000000o {
        public gur.O000000o O00000o0;

        /* synthetic */ O000O00o() {
            this(7);
        }

        private O000O00o(int i) {
            super(7, (byte) 0);
        }
    }

    static class O00000o0 extends O000000o {
        public gul O00000o0;

        /* synthetic */ O00000o0() {
            this(4);
        }

        private O00000o0(int i) {
            super(4, (byte) 0);
            this.O00000Oo = true;
        }
    }

    static class O000O0o0 extends O000000o {
        public gul O00000o0;

        /* synthetic */ O000O0o0() {
            this(5);
        }

        private O000O0o0(int i) {
            super(5, (byte) 0);
            this.O00000Oo = true;
        }
    }

    static class O0000o00 extends O000000o {
        public gul O00000o0;

        /* synthetic */ O0000o00() {
            this(11);
        }

        private O0000o00(int i) {
            super(11, (byte) 0);
            this.O00000Oo = true;
        }
    }
}
