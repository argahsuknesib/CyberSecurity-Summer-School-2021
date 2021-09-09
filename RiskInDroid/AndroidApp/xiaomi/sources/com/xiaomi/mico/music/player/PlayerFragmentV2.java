package com.xiaomi.mico.music.player;

import _m_j.hxi;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.squareup.picasso.Transformation;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.application.MicoManager;
import com.xiaomi.mico.common.transformation.CropSquareTransformation;
import com.xiaomi.mico.common.util.DisplayUtils;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.smarthome.R;
import java.io.Serializable;

public class PlayerFragmentV2 extends BasePlayerFragment {
    @BindView(6806)
    TextView mArtistName;
    @BindView(6807)
    TextView mAudioName;
    @BindView(6825)
    ImageView mCover;
    @BindView(6815)
    ImageView mLove;
    @BindView(7151)
    ScrollView mScrollView;
    private boolean playingSong;

    /* access modifiers changed from: package-private */
    public void updatePlayerPosition(int i, boolean z) {
    }

    /* access modifiers changed from: package-private */
    public void updatePlayingStatus(boolean z) {
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate((int) R.layout.mico_fragment_player_v2, viewGroup, false);
        ButterKnife.bind(this, inflate);
        int dip2px = DisplayUtils.dip2px(getContext(), 54.0f);
        if (DisplayUtils.getScreenHeightPixels(getContext()) <= 1920) {
            dip2px = DisplayUtils.dip2px(getContext(), 72.0f);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mScrollView.getLayoutParams();
            layoutParams.topMargin = 0;
            this.mScrollView.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mAudioName.getLayoutParams();
            layoutParams2.topMargin = DisplayUtils.dip2px(getContext(), 6.0f);
            this.mAudioName.setLayoutParams(layoutParams2);
        }
        int screenWidthPixels = DisplayUtils.getScreenWidthPixels(getContext()) - dip2px;
        ViewGroup.LayoutParams layoutParams3 = this.mCover.getLayoutParams();
        layoutParams3.height = screenWidthPixels;
        layoutParams3.width = screenWidthPixels;
        this.mCover.setLayoutParams(layoutParams3);
        FragmentActivity activity = getActivity();
        if (activity instanceof PlayerActivityV2) {
            ((PlayerActivityV2) activity).mControlBar.setLoveView(this.mLove);
        }
        return inflate;
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    /* access modifiers changed from: package-private */
    public void updatePlayingMusic(int i, Remote.Response.TrackData trackData) {
        this.playingSong = MusicHelper.isPlayingSong(i);
    }

    /* access modifiers changed from: package-private */
    public void updatePlayingMusic(Serializable serializable) {
        if (!"s6".equals(MicoManager.getInstance().getCurrentMicoType()) || !TextUtils.isEmpty(MusicHelper.getTitle(serializable))) {
            updateCover(MusicHelper.getCover(serializable));
            CharSequence title = MusicHelper.getTitle(serializable);
            if (TextUtils.isEmpty(title)) {
                title = getString(R.string.mico_music_directive_default_title);
            }
            String artistName = serializable instanceof Music.Song ? ((Music.Song) serializable).getArtistName() : null;
            String cpName = MusicHelper.getCpName(serializable);
            if (!TextUtils.isEmpty(artistName)) {
                updateAudioInfo(title, artistName);
            } else {
                updateAudioInfo(title, cpName);
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.mico.music.MusicHelper.loadCover(java.lang.String, android.widget.ImageView, int, int, int, boolean, com.squareup.picasso.Transformation):void
     arg types: [java.lang.String, android.widget.ImageView, ?, ?, ?, int, com.xiaomi.mico.common.transformation.CropSquareTransformation]
     candidates:
      com.xiaomi.mico.music.MusicHelper.loadCover(java.lang.String, android.widget.ImageView, int, int, int, boolean, boolean):void
      com.xiaomi.mico.music.MusicHelper.loadCover(java.lang.String, android.widget.ImageView, int, int, int, boolean, com.squareup.picasso.Transformation):void */
    private void updateCover(String str) {
        MusicHelper.loadCover(str, this.mCover, (int) R.dimen.player_cover_width, (int) R.dimen.player_cover_width, (int) R.drawable.img_cover_player, true, (Transformation) new CropSquareTransformation(15));
    }

    public void updateAudioInfo(CharSequence charSequence, CharSequence charSequence2) {
        TextView textView = this.mAudioName;
        if (TextUtils.isEmpty(charSequence)) {
            charSequence = "";
        }
        textView.setText(charSequence);
        TextView textView2 = this.mArtistName;
        if (TextUtils.isEmpty(charSequence2)) {
            charSequence2 = "";
        }
        textView2.setText(charSequence2);
    }

    /* access modifiers changed from: package-private */
    public void updatePlayingDirective(Remote.Response.Directive directive) {
        updateCover(directive.cover);
        updateAudioInfo(directive.title, MusicHelper.getCpName(directive.origin));
    }

    @OnClick({6825})
    public void onClick(View view) {
        if (view.getId() == R.id.player_cover && this.playingSong) {
            ((PlayerActivityV2) getActivity()).setCurrentItem(1);
            hxi.O00000o.f952O000000o.O000000o("content_playpage_cover", new Object[0]);
        }
    }
}
