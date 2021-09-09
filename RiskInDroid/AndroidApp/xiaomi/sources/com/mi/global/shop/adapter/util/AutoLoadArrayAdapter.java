package com.mi.global.shop.adapter.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mi.global.shop.widget.CustomTextView;
import com.xiaomi.smarthome.R;

public abstract class AutoLoadArrayAdapter<T> extends ArrayAdapter<T> {

    /* renamed from: O000000o  reason: collision with root package name */
    public O000000o f4828O000000o;
    private LoadMoreStatus O00000Oo;

    public enum LoadMoreStatus {
        idle,
        loading,
        error,
        disable
    }

    public interface O000000o {
        void O000000o();
    }

    public int getViewTypeCount() {
        return 2;
    }

    public class LoadMoreViewHolder_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private LoadMoreViewHolder f4831O000000o;

        public LoadMoreViewHolder_ViewBinding(LoadMoreViewHolder loadMoreViewHolder, View view) {
            this.f4831O000000o = loadMoreViewHolder;
            loadMoreViewHolder.mContent = Utils.findRequiredView(view, R.id.load_more_content, "field 'mContent'");
            loadMoreViewHolder.mProgressBar = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.load_more_progressBar, "field 'mProgressBar'", ProgressBar.class);
            loadMoreViewHolder.mMoreText = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.load_more_text, "field 'mMoreText'", CustomTextView.class);
        }

        public void unbind() {
            LoadMoreViewHolder loadMoreViewHolder = this.f4831O000000o;
            if (loadMoreViewHolder != null) {
                this.f4831O000000o = null;
                loadMoreViewHolder.mContent = null;
                loadMoreViewHolder.mProgressBar = null;
                loadMoreViewHolder.mMoreText = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public AutoLoadArrayAdapter(Context context) {
        super(context);
    }

    public final void O000000o(LoadMoreStatus loadMoreStatus) {
        this.O00000Oo = loadMoreStatus;
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View getView(int i, View view, ViewGroup viewGroup) {
        LoadMoreViewHolder loadMoreViewHolder;
        if (getItemViewType(i) != 0) {
            return super.getView(i, view, viewGroup);
        }
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.shop_load_more_layout, viewGroup, false);
            loadMoreViewHolder = new LoadMoreViewHolder(view);
            view.setTag(loadMoreViewHolder);
        } else {
            loadMoreViewHolder = (LoadMoreViewHolder) view.getTag();
        }
        LoadMoreStatus loadMoreStatus = this.O00000Oo;
        O000000o o000000o = this.f4828O000000o;
        int i2 = AnonymousClass1.f4829O000000o[loadMoreStatus.ordinal()];
        if (i2 == 1) {
            loadMoreViewHolder.mProgressBar.setVisibility(8);
            loadMoreViewHolder.mMoreText.setText((int) R.string.more_error);
            loadMoreViewHolder.mContent.setOnClickListener(new View.OnClickListener(o000000o) {
                /* class com.mi.global.shop.adapter.util.AutoLoadArrayAdapter.LoadMoreViewHolder.AnonymousClass1 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ O000000o f4830O000000o;

                {
                    this.f4830O000000o = r2;
                }

                public final void onClick(View view) {
                    O000000o o000000o = this.f4830O000000o;
                    if (o000000o != null) {
                        o000000o.O000000o();
                    }
                }
            });
        } else if (i2 == 2) {
            loadMoreViewHolder.mProgressBar.setVisibility(0);
            loadMoreViewHolder.mMoreText.setText((int) R.string.more_loading);
            if (o000000o != null) {
                o000000o.O000000o();
            }
            loadMoreViewHolder.mContent.setOnClickListener(null);
        } else if (i2 == 3) {
            loadMoreViewHolder.mProgressBar.setVisibility(0);
            loadMoreViewHolder.mMoreText.setText((int) R.string.more_loading);
            loadMoreViewHolder.mContent.setOnClickListener(null);
        } else if (i2 == 4) {
            loadMoreViewHolder.mProgressBar.setVisibility(8);
            loadMoreViewHolder.mMoreText.setText((int) R.string.no_more);
            loadMoreViewHolder.mContent.setOnClickListener(null);
        }
        if (this.O00000Oo == LoadMoreStatus.idle) {
            O000000o(LoadMoreStatus.loading);
        }
        return view;
    }

    public int getCount() {
        return O000000o() + (this.O00000Oo == LoadMoreStatus.disable ? 0 : 1);
    }

    public int getItemViewType(int i) {
        return i < O000000o() ? 1 : 0;
    }

    public Object getItem(int i) {
        if (i >= O000000o() || this.O00000oO == null) {
            return null;
        }
        return this.O00000oO.get(i);
    }

    private int O000000o() {
        if (this.O00000oO != null) {
            return this.O00000oO.size();
        }
        return 0;
    }

    static class LoadMoreViewHolder {
        @BindView(2131493685)
        View mContent;
        @BindView(2131493690)
        CustomTextView mMoreText;
        @BindView(2131493689)
        ProgressBar mProgressBar;

        LoadMoreViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    /* renamed from: com.mi.global.shop.adapter.util.AutoLoadArrayAdapter$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f4829O000000o = new int[LoadMoreStatus.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            f4829O000000o[LoadMoreStatus.error.ordinal()] = 1;
            f4829O000000o[LoadMoreStatus.idle.ordinal()] = 2;
            f4829O000000o[LoadMoreStatus.loading.ordinal()] = 3;
            try {
                f4829O000000o[LoadMoreStatus.disable.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}
