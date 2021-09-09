package com.mi.global.shop.imageselector;

import _m_j.bzx;
import _m_j.ee;
import _m_j.eh;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.mi.global.shop.activity.BaseActivity;
import com.mi.global.shop.imageselector.bean.Image;
import com.mi.global.shop.widget.CustomButtonView;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.Iterator;

public class ImageViewActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private ViewPager f4869O000000o;
    private O000000o O00000Oo;
    private int O00000o;
    private CustomButtonView O00000o0;
    private int O00000oO;
    public ImageView mCheckMark;
    public int mCurrentPager;
    public ArrayList<Image> mData;
    public ArrayList<String> mResults;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        O000000o((int) R.layout.shop_activity_image);
        this.mBackView.setVisibility(0);
        this.mBackView.setVisibility(0);
        this.mBackView.setOnClickListener(new View.OnClickListener() {
            /* class com.mi.global.shop.imageselector.ImageViewActivity.AnonymousClass1 */

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putStringArrayListExtra("result", ImageViewActivity.this.mResults);
                ImageViewActivity.this.setResult(0, intent);
                ImageViewActivity.this.finish();
            }
        });
        this.mCartView.setVisibility(8);
        setTitle("Preview");
        this.f4869O000000o = (ViewPager) findViewById(R.id.pager);
        this.O00000Oo = new O000000o(getSupportFragmentManager());
        this.f4869O000000o.addOnPageChangeListener(new ViewPager.O0000O0o() {
            /* class com.mi.global.shop.imageselector.ImageViewActivity.AnonymousClass2 */

            public final void onPageScrollStateChanged(int i) {
            }

            public final void onPageScrolled(int i, float f, int i2) {
            }

            public final void onPageSelected(int i) {
                ImageViewActivity imageViewActivity = ImageViewActivity.this;
                imageViewActivity.mCurrentPager = i;
                Image image = imageViewActivity.mData.get(ImageViewActivity.this.mCurrentPager);
                ImageViewActivity.this.mCheckMark.setSelected(false);
                Iterator<String> it = ImageViewActivity.this.mResults.iterator();
                while (it.hasNext()) {
                    if (it.next().equals(image.f4887O000000o)) {
                        ImageViewActivity.this.mCheckMark.setSelected(true);
                    }
                }
            }
        });
        Intent intent = getIntent();
        if (intent != null) {
            this.mCurrentPager = intent.getIntExtra("pager", 0);
            this.O00000o = intent.getIntExtra("count", 0);
            this.O00000oO = intent.getIntExtra("mode", 0);
            this.mData = intent.getParcelableArrayListExtra("data");
            this.mResults = intent.getStringArrayListExtra("results");
        }
        this.O00000o0 = (CustomButtonView) findViewById(R.id.commit);
        if (this.O00000oO == 1) {
            O000000o(this.mResults);
            this.O00000o0.setVisibility(0);
            this.O00000o0.setOnClickListener(new View.OnClickListener() {
                /* class com.mi.global.shop.imageselector.ImageViewActivity.AnonymousClass3 */

                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putStringArrayListExtra("result", ImageViewActivity.this.mResults);
                    ImageViewActivity.this.setResult(-1, intent);
                    ImageViewActivity.this.finish();
                }
            });
        } else {
            this.O00000o0.setVisibility(8);
        }
        this.mCheckMark = (ImageView) findViewById(R.id.check_mark);
        this.mCheckMark.setOnClickListener(new View.OnClickListener() {
            /* class com.mi.global.shop.imageselector.ImageViewActivity.AnonymousClass4 */

            public final void onClick(View view) {
                ImageViewActivity.this.selectImageFromGrid(ImageViewActivity.this.mData.get(ImageViewActivity.this.mCurrentPager));
            }
        });
        this.f4869O000000o.setAdapter(this.O00000Oo);
        this.f4869O000000o.setCurrentItem(this.mCurrentPager, false);
    }

    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putStringArrayListExtra("result", this.mResults);
        setResult(0, intent);
        finish();
    }

    public void selectImageFromGrid(Image image) {
        if (image == null) {
            return;
        }
        if (this.mResults.contains(image.f4887O000000o)) {
            this.mResults.remove(image.f4887O000000o);
            O000000o(this.mResults);
            this.mCheckMark.setSelected(false);
        } else if (this.O00000o == this.mResults.size()) {
            Toast.makeText(this, (int) R.string.mis_msg_amount_limit, 0).show();
        } else {
            this.mResults.add(image.f4887O000000o);
            O000000o(this.mResults);
            this.mCheckMark.setSelected(true);
        }
    }

    private void O000000o(ArrayList<String> arrayList) {
        int i;
        if (arrayList == null || arrayList.size() <= 0) {
            this.O00000o0.setText((int) R.string.shop_mis_action_done);
            this.O00000o0.setEnabled(false);
            i = 0;
        } else {
            i = arrayList.size();
            this.O00000o0.setEnabled(true);
        }
        this.O00000o0.setText(getString(R.string.mis_action_button_string, new Object[]{getString(R.string.shop_mis_action_done), Integer.valueOf(i), Integer.valueOf(this.O00000o)}));
    }

    class O000000o extends eh {
        public O000000o(ee eeVar) {
            super(eeVar);
        }

        public final Fragment getItem(int i) {
            return bzx.O000000o(ImageViewActivity.this.mData.get(i).f4887O000000o);
        }

        public final int getCount() {
            if (ImageViewActivity.this.mData == null) {
                return 0;
            }
            return ImageViewActivity.this.mData.size();
        }
    }
}
