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
import com.xiaomi.smarthome.miio.camera.face.FaceManager;
import com.xiaomi.smarthome.miio.camera.face.model.FigureInfo;
import java.util.ArrayList;
import java.util.List;

public class FaceRecyclerAdapter extends RecyclerView.O000000o<RecyclerView.O000OOo0> {
    public static final String TAG = "FaceRecyclerAdapter";
    public ClickCallBack clickCallBack;
    public Context context;
    public FaceManager faceManager;
    public List<FigureInfo> mData = new ArrayList();
    public cnw mOptions;
    private int selectedCount;
    public boolean selectedMod;

    public interface ClickCallBack {
        void onRecyclerClick(int i);

        void onRecyclerLongClick(int i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public FaceRecyclerAdapter(Context context2, ClickCallBack clickCallBack2, FaceManager faceManager2) {
        initImageDisplayOptions(context2);
        this.context = context2;
        this.clickCallBack = clickCallBack2;
        this.faceManager = faceManager2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.item_face_figures, viewGroup, false));
    }

    public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        ((ItemViewHolder) o000OOo0).bindView(i);
    }

    public void setData(ArrayList<FigureInfo> arrayList) {
        this.mData.clear();
        this.selectedCount = 0;
        this.mData.addAll(arrayList);
        this.mData.add(new FigureInfo());
        notifyDataSetChanged();
    }

    public void addData(ArrayList<FigureInfo> arrayList) {
        unSelectAll();
        this.mData.addAll(arrayList);
        notifyDataSetChanged();
    }

    public List<String> getSelectedFigureIds() {
        ArrayList arrayList = new ArrayList();
        for (FigureInfo next : this.mData) {
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
        notifyDataSetChanged();
    }

    public boolean getSelectedMode() {
        return this.selectedMod;
    }

    public int getSelectedCount() {
        return this.selectedCount;
    }

    public void toggolSelected(FigureInfo figureInfo) {
        figureInfo.selected = !figureInfo.selected;
        if (figureInfo.selected) {
            this.selectedCount++;
        } else {
            this.selectedCount--;
        }
    }

    public void selectAll() {
        for (FigureInfo figureInfo : this.mData) {
            figureInfo.selected = true;
        }
        this.selectedCount = this.mData.size();
        notifyDataSetChanged();
    }

    public boolean isSelectAll() {
        for (FigureInfo next : this.mData) {
            if (!TextUtils.isEmpty(next.figureId) && !next.selected) {
                return false;
            }
        }
        return true;
    }

    public void unSelectAll() {
        for (FigureInfo figureInfo : this.mData) {
            figureInfo.selected = false;
        }
        this.selectedCount = 0;
        notifyDataSetChanged();
    }

    class ItemViewHolder extends RecyclerView.O000OOo0 {
        ImageView faceSelected;
        ImageView figureFace;
        TextView figureName;

        ItemViewHolder(View view) {
            super(view);
            this.figureFace = (ImageView) view.findViewById(R.id.figure_face);
            this.figureName = (TextView) view.findViewById(R.id.figure_name);
            this.faceSelected = (ImageView) view.findViewById(R.id.face_selected_img);
            view.setOnClickListener(new View.OnClickListener(FaceRecyclerAdapter.this) {
                /* class com.xiaomi.smarthome.miio.camera.face.adapter.FaceRecyclerAdapter.ItemViewHolder.AnonymousClass1 */

                public void onClick(View view) {
                    int layoutPosition = ItemViewHolder.this.getLayoutPosition();
                    if (layoutPosition == -1) {
                        layoutPosition = ItemViewHolder.this.getAdapterPosition();
                    }
                    String str = FaceRecyclerAdapter.TAG;
                    civ.O000000o(str, layoutPosition + "onClick");
                    if (FaceRecyclerAdapter.this.selectedMod && layoutPosition < FaceRecyclerAdapter.this.mData.size() - 1) {
                        FaceRecyclerAdapter.this.toggolSelected(FaceRecyclerAdapter.this.mData.get(layoutPosition));
                        FaceRecyclerAdapter.this.notifyItemChanged(layoutPosition);
                    }
                    FaceRecyclerAdapter.this.clickCallBack.onRecyclerClick(layoutPosition);
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener(FaceRecyclerAdapter.this) {
                /* class com.xiaomi.smarthome.miio.camera.face.adapter.FaceRecyclerAdapter.ItemViewHolder.AnonymousClass2 */

                public boolean onLongClick(View view) {
                    int layoutPosition = ItemViewHolder.this.getLayoutPosition();
                    if (layoutPosition >= FaceRecyclerAdapter.this.mData.size() - 1) {
                        return true;
                    }
                    if (layoutPosition == -1) {
                        layoutPosition = ItemViewHolder.this.getAdapterPosition();
                    }
                    String str = FaceRecyclerAdapter.TAG;
                    civ.O000000o(str, layoutPosition + "onLongClick");
                    FaceRecyclerAdapter.this.toggolSelected(FaceRecyclerAdapter.this.mData.get(layoutPosition));
                    FaceRecyclerAdapter.this.notifyDataSetChanged();
                    FaceRecyclerAdapter.this.clickCallBack.onRecyclerLongClick(layoutPosition);
                    return true;
                }
            });
        }

        /* access modifiers changed from: package-private */
        public void bindView(int i) {
            if (i >= FaceRecyclerAdapter.this.mData.size() - 1) {
                this.faceSelected.setVisibility(8);
                this.figureName.setText(FaceRecyclerAdapter.this.context.getString(R.string.add));
                this.figureFace.setImageResource(R.drawable.face_add_item_icon_round);
                return;
            }
            final FigureInfo figureInfo = FaceRecyclerAdapter.this.mData.get(i);
            this.figureName.setText(figureInfo.figureName);
            if (FaceRecyclerAdapter.this.selectedMod) {
                this.faceSelected.setVisibility(0);
                if (figureInfo.selected) {
                    this.faceSelected.setImageResource(R.drawable.icon_selected);
                } else {
                    this.faceSelected.setImageResource(R.drawable.icon_unselected);
                }
            } else {
                this.faceSelected.setVisibility(8);
            }
            this.figureFace.setTag(figureInfo.coverFaceId);
            if (!TextUtils.isEmpty(figureInfo.coverFaceId)) {
                AnonymousClass3 r0 = new coq() {
                    /* class com.xiaomi.smarthome.miio.camera.face.adapter.FaceRecyclerAdapter.ItemViewHolder.AnonymousClass3 */
                    int failCount = 0;

                    public void onLoadingFailed(String str, View view, FailReason failReason) {
                        int i = this.failCount;
                        if (i <= 3) {
                            this.failCount = i + 1;
                            if (cnx.O000000o().O00000Oo()) {
                                cnx.O000000o().O000000o(FaceRecyclerAdapter.this.faceManager.getFaceImg(figureInfo.coverFaceId), ItemViewHolder.this.figureFace, FaceRecyclerAdapter.this.mOptions, this);
                            }
                        }
                    }
                };
                if (cnx.O000000o().O00000Oo()) {
                    cnx.O000000o().O000000o(FaceRecyclerAdapter.this.faceManager.getFaceImg(figureInfo.coverFaceId), this.figureFace, FaceRecyclerAdapter.this.mOptions, r0);
                }
            }
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
