package com.xiaomi.smarthome.miio.camera.face.activity;

import _m_j.gqg;
import _m_j.gwg;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.view.recycle.RecyclerViewRefreshLayout;
import com.xiaomi.smarthome.miio.camera.face.FaceManager;
import com.xiaomi.smarthome.miio.camera.face.adapter.UnmarkedFaceAdapter;
import com.xiaomi.smarthome.miio.camera.face.util.FaceUtils;
import java.util.ArrayList;

public class FaceUnmarkedListActivity extends FaceManagerBaseActivity implements View.OnClickListener {
    public static final String TAG = "FaceUnmarkedListActivity";
    public UnmarkedFaceAdapter mAdapter;
    private RecyclerView mRecyclerView;
    public RecyclerViewRefreshLayout mRefreshLayout;
    private UnmarkedFaceAdapter.ClickCallBack recyclerClickCallback = new UnmarkedFaceAdapter.ClickCallBack() {
        /* class com.xiaomi.smarthome.miio.camera.face.activity.FaceUnmarkedListActivity.AnonymousClass3 */

        public void onRecyclerClick(int i) {
            FaceUtils.processMarkFace(FaceUnmarkedListActivity.this, FaceUnmarkedListActivity.this.mAdapter.getItem(i).faceId, FaceManagerBaseActivity.mFaceManager, new FaceManager.IFaceCallback() {
                /* class com.xiaomi.smarthome.miio.camera.face.activity.FaceUnmarkedListActivity.AnonymousClass3.AnonymousClass1 */

                public void onSuccess(Object obj, Object obj2) {
                    FaceUnmarkedListActivity.this.setResult(-1);
                    FaceUnmarkedListActivity.this.finish();
                }

                public void onFailure(int i, String str) {
                    gqg.O00000Oo((int) R.string.action_fail);
                }
            });
        }
    };
    private TextView tvTitle;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_face_unmarked);
        gwg.O000000o(findViewById(R.id.title_bar_container));
        initView();
        loadData();
    }

    private void initView() {
        this.tvTitle = (TextView) findViewById(R.id.title_bar_title);
        this.tvTitle.setText(getResources().getString(R.string.face_unmarked));
        findViewById(R.id.title_bar_more).setVisibility(8);
        findViewById(R.id.title_bar_return).setOnClickListener(this);
        this.mRefreshLayout = (RecyclerViewRefreshLayout) findViewById(R.id.recycle_refresh);
        this.mRefreshLayout.setMode(2);
        this.mRefreshLayout.setFooterRefreshView(LayoutInflater.from(this).inflate((int) R.layout.camera_list_load_more, (ViewGroup) null));
        this.mRefreshLayout.setOnPushLoadMoreListener(new RecyclerViewRefreshLayout.OnPushLoadMoreListener() {
            /* class com.xiaomi.smarthome.miio.camera.face.activity.FaceUnmarkedListActivity.AnonymousClass1 */

            public void onPushDistance(int i) {
            }

            public void onPushEnable(boolean z) {
            }

            public void onLoadMore() {
                FaceManagerBaseActivity.mFaceManager.getUnmarkFaces(50, true, new FaceManager.IFaceCallback() {
                    /* class com.xiaomi.smarthome.miio.camera.face.activity.FaceUnmarkedListActivity.AnonymousClass1.AnonymousClass1 */

                    public void onFailure(int i, String str) {
                    }

                    public void onSuccess(Object obj, Object obj2) {
                        FaceUnmarkedListActivity.this.mAdapter.addData((ArrayList) obj2);
                        FaceUnmarkedListActivity.this.mRefreshLayout.setLoadMore(false);
                    }
                });
            }
        });
        this.mRecyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(1);
        this.mRecyclerView.setLayoutManager(linearLayoutManager);
        this.mAdapter = new UnmarkedFaceAdapter(this, this.recyclerClickCallback, mFaceManager);
        this.mRecyclerView.setAdapter(this.mAdapter);
        this.mAdapter.setData(new ArrayList());
    }

    private void loadData() {
        mFaceManager.getUnmarkFaces(50, false, new FaceManager.IFaceCallback() {
            /* class com.xiaomi.smarthome.miio.camera.face.activity.FaceUnmarkedListActivity.AnonymousClass2 */

            public void onFailure(int i, String str) {
            }

            public void onSuccess(Object obj, Object obj2) {
                FaceUnmarkedListActivity.this.mAdapter.setData((ArrayList) obj2);
            }
        });
    }

    public void onClick(View view) {
        if (view.getId() == R.id.title_bar_return) {
            onBackPressed();
        }
    }
}
