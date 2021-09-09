package _m_j;

import _m_j.hpu;
import _m_j.hqa;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.common.widget.CustomPullDownRefreshListView;
import com.xiaomi.smarthome.scene.adapter.RecommendSceneAdapter;

public class hnh extends fvm {
    public static final String O00000o = "hnh";

    /* renamed from: O000000o  reason: collision with root package name */
    View f19075O000000o;
    RecommendSceneAdapter O00000Oo;
    CustomPullDownRefreshListView O00000o0;
    LinearLayout O00000oO;
    TextView O00000oo;
    private boolean O0000O0o = true;
    private boolean O0000OOo;
    private hpu.O000000o O0000Oo0 = new hpu.O000000o() {
        /* class _m_j.hnh.AnonymousClass4 */

        public final void O000000o(int i) {
            if (hnh.this.isValid()) {
                gsy.O00000Oo(hnh.O00000o, "onRefreshSuccess".concat(String.valueOf(i)));
                if (hnh.this.O00000o0 != null) {
                    if (i == 1) {
                        hnh.this.O00000o0.O00000Oo();
                    }
                    RecommendSceneAdapter recommendSceneAdapter = hnh.this.O00000Oo;
                    hqa hqa = hpu.O000000o().O00000Oo;
                    if (hqa != null) {
                        recommendSceneAdapter.O00000Oo = hqa;
                    } else {
                        recommendSceneAdapter.O00000Oo = new hqa();
                    }
                    if (!ftn.O00000Oo(CoreApi.O000000o().O0000ooO()) && hig.O00000oo() && recommendSceneAdapter.O00000Oo != null && recommendSceneAdapter.O00000Oo.O00000o0 != null && (recommendSceneAdapter.O00000Oo.O00000o0.size() <= 0 || !recommendSceneAdapter.O000000o(0))) {
                        hqa.O00000Oo o00000Oo = new hqa.O00000Oo();
                        o00000Oo.f517O000000o = "-1001";
                        o00000Oo.O00000Oo = recommendSceneAdapter.f11116O000000o.getString(R.string.recommend_nfc_trigger);
                        recommendSceneAdapter.O00000Oo.O00000o0.add(0, o00000Oo);
                    }
                    recommendSceneAdapter.notifyDataSetChanged();
                    if (hnh.this.O00000Oo.getCount() == 0) {
                        hnh.this.O00000oO.setVisibility(0);
                        hnh.this.O00000o0.setVisibility(8);
                        return;
                    }
                    hnh.this.O00000oO.setVisibility(8);
                    hnh.this.O00000o0.setVisibility(0);
                }
            }
        }

        public final void O000000o() {
            if (hnh.this.isValid()) {
                gsy.O00000Oo(hnh.O00000o, new StringBuilder("onRefreshFail1").toString());
                hnh.this.O00000o0.O00000Oo();
                if (hnh.this.O00000Oo != null && hnh.this.O00000Oo.getCount() == 0) {
                    hnh.this.O00000oO.setVisibility(0);
                }
            }
        }
    };

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f19075O000000o == null) {
            this.f19075O000000o = layoutInflater.inflate((int) R.layout.fragment_recommend_layout, (ViewGroup) null);
            this.O00000o0 = (CustomPullDownRefreshListView) this.f19075O000000o.findViewById(R.id.pull_listview);
            this.O00000oO = (LinearLayout) this.f19075O000000o.findViewById(R.id.common_white_empty_view);
            this.O00000oo = (TextView) this.f19075O000000o.findViewById(R.id.common_white_empty_text);
            this.O00000oo.setText((int) R.string.recommend_scene_no_data);
            this.O00000oO.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.hnh.AnonymousClass1 */

                public final void onClick(View view) {
                    if (hnh.this.O00000o0 != null) {
                        hnh.this.O00000o0.O000000o();
                    }
                }
            });
            this.O00000Oo = new RecommendSceneAdapter(getActivity());
            this.O00000o0.setAdapter((ListAdapter) this.O00000Oo);
            this.O00000o0.setOnScrollListener(new AbsListView.OnScrollListener() {
                /* class _m_j.hnh.AnonymousClass2 */

                public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                }

                public final void onScrollStateChanged(AbsListView absListView, int i) {
                    FragmentActivity validActivity;
                    View currentFocus;
                    if (1 == i && (validActivity = hnh.this.getValidActivity()) != null && (currentFocus = validActivity.getCurrentFocus()) != null) {
                        currentFocus.clearFocus();
                    }
                }
            });
            this.O00000o0.setRefreshListener(new CustomPullDownRefreshListView.O00000o0() {
                /* class _m_j.hnh.AnonymousClass3 */

                public final void startRefresh() {
                    gsy.O00000Oo(hnh.O00000o, "startRefresh");
                    hpu.O000000o().O0000OOo.sendEmptyMessage(1);
                    ggb.O0000o00();
                }
            });
            this.O00000o0.O000000o();
        }
        return this.f19075O000000o;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    public void onResume() {
        super.onResume();
        this.O0000OOo = false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        hpu O000000o2 = hpu.O000000o();
        hpu.O000000o o000000o = this.O0000Oo0;
        if (o000000o != null) {
            int i = 0;
            while (i < O000000o2.O00000oO.size()) {
                if (O000000o2.O00000oO.get(i) != o000000o) {
                    i++;
                } else {
                    return;
                }
            }
            O000000o2.O00000oO.add(o000000o);
        }
    }

    public void onPause() {
        super.onPause();
        this.O0000OOo = true;
    }

    public void onPageSelected() {
        super.onPageSelected();
    }

    public void onDestroy() {
        super.onDestroy();
        hpu O000000o2 = hpu.O000000o();
        hpu.O000000o o000000o = this.O0000Oo0;
        if (O000000o2.O00000oO.contains(o000000o)) {
            O000000o2.O00000oO.remove(o000000o);
        }
    }

    public void onDetach() {
        super.onDetach();
    }
}
