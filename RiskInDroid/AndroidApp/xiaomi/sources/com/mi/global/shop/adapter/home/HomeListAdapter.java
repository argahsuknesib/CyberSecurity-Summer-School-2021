package com.mi.global.shop.adapter.home;

import _m_j.cav;
import _m_j.cbb;
import _m_j.cbj;
import _m_j.cbq;
import _m_j.cby;
import _m_j.ccd;
import _m_j.cdy;
import _m_j.cef;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.exoplayer2.C;
import com.mi.global.shop.activity.WebActivity;
import com.mi.global.shop.newmodel.home.NewHomeBlockData;
import com.mi.global.shop.newmodel.home.NewHomeBlockInfo;
import com.mi.global.shop.newmodel.home.NewHomeBlockInfoItem;
import com.mi.global.shop.widget.AutoScrollViewPager;
import com.mi.global.shop.widget.CustomRecyclerView;
import com.mi.global.shop.widget.CustomTextView;
import com.mi.global.shop.widget.EasyTextView;
import com.mi.global.shop.widget.NoScrollGridView;
import com.mi.global.shop.widget.vpi.LinePageIndicator;
import com.mi.util.Device;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

public class HomeListAdapter extends BaseAdapter {

    /* renamed from: O000000o  reason: collision with root package name */
    public List<NewHomeBlockInfo> f4789O000000o = new ArrayList();
    private ArrayList<Integer> O00000Oo = new ArrayList<>();
    private Context O00000o0;

    public long getItemId(int i) {
        return (long) i;
    }

    public int getViewTypeCount() {
        return 10;
    }

    public class HDHolder_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private HDHolder f4799O000000o;

        public HDHolder_ViewBinding(HDHolder hDHolder, View view) {
            this.f4799O000000o = hDHolder;
            hDHolder.grid = (NoScrollGridView) Utils.findRequiredViewAsType(view, R.id.home_image_grid_view, "field 'grid'", NoScrollGridView.class);
        }

        public void unbind() {
            HDHolder hDHolder = this.f4799O000000o;
            if (hDHolder != null) {
                this.f4799O000000o = null;
                hDHolder.grid = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public class StationMoreHolder_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private StationMoreHolder f4812O000000o;

        public StationMoreHolder_ViewBinding(StationMoreHolder stationMoreHolder, View view) {
            this.f4812O000000o = stationMoreHolder;
            stationMoreHolder.more = Utils.findRequiredView(view, R.id.home_grid_header_more, "field 'more'");
        }

        public void unbind() {
            StationMoreHolder stationMoreHolder = this.f4812O000000o;
            if (stationMoreHolder != null) {
                this.f4812O000000o = null;
                stationMoreHolder.more = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public class PhoneHolder_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private PhoneHolder f4804O000000o;

        public PhoneHolder_ViewBinding(PhoneHolder phoneHolder, View view) {
            this.f4804O000000o = phoneHolder;
            phoneHolder.list = (CustomRecyclerView) Utils.findRequiredViewAsType(view, R.id.phone_list, "field 'list'", CustomRecyclerView.class);
            phoneHolder.bg = (ImageView) Utils.findRequiredViewAsType(view, R.id.phone_list_bg, "field 'bg'", ImageView.class);
        }

        public void unbind() {
            PhoneHolder phoneHolder = this.f4804O000000o;
            if (phoneHolder != null) {
                this.f4804O000000o = null;
                phoneHolder.list = null;
                phoneHolder.bg = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public class ProductHolder_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private ProductHolder f4807O000000o;

        public ProductHolder_ViewBinding(ProductHolder productHolder, View view) {
            this.f4807O000000o = productHolder;
            productHolder.content = Utils.findRequiredView(view, R.id.home_product_content, "field 'content'");
            productHolder.product = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.product_image, "field 'product'", SimpleDraweeView.class);
        }

        public void unbind() {
            ProductHolder productHolder = this.f4807O000000o;
            if (productHolder != null) {
                this.f4807O000000o = null;
                productHolder.content = null;
                productHolder.product = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public class AccessoryHolder_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private AccessoryHolder f4791O000000o;

        public AccessoryHolder_ViewBinding(AccessoryHolder accessoryHolder, View view) {
            this.f4791O000000o = accessoryHolder;
            accessoryHolder.content = Utils.findRequiredView(view, R.id.accessory_list_content, "field 'content'");
            accessoryHolder.list = (CustomRecyclerView) Utils.findRequiredViewAsType(view, R.id.accessory_list, "field 'list'", CustomRecyclerView.class);
            accessoryHolder.bg = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.accessory_list_bg, "field 'bg'", SimpleDraweeView.class);
        }

        public void unbind() {
            AccessoryHolder accessoryHolder = this.f4791O000000o;
            if (accessoryHolder != null) {
                this.f4791O000000o = null;
                accessoryHolder.content = null;
                accessoryHolder.list = null;
                accessoryHolder.bg = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public class GalleryHolder_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private GalleryHolder f4794O000000o;

        public GalleryHolder_ViewBinding(GalleryHolder galleryHolder, View view) {
            this.f4794O000000o = galleryHolder;
            galleryHolder.pager = (AutoScrollViewPager) Utils.findRequiredViewAsType(view, R.id.home_gallery_viewpager, "field 'pager'", AutoScrollViewPager.class);
            galleryHolder.indicator = (LinePageIndicator) Utils.findRequiredViewAsType(view, R.id.home_gallery_indicator, "field 'indicator'", LinePageIndicator.class);
        }

        public void unbind() {
            GalleryHolder galleryHolder = this.f4794O000000o;
            if (galleryHolder != null) {
                this.f4794O000000o = null;
                galleryHolder.pager = null;
                galleryHolder.indicator = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public class GameHolder_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private GameHolder f4797O000000o;

        public GameHolder_ViewBinding(GameHolder gameHolder, View view) {
            this.f4797O000000o = gameHolder;
            gameHolder.content = Utils.findRequiredView(view, R.id.game_content, "field 'content'");
            gameHolder.bg = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.game_bg, "field 'bg'", SimpleDraweeView.class);
            gameHolder.text = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.game_text, "field 'text'", CustomTextView.class);
            gameHolder.gameIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.game_icon, "field 'gameIcon'", ImageView.class);
        }

        public void unbind() {
            GameHolder gameHolder = this.f4797O000000o;
            if (gameHolder != null) {
                this.f4797O000000o = null;
                gameHolder.content = null;
                gameHolder.bg = null;
                gameHolder.text = null;
                gameHolder.gameIcon = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public class StationTitleHolder_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private StationTitleHolder f4813O000000o;

        public StationTitleHolder_ViewBinding(StationTitleHolder stationTitleHolder, View view) {
            this.f4813O000000o = stationTitleHolder;
            stationTitleHolder.textTitle = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.home_grid_header_title, "field 'textTitle'", CustomTextView.class);
            stationTitleHolder.imageTitle = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.home_grid_header_image_title, "field 'imageTitle'", SimpleDraweeView.class);
        }

        public void unbind() {
            StationTitleHolder stationTitleHolder = this.f4813O000000o;
            if (stationTitleHolder != null) {
                this.f4813O000000o = null;
                stationTitleHolder.textTitle = null;
                stationTitleHolder.imageTitle = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public class HotBuyHolder_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private HotBuyHolder f4802O000000o;

        public HotBuyHolder_ViewBinding(HotBuyHolder hotBuyHolder, View view) {
            this.f4802O000000o = hotBuyHolder;
            hotBuyHolder.image = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.hot_buy_image, "field 'image'", SimpleDraweeView.class);
            hotBuyHolder.name = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.hot_buy_name, "field 'name'", CustomTextView.class);
            hotBuyHolder.desc = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.hot_buy_desc, "field 'desc'", CustomTextView.class);
            hotBuyHolder.prize = (EasyTextView) Utils.findRequiredViewAsType(view, R.id.hot_buy_prize, "field 'prize'", EasyTextView.class);
            hotBuyHolder.time = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.hot_buy_time, "field 'time'", CustomTextView.class);
            hotBuyHolder.textBuy = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.hot_buy_text, "field 'textBuy'", CustomTextView.class);
            hotBuyHolder.imageBuy = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.hot_buy_image_btn, "field 'imageBuy'", SimpleDraweeView.class);
        }

        public void unbind() {
            HotBuyHolder hotBuyHolder = this.f4802O000000o;
            if (hotBuyHolder != null) {
                this.f4802O000000o = null;
                hotBuyHolder.image = null;
                hotBuyHolder.name = null;
                hotBuyHolder.desc = null;
                hotBuyHolder.prize = null;
                hotBuyHolder.time = null;
                hotBuyHolder.textBuy = null;
                hotBuyHolder.imageBuy = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public class StationItemHolder_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private StationItemHolder f4810O000000o;

        public StationItemHolder_ViewBinding(StationItemHolder stationItemHolder, View view) {
            this.f4810O000000o = stationItemHolder;
            stationItemHolder.leftView = Utils.findRequiredView(view, R.id.left_layout, "field 'leftView'");
            stationItemHolder.rightView = Utils.findRequiredView(view, R.id.right_layout, "field 'rightView'");
            stationItemHolder.leftImage = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.left_item_image, "field 'leftImage'", SimpleDraweeView.class);
            stationItemHolder.leftName = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.left_item_name, "field 'leftName'", CustomTextView.class);
            stationItemHolder.leftPrice = (EasyTextView) Utils.findRequiredViewAsType(view, R.id.left_item_price, "field 'leftPrice'", EasyTextView.class);
            stationItemHolder.leftIconImage = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.left_icon_image, "field 'leftIconImage'", SimpleDraweeView.class);
            stationItemHolder.leftIconText = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.left_icon_text, "field 'leftIconText'", CustomTextView.class);
            stationItemHolder.rightImage = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.right_item_image, "field 'rightImage'", SimpleDraweeView.class);
            stationItemHolder.rightName = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.right_item_name, "field 'rightName'", CustomTextView.class);
            stationItemHolder.rightPrice = (EasyTextView) Utils.findRequiredViewAsType(view, R.id.right_item_price, "field 'rightPrice'", EasyTextView.class);
            stationItemHolder.rightIconImage = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.right_icon_image, "field 'rightIconImage'", SimpleDraweeView.class);
            stationItemHolder.rightIconText = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.right_icon_text, "field 'rightIconText'", CustomTextView.class);
        }

        public void unbind() {
            StationItemHolder stationItemHolder = this.f4810O000000o;
            if (stationItemHolder != null) {
                this.f4810O000000o = null;
                stationItemHolder.leftView = null;
                stationItemHolder.rightView = null;
                stationItemHolder.leftImage = null;
                stationItemHolder.leftName = null;
                stationItemHolder.leftPrice = null;
                stationItemHolder.leftIconImage = null;
                stationItemHolder.leftIconText = null;
                stationItemHolder.rightImage = null;
                stationItemHolder.rightName = null;
                stationItemHolder.rightPrice = null;
                stationItemHolder.rightIconImage = null;
                stationItemHolder.rightIconText = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public HomeListAdapter(Context context) {
        this.O00000o0 = context;
    }

    public final void O000000o(NewHomeBlockData newHomeBlockData) {
        System.out.println(newHomeBlockData);
        this.O00000Oo.clear();
        this.f4789O000000o.clear();
        if (newHomeBlockData.mHeaderGallery != null && newHomeBlockData.mHeaderGallery.size() > 0) {
            NewHomeBlockInfo newHomeBlockInfo = newHomeBlockData.mHeaderGallery.get(0);
            if (newHomeBlockInfo.mItems != null && newHomeBlockInfo.mItems.size() > 0) {
                this.f4789O000000o.add(newHomeBlockInfo);
                this.O00000Oo.add(0);
            }
        }
        if (newHomeBlockData.mHDSections != null && newHomeBlockData.mHDSections.size() > 0) {
            NewHomeBlockInfo newHomeBlockInfo2 = newHomeBlockData.mHDSections.get(0);
            if (newHomeBlockInfo2.mItems != null && newHomeBlockInfo2.mItems.size() > 0) {
                this.f4789O000000o.add(newHomeBlockInfo2);
                this.O00000Oo.add(9);
            }
        }
        if (newHomeBlockData.mHotBuySections != null && newHomeBlockData.mHotBuySections.size() > 0) {
            NewHomeBlockInfo newHomeBlockInfo3 = newHomeBlockData.mHotBuySections.get(0);
            if (newHomeBlockInfo3.mItems != null && newHomeBlockInfo3.mItems.size() > 0) {
                this.f4789O000000o.add(newHomeBlockInfo3);
                this.O00000Oo.add(3);
            }
        }
        if (newHomeBlockData.mGameSections != null && newHomeBlockData.mGameSections.size() > 0) {
            NewHomeBlockInfo newHomeBlockInfo4 = newHomeBlockData.mGameSections.get(0);
            if (newHomeBlockInfo4.mItems != null && newHomeBlockInfo4.mItems.size() > 0) {
                this.f4789O000000o.add(newHomeBlockInfo4);
                this.O00000Oo.add(4);
            }
        }
        if (newHomeBlockData.mPhoneSections != null && newHomeBlockData.mPhoneSections.size() > 0) {
            NewHomeBlockInfo newHomeBlockInfo5 = newHomeBlockData.mPhoneSections.get(0);
            if (newHomeBlockInfo5.mItems != null && newHomeBlockInfo5.mItems.size() > 0) {
                this.f4789O000000o.add(newHomeBlockInfo5);
                this.O00000Oo.add(1);
            }
        }
        O000000o(newHomeBlockData.getHomeSectionBySort(1));
        if (newHomeBlockData.mAccessorySections != null && newHomeBlockData.mAccessorySections.size() > 0) {
            NewHomeBlockInfo newHomeBlockInfo6 = newHomeBlockData.mAccessorySections.get(0);
            if (newHomeBlockInfo6.mItems != null && newHomeBlockInfo6.mItems.size() > 0) {
                this.f4789O000000o.add(newHomeBlockInfo6);
                this.O00000Oo.add(2);
            }
        }
        O000000o(newHomeBlockData.getHomeSectionBySort(2));
        if (newHomeBlockData.mProductSections != null && newHomeBlockData.mProductSections.size() > 0) {
            NewHomeBlockInfo newHomeBlockInfo7 = newHomeBlockData.mProductSections.get(0);
            if (newHomeBlockInfo7.mItems != null && newHomeBlockInfo7.mItems.size() > 0) {
                this.f4789O000000o.add(newHomeBlockInfo7);
                this.O00000Oo.add(8);
            }
        }
        notifyDataSetChanged();
    }

    private void O000000o(NewHomeBlockInfo newHomeBlockInfo) {
        if (newHomeBlockInfo != null && newHomeBlockInfo.mItems != null && newHomeBlockInfo.mItems.size() > 0) {
            NewHomeBlockInfo newHomeBlockInfo2 = new NewHomeBlockInfo();
            newHomeBlockInfo2.mDesc = newHomeBlockInfo.mDesc;
            this.f4789O000000o.add(newHomeBlockInfo2);
            this.O00000Oo.add(5);
            int i = 0;
            while (i < newHomeBlockInfo.mItems.size()) {
                NewHomeBlockInfo newHomeBlockInfo3 = new NewHomeBlockInfo();
                newHomeBlockInfo3.mItems.add(newHomeBlockInfo.mItems.get(i));
                int i2 = i + 1;
                if (i2 < newHomeBlockInfo.mItems.size()) {
                    newHomeBlockInfo3.mItems.add(newHomeBlockInfo.mItems.get(i2));
                    i = i2;
                }
                this.f4789O000000o.add(newHomeBlockInfo3);
                this.O00000Oo.add(6);
                i++;
            }
            if (newHomeBlockInfo.mDesc != null && newHomeBlockInfo.mDesc.mSort == 2) {
                this.f4789O000000o.add(newHomeBlockInfo2);
                this.O00000Oo.add(7);
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View getView(int i, View view, ViewGroup viewGroup) {
        O000000o o000000o;
        O000000o o000000o2;
        if (view == null) {
            switch (getItemViewType(i)) {
                case 0:
                    view = LayoutInflater.from(this.O00000o0).inflate((int) R.layout.shop_home_gallery, viewGroup, false);
                    o000000o = new GalleryHolder(view);
                    break;
                case 1:
                    view = LayoutInflater.from(this.O00000o0).inflate((int) R.layout.shop_phone_list, viewGroup, false);
                    o000000o2 = new PhoneHolder(view, viewGroup);
                    o000000o = o000000o2;
                    break;
                case 2:
                    view = LayoutInflater.from(this.O00000o0).inflate((int) R.layout.shop_accessory_list, viewGroup, false);
                    o000000o2 = new AccessoryHolder(view, viewGroup);
                    o000000o = o000000o2;
                    break;
                case 3:
                    view = LayoutInflater.from(this.O00000o0).inflate((int) R.layout.shop_home_hot_buy, viewGroup, false);
                    o000000o = new HotBuyHolder(view);
                    break;
                case 4:
                    view = LayoutInflater.from(this.O00000o0).inflate((int) R.layout.shop_home_game, viewGroup, false);
                    o000000o = new GameHolder(view);
                    break;
                case 5:
                    view = LayoutInflater.from(this.O00000o0).inflate((int) R.layout.shop_home_station_title, viewGroup, false);
                    o000000o = new StationTitleHolder(view);
                    break;
                case 6:
                    view = LayoutInflater.from(this.O00000o0).inflate((int) R.layout.shop_home_station_item, viewGroup, false);
                    o000000o = new StationItemHolder(view);
                    break;
                case 7:
                    view = LayoutInflater.from(this.O00000o0).inflate((int) R.layout.shop_home_station_more, viewGroup, false);
                    o000000o = new StationMoreHolder(view);
                    break;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    view = LayoutInflater.from(this.O00000o0).inflate((int) R.layout.shop_home_product, viewGroup, false);
                    o000000o = new ProductHolder(view);
                    break;
                case 9:
                    view = LayoutInflater.from(this.O00000o0).inflate((int) R.layout.shop_home_hd, viewGroup, false);
                    o000000o = new HDHolder(view);
                    break;
                default:
                    o000000o = null;
                    break;
            }
            if (o000000o != null) {
                view.setTag(o000000o);
            }
        } else {
            o000000o = (O000000o) view.getTag();
        }
        if (o000000o != null) {
            o000000o.O000000o(this.f4789O000000o.get(i));
        }
        return view;
    }

    public Object getItem(int i) {
        return this.f4789O000000o.get(i);
    }

    public int getCount() {
        return this.f4789O000000o.size();
    }

    public int getItemViewType(int i) {
        return this.O00000Oo.get(i).intValue();
    }

    static class O000000o {
        public void O000000o(NewHomeBlockInfo newHomeBlockInfo) {
        }

        O000000o() {
        }
    }

    static class GalleryHolder extends O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        HomeGalleryPagerAdapter f4792O000000o;
        int O00000Oo = 0;
        @BindView(2131493412)
        LinePageIndicator indicator;
        @BindView(2131493413)
        AutoScrollViewPager pager;

        public GalleryHolder(View view) {
            ButterKnife.bind(this, view);
            view.getLayoutParams().height = cbj.O000000o.f13594O000000o.O00000o0(20);
            this.pager.setStopScrollWhenTouch(true);
            this.pager.setStopScrollWhenTouched(true);
            this.f4792O000000o = new HomeGalleryPagerAdapter(view.getContext());
            this.pager.setAdapter(this.f4792O000000o);
            int O000000o2 = this.f4792O000000o.O000000o();
            this.indicator.setVisibility(0);
            this.indicator.setViewPager(this.pager);
            this.indicator.setRealCount(O000000o2);
            this.indicator.setCentered(true);
            this.indicator.setStrokeWidth(0.0f);
            this.pager.addOnPageChangeListener(new ViewPager.O0000O0o() {
                /* class com.mi.global.shop.adapter.home.HomeListAdapter.GalleryHolder.AnonymousClass1 */

                public final void onPageScrollStateChanged(int i) {
                }

                public final void onPageScrolled(int i, float f, int i2) {
                }

                public final void onPageSelected(int i) {
                    ccd.O000000o((NewHomeBlockInfoItem) GalleryHolder.this.f4792O000000o.O000000o(i));
                }
            });
            this.pager.setCurrentItem(0);
            AutoScrollViewPager autoScrollViewPager = this.pager;
            autoScrollViewPager.O00000oO = true;
            autoScrollViewPager.O000000o(5000);
        }

        public final void O000000o(NewHomeBlockInfo newHomeBlockInfo) {
            if (newHomeBlockInfo != null && newHomeBlockInfo.mItems != null && !newHomeBlockInfo.mItems.isEmpty()) {
                HomeGalleryPagerAdapter homeGalleryPagerAdapter = this.f4792O000000o;
                ArrayList<T> arrayList = newHomeBlockInfo.mItems;
                if (arrayList != null) {
                    homeGalleryPagerAdapter.f4732O000000o = arrayList;
                    homeGalleryPagerAdapter.notifyDataSetChanged();
                }
                this.indicator.setRealCount(this.f4792O000000o.O000000o());
            }
        }
    }

    static class PhoneHolder extends O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        HomePhoneListAdapter f4803O000000o;
        @BindView(2131493865)
        ImageView bg;
        @BindView(2131493864)
        CustomRecyclerView list;

        public PhoneHolder(View view, ViewGroup viewGroup) {
            ButterKnife.bind(this, view);
            int O000000o2 = Device.f5099O000000o - cdy.O000000o(view.getContext(), 70.0f);
            this.list.addItemDecoration(new cby((O000000o2 / Math.round((float) (O000000o2 / cdy.O000000o(view.getContext(), 90.0f)))) - cdy.O000000o(view.getContext(), 70.0f), cdy.O000000o(view.getContext(), 35.0f), cdy.O000000o(view.getContext(), 35.0f)));
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
            linearLayoutManager.setOrientation(0);
            this.list.setLayoutManager(linearLayoutManager);
            this.list.setItemAnimator(null);
            this.f4803O000000o = new HomePhoneListAdapter(view.getContext());
            this.list.setAdapter(this.f4803O000000o);
            this.list.setParent(viewGroup);
        }

        public final void O000000o(NewHomeBlockInfo newHomeBlockInfo) {
            if (newHomeBlockInfo != null && newHomeBlockInfo.mItems != null && !newHomeBlockInfo.mItems.isEmpty()) {
                HomePhoneListAdapter homePhoneListAdapter = this.f4803O000000o;
                ArrayList<NewHomeBlockInfoItem> arrayList = newHomeBlockInfo.mItems;
                if (arrayList != null) {
                    homePhoneListAdapter.O00000Oo.clear();
                    homePhoneListAdapter.O00000Oo.addAll(arrayList);
                    homePhoneListAdapter.notifyDataSetChanged();
                }
            }
        }
    }

    static class AccessoryHolder extends O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        HomeAccessoryListAdapter f4790O000000o;
        @BindView(2131492895)
        SimpleDraweeView bg;
        @BindView(2131492896)
        View content;
        @BindView(2131492894)
        CustomRecyclerView list;

        public AccessoryHolder(View view, ViewGroup viewGroup) {
            ButterKnife.bind(this, view);
            this.content.getLayoutParams().height = cbj.O000000o.f13594O000000o.O00000o0(24);
            this.list.addItemDecoration(new cby(cdy.O000000o(view.getContext(), 7.0f), cdy.O000000o(view.getContext(), 25.0f), cdy.O000000o(view.getContext(), 25.0f)));
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
            linearLayoutManager.setOrientation(0);
            this.list.setLayoutManager(linearLayoutManager);
            this.list.setItemAnimator(null);
            this.f4790O000000o = new HomeAccessoryListAdapter(view.getContext());
            this.list.setAdapter(this.f4790O000000o);
            this.list.setParent(viewGroup);
        }

        public final void O000000o(NewHomeBlockInfo newHomeBlockInfo) {
            if (newHomeBlockInfo != null && newHomeBlockInfo.mItems != null && !newHomeBlockInfo.mItems.isEmpty()) {
                HomeAccessoryListAdapter homeAccessoryListAdapter = this.f4790O000000o;
                ArrayList<NewHomeBlockInfoItem> arrayList = newHomeBlockInfo.mItems;
                if (arrayList != null) {
                    homeAccessoryListAdapter.O00000Oo.clear();
                    homeAccessoryListAdapter.O00000Oo.addAll(arrayList);
                    homeAccessoryListAdapter.notifyDataSetChanged();
                }
                cbq.O000000o(newHomeBlockInfo.mDesc.background, this.bg);
            }
        }
    }

    static class HotBuyHolder extends O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        View f4800O000000o;
        @BindView(2131493427)
        CustomTextView desc;
        @BindView(2131493428)
        SimpleDraweeView image;
        @BindView(2131493429)
        SimpleDraweeView imageBuy;
        @BindView(2131493430)
        CustomTextView name;
        @BindView(2131493431)
        EasyTextView prize;
        @BindView(2131493432)
        CustomTextView textBuy;
        @BindView(2131493433)
        CustomTextView time;

        public HotBuyHolder(View view) {
            this.f4800O000000o = view;
            ButterKnife.bind(this, view);
        }

        public final void O000000o(NewHomeBlockInfo newHomeBlockInfo) {
            if (newHomeBlockInfo != null && newHomeBlockInfo.mItems != null && !newHomeBlockInfo.mItems.isEmpty()) {
                final NewHomeBlockInfoItem newHomeBlockInfoItem = newHomeBlockInfo.mItems.get(0);
                this.name.setText(newHomeBlockInfoItem.mProductName);
                this.desc.setText(newHomeBlockInfoItem.mProductMore);
                this.prize.setPrize(newHomeBlockInfoItem);
                this.time.setText(newHomeBlockInfo.mDesc.mTitle);
                cbq.O000000o(newHomeBlockInfoItem.getImageUrl(), this.image);
                this.f4800O000000o.setOnClickListener(new View.OnClickListener() {
                    /* class com.mi.global.shop.adapter.home.HomeListAdapter.HotBuyHolder.AnonymousClass1 */

                    public final void onClick(View view) {
                        ccd.O000000o(HotBuyHolder.this.f4800O000000o.getContext(), newHomeBlockInfoItem);
                    }
                });
                if (!TextUtils.isEmpty(newHomeBlockInfo.mDesc.mButtonImage)) {
                    this.textBuy.setVisibility(8);
                    this.imageBuy.setVisibility(0);
                    cbq.O000000o(newHomeBlockInfo.mDesc.mButtonImage, this.imageBuy);
                } else {
                    this.textBuy.setVisibility(0);
                    if (!TextUtils.isEmpty(newHomeBlockInfo.mDesc.mButtonText)) {
                        this.textBuy.setText(newHomeBlockInfo.mDesc.mButtonText);
                    }
                    this.imageBuy.setVisibility(8);
                }
                ccd.O000000o(newHomeBlockInfoItem);
            }
        }
    }

    static class GameHolder extends O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        View f4795O000000o;
        @BindView(2131493373)
        SimpleDraweeView bg;
        @BindView(2131493374)
        View content;
        @BindView(2131493375)
        ImageView gameIcon;
        @BindView(2131493376)
        CustomTextView text;

        public GameHolder(View view) {
            this.f4795O000000o = view;
            ButterKnife.bind(this, view);
            this.content.getLayoutParams().height = cbj.O000000o.f13594O000000o.O00000o0(23);
        }

        public final void O000000o(NewHomeBlockInfo newHomeBlockInfo) {
            if (newHomeBlockInfo != null && newHomeBlockInfo.mItems != null && !newHomeBlockInfo.mItems.isEmpty()) {
                final NewHomeBlockInfoItem newHomeBlockInfoItem = newHomeBlockInfo.mItems.get(0);
                if (newHomeBlockInfo.mDesc != null) {
                    if (newHomeBlockInfo.mDesc.show_arrow) {
                        this.gameIcon.setVisibility(0);
                    } else {
                        this.gameIcon.setVisibility(4);
                    }
                }
                this.text.setText(newHomeBlockInfoItem.mProductName);
                this.f4795O000000o.setOnClickListener(new View.OnClickListener() {
                    /* class com.mi.global.shop.adapter.home.HomeListAdapter.GameHolder.AnonymousClass1 */

                    public final void onClick(View view) {
                        ccd.O000000o(GameHolder.this.f4795O000000o.getContext(), newHomeBlockInfoItem);
                    }
                });
                cbq.O000000o(newHomeBlockInfoItem.getImageUrl(), this.bg);
                ccd.O000000o(newHomeBlockInfoItem);
            }
        }
    }

    static class StationMoreHolder extends O000000o {
        @BindView(2131493416)
        View more;

        public StationMoreHolder(View view) {
            ButterKnife.bind(this, view);
        }

        public final void O000000o(NewHomeBlockInfo newHomeBlockInfo) {
            if (newHomeBlockInfo == null || newHomeBlockInfo.mDesc == null || newHomeBlockInfo.mDesc.mSort != 2) {
                this.more.setVisibility(8);
                return;
            }
            this.more.setVisibility(0);
            this.more.setOnClickListener(new View.OnClickListener() {
                /* class com.mi.global.shop.adapter.home.HomeListAdapter.StationMoreHolder.AnonymousClass1 */

                public final void onClick(View view) {
                    Intent intent = new Intent(StationMoreHolder.this.more.getContext(), WebActivity.class);
                    intent.putExtra("url", cav.O000OOoO());
                    StationMoreHolder.this.more.getContext().startActivity(intent);
                }
            });
        }
    }

    static class StationItemHolder extends O000000o {
        @BindView(2131493617)
        SimpleDraweeView leftIconImage;
        @BindView(2131493618)
        CustomTextView leftIconText;
        @BindView(2131493620)
        SimpleDraweeView leftImage;
        @BindView(2131493621)
        CustomTextView leftName;
        @BindView(2131493622)
        EasyTextView leftPrice;
        @BindView(2131493623)
        View leftView;
        @BindView(2131493949)
        SimpleDraweeView rightIconImage;
        @BindView(2131493950)
        CustomTextView rightIconText;
        @BindView(2131493952)
        SimpleDraweeView rightImage;
        @BindView(2131493953)
        CustomTextView rightName;
        @BindView(2131493954)
        EasyTextView rightPrice;
        @BindView(2131493955)
        View rightView;

        public StationItemHolder(View view) {
            ButterKnife.bind(this, view);
            this.leftImage.getLayoutParams().width = cbj.O000000o.f13594O000000o.O00000o0(13);
            this.leftImage.getLayoutParams().height = cbj.O000000o.f13594O000000o.O00000o0(14);
            this.rightImage.getLayoutParams().width = cbj.O000000o.f13594O000000o.O00000o0(13);
            this.rightImage.getLayoutParams().height = cbj.O000000o.f13594O000000o.O00000o0(14);
        }

        public final void O000000o(NewHomeBlockInfo newHomeBlockInfo) {
            if (newHomeBlockInfo == null || newHomeBlockInfo.mItems == null) {
                this.leftView.setVisibility(8);
                this.rightView.setVisibility(8);
                return;
            }
            if (newHomeBlockInfo.mItems.size() <= 0 || newHomeBlockInfo.mItems.get(0) == null) {
                this.leftView.setVisibility(8);
            } else {
                final NewHomeBlockInfoItem newHomeBlockInfoItem = newHomeBlockInfo.mItems.get(0);
                this.leftView.setVisibility(0);
                int i = cef.O000000o().f13684O000000o / 2;
                String imageUrl = newHomeBlockInfoItem.getImageUrl();
                if (!TextUtils.isEmpty(imageUrl)) {
                    imageUrl = cbb.O000000o(i, 99999, newHomeBlockInfoItem.getImageUrl());
                }
                cbq.O000000o(imageUrl, this.leftImage);
                this.leftName.setText(newHomeBlockInfoItem.mProductName);
                this.leftPrice.setPrize(newHomeBlockInfoItem);
                if (TextUtils.isEmpty(newHomeBlockInfoItem.mIconImg)) {
                    this.leftIconImage.setVisibility(8);
                } else {
                    this.leftIconImage.setVisibility(0);
                    cbq.O000000o(newHomeBlockInfoItem.mIconImg, this.leftIconImage);
                }
                if (TextUtils.isEmpty(newHomeBlockInfoItem.mIconContent)) {
                    this.leftIconText.setVisibility(8);
                } else {
                    this.leftIconText.setVisibility(0);
                    this.leftIconText.setText(newHomeBlockInfoItem.mIconContent);
                }
                this.leftView.setOnClickListener(new View.OnClickListener() {
                    /* class com.mi.global.shop.adapter.home.HomeListAdapter.StationItemHolder.AnonymousClass1 */

                    public final void onClick(View view) {
                        ccd.O000000o(StationItemHolder.this.leftView.getContext(), newHomeBlockInfoItem);
                    }
                });
                ccd.O000000o(newHomeBlockInfoItem);
            }
            if (newHomeBlockInfo.mItems.size() <= 1 || newHomeBlockInfo.mItems.get(1) == null) {
                this.rightView.setVisibility(8);
                return;
            }
            final NewHomeBlockInfoItem newHomeBlockInfoItem2 = newHomeBlockInfo.mItems.get(1);
            this.rightView.setVisibility(0);
            int i2 = cef.O000000o().f13684O000000o / 2;
            String imageUrl2 = newHomeBlockInfoItem2.getImageUrl();
            if (!TextUtils.isEmpty(imageUrl2)) {
                imageUrl2 = cbb.O000000o(i2, 99999, newHomeBlockInfoItem2.getImageUrl());
            }
            cbq.O000000o(imageUrl2, this.rightImage);
            this.rightName.setText(newHomeBlockInfoItem2.mProductName);
            this.rightPrice.setPrize(newHomeBlockInfoItem2);
            if (TextUtils.isEmpty(newHomeBlockInfoItem2.mIconImg)) {
                this.rightIconImage.setVisibility(8);
            } else {
                this.rightIconImage.setVisibility(0);
                cbq.O000000o(newHomeBlockInfoItem2.mIconImg, this.rightIconImage);
            }
            if (TextUtils.isEmpty(newHomeBlockInfoItem2.mIconContent)) {
                this.rightIconText.setVisibility(8);
            } else {
                this.rightIconText.setVisibility(0);
                this.rightIconText.setText(newHomeBlockInfoItem2.mIconContent);
            }
            this.rightView.setOnClickListener(new View.OnClickListener() {
                /* class com.mi.global.shop.adapter.home.HomeListAdapter.StationItemHolder.AnonymousClass2 */

                public final void onClick(View view) {
                    ccd.O000000o(StationItemHolder.this.rightView.getContext(), newHomeBlockInfoItem2);
                }
            });
            ccd.O000000o(newHomeBlockInfoItem2);
        }
    }

    static class StationTitleHolder extends O000000o {
        @BindView(2131493415)
        SimpleDraweeView imageTitle;
        @BindView(2131493417)
        CustomTextView textTitle;

        public StationTitleHolder(View view) {
            ButterKnife.bind(this, view);
        }

        public final void O000000o(NewHomeBlockInfo newHomeBlockInfo) {
            if (newHomeBlockInfo != null && newHomeBlockInfo.mDesc != null) {
                if (!TextUtils.isEmpty(newHomeBlockInfo.mDesc.mButtonImage)) {
                    this.textTitle.setVisibility(8);
                    this.imageTitle.setVisibility(0);
                    cbq.O000000o(newHomeBlockInfo.mDesc.mButtonImage, this.imageTitle);
                    return;
                }
                this.textTitle.setVisibility(0);
                this.textTitle.setText(newHomeBlockInfo.mDesc.mTitle);
                this.imageTitle.setVisibility(8);
            }
        }
    }

    static class HDHolder extends O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        HomeImageGridAdapter f4798O000000o;
        @BindView(2131493418)
        NoScrollGridView grid;

        public HDHolder(View view) {
            ButterKnife.bind(this, view);
            this.f4798O000000o = new HomeImageGridAdapter(view.getContext());
            this.grid.setAdapter((ListAdapter) this.f4798O000000o);
        }

        public final void O000000o(NewHomeBlockInfo newHomeBlockInfo) {
            if (newHomeBlockInfo != null && newHomeBlockInfo.mItems != null && !newHomeBlockInfo.mItems.isEmpty()) {
                this.grid.setNumColumns(newHomeBlockInfo.mItems.size());
                this.f4798O000000o.O000000o((List) newHomeBlockInfo.mItems);
            }
        }
    }

    static class ProductHolder extends O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        View f4805O000000o;
        @BindView(2131493419)
        View content;
        @BindView(2131493887)
        SimpleDraweeView product;

        public ProductHolder(View view) {
            this.f4805O000000o = view;
            ButterKnife.bind(this, view);
            this.content.getLayoutParams().height = cbj.O000000o.f13594O000000o.O00000o0(25);
        }

        public final void O000000o(NewHomeBlockInfo newHomeBlockInfo) {
            if (newHomeBlockInfo != null && newHomeBlockInfo.mItems != null && !newHomeBlockInfo.mItems.isEmpty()) {
                final NewHomeBlockInfoItem newHomeBlockInfoItem = newHomeBlockInfo.mItems.get(0);
                this.f4805O000000o.setOnClickListener(new View.OnClickListener() {
                    /* class com.mi.global.shop.adapter.home.HomeListAdapter.ProductHolder.AnonymousClass1 */

                    public final void onClick(View view) {
                        ccd.O000000o(ProductHolder.this.f4805O000000o.getContext(), newHomeBlockInfoItem);
                    }
                });
                ccd.O000000o(newHomeBlockInfoItem);
                String imageUrl = newHomeBlockInfoItem.getImageUrl();
                if (!TextUtils.isEmpty(imageUrl) && !imageUrl.equals(this.product.getTag())) {
                    this.product.setTag(imageUrl);
                    cbq.O000000o(imageUrl, this.product);
                }
            }
        }
    }
}
