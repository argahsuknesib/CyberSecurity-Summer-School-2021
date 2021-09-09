package com.xiaomi.mico.music.patchwall.group;

import _m_j.gsy;
import _m_j.hxi;
import _m_j.hxk;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;
import com.xiaomi.mico.api.model.IntelligentModel;
import com.xiaomi.mico.common.transformation.CropSquareTransformation;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.common.util.DisplayUtils;
import com.xiaomi.mico.common.widget.RatioBanner;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.patchwall.IntelligentMoreActivity;
import com.xiaomi.mico.music.patchwall.group.IntelligentViewHolderFactory;
import com.xiaomi.smarthome.R;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;
import java.util.ArrayList;
import java.util.List;

public class IntelligentViewHolderFactory {
    public static SparseIntArray sViewHolder;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewHolder = sparseIntArray;
        sparseIntArray.put(0, 1);
        sViewHolder.put(1, R.layout.mico_intelligent_banner_view);
        sViewHolder.put(2, R.layout.mico_intelligent_kingkong_view);
        sViewHolder.put(3, R.layout.mico_intelligent_single_pic_view);
        sViewHolder.put(4, R.layout.mico_view_patch_intelligent);
        sViewHolder.put(5, R.layout.mico_intelligent_single_pic_view);
        sViewHolder.put(6, R.layout.mico_intelligent_info_stream_view);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public static IntelligentBaseViewHolder createGroupViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        IntelligentHeaderViewHolder intelligentHeaderViewHolder = new IntelligentHeaderViewHolder(layoutInflater.inflate((int) R.layout.mico_select_view_patchwall_title, viewGroup, false));
        gsy.O00000Oo("IntelligentViewHolderFactory", "createGroupViewHolder");
        return intelligentHeaderViewHolder;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public static IntelligentBaseViewHolder createChildViewHolder(int i, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        gsy.O00000Oo("IntelligentViewHolderFactory", "createChildViewHolder type == ".concat(String.valueOf(i)));
        View inflate = layoutInflater.inflate(sViewHolder.get(i), viewGroup, false);
        switch (i) {
            case 1:
                return new BannerViewHolder(inflate);
            case 2:
                return new IntelligentKingKongViewHolder(inflate);
            case 3:
            case 5:
                return new SinglePicViewHolder(inflate, i);
            case 4:
                return new OneDrivenTwoViewHolder(inflate);
            case 6:
                return new InfoStreamViewHolder(inflate);
            default:
                gsy.O00000Oo("IntelligentViewHolderFactory", "createViewHolder err: type == ".concat(String.valueOf(i)));
                return null;
        }
    }

    public static class BannerViewHolder extends IntelligentBaseViewHolder {
        RatioBanner banner;
        public List<IntelligentModel.ListBean.CardsBean> banners;

        public BannerViewHolder(View view) {
            super(view);
            this.banner = (RatioBanner) view.findViewById(R.id.mico_select_banner);
            this.banner.setCorner(12.0f);
            this.banner.setImageLoader(new ImageLoader() {
                /* class com.xiaomi.mico.music.patchwall.group.IntelligentViewHolderFactory.BannerViewHolder.AnonymousClass2 */

                public void displayImage(Context context, Object obj, ImageView imageView) {
                    String picture = ((IntelligentModel.ListBean.CardsBean) obj).getPicture();
                    if (!TextUtils.isEmpty(picture)) {
                        Picasso.get().load(picture).placeholder((int) R.drawable.img_banner_music).error((int) R.drawable.img_banner_music).noFade().into(imageView);
                        return;
                    }
                    Picasso.get().load((int) R.drawable.img_banner_music).memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE).placeholder((int) R.drawable.img_banner_music).into(imageView);
                }
            }).setOnBannerListener(new OnBannerListener() {
                /* class com.xiaomi.mico.music.patchwall.group.IntelligentViewHolderFactory.BannerViewHolder.AnonymousClass1 */

                public void OnBannerClick(int i) {
                    BannerViewHolder bannerViewHolder = BannerViewHolder.this;
                    bannerViewHolder.onClickView(bannerViewHolder.banners.get(i).getJumpLink());
                    hxi.O00000o.f952O000000o.O000000o("content_intelligence_banner", "position", Integer.valueOf(i + 1));
                    if (BannerViewHolder.this.mItemClickListener != null) {
                        BannerViewHolder.this.mItemClickListener.onItemClicked(i);
                    }
                }
            });
        }

        public void bindView(List<IntelligentModel.ListBean.CardsBean> list, RecyclerView.O000000o o000000o) {
            if (!ContainerUtil.equals(this.banners, list)) {
                this.banners = list;
                this.banner.update(this.banners);
                if (!(o000000o instanceof RatioBanner.OnStateChange) || !((RatioBanner.OnStateChange) o000000o).isActivate()) {
                    this.banner.stopAutoPlay();
                } else {
                    this.banner.startAutoPlay();
                }
            }
        }
    }

    public static class SinglePicViewHolder extends IntelligentBaseViewHolder {
        ImageView img = ((ImageView) this.itemView.findViewById(R.id.mico_intelligent_iv_single_pic));
        TextView mMainTitle = ((TextView) this.itemView.findViewById(R.id.main_title));
        TextView mVoteUserAmount = ((TextView) this.itemView.findViewById(R.id.tv_vote_user_amount));

        public SinglePicViewHolder(View view, int i) {
            super(view);
            Context context;
            float f;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.img.getLayoutParams();
            ImageView imageView = this.img;
            if (i == 5) {
                context = imageView.getContext();
                f = 180.0f;
            } else {
                context = imageView.getContext();
                f = 158.0f;
            }
            imageView.setMinimumHeight(DisplayUtils.dip2px(context, f));
            layoutParams.height = (int) ((((float) DisplayUtils.px2dip(this.img.getContext(), (float) this.img.getMinimumHeight())) / 330.0f) * ((float) (DisplayUtils.getScreenWidthPixels(this.img.getContext()) - DisplayUtils.dip2px(this.img.getContext(), 30.0f))));
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.xiaomi.mico.music.MusicHelper.loadPatchWallCropSquareCover(java.lang.String, android.widget.ImageView, int, int, boolean):void
         arg types: [java.lang.String, android.widget.ImageView, ?, int, int]
         candidates:
          com.xiaomi.mico.music.MusicHelper.loadPatchWallCropSquareCover(java.lang.String, android.widget.ImageView, int, int, int):void
          com.xiaomi.mico.music.MusicHelper.loadPatchWallCropSquareCover(java.lang.String, android.widget.ImageView, int, int, boolean):void */
        public void bindView(List<IntelligentModel.ListBean.CardsBean> list, RecyclerView.O000000o o000000o) {
            if (list.size() > 0 && list.get(0) != null && o000000o != null) {
                IntelligentModel.ListBean.CardsBean cardsBean = list.get(0);
                this.img.setOnClickListener(new View.OnClickListener(cardsBean) {
                    /* class com.xiaomi.mico.music.patchwall.group.$$Lambda$IntelligentViewHolderFactory$SinglePicViewHolder$YLqmAX3FHUvRL0RESpZxYI9aRbw */
                    private final /* synthetic */ IntelligentModel.ListBean.CardsBean f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        IntelligentViewHolderFactory.SinglePicViewHolder.this.lambda$bindView$0$IntelligentViewHolderFactory$SinglePicViewHolder(this.f$1, view);
                    }
                });
                MusicHelper.loadPatchWallCropSquareCover(cardsBean.getPicture(), this.img, (int) R.drawable.mico_img_cover_default_singleimg, this.borderRadius, true);
                String str = "";
                this.mVoteUserAmount.setText(TextUtils.isEmpty(cardsBean.getPicContent()) ? str : cardsBean.getPicContent());
                TextView textView = this.mMainTitle;
                if (!TextUtils.isEmpty(cardsBean.getPicTitle())) {
                    str = cardsBean.getPicTitle();
                }
                textView.setText(str);
            }
        }

        public /* synthetic */ void lambda$bindView$0$IntelligentViewHolderFactory$SinglePicViewHolder(IntelligentModel.ListBean.CardsBean cardsBean, View view) {
            onClickView(cardsBean.getJumpLink());
            if (this.mItemClickListener != null) {
                this.mItemClickListener.onItemClicked(cardsBean.getPosition());
            }
        }
    }

    public static class OneDrivenTwoViewHolder extends IntelligentBaseViewHolder {
        ImageView mBigViewImg = ((ImageView) this.itemView.findViewById(R.id.mico_intelligent_row_one_img));
        View mLeftView = this.itemView.findViewById(R.id.mico_intelligent_column_left_layout);
        ImageView mLeftViewImg = ((ImageView) this.itemView.findViewById(R.id.mico_intelligent_column_two_left_img));
        TextView mLeftViewSubTitle = ((TextView) this.itemView.findViewById(R.id.mico_intelligent_row_two_left_subtitle));
        TextView mLeftViewThirdTitle = ((TextView) this.itemView.findViewById(R.id.mico_intelligent_row_two_left_thirdtitle));
        TextView mLeftViewTitle = ((TextView) this.itemView.findViewById(R.id.mico_intelligent_row_two_left_title));
        View mRightView = this.itemView.findViewById(R.id.mico_intelligent_column_right_layout);
        ImageView mRightViewImg = ((ImageView) this.itemView.findViewById(R.id.mico_intelligent_column_two_right_img));
        TextView mRightViewSubTitle = ((TextView) this.itemView.findViewById(R.id.mico_intelligent_row_two_right_subtitle));
        TextView mRightViewThirdTitle = ((TextView) this.itemView.findViewById(R.id.mico_intelligent_row_two_right_thirdtitle));
        TextView mRightViewTitle = ((TextView) this.itemView.findViewById(R.id.mico_intelligent_row_two_right_title));
        TextView mTopViewSubTitle = ((TextView) this.itemView.findViewById(R.id.mico_intelligent_row_one_tv_sub));
        TextView mTopViewTitle = ((TextView) this.itemView.findViewById(R.id.mico_intelligent_row_one_tv_main));

        public OneDrivenTwoViewHolder(View view) {
            super(view);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.xiaomi.mico.music.MusicHelper.loadPatchWallCropSquareCover(java.lang.String, android.widget.ImageView, int, int, boolean):void
         arg types: [java.lang.String, android.widget.ImageView, ?, int, int]
         candidates:
          com.xiaomi.mico.music.MusicHelper.loadPatchWallCropSquareCover(java.lang.String, android.widget.ImageView, int, int, int):void
          com.xiaomi.mico.music.MusicHelper.loadPatchWallCropSquareCover(java.lang.String, android.widget.ImageView, int, int, boolean):void */
        public void bindView(List<IntelligentModel.ListBean.CardsBean> list, RecyclerView.O000000o o000000o) {
            if (list != null) {
                IntelligentModel.ListBean.CardsBean cardsBean = list.get(0);
                if (cardsBean != null) {
                    this.mBigViewImg.setOnClickListener(new View.OnClickListener(cardsBean) {
                        /* class com.xiaomi.mico.music.patchwall.group.$$Lambda$IntelligentViewHolderFactory$OneDrivenTwoViewHolder$sQ6jo8kZCrJ3wh13Z9BsUnFouQ */
                        private final /* synthetic */ IntelligentModel.ListBean.CardsBean f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void onClick(View view) {
                            IntelligentViewHolderFactory.OneDrivenTwoViewHolder.this.lambda$bindView$0$IntelligentViewHolderFactory$OneDrivenTwoViewHolder(this.f$1, view);
                        }
                    });
                    MusicHelper.loadPatchWallCropSquareCover(cardsBean.getPicture(), this.mBigViewImg, (int) R.drawable.img_cover_default_intelligent_330_180, this.borderRadius, true);
                    String str = "";
                    this.mTopViewSubTitle.setText(TextUtils.isEmpty(cardsBean.getPicContent()) ? str : cardsBean.getPicContent());
                    TextView textView = this.mTopViewTitle;
                    if (!TextUtils.isEmpty(cardsBean.getPicTitle())) {
                        str = cardsBean.getPicTitle();
                    }
                    textView.setText(str);
                }
                for (int i = 1; i < list.size(); i++) {
                    if (i == 1) {
                        updateLeftChildView(list.get(1));
                    } else if (i == 2) {
                        updateRightChildView(list.get(2));
                    } else {
                        return;
                    }
                }
            }
        }

        public /* synthetic */ void lambda$bindView$0$IntelligentViewHolderFactory$OneDrivenTwoViewHolder(IntelligentModel.ListBean.CardsBean cardsBean, View view) {
            onClickView(cardsBean.getJumpLink());
            hxi.O00000o.O000000o(1, "GOOD_ITEM", cardsBean.getMainTitle());
            if (this.mItemClickListener != null) {
                this.mItemClickListener.onItemClicked(cardsBean.getPosition());
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.xiaomi.mico.music.MusicHelper.loadPatchWallCropSquareCover(java.lang.String, android.widget.ImageView, int, int, boolean):void
         arg types: [java.lang.String, android.widget.ImageView, ?, int, int]
         candidates:
          com.xiaomi.mico.music.MusicHelper.loadPatchWallCropSquareCover(java.lang.String, android.widget.ImageView, int, int, int):void
          com.xiaomi.mico.music.MusicHelper.loadPatchWallCropSquareCover(java.lang.String, android.widget.ImageView, int, int, boolean):void */
        private void updateLeftChildView(IntelligentModel.ListBean.CardsBean cardsBean) {
            String str = "";
            if (cardsBean != null) {
                MusicHelper.loadPatchWallCropSquareCover(cardsBean.getPicture(), this.mLeftViewImg, (int) R.drawable.img_cover_default_rectangle, this.borderRadius, true);
                this.mLeftViewTitle.setText(cardsBean.getMainTitle());
                this.mLeftViewSubTitle.setText(cardsBean.getSubTitle());
                this.mLeftView.setOnClickListener(new View.OnClickListener(cardsBean) {
                    /* class com.xiaomi.mico.music.patchwall.group.$$Lambda$IntelligentViewHolderFactory$OneDrivenTwoViewHolder$U84LRFqr4xlyyCjBLgsiLLZDXg0 */
                    private final /* synthetic */ IntelligentModel.ListBean.CardsBean f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        IntelligentViewHolderFactory.OneDrivenTwoViewHolder.this.lambda$updateLeftChildView$1$IntelligentViewHolderFactory$OneDrivenTwoViewHolder(this.f$1, view);
                    }
                });
                TextView textView = this.mLeftViewThirdTitle;
                if (!TextUtils.isEmpty(cardsBean.getPicContent())) {
                    str = cardsBean.getPicContent();
                }
                textView.setText(str);
                return;
            }
            MusicHelper.loadPatchWallCropSquareCover(str, this.mLeftViewImg, (int) R.drawable.img_cover_default_rectangle, this.borderRadius, true);
            this.mLeftViewTitle.setText(str);
            this.mLeftViewSubTitle.setText(str);
            this.mLeftView.setOnClickListener(null);
        }

        public /* synthetic */ void lambda$updateLeftChildView$1$IntelligentViewHolderFactory$OneDrivenTwoViewHolder(IntelligentModel.ListBean.CardsBean cardsBean, View view) {
            onClickView(cardsBean.getJumpLink());
            hxi.O00000o.O000000o(2, "GOOD_ITEM", cardsBean.getMainTitle());
            if (this.mItemClickListener != null) {
                this.mItemClickListener.onItemClicked(cardsBean.getPosition());
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.xiaomi.mico.music.MusicHelper.loadPatchWallCropSquareCover(java.lang.String, android.widget.ImageView, int, int, boolean):void
         arg types: [java.lang.String, android.widget.ImageView, ?, int, int]
         candidates:
          com.xiaomi.mico.music.MusicHelper.loadPatchWallCropSquareCover(java.lang.String, android.widget.ImageView, int, int, int):void
          com.xiaomi.mico.music.MusicHelper.loadPatchWallCropSquareCover(java.lang.String, android.widget.ImageView, int, int, boolean):void */
        private void updateRightChildView(IntelligentModel.ListBean.CardsBean cardsBean) {
            String str = "";
            if (cardsBean != null) {
                MusicHelper.loadPatchWallCropSquareCover(cardsBean.getPicture(), this.mRightViewImg, (int) R.drawable.img_cover_default_rectangle, this.borderRadius, true);
                this.mRightViewTitle.setText(cardsBean.getMainTitle());
                this.mRightViewSubTitle.setText(cardsBean.getSubTitle());
                this.mRightView.setOnClickListener(new View.OnClickListener(cardsBean) {
                    /* class com.xiaomi.mico.music.patchwall.group.$$Lambda$IntelligentViewHolderFactory$OneDrivenTwoViewHolder$8LLHw4whnbFpSiZgsYGAYRXO6f4 */
                    private final /* synthetic */ IntelligentModel.ListBean.CardsBean f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        IntelligentViewHolderFactory.OneDrivenTwoViewHolder.this.lambda$updateRightChildView$2$IntelligentViewHolderFactory$OneDrivenTwoViewHolder(this.f$1, view);
                    }
                });
                TextView textView = this.mRightViewThirdTitle;
                if (!TextUtils.isEmpty(cardsBean.getPicContent())) {
                    str = cardsBean.getPicContent();
                }
                textView.setText(str);
                return;
            }
            MusicHelper.loadPatchWallCropSquareCover(str, this.mRightViewImg, (int) R.drawable.img_cover_default_rectangle, this.borderRadius, true);
            this.mRightViewTitle.setText(str);
            this.mRightViewSubTitle.setText(str);
            this.mRightView.setOnClickListener(null);
        }

        public /* synthetic */ void lambda$updateRightChildView$2$IntelligentViewHolderFactory$OneDrivenTwoViewHolder(IntelligentModel.ListBean.CardsBean cardsBean, View view) {
            onClickView(cardsBean.getJumpLink());
            hxi.O00000o.O000000o(2, "GOOD_ITEM", cardsBean.getMainTitle());
            if (this.mItemClickListener != null) {
                this.mItemClickListener.onItemClicked(cardsBean.getPosition());
            }
        }
    }

    public static class InfoStreamViewHolder extends IntelligentBaseViewHolder {
        private final TextView mAmount = ((TextView) this.itemView.findViewById(R.id.tv_info_stream_title_amount));
        private final ImageView mBgViewImg = ((ImageView) this.itemView.findViewById(R.id.mico_intelligent_iv_pic));
        private final TextView mMainTitle = ((TextView) this.itemView.findViewById(R.id.tv_info_stream_title_main));
        private final TextView mSubTitle = ((TextView) this.itemView.findViewById(R.id.tv_info_stream_title_sub));

        public InfoStreamViewHolder(View view) {
            super(view);
        }

        public void bindView(List<IntelligentModel.ListBean.CardsBean> list, RecyclerView.O000000o o000000o) {
            if (list.size() > 0 && list.get(0) != null && o000000o != null) {
                IntelligentModel.ListBean.CardsBean cardsBean = list.get(0);
                this.mRootView.setOnClickListener(new View.OnClickListener(cardsBean) {
                    /* class com.xiaomi.mico.music.patchwall.group.$$Lambda$IntelligentViewHolderFactory$InfoStreamViewHolder$y0J3q7M1kyMLtJmF9FapmzVjFLA */
                    private final /* synthetic */ IntelligentModel.ListBean.CardsBean f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        IntelligentViewHolderFactory.InfoStreamViewHolder.this.lambda$bindView$0$IntelligentViewHolderFactory$InfoStreamViewHolder(this.f$1, view);
                    }
                });
                MusicHelper.loadCenterCover(cardsBean.getPicture(), R.drawable.img_cover_default_rectangle, R.drawable.img_cover_default_rectangle, this.mBgViewImg, new CropSquareTransformation(this.borderRadius), DisplayUtils.dip2px(this.mBgViewImg.getContext(), 102.0f));
                this.mMainTitle.setText(cardsBean.getMainTitle());
                this.mSubTitle.setText(cardsBean.getSubTitle());
                this.mAmount.setText(TextUtils.isEmpty(cardsBean.getPicContent()) ? "" : cardsBean.getPicContent());
            }
        }

        public /* synthetic */ void lambda$bindView$0$IntelligentViewHolderFactory$InfoStreamViewHolder(IntelligentModel.ListBean.CardsBean cardsBean, View view) {
            onClickView(cardsBean.getJumpLink());
            if (this.mItemClickListener != null) {
                this.mItemClickListener.onItemClicked(cardsBean.getPosition());
            }
        }
    }

    public static class IntelligentKingKongViewHolder extends IntelligentBaseViewHolder {
        List<ViewGroup> mVewGroups = new ArrayList();
        int[] tabIds = {R.id.mico_tab1, R.id.mico_tab2, R.id.mico_tab3, R.id.mico_tab4};

        public IntelligentKingKongViewHolder(View view) {
            super(view);
            for (int i = 0; i < 4; i++) {
                this.mVewGroups.add((ViewGroup) this.itemView.findViewById(this.tabIds[i]));
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.xiaomi.mico.music.MusicHelper.loadPatchWallCropSquareCover(java.lang.String, android.widget.ImageView, int, int, boolean):void
         arg types: [java.lang.String, android.widget.ImageView, ?, int, int]
         candidates:
          com.xiaomi.mico.music.MusicHelper.loadPatchWallCropSquareCover(java.lang.String, android.widget.ImageView, int, int, int):void
          com.xiaomi.mico.music.MusicHelper.loadPatchWallCropSquareCover(java.lang.String, android.widget.ImageView, int, int, boolean):void */
        public void bindView(List<IntelligentModel.ListBean.CardsBean> list, RecyclerView.O000000o o000000o) {
            if (list != null && list.size() > 0 && o000000o != null) {
                for (int i = 0; i < list.size(); i++) {
                    final IntelligentModel.ListBean.CardsBean cardsBean = list.get(i);
                    if (cardsBean != null) {
                        ViewGroup viewGroup = this.mVewGroups.get(i);
                        viewGroup.setVisibility(0);
                        MusicHelper.loadPatchWallCropSquareCover(cardsBean.getPicture(), (ImageView) viewGroup.getChildAt(0), (int) R.color.mj_color_gray_lighter, 0, true);
                        ((TextView) viewGroup.getChildAt(1)).setText(cardsBean.getMainTitle());
                        viewGroup.setOnClickListener(new View.OnClickListener() {
                            /* class com.xiaomi.mico.music.patchwall.group.IntelligentViewHolderFactory.IntelligentKingKongViewHolder.AnonymousClass1 */

                            public void onClick(View view) {
                                IntelligentKingKongViewHolder.this.onClickView(cardsBean.getJumpLink());
                                hxk hxk = hxi.O00000o;
                                int position = cardsBean.getPosition();
                                String mainTitle = cardsBean.getMainTitle();
                                hxk.f952O000000o.O000000o("content_intelligence_guide", "position", Integer.valueOf(position), "name", mainTitle);
                            }
                        });
                    }
                }
            }
        }
    }

    public static class IntelligentHeaderViewHolder extends IntelligentBaseViewHolder {
        TextView desc = ((TextView) this.itemView.findViewById(R.id.patchwall_header_desc));
        TextView more = ((TextView) this.itemView.findViewById(R.id.patchwall_header_more));
        TextView title = ((TextView) this.itemView.findViewById(R.id.patchwall_header_title));

        @Deprecated
        public void bindView(List<IntelligentModel.ListBean.CardsBean> list, RecyclerView.O000000o o000000o) {
        }

        public IntelligentHeaderViewHolder(View view) {
            super(view);
        }

        public void bindView(IntelligentModel.ListBean listBean) {
            if (listBean != null) {
                this.title.setText(listBean.getName());
                ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
                int i = 0;
                if (TextUtils.isEmpty(listBean.getName())) {
                    layoutParams.height = 0;
                } else {
                    layoutParams.height = -2;
                }
                TextView textView = this.more;
                if (!listBean.isMore()) {
                    i = 8;
                }
                textView.setVisibility(i);
                this.more.setOnClickListener(new View.OnClickListener(listBean) {
                    /* class com.xiaomi.mico.music.patchwall.group.$$Lambda$IntelligentViewHolderFactory$IntelligentHeaderViewHolder$9Ingey8sKVno3znbaB0OmtITbw */
                    private final /* synthetic */ IntelligentModel.ListBean f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        IntelligentViewHolderFactory.IntelligentHeaderViewHolder.this.lambda$bindView$0$IntelligentViewHolderFactory$IntelligentHeaderViewHolder(this.f$1, view);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$bindView$0$IntelligentViewHolderFactory$IntelligentHeaderViewHolder(IntelligentModel.ListBean listBean, View view) {
            IntelligentMoreActivity.startActivity(this.mRootView.getContext().getApplicationContext(), listBean.getTypeId(), listBean.getName(), listBean.getType());
            if (this.mItemClickListener != null) {
                this.mItemClickListener.onItemClicked(0);
            }
        }
    }
}
