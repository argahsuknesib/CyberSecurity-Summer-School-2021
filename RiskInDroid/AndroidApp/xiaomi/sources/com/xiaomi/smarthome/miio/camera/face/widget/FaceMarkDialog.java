package com.xiaomi.smarthome.miio.camera.face.widget;

import _m_j.cid;
import _m_j.cnr;
import _m_j.cnw;
import _m_j.cnx;
import _m_j.gqb;
import _m_j.gqg;
import _m_j.gri;
import _m_j.hyy;
import _m_j.jz;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.mijia.model.CameraImageLoader;
import com.mijia.model.CameraImageLoaderEx;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.miio.camera.face.FaceManager;
import com.xiaomi.smarthome.miio.camera.face.adapter.FaceMarkDialogAdapter;
import com.xiaomi.smarthome.miio.camera.face.model.FigureInfo;
import com.xiaomi.smarthome.miio.camera.face.util.FaceUtils;
import com.xiaomi.smarthome.utils.DialogBase;
import java.util.ArrayList;
import java.util.List;

public class FaceMarkDialog extends DialogBase {
    private Button btnCancel;
    private Button btnConfirm;
    private ImageView ivFace;
    private Context mContext;
    private List<FigureInfo> mDatas;
    public EditText mEditText;
    private String mFaceId;
    private FaceManager mFaceManager;
    public OnNameSelectListener mOnNameSelectListener;
    private String mfaceName;

    public interface OnNameSelectListener {
        void onNameSelected(String str, boolean z);
    }

    protected FaceMarkDialog(Context context) {
        super(context);
        this.mContext = context;
    }

    public FaceMarkDialog(Context context, String str, List<FigureInfo> list, FaceManager faceManager) {
        this(context);
        this.mFaceId = str;
        this.mDatas = list;
        this.mFaceManager = faceManager;
        initConfig();
    }

    public FaceMarkDialog(Context context, String str, ArrayList<FigureInfo> arrayList, FaceManager faceManager, String str2) {
        this(context);
        this.mFaceId = str;
        this.mDatas = arrayList;
        this.mFaceManager = faceManager;
        this.mfaceName = str2;
        initConfig();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.drawable.InsetDrawable.<init>(android.graphics.drawable.Drawable, int, int, int, int):void}
     arg types: [android.graphics.drawable.ColorDrawable, int, int, int, int]
     candidates:
      ClspMth{android.graphics.drawable.InsetDrawable.<init>(android.graphics.drawable.Drawable, float, float, float, float):void}
      ClspMth{android.graphics.drawable.InsetDrawable.<init>(android.graphics.drawable.Drawable, int, int, int, int):void} */
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = LayoutInflater.from(this.mContext.getApplicationContext()).inflate((int) R.layout.face_input_dialog_custom_view, (ViewGroup) null);
        this.ivFace = (ImageView) inflate.findViewById(R.id.iv_face);
        this.mEditText = (EditText) inflate.findViewById(R.id.input_text);
        if (!TextUtils.isEmpty(this.mfaceName)) {
            this.mEditText.setText(this.mfaceName);
            this.mEditText.setSelection(this.mfaceName.length());
        }
        this.btnCancel = (Button) inflate.findViewById(R.id.btn_cancel);
        this.btnConfirm = (Button) inflate.findViewById(R.id.btn_confirm);
        if (cnx.O000000o().O00000Oo()) {
            cnx.O000000o().O000000o(this.mFaceManager.getFaceImg(this.mFaceId), this.ivFace);
        }
        final ViewPager viewPager = (ViewPager) inflate.findViewById(R.id.viewpager);
        final LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.point_layout);
        List<FigureInfo> list = this.mDatas;
        if (list == null || list.size() <= 0) {
            viewPager.setVisibility(8);
            linearLayout.setVisibility(8);
        } else {
            viewPager.setVisibility(0);
            linearLayout.setVisibility(0);
            List<View> pageList = getPageList();
            FacePagerAdapter facePagerAdapter = new FacePagerAdapter();
            facePagerAdapter.setPageList(pageList);
            viewPager.setAdapter(facePagerAdapter);
            for (final int i = 0; i < pageList.size(); i++) {
                ImageView createPointView = createPointView(this.mContext);
                if (i == 0) {
                    createPointView.setSelected(true);
                }
                createPointView.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.miio.camera.face.widget.FaceMarkDialog.AnonymousClass1 */

                    public void onClick(View view) {
                        viewPager.setCurrentItem(i, true);
                    }
                });
                linearLayout.addView(createPointView);
            }
            viewPager.addOnPageChangeListener(new ViewPager.O0000O0o() {
                /* class com.xiaomi.smarthome.miio.camera.face.widget.FaceMarkDialog.AnonymousClass2 */

                public void onPageScrollStateChanged(int i) {
                }

                public void onPageScrolled(int i, float f, int i2) {
                }

                public void onPageSelected(int i) {
                    for (int i2 = 0; i2 < linearLayout.getChildCount(); i2++) {
                        if (i2 != i) {
                            linearLayout.getChildAt(i2).setSelected(false);
                        } else {
                            linearLayout.getChildAt(i2).setSelected(true);
                        }
                    }
                }
            });
        }
        this.btnCancel.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.camera.face.widget.FaceMarkDialog.AnonymousClass3 */

            public void onClick(View view) {
                FaceMarkDialog.this.dismiss();
            }
        });
        this.btnConfirm.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.camera.face.widget.FaceMarkDialog.AnonymousClass4 */

            public void onClick(View view) {
                String obj = FaceMarkDialog.this.mEditText.getText().toString();
                if (TextUtils.isEmpty(obj)) {
                    gqg.O00000Oo((int) R.string.add_feature_empty_tips);
                } else if (gqb.O000000o((CharSequence) obj) > 10) {
                    gqg.O00000Oo((int) R.string.add_feature_max_tips);
                } else if (FaceUtils.containsEmoji(obj)) {
                    gqg.O00000Oo((int) R.string.no_emoij_tips);
                } else {
                    if (FaceMarkDialog.this.mOnNameSelectListener != null) {
                        FaceMarkDialog.this.mOnNameSelectListener.onNameSelected(obj, false);
                    }
                    FaceMarkDialog.this.dismiss();
                }
            }
        });
        this.mContext.getApplicationContext().getResources();
        inflate.setLayoutParams(new FrameLayout.LayoutParams(-1, -2, 17));
        setContentView(inflate);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) new ColorDrawable(0), gri.O000000o(8.0f), gri.O000000o(8.0f), gri.O000000o(8.0f), gri.O000000o(8.0f)));
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
        initEditText();
        hyy.O000000o(this.mContext, this, 16);
    }

    /* access modifiers changed from: package-private */
    public List<View> getPageList() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < this.mDatas.size(); i++) {
            arrayList2.add(this.mDatas.get(i));
            if (4 == arrayList2.size()) {
                arrayList.add(createPage(this.mContext, arrayList2));
                arrayList2 = new ArrayList();
            }
        }
        if (arrayList2.size() > 0) {
            arrayList.add(createPage(this.mContext, arrayList2));
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public View createPage(Context context, List<FigureInfo> list) {
        RecyclerView recyclerView = new RecyclerView(context);
        recyclerView.setOverScrollMode(2);
        recyclerView.setLayoutManager(new GridLayoutManager(this.mContext, 4));
        recyclerView.setAdapter(new FaceMarkDialogAdapter(this.mContext.getApplicationContext(), list, new FaceMarkDialogAdapter.ClickCallBack() {
            /* class com.xiaomi.smarthome.miio.camera.face.widget.FaceMarkDialog.AnonymousClass5 */

            public void onRecyclerClick(int i, String str) {
                if (FaceMarkDialog.this.mOnNameSelectListener != null) {
                    FaceMarkDialog.this.mOnNameSelectListener.onNameSelected(str, true);
                }
                FaceMarkDialog.this.dismiss();
            }
        }, this.mFaceManager));
        return recyclerView;
    }

    /* access modifiers changed from: package-private */
    public ImageView createPointView(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.face_point_drawable);
        imageView.setPadding(gri.O000000o(4.0f), 0, gri.O000000o(4.0f), 0);
        return imageView;
    }

    private void initEditText() {
        this.mEditText.addTextChangedListener(new TextWatcher() {
            /* class com.xiaomi.smarthome.miio.camera.face.widget.FaceMarkDialog.AnonymousClass6 */

            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                int O00000Oo;
                if (gqb.O000000o(charSequence) > 10 && (O00000Oo = gqb.O00000Oo(charSequence)) < charSequence.length()) {
                    FaceMarkDialog.this.mEditText.setText(charSequence.subSequence(0, O00000Oo));
                    FaceMarkDialog.this.mEditText.setSelection(O00000Oo);
                }
            }
        });
    }

    private void initConfig() {
        if (!cnx.O000000o().O00000Oo()) {
            Context applicationContext = this.mContext.getApplicationContext();
            ImageLoaderConfiguration.Builder builder = new ImageLoaderConfiguration.Builder(applicationContext);
            builder.O000000o();
            builder.O0000o0 = true;
            builder.O000000o(new cnr());
            builder.O00000Oo();
            builder.O000000o(QueueProcessingType.LIFO);
            DeviceStat deviceStat = this.mFaceManager.getDevice().deviceStat();
            if (cid.O000000o(deviceStat, deviceStat.did).O00000o()) {
                builder.O0000oO0 = new CameraImageLoaderEx(applicationContext);
            } else {
                builder.O0000oO0 = new CameraImageLoader(applicationContext);
            }
            builder.O0000oOo = true;
            cnw.O000000o o000000o = new cnw.O000000o();
            o000000o.O0000OOo = true;
            o000000o.O0000Oo0 = true;
            builder.O0000oOO = o000000o.O000000o(Bitmap.Config.RGB_565).O000000o();
            cnx.O000000o().O000000o(builder.O00000o0());
        }
    }

    public void setOnNameSelectListener(OnNameSelectListener onNameSelectListener) {
        this.mOnNameSelectListener = onNameSelectListener;
    }

    public class FacePagerAdapter extends jz {
        List<View> mPageList = new ArrayList();

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        public FacePagerAdapter() {
        }

        public void setPageList(List<View> list) {
            this.mPageList.clear();
            this.mPageList.addAll(list);
            notifyDataSetChanged();
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            viewGroup.addView(this.mPageList.get(i));
            return this.mPageList.get(i);
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView(this.mPageList.get(i));
        }

        public int getCount() {
            return this.mPageList.size();
        }
    }
}
