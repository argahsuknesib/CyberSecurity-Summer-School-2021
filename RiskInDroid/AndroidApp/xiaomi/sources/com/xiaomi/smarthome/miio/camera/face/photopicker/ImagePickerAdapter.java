package com.xiaomi.smarthome.miio.camera.face.photopicker;

import _m_j.cnx;
import _m_j.gqg;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

public class ImagePickerAdapter extends RecyclerView.O000000o<ImagePickerViewHolder> {
    public int limit = 1;
    private Context mContext;
    private List<Image> mData = new ArrayList();
    public OnImageClickListener mOnImageClickListener;
    public List<Image> mSelectedList = new ArrayList();

    public interface OnImageClickListener {
        void onImageClick(Image image);
    }

    public ImagePickerAdapter(Context context) {
        this.mContext = context;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public ImagePickerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ImagePickerViewHolder(LayoutInflater.from(this.mContext).inflate((int) R.layout.recycler_item_img_chooser, viewGroup, false));
    }

    public void onBindViewHolder(ImagePickerViewHolder imagePickerViewHolder, int i) {
        imagePickerViewHolder.bindView(i);
    }

    public int getItemCount() {
        return this.mData.size();
    }

    public void setData(List<Image> list) {
        this.mData = list;
        notifyDataSetChanged();
    }

    public Image getItem(int i) {
        return this.mData.get(i);
    }

    public void setOnImageClickListener(OnImageClickListener onImageClickListener) {
        this.mOnImageClickListener = onImageClickListener;
    }

    public void setLimit(int i) {
        this.limit = i;
    }

    public List<Image> getSelectImages() {
        return this.mSelectedList;
    }

    public void release() {
        this.mSelectedList.clear();
        this.mData.clear();
    }

    class ImagePickerViewHolder extends RecyclerView.O000OOo0 {
        private ImageView imageView;
        public ImageView ivPick;

        public ImagePickerViewHolder(View view) {
            super(view);
            this.imageView = (ImageView) view.findViewById(R.id.iv_image);
            this.ivPick = (ImageView) view.findViewById(R.id.iv_picker);
        }

        public void bindView(int i) {
            final Image item = ImagePickerAdapter.this.getItem(i);
            if (ImagePickerAdapter.this.mSelectedList.contains(item)) {
                this.ivPick.setImageResource(R.drawable.icon_selected);
            } else {
                this.ivPick.setImageResource(R.drawable.icon_unselected);
            }
            this.imageView.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.miio.camera.face.photopicker.ImagePickerAdapter.ImagePickerViewHolder.AnonymousClass1 */

                public void onClick(View view) {
                    if (ImagePickerAdapter.this.mSelectedList.contains(item)) {
                        ImagePickerViewHolder.this.ivPick.setImageResource(R.drawable.icon_unselected);
                        ImagePickerAdapter.this.mSelectedList.remove(item);
                    } else if (ImagePickerAdapter.this.mSelectedList.size() >= ImagePickerAdapter.this.limit) {
                        gqg.O00000Oo((int) R.string.pick_photo_limit_tips);
                        return;
                    } else {
                        ImagePickerViewHolder.this.ivPick.setImageResource(R.drawable.icon_selected);
                        ImagePickerAdapter.this.mSelectedList.add(item);
                    }
                    if (ImagePickerAdapter.this.mOnImageClickListener != null) {
                        ImagePickerAdapter.this.mOnImageClickListener.onImageClick(item);
                    }
                }
            });
            if (cnx.O000000o().O00000Oo()) {
                cnx O000000o2 = cnx.O000000o();
                O000000o2.O000000o("file://" + item.path, this.imageView);
            }
        }
    }
}
