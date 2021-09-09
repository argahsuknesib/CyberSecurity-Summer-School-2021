package com.xiaomi.mico.music.search;

import _m_j.jgc;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.base.MicoBaseActivity;
import com.xiaomi.mico.common.adapter.SimplePagerAdapter;
import com.xiaomi.mico.common.recyclerview.adapter.GroupAdapter;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.common.util.ObjectStoreHelper;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.mico.common.widget.FluidLayout;
import com.xiaomi.mico.common.widget.SearchBarV2;
import com.xiaomi.mico.music.event.MusicEvent;
import com.xiaomi.mico.music.search.SchBaseFragment;
import com.xiaomi.mico.music.search.SearchAudioActivity;
import com.xiaomi.mico.music.search.SearchContainer;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import java.util.LinkedList;
import java.util.List;

public class SearchAudioActivity extends MicoBaseActivity implements SchBaseFragment.AudioProvider, SchBaseFragment.KeyProvider {
    private String blockTitle;
    private int categoryType;
    private List<String> cpList;
    private ApiRequest mApiRequest;
    LinearLayout mContent;
    private HotAdapter mHotAdapter;
    RecyclerView mHotView;
    private String mKey;
    SearchBarV2 mSearchBar;
    SearchContainer mSearchContainer;
    TabLayout mTabLayout;
    ViewPager mViewPager;

    public boolean isDarkMode() {
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_search);
        this.mSearchBar = (SearchBarV2) findViewById(R.id.title_bar);
        this.mSearchContainer = (SearchContainer) findViewById(R.id.search_container);
        this.mHotView = (RecyclerView) findViewById(R.id.linear_recycle_view);
        this.mContent = (LinearLayout) findViewById(R.id.search_content);
        this.mTabLayout = (TabLayout) findViewById(R.id.search_content_tab_layout);
        this.mViewPager = (ViewPager) findViewById(R.id.search_content_view_pager);
        this.blockTitle = getIntent().getStringExtra("block_title");
        this.categoryType = getIntent().getIntExtra("block_category_type", -1);
        this.cpList = getIntent().getStringArrayListExtra("block_cp_list");
        this.mSearchBar.setListener(new SearchBarV2.Listener() {
            /* class com.xiaomi.mico.music.search.SearchAudioActivity.AnonymousClass1 */

            public void onBack() {
                SearchAudioActivity.this.finish();
            }

            public void onClear() {
                if (SearchAudioActivity.this.mHotView.getVisibility() != 0) {
                    SearchAudioActivity.this.mHotView.setVisibility(0);
                    SearchAudioActivity.this.mContent.setVisibility(8);
                }
            }

            public void onSearch(String str) {
                SearchAudioActivity.this.doSearch(str);
            }
        });
        this.mSearchContainer.setOnTouchStartListener(new SearchContainer.OnTouchStartListener() {
            /* class com.xiaomi.mico.music.search.$$Lambda$SearchAudioActivity$ACCnCrmoXy0MCiGEuuD6vCdOiM */

            public final void onTouchStart() {
                SearchAudioActivity.this.lambda$onCreate$0$SearchAudioActivity();
            }
        });
        setupHotView();
        this.mViewPager.setAdapter(new SimplePagerAdapter(getSupportFragmentManager(), new SchStationFragment()));
        this.mTabLayout.setVisibility(8);
    }

    public /* synthetic */ void lambda$onCreate$0$SearchAudioActivity() {
        this.mSearchBar.clearEditorFocus();
    }

    public void onDestroy() {
        super.onDestroy();
        ApiRequest apiRequest = this.mApiRequest;
        if (apiRequest != null) {
            apiRequest.cancel();
            this.mApiRequest = null;
        }
    }

    public String getKey() {
        return this.mKey;
    }

    private void setupHotView() {
        this.mHotAdapter = new HotAdapter();
        this.mHotView.setAdapter(this.mHotAdapter);
    }

    public void search(String str) {
        this.mSearchBar.search(str);
    }

    public void doSearch(String str) {
        if (str != null && !TextUtils.isEmpty(str.trim())) {
            this.mSearchBar.clearEditorFocus();
            this.mHotAdapter.addOrUpdateHistoryKey(str);
            this.mHotView.setVisibility(8);
            this.mContent.setVisibility(0);
            if (!str.equalsIgnoreCase(this.mKey)) {
                this.mKey = str;
                jgc.O000000o().O00000o(new MusicEvent.SearchKeyChanged(str));
            }
        }
    }

    public String getSearchTag() {
        return this.blockTitle;
    }

    public int getCategoryType() {
        return this.categoryType;
    }

    public List<String> getSearchCpList() {
        return this.cpList;
    }

    class HotAdapter extends GroupAdapter<ItemClickableAdapter.ViewHolder> implements ItemClickableAdapter.OnItemClickListener, HeaderViewHolder.Listener, HistoryViewHolder.Listener, HotViewHolder.Listener, ItemViewHolder.Listener {
        public List<String> historyKeys;

        private HotAdapter() {
            this.historyKeys = new LinkedList();
            addGroup(new HotGroup(null));
            String string = getSP().getString(getHistorySearchKey(), null);
            if (!TextUtils.isEmpty(string)) {
                List list = (List) ObjectStoreHelper.decode(string);
                if (ContainerUtil.hasData(list)) {
                    this.historyKeys.addAll(list);
                }
            }
            addGroup(new HistoryGroup(this.historyKeys));
            setOnItemClickListener(this);
        }

        private SharedPreferences getSP() {
            return SearchAudioActivity.this.getSharedPreferences("Search", 0);
        }

        public void persistHistoryKeys() {
            getSP().edit().putString(getHistorySearchKey(), ObjectStoreHelper.encode(this.historyKeys)).apply();
        }

        private String getHistorySearchKey() {
            return "search_history" + SearchAudioActivity.this.getSearchTag();
        }

        private void updateHotKeys(List<String> list) {
            GroupAdapter.Group groupByID = getGroupByID("hot");
            if (groupByID != null) {
                ((HotGroup) groupByID).updateHotKeys(list);
                notifyDataSetChanged();
            }
        }

        public void addOrUpdateHistoryKey(String str) {
            int indexOf = this.historyKeys.indexOf(str);
            if (indexOf != 0) {
                if (indexOf != -1) {
                    this.historyKeys.remove(indexOf);
                }
                this.historyKeys.add(0, str);
                persistHistoryKeys();
                notifyDataSetChanged();
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public ItemClickableAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == 1) {
                return new HotViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_music_search_hot, viewGroup, false), this);
            }
            if (i == 2) {
                return new HeaderViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_search_header, viewGroup, false), this);
            }
            if (i == 4) {
                return new HistoryViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_music_search_history, viewGroup, false), this);
            }
            return new ItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_search_item, viewGroup, false), this.onItemClickListener, this);
        }

        public void onItemClick(ItemClickableAdapter.ViewHolder viewHolder, int i) {
            SearchAudioActivity.this.search((String) getItem(i));
        }

        public void onSearch(String str) {
            SearchAudioActivity.this.search(str);
        }

        public void onLongClick(String str) {
            ToastUtil.showToast(String.valueOf(str));
        }

        public void onClear() {
            if (this.historyKeys.size() > 0) {
                this.historyKeys.clear();
                persistHistoryKeys();
                notifyDataSetChanged();
            }
        }

        public void onDelete(final String str) {
            MLAlertDialog.Builder O000000o2 = new MLAlertDialog.Builder(SearchAudioActivity.this.getContext()).O000000o((int) R.string.mico_common_hint);
            O000000o2.O00000Oo("确定删除搜索记录 " + str + " ?").O00000Oo((int) R.string.common_cancel, (DialogInterface.OnClickListener) null).O000000o((int) R.string.common_confirm, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.mico.music.search.SearchAudioActivity.HotAdapter.AnonymousClass1 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    HotAdapter.this.historyKeys.remove(str);
                    HotAdapter.this.persistHistoryKeys();
                    HotAdapter.this.notifyDataSetChanged();
                }
            }).O00000oo();
        }
    }

    static class HotGroup extends GroupAdapter.Group<ItemClickableAdapter.ViewHolder> {
        private List<String> hotKeys;

        public String getID() {
            return "hot";
        }

        public int getItemViewType(int i) {
            return 1;
        }

        private HotGroup(List<String> list) {
            this.hotKeys = list;
        }

        public void updateHotKeys(List<String> list) {
            this.hotKeys = list;
        }

        public int getHeaderCount() {
            List<String> list = this.hotKeys;
            return (list == null || list.isEmpty()) ? 0 : 1;
        }

        public void onBindViewHolder(ItemClickableAdapter.ViewHolder viewHolder, int i) {
            ((HotViewHolder) viewHolder).bindView(this.hotKeys);
        }
    }

    static class HistoryGroup extends GroupAdapter.Group<ItemClickableAdapter.ViewHolder> {
        private List<String> historyKeys;

        public String getID() {
            return "history";
        }

        public int getItemViewType(int i) {
            return 4;
        }

        private HistoryGroup(List<String> list) {
            this.historyKeys = list;
        }

        public int getHeaderCount() {
            List<String> list = this.historyKeys;
            return (list == null || list.isEmpty()) ? 0 : 1;
        }

        public String getItem(int i) {
            return this.historyKeys.get(i);
        }

        public void onBindViewHolder(ItemClickableAdapter.ViewHolder viewHolder, int i) {
            ((HistoryViewHolder) viewHolder).bindView(this.historyKeys);
        }
    }

    static class HotViewHolder extends ItemClickableAdapter.ViewHolder implements View.OnClickListener {
        FluidLayout hot;
        private Listener listener;
        TextView mItemTitle;

        interface Listener {
            void onSearch(String str);
        }

        private HotViewHolder(View view, Listener listener2) {
            super(view, null);
            this.hot = (FluidLayout) view.findViewById(R.id.search_hot);
            this.mItemTitle = (TextView) view.findViewById(R.id.item_title);
            this.listener = listener2;
        }

        public void onClick(View view) {
            if (view instanceof TextView) {
                this.listener.onSearch(((TextView) view).getText().toString());
            }
        }

        public void bindView(List<String> list) {
            this.hot.removeAllViews();
            for (String item : list) {
                TextView item2 = getItem(this.itemView.getContext(), item);
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, this.itemView.getResources().getDimensionPixelSize(R.dimen.music_hot_key_height));
                int dimensionPixelSize = this.itemView.getResources().getDimensionPixelSize(R.dimen.music_hot_key_margin);
                marginLayoutParams.setMargins(0, 0, dimensionPixelSize, dimensionPixelSize);
                this.hot.addView(item2, marginLayoutParams);
            }
        }

        private TextView getItem(Context context, String str) {
            TextView textView = new TextView(context);
            textView.setGravity(16);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.music_hot_key_padding);
            textView.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            textView.setText(str);
            textView.setTextSize(0, this.itemView.getResources().getDimension(R.dimen.prompt_text_size));
            textView.setTextColor(context.getResources().getColor(R.color.mj_color_black));
            textView.setBackgroundResource(R.drawable.bg_hot_music_gray);
            textView.setOnClickListener(this);
            return textView;
        }
    }

    static class HeaderViewHolder extends ItemClickableAdapter.ViewHolder {
        private Listener listener;

        interface Listener {
            void onClear();
        }

        private HeaderViewHolder(View view, Listener listener2) {
            super(view, null);
            view.findViewById(R.id.search_header_clear).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.music.search.$$Lambda$SearchAudioActivity$HeaderViewHolder$5H3DuHWSp6_YqikgPM2k9yyiTI */

                public final void onClick(View view) {
                    SearchAudioActivity.HeaderViewHolder.this.lambda$new$0$SearchAudioActivity$HeaderViewHolder(view);
                }
            });
            this.listener = listener2;
        }

        public /* synthetic */ void lambda$new$0$SearchAudioActivity$HeaderViewHolder(View view) {
            onClick();
        }

        public void onClick() {
            this.listener.onClear();
        }
    }

    static class ItemViewHolder extends ItemClickableAdapter.ViewHolder {
        private Listener listener;
        TextView text;

        interface Listener {
            void onDelete(String str);
        }

        private ItemViewHolder(View view, ItemClickableAdapter.OnItemClickListener onItemClickListener, Listener listener2) {
            super(view, onItemClickListener);
            this.text = (TextView) view.findViewById(R.id.search_item_text);
            view.findViewById(R.id.search_item_delete).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.music.search.$$Lambda$SearchAudioActivity$ItemViewHolder$9EALtVNPsC1bYrZzbOFGlDa6W1Y */

                public final void onClick(View view) {
                    SearchAudioActivity.ItemViewHolder.this.lambda$new$0$SearchAudioActivity$ItemViewHolder(view);
                }
            });
            this.listener = listener2;
        }

        public /* synthetic */ void lambda$new$0$SearchAudioActivity$ItemViewHolder(View view) {
            onClick();
        }

        public void onClick() {
            this.listener.onDelete(this.text.getText().toString());
        }

        private void bindView(String str) {
            this.text.setText(str);
        }
    }

    static class HistoryViewHolder extends ItemClickableAdapter.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        FluidLayout hot;
        private Listener listener;

        interface Listener {
            void onClear();

            void onDelete(String str);

            void onLongClick(String str);

            void onSearch(String str);
        }

        private HistoryViewHolder(View view, Listener listener2) {
            super(view, null);
            this.hot = (FluidLayout) view.findViewById(R.id.search_history);
            view.findViewById(R.id.history_clear).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.music.search.$$Lambda$SearchAudioActivity$HistoryViewHolder$qSfAVE_Ilg_QAWX1KCsmJeU49g */

                public final void onClick(View view) {
                    SearchAudioActivity.HistoryViewHolder.this.lambda$new$0$SearchAudioActivity$HistoryViewHolder(view);
                }
            });
            this.listener = listener2;
        }

        public /* synthetic */ void lambda$new$0$SearchAudioActivity$HistoryViewHolder(View view) {
            onClick();
        }

        public void onClick(View view) {
            if (view instanceof TextView) {
                this.listener.onSearch(((TextView) view).getText().toString());
            }
        }

        public void onClick() {
            this.listener.onClear();
        }

        public boolean onLongClick(View view) {
            if (!(view instanceof TextView)) {
                return false;
            }
            this.listener.onDelete(((TextView) view).getText().toString());
            return true;
        }

        public void bindView(List<String> list) {
            this.hot.removeAllViews();
            for (String item : list) {
                TextView item2 = getItem(this.itemView.getContext(), item);
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, this.itemView.getResources().getDimensionPixelSize(R.dimen.music_hot_key_height));
                int dimensionPixelSize = this.itemView.getResources().getDimensionPixelSize(R.dimen.music_hot_key_margin);
                marginLayoutParams.setMargins(0, 0, dimensionPixelSize, dimensionPixelSize);
                this.hot.addView(item2, marginLayoutParams);
            }
        }

        private TextView getItem(Context context, String str) {
            TextView textView = new TextView(context);
            textView.setGravity(16);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.music_hot_key_padding);
            textView.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            textView.setText(str);
            textView.setTextSize(0, this.itemView.getResources().getDimension(R.dimen.prompt_text_size));
            textView.setTextColor(context.getResources().getColor(R.color.mj_color_black));
            textView.setBackgroundResource(R.drawable.bg_hot_music_gray);
            textView.setOnClickListener(this);
            textView.setOnLongClickListener(this);
            return textView;
        }
    }
}
