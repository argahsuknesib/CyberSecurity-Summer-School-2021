package com.mi.global.shop.feature.search;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.shopviews.widget.customfont.CustomTextView;
import com.xiaomi.smarthome.R;

public class SearchResultFragment_ViewBinding implements Unbinder {
    private SearchResultFragment target;

    public SearchResultFragment_ViewBinding(SearchResultFragment searchResultFragment, View view) {
        this.target = searchResultFragment;
        searchResultFragment.mDropDownMenu = (DropDownMenu) Utils.findRequiredViewAsType(view, R.id.dropDownMenu, "field 'mDropDownMenu'", DropDownMenu.class);
        searchResultFragment.mNoResult = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.tv_search_no_result, "field 'mNoResult'", CustomTextView.class);
    }

    public void unbind() {
        SearchResultFragment searchResultFragment = this.target;
        if (searchResultFragment != null) {
            this.target = null;
            searchResultFragment.mDropDownMenu = null;
            searchResultFragment.mNoResult = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
