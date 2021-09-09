package com.xiaomi.mico;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.appbar.AppBarLayout;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.xiaomi.mico.common.widget.MicoLoadingView;
import com.xiaomi.mico.music.player.PlayerControler;
import com.xiaomi.smarthome.R;

public class MicoMainFragment_ViewBinding implements Unbinder {
    private MicoMainFragment target;

    public MicoMainFragment_ViewBinding(MicoMainFragment micoMainFragment, View view) {
        this.target = micoMainFragment;
        micoMainFragment.mCoordinatorLayout = (CoordinatorLayout) Utils.findRequiredViewAsType(view, R.id.title_bar, "field 'mCoordinatorLayout'", CoordinatorLayout.class);
        micoMainFragment.mToolBar = (Toolbar) Utils.findRequiredViewAsType(view, R.id.mico_music_tool_bar, "field 'mToolBar'", Toolbar.class);
        micoMainFragment.mAppBarLayout = (AppBarLayout) Utils.findRequiredViewAsType(view, R.id.mico_music_app_bar_layout, "field 'mAppBarLayout'", AppBarLayout.class);
        micoMainFragment.mMenuIcon = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.mico_menu_icon_img, "field 'mMenuIcon'", SimpleDraweeView.class);
        micoMainFragment.mMenu = (TextView) Utils.findRequiredViewAsType(view, R.id.mico_music_menu, "field 'mMenu'", TextView.class);
        micoMainFragment.mPlayerControler = (PlayerControler) Utils.findRequiredViewAsType(view, R.id.music_control_view, "field 'mPlayerControler'", PlayerControler.class);
        micoMainFragment.smartTabLayout = (SmartTabLayout) Utils.findRequiredViewAsType(view, R.id.mico_tablayout, "field 'smartTabLayout'", SmartTabLayout.class);
        micoMainFragment.mViewPager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.music_view_pager, "field 'mViewPager'", ViewPager.class);
        micoMainFragment.tabLeftSpace = Utils.findRequiredView(view, R.id.tab_left_space, "field 'tabLeftSpace'");
        micoMainFragment.mMicoChooseView = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.mico_choose_layout, "field 'mMicoChooseView'", RelativeLayout.class);
        micoMainFragment.mMicoTitleView = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.mico_title_bar, "field 'mMicoTitleView'", LinearLayout.class);
        micoMainFragment.mUserIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.mico_user_entrance, "field 'mUserIcon'", ImageView.class);
        micoMainFragment.mSearchIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.mico_search_entrance, "field 'mSearchIcon'", ImageView.class);
        micoMainFragment.mBackImgView = (ImageView) Utils.findRequiredViewAsType(view, R.id.mico_back_img, "field 'mBackImgView'", ImageView.class);
        micoMainFragment.mTabUserIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.mico_tab_user_entrance, "field 'mTabUserIcon'", ImageView.class);
        micoMainFragment.mTabSearchIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.mico_tab_search_entrance, "field 'mTabSearchIcon'", ImageView.class);
        micoMainFragment.mDropDwonView = (ImageView) Utils.findRequiredViewAsType(view, R.id.mico_icon_select, "field 'mDropDwonView'", ImageView.class);
        micoMainFragment.mTipsContainerView = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.mico_nodevice_tips_container, "field 'mTipsContainerView'", LinearLayout.class);
        micoMainFragment.mRightFade = Utils.findRequiredView(view, R.id.mico_right_fade, "field 'mRightFade'");
        micoMainFragment.mLoadingView = (MicoLoadingView) Utils.findRequiredViewAsType(view, R.id.mico_loading_view_container, "field 'mLoadingView'", MicoLoadingView.class);
    }

    public void unbind() {
        MicoMainFragment micoMainFragment = this.target;
        if (micoMainFragment != null) {
            this.target = null;
            micoMainFragment.mCoordinatorLayout = null;
            micoMainFragment.mToolBar = null;
            micoMainFragment.mAppBarLayout = null;
            micoMainFragment.mMenuIcon = null;
            micoMainFragment.mMenu = null;
            micoMainFragment.mPlayerControler = null;
            micoMainFragment.smartTabLayout = null;
            micoMainFragment.mViewPager = null;
            micoMainFragment.tabLeftSpace = null;
            micoMainFragment.mMicoChooseView = null;
            micoMainFragment.mMicoTitleView = null;
            micoMainFragment.mUserIcon = null;
            micoMainFragment.mSearchIcon = null;
            micoMainFragment.mBackImgView = null;
            micoMainFragment.mTabUserIcon = null;
            micoMainFragment.mTabSearchIcon = null;
            micoMainFragment.mDropDwonView = null;
            micoMainFragment.mTipsContainerView = null;
            micoMainFragment.mRightFade = null;
            micoMainFragment.mLoadingView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
