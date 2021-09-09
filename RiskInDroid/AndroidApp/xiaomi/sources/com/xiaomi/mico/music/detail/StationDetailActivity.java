package com.xiaomi.mico.music.detail;

import _m_j.czx;
import _m_j.dai;
import _m_j.hxi;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Optional;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.xiaomi.mico.api.ApiConstants;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.ObservableApiHelper;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.base.MicoBaseActivity;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.common.recyclerview.adapter.SingleAdapter;
import com.xiaomi.mico.common.util.CommonUtils;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.mico.common.widget.OnPurchaseResultListener;
import com.xiaomi.mico.common.widget.OverallPurchaseHelper;
import com.xiaomi.mico.common.widget.SingleEpisodePurchaseHelper;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.PaymentWebActivity;
import com.xiaomi.mico.music.detail.DetailListTab;
import com.xiaomi.mico.music.detail.DetailPaymentTab;
import com.xiaomi.mico.music.detail.DetailTitleBar;
import com.xiaomi.mico.music.player.PlayerActivityV2;
import com.xiaomi.mico.music.player.PlayerStatusTrack;
import com.xiaomi.mico.setting.babyschedule.BabyScheduleEditActivity;
import com.xiaomi.smarthome.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONObject;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func1;

public class StationDetailActivity extends MicoBaseActivity implements ItemClickableAdapter.OnItemClickListener, DetailListTab.DetailListTabListener, DetailListTab.DetailPlayAllListener, DetailListTab.DetailSortListener, PlayerStatusTrack.onTrackListener {
    public AudioBookAdapter audioBookAdapter;
    private boolean currentTabIsNovel;
    private boolean isShowIntro;
    private ApiRequest mApiRequest;
    DetailHeader mDetailHeader;
    RecyclerView mRecyclerView;
    public Music.Station mStation;
    private Subscription mSubscription;
    DetailTitleBar mTitleBar;
    public boolean needRefreshData;
    public OverallPurchaseHelper overallPurchaseHelper;
    public int page = 1;
    DetailPaymentTab paymentTab;
    View paymentTabShadow;
    SmartRefreshLayout refreshLayout;
    public boolean showPurchaseResultToast;
    private SingleEpisodePurchaseHelper singleEpisodePurchaseHelper;
    TextView stationIntro;
    View stationIntroContain;
    WebView stationIntroWeb;

    public static void statListenCount(Music.Station station) {
        if (station == null) {
        }
    }

    private void statShowCount(Music.Station station) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_detail_general_loadmore_payment);
        this.mStation = (Music.Station) getIntent().getSerializableExtra("music");
        this.currentTabIsNovel = getIntent().getBooleanExtra("INTENT_KEY_CURRENT_TAB_IS_NOVEL", false);
        if (this.mStation == null) {
            finish();
            return;
        }
        findViewById(R.id.headerContainer);
        this.mDetailHeader = (DetailHeader) findViewById(R.id.detail_header);
        this.refreshLayout = (SmartRefreshLayout) findViewById(R.id.refresh_layout);
        this.paymentTab = (DetailPaymentTab) findViewById(R.id.payment_tab);
        this.paymentTabShadow = findViewById(R.id.payment_tab_shadow);
        this.stationIntro = (TextView) findViewById(R.id.station_intro);
        this.stationIntroContain = findViewById(R.id.station_intro_contain);
        this.stationIntroWeb = (WebView) findViewById(R.id.station_intro_web);
        this.stationIntroWeb.setBackgroundColor(0);
        this.stationIntroWeb.setLayerType(1, null);
        this.mTitleBar = (DetailTitleBar) findViewById(R.id.title_bar);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.linear_recycle_view);
        findViewById(R.id.babySchedule).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.music.detail.$$Lambda$StationDetailActivity$sSX0MAONYplO9v9D8hlYPTAW31A */

            public final void onClick(View view) {
                StationDetailActivity.this.lambda$onCreate$0$StationDetailActivity(view);
            }
        });
        this.mTitleBar.addPlayerIndicator(new DetailTitleBar.PlayerIndicatorStatClickListener() {
            /* class com.xiaomi.mico.music.detail.StationDetailActivity.AnonymousClass1 */

            public void onStatClick() {
                hxi.O00000o.O000000o("content_children_player", (JSONObject) null);
            }
        });
        this.mDetailHeader.setMusic(this.mStation, true);
        this.audioBookAdapter = new AudioBookAdapter(!ApiConstants.isAreaCodeInTaiWan());
        getResources().getDimensionPixelSize(R.dimen.music_item_header_height);
        this.audioBookAdapter.setOnItemClickListener(this);
        this.mRecyclerView.setAdapter(this.audioBookAdapter);
        this.refreshLayout.O00000o0(false);
        this.refreshLayout.O0000O0o(true);
        this.refreshLayout.O00000o(true);
        this.refreshLayout.O000000o(new dai() {
            /* class com.xiaomi.mico.music.detail.$$Lambda$StationDetailActivity$i9u9OW0A1aboxuqKmb248xxGm7w */

            public final void onLoadMore(czx czx) {
                StationDetailActivity.this.lambda$onCreate$1$StationDetailActivity(czx);
            }
        });
        getStationInfo2();
        this.paymentTab.setListener(new DetailPaymentTab.DetailPaymentTabListener() {
            /* class com.xiaomi.mico.music.detail.StationDetailActivity.AnonymousClass2 */

            public void onClickFreeTrial() {
                StationDetailActivity.this.onItemClick(null, 0);
            }

            public void onClickPurchase() {
                StationDetailActivity stationDetailActivity = StationDetailActivity.this;
                stationDetailActivity.overallPurchaseHelper = new OverallPurchaseHelper(stationDetailActivity, stationDetailActivity.mStation, StationDetailActivity.this.getIntent().getStringExtra("INTENT_KEY_ACTION"));
                StationDetailActivity.this.overallPurchaseHelper.showPopupView();
                hxi.O00000o.f952O000000o.O000000o("content_sound_buy", new Object[0]);
            }
        });
        this.mDetailHeader.mTabView.setListTabListener(this);
        this.mDetailHeader.mTabView.setPlayAllListener(this);
        this.mDetailHeader.mTabView.setSortListener(this);
        this.mDetailHeader.mTabView.setSortStatus(!ApiConstants.isAreaCodeInTaiWan());
        this.stationIntroWeb.getSettings().setSupportZoom(false);
        hxi.O00000o0.O00000o0(3);
    }

    public /* synthetic */ void lambda$onCreate$1$StationDetailActivity(czx czx) {
        getStationSoundList(this.page * 20, this.mStation.saleType);
    }

    public void onResume() {
        WebSettings settings;
        super.onResume();
        PlayerStatusTrack.getInstance().register(this);
        this.mTitleBar.onResume();
        if (this.needRefreshData && thisActivityIsForegroundRunning()) {
            getStationInfo2();
        }
        if (Build.VERSION.SDK_INT >= 29 && (settings = this.stationIntroWeb.getSettings()) != null) {
            if ((getResources().getConfiguration().uiMode & 48) == 32) {
                settings.setForceDark(2);
            } else {
                settings.setForceDark(0);
            }
        }
    }

    private boolean thisActivityIsForegroundRunning() {
        try {
            return ((ActivityManager) getSystemService("activity")).getRunningTasks(1).get(0).topActivity.getClassName().equals(StationDetailActivity.class.getName());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void onPause() {
        super.onPause();
        PlayerStatusTrack.getInstance().unregister(this);
        this.mTitleBar.onPause();
    }

    public void onTrack(Remote.Response.PlayerStatus playerStatus) {
        this.mTitleBar.updatePlayerStatus(playerStatus);
        AudioBookAdapter audioBookAdapter2 = this.audioBookAdapter;
        if (audioBookAdapter2 != null) {
            audioBookAdapter2.updatePlayingMusicID(MusicHelper.getPlayingMusicID(playerStatus));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        SingleEpisodePurchaseHelper singleEpisodePurchaseHelper2 = this.singleEpisodePurchaseHelper;
        if (singleEpisodePurchaseHelper2 != null) {
            singleEpisodePurchaseHelper2.onActivityResult(i, i2, intent);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        Subscription subscription = this.mSubscription;
        if (subscription != null && !subscription.isUnsubscribed()) {
            this.mSubscription.unsubscribe();
            this.mSubscription = null;
        }
        ApiRequest apiRequest = this.mApiRequest;
        if (apiRequest != null) {
            apiRequest.cancel();
            this.mApiRequest = null;
        }
        SingleEpisodePurchaseHelper singleEpisodePurchaseHelper2 = this.singleEpisodePurchaseHelper;
        if (singleEpisodePurchaseHelper2 != null) {
            singleEpisodePurchaseHelper2.release();
            this.singleEpisodePurchaseHelper = null;
        }
        OverallPurchaseHelper overallPurchaseHelper2 = this.overallPurchaseHelper;
        if (overallPurchaseHelper2 != null) {
            overallPurchaseHelper2.release();
            this.overallPurchaseHelper = null;
        }
    }

    @Optional
    /* renamed from: onClick */
    public void lambda$onCreate$0$StationDetailActivity(View view) {
        BabyScheduleEditActivity.start(this, this.mStation);
    }

    /* access modifiers changed from: protected */
    public void onPlay(List<Music.Station> list, int i, MusicHelper.OnPlayingListener onPlayingListener) {
        MusicHelper.playStations(list, i, onPlayingListener, this.mStation.stationID, this.mStation.isReverse);
    }

    public void getStationInfo2() {
        this.mSubscription = ObservableApiHelper.getStationInfo(new Music.Station.Simple(this.mStation.globalID, this.mStation.stationID, this.mStation.origin, MusicHelper.convertStationType(this.mStation.type))).flatMap(new Func1() {
            /* class com.xiaomi.mico.music.detail.$$Lambda$StationDetailActivity$DWxPJjNyoGcOfDiFeSltgylQ4d0 */

            public final Object call(Object obj) {
                return StationDetailActivity.this.lambda$getStationInfo2$2$StationDetailActivity((Music.Station) obj);
            }
        }).subscribe(new Action1() {
            /* class com.xiaomi.mico.music.detail.$$Lambda$StationDetailActivity$1aiRtU0n0PeSuslZjISwH_iwxN8 */

            public final void call(Object obj) {
                StationDetailActivity.this.lambda$getStationInfo2$3$StationDetailActivity((Music.StationSoundList) obj);
            }
        }, new Action1() {
            /* class com.xiaomi.mico.music.detail.$$Lambda$StationDetailActivity$H9QFctn0QdCGmCBpnGRvXeb5MMU */

            public final void call(Object obj) {
                StationDetailActivity.this.lambda$getStationInfo2$4$StationDetailActivity((Throwable) obj);
            }
        });
    }

    public /* synthetic */ Observable lambda$getStationInfo2$2$StationDetailActivity(Music.Station station) {
        this.mStation = station;
        updateHeaderView(station, this.isShowIntro);
        showPurchaseResultToast();
        return ObservableApiHelper.getStationSoundList(this.mStation.stationID, this.mStation.getOriginToGetStationList(), this.mStation.category, 0, 20, this.mStation.isReverse, Integer.valueOf(this.mStation.saleType));
    }

    public /* synthetic */ void lambda$getStationInfo2$3$StationDetailActivity(Music.StationSoundList stationSoundList) {
        this.needRefreshData = false;
        this.page = 1;
        this.refreshLayout.O0000O0o();
        this.audioBookAdapter.updateDataList(stationSoundList.soundList);
        this.refreshLayout.O0000O0o(!stationSoundList.isEnd);
        dismissProgressDialog();
    }

    public /* synthetic */ void lambda$getStationInfo2$4$StationDetailActivity(Throwable th) {
        this.needRefreshData = false;
        this.refreshLayout.O0000O0o();
        dismissProgressDialog();
    }

    private void showPurchaseResultToast() {
        if (this.showPurchaseResultToast) {
            if (this.mStation.bought) {
                SingleEpisodePurchaseHelper.showPurchaseSuccessToast();
            } else {
                SingleEpisodePurchaseHelper.showPurchaseFailedToast();
            }
            this.showPurchaseResultToast = false;
        }
    }

    private void getStationSoundList(final int i, int i2) {
        this.mApiRequest = ApiHelper.getStationSoundList(this.mStation.stationID, this.mStation.getOriginToGetStationList(), this.mStation.category, i, 20, this.mStation.isReverse, Integer.valueOf(i2), new ApiRequest.Listener<Music.StationSoundList>() {
            /* class com.xiaomi.mico.music.detail.StationDetailActivity.AnonymousClass3 */

            public void onSuccess(Music.StationSoundList stationSoundList) {
                StationDetailActivity.this.refreshLayout.O0000O0o();
                if (i <= 0) {
                    StationDetailActivity.this.audioBookAdapter.updateDataList(stationSoundList.soundList);
                    StationDetailActivity.this.page = 1;
                } else {
                    StationDetailActivity.this.page++;
                    StationDetailActivity.this.audioBookAdapter.addDataList(stationSoundList.soundList);
                }
                StationDetailActivity.this.refreshLayout.O0000O0o(!stationSoundList.isEnd);
                StationDetailActivity.this.dismissProgressDialog();
            }

            public void onFailure(ApiError apiError) {
                StationDetailActivity.this.refreshLayout.O0000O0o();
                StationDetailActivity.this.dismissProgressDialog();
            }
        });
    }

    private void updateHeaderView(Music.Station station, boolean z) {
        this.mDetailHeader.updateMusic(this.mStation);
        DetailHeader detailHeader = this.mDetailHeader;
        Music.Station station2 = this.mStation;
        detailHeader.updateBabyScheduleIconVisibility(station2, station2.fromAddBabySchedule);
        statShowCount(station);
        if (ApiConstants.isAreaCodeInTaiWan()) {
            onClickContent();
            this.mDetailHeader.showPlayAllView();
        } else if (needBought(station)) {
            this.mDetailHeader.showTabView();
            if (z) {
                this.mDetailHeader.mTabView.selectedIntro();
                onClickIntro();
            } else {
                this.mDetailHeader.mTabView.selectedContent();
                onClickContent();
            }
            this.paymentTab.setPrice(station.salesPrice);
            this.paymentTab.updatePurchaseBtnVisibility(station);
            this.stationIntro.setText(station.albumAbstract);
            if (station.salesPrice < 0) {
                this.mDetailHeader.updateDescInfo(getString(R.string.music_book_price_pending));
            } else if (this.mStation.supportSingleEpisodePurchase()) {
                this.mDetailHeader.updateDescInfo(getResources().getString(R.string.music_book_unit_price_yuan, Float.valueOf(this.paymentTab.getPrice(station.salesPrice))));
            } else {
                this.mDetailHeader.updateDescInfo(getResources().getString(R.string.music_book_price_yuan, Float.valueOf(this.paymentTab.getPrice(station.salesPrice))));
            }
        } else {
            this.paymentTab.setVisibility(8);
            this.paymentTabShadow.setVisibility(8);
            this.mDetailHeader.showPlayAllView();
            onClickContent();
            if (TextUtils.isEmpty(station.albumAbstract)) {
                this.mDetailHeader.updateDescInfo(getResources().getString(R.string.music_desc_nothing), false, false);
                return;
            }
            this.mDetailHeader.updateDescInfo(getResources().getString(R.string.music_desc, station.albumAbstract), true, true);
        }
    }

    private boolean needBought(Music.Station station) {
        return station.saleType > 0 && !station.bought;
    }

    public void onClickIntro() {
        Music.Station station = this.mStation;
        if (station != null) {
            String str = station.h5Url;
            if (str == null || str.isEmpty()) {
                this.stationIntroContain.setVisibility(0);
            } else {
                this.stationIntroWeb.loadUrl(str);
                this.stationIntroWeb.setVisibility(0);
                if (Build.VERSION.SDK_INT >= 21) {
                    this.stationIntroWeb.getSettings().setMixedContentMode(0);
                }
            }
        }
        this.paymentTab.setVisibility(0);
        this.paymentTabShadow.setVisibility(0);
        this.refreshLayout.setVisibility(8);
        this.isShowIntro = true;
    }

    public void onClickContent() {
        this.paymentTab.setVisibility(8);
        this.paymentTabShadow.setVisibility(8);
        if (this.mStation.h5Url == null || this.mStation.h5Url.isEmpty()) {
            this.stationIntroContain.setVisibility(8);
        } else {
            this.stationIntroWeb.setVisibility(8);
        }
        this.refreshLayout.setVisibility(0);
        this.isShowIntro = false;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    public static void gotoPay(Activity activity, Music.Station station) {
        if (station == null || TextUtils.isEmpty(station.paymentUrl) || !station.paymentUrl.startsWith("http")) {
            new Object[1][0] = "station info is invalid";
            return;
        }
        Uri.Builder appendQueryParameter = Uri.parse(station.paymentUrl).buildUpon().appendQueryParameter("action", buildAction(station)).appendQueryParameter("productCount", "1").appendQueryParameter("operateMode", "0");
        if (ApiConstants.isPrevEnv()) {
            appendQueryParameter.appendQueryParameter("environment", "1");
        }
        String uri = appendQueryParameter.build().toString();
        Intent intent = new Intent(activity, PaymentWebActivity.class);
        intent.putExtra("common_web_title", "");
        intent.putExtra("common_web_url", uri);
        intent.putExtra("fullscreen", false);
        activity.startActivity(intent);
    }

    private static String buildAction(Music.Station station) {
        return Uri.parse("mico://homepage/station?").buildUpon().appendQueryParameter("id", station.stationID).appendQueryParameter("origin", station.getOriginToGetStationList()).appendQueryParameter("type", "album").appendQueryParameter("saleType", String.valueOf(station.saleType)).appendQueryParameter("category", TextUtils.isEmpty(station.category) ? "book" : station.category).build().toString();
    }

    public void onItemClick(ItemClickableAdapter.ViewHolder viewHolder, int i) {
        List dataList = this.audioBookAdapter.getDataList();
        if (!ContainerUtil.isEmpty(dataList)) {
            statListenCount(this.mStation);
            Music.Station station = (Music.Station) dataList.get(i);
            if (!station.isLegal()) {
                ToastUtil.showToast((int) R.string.music_play_illegal);
                return;
            }
            Music.Station station2 = i >= 0 ? station : null;
            if (station2 != null && TextUtils.equals(MusicHelper.getID(station2), this.audioBookAdapter.getPlayingMusicID())) {
                PlayerActivityV2.displayPlayerWithAnim(getContext());
            } else if (station.needPurchase(this.mStation)) {
                playResourceNotFree(station, dataList, i);
            } else {
                onPlay(dataList, i, new MusicHelper.OnPlayingListener() {
                    /* class com.xiaomi.mico.music.detail.$$Lambda$StationDetailActivity$1CYEiq3YoRmEeTaQz9YaepyRIy4 */

                    public final void onPlaying(String str) {
                        StationDetailActivity.this.lambda$onItemClick$5$StationDetailActivity(str);
                    }
                });
            }
        }
    }

    public /* synthetic */ void lambda$onItemClick$5$StationDetailActivity(String str) {
        this.audioBookAdapter.updatePlayingMusicID(str);
        setStationReverse();
    }

    private void playResourceNotFree(Music.Station station, List<Music.Station> list, int i) {
        if (station == null || station.saleType <= 0) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                Music.Station station2 = list.get(i2);
                if (station2.saleType <= 0) {
                    arrayList.add(station2);
                }
                if (station != null && station2.origin.equals(station.origin) && station2.stationID.equals(station.stationID)) {
                    i = arrayList.size() - 1;
                }
            }
            if (!arrayList.isEmpty()) {
                onPlay(arrayList, i, new MusicHelper.OnPlayingListener() {
                    /* class com.xiaomi.mico.music.detail.$$Lambda$StationDetailActivity$PnCH7qj2y7e0IDOB9HaeByndUmo */

                    public final void onPlaying(String str) {
                        StationDetailActivity.this.lambda$playResourceNotFree$6$StationDetailActivity(str);
                    }
                });
                return;
            }
            return;
        }
        Music.Station station3 = this.mStation;
        if (station3 != null && station3.salesPrice >= 0 && !needSingleEpisodePurchase(station)) {
            this.overallPurchaseHelper = new OverallPurchaseHelper(this, this.mStation, getIntent().getStringExtra("INTENT_KEY_ACTION"));
            this.overallPurchaseHelper.showPopupView();
        }
    }

    public /* synthetic */ void lambda$playResourceNotFree$6$StationDetailActivity(String str) {
        this.audioBookAdapter.updatePlayingMusicID(str);
        setStationReverse();
    }

    private boolean needSingleEpisodePurchase(Music.Station station) {
        boolean isNeedSingleEpisodePurchase = isNeedSingleEpisodePurchase(this.mStation, station, getIntent());
        if (isNeedSingleEpisodePurchase) {
            this.singleEpisodePurchaseHelper = new SingleEpisodePurchaseHelper(this, this.mStation, station, getIntent().getStringExtra("INTENT_KEY_ACTION"), new OnPurchaseResultListener() {
                /* class com.xiaomi.mico.music.detail.StationDetailActivity.AnonymousClass4 */

                public void onPurchaseFailed() {
                }

                public void onPurchaseSuccess() {
                    StationDetailActivity.this.getStationInfo2();
                }
            });
            this.singleEpisodePurchaseHelper.showPopupView();
        }
        return isNeedSingleEpisodePurchase;
    }

    public static boolean isNeedSingleEpisodePurchase(Music.Station station, Music.Station station2, Intent intent) {
        return station != null && station.supportSingleEpisodePurchase() && !station2.bought;
    }

    private void setStationReverse() {
        ApiHelper.setStationReverse(this.mStation, new ApiRequest.Listener<Boolean>() {
            /* class com.xiaomi.mico.music.detail.StationDetailActivity.AnonymousClass5 */

            public void onFailure(ApiError apiError) {
            }

            public void onSuccess(Boolean bool) {
            }
        });
    }

    public void onClickSort() {
        showProgressDialog(null);
        if ("REVERSE".equals(this.mStation.isReverse)) {
            this.mStation.isReverse = "NOT_REVERSE";
        } else {
            this.mStation.isReverse = "REVERSE";
        }
        getStationSoundList(0, this.mStation.saleType);
    }

    public void onPlayAll() {
        hxi.O00000o.O000000o("content_children_tall", (JSONObject) null);
        List dataList = this.audioBookAdapter.getDataList();
        if (!ContainerUtil.isEmpty(dataList)) {
            onPlay(dataList, -1, new MusicHelper.OnPlayingListener() {
                /* class com.xiaomi.mico.music.detail.$$Lambda$StationDetailActivity$6kl6BEBDPPl90GZ97ImOKBq0aQ */

                public final void onPlaying(String str) {
                    StationDetailActivity.this.lambda$onPlayAll$7$StationDetailActivity(str);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onPlayAll$7$StationDetailActivity(String str) {
        this.audioBookAdapter.updatePlayingMusicID(str);
        setStationReverse();
    }

    public class AudioBookAdapter extends SingleAdapter<AudioBookViewHolder, Music.Station> {
        public boolean isSupportTimeDurtion;
        private String playingMusicID;

        AudioBookAdapter(boolean z) {
            this.isSupportTimeDurtion = z;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        /* access modifiers changed from: protected */
        public AudioBookViewHolder onCreateItemViewHolder(ViewGroup viewGroup, int i) {
            return new AudioBookViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_music_audiobook_item_station, viewGroup, false), this.onItemClickListener);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.xiaomi.mico.common.recyclerview.adapter.SingleAdapter.onBindItemViewHolder(com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter$ViewHolder, int):void
         arg types: [com.xiaomi.mico.music.detail.StationDetailActivity$AudioBookAdapter$AudioBookViewHolder, int]
         candidates:
          com.xiaomi.mico.music.detail.StationDetailActivity.AudioBookAdapter.onBindItemViewHolder(com.xiaomi.mico.music.detail.StationDetailActivity$AudioBookAdapter$AudioBookViewHolder, int):void
          com.xiaomi.mico.common.recyclerview.adapter.SingleAdapter.onBindItemViewHolder(com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter$ViewHolder, int):void */
        /* access modifiers changed from: protected */
        public void onBindItemViewHolder(AudioBookViewHolder audioBookViewHolder, int i) {
            super.onBindItemViewHolder((ItemClickableAdapter.ViewHolder) audioBookViewHolder, i);
            Music.Station station = (Music.Station) getData(i);
            AudioBookViewHolder audioBookViewHolder2 = audioBookViewHolder;
            audioBookViewHolder2.bindView(station, MusicHelper.isLegal(station), CommonUtils.equals(MusicHelper.getID(station), this.playingMusicID), StationDetailActivity.this.mStation.isFree(), StationDetailActivity.this.mStation.bought);
        }

        public String getPlayingMusicID() {
            return this.playingMusicID;
        }

        /* access modifiers changed from: package-private */
        public void updatePlayingMusicID(String str) {
            this.playingMusicID = str;
            if (getDataSize() > 0) {
                notifyDataSetChanged();
            }
        }

        class AudioBookViewHolder extends ItemClickableAdapter.ViewHolder {
            View freeTrialLayout;
            View itemNote;
            View ivLock;
            TextView mItemId;
            TextView mMusicDuration;
            TextView mTitle;
            TextView mUpTime;

            AudioBookViewHolder(View view, ItemClickableAdapter.OnItemClickListener onItemClickListener) {
                super(view, onItemClickListener);
                this.freeTrialLayout = view.findViewById(R.id.free_trial_layout);
                this.ivLock = view.findViewById(R.id.ivLock);
                this.itemNote = view.findViewById(R.id.music_item_note);
                this.mItemId = (TextView) view.findViewById(R.id.item_id);
                this.mTitle = (TextView) view.findViewById(R.id.music_item_title);
                this.mUpTime = (TextView) view.findViewById(R.id.up_time);
                this.mMusicDuration = (TextView) view.findViewById(R.id.music_duration);
            }

            /* access modifiers changed from: protected */
            public void bindView(Music.Station station, boolean z, boolean z2, boolean z3, boolean z4) {
                View view;
                this.mTitle.setText(station.title);
                int i = 8;
                if (AudioBookAdapter.this.isSupportTimeDurtion) {
                    this.mItemId.setText(String.valueOf(station.episodesNum));
                    this.itemNote.setVisibility(z2 ? 0 : 8);
                    this.mItemId.setVisibility(z2 ? 8 : 0);
                    if (z3 || z4) {
                        this.freeTrialLayout.setVisibility(8);
                        view = this.ivLock;
                    } else if (station.isFree()) {
                        this.freeTrialLayout.setVisibility(0);
                        view = this.ivLock;
                    } else {
                        this.freeTrialLayout.setVisibility(8);
                        view = this.ivLock;
                        if (!station.bought) {
                            i = 0;
                        }
                    }
                    view.setVisibility(i);
                    this.mTitle.setTextColor(StationDetailActivity.this.getResources().getColor(R.color.mj_color_black));
                    this.mUpTime.setText(updateTimeString(station.updateTime));
                    this.mMusicDuration.setText(durationString(station.duration));
                } else {
                    this.itemNote.setVisibility(8);
                    this.mItemId.setVisibility(8);
                    this.mUpTime.setCompoundDrawables(null, null, null, null);
                    this.mMusicDuration.setCompoundDrawables(null, null, null, null);
                    this.freeTrialLayout.setVisibility(8);
                    this.mUpTime.setText(station.broadcaster);
                    this.mMusicDuration.setText(station.category);
                }
                if (z2) {
                    this.mTitle.setTextColor(StationDetailActivity.this.getResources().getColor(R.color.mj_color_green_normal));
                }
                if (!z) {
                    this.mTitle.setTextColor(StationDetailActivity.this.getResources().getColor(R.color.mj_color_gray_lighter));
                }
            }

            private String durationString(long j) {
                if (j <= 0) {
                    return "--";
                }
                long j2 = j / 3600;
                long j3 = (j - (3600 * j2)) / 60;
                if (j2 > 0) {
                    return StationDetailActivity.this.getString(R.string.music_duration_with_hour, new Object[]{Long.valueOf(j2), Long.valueOf(j3)});
                }
                if (j3 == 0) {
                    j3 = 1;
                }
                return StationDetailActivity.this.getString(R.string.music_duration, new Object[]{Long.valueOf(j3)});
            }

            private String updateTimeString(long j) {
                return new SimpleDateFormat("MM-dd").format(new Date(j));
            }
        }
    }
}
