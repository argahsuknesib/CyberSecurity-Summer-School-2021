package com.xiaomi.mico.music.patchwall;

import _m_j.hxi;
import _m_j.hxk;
import _m_j.hxp;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.IntelligentMoreModel;
import com.xiaomi.mico.application.MicoApplication;
import com.xiaomi.mico.base.MicoBaseActivity;
import com.xiaomi.mico.common.util.DisplayUtils;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.patchwall.IntelligentMoreActivity;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

public class IntelligentMoreActivity extends MicoBaseActivity {
    public InnerAdapter innerAdapter;
    private long lastUpdateTime;
    public boolean loadPatchWallFail = false;
    @BindView(6434)
    RecyclerView mRecyclerView;
    public String pageType;
    public int pageTypeId;
    @BindView(6907)
    SmartRefreshLayout refreshLayout;
    @BindView(7237)
    ImageView titleBarLeftIcon;
    @BindView(7245)
    TextView titleBarTitle;

    public static void startActivity(Context context, int i, String str, String str2) {
        Intent intent = new Intent(context, IntelligentMoreActivity.class);
        intent.putExtra("intelligent_pagetype_param", i);
        intent.putExtra("intelligent_pagename_param", str);
        intent.putExtra("intelligent_pagetype_name_param", str2);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_intelligent_more);
        ButterKnife.bind(this);
        this.pageTypeId = getIntent().getIntExtra("intelligent_pagetype_param", 0);
        this.pageType = getIntent().getStringExtra("intelligent_pagetype_name_param");
        initView();
        getPatchWallFlow();
    }

    private void initView() {
        this.titleBarLeftIcon.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.music.patchwall.$$Lambda$IntelligentMoreActivity$zHnBc2aNTlY6TmfTmOLX9jvUi_4 */

            public final void onClick(View view) {
                IntelligentMoreActivity.this.lambda$initView$0$IntelligentMoreActivity(view);
            }
        });
        this.titleBarTitle.setText(getIntent().getStringExtra("intelligent_pagename_param"));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setItemPrefetchEnabled(false);
        linearLayoutManager.setInitialPrefetchItemCount(0);
        this.mRecyclerView.setLayoutManager(linearLayoutManager);
        this.mRecyclerView.setHasFixedSize(true);
        this.mRecyclerView.setItemViewCacheSize(0);
        this.refreshLayout.O00000o0(false);
        this.refreshLayout.O0000O0o(false);
        this.refreshLayout.O00000o(false);
        this.innerAdapter = new InnerAdapter();
        this.mRecyclerView.setAdapter(this.innerAdapter);
    }

    public /* synthetic */ void lambda$initView$0$IntelligentMoreActivity(View view) {
        onBackPressed();
    }

    private void getPatchWallFlow() {
        ApiHelper.getIntelligentMoreFlow(this.pageTypeId, new ApiRequest.Listener<IntelligentMoreModel>() {
            /* class com.xiaomi.mico.music.patchwall.IntelligentMoreActivity.AnonymousClass1 */

            public void onSuccess(IntelligentMoreModel intelligentMoreModel) {
                if (!(intelligentMoreModel == null || intelligentMoreModel.getList() == null)) {
                    IntelligentMoreActivity.this.innerAdapter.setData(intelligentMoreModel.getList(), intelligentMoreModel.getDisplayType());
                    IntelligentMoreActivity.this.loadPatchWallFail = false;
                }
                IntelligentMoreActivity.this.updatedDate();
            }

            public void onFailure(ApiError apiError) {
                new Object[1][0] = apiError;
                IntelligentMoreActivity.this.loadPatchWallFail = true;
            }
        }).bindToLifecycle(this);
    }

    public void onResume() {
        super.onResume();
        if (isNeedUpdateData() || this.loadPatchWallFail) {
            getPatchWallFlow();
        }
        hxp hxp = hxi.O00000o0;
        int i = this.pageTypeId;
        hxp.f957O000000o.O000000o(i != 3 ? i != 4 ? i != 5 ? "" : "content_guide_page" : "content_qa_page" : "content_discuss_page", new Object[0]);
        hxi.O00000o0.f957O000000o.O000000o("content_second_page", "type", this.pageType, "name", this.titleBarTitle.getText().toString());
    }

    private boolean isNeedUpdateData() {
        return (((System.currentTimeMillis() - this.lastUpdateTime) > 120000 ? 1 : ((System.currentTimeMillis() - this.lastUpdateTime) == 120000 ? 0 : -1)) > 0) & ((this.lastUpdateTime > 0 ? 1 : (this.lastUpdateTime == 0 ? 0 : -1)) > 0);
    }

    public void updatedDate() {
        this.lastUpdateTime = System.currentTimeMillis();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    class InnerAdapter extends RecyclerView.O000000o<VH> {
        public final int borderRadius;
        private final List<IntelligentMoreModel.ListBean> mDataList;
        private int mDisplayType;

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.xiaomi.mico.common.util.DisplayUtils.dip2px(android.app.Activity, float):int
         arg types: [android.app.Activity, int]
         candidates:
          com.xiaomi.mico.common.util.DisplayUtils.dip2px(android.content.Context, float):int
          com.xiaomi.mico.common.util.DisplayUtils.dip2px(android.app.Activity, float):int */
        private InnerAdapter() {
            this.mDataList = new ArrayList();
            this.mDisplayType = 3;
            this.borderRadius = DisplayUtils.dip2px(IntelligentMoreActivity.this.getContext(), 12.0f);
        }

        public void setData(List<IntelligentMoreModel.ListBean> list, int i) {
            this.mDataList.clear();
            this.mDataList.addAll(list);
            if (i > 0) {
                this.mDisplayType = i;
            }
            notifyDataSetChanged();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public VH onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new VH(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.mico_intelligent_single_pic_view, viewGroup, false));
        }

        public void onBindViewHolder(VH vh, int i) {
            float f;
            Context context;
            IntelligentMoreModel.ListBean listBean = this.mDataList.get(i);
            vh.img.setOnClickListener(new View.OnClickListener(i, listBean) {
                /* class com.xiaomi.mico.music.patchwall.$$Lambda$IntelligentMoreActivity$InnerAdapter$QvWTJLuhwpmtVahtaUVK6M7ejw */
                private final /* synthetic */ int f$1;
                private final /* synthetic */ IntelligentMoreModel.ListBean f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    IntelligentMoreActivity.InnerAdapter.this.lambda$onBindViewHolder$0$IntelligentMoreActivity$InnerAdapter(this.f$1, this.f$2, view);
                }
            });
            int i2 = this.mDisplayType == 5 ? R.drawable.img_cover_default_intelligent_330_180 : R.drawable.mico_img_cover_default_singleimg;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) vh.img.getLayoutParams();
            ImageView imageView = vh.img;
            if (this.mDisplayType == 5) {
                context = vh.img.getContext();
                f = 180.0f;
            } else {
                context = vh.img.getContext();
                f = 158.0f;
            }
            imageView.setMinimumHeight(DisplayUtils.dip2px(context, f));
            layoutParams.height = (int) ((((float) DisplayUtils.px2dip(vh.img.getContext(), (float) vh.img.getMinimumHeight())) / 330.0f) * ((float) (DisplayUtils.getScreenWidthPixels(vh.img.getContext()) - DisplayUtils.dip2px(vh.img.getContext(), 30.0f))));
            MusicHelper.loadPatchWallCropSquareCover(listBean.getPicture(), vh.img, i2, this.borderRadius);
            String str = "";
            vh.mVoteUserAmount.setText(TextUtils.isEmpty(listBean.getPicContent()) ? str : listBean.getPicContent());
            TextView textView = vh.mMainTitle;
            if (!TextUtils.isEmpty(listBean.getPicTitle())) {
                str = listBean.getPicTitle();
            }
            textView.setText(str);
        }

        public /* synthetic */ void lambda$onBindViewHolder$0$IntelligentMoreActivity$InnerAdapter(int i, IntelligentMoreModel.ListBean listBean, View view) {
            hxk hxk = hxi.O00000o;
            int i2 = i + 1;
            String mainTitle = listBean.getMainTitle();
            int i3 = IntelligentMoreActivity.this.pageTypeId;
            hxk.f952O000000o.O000000o(i3 != 3 ? i3 != 4 ? i3 != 5 ? "" : "content_guide_floor" : "content_qa1_floor" : "content_discuss_floor", "position", Integer.valueOf(i2), "type", "", "name", mainTitle);
            MicoApplication.getInstance().getMicoHelperListener().jumpSmartHome(listBean.getJumpLink(), "");
            hxi.O00000o.f952O000000o.O000000o("content_second_click", "type", IntelligentMoreActivity.this.pageType, "position", Integer.valueOf(i), "name", IntelligentMoreActivity.this.titleBarTitle.getText().toString());
        }

        public int getItemCount() {
            return this.mDataList.size();
        }

        class VH extends RecyclerView.O000OOo0 {
            ImageView img;
            TextView mMainTitle;
            TextView mVoteUserAmount;

            VH(View view) {
                super(view);
                this.img = (ImageView) view.findViewById(R.id.mico_intelligent_iv_single_pic);
                this.mVoteUserAmount = (TextView) view.findViewById(R.id.tv_vote_user_amount);
                this.mMainTitle = (TextView) view.findViewById(R.id.main_title);
            }
        }
    }
}
