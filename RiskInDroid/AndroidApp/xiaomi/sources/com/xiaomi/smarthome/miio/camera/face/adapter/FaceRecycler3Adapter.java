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
import com.xiaomi.smarthome.miio.camera.face.adapter.FaceRecycler3Adapter;
import com.xiaomi.smarthome.miio.camera.face.model.FigureInfo;
import java.util.ArrayList;
import java.util.List;

public class FaceRecycler3Adapter extends RecyclerView.O000000o<RecyclerView.O000OOo0> {
    public static final String TAG = "FaceRecycler3Adapter";
    public ClickCallback clickCallBack;
    public Context context;
    public FaceManager faceManager;
    public List<FigureInfo> mData = new ArrayList();
    public cnw mOptions;
    private int selectedCount;
    public boolean selectedMode;

    public long getItemId(int i) {
        return (long) i;
    }

    public FaceRecycler3Adapter(Context context2, ClickCallback clickCallback, FaceManager faceManager2) {
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
        return new ItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.item_face_figures3, viewGroup, false));
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

    public void setSelectedMode(boolean z) {
        this.selectedMode = z;
        if (!this.selectedMode) {
            unSelectAll();
        }
        notifyDataSetChanged();
    }

    public boolean getSelectedMode() {
        return this.selectedMode;
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

    public boolean isSelectAll() {
        for (FigureInfo next : this.mData) {
            if (!TextUtils.isEmpty(next.figureId) && !next.selected) {
                return false;
            }
        }
        return true;
    }

    public void selectAll() {
        for (FigureInfo figureInfo : this.mData) {
            figureInfo.selected = true;
        }
        this.selectedCount = this.mData.size();
        notifyDataSetChanged();
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
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.miio.camera.face.adapter.$$Lambda$FaceRecycler3Adapter$ItemViewHolder$ivjKYLsXwj6Sqkmbvc8zdyaQsgI */

                public final void onClick(View view) {
                    FaceRecycler3Adapter.ItemViewHolder.this.lambda$new$0$FaceRecycler3Adapter$ItemViewHolder(view);
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() {
                /* class com.xiaomi.smarthome.miio.camera.face.adapter.$$Lambda$FaceRecycler3Adapter$ItemViewHolder$hCRAkDRGYk0fyW9QaIrmbe7IJk4 */

                public final boolean onLongClick(View view) {
                    return FaceRecycler3Adapter.ItemViewHolder.this.lambda$new$1$FaceRecycler3Adapter$ItemViewHolder(view);
                }
            });
        }

        public /* synthetic */ void lambda$new$0$FaceRecycler3Adapter$ItemViewHolder(View view) {
            int layoutPosition = getLayoutPosition();
            if (layoutPosition == -1) {
                layoutPosition = getAdapterPosition();
            }
            String str = FaceRecycler3Adapter.TAG;
            civ.O000000o(str, layoutPosition + "onClick");
            if (FaceRecycler3Adapter.this.selectedMode && layoutPosition < FaceRecycler3Adapter.this.mData.size() - 1) {
                FaceRecycler3Adapter faceRecycler3Adapter = FaceRecycler3Adapter.this;
                faceRecycler3Adapter.toggolSelected(faceRecycler3Adapter.mData.get(layoutPosition));
                FaceRecycler3Adapter.this.notifyItemChanged(layoutPosition);
            }
            FaceRecycler3Adapter.this.clickCallBack.onRecyclerClick(this, view, layoutPosition);
        }

        public /* synthetic */ boolean lambda$new$1$FaceRecycler3Adapter$ItemViewHolder(View view) {
            int layoutPosition = getLayoutPosition();
            if (layoutPosition >= FaceRecycler3Adapter.this.mData.size() - 1) {
                return true;
            }
            if (layoutPosition == -1) {
                layoutPosition = getAdapterPosition();
            }
            String str = FaceRecycler3Adapter.TAG;
            civ.O000000o(str, layoutPosition + "onLongClick");
            FaceRecycler3Adapter faceRecycler3Adapter = FaceRecycler3Adapter.this;
            faceRecycler3Adapter.toggolSelected(faceRecycler3Adapter.mData.get(layoutPosition));
            FaceRecycler3Adapter.this.notifyDataSetChanged();
            FaceRecycler3Adapter.this.clickCallBack.onRecyclerLongClick(this, view, layoutPosition);
            return true;
        }

        /* access modifiers changed from: package-private */
        public void bindView(int i) {
            if (i >= FaceRecycler3Adapter.this.mData.size() - 1) {
                this.faceSelected.setVisibility(8);
                this.figureName.setText(FaceRecycler3Adapter.this.context.getString(R.string.add));
                this.figureFace.setImageResource(R.drawable.face_add_item_icon_round);
                return;
            }
            final FigureInfo figureInfo = FaceRecycler3Adapter.this.mData.get(i);
            this.figureName.setText(figureInfo.figureName);
            if (FaceRecycler3Adapter.this.selectedMode) {
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
                AnonymousClass1 r0 = new coq() {
                    /* class com.xiaomi.smarthome.miio.camera.face.adapter.FaceRecycler3Adapter.ItemViewHolder.AnonymousClass1 */
                    int failCount = 0;

                    public void onLoadingFailed(String str, View view, FailReason failReason) {
                        int i = this.failCount;
                        if (i <= 3) {
                            this.failCount = i + 1;
                            if (cnx.O000000o().O00000Oo()) {
                                cnx.O000000o().O000000o(FaceRecycler3Adapter.this.faceManager.getFaceImg(figureInfo.coverFaceId), ItemViewHolder.this.figureFace, FaceRecycler3Adapter.this.mOptions, this);
                            }
                        }
                    }
                };
                if (cnx.O000000o().O00000Oo()) {
                    cnx.O000000o().O000000o(FaceRecycler3Adapter.this.faceManager.getFaceImg(figureInfo.coverFaceId), this.figureFace, FaceRecycler3Adapter.this.mOptions, r0);
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
