package com.xiaomi.smarthome.camera.activity.local;

import _m_j.chp;
import _m_j.cki;
import _m_j.cnw;
import _m_j.cnx;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.view.recycle.RecyclerClickListener;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.CloudVideoDownloadInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlbumAdapter extends RecyclerView.O000000o<AlbumViewHolder> {
    public static final String TAG = "AlbumAdapter";
    private boolean isV4;
    public List<LocalFileData> mData = new ArrayList();
    public boolean mIsMultiSelectMode;
    public RecyclerClickListener mListener;
    public cnw mOptions;
    private boolean[] mSelectMap;

    public AlbumAdapter(Context context, RecyclerClickListener recyclerClickListener, boolean z) {
        this.isV4 = z;
        initImageDisplayOptions(context);
        this.mListener = recyclerClickListener;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public AlbumViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new AlbumViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.album_item, viewGroup, false));
    }

    public void onBindViewHolder(AlbumViewHolder albumViewHolder, int i) {
        albumViewHolder.bindView(i);
    }

    public int getItemCount() {
        return this.mData.size();
    }

    public LocalFileData getItem(int i) {
        if (i < 0 || i >= this.mData.size()) {
            return null;
        }
        return this.mData.get(i);
    }

    class AlbumViewHolder extends RecyclerView.O000OOo0 {
        private ImageView checkView;
        private ImageView imageView;
        private ProgressBar sbProgress;
        private TextView timeView;
        private TextView tv_downloading;
        private View videoImg;

        public AlbumViewHolder(View view) {
            super(view);
            this.timeView = (TextView) view.findViewById(R.id.title);
            this.imageView = (ImageView) view.findViewById(R.id.thumb);
            this.checkView = (ImageView) view.findViewById(R.id.checkbox);
            this.videoImg = view.findViewById(R.id.album_video);
            this.tv_downloading = (TextView) view.findViewById(R.id.tv_downloading);
            this.sbProgress = (ProgressBar) view.findViewById(R.id.sbProgress);
            this.sbProgress.setIndeterminate(false);
            this.imageView.getLayoutParams().height = (((int) (((float) chp.f13827O000000o) - (chp.O00000o0 * 4.0f))) * 3) / 16;
            view.setOnLongClickListener(new View.OnLongClickListener(AlbumAdapter.this) {
                /* class com.xiaomi.smarthome.camera.activity.local.AlbumAdapter.AlbumViewHolder.AnonymousClass1 */

                public boolean onLongClick(View view) {
                    if (AlbumAdapter.this.mListener == null) {
                        return true;
                    }
                    AlbumAdapter.this.mListener.onRecyclerLongClick(view);
                    return true;
                }
            });
            view.setOnClickListener(new View.OnClickListener(AlbumAdapter.this) {
                /* class com.xiaomi.smarthome.camera.activity.local.AlbumAdapter.AlbumViewHolder.AnonymousClass2 */

                public void onClick(View view) {
                    if (AlbumAdapter.this.mListener != null) {
                        AlbumAdapter.this.mListener.onRecyclerClick(view);
                    }
                }
            });
        }

        /* access modifiers changed from: package-private */
        public void bindView(int i) {
            LocalFileData localFileData = AlbumAdapter.this.mData.get(i);
            if (localFileData.isCloudMp4File && (localFileData instanceof CloudVideoDownloadInfo)) {
                this.imageView.setImageResource(R.drawable.set_bg_02_visual_nor);
                this.videoImg.setVisibility(8);
                CloudVideoDownloadInfo cloudVideoDownloadInfo = (CloudVideoDownloadInfo) localFileData;
                String str = AlbumAdapter.TAG;
                cki.O00000o(str, "info.progress=" + cloudVideoDownloadInfo.progress);
                cloudVideoDownloadInfo.progress = cloudVideoDownloadInfo.progress / 2;
                this.sbProgress.setProgress(cloudVideoDownloadInfo.progress);
                if (this.sbProgress.getVisibility() != 0) {
                    this.sbProgress.setVisibility(0);
                }
                this.tv_downloading.setText("");
                if (this.tv_downloading.getVisibility() != 0) {
                    this.tv_downloading.setVisibility(0);
                }
                int i2 = cloudVideoDownloadInfo.status;
                if (i2 == 0) {
                    this.tv_downloading.setText((int) R.string.cs_download_prepare);
                } else if (i2 == 1) {
                    TextView textView = this.tv_downloading;
                    textView.setText(this.imageView.getContext().getString(R.string.cs_downloading) + cloudVideoDownloadInfo.progress + "%");
                } else if (i2 == 2) {
                    this.tv_downloading.setText((int) R.string.cs_download_fail);
                    this.sbProgress.setProgress(0);
                } else if (i2 == 4) {
                    this.sbProgress.setProgress(0);
                    this.tv_downloading.setText((int) R.string.cs_download_prepare);
                } else if (i2 == 8) {
                    this.tv_downloading.setText((int) R.string.cs_download_pause);
                    this.sbProgress.setProgress(0);
                }
            } else if (localFileData.videoType == 3) {
                this.tv_downloading.setVisibility(8);
                this.sbProgress.setVisibility(8);
                this.videoImg.setVisibility(0);
                this.timeView.setText(localFileData.title);
                if (cnx.O000000o().O00000Oo()) {
                    cnx.O000000o().O000000o(localFileData.displayImgPath, this.imageView, AlbumAdapter.this.mOptions);
                }
            } else {
                this.tv_downloading.setVisibility(8);
                this.sbProgress.setVisibility(8);
                if (localFileData.item.O00000oO) {
                    this.videoImg.setVisibility(0);
                    this.timeView.setText(localFileData.title);
                } else {
                    this.videoImg.setVisibility(8);
                    this.timeView.setText("");
                }
                if (cnx.O000000o().O00000Oo()) {
                    cnx.O000000o().O000000o(localFileData.item.O00000o, this.imageView, AlbumAdapter.this.mOptions);
                }
            }
            if (AlbumAdapter.this.mIsMultiSelectMode) {
                this.checkView.setVisibility(0);
                if (AlbumAdapter.this.isSelected(i)) {
                    this.checkView.setImageResource(R.drawable.delete_checked);
                } else {
                    this.checkView.setImageResource(R.drawable.delete_unchecked);
                }
            } else {
                this.checkView.setVisibility(8);
            }
        }
    }

    private void initImageDisplayOptions(Context context) {
        cnw.O000000o o000000o = new cnw.O000000o();
        if (this.isV4) {
            o000000o.O00000o = context.getResources().getDrawable(R.drawable.camera_v4_remind_load_fail);
            o000000o.O00000oO = context.getResources().getDrawable(R.drawable.camera_v4_remind_load_fail);
            o000000o.O00000oo = context.getResources().getDrawable(R.drawable.camera_v4_remind_load_fail);
        } else {
            o000000o.O00000o = context.getResources().getDrawable(R.drawable.camera_remind_load_fail);
            o000000o.O00000oO = context.getResources().getDrawable(R.drawable.camera_remind_load_fail);
            o000000o.O00000oo = context.getResources().getDrawable(R.drawable.camera_remind_load_fail);
        }
        o000000o.O0000OOo = true;
        o000000o.O0000Oo0 = true;
        o000000o.O0000o00 = true;
        cnw.O000000o O000000o2 = o000000o.O000000o(Bitmap.Config.RGB_565);
        O000000o2.O0000Oo = ImageScaleType.EXACTLY_STRETCHED;
        this.mOptions = O000000o2.O000000o();
    }

    public void setData(List<LocalFileData> list) {
        this.mData = list;
        this.mSelectMap = new boolean[this.mData.size()];
    }

    public void setSelectMode(boolean z) {
        if (this.mIsMultiSelectMode != z) {
            if (!z) {
                unSelectAll();
            }
            this.mIsMultiSelectMode = z;
            notifyDataSetChanged();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.Arrays.fill(boolean[], boolean):void}
     arg types: [boolean[], int]
     candidates:
      ClspMth{java.util.Arrays.fill(double[], double):void}
      ClspMth{java.util.Arrays.fill(byte[], byte):void}
      ClspMth{java.util.Arrays.fill(long[], long):void}
      ClspMth{java.util.Arrays.fill(char[], char):void}
      ClspMth{java.util.Arrays.fill(short[], short):void}
      ClspMth{java.util.Arrays.fill(java.lang.Object[], java.lang.Object):void}
      ClspMth{java.util.Arrays.fill(int[], int):void}
      ClspMth{java.util.Arrays.fill(float[], float):void}
      ClspMth{java.util.Arrays.fill(boolean[], boolean):void} */
    public void selectAll() {
        boolean[] zArr = this.mSelectMap;
        if (zArr != null) {
            Arrays.fill(zArr, true);
        }
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.Arrays.fill(boolean[], boolean):void}
     arg types: [boolean[], int]
     candidates:
      ClspMth{java.util.Arrays.fill(double[], double):void}
      ClspMth{java.util.Arrays.fill(byte[], byte):void}
      ClspMth{java.util.Arrays.fill(long[], long):void}
      ClspMth{java.util.Arrays.fill(char[], char):void}
      ClspMth{java.util.Arrays.fill(short[], short):void}
      ClspMth{java.util.Arrays.fill(java.lang.Object[], java.lang.Object):void}
      ClspMth{java.util.Arrays.fill(int[], int):void}
      ClspMth{java.util.Arrays.fill(float[], float):void}
      ClspMth{java.util.Arrays.fill(boolean[], boolean):void} */
    public void unSelectAll() {
        boolean[] zArr = this.mSelectMap;
        if (zArr != null) {
            Arrays.fill(zArr, false);
        }
        notifyDataSetChanged();
    }

    public int getSelectCount() {
        int i = 0;
        if (this.mSelectMap == null) {
            return 0;
        }
        int i2 = 0;
        while (true) {
            boolean[] zArr = this.mSelectMap;
            if (i >= zArr.length) {
                return i2;
            }
            if (zArr[i]) {
                i2++;
            }
            i++;
        }
    }

    public void selectToggle(int i) {
        if (i >= 0) {
            boolean[] zArr = this.mSelectMap;
            if (i < zArr.length) {
                zArr[i] = !zArr[i];
            }
        }
    }

    public boolean isSelected(int i) {
        if (i < 0) {
            return false;
        }
        boolean[] zArr = this.mSelectMap;
        if (i >= zArr.length) {
            return false;
        }
        return zArr[i];
    }

    public void setMultiSelectMode(boolean z) {
        if (this.mIsMultiSelectMode != z) {
            this.mIsMultiSelectMode = z;
            if (!z) {
                unSelectAll();
            }
            notifyDataSetChanged();
        }
    }

    public ArrayList<LocalFileData> getSelectItems() {
        ArrayList<LocalFileData> arrayList = new ArrayList<>();
        for (int i = 0; i < this.mData.size(); i++) {
            boolean[] zArr = this.mSelectMap;
            if (i >= zArr.length) {
                break;
            }
            if (zArr[i]) {
                arrayList.add(this.mData.get(i));
            }
        }
        return arrayList;
    }

    public void updateDownloadingItem(CloudVideoDownloadInfo cloudVideoDownloadInfo) {
        for (int i = 0; i < this.mData.size(); i++) {
            LocalFileData localFileData = this.mData.get(i);
            if (localFileData instanceof CloudVideoDownloadInfo) {
                CloudVideoDownloadInfo cloudVideoDownloadInfo2 = (CloudVideoDownloadInfo) localFileData;
                if (cloudVideoDownloadInfo.id == cloudVideoDownloadInfo2.id) {
                    cloudVideoDownloadInfo2.size = cloudVideoDownloadInfo.size;
                    cloudVideoDownloadInfo2.mp4FilePath = cloudVideoDownloadInfo.mp4FilePath;
                    cloudVideoDownloadInfo2.m3u8FilePath = cloudVideoDownloadInfo.m3u8FilePath;
                    cloudVideoDownloadInfo2.progress = cloudVideoDownloadInfo.progress;
                    cloudVideoDownloadInfo2.did = cloudVideoDownloadInfo.did;
                    cloudVideoDownloadInfo2.status = cloudVideoDownloadInfo.status;
                    cloudVideoDownloadInfo2.createTime = cloudVideoDownloadInfo.createTime;
                    cloudVideoDownloadInfo2.m3u8LocalPath = cloudVideoDownloadInfo.m3u8LocalPath;
                    cloudVideoDownloadInfo2.uid = cloudVideoDownloadInfo.uid;
                    cloudVideoDownloadInfo2.videoUrl = cloudVideoDownloadInfo.videoUrl;
                    cloudVideoDownloadInfo2.endTime = cloudVideoDownloadInfo.endTime;
                    cloudVideoDownloadInfo2.startTime = cloudVideoDownloadInfo.startTime;
                    cloudVideoDownloadInfo2.timezoneId = cloudVideoDownloadInfo.timezoneId;
                    notifyItemChanged(i);
                    return;
                }
            }
        }
    }

    public int getDownloadingIndex(CloudVideoDownloadInfo cloudVideoDownloadInfo) {
        for (int i = 0; i < this.mData.size(); i++) {
            LocalFileData localFileData = this.mData.get(i);
            if ((localFileData instanceof CloudVideoDownloadInfo) && cloudVideoDownloadInfo != null && cloudVideoDownloadInfo.id == ((CloudVideoDownloadInfo) localFileData).id) {
                return i;
            }
        }
        return -1;
    }

    public void destroyDisplayImageOptions() {
        this.mOptions = null;
        this.mListener = null;
    }
}
