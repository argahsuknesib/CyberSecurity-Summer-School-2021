package _m_j;

import _m_j.hng;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.PluginRecommendSceneInfo;
import com.xiaomi.smarthome.library.common.widget.CustomPullDownRefreshListView;
import com.xiaomi.smarthome.scene.activity.PluginRecommendSceneActivity;
import com.xiaomi.smarthome.scene.pluginrecommend.CreateSceneFromRecommendActivity;
import com.xiaomi.smarthome.scene.pluginrecommend.LightActionStartActivity;

public final class hng extends fvm {
    private static final String O0000O0o = hnh.class.getSimpleName();

    /* renamed from: O000000o  reason: collision with root package name */
    View f19069O000000o;
    O000000o O00000Oo;
    LinearLayout O00000o;
    CustomPullDownRefreshListView O00000o0;
    TextView O00000oO;
    public String O00000oo;

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f19069O000000o == null) {
            this.f19069O000000o = layoutInflater.inflate((int) R.layout.fragment_recommend_layout, (ViewGroup) null);
            this.O00000o0 = (CustomPullDownRefreshListView) this.f19069O000000o.findViewById(R.id.pull_listview);
            this.O00000o = (LinearLayout) this.f19069O000000o.findViewById(R.id.common_white_empty_view);
            this.O00000oO = (TextView) this.f19069O000000o.findViewById(R.id.common_white_empty_text);
            this.O00000oO.setText((int) R.string.recommend_scene_no_data);
            this.O00000o.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.hng.AnonymousClass1 */

                public final void onClick(View view) {
                    if (hng.this.O00000o0 != null) {
                        hng.this.O00000o0.O000000o();
                    }
                }
            });
            this.O00000Oo = new O000000o(getActivity());
            this.O00000o0.setAdapter((ListAdapter) this.O00000Oo);
            this.O00000o0.setOnScrollListener(new AbsListView.OnScrollListener() {
                /* class _m_j.hng.AnonymousClass2 */

                public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                }

                public final void onScrollStateChanged(AbsListView absListView, int i) {
                    FragmentActivity validActivity;
                    View currentFocus;
                    if (1 == i && (validActivity = hng.this.getValidActivity()) != null && (currentFocus = validActivity.getCurrentFocus()) != null) {
                        currentFocus.clearFocus();
                    }
                }
            });
        }
        return this.f19069O000000o;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (getArguments() != null && getArguments().containsKey("device_id")) {
            this.O00000oo = getArguments().getString("device_id");
        }
        Device O000000o2 = fno.O000000o().O000000o(this.O00000oo);
        hxi.O00000oO.f958O000000o.O000000o("recommend_lockspeaker_automation", "model", O000000o2 != null ? O000000o2.model : "");
        this.O00000o0.setRefreshListener(new CustomPullDownRefreshListView.O00000o0() {
            /* class _m_j.$$Lambda$hng$tQWUW8suZ_3MSrpq8YrVfYin1e0 */

            public final void startRefresh() {
                hng.this.O000000o();
            }
        });
        this.O00000o0.O000000o();
    }

    public final void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o() {
        gsy.O00000Oo(O0000O0o, "startRefresh");
        hps.O000000o().O000000o(this.O00000oo, new fsm<PluginRecommendSceneInfo, fso>() {
            /* class _m_j.hng.AnonymousClass3 */

            public final /* synthetic */ void onSuccess(Object obj) {
                PluginRecommendSceneInfo pluginRecommendSceneInfo = (PluginRecommendSceneInfo) obj;
                if (!(pluginRecommendSceneInfo == null || pluginRecommendSceneInfo.mSceneItems == null || pluginRecommendSceneInfo.mSceneItems.size() <= 0)) {
                    O000000o o000000o = hng.this.O00000Oo;
                    if (pluginRecommendSceneInfo != null) {
                        o000000o.f19073O000000o = pluginRecommendSceneInfo;
                    } else {
                        o000000o.f19073O000000o = new PluginRecommendSceneInfo();
                    }
                    o000000o.notifyDataSetChanged();
                    hng.this.O00000Oo.notifyDataSetChanged();
                }
                hng.this.O00000o0.O00000Oo();
            }

            public final void onFailure(fso fso) {
                hng.this.O00000o0.O00000Oo();
            }
        });
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public final void onPageSelected() {
        super.onPageSelected();
    }

    public final void onDestroy() {
        super.onDestroy();
    }

    public final void onDetach() {
        super.onDetach();
    }

    public class O000000o extends BaseAdapter {

        /* renamed from: O000000o  reason: collision with root package name */
        PluginRecommendSceneInfo f19073O000000o = new PluginRecommendSceneInfo();
        private LayoutInflater O00000o;
        private Context O00000o0;

        public final long getItemId(int i) {
            return (long) i;
        }

        public O000000o(Context context) {
            this.O00000o0 = context;
            this.O00000o = LayoutInflater.from(context);
        }

        public final int getCount() {
            PluginRecommendSceneInfo pluginRecommendSceneInfo = this.f19073O000000o;
            if (pluginRecommendSceneInfo == null || pluginRecommendSceneInfo.mSceneItems == null) {
                return 0;
            }
            return this.f19073O000000o.mSceneItems.size();
        }

        public final Object getItem(int i) {
            return this.f19073O000000o.mSceneItems.get(i);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C0117O000000o o000000o;
            if (view == null) {
                view = this.O00000o.inflate((int) R.layout.plugin_recommend_scene_new_item, (ViewGroup) null);
                o000000o = new C0117O000000o(view);
                view.setTag(o000000o);
            } else {
                o000000o = (C0117O000000o) view.getTag();
            }
            PluginRecommendSceneInfo.RecommendSceneItem recommendSceneItem = this.f19073O000000o.mSceneItems.get(i);
            o000000o.f19074O000000o.setHierarchy(new GenericDraweeHierarchyBuilder(this.O00000o0.getResources()).setFadeDuration(200).setPlaceholderImage(this.O00000o0.getResources().getDrawable(R.drawable.recommend_scene_list_default_icon)).setRoundingParams(RoundingParams.fromCornersRadius(20.0f)).setActualImageScaleType(ScalingUtils.ScaleType.CENTER).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_START).build());
            if (!TextUtils.isEmpty(recommendSceneItem.cardImgUrl)) {
                o000000o.f19074O000000o.setImageURI(Uri.parse(recommendSceneItem.cardImgUrl));
            } else {
                o000000o.f19074O000000o.setImageResource(R.drawable.recommend_scene_list_default_icon);
            }
            if (!TextUtils.isEmpty(recommendSceneItem.intro)) {
                o000000o.O00000Oo.setText(recommendSceneItem.intro);
            } else {
                o000000o.O00000Oo.setText("");
            }
            if (!TextUtils.isEmpty(recommendSceneItem.cardDesc)) {
                o000000o.O00000o0.setText(recommendSceneItem.cardDesc);
            } else {
                o000000o.O00000o0.setText("");
            }
            o000000o.itemView.setOnClickListener(new View.OnClickListener(recommendSceneItem) {
                /* class _m_j.$$Lambda$hng$O000000o$IWUTdpbDECQLwutKJuB_skEEVL4 */
                private final /* synthetic */ PluginRecommendSceneInfo.RecommendSceneItem f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    hng.O000000o.this.O000000o(this.f$1, view);
                }
            });
            return view;
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
        public /* synthetic */ void O000000o(PluginRecommendSceneInfo.RecommendSceneItem recommendSceneItem, View view) {
            if (recommendSceneItem != null && !TextUtils.isEmpty(recommendSceneItem.sr_id)) {
                Device O000000o2 = fno.O000000o().O000000o(hng.this.O00000oo);
                if (O000000o2 != null) {
                    hxk hxk = hxi.O00000o;
                    String str = O000000o2.model;
                    String str2 = recommendSceneItem.sr_id;
                    hxk.f952O000000o.O000000o("rec_light_auto", "model", str, "sr_id", str2);
                }
                try {
                    if (Long.parseLong(recommendSceneItem.sr_id) / 1000 == 2) {
                        Intent intent = new Intent(this.O00000o0, CreateSceneFromRecommendActivity.class);
                        intent.putExtra("need_choose_detail", true);
                        intent.putExtra("sr_id", new Integer(recommendSceneItem.sr_id));
                        intent.putExtra("did", hng.this.O00000oo);
                        this.O00000o0.startActivity(intent);
                        return;
                    }
                } catch (Exception unused) {
                }
                String str3 = recommendSceneItem.sr_id;
                char c = 65535;
                switch (str3.hashCode()) {
                    case 1507423:
                        if (str3.equals("1000")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 1507424:
                        if (str3.equals("1001")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 1507425:
                        if (str3.equals("1002")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 1507426:
                        if (str3.equals("1003")) {
                            c = 3;
                            break;
                        }
                        break;
                }
                if (c == 0) {
                    hxk hxk2 = hxi.O00000o;
                    String str4 = fno.O000000o().O000000o(hng.this.O00000oo).model;
                    hxk2.f952O000000o.O000000o("recommend_lockspeaker_automation", "model", str4);
                    Intent intent2 = new Intent(this.O00000o0, PluginRecommendSceneActivity.class);
                    intent2.putExtra("sr_id", new Integer(recommendSceneItem.sr_id));
                    intent2.putExtra("did", hng.this.O00000oo);
                    this.O00000o0.startActivity(intent2);
                } else if (c == 1 || c == 2 || c == 3) {
                    Intent intent3 = new Intent(this.O00000o0, LightActionStartActivity.class);
                    intent3.putExtra("sr_id", new Integer(recommendSceneItem.sr_id));
                    intent3.putExtra("did", hng.this.O00000oo);
                    this.O00000o0.startActivity(intent3);
                }
            }
        }

        /* renamed from: _m_j.hng$O000000o$O000000o  reason: collision with other inner class name */
        class C0117O000000o extends RecyclerView.O000OOo0 {

            /* renamed from: O000000o  reason: collision with root package name */
            SimpleDraweeView f19074O000000o;
            TextView O00000Oo;
            TextView O00000o0;

            public C0117O000000o(View view) {
                super(view);
                this.f19074O000000o = (SimpleDraweeView) view.findViewById(R.id.recommend_sdv);
                this.O00000Oo = (TextView) view.findViewById(R.id.recommend_title);
                this.O00000o0 = (TextView) view.findViewById(R.id.recommend_desc);
            }
        }
    }
}
