package com.xiaomi.smarthome.camera.activity.local;

import _m_j.ciw;
import _m_j.cki;
import _m_j.ckv;
import _m_j.clj;
import _m_j.hyy;
import _m_j.jz;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.viewpager.widget.ViewPager;
import com.Utils.MediaStoreUtil;
import com.mijia.generalplayer.videoview.BasicVideoView;
import com.mijia.generalplayer.videoview.GeneralVideoView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.camera.activity.local.LocalPicActivity;
import com.xiaomi.smarthome.camera.view.FixNoScrollViewPager;
import com.xiaomi.smarthome.camera.view.widget.PhotoView;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocalPicActivity extends CameraBaseActivity {
    public static final String TAG = "LocalPicActivity";
    public int currentSelectIndex;
    public boolean isEnterVideo;
    public View mBottomViewContainer;
    public ArrayList<clj.O000000o> mDataList = new ArrayList<>();
    public clj.O000000o mLocalFile;
    private clj mLocalFileManager;
    View mTitleLayout;
    public TextView mTitleView;
    public FixNoScrollViewPager mViewPage;
    boolean noScroll = false;
    public Map<Integer, View> viewPageMap = new HashMap();

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        Intent intent = getIntent();
        if (intent.getBooleanExtra("need_land", false)) {
            setRequestedOrientation(0);
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
        }
        setContentView((int) R.layout.camera_activity_local_pic);
        this.mTitleLayout = findViewById(R.id.title_bar);
        findViewById(R.id.title_bar_more).setVisibility(8);
        this.mLocalFileManager = this.mCameraDevice.O0000O0o();
        this.mLocalFile = this.mLocalFileManager.O00000Oo(intent.getStringExtra("file_path"));
        List<clj.O000000o> list = this.mLocalFileManager.O0000O0o;
        if (list.isEmpty()) {
            finish();
            return;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            this.mDataList.add(list.get(size));
        }
        if (this.mLocalFile == null) {
            this.mLocalFile = this.mDataList.get(0);
        }
        clj.O000000o o000000o = this.mLocalFile;
        if (o000000o != null && o000000o.O00000oO) {
            this.isEnterVideo = true;
        }
        initView();
        if (ciw.O000000o(getRequestedOrientation())) {
            this.mBottomViewContainer.setVisibility(8);
            this.mTitleLayout.setVisibility(8);
        }
    }

    private void initView() {
        this.mTitleView = (TextView) findViewById(R.id.title_bar_title);
        this.mTitleView.setText(this.mLocalFile.O00000o0.getName());
        this.mViewPage = (FixNoScrollViewPager) findViewById(R.id.local_pic_pager);
        int i = 0;
        try {
            this.noScroll = getIntent().getBooleanExtra("noScroll", false);
        } catch (Exception e) {
            cki.O00000oO(TAG, e.toString());
        }
        this.mViewPage.setNoScroll(this.noScroll);
        this.mViewPage.setAdapter(new PicAdapter());
        this.mBottomViewContainer = findViewById(R.id.bottom_tools_container);
        findViewById(R.id.local_share).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.local.$$Lambda$LocalPicActivity$3zKWhgYVzfuyK5yOaYmB0CEiAlY */

            public final void onClick(View view) {
                LocalPicActivity.this.lambda$initView$0$LocalPicActivity(view);
            }
        });
        findViewById(R.id.title_bar_return).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.local.$$Lambda$LocalPicActivity$9CU0vKK4nmGWURT9sp_QxPLEyFE */

            public final void onClick(View view) {
                LocalPicActivity.this.lambda$initView$1$LocalPicActivity(view);
            }
        });
        findViewById(R.id.local_delete).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.local.$$Lambda$LocalPicActivity$5xSFFPn5pKgNxkudSSJ_3RtOrg */

            public final void onClick(View view) {
                LocalPicActivity.this.lambda$initView$2$LocalPicActivity(view);
            }
        });
        int indexOf = this.mDataList.indexOf(this.mLocalFile);
        if (indexOf >= 0) {
            i = indexOf;
        }
        this.mViewPage.setCurrentItem(i);
        this.currentSelectIndex = i;
        this.mViewPage.addOnPageChangeListener(new ViewPager.O0000O0o() {
            /* class com.xiaomi.smarthome.camera.activity.local.LocalPicActivity.AnonymousClass1 */

            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
                if (i >= 0 && i < LocalPicActivity.this.mDataList.size()) {
                    LocalPicActivity localPicActivity = LocalPicActivity.this;
                    localPicActivity.mLocalFile = localPicActivity.mDataList.get(i);
                    if (LocalPicActivity.this.mLocalFile != null) {
                        LocalPicActivity.this.mTitleView.setText(LocalPicActivity.this.mLocalFile.O00000o0.getName());
                    }
                    View view = LocalPicActivity.this.viewPageMap.get(Integer.valueOf(LocalPicActivity.this.currentSelectIndex));
                    if (view != null && (view instanceof GeneralVideoView)) {
                        ((GeneralVideoView) view).O00000oO();
                    }
                    LocalPicActivity.this.currentSelectIndex = i;
                }
            }
        });
    }

    public /* synthetic */ void lambda$initView$0$LocalPicActivity(View view) {
        doShare();
    }

    public /* synthetic */ void lambda$initView$1$LocalPicActivity(View view) {
        finish();
    }

    public /* synthetic */ void lambda$initView$2$LocalPicActivity(View view) {
        doDelete();
    }

    public void doShare() {
        openSharePictureActivity("", "", this.mLocalFile.O00000o0.getAbsolutePath());
    }

    public void doDelete() {
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(activity());
        builder.O000000o((int) R.string.delete_title);
        builder.O000000o((int) R.string.delete, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.local.$$Lambda$LocalPicActivity$T6RatD8xB1M0KXPfFytIWfqWybI */

            public final void onClick(DialogInterface dialogInterface, int i) {
                LocalPicActivity.this.lambda$doDelete$3$LocalPicActivity(dialogInterface, i);
            }
        });
        builder.O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null);
        builder.O00000oo();
    }

    public /* synthetic */ void lambda$doDelete$3$LocalPicActivity(DialogInterface dialogInterface, int i) {
        this.mLocalFileManager.O000000o(this.mLocalFile);
        try {
            String replaceFirst = this.mLocalFile.O00000o.replaceFirst("/Xiaomi/local", "").replaceFirst("file://", "");
            if (new File(replaceFirst + ".png").exists()) {
                MediaStoreUtil.O00000o(this, replaceFirst + ".png");
            }
        } catch (Exception e) {
            String str = TAG;
            cki.O00000oO(str, "Error in deleting file: " + e.toString());
        }
        Toast.makeText(activity(), (int) R.string.local_file_delete_success, 0).show();
        finish();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Window window = getWindow();
        if (configuration.orientation != 1) {
            window.clearFlags(2048);
        } else {
            window.addFlags(2048);
        }
        View view = this.viewPageMap.get(Integer.valueOf(this.currentSelectIndex));
        if (view != null && (view instanceof GeneralVideoView)) {
            ((GeneralVideoView) view).O000000o(configuration);
        }
    }

    public void finish() {
        if (ciw.O000000o(getRequestedOrientation())) {
            View view = this.viewPageMap.get(Integer.valueOf(this.currentSelectIndex));
            if (view instanceof GeneralVideoView) {
                ((GeneralVideoView) view).O0000O0o();
            }
        }
        super.finish();
    }

    public void onBackPressed() {
        View view;
        if (!ciw.O000000o(getRequestedOrientation()) || (view = this.viewPageMap.get(Integer.valueOf(this.currentSelectIndex))) == null || !(view instanceof GeneralVideoView)) {
            super.onBackPressed();
            if (ciw.O000000o(getRequestedOrientation())) {
                Intent intent = new Intent(this, LocalPicActivity.class);
                intent.putExtra("file_path", this.mLocalFile.O00000o);
                startActivity(intent);
                return;
            }
            return;
        }
        ((GeneralVideoView) view).O0000O0o();
    }

    class PicAdapter extends jz {
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        private PicAdapter() {
        }

        public int getCount() {
            return LocalPicActivity.this.mDataList.size();
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX INFO: additional move instructions added (2) to help type inference */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: com.xiaomi.smarthome.camera.view.widget.PhotoView} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: com.mijia.generalplayer.videoview.GeneralVideoView} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.xiaomi.smarthome.camera.view.widget.PhotoView} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: com.xiaomi.smarthome.camera.view.widget.PhotoView} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: com.xiaomi.smarthome.camera.view.widget.PhotoView} */
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.mijia.generalplayer.videoview.BasicVideoView.O000000o(int[], _m_j.ckv$O000000o, boolean):void
         arg types: [int[], com.xiaomi.smarthome.camera.activity.local.-$$Lambda$LocalPicActivity$PicAdapter$nzuM0dwjv16c9JrcGG6pb2LlUiI, int]
         candidates:
          com.mijia.generalplayer.videoview.BasicVideoView.O000000o(java.lang.String, java.util.Map<java.lang.String, java.lang.String>, long):void
          com.mijia.generalplayer.videoview.BasicVideoView.O000000o(int[], _m_j.ckv$O000000o, boolean):void */
        /* JADX WARNING: Multi-variable type inference failed */
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            PhotoView photoView;
            clj.O000000o o000000o = LocalPicActivity.this.mLocalFile;
            if (i >= 0 && i < LocalPicActivity.this.mDataList.size()) {
                o000000o = LocalPicActivity.this.mDataList.get(i);
            }
            if (o000000o.O00000oO) {
                String absolutePath = o000000o.O00000o0.getAbsolutePath();
                GeneralVideoView generalVideoView = new GeneralVideoView(LocalPicActivity.this.getContext());
                generalVideoView.O000000o((String) null, "local:".concat(String.valueOf(absolutePath)));
                generalVideoView.setOnConfigurationChangedListener(new BasicVideoView.O000000o() {
                    /* class com.xiaomi.smarthome.camera.activity.local.$$Lambda$LocalPicActivity$PicAdapter$CrTBEfXJFgQ_d4y2C1zzVP3z05E */

                    public final void onChangeOrientation(boolean z) {
                        LocalPicActivity.PicAdapter.this.lambda$instantiateItem$0$LocalPicActivity$PicAdapter(z);
                    }
                });
                generalVideoView.O000000o(new int[]{ckv.camera_ic_player_share, ckv.camera_ic_player_delete}, (ckv.O000000o) new ckv.O000000o(generalVideoView) {
                    /* class com.xiaomi.smarthome.camera.activity.local.$$Lambda$LocalPicActivity$PicAdapter$nzuM0dwjv16c9JrcGG6pb2LlUiI */
                    private final /* synthetic */ GeneralVideoView f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onActionClick(int i) {
                        LocalPicActivity.PicAdapter.this.lambda$instantiateItem$1$LocalPicActivity$PicAdapter(this.f$1, i);
                    }
                }, false);
                generalVideoView.setScaleEnable(true);
                if (!LocalPicActivity.this.isEnterVideo || !o000000o.equals(LocalPicActivity.this.mLocalFile)) {
                    generalVideoView.O00000Oo(absolutePath, null);
                    generalVideoView.O000000o(absolutePath);
                    photoView = generalVideoView;
                } else {
                    generalVideoView.O000000o(absolutePath, (Map<String, String>) null);
                    LocalPicActivity.this.isEnterVideo = false;
                    photoView = generalVideoView;
                }
            } else {
                PhotoView photoView2 = new PhotoView(LocalPicActivity.this.activity());
                photoView2.enable();
                photoView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
                photoView2.setFilePath(o000000o.O00000o0.getAbsolutePath());
                photoView = photoView2;
            }
            LocalPicActivity.this.viewPageMap.put(Integer.valueOf(i), photoView);
            viewGroup.addView(photoView);
            return photoView;
        }

        public /* synthetic */ void lambda$instantiateItem$0$LocalPicActivity$PicAdapter(boolean z) {
            FixNoScrollViewPager fixNoScrollViewPager;
            int i = z ? 0 : 8;
            LocalPicActivity.this.mBottomViewContainer.setVisibility(i);
            LocalPicActivity.this.mTitleLayout.setVisibility(i);
            boolean z2 = true;
            if (LocalPicActivity.this.noScroll) {
                fixNoScrollViewPager = LocalPicActivity.this.mViewPage;
            } else {
                fixNoScrollViewPager = LocalPicActivity.this.mViewPage;
                if (z) {
                    z2 = false;
                }
            }
            fixNoScrollViewPager.setNoScroll(z2);
            if (!z) {
                LocalPicActivity.this.hideStatusBar();
            }
        }

        public /* synthetic */ void lambda$instantiateItem$1$LocalPicActivity$PicAdapter(GeneralVideoView generalVideoView, int i) {
            if (i == ckv.camera_ic_player_share) {
                if (hyy.O000000o() && generalVideoView != null) {
                    generalVideoView.O00000oo();
                }
                LocalPicActivity.this.doShare();
            } else if (i == ckv.camera_ic_player_delete) {
                LocalPicActivity.this.doDelete();
            }
        }

        public void finishUpdate(ViewGroup viewGroup) {
            super.finishUpdate(viewGroup);
        }
    }
}
