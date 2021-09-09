package com.xiaomi.smarthome.miio.camera.face.adapter;

import _m_j.cnx;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.miio.camera.face.FaceManager;
import com.xiaomi.smarthome.miio.camera.face.model.UnmarkedFaceInfo;
import java.util.ArrayList;
import java.util.List;

public class UnmarkedFaceAdapter extends RecyclerView.O000000o<RecyclerView.O000OOo0> {
    public ClickCallBack clickCallBack;
    public FaceManager faceManager;
    private Context mContext;
    public List<UnmarkedFaceInfo> mData = new ArrayList();

    public interface ClickCallBack {
        void onRecyclerClick(int i);
    }

    public UnmarkedFaceAdapter(Context context, ClickCallBack clickCallBack2, FaceManager faceManager2) {
        this.mContext = context;
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
        return new ItemViewHolder(LayoutInflater.from(this.mContext).inflate((int) R.layout.recycler_item_unmarked_face, viewGroup, false));
    }

    public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        ((ItemViewHolder) o000OOo0).bindView(i);
    }

    public void setData(ArrayList<UnmarkedFaceInfo> arrayList) {
        this.mData.clear();
        this.mData.addAll(arrayList);
        notifyDataSetChanged();
    }

    public void addData(ArrayList<UnmarkedFaceInfo> arrayList) {
        this.mData.addAll(arrayList);
        notifyDataSetChanged();
    }

    public UnmarkedFaceInfo getItem(int i) {
        return this.mData.get(i);
    }

    public int getItemCount() {
        return this.mData.size();
    }

    class ItemViewHolder extends RecyclerView.O000OOo0 {
        ImageView ivFaceImg;
        TextView tvEdit;

        public ItemViewHolder(View view) {
            super(view);
            this.ivFaceImg = (ImageView) view.findViewById(R.id.iv_face_img);
            this.tvEdit = (TextView) view.findViewById(R.id.tv_edit_mark);
            view.setOnClickListener(new View.OnClickListener(UnmarkedFaceAdapter.this) {
                /* class com.xiaomi.smarthome.miio.camera.face.adapter.UnmarkedFaceAdapter.ItemViewHolder.AnonymousClass1 */

                public void onClick(View view) {
                    int layoutPosition = ItemViewHolder.this.getLayoutPosition();
                    if (layoutPosition == -1) {
                        layoutPosition = ItemViewHolder.this.getAdapterPosition();
                    }
                    UnmarkedFaceAdapter.this.clickCallBack.onRecyclerClick(layoutPosition);
                }
            });
        }

        /* access modifiers changed from: package-private */
        public void bindView(int i) {
            UnmarkedFaceInfo unmarkedFaceInfo = UnmarkedFaceAdapter.this.mData.get(i);
            this.tvEdit.setVisibility(0);
            if (TextUtils.isEmpty(unmarkedFaceInfo.faceId)) {
                this.ivFaceImg.setImageResource(R.drawable.icon_face_manager_first_larg);
            } else if (!unmarkedFaceInfo.faceId.equals(this.ivFaceImg.getTag())) {
                this.ivFaceImg.setTag(unmarkedFaceInfo.faceId);
                String faceImg = UnmarkedFaceAdapter.this.faceManager.getFaceImg(unmarkedFaceInfo.faceId);
                if (cnx.O000000o().O00000Oo()) {
                    cnx.O000000o().O000000o(faceImg, this.ivFaceImg);
                }
            }
        }
    }
}
