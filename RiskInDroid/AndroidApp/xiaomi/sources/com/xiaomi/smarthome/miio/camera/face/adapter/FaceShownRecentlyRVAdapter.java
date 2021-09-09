package com.xiaomi.smarthome.miio.camera.face.adapter;

import _m_j.civ;
import _m_j.cnw;
import _m_j.cnx;
import _m_j.coq;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.miio.camera.face.ClickCallback;
import com.xiaomi.smarthome.miio.camera.face.FaceManager;
import com.xiaomi.smarthome.miio.camera.face.adapter.FaceShownRecentlyRVAdapter;
import com.xiaomi.smarthome.miio.camera.face.model.FaceInfoEx;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class FaceShownRecentlyRVAdapter extends RecyclerView.O000000o<RecyclerView.O000OOo0> {
    public static final String TAG = "FaceShownRecentlyRVAdapter";
    public ClickCallback clickCallBack;
    private Context context;
    public FaceManager faceManager;
    public List<FaceInfoEx> mData = new ArrayList();
    public cnw mOptions;
    private int selectedCount;
    public boolean selectedMod;
    public SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public long getItemId(int i) {
        return (long) i;
    }

    public FaceShownRecentlyRVAdapter(Context context2, ClickCallback clickCallback, FaceManager faceManager2) {
        initImageDisplayOptions(context2);
        this.context = context2;
        this.clickCallBack = clickCallback;
        this.faceManager = faceManager2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.item_face_recently_shown_figures, viewGroup, false));
    }

    public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        ((ItemViewHolder) o000OOo0).bindView(i);
    }

    public void setData(ArrayList<FaceInfoEx> arrayList) {
        this.mData.clear();
        this.selectedCount = 0;
        this.mData.addAll(arrayList);
        notifyDataSetChanged();
    }

    public void addData(ArrayList<FaceInfoEx> arrayList) {
        unSelectAll();
        this.mData.addAll(arrayList);
        notifyDataSetChanged();
    }

    public void clearData() {
        List<FaceInfoEx> list = this.mData;
        if (list != null) {
            list.clear();
            notifyDataSetChanged();
        }
    }

    public List<String> getSelectedFigureIds() {
        ArrayList arrayList = new ArrayList();
        for (FaceInfoEx next : this.mData) {
            if (next.selected) {
                arrayList.add(next.figureId);
            }
        }
        return arrayList;
    }

    public int getItemCount() {
        return this.mData.size();
    }

    public void setSelectedMod(boolean z) {
        this.selectedMod = z;
        if (!this.selectedMod) {
            unSelectAll();
        }
    }

    public int getSelectedCount() {
        return this.selectedCount;
    }

    public void toggolSelected(FaceInfoEx faceInfoEx) {
        faceInfoEx.selected = !faceInfoEx.selected;
        if (faceInfoEx.selected) {
            this.selectedCount++;
        } else {
            this.selectedCount--;
        }
    }

    public void selectAll() {
        for (FaceInfoEx faceInfoEx : this.mData) {
            faceInfoEx.selected = true;
        }
        this.selectedCount = this.mData.size();
        notifyDataSetChanged();
    }

    public void unSelectAll() {
        for (FaceInfoEx faceInfoEx : this.mData) {
            faceInfoEx.selected = false;
        }
        this.selectedCount = 0;
        notifyDataSetChanged();
    }

    public class ItemViewHolder extends RecyclerView.O000OOo0 {
        ImageView faceSelected;
        TextView figureDesc;
        ImageView figureFace;
        TextView figureName;
        ImageView ivArrow;
        TextView tvOperation;

        ItemViewHolder(View view) {
            super(view);
            this.figureFace = (ImageView) view.findViewById(R.id.figure_face);
            this.figureName = (TextView) view.findViewById(R.id.figure_name);
            this.faceSelected = (ImageView) view.findViewById(R.id.face_selected_img);
            this.figureDesc = (TextView) view.findViewById(R.id.figure_desc);
            this.tvOperation = (TextView) view.findViewById(R.id.tv_operation);
            this.ivArrow = (ImageView) view.findViewById(R.id.iv_arrow);
            this.tvOperation.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.miio.camera.face.adapter.$$Lambda$FaceShownRecentlyRVAdapter$ItemViewHolder$EW64cDUX135WgQI1HpPjKGi9Chg */

                public final void onClick(View view) {
                    FaceShownRecentlyRVAdapter.ItemViewHolder.this.lambda$new$0$FaceShownRecentlyRVAdapter$ItemViewHolder(view);
                }
            });
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.miio.camera.face.adapter.$$Lambda$FaceShownRecentlyRVAdapter$ItemViewHolder$Snk4KOsblPpakCvPDCu0K1jxQDs */

                public final void onClick(View view) {
                    FaceShownRecentlyRVAdapter.ItemViewHolder.this.lambda$new$1$FaceShownRecentlyRVAdapter$ItemViewHolder(view);
                }
            });
        }

        public /* synthetic */ void lambda$new$0$FaceShownRecentlyRVAdapter$ItemViewHolder(View view) {
            int layoutPosition = getLayoutPosition();
            if (layoutPosition == -1) {
                layoutPosition = getAdapterPosition();
            }
            FaceShownRecentlyRVAdapter.this.clickCallBack.onRecyclerClick(this, view, layoutPosition);
        }

        public /* synthetic */ void lambda$new$1$FaceShownRecentlyRVAdapter$ItemViewHolder(View view) {
            int layoutPosition = getLayoutPosition();
            if (layoutPosition == -1) {
                layoutPosition = getAdapterPosition();
            }
            String str = FaceShownRecentlyRVAdapter.TAG;
            civ.O000000o(str, layoutPosition + "onClick");
            if (FaceShownRecentlyRVAdapter.this.selectedMod && layoutPosition < FaceShownRecentlyRVAdapter.this.mData.size() - 1) {
                FaceShownRecentlyRVAdapter faceShownRecentlyRVAdapter = FaceShownRecentlyRVAdapter.this;
                faceShownRecentlyRVAdapter.toggolSelected(faceShownRecentlyRVAdapter.mData.get(layoutPosition));
                FaceShownRecentlyRVAdapter.this.notifyItemChanged(layoutPosition);
            }
            FaceShownRecentlyRVAdapter.this.clickCallBack.onRecyclerClick(this, view, layoutPosition);
        }

        /* access modifiers changed from: package-private */
        public void bindView(int i) {
            final FaceInfoEx faceInfoEx = FaceShownRecentlyRVAdapter.this.mData.get(i);
            if (faceInfoEx.figureName != null) {
                this.figureName.setText(faceInfoEx.figureName);
                this.tvOperation.setVisibility(8);
                this.ivArrow.setVisibility(0);
            } else {
                this.figureName.setText((int) R.string.face_unmarked);
                this.tvOperation.setVisibility(0);
                this.ivArrow.setVisibility(8);
            }
            if (FaceShownRecentlyRVAdapter.this.selectedMod) {
                this.faceSelected.setVisibility(0);
                if (faceInfoEx.selected) {
                    this.faceSelected.setImageResource(R.drawable.icon_selected);
                } else {
                    this.faceSelected.setImageResource(R.drawable.icon_unselected);
                }
            } else {
                this.faceSelected.setVisibility(8);
            }
            this.figureFace.setTag(faceInfoEx.coverFaceId);
            if (faceInfoEx.updateTime > 0) {
                this.figureDesc.setText(FaceShownRecentlyRVAdapter.this.simpleDateFormat.format(Long.valueOf(faceInfoEx.updateTime)));
            } else {
                this.figureDesc.setText("");
            }
            if (!TextUtils.isEmpty(faceInfoEx.coverFaceId)) {
                AnonymousClass1 r0 = new coq() {
                    /* class com.xiaomi.smarthome.miio.camera.face.adapter.FaceShownRecentlyRVAdapter.ItemViewHolder.AnonymousClass1 */
                    int failCount = 0;

                    public void onLoadingFailed(String str, View view, FailReason failReason) {
                        int i = this.failCount;
                        if (i <= 3) {
                            this.failCount = i + 1;
                            if (cnx.O000000o().O00000Oo()) {
                                cnx.O000000o().O000000o(FaceShownRecentlyRVAdapter.this.faceManager.getFaceImg(faceInfoEx.coverFaceId), ItemViewHolder.this.figureFace, FaceShownRecentlyRVAdapter.this.mOptions, this);
                            }
                        }
                    }
                };
                if (cnx.O000000o().O00000Oo()) {
                    cnx.O000000o().O000000o(FaceShownRecentlyRVAdapter.this.faceManager.getFaceImg(faceInfoEx.coverFaceId), this.figureFace, FaceShownRecentlyRVAdapter.this.mOptions, r0);
                }
                this.tvOperation.setCompoundDrawablesWithIntrinsicBounds((int) R.drawable.camera_arrow_right, 0, 0, 0);
                this.tvOperation.setBackgroundResource(0);
                this.tvOperation.setText("");
                return;
            }
            if (cnx.O000000o().O00000Oo()) {
                cnx.O000000o().O000000o(FaceShownRecentlyRVAdapter.this.faceManager.getFaceImg(faceInfoEx.faceId), this.figureFace);
            }
            this.tvOperation.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            this.tvOperation.setBackgroundResource(R.drawable.bg_round_corner_12dp);
            this.tvOperation.setText((int) R.string.add_notes);
        }
    }

    public void destroyDisplayImageOptions() {
        this.mOptions = null;
    }

    private void initImageDisplayOptions(Context context2) {
        cnw.O000000o o000000o = new cnw.O000000o();
        o000000o.O0000OOo = true;
        o000000o.O0000Oo0 = true;
        o000000o.O0000o00 = true;
        this.mOptions = o000000o.O000000o(Bitmap.Config.RGB_565).O000000o();
    }
}
