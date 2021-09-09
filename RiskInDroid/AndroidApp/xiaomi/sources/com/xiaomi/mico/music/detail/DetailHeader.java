package com.xiaomi.mico.music.detail;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.squareup.picasso.Transformation;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.IncompleteApiListener;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.common.application.AppCapability;
import com.xiaomi.mico.common.transformation.CropSquareTransformation;
import com.xiaomi.mico.common.util.DisplayUtils;
import com.xiaomi.mico.common.widget.ShadeImageView;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.favourite.FavouriteManager;
import com.xiaomi.smarthome.R;
import java.io.Serializable;

public class DetailHeader extends RelativeLayout {
    private int height;
    ImageView ivLoveBellow;
    ImageView mCover;
    TextView mDescInfo;
    TextView mDescription;
    ShadeImageView mHeaderBackground;
    ImageView mLove;
    private Serializable mMusic;
    TextView mName;
    DetailListTab mTabView;

    /* access modifiers changed from: protected */
    public void updateBabyScheduleIconVisibility(Serializable serializable, boolean z) {
    }

    public DetailHeader(Context context) {
        super(context);
    }

    public DetailHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.mHeaderBackground = (ShadeImageView) findViewById(R.id.detail_header_background);
        this.mCover = (ImageView) findViewById(R.id.detail_cover);
        this.mName = (TextView) findViewById(R.id.detail_name);
        this.mDescription = (TextView) findViewById(R.id.detail_description);
        this.mLove = (ImageView) findViewById(R.id.detail_love);
        this.mLove.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.music.detail.$$Lambda$DetailHeader$eHVs1U52WscN3zbGB_LRBLKO4E */

            public final void onClick(View view) {
                DetailHeader.this.lambda$onFinishInflate$0$DetailHeader(view);
            }
        });
        this.ivLoveBellow = (ImageView) findViewById(R.id.detail_love_bellow);
        this.ivLoveBellow.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.music.detail.$$Lambda$DetailHeader$hK1NZLClASDv0JPkkVqYzjsYFYg */

            public final void onClick(View view) {
                DetailHeader.this.lambda$onFinishInflate$1$DetailHeader(view);
            }
        });
        this.mDescInfo = (TextView) findViewById(R.id.detail_desc_info);
        this.mDescInfo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.music.detail.$$Lambda$DetailHeader$tvjR5LQiECyLbBmdcGZg2DJ0jgM */

            public final void onClick(View view) {
                DetailHeader.this.lambda$onFinishInflate$2$DetailHeader(view);
            }
        });
        this.mTabView = (DetailListTab) findViewById(R.id.detail_list_tab);
    }

    /* renamed from: onClick */
    public void lambda$onFinishInflate$2$DetailHeader(View view) {
        int id = view.getId();
        if (id == R.id.detail_love || id == R.id.detail_love_bellow) {
            final ImageView imageView = id == R.id.detail_love ? this.mLove : this.ivLoveBellow;
            FavouriteManager.getInstance().toggleLike(imageView, this.mMusic, new IncompleteApiListener() {
                /* class com.xiaomi.mico.music.detail.DetailHeader.AnonymousClass1 */

                public void onFailure(ApiError apiError) {
                }

                public void onSuccess() {
                    if (imageView.isSelected()) {
                        Toast.makeText(DetailHeader.this.getContext(), (int) R.string.music_loved, 0).show();
                    } else {
                        Toast.makeText(DetailHeader.this.getContext(), (int) R.string.music_unloved, 0).show();
                    }
                }
            });
        } else if (id == R.id.detail_desc_info && this.mMusic != null) {
            Intent intent = new Intent(getContext(), StationInfoDetailActivity.class);
            intent.putExtra("music", this.mMusic);
            getContext().startActivity(intent);
        }
    }

    /* access modifiers changed from: package-private */
    public void setMusic(Serializable serializable, boolean z) {
        if (!z || !AppCapability.hasCapabilitySongCollection()) {
            this.mLove.setVisibility(8);
            this.ivLoveBellow.setVisibility(8);
        } else {
            this.mLove.setVisibility(0);
            this.ivLoveBellow.setVisibility(0);
        }
        updateMusic(serializable, true);
    }

    /* access modifiers changed from: package-private */
    public void updateMusic(Serializable serializable) {
        updateMusic(serializable, false);
    }

    /* access modifiers changed from: package-private */
    public void updateMusic(Serializable serializable, boolean z) {
        this.mMusic = serializable;
        updateCover(MusicHelper.getCover(serializable), z);
        updateName(MusicHelper.getTitle(serializable));
        updateDescription(MusicHelper.getDescription2(serializable));
        if (AppCapability.hasCapabilitySongCollection()) {
            String likeID = MusicHelper.getLikeID(serializable);
            if (!TextUtils.isEmpty(likeID)) {
                getLikeStatus(MusicHelper.getType(serializable), Long.parseLong(likeID));
            }
        }
    }

    public void updateDescInfo(String str) {
        updateDescInfo(str, false, false);
    }

    public void updateDescInfo(String str, boolean z, boolean z2) {
        if (!TextUtils.isEmpty(str)) {
            this.mDescInfo.setText(str);
            this.mDescInfo.setVisibility(0);
            if (z2) {
                Drawable drawable = getResources().getDrawable(R.drawable.icon_music_detail_desc_arrow);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.mDescInfo.setCompoundDrawables(null, null, drawable, null);
            }
        } else {
            this.mDescInfo.setVisibility(8);
        }
        this.mDescInfo.setEnabled(z);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.mico.music.MusicHelper.loadCover(java.lang.String, android.widget.ImageView, int, int, int, boolean, com.squareup.picasso.Transformation):void
     arg types: [java.lang.String, android.widget.ImageView, ?, ?, ?, int, com.xiaomi.mico.common.transformation.CropSquareTransformation]
     candidates:
      com.xiaomi.mico.music.MusicHelper.loadCover(java.lang.String, android.widget.ImageView, int, int, int, boolean, boolean):void
      com.xiaomi.mico.music.MusicHelper.loadCover(java.lang.String, android.widget.ImageView, int, int, int, boolean, com.squareup.picasso.Transformation):void */
    /* access modifiers changed from: package-private */
    public void updateCover(String str, boolean z) {
        MusicHelper.loadCoverBackground(str, this.mHeaderBackground, z);
        if (!(this.mMusic instanceof Music.Channel) || !TextUtils.isEmpty(str) || !((Music.Channel) this.mMusic).isDefault) {
            MusicHelper.loadCenterCover(str, R.drawable.img_cover_error_corner, R.drawable.img_cover_error_corner, this.mCover, new CropSquareTransformation(DisplayUtils.dip2px(getContext(), 12.0f)), DisplayUtils.dip2px(getContext(), 90.0f));
            return;
        }
        MusicHelper.loadCover(str, this.mCover, (int) R.dimen.music_cover_size_large, (int) R.dimen.music_cover_size_large, (int) R.drawable.img_cover_default_qq, true, (Transformation) new CropSquareTransformation(DisplayUtils.dip2px(getContext(), 12.0f)));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int i5 = this.height;
        this.height = getHeight();
        int i6 = this.height;
        if (i6 != i5) {
            updateHeaderBackgoundHight(i6);
        }
    }

    private void updateHeaderBackgoundHight(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mHeaderBackground.getLayoutParams();
        layoutParams.height = i;
        this.mHeaderBackground.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: package-private */
    public void updateName(CharSequence charSequence) {
        this.mName.setText(charSequence);
    }

    /* access modifiers changed from: package-private */
    public void updateDescription(CharSequence charSequence) {
        this.mDescription.setText(charSequence);
    }

    /* access modifiers changed from: package-private */
    public void updateDescAndDrawable(CharSequence charSequence, int i) {
        this.mDescription.setText(charSequence);
    }

    private void getLikeStatus(int i, long j) {
        FavouriteManager.getInstance().getLikeStatus(i, j, new ApiRequest.Listener<Boolean>() {
            /* class com.xiaomi.mico.music.detail.DetailHeader.AnonymousClass2 */

            public void onFailure(ApiError apiError) {
            }

            public void onSuccess(Boolean bool) {
                DetailHeader.this.mLove.setSelected(bool.booleanValue());
                DetailHeader.this.ivLoveBellow.setSelected(bool.booleanValue());
            }
        });
    }

    public void showTabView() {
        DetailListTab detailListTab = this.mTabView;
        if (detailListTab != null) {
            detailListTab.showTabView();
        }
    }

    public void showPlayAllView() {
        DetailListTab detailListTab = this.mTabView;
        if (detailListTab != null) {
            detailListTab.showPlayAllView();
        }
    }
}
