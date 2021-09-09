package com.xiaomi.mico.music.detail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.smarthome.R;

public class DetailPaymentTab extends LinearLayout {
    DetailPaymentTabListener listener;
    TextView mPurchase;

    public interface DetailPaymentTabListener {
        void onClickFreeTrial();

        void onClickPurchase();
    }

    public DetailPaymentTab(Context context) {
        super(context);
        init(context);
    }

    public DetailPaymentTab(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        View.inflate(context, R.layout.view_music_list_payment_tab, this);
        this.mPurchase = (TextView) findViewById(R.id.purchase);
        this.mPurchase.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.music.detail.$$Lambda$DetailPaymentTab$XayNqKAul5fwdVln3b5MH7m7l0 */

            public final void onClick(View view) {
                DetailPaymentTab.this.lambda$init$0$DetailPaymentTab(view);
            }
        });
        findViewById(R.id.free_trial).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.music.detail.$$Lambda$DetailPaymentTab$Rwu4z2UjYlp73G_0IQQHTGSSDRk */

            public final void onClick(View view) {
                DetailPaymentTab.this.lambda$init$1$DetailPaymentTab(view);
            }
        });
    }

    /* renamed from: onClick */
    public void lambda$init$1$DetailPaymentTab(View view) {
        DetailPaymentTabListener detailPaymentTabListener;
        int id = view.getId();
        if (id == R.id.purchase) {
            DetailPaymentTabListener detailPaymentTabListener2 = this.listener;
            if (detailPaymentTabListener2 != null) {
                detailPaymentTabListener2.onClickPurchase();
            }
        } else if (id == R.id.free_trial && (detailPaymentTabListener = this.listener) != null) {
            detailPaymentTabListener.onClickFreeTrial();
        }
    }

    public void updatePurchaseBtnVisibility(Music.Station station) {
        this.mPurchase.setVisibility(station.needOverall() ? 0 : 8);
    }

    public void setPrice(long j) {
        if (j < 0) {
            this.mPurchase.setText((int) R.string.music_book_price_coming);
            return;
        }
        double d = (double) j;
        Double.isNaN(d);
        this.mPurchase.setText(getContext().getString(R.string.music_book_price, Float.valueOf((float) (d / 100.0d))));
    }

    public float getPrice(long j) {
        double d = (double) j;
        Double.isNaN(d);
        return (float) (d / 100.0d);
    }

    public void setListener(DetailPaymentTabListener detailPaymentTabListener) {
        this.listener = detailPaymentTabListener;
    }
}
