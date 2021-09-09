package com.mi.global.shop.feature.search;

import _m_j.byp;
import _m_j.bys;
import _m_j.cdy;
import _m_j.ced;
import _m_j.ny;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.mi.global.shop.base.BaseActivity;
import com.mi.global.shop.base.request.SimpleCallback;
import com.mi.global.shop.base.request.SimpleJsonRequest;
import com.mi.global.shop.base.request.SimpleProtobufRequest;
import com.mi.global.shop.base.service.GlobalConfigService;
import com.mi.global.shop.base.widget.CustomEditTextView;
import com.mi.global.shop.feature.search.newmodel.SearchRecommendResult;
import com.mi.global.shop.feature.search.newmodel.SearchWordResult;
import com.mi.global.shop.feature.search.widget.TagsLayout;
import com.xiaomi.shopviews.widget.customfont.CustomTextView;
import com.xiaomi.smarthome.R;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Route(path = "/featureGlobalshopSearch/searchActivity")
public class SearchActivity extends BaseActivity {
    private static final String TAG = "com.mi.global.shop.feature.search.SearchActivity";
    private static int sDarkModeFlag;
    private static Method sExtraFlagField;
    public static int statusBarHeight;
    public SearchResultListAdapter adapter;
    @BindView(2131492937)
    ImageButton btnHistoryClear;
    @BindView(2131493473)
    CustomTextView etvSearch;
    @BindView(2131493474)
    CustomTextView etvSearchCancel;
    @BindView(2131493032)
    CustomEditTextView etvSearchInput;
    @Autowired
    GlobalConfigService globalConfigService;
    public boolean isResultShowed = false;
    public LinearLayout layoutSearchContainer;
    @BindView(2131493144)
    LinearLayout layoutSearchHot;
    @BindView(2131493145)
    RelativeLayout layoutSearchRecord;
    @BindView(2131493296)
    FrameLayout rootView;
    @BindView(2131493300)
    ListView rvSearchResult;
    public ArrayList<SearchWordResult.DataBean> searchData = new ArrayList<>();
    private SearchResultFragment searchResultFragment;
    @BindView(2131493373)
    TagsLayout tagsHistoryGroup;
    @BindView(2131493374)
    TagsLayout tagsHotGroup;
    TextWatcher textWatcher = new TextWatcher() {
        /* class com.mi.global.shop.feature.search.SearchActivity.AnonymousClass5 */

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(SearchActivity.this.etvSearchInput.getText().toString())) {
                SearchActivity.this.showSearchResultView(false);
            } else {
                SearchActivity searchActivity = SearchActivity.this;
                searchActivity.requestSearchResult(searchActivity.etvSearchInput.getText().toString());
            }
            SearchActivity.this.showSearchResultPage(false, "");
        }
    };
    @BindView(2131493475)
    CustomTextView tvSearchNoResult;
    @BindView(2131493476)
    CustomTextView tvSearchRecord;

    public void onCreate(Bundle bundle) {
        try {
            requestWindowFeature(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onCreate(bundle);
        ny.O000000o();
        ny.O000000o(this);
        if (this.globalConfigService != null) {
            setCustomContentView(R.layout.feature_search_activity_search_sub_content);
            ButterKnife.bind(this);
            initView();
            initRecommendData();
            return;
        }
        throw new RuntimeException("调用方需要实现 globalShopBase 组件的 Service 包的所有接口。");
    }

    private void initView() {
        setCartViewVisible(false);
        this.layoutSearchContainer = (LinearLayout) findViewById(R.id.layout_search_container);
        this.layoutSearchContainer.setVisibility(0);
        this.etvSearchCancel.setVisibility(0);
        getSearchHistory();
        this.etvSearchInput.addTextChangedListener(this.textWatcher);
        this.etvSearchCancel.setOnClickListener(new View.OnClickListener() {
            /* class com.mi.global.shop.feature.search.SearchActivity.AnonymousClass1 */

            public void onClick(View view) {
                byp.O000000o("cancel_click", SearchActivity.this.isResultShowed ? "search_landing" : "search_jump");
                SearchActivity.this.finish();
            }
        });
        this.btnHistoryClear.setOnClickListener(new View.OnClickListener() {
            /* class com.mi.global.shop.feature.search.SearchActivity.AnonymousClass2 */

            public void onClick(View view) {
                bys.O000000o(SearchActivity.this, "pref_key_search_history_list", new ArrayList());
                SearchActivity.this.tagsHistoryGroup.removeAllViews();
                SearchActivity.this.layoutSearchRecord.setVisibility(8);
                byp.O000000o("delete_click", "search_jump");
            }
        });
        this.rvSearchResult.setDivider(null);
        this.rvSearchResult.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.mi.global.shop.feature.search.SearchActivity.AnonymousClass3 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.bys.O000000o(android.content.Context, java.lang.String, java.lang.Class):T
             arg types: [com.mi.global.shop.feature.search.SearchActivity, java.lang.String, java.lang.Class]
             candidates:
              _m_j.bys.O000000o(android.content.Context, java.lang.String, java.lang.Object):void
              _m_j.bys.O000000o(android.content.Context, java.lang.String, java.lang.Class):T */
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (SearchActivity.this.searchData.get(i) != null) {
                    if (!TextUtils.isEmpty(SearchActivity.this.searchData.get(i).tag)) {
                        ny.O000000o();
                        ny.O000000o("/globalShop/webActivity").withString("url", SearchActivity.this.connectionHelperService.O00000Oo() + SearchActivity.this.connectionHelperService.O00000o0() + "/" + SearchActivity.this.searchData.get(i).tag).navigation();
                    } else {
                        SearchActivity searchActivity = SearchActivity.this;
                        searchActivity.showSearchResultPage(true, searchActivity.searchData.get(i).name);
                        byp.O000000o("%s_click", "search_associative", "asssociative", SearchActivity.this.searchData.get(i).name);
                    }
                    SearchActivity.this.etvSearchInput.removeTextChangedListener(SearchActivity.this.textWatcher);
                    SearchActivity.this.etvSearchInput.setText(SearchActivity.this.searchData.get(i).name);
                    SearchActivity.this.etvSearchInput.setSelection(SearchActivity.this.etvSearchInput.getText().length());
                    SearchActivity.this.etvSearchInput.addTextChangedListener(SearchActivity.this.textWatcher);
                    ArrayList arrayList = (ArrayList) bys.O000000o((Context) SearchActivity.this, "pref_key_search_history_list", ArrayList.class);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(SearchActivity.this.searchData.get(i).name);
                    bys.O000000o(SearchActivity.this, "pref_key_search_history_list", arrayList);
                    byp.O000000o(String.format("%s_click", SearchActivity.this.searchData.get(i)), "search_associative");
                    SearchActivity.this.adapter.clear();
                    SearchActivity.this.adapter.notifyDataSetChanged();
                }
            }
        });
        this.etvSearchInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* class com.mi.global.shop.feature.search.SearchActivity.AnonymousClass4 */

            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 3 && i != 4 && i != 6 && i != 0) {
                    return false;
                }
                InputMethodManager inputMethodManager = (InputMethodManager) textView.getContext().getSystemService("input_method");
                if (inputMethodManager.isActive()) {
                    inputMethodManager.hideSoftInputFromWindow(textView.getApplicationWindowToken(), 0);
                }
                if (!TextUtils.isEmpty(SearchActivity.this.etvSearchInput.getText())) {
                    byp.O00000Oo("search_click", "search_jump", "search", SearchActivity.this.etvSearchInput.getText().toString());
                    SearchActivity searchActivity = SearchActivity.this;
                    searchActivity.showSearchResultPage(true, searchActivity.etvSearchInput.getText().toString());
                }
                return true;
            }
        });
    }

    public void showSearchResultPage(boolean z, String str) {
        if (isActivityAlive(this)) {
            this.isResultShowed = z;
            if (z) {
                this.tvSearchNoResult.setVisibility(8);
                this.searchResultFragment = SearchResultFragment.newInstance(str);
                getSupportFragmentManager().O000000o().O00000Oo(R.id.root_view, this.searchResultFragment, TAG).O00000o0();
                return;
            }
            SearchResultFragment searchResultFragment2 = this.searchResultFragment;
            if (searchResultFragment2 != null && searchResultFragment2.isAdded()) {
                getSupportFragmentManager().O000000o().O000000o(this.searchResultFragment).O00000o0();
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bys.O000000o(android.content.Context, java.lang.String, java.lang.Class):T
     arg types: [com.mi.global.shop.feature.search.SearchActivity, java.lang.String, java.lang.Class]
     candidates:
      _m_j.bys.O000000o(android.content.Context, java.lang.String, java.lang.Object):void
      _m_j.bys.O000000o(android.content.Context, java.lang.String, java.lang.Class):T */
    private void getSearchHistory() {
        ArrayList arrayList = (ArrayList) bys.O000000o((Context) this, "pref_key_search_history_list", ArrayList.class);
        if (arrayList == null || arrayList.size() <= 0) {
            this.layoutSearchRecord.setVisibility(8);
            return;
        }
        fillSearchHistoryLabel(this.tagsHistoryGroup, arrayList);
        this.layoutSearchRecord.setVisibility(0);
    }

    private void initRecommendData() {
        Object obj;
        Uri.Builder buildUpon = Uri.parse(this.connectionHelperService.O000000o()).buildUpon();
        buildUpon.appendQueryParameter("type", "android");
        AnonymousClass6 r1 = new SimpleCallback<SearchRecommendResult>() {
            /* class com.mi.global.shop.feature.search.SearchActivity.AnonymousClass6 */

            public void success(SearchRecommendResult searchRecommendResult) {
                if (searchRecommendResult == null || searchRecommendResult.data == null || searchRecommendResult.data.recommend == null || searchRecommendResult.data.recommend.size() <= 0) {
                    SearchActivity.this.layoutSearchHot.setVisibility(8);
                    return;
                }
                SearchActivity searchActivity = SearchActivity.this;
                searchActivity.fillSearchRecommendLabel(searchActivity.tagsHotGroup, searchRecommendResult.data.recommend);
            }

            public void error(String str) {
                super.error(str);
            }
        };
        if (this.globalConfigService.O00000Oo()) {
            obj = new SimpleProtobufRequest(buildUpon.toString(), SearchRecommendResult.class, r1);
        } else {
            obj = new SimpleJsonRequest(buildUpon.toString(), SearchRecommendResult.class, r1);
        }
        ced.f13683O000000o.add(obj);
    }

    public void requestSearchResult(final String str) {
        Object obj;
        Uri.Builder buildUpon = Uri.parse(this.connectionHelperService.O000000o(str)).buildUpon();
        AnonymousClass7 r1 = new SimpleCallback<SearchWordResult>() {
            /* class com.mi.global.shop.feature.search.SearchActivity.AnonymousClass7 */

            public void success(SearchWordResult searchWordResult) {
                if (TextUtils.equals(SearchActivity.this.etvSearchInput.getText().toString(), str)) {
                    if (searchWordResult != null && searchWordResult.data != null) {
                        SearchActivity.this.searchData.clear();
                        if (searchWordResult.data.item != null) {
                            SearchActivity.this.searchData.addAll(searchWordResult.data.item);
                        }
                        if (searchWordResult.data.list != null && searchWordResult.data.list.size() > 0) {
                            for (int i = 0; i < searchWordResult.data.list.size(); i++) {
                                SearchWordResult.DataBean dataBean = new SearchWordResult.DataBean();
                                dataBean.name = searchWordResult.data.list.get(i);
                                SearchActivity.this.searchData.add(dataBean);
                            }
                        }
                        if (SearchActivity.this.adapter == null) {
                            SearchActivity searchActivity = SearchActivity.this;
                            searchActivity.adapter = new SearchResultListAdapter(searchActivity, str, searchActivity.searchData);
                            SearchActivity.this.rvSearchResult.setAdapter((ListAdapter) SearchActivity.this.adapter);
                        }
                        SearchActivity.this.adapter.setKeyWord(str);
                        SearchActivity.this.adapter.notifyDataSetChanged();
                        SearchActivity.this.showSearchResultView(true);
                    } else if (searchWordResult.data == null) {
                        SearchActivity.this.rvSearchResult.setVisibility(8);
                        SearchActivity.this.tvSearchNoResult.setVisibility(0);
                    }
                }
            }

            public void error(String str) {
                super.error(str);
            }
        };
        if (this.globalConfigService.O00000Oo()) {
            obj = new SimpleProtobufRequest(buildUpon.toString(), SearchWordResult.class, r1);
        } else {
            obj = new SimpleJsonRequest(buildUpon.toString(), SearchWordResult.class, r1);
        }
        ced.f13683O000000o.add(obj);
    }

    public void showSearchResultView(boolean z) {
        if (z) {
            this.tvSearchNoResult.setVisibility(8);
            this.rvSearchResult.setVisibility(0);
            this.layoutSearchRecord.setVisibility(8);
            this.layoutSearchHot.setVisibility(8);
            return;
        }
        this.tvSearchNoResult.setVisibility(8);
        this.rvSearchResult.setVisibility(8);
        this.layoutSearchHot.setVisibility(0);
        getSearchHistory();
    }

    public void fillSearchHistoryLabel(TagsLayout tagsLayout, List<String> list) {
        if (tagsLayout != null && list != null) {
            if (tagsLayout.getChildCount() > 0) {
                tagsLayout.removeAllViews();
            }
            for (final String next : list) {
                if (!TextUtils.isEmpty(next)) {
                    addTextView(tagsLayout, next, new View.OnClickListener() {
                        /* class com.mi.global.shop.feature.search.SearchActivity.AnonymousClass8 */

                        public void onClick(View view) {
                            SearchActivity.this.etvSearchInput.removeTextChangedListener(SearchActivity.this.textWatcher);
                            SearchActivity.this.etvSearchInput.setText(next);
                            SearchActivity.this.etvSearchInput.setSelection(SearchActivity.this.etvSearchInput.getText().length());
                            SearchActivity.this.etvSearchInput.addTextChangedListener(SearchActivity.this.textWatcher);
                            SearchActivity.this.showSearchResultPage(true, next);
                            byp.O000000o(String.format("%s_click", next), "search_jump");
                        }
                    });
                }
            }
        }
    }

    public void fillSearchRecommendLabel(TagsLayout tagsLayout, List<SearchRecommendResult.Recommend> list) {
        if (tagsLayout != null && list != null) {
            if (tagsLayout.getChildCount() > 0) {
                tagsLayout.removeAllViews();
            }
            for (final SearchRecommendResult.Recommend next : list) {
                if (!TextUtils.isEmpty(next.name)) {
                    addTextView(tagsLayout, next.name, new View.OnClickListener() {
                        /* class com.mi.global.shop.feature.search.SearchActivity.AnonymousClass9 */

                        public void onClick(View view) {
                            if (!TextUtils.isEmpty(next.link)) {
                                byp.O000000o(String.format("%s_click", next.name), "search_jump");
                                ny.O000000o();
                                ny.O000000o("/globalShop/webActivity").withString("url", next.link).navigation();
                            }
                        }
                    });
                }
            }
        }
    }

    private void addTextView(TagsLayout tagsLayout, String str, View.OnClickListener onClickListener) {
        TagsLayout.LayoutParams layoutParams = new TagsLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(cdy.O000000o(10.0f), cdy.O000000o(10.0f), 0, 0);
        TextView textView = new TextView(tagsLayout.getContext());
        textView.setText(str);
        textView.setTextSize(13.0f);
        textView.setGravity(17);
        textView.setIncludeFontPadding(false);
        textView.setPadding(cdy.O000000o(11.0f), 0, cdy.O000000o(11.0f), 0);
        textView.setSingleLine();
        textView.setTextColor(Color.parseColor("#424242"));
        textView.setHeight(cdy.O000000o(30.0f));
        textView.setBackgroundResource(R.drawable.feature_search_search_label_bg);
        textView.setOnClickListener(onClickListener);
        tagsLayout.addView(textView, layoutParams);
    }
}
