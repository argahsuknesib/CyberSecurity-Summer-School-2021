package com.xiaomi.mico.common.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.ButterKnife;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.common.recyclerview.adapter.GroupAdapter;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.common.util.Cache;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.common.util.ObjectStoreHelper;
import com.xiaomi.mico.common.widget.SearchTagsView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import java.util.LinkedList;
import java.util.List;

public class SearchTagsView extends RelativeLayout {
    private ApiRequest apiRequest;
    public HotAdapter hotAdapter;
    RecyclerView mHotView;
    private OnSearchListener onSearchListener;
    private CharSequence title;

    public interface OnSearchListener {
        void onSearch(String str);
    }

    public SearchTagsView(Context context) {
        super(context);
        initView(context, null, 0);
    }

    public SearchTagsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context, attributeSet, 0);
    }

    public SearchTagsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context, attributeSet, i);
    }

    private void initView(Context context, AttributeSet attributeSet, int i) {
        LayoutInflater.from(context).inflate((int) R.layout.view_linear_recycler_view, this);
        ButterKnife.bind(this);
        this.mHotView = (RecyclerView) findViewById(R.id.linear_recycle_view);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.hot_title}, i, 0);
            this.title = obtainStyledAttributes.getText(0);
            obtainStyledAttributes.recycle();
        }
        setupHotView();
    }

    private void setupHotView() {
        this.hotAdapter = new HotAdapter(this.title);
        this.mHotView.setAdapter(this.hotAdapter);
        this.hotAdapter.updateHotKeys((List) Cache.get("Music_Search_Hot_Key", List.class));
        this.apiRequest = ApiHelper.getHotKeys(new ApiRequest.Listener<List<String>>() {
            /* class com.xiaomi.mico.common.widget.SearchTagsView.AnonymousClass1 */

            public void onFailure(ApiError apiError) {
            }

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                onSuccess((List<String>) ((List) obj));
            }

            public void onSuccess(List<String> list) {
                Cache.put("Music_Search_Hot_Key", list);
                if (SearchTagsView.this.hotAdapter != null) {
                    SearchTagsView.this.hotAdapter.updateHotKeys(list);
                }
            }
        });
    }

    public void setOnSearchListener(OnSearchListener onSearchListener2) {
        this.onSearchListener = onSearchListener2;
    }

    public void addOrUpdateHistoryKey(String str) {
        this.hotAdapter.addOrUpdateHistoryKey(str);
    }

    public void search(String str) {
        OnSearchListener onSearchListener2 = this.onSearchListener;
        if (onSearchListener2 != null) {
            onSearchListener2.onSearch(str);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.apiRequest.cancel();
        ApiRequest apiRequest2 = this.apiRequest;
        if (apiRequest2 != null) {
            apiRequest2.cancel();
            this.apiRequest = null;
        }
    }

    class HotAdapter extends GroupAdapter<ItemClickableAdapter.ViewHolder> implements ItemClickableAdapter.OnItemClickListener, HeaderViewHolder.Listener, HistoryViewHolder.Listener, HotViewHolder.Listener, ItemViewHolder.Listener {
        public List<String> historyKeys;

        public void onLongClick(String str) {
        }

        private HotAdapter(CharSequence charSequence) {
            this.historyKeys = new LinkedList();
            addGroup(new HotGroup(null, charSequence));
            String string = getSP().getString("search_history", null);
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
            return SearchTagsView.this.getContext().getSharedPreferences("Search", 0);
        }

        public void persistHistoryKeys() {
            getSP().edit().putString("search_history", ObjectStoreHelper.encode(this.historyKeys)).apply();
        }

        public void updateHotKeys(List<String> list) {
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
            SearchTagsView.this.search((String) getItem(i));
        }

        public void onSearch(String str) {
            SearchTagsView.this.search(str);
        }

        public void onClear() {
            if (this.historyKeys.size() > 0) {
                this.historyKeys.clear();
                persistHistoryKeys();
                notifyDataSetChanged();
            }
        }

        public void onDelete(final String str) {
            MLAlertDialog.Builder O000000o2 = new MLAlertDialog.Builder(SearchTagsView.this.getContext()).O000000o((int) R.string.mico_common_hint);
            O000000o2.O00000Oo("确定删除搜索记录 " + str + " ?").O00000Oo((int) R.string.common_cancel, (DialogInterface.OnClickListener) null).O000000o((int) R.string.common_confirm, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.mico.common.widget.SearchTagsView.HotAdapter.AnonymousClass1 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    HotAdapter.this.historyKeys.remove(str);
                    HotAdapter.this.persistHistoryKeys();
                    HotAdapter.this.notifyDataSetChanged();
                }
            }).O00000oo();
        }

        public void setHotViewTitle(int i) {
            SearchTagsView.this.hotAdapter.setHotViewTitle(i);
        }
    }

    static class HotGroup extends GroupAdapter.Group<ItemClickableAdapter.ViewHolder> {
        private List<String> hotKeys;
        private CharSequence hotTitle;

        public String getID() {
            return "hot";
        }

        public int getItemViewType(int i) {
            return 1;
        }

        private HotGroup(List<String> list, CharSequence charSequence) {
            this.hotKeys = list;
            this.hotTitle = charSequence;
        }

        public void updateHotKeys(List<String> list) {
            this.hotKeys = list;
        }

        public int getHeaderCount() {
            List<String> list = this.hotKeys;
            return (list == null || list.isEmpty()) ? 0 : 1;
        }

        public void onBindViewHolder(ItemClickableAdapter.ViewHolder viewHolder, int i) {
            ((HotViewHolder) viewHolder).bindView(this.hotKeys, this.hotTitle);
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

        public void bindView(List<String> list, CharSequence charSequence) {
            if (!TextUtils.isEmpty(charSequence)) {
                this.mItemTitle.setText(charSequence);
            }
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
                /* class com.xiaomi.mico.common.widget.$$Lambda$SearchTagsView$HeaderViewHolder$MuAizVFlDnk4PQFzfwfszUULu4 */

                public final void onClick(View view) {
                    SearchTagsView.HeaderViewHolder.this.lambda$new$0$SearchTagsView$HeaderViewHolder(view);
                }
            });
            this.listener = listener2;
        }

        public /* synthetic */ void lambda$new$0$SearchTagsView$HeaderViewHolder(View view) {
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
                /* class com.xiaomi.mico.common.widget.$$Lambda$SearchTagsView$ItemViewHolder$W4rX81CbNxDMOfid56UwdEWDE */

                public final void onClick(View view) {
                    SearchTagsView.ItemViewHolder.this.lambda$new$0$SearchTagsView$ItemViewHolder(view);
                }
            });
            this.listener = listener2;
        }

        public /* synthetic */ void lambda$new$0$SearchTagsView$ItemViewHolder(View view) {
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
                /* class com.xiaomi.mico.common.widget.$$Lambda$SearchTagsView$HistoryViewHolder$5Zs28PCobglnEaPhoVEuKBkREf8 */

                public final void onClick(View view) {
                    SearchTagsView.HistoryViewHolder.this.lambda$new$0$SearchTagsView$HistoryViewHolder(view);
                }
            });
            this.listener = listener2;
        }

        public /* synthetic */ void lambda$new$0$SearchTagsView$HistoryViewHolder(View view) {
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
