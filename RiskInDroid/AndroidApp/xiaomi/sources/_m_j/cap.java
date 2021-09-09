package _m_j;

import _m_j.cbm;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.android.volley.Request;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mi.global.shop.activity.OrderListAcitvity;
import com.mi.global.shop.activity.WebActivity;
import com.mi.global.shop.adapter.home.HomeListAdapter;
import com.mi.global.shop.loader.BaseResult;
import com.mi.global.shop.newmodel.BaseResult;
import com.mi.global.shop.newmodel.home.NewHomeBlockData;
import com.mi.global.shop.newmodel.home.NewHomeBlockInfo;
import com.mi.global.shop.newmodel.home.NewHomeBlockInfoItem;
import com.mi.global.shop.newmodel.home.NewHomeBlockResult;
import com.mi.global.shop.newmodel.notice.NewNoticeData;
import com.mi.global.shop.newmodel.notice.NewNoticeResult;
import com.mi.global.shop.widget.BaseListView;
import com.mi.global.shop.widget.CustomTextView;
import com.mi.global.shop.widget.EmptyLoadingViewPlus;
import com.mi.global.shop.widget.pulltorefresh.SimplePullToRefreshLayout;
import com.mi.util.Device;
import com.xiaomi.smarthome.R;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class cap extends can implements View.OnClickListener, SimplePullToRefreshLayout.O00000o {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f13528O000000o = "cap";
    public SimplePullToRefreshLayout O00000Oo;
    HomeListAdapter O00000o;
    public EmptyLoadingViewPlus O00000o0;
    public NewNoticeData O00000oO;
    SimpleDraweeView O00000oo;
    NewHomeBlockInfoItem O0000O0o;
    private BaseListView O0000OOo;
    private LinearLayout O0000Oo;
    private View O0000Oo0;
    private ImageView O0000OoO;
    private CustomTextView O0000Ooo;
    private boolean O0000o0 = true;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate((int) R.layout.shop_home_fragment, viewGroup, false);
        this.O0000Oo0 = getActivity().findViewById(R.id.title_mi_logo);
        this.O0000Oo0.setVisibility(0);
        this.O00000Oo = (SimplePullToRefreshLayout) inflate.findViewById(R.id.home_fragment_ptr);
        this.O00000Oo.setOnRefreshListener(new SimplePullToRefreshLayout.O00000o() {
            /* class _m_j.cap.AnonymousClass1 */

            public final void onRefresh() {
                cap.this.onRefresh();
                cap.this.O00000Oo.O000000o();
            }
        });
        this.O00000oo = (SimpleDraweeView) inflate.findViewById(R.id.activity_entrance);
        this.O00000oo.setOnClickListener(this);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.O00000oo.getLayoutParams();
        layoutParams.leftMargin = (Device.f5099O000000o * 4) / 5;
        layoutParams.topMargin = (Device.O00000Oo * 2) / 5;
        this.O00000oo.setLayoutParams(layoutParams);
        this.O00000o0 = (EmptyLoadingViewPlus) inflate.findViewById(R.id.loading);
        this.O00000o0.setPullToRefreshLayout(this.O00000Oo);
        this.O0000Oo = (LinearLayout) inflate.findViewById(R.id.noticeboard);
        this.O0000Ooo = (CustomTextView) inflate.findViewById(R.id.notice_text);
        this.O0000OoO = (ImageView) inflate.findViewById(R.id.notice_close);
        this.O0000OoO.setOnClickListener(this);
        this.O0000OOo = (BaseListView) inflate.findViewById(16908298);
        this.O00000o = new HomeListAdapter(getActivity());
        this.O0000OOo.setAdapter((ListAdapter) this.O00000o);
        NewNoticeData newNoticeData = this.O00000oO;
        if (newNoticeData != null) {
            O000000o(newNoticeData);
        }
        return inflate;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        O000000o();
    }

    public void onResume() {
        Request request;
        super.onResume();
        if (this.O0000o0) {
            this.O0000o0 = false;
        } else if (O00000Oo()) {
            String O000O0oO = cav.O000O0oO();
            AnonymousClass3 r1 = new cak<NewNoticeResult>() {
                /* class _m_j.cap.AnonymousClass3 */

                public final /* synthetic */ void O000000o(BaseResult baseResult) {
                    cap.this.O00000oO = ((NewNoticeResult) baseResult).data;
                    cap cap = cap.this;
                    cap.O00000Oo(cap.O00000oO);
                }

                public final void O000000o(String str) {
                    ccr.O00000Oo(cap.f13528O000000o, "load notice error".concat(String.valueOf(str)));
                }
            };
            if (byl.O0000OoO()) {
                request = new cam(O000O0oO, NewNoticeResult.class, r1);
            } else {
                request = new cal(O000O0oO, NewNoticeResult.class, r1);
            }
            request.setTag(f13528O000000o);
            ced.f13683O000000o.add(request);
        }
    }

    public void onPause() {
        super.onPause();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public void onRefresh() {
        ccr.O00000Oo(f13528O000000o, "onRefresh");
        O000000o();
    }

    private void O000000o() {
        Request request;
        Uri.Builder buildUpon = Uri.parse(cav.O000Oo0o()).buildUpon();
        buildUpon.appendQueryParameter("phone_model", Device.O00000oO);
        buildUpon.appendQueryParameter("phone_device", Device.O00000oo);
        if (bzw.O000000o()) {
            buildUpon.appendQueryParameter("_network_type", cbf.O000000o());
        }
        buildUpon.appendQueryParameter("name", "pages_index");
        AnonymousClass2 r1 = new cak<NewHomeBlockResult>() {
            /* class _m_j.cap.AnonymousClass2 */

            public final /* synthetic */ void O000000o(BaseResult baseResult) {
                NewHomeBlockResult newHomeBlockResult = (NewHomeBlockResult) baseResult;
                if (cap.this.O00000o0 != null) {
                    cap.this.O00000o0.setVisibility(8);
                }
                cap cap = cap.this;
                NewHomeBlockData newHomeBlockData = newHomeBlockResult.data;
                if (newHomeBlockData != null) {
                    cap.O00000o.O000000o(newHomeBlockData);
                }
                cap cap2 = cap.this;
                NewHomeBlockData newHomeBlockData2 = newHomeBlockResult.data;
                if (newHomeBlockData2 != null) {
                    if (newHomeBlockData2.mHEntrance != null && newHomeBlockData2.mHEntrance.size() > 0) {
                        NewHomeBlockInfo newHomeBlockInfo = newHomeBlockData2.mHEntrance.get(0);
                        if (newHomeBlockInfo.mItems != null && newHomeBlockInfo.mItems.size() > 0) {
                            cap2.O0000O0o = newHomeBlockInfo.mItems.get(0);
                            if (cap2.O0000O0o != null) {
                                if (!"4".equals(cap2.O0000O0o.mIconType) || !cbm.O00000o0.O00000Oo(cap2.getContext(), "pref_key_home_entrance_viewid", "").equals(cap2.O0000O0o.mViewId)) {
                                    cap2.O00000oo.setController(((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setUri(Uri.parse(cap2.O0000O0o.getImageUrl())).setAutoPlayAnimations(true)).build());
                                    if (cap2.O00000oo.getVisibility() != 0) {
                                        cap2.O00000oo.setVisibility(0);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                        }
                    }
                    if (cap2.O00000oo.getVisibility() == 0) {
                        cap2.O00000oo.setVisibility(8);
                    }
                }
            }

            public final void O000000o(String str) {
                cap cap = cap.this;
                if (cap.O00000o != null && cap.O00000o.f4789O000000o.size() != 0) {
                    cec.O000000o(cap.getContext(), str, 0);
                } else if (cap.O00000o0 != null) {
                    cap.O00000o0.O000000o(BaseResult.ResultStatus.NETWROK_ERROR);
                }
            }
        };
        if (byl.O0000OoO()) {
            request = new cam(buildUpon.toString(), NewHomeBlockResult.class, r1);
        } else {
            request = new cal(buildUpon.toString(), NewHomeBlockResult.class, r1);
        }
        request.setTag(f13528O000000o);
        ced.f13683O000000o.add(request);
    }

    private boolean O00000Oo() {
        boolean z;
        String O00000Oo2 = cbm.O00000o0.O00000Oo(getContext(), "pref_key_home_notice_closed_type", "");
        long O000000o2 = cbm.O00000o0.O000000o(getContext(), "pref_key_home_notice_closed_time");
        if (O000000o2 != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            if (simpleDateFormat.format(Long.valueOf(currentTimeMillis)).equals(simpleDateFormat.format(Long.valueOf(O000000o2)))) {
                z = true;
                return z || TextUtils.isEmpty(O00000Oo2) || !O00000Oo2.equals("1");
            }
        }
        z = false;
        if (z) {
        }
    }

    public final void O000000o(NewNoticeData newNoticeData) {
        if (newNoticeData != null && !TextUtils.isEmpty(newNoticeData.content)) {
            this.O00000oO = newNoticeData;
            if (O00000Oo()) {
                O00000Oo(newNoticeData);
            }
        }
    }

    public final void O00000Oo(NewNoticeData newNoticeData) {
        if (this.O0000Oo != null) {
            if (newNoticeData == null || TextUtils.isEmpty(newNoticeData.content)) {
                this.O0000Oo.setVisibility(8);
            } else if ("0".equalsIgnoreCase(newNoticeData.type)) {
                this.O0000Oo.setVisibility(8);
            } else if ("2".equals(newNoticeData.type)) {
                this.O0000Oo.setVisibility(8);
            } else {
                ccr.O00000Oo(f13528O000000o, "noticeShow:".concat(String.valueOf(newNoticeData)));
                this.O0000Ooo.setText(newNoticeData.content);
                this.O0000Oo.setOnClickListener(this);
                this.O0000Oo.setVisibility(0);
            }
        }
    }

    public void onClick(View view) {
        NewNoticeData newNoticeData;
        int id = view.getId();
        if (id == R.id.activity_entrance) {
            if (this.O0000O0o != null) {
                ccd.O000000o(getContext(), this.O0000O0o);
                if ("4".equals(this.O0000O0o.mIconType)) {
                    this.O00000oo.setVisibility(8);
                    cbm.O00000o0.O000000o(getContext(), "pref_key_home_entrance_viewid", this.O0000O0o.mViewId);
                }
            }
        } else if (id == R.id.notice_close) {
            this.O0000Oo.setVisibility(8);
            NewNoticeData newNoticeData2 = this.O00000oO;
            if (newNoticeData2 != null && !TextUtils.isEmpty(newNoticeData2.type)) {
                cbm.O00000o0.O000000o(getContext(), "pref_key_home_notice_closed_type", this.O00000oO.type);
                cbm.O00000o0.O000000o(getContext(), "pref_key_home_notice_closed_time", Long.valueOf(System.currentTimeMillis()));
            }
        } else if (id == R.id.noticeboard && (newNoticeData = this.O00000oO) != null && !TextUtils.isEmpty(newNoticeData.content)) {
            if ("2".equalsIgnoreCase(this.O00000oO.type) && ccn.O0000o00().O0000o0O()) {
                if (cad.O00000o()) {
                    Intent intent = new Intent(getActivity(), OrderListAcitvity.class);
                    intent.putExtra("type", 1);
                    startActivity(intent);
                    return;
                }
                String O0000oO0 = cav.O0000oO0();
                Intent intent2 = new Intent(getActivity(), WebActivity.class);
                intent2.putExtra("url", O0000oO0);
                getActivity().startActivity(intent2);
            }
            if ("1".equalsIgnoreCase(this.O00000oO.type) && !TextUtils.isEmpty(this.O00000oO.url)) {
                String str = this.O00000oO.url;
                Intent intent3 = new Intent(getActivity(), WebActivity.class);
                intent3.putExtra("url", str);
                getActivity().startActivity(intent3);
            }
        }
    }
}
