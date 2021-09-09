package com.xiaomi.mico.music.detail;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaomi.mico.music.OpenQQMusicVIPView;
import com.xiaomi.mico.music.detail.DetailListTab;
import com.xiaomi.smarthome.R;

public class DetailListTab2 extends RelativeLayout {
    private DetailListTab.DetailPlayAllListener listPlayAllListener;
    private DetailListTab.DetailListTabListener listTabListener;
    TextView mContent;
    TextView mIntro;
    OpenQQMusicVIPView openQQMusicVIPView;
    View playAllContain;
    ImageView sort;
    private DetailListTab.DetailSortListener sortListener;
    View tabLayoutContain;

    public interface DetailListTabListener {
        void onClickContent();

        void onClickIntro();
    }

    public interface DetailPlayAllListener {
        void onPlayAll();
    }

    public interface DetailSortListener {
        void onClickSort();
    }

    public DetailListTab2(Context context) {
        super(context);
        init(context);
    }

    public DetailListTab2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        View.inflate(context, R.layout.view_music_list_detail_tab2, this);
        this.playAllContain = findViewById(R.id.play_all_contain);
        this.tabLayoutContain = findViewById(R.id.tab_layout_contain);
        this.mIntro = (TextView) findViewById(R.id.button_introduction);
        this.mIntro.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.music.detail.$$Lambda$DetailListTab2$NGJb8YQka25cFzUl6QoK5CmVPAQ */

            public final void onClick(View view) {
                DetailListTab2.this.lambda$init$0$DetailListTab2(view);
            }
        });
        this.mContent = (TextView) findViewById(R.id.button_content);
        this.mContent.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.music.detail.$$Lambda$DetailListTab2$tGHLYejC5vkaVFrVSHyrFY6DFk */

            public final void onClick(View view) {
                DetailListTab2.this.lambda$init$1$DetailListTab2(view);
            }
        });
        findViewById(R.id.music_play_all_icon).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.music.detail.$$Lambda$DetailListTab2$wjCOCrKCs3BUokkOGypB7ZAQZkQ */

            public final void onClick(View view) {
                DetailListTab2.this.lambda$init$2$DetailListTab2(view);
            }
        });
        findViewById(R.id.music_play_all_play).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.music.detail.$$Lambda$DetailListTab2$gAFJ0fczKCV2g1F2zB7EqrZBkQ */

            public final void onClick(View view) {
                DetailListTab2.this.lambda$init$3$DetailListTab2(view);
            }
        });
        this.openQQMusicVIPView = (OpenQQMusicVIPView) findViewById(R.id.openVipViews);
    }

    /* renamed from: onClick */
    public void lambda$init$3$DetailListTab2(View view) {
        DetailListTab.DetailPlayAllListener detailPlayAllListener;
        int id = view.getId();
        if (id == R.id.button_introduction) {
            DetailListTab.DetailListTabListener detailListTabListener = this.listTabListener;
            if (detailListTabListener != null) {
                detailListTabListener.onClickIntro();
            }
            selectedIntro();
        } else if (id == R.id.button_content) {
            DetailListTab.DetailListTabListener detailListTabListener2 = this.listTabListener;
            if (detailListTabListener2 != null) {
                detailListTabListener2.onClickContent();
            }
            selectedContent();
        } else if ((id == R.id.music_play_all_icon || id == R.id.music_play_all_play) && (detailPlayAllListener = this.listPlayAllListener) != null) {
            detailPlayAllListener.onPlayAll();
        }
    }

    public void selectedContent() {
        this.mContent.setSelected(true);
        this.mIntro.setSelected(false);
        this.mContent.setTypeface(Typeface.defaultFromStyle(1));
        this.mIntro.setTypeface(Typeface.defaultFromStyle(0));
    }

    public void selectedIntro() {
        this.mContent.setSelected(false);
        this.mIntro.setSelected(true);
        this.mIntro.setTypeface(Typeface.defaultFromStyle(1));
        this.mContent.setTypeface(Typeface.defaultFromStyle(0));
    }

    public void updateOpenVipViewVisibility() {
        OpenQQMusicVIPView openQQMusicVIPView2 = this.openQQMusicVIPView;
        openQQMusicVIPView2.updateOpenVipViewVisibility(openQQMusicVIPView2.getContext());
    }

    public void hidePlayAllAndTabView() {
        this.tabLayoutContain.setVisibility(8);
        this.playAllContain.setVisibility(8);
    }

    public void showTabView() {
        this.tabLayoutContain.setVisibility(0);
        this.playAllContain.setVisibility(8);
    }

    public void showPlayAllView() {
        this.playAllContain.setVisibility(0);
        this.tabLayoutContain.setVisibility(8);
    }

    public void setListTabListener(DetailListTab.DetailListTabListener detailListTabListener) {
        this.listTabListener = detailListTabListener;
    }

    public void setPlayAllListener(DetailListTab.DetailPlayAllListener detailPlayAllListener) {
        this.listPlayAllListener = detailPlayAllListener;
    }

    public void setSortListener(DetailListTab.DetailSortListener detailSortListener) {
        this.sortListener = detailSortListener;
        ImageView imageView = this.sort;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    public void setSortStatus(boolean z) {
        this.sort.setVisibility(z ? 0 : 8);
    }
}
