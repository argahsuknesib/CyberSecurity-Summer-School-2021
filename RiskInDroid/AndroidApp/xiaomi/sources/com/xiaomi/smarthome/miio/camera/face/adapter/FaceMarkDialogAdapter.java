package com.xiaomi.smarthome.miio.camera.face.adapter;

import _m_j.cnx;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.miio.camera.face.FaceManager;
import com.xiaomi.smarthome.miio.camera.face.model.FigureInfo;
import java.util.List;

public class FaceMarkDialogAdapter extends RecyclerView.O000000o<RecyclerView.O000OOo0> {
    public ClickCallBack mClickCallBack;
    private Context mContext;
    public List<FigureInfo> mDatas;
    public FaceManager mFaceManager;

    public interface ClickCallBack {
        void onRecyclerClick(int i, String str);
    }

    public FaceMarkDialogAdapter(Context context, List<FigureInfo> list, ClickCallBack clickCallBack, FaceManager faceManager) {
        this.mContext = context;
        this.mDatas = list;
        this.mClickCallBack = clickCallBack;
        this.mFaceManager = faceManager;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ItemViewHolder(LayoutInflater.from(this.mContext).inflate((int) R.layout.recylcer_item_face_mark_dialog, viewGroup, false));
    }

    public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        ((ItemViewHolder) o000OOo0).bindView(i);
    }

    public int getItemCount() {
        if (this.mDatas.size() >= 6) {
            return 6;
        }
        return this.mDatas.size();
    }

    public FigureInfo getItem(int i) {
        return this.mDatas.get(i);
    }

    class ItemViewHolder extends RecyclerView.O000OOo0 {
        ImageView imageview;
        TextView textview;

        public ItemViewHolder(View view) {
            super(view);
            this.imageview = (ImageView) view.findViewById(R.id.iv);
            this.textview = (TextView) view.findViewById(R.id.f3590tv);
            view.setOnClickListener(new View.OnClickListener(FaceMarkDialogAdapter.this) {
                /* class com.xiaomi.smarthome.miio.camera.face.adapter.FaceMarkDialogAdapter.ItemViewHolder.AnonymousClass1 */

                public void onClick(View view) {
                    int layoutPosition = ItemViewHolder.this.getLayoutPosition();
                    if (layoutPosition == -1) {
                        layoutPosition = ItemViewHolder.this.getAdapterPosition();
                    }
                    FaceMarkDialogAdapter.this.mClickCallBack.onRecyclerClick(layoutPosition, FaceMarkDialogAdapter.this.getItem(layoutPosition).figureName);
                }
            });
        }

        /* access modifiers changed from: package-private */
        public void bindView(int i) {
            FigureInfo figureInfo = FaceMarkDialogAdapter.this.mDatas.get(i);
            this.textview.setText(figureInfo.figureName);
            if (cnx.O000000o().O00000Oo()) {
                cnx.O000000o().O000000o(FaceMarkDialogAdapter.this.mFaceManager.getFaceImg(figureInfo.coverFaceId), this.imageview);
            }
        }
    }
}
