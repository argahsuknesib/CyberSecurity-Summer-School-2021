package com.xiaomi.smarthome.miio.camera.face.adapter;

import _m_j.cnw;
import _m_j.cnx;
import _m_j.gsy;
import _m_j.hxi;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils;
import com.xiaomi.smarthome.miio.camera.face.FaceManager;
import com.xiaomi.smarthome.miio.camera.face.adapter.FigureFaceEventAdapter;
import com.xiaomi.smarthome.miio.camera.face.model.FaceEvent;
import com.xiaomi.smarthome.miio.camera.face.model.FaceEventItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FigureFaceEventAdapter extends RecyclerView.O000000o<RecyclerView.O000OOo0> {
    public static final String TAG = "FigureFaceEventAdapter";
    public int ITEM_TYPE_DAY = 0;
    private int ITEM_TYPE_EVENT = 1;
    public ClickCallBack clickCallBack;
    public Context context;
    public FaceManager faceManager;
    public List<FaceEventItem> mData = new ArrayList();
    public cnw mOptions;
    public String name;
    private int selectedCount;
    private boolean selectedMod;
    public boolean showReportError;

    public interface ClickCallBack {
        void onAdapterDataChange();

        void onRecyclerClick(int i);

        void onRecyclerLongClick(int i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public FigureFaceEventAdapter(Context context2, ClickCallBack clickCallBack2, FaceManager faceManager2, String str) {
        initImageDisplayOptions(context2);
        this.context = context2;
        this.clickCallBack = clickCallBack2;
        this.faceManager = faceManager2;
        this.showReportError = false;
        this.name = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == this.ITEM_TYPE_DAY) {
            return new ItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.item_face_event_day, viewGroup, false), i);
        }
        return new ItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.item_figure_face_event, viewGroup, false), i);
    }

    public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        ((ItemViewHolder) o000OOo0).bindView(i);
    }

    public void setData(ArrayList<FaceEventItem> arrayList) {
        if (arrayList != null) {
            this.mData.clear();
            this.selectedCount = 0;
            this.mData.addAll(arrayList);
            Iterator<FaceEventItem> it = arrayList.iterator();
            while (it.hasNext()) {
                gsy.O000000o(6, "faceEvent", it.next().toString());
            }
            notifyDataSetChanged();
        }
    }

    public void addData(ArrayList<FaceEventItem> arrayList) {
        if (arrayList != null) {
            int size = this.mData.size();
            this.mData.addAll(arrayList);
            Iterator<FaceEventItem> it = arrayList.iterator();
            while (it.hasNext()) {
                gsy.O000000o(6, "faceEvent", it.next().toString());
            }
            notifyItemRangeChanged(size, this.mData.size());
        }
    }

    public void setShowReportError(boolean z) {
        this.showReportError = z;
        notifyDataSetChanged();
    }

    public boolean getShowReportError() {
        return this.showReportError;
    }

    public int getItemCount() {
        return this.mData.size();
    }

    public void setSelectedMod(boolean z) {
        this.selectedMod = z;
        if (!this.selectedMod) {
            unSelectAll();
        }
        notifyDataSetChanged();
    }

    public int getSelectedCount() {
        return this.selectedCount;
    }

    public void selectAll() {
        notifyDataSetChanged();
    }

    public void unSelectAll() {
        notifyDataSetChanged();
    }

    public void clear() {
        this.mData.clear();
        notifyDataSetChanged();
    }

    class ItemViewHolder extends RecyclerView.O000OOo0 {
        TextView event_day;
        View item_view;
        ImageView iv_image;
        TextView tv_event_des;
        TextView tv_report_error;
        TextView tv_time;
        int type;

        ItemViewHolder(View view, int i) {
            super(view);
            this.type = i;
            this.item_view = view;
            if (i == FigureFaceEventAdapter.this.ITEM_TYPE_DAY) {
                this.event_day = (TextView) view.findViewById(R.id.event_day);
                return;
            }
            this.tv_time = (TextView) view.findViewById(R.id.tv_event_time);
            this.iv_image = (ImageView) view.findViewById(R.id.face_event_image);
            this.tv_report_error = (TextView) view.findViewById(R.id.tv_report_error);
            this.tv_event_des = (TextView) view.findViewById(R.id.tv_event_des);
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.miio.camera.face.adapter.$$Lambda$FigureFaceEventAdapter$ItemViewHolder$i1nOtm7FQOC4y6Bl4PW9Ra6uYs */

                public final void onClick(View view) {
                    FigureFaceEventAdapter.ItemViewHolder.this.lambda$new$0$FigureFaceEventAdapter$ItemViewHolder(view);
                }
            });
        }

        public /* synthetic */ void lambda$new$0$FigureFaceEventAdapter$ItemViewHolder(View view) {
            FigureFaceEventAdapter.this.clickCallBack.onRecyclerClick(getAdapterPosition());
        }

        /* access modifiers changed from: package-private */
        public void bindView(int i) {
            FaceEventItem faceEventItem = FigureFaceEventAdapter.this.mData.get(i);
            if (this.type == FigureFaceEventAdapter.this.ITEM_TYPE_DAY) {
                this.event_day.setText(faceEventItem.time);
                return;
            }
            if (FigureFaceEventAdapter.this.showReportError) {
                this.tv_report_error.setVisibility(0);
            } else {
                this.tv_report_error.setVisibility(8);
            }
            if (FigureFaceEventAdapter.this.name != null) {
                this.tv_event_des.setText(String.format(FigureFaceEventAdapter.this.context.getResources().getString(R.string.known_people_desc), FigureFaceEventAdapter.this.name));
            } else {
                this.tv_event_des.setText(FigureFaceEventAdapter.this.context.getResources().getString(R.string.unknown_people_desc));
            }
            this.tv_report_error.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.miio.camera.face.adapter.FigureFaceEventAdapter.ItemViewHolder.AnonymousClass1 */

                public void onClick(View view) {
                    FaceEvent faceEvent;
                    ItemViewHolder.this.item_view.setEnabled(false);
                    int adapterPosition = ItemViewHolder.this.getAdapterPosition();
                    hxi.O00000o.f952O000000o.O000000o("Face_ErrorsButton_ClickNum", new Object[0]);
                    if (adapterPosition < FigureFaceEventAdapter.this.mData.size() && adapterPosition >= 0 && (faceEvent = FigureFaceEventAdapter.this.mData.get(adapterPosition).item) != null) {
                        FigureFaceEventAdapter.this.mData.remove(adapterPosition);
                        FigureFaceEventAdapter.this.notifyItemRemoved(adapterPosition);
                        FigureFaceEventAdapter.this.faceManager.faceClusterErrorReport(faceEvent.fileId, faceEvent.offset, faceEvent.faceId, new FaceManager.IFaceCallback() {
                            /* class com.xiaomi.smarthome.miio.camera.face.adapter.FigureFaceEventAdapter.ItemViewHolder.AnonymousClass1.AnonymousClass1 */

                            public void onSuccess(Object obj, Object obj2) {
                                if (FigureFaceEventAdapter.this.clickCallBack != null) {
                                    FigureFaceEventAdapter.this.clickCallBack.onAdapterDataChange();
                                }
                            }

                            public void onFailure(int i, String str) {
                                if (FigureFaceEventAdapter.this.clickCallBack != null) {
                                    FigureFaceEventAdapter.this.clickCallBack.onAdapterDataChange();
                                }
                            }
                        });
                    }
                }
            });
            this.tv_time.setText(faceEventItem.time);
            String snapshotUrl = CloudVideoNetUtils.getInstance().getSnapshotUrl(FigureFaceEventAdapter.this.faceManager.getDeviceId(), faceEventItem.item.fileId, faceEventItem.item.imgStoreId);
            if (cnx.O000000o().O00000Oo()) {
                cnx.O000000o().O000000o(snapshotUrl, this.iv_image, FigureFaceEventAdapter.this.mOptions);
            }
        }
    }

    public int getItemViewType(int i) {
        if (i < 0 || i >= this.mData.size() || this.mData.get(i).item != null) {
            return this.ITEM_TYPE_EVENT;
        }
        return this.ITEM_TYPE_DAY;
    }

    public void destroyDisplayImageOptions() {
        this.mOptions = null;
    }

    private void initImageDisplayOptions(Context context2) {
        cnw.O000000o o000000o = new cnw.O000000o();
        o000000o.O00000o = context2.getResources().getDrawable(R.drawable.event_list_item_img_bg);
        o000000o.O00000oO = context2.getResources().getDrawable(R.drawable.event_list_item_img_bg);
        o000000o.O00000oo = context2.getResources().getDrawable(R.drawable.event_list_item_img_bg);
        o000000o.O0000OOo = true;
        o000000o.O0000Oo0 = true;
        o000000o.O0000o00 = true;
        cnw.O000000o O000000o2 = o000000o.O000000o(Bitmap.Config.RGB_565);
        O000000o2.O0000Oo = ImageScaleType.EXACTLY_STRETCHED;
        this.mOptions = O000000o2.O000000o();
    }
}
