package com.mi.global.shop.feature.search;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mi.global.shop.base.widget.CustomEditTextView;
import com.mi.global.shop.feature.search.widget.TagsLayout;
import com.xiaomi.shopviews.widget.customfont.CustomTextView;
import com.xiaomi.smarthome.R;

public class SearchActivity_ViewBinding implements Unbinder {
    private SearchActivity target;

    public SearchActivity_ViewBinding(SearchActivity searchActivity) {
        this(searchActivity, searchActivity.getWindow().getDecorView());
    }

    public SearchActivity_ViewBinding(SearchActivity searchActivity, View view) {
        this.target = searchActivity;
        searchActivity.etvSearchInput = (CustomEditTextView) Utils.findRequiredViewAsType(view, R.id.etv_search_input, "field 'etvSearchInput'", CustomEditTextView.class);
        searchActivity.etvSearchCancel = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.tv_search_cancel, "field 'etvSearchCancel'", CustomTextView.class);
        searchActivity.etvSearch = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.tv_search, "field 'etvSearch'", CustomTextView.class);
        searchActivity.rvSearchResult = (ListView) Utils.findRequiredViewAsType(view, R.id.rv_search_result, "field 'rvSearchResult'", ListView.class);
        searchActivity.tvSearchNoResult = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.tv_search_no_result, "field 'tvSearchNoResult'", CustomTextView.class);
        searchActivity.tvSearchRecord = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.tv_search_record, "field 'tvSearchRecord'", CustomTextView.class);
        searchActivity.tagsHistoryGroup = (TagsLayout) Utils.findRequiredViewAsType(view, R.id.tags_history_group, "field 'tagsHistoryGroup'", TagsLayout.class);
        searchActivity.layoutSearchRecord = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.layout_search_record, "field 'layoutSearchRecord'", RelativeLayout.class);
        searchActivity.tagsHotGroup = (TagsLayout) Utils.findRequiredViewAsType(view, R.id.tags_hot_group, "field 'tagsHotGroup'", TagsLayout.class);
        searchActivity.layoutSearchHot = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.layout_search_hot, "field 'layoutSearchHot'", LinearLayout.class);
        searchActivity.btnHistoryClear = (ImageButton) Utils.findRequiredViewAsType(view, R.id.btn_history_clear, "field 'btnHistoryClear'", ImageButton.class);
        searchActivity.rootView = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.root_view, "field 'rootView'", FrameLayout.class);
    }

    public void unbind() {
        SearchActivity searchActivity = this.target;
        if (searchActivity != null) {
            this.target = null;
            searchActivity.etvSearchInput = null;
            searchActivity.etvSearchCancel = null;
            searchActivity.etvSearch = null;
            searchActivity.rvSearchResult = null;
            searchActivity.tvSearchNoResult = null;
            searchActivity.tvSearchRecord = null;
            searchActivity.tagsHistoryGroup = null;
            searchActivity.layoutSearchRecord = null;
            searchActivity.tagsHotGroup = null;
            searchActivity.layoutSearchHot = null;
            searchActivity.btnHistoryClear = null;
            searchActivity.rootView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
