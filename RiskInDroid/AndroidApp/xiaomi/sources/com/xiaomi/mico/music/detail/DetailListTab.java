package com.xiaomi.mico.music.detail;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaomi.mico.music.OpenQQMusicVIPView;
import com.xiaomi.smarthome.R;

public class DetailListTab extends RelativeLayout {
    private DetailPlayAllListener listPlayAllListener;
    private DetailListTabListener listTabListener;
    TextView mContent;
    TextView mIntro;
    OpenQQMusicVIPView openQQMusicVIPView;
    View playAllContain;
    ImageView sort;
    private DetailSortListener sortListener;
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

    public DetailListTab(Context context) {
        super(context);
        init(context);
    }

    public DetailListTab(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        View.inflate(context, R.layout.view_music_list_detail_tab, this);
        this.playAllContain = findViewById(R.id.play_all_contain);
        this.tabLayoutContain = findViewById(R.id.tab_layout_contain);
        this.sort = (ImageView) findViewById(R.id.music_list_sort);
        this.sort.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.music.detail.$$Lambda$DetailListTab$AdvdE5YiXRxLH4C9FpJfnfvIPk */

            public final void onClick(View view) {
                DetailListTab.this.lambda$init$0$DetailListTab(view);
            }
        });
        this.mIntro = (TextView) findViewById(R.id.button_introduction);
        this.mIntro.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.music.detail.$$Lambda$DetailListTab$kKPsJiFp4WWw1OqqhBhEyeDRFQ */

            public final void onClick(View view) {
                DetailListTab.this.lambda$init$1$DetailListTab(view);
            }
        });
        this.mContent = (TextView) findViewById(R.id.button_content);
        this.mContent.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.music.detail.$$Lambda$DetailListTab$d7VeOjztVhmedDMBzzx8QTvP_8 */

            public final void onClick(View view) {
                DetailListTab.this.lambda$init$2$DetailListTab(view);
            }
        });
        findViewById(R.id.music_play_all_icon).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.music.detail.$$Lambda$DetailListTab$mg7O8u0FDKo77D867ag0_0moe4 */

            public final void onClick(View view) {
                DetailListTab.this.lambda$init$3$DetailListTab(view);
            }
        });
        findViewById(R.id.music_play_all_play).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.music.detail.$$Lambda$DetailListTab$HHmpWQWkrgQqqHoF1lyWPYPlDr4 */

            public final void onClick(View view) {
                DetailListTab.this.lambda$init$4$DetailListTab(view);
            }
        });
        this.openQQMusicVIPView = (OpenQQMusicVIPView) findViewById(R.id.openVipViews);
    }

    /* renamed from: onClick */
    public void lambda$init$4$DetailListTab(View view) {
        DetailPlayAllListener detailPlayAllListener;
        int id = view.getId();
        if (id == R.id.button_introduction) {
            DetailListTabListener detailListTabListener = this.listTabListener;
            if (detailListTabListener != null) {
                detailListTabListener.onClickIntro();
            }
            selectedIntro();
        } else if (id == R.id.button_content) {
            DetailListTabListener detailListTabListener2 = this.listTabListener;
            if (detailListTabListener2 != null) {
                detailListTabListener2.onClickContent();
            }
            selectedContent();
        } else if (id == R.id.music_list_sort) {
            DetailSortListener detailSortListener = this.sortListener;
            if (detailSortListener != null) {
                detailSortListener.onClickSort();
            }
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

    public void setListTabListener(DetailListTabListener detailListTabListener) {
        this.listTabListener = detailListTabListener;
    }

    public void setPlayAllListener(DetailPlayAllListener detailPlayAllListener) {
        this.listPlayAllListener = detailPlayAllListener;
    }

    public void setSortListener(DetailSortListener detailSortListener) {
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
