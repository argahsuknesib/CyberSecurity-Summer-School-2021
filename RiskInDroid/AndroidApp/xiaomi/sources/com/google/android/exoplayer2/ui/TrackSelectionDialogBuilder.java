package com.google.android.exoplayer2.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.xiaomi.smarthome.R;
import java.util.Collections;
import java.util.List;

public final class TrackSelectionDialogBuilder {
    private boolean allowAdaptiveSelections;
    private boolean allowMultipleOverrides;
    private final DialogCallback callback;
    private final Context context;
    private boolean isDisabled;
    private final MappingTrackSelector.MappedTrackInfo mappedTrackInfo;
    private List<DefaultTrackSelector.SelectionOverride> overrides;
    private final int rendererIndex;
    private boolean showDisableOption;
    private final CharSequence title;
    private TrackNameProvider trackNameProvider;

    public interface DialogCallback {
        void onTracksSelected(boolean z, List<DefaultTrackSelector.SelectionOverride> list);
    }

    public TrackSelectionDialogBuilder(Context context2, CharSequence charSequence, MappingTrackSelector.MappedTrackInfo mappedTrackInfo2, int i, DialogCallback dialogCallback) {
        this.context = context2;
        this.title = charSequence;
        this.mappedTrackInfo = mappedTrackInfo2;
        this.rendererIndex = i;
        this.callback = dialogCallback;
        this.overrides = Collections.emptyList();
    }

    public TrackSelectionDialogBuilder(Context context2, CharSequence charSequence, DefaultTrackSelector defaultTrackSelector, int i) {
        this.context = context2;
        this.title = charSequence;
        this.mappedTrackInfo = (MappingTrackSelector.MappedTrackInfo) Assertions.checkNotNull(defaultTrackSelector.getCurrentMappedTrackInfo());
        this.rendererIndex = i;
        TrackGroupArray trackGroups = this.mappedTrackInfo.getTrackGroups(i);
        DefaultTrackSelector.Parameters parameters = defaultTrackSelector.getParameters();
        this.isDisabled = parameters.getRendererDisabled(i);
        DefaultTrackSelector.SelectionOverride selectionOverride = parameters.getSelectionOverride(i, trackGroups);
        this.overrides = selectionOverride == null ? Collections.emptyList() : Collections.singletonList(selectionOverride);
        this.callback = new DialogCallback(parameters, i, trackGroups) {
            /* class com.google.android.exoplayer2.ui.$$Lambda$TrackSelectionDialogBuilder$SJJCZZJJjIw7uRbYhQYc32lsWqk */
            private final /* synthetic */ DefaultTrackSelector.Parameters f$1;
            private final /* synthetic */ int f$2;
            private final /* synthetic */ TrackGroupArray f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void onTracksSelected(boolean z, List list) {
                TrackSelectionDialogBuilder.lambda$new$0(DefaultTrackSelector.this, this.f$1, this.f$2, this.f$3, z, list);
            }
        };
    }

    static /* synthetic */ void lambda$new$0(DefaultTrackSelector defaultTrackSelector, DefaultTrackSelector.Parameters parameters, int i, TrackGroupArray trackGroupArray, boolean z, List list) {
        defaultTrackSelector.setParameters(TrackSelectionUtil.updateParametersWithOverride(parameters, i, trackGroupArray, z, list.isEmpty() ? null : (DefaultTrackSelector.SelectionOverride) list.get(0)));
    }

    public final TrackSelectionDialogBuilder setIsDisabled(boolean z) {
        this.isDisabled = z;
        return this;
    }

    public final TrackSelectionDialogBuilder setOverride(DefaultTrackSelector.SelectionOverride selectionOverride) {
        return setOverrides(selectionOverride == null ? Collections.emptyList() : Collections.singletonList(selectionOverride));
    }

    public final TrackSelectionDialogBuilder setOverrides(List<DefaultTrackSelector.SelectionOverride> list) {
        this.overrides = list;
        return this;
    }

    public final TrackSelectionDialogBuilder setAllowAdaptiveSelections(boolean z) {
        this.allowAdaptiveSelections = z;
        return this;
    }

    public final TrackSelectionDialogBuilder setAllowMultipleOverrides(boolean z) {
        this.allowMultipleOverrides = z;
        return this;
    }

    public final TrackSelectionDialogBuilder setShowDisableOption(boolean z) {
        this.showDisableOption = z;
        return this;
    }

    public final TrackSelectionDialogBuilder setTrackNameProvider(TrackNameProvider trackNameProvider2) {
        this.trackNameProvider = trackNameProvider2;
        return this;
    }

    public final AlertDialog build() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        View inflate = LayoutInflater.from(builder.getContext()).inflate((int) R.layout.exo_track_selection_dialog, (ViewGroup) null);
        TrackSelectionView trackSelectionView = (TrackSelectionView) inflate.findViewById(R.id.exo_track_selection_view);
        trackSelectionView.setAllowMultipleOverrides(this.allowMultipleOverrides);
        trackSelectionView.setAllowAdaptiveSelections(this.allowAdaptiveSelections);
        trackSelectionView.setShowDisableOption(this.showDisableOption);
        TrackNameProvider trackNameProvider2 = this.trackNameProvider;
        if (trackNameProvider2 != null) {
            trackSelectionView.setTrackNameProvider(trackNameProvider2);
        }
        trackSelectionView.init(this.mappedTrackInfo, this.rendererIndex, this.isDisabled, this.overrides, null);
        return builder.setTitle(this.title).setView(inflate).setPositiveButton(17039370, new DialogInterface.OnClickListener(trackSelectionView) {
            /* class com.google.android.exoplayer2.ui.$$Lambda$TrackSelectionDialogBuilder$VaO5kTTQd_Ci4_bzaz_It3r8zXM */
            private final /* synthetic */ TrackSelectionView f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                TrackSelectionDialogBuilder.this.lambda$build$1$TrackSelectionDialogBuilder(this.f$1, dialogInterface, i);
            }
        }).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).create();
    }

    public /* synthetic */ void lambda$build$1$TrackSelectionDialogBuilder(TrackSelectionView trackSelectionView, DialogInterface dialogInterface, int i) {
        this.callback.onTracksSelected(trackSelectionView.getIsDisabled(), trackSelectionView.getOverrides());
    }
}
