package com.google.android.exoplayer2.trackselection;

import android.content.Context;
import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class DefaultTrackSelector extends MappingTrackSelector {
    private static final int[] NO_TRACKS = new int[0];
    private boolean allowMultipleAdaptiveSelections;
    private final AtomicReference<Parameters> parametersReference;
    private final TrackSelection.Factory trackSelectionFactory;

    public static int compareFormatValues(int i, int i2) {
        if (i == -1) {
            return i2 == -1 ? 0 : -1;
        }
        if (i2 == -1) {
            return 1;
        }
        return i - i2;
    }

    public static int compareInts(int i, int i2) {
        if (i > i2) {
            return 1;
        }
        return i2 > i ? -1 : 0;
    }

    public static final class ParametersBuilder extends TrackSelectionParameters.Builder {
        private boolean allowAudioMixedChannelCountAdaptiveness;
        private boolean allowAudioMixedMimeTypeAdaptiveness;
        private boolean allowAudioMixedSampleRateAdaptiveness;
        private boolean allowVideoMixedMimeTypeAdaptiveness;
        private boolean allowVideoNonSeamlessAdaptiveness;
        private boolean exceedAudioConstraintsIfNecessary;
        private boolean exceedRendererCapabilitiesIfNecessary;
        private boolean exceedVideoConstraintsIfNecessary;
        private boolean forceHighestSupportedBitrate;
        private boolean forceLowestBitrate;
        private int maxAudioBitrate;
        private int maxAudioChannelCount;
        private int maxVideoBitrate;
        private int maxVideoFrameRate;
        private int maxVideoHeight;
        private int maxVideoWidth;
        private final SparseBooleanArray rendererDisabledFlags;
        private final SparseArray<Map<TrackGroupArray, SelectionOverride>> selectionOverrides;
        private int tunnelingAudioSessionId;
        private int viewportHeight;
        private boolean viewportOrientationMayChange;
        private int viewportWidth;

        @Deprecated
        public ParametersBuilder() {
            setInitialValuesWithoutContext();
            this.selectionOverrides = new SparseArray<>();
            this.rendererDisabledFlags = new SparseBooleanArray();
        }

        public ParametersBuilder(Context context) {
            super(context);
            setInitialValuesWithoutContext();
            this.selectionOverrides = new SparseArray<>();
            this.rendererDisabledFlags = new SparseBooleanArray();
            setViewportSizeToPhysicalDisplaySize(context, true);
        }

        private ParametersBuilder(Parameters parameters) {
            super(parameters);
            this.maxVideoWidth = parameters.maxVideoWidth;
            this.maxVideoHeight = parameters.maxVideoHeight;
            this.maxVideoFrameRate = parameters.maxVideoFrameRate;
            this.maxVideoBitrate = parameters.maxVideoBitrate;
            this.exceedVideoConstraintsIfNecessary = parameters.exceedVideoConstraintsIfNecessary;
            this.allowVideoMixedMimeTypeAdaptiveness = parameters.allowVideoMixedMimeTypeAdaptiveness;
            this.allowVideoNonSeamlessAdaptiveness = parameters.allowVideoNonSeamlessAdaptiveness;
            this.viewportWidth = parameters.viewportWidth;
            this.viewportHeight = parameters.viewportHeight;
            this.viewportOrientationMayChange = parameters.viewportOrientationMayChange;
            this.maxAudioChannelCount = parameters.maxAudioChannelCount;
            this.maxAudioBitrate = parameters.maxAudioBitrate;
            this.exceedAudioConstraintsIfNecessary = parameters.exceedAudioConstraintsIfNecessary;
            this.allowAudioMixedMimeTypeAdaptiveness = parameters.allowAudioMixedMimeTypeAdaptiveness;
            this.allowAudioMixedSampleRateAdaptiveness = parameters.allowAudioMixedSampleRateAdaptiveness;
            this.allowAudioMixedChannelCountAdaptiveness = parameters.allowAudioMixedChannelCountAdaptiveness;
            this.forceLowestBitrate = parameters.forceLowestBitrate;
            this.forceHighestSupportedBitrate = parameters.forceHighestSupportedBitrate;
            this.exceedRendererCapabilitiesIfNecessary = parameters.exceedRendererCapabilitiesIfNecessary;
            this.tunnelingAudioSessionId = parameters.tunnelingAudioSessionId;
            this.selectionOverrides = cloneSelectionOverrides(parameters.selectionOverrides);
            this.rendererDisabledFlags = parameters.rendererDisabledFlags.clone();
        }

        public final ParametersBuilder setMaxVideoSizeSd() {
            return setMaxVideoSize(1279, 719);
        }

        public final ParametersBuilder clearVideoSizeConstraints() {
            return setMaxVideoSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }

        public final ParametersBuilder setMaxVideoSize(int i, int i2) {
            this.maxVideoWidth = i;
            this.maxVideoHeight = i2;
            return this;
        }

        public final ParametersBuilder setMaxVideoFrameRate(int i) {
            this.maxVideoFrameRate = i;
            return this;
        }

        public final ParametersBuilder setMaxVideoBitrate(int i) {
            this.maxVideoBitrate = i;
            return this;
        }

        public final ParametersBuilder setExceedVideoConstraintsIfNecessary(boolean z) {
            this.exceedVideoConstraintsIfNecessary = z;
            return this;
        }

        public final ParametersBuilder setAllowVideoMixedMimeTypeAdaptiveness(boolean z) {
            this.allowVideoMixedMimeTypeAdaptiveness = z;
            return this;
        }

        public final ParametersBuilder setAllowVideoNonSeamlessAdaptiveness(boolean z) {
            this.allowVideoNonSeamlessAdaptiveness = z;
            return this;
        }

        public final ParametersBuilder setViewportSizeToPhysicalDisplaySize(Context context, boolean z) {
            Point currentDisplayModeSize = Util.getCurrentDisplayModeSize(context);
            return setViewportSize(currentDisplayModeSize.x, currentDisplayModeSize.y, z);
        }

        public final ParametersBuilder clearViewportSizeConstraints() {
            return setViewportSize(Integer.MAX_VALUE, Integer.MAX_VALUE, true);
        }

        public final ParametersBuilder setViewportSize(int i, int i2, boolean z) {
            this.viewportWidth = i;
            this.viewportHeight = i2;
            this.viewportOrientationMayChange = z;
            return this;
        }

        public final ParametersBuilder setPreferredAudioLanguage(String str) {
            super.setPreferredAudioLanguage(str);
            return this;
        }

        public final ParametersBuilder setMaxAudioChannelCount(int i) {
            this.maxAudioChannelCount = i;
            return this;
        }

        public final ParametersBuilder setMaxAudioBitrate(int i) {
            this.maxAudioBitrate = i;
            return this;
        }

        public final ParametersBuilder setExceedAudioConstraintsIfNecessary(boolean z) {
            this.exceedAudioConstraintsIfNecessary = z;
            return this;
        }

        public final ParametersBuilder setAllowAudioMixedMimeTypeAdaptiveness(boolean z) {
            this.allowAudioMixedMimeTypeAdaptiveness = z;
            return this;
        }

        public final ParametersBuilder setAllowAudioMixedSampleRateAdaptiveness(boolean z) {
            this.allowAudioMixedSampleRateAdaptiveness = z;
            return this;
        }

        public final ParametersBuilder setAllowAudioMixedChannelCountAdaptiveness(boolean z) {
            this.allowAudioMixedChannelCountAdaptiveness = z;
            return this;
        }

        public final ParametersBuilder setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(Context context) {
            super.setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(context);
            return this;
        }

        public final ParametersBuilder setPreferredTextLanguage(String str) {
            super.setPreferredTextLanguage(str);
            return this;
        }

        public final ParametersBuilder setPreferredTextRoleFlags(int i) {
            super.setPreferredTextRoleFlags(i);
            return this;
        }

        public final ParametersBuilder setSelectUndeterminedTextLanguage(boolean z) {
            super.setSelectUndeterminedTextLanguage(z);
            return this;
        }

        public final ParametersBuilder setDisabledTextTrackSelectionFlags(int i) {
            super.setDisabledTextTrackSelectionFlags(i);
            return this;
        }

        public final ParametersBuilder setForceLowestBitrate(boolean z) {
            this.forceLowestBitrate = z;
            return this;
        }

        public final ParametersBuilder setForceHighestSupportedBitrate(boolean z) {
            this.forceHighestSupportedBitrate = z;
            return this;
        }

        public final ParametersBuilder setExceedRendererCapabilitiesIfNecessary(boolean z) {
            this.exceedRendererCapabilitiesIfNecessary = z;
            return this;
        }

        public final ParametersBuilder setTunnelingAudioSessionId(int i) {
            this.tunnelingAudioSessionId = i;
            return this;
        }

        public final ParametersBuilder setRendererDisabled(int i, boolean z) {
            if (this.rendererDisabledFlags.get(i) == z) {
                return this;
            }
            if (z) {
                this.rendererDisabledFlags.put(i, true);
            } else {
                this.rendererDisabledFlags.delete(i);
            }
            return this;
        }

        public final ParametersBuilder setSelectionOverride(int i, TrackGroupArray trackGroupArray, SelectionOverride selectionOverride) {
            Map map = this.selectionOverrides.get(i);
            if (map == null) {
                map = new HashMap();
                this.selectionOverrides.put(i, map);
            }
            if (map.containsKey(trackGroupArray) && Util.areEqual(map.get(trackGroupArray), selectionOverride)) {
                return this;
            }
            map.put(trackGroupArray, selectionOverride);
            return this;
        }

        public final ParametersBuilder clearSelectionOverride(int i, TrackGroupArray trackGroupArray) {
            Map map = this.selectionOverrides.get(i);
            if (map != null && map.containsKey(trackGroupArray)) {
                map.remove(trackGroupArray);
                if (map.isEmpty()) {
                    this.selectionOverrides.remove(i);
                }
            }
            return this;
        }

        public final ParametersBuilder clearSelectionOverrides(int i) {
            Map map = this.selectionOverrides.get(i);
            if (map != null && !map.isEmpty()) {
                this.selectionOverrides.remove(i);
            }
            return this;
        }

        public final ParametersBuilder clearSelectionOverrides() {
            if (this.selectionOverrides.size() == 0) {
                return this;
            }
            this.selectionOverrides.clear();
            return this;
        }

        public final Parameters build() {
            return new Parameters(this.maxVideoWidth, this.maxVideoHeight, this.maxVideoFrameRate, this.maxVideoBitrate, this.exceedVideoConstraintsIfNecessary, this.allowVideoMixedMimeTypeAdaptiveness, this.allowVideoNonSeamlessAdaptiveness, this.viewportWidth, this.viewportHeight, this.viewportOrientationMayChange, this.preferredAudioLanguage, this.maxAudioChannelCount, this.maxAudioBitrate, this.exceedAudioConstraintsIfNecessary, this.allowAudioMixedMimeTypeAdaptiveness, this.allowAudioMixedSampleRateAdaptiveness, this.allowAudioMixedChannelCountAdaptiveness, this.preferredTextLanguage, this.preferredTextRoleFlags, this.selectUndeterminedTextLanguage, this.disabledTextTrackSelectionFlags, this.forceLowestBitrate, this.forceHighestSupportedBitrate, this.exceedRendererCapabilitiesIfNecessary, this.tunnelingAudioSessionId, this.selectionOverrides, this.rendererDisabledFlags);
        }

        private void setInitialValuesWithoutContext() {
            this.maxVideoWidth = Integer.MAX_VALUE;
            this.maxVideoHeight = Integer.MAX_VALUE;
            this.maxVideoFrameRate = Integer.MAX_VALUE;
            this.maxVideoBitrate = Integer.MAX_VALUE;
            this.exceedVideoConstraintsIfNecessary = true;
            this.allowVideoMixedMimeTypeAdaptiveness = false;
            this.allowVideoNonSeamlessAdaptiveness = true;
            this.viewportWidth = Integer.MAX_VALUE;
            this.viewportHeight = Integer.MAX_VALUE;
            this.viewportOrientationMayChange = true;
            this.maxAudioChannelCount = Integer.MAX_VALUE;
            this.maxAudioBitrate = Integer.MAX_VALUE;
            this.exceedAudioConstraintsIfNecessary = true;
            this.allowAudioMixedMimeTypeAdaptiveness = false;
            this.allowAudioMixedSampleRateAdaptiveness = false;
            this.allowAudioMixedChannelCountAdaptiveness = false;
            this.forceLowestBitrate = false;
            this.forceHighestSupportedBitrate = false;
            this.exceedRendererCapabilitiesIfNecessary = true;
            this.tunnelingAudioSessionId = 0;
        }

        private static SparseArray<Map<TrackGroupArray, SelectionOverride>> cloneSelectionOverrides(SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray) {
            SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray2 = new SparseArray<>();
            for (int i = 0; i < sparseArray.size(); i++) {
                sparseArray2.put(sparseArray.keyAt(i), new HashMap(sparseArray.valueAt(i)));
            }
            return sparseArray2;
        }
    }

    public static final class Parameters extends TrackSelectionParameters {
        public static final Parcelable.Creator<Parameters> CREATOR = new Parcelable.Creator<Parameters>() {
            /* class com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters.AnonymousClass1 */

            public final Parameters createFromParcel(Parcel parcel) {
                return new Parameters(parcel);
            }

            public final Parameters[] newArray(int i) {
                return new Parameters[i];
            }
        };
        public static final Parameters DEFAULT_WITHOUT_CONTEXT = new ParametersBuilder().build();
        public final boolean allowAudioMixedChannelCountAdaptiveness;
        public final boolean allowAudioMixedMimeTypeAdaptiveness;
        public final boolean allowAudioMixedSampleRateAdaptiveness;
        public final boolean allowVideoMixedMimeTypeAdaptiveness;
        public final boolean allowVideoNonSeamlessAdaptiveness;
        public final boolean exceedAudioConstraintsIfNecessary;
        public final boolean exceedRendererCapabilitiesIfNecessary;
        public final boolean exceedVideoConstraintsIfNecessary;
        public final boolean forceHighestSupportedBitrate;
        public final boolean forceLowestBitrate;
        public final int maxAudioBitrate;
        public final int maxAudioChannelCount;
        public final int maxVideoBitrate;
        public final int maxVideoFrameRate;
        public final int maxVideoHeight;
        public final int maxVideoWidth;
        public final SparseBooleanArray rendererDisabledFlags;
        public final SparseArray<Map<TrackGroupArray, SelectionOverride>> selectionOverrides;
        public final int tunnelingAudioSessionId;
        public final int viewportHeight;
        public final boolean viewportOrientationMayChange;
        public final int viewportWidth;

        public final int describeContents() {
            return 0;
        }

        public static Parameters getDefaults(Context context) {
            return new ParametersBuilder(context).build();
        }

        Parameters(int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, int i5, int i6, boolean z4, String str, int i7, int i8, boolean z5, boolean z6, boolean z7, boolean z8, String str2, int i9, boolean z9, int i10, boolean z10, boolean z11, boolean z12, int i11, SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray, SparseBooleanArray sparseBooleanArray) {
            super(str, str2, i9, z9, i10);
            this.maxVideoWidth = i;
            this.maxVideoHeight = i2;
            this.maxVideoFrameRate = i3;
            this.maxVideoBitrate = i4;
            this.exceedVideoConstraintsIfNecessary = z;
            this.allowVideoMixedMimeTypeAdaptiveness = z2;
            this.allowVideoNonSeamlessAdaptiveness = z3;
            this.viewportWidth = i5;
            this.viewportHeight = i6;
            this.viewportOrientationMayChange = z4;
            this.maxAudioChannelCount = i7;
            this.maxAudioBitrate = i8;
            this.exceedAudioConstraintsIfNecessary = z5;
            this.allowAudioMixedMimeTypeAdaptiveness = z6;
            this.allowAudioMixedSampleRateAdaptiveness = z7;
            this.allowAudioMixedChannelCountAdaptiveness = z8;
            this.forceLowestBitrate = z10;
            this.forceHighestSupportedBitrate = z11;
            this.exceedRendererCapabilitiesIfNecessary = z12;
            this.tunnelingAudioSessionId = i11;
            this.selectionOverrides = sparseArray;
            this.rendererDisabledFlags = sparseBooleanArray;
        }

        Parameters(Parcel parcel) {
            super(parcel);
            this.maxVideoWidth = parcel.readInt();
            this.maxVideoHeight = parcel.readInt();
            this.maxVideoFrameRate = parcel.readInt();
            this.maxVideoBitrate = parcel.readInt();
            this.exceedVideoConstraintsIfNecessary = Util.readBoolean(parcel);
            this.allowVideoMixedMimeTypeAdaptiveness = Util.readBoolean(parcel);
            this.allowVideoNonSeamlessAdaptiveness = Util.readBoolean(parcel);
            this.viewportWidth = parcel.readInt();
            this.viewportHeight = parcel.readInt();
            this.viewportOrientationMayChange = Util.readBoolean(parcel);
            this.maxAudioChannelCount = parcel.readInt();
            this.maxAudioBitrate = parcel.readInt();
            this.exceedAudioConstraintsIfNecessary = Util.readBoolean(parcel);
            this.allowAudioMixedMimeTypeAdaptiveness = Util.readBoolean(parcel);
            this.allowAudioMixedSampleRateAdaptiveness = Util.readBoolean(parcel);
            this.allowAudioMixedChannelCountAdaptiveness = Util.readBoolean(parcel);
            this.forceLowestBitrate = Util.readBoolean(parcel);
            this.forceHighestSupportedBitrate = Util.readBoolean(parcel);
            this.exceedRendererCapabilitiesIfNecessary = Util.readBoolean(parcel);
            this.tunnelingAudioSessionId = parcel.readInt();
            this.selectionOverrides = readSelectionOverrides(parcel);
            this.rendererDisabledFlags = (SparseBooleanArray) Util.castNonNull(parcel.readSparseBooleanArray());
        }

        public final boolean getRendererDisabled(int i) {
            return this.rendererDisabledFlags.get(i);
        }

        public final boolean hasSelectionOverride(int i, TrackGroupArray trackGroupArray) {
            Map map = this.selectionOverrides.get(i);
            return map != null && map.containsKey(trackGroupArray);
        }

        public final SelectionOverride getSelectionOverride(int i, TrackGroupArray trackGroupArray) {
            Map map = this.selectionOverrides.get(i);
            if (map != null) {
                return (SelectionOverride) map.get(trackGroupArray);
            }
            return null;
        }

        public final ParametersBuilder buildUpon() {
            return new ParametersBuilder(this);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                Parameters parameters = (Parameters) obj;
                return super.equals(obj) && this.maxVideoWidth == parameters.maxVideoWidth && this.maxVideoHeight == parameters.maxVideoHeight && this.maxVideoFrameRate == parameters.maxVideoFrameRate && this.maxVideoBitrate == parameters.maxVideoBitrate && this.exceedVideoConstraintsIfNecessary == parameters.exceedVideoConstraintsIfNecessary && this.allowVideoMixedMimeTypeAdaptiveness == parameters.allowVideoMixedMimeTypeAdaptiveness && this.allowVideoNonSeamlessAdaptiveness == parameters.allowVideoNonSeamlessAdaptiveness && this.viewportOrientationMayChange == parameters.viewportOrientationMayChange && this.viewportWidth == parameters.viewportWidth && this.viewportHeight == parameters.viewportHeight && this.maxAudioChannelCount == parameters.maxAudioChannelCount && this.maxAudioBitrate == parameters.maxAudioBitrate && this.exceedAudioConstraintsIfNecessary == parameters.exceedAudioConstraintsIfNecessary && this.allowAudioMixedMimeTypeAdaptiveness == parameters.allowAudioMixedMimeTypeAdaptiveness && this.allowAudioMixedSampleRateAdaptiveness == parameters.allowAudioMixedSampleRateAdaptiveness && this.allowAudioMixedChannelCountAdaptiveness == parameters.allowAudioMixedChannelCountAdaptiveness && this.forceLowestBitrate == parameters.forceLowestBitrate && this.forceHighestSupportedBitrate == parameters.forceHighestSupportedBitrate && this.exceedRendererCapabilitiesIfNecessary == parameters.exceedRendererCapabilitiesIfNecessary && this.tunnelingAudioSessionId == parameters.tunnelingAudioSessionId && areRendererDisabledFlagsEqual(this.rendererDisabledFlags, parameters.rendererDisabledFlags) && areSelectionOverridesEqual(this.selectionOverrides, parameters.selectionOverrides);
            }
        }

        public final int hashCode() {
            return (((((((((((((((((((((((((((((((((((((((super.hashCode() * 31) + this.maxVideoWidth) * 31) + this.maxVideoHeight) * 31) + this.maxVideoFrameRate) * 31) + this.maxVideoBitrate) * 31) + (this.exceedVideoConstraintsIfNecessary ? 1 : 0)) * 31) + (this.allowVideoMixedMimeTypeAdaptiveness ? 1 : 0)) * 31) + (this.allowVideoNonSeamlessAdaptiveness ? 1 : 0)) * 31) + (this.viewportOrientationMayChange ? 1 : 0)) * 31) + this.viewportWidth) * 31) + this.viewportHeight) * 31) + this.maxAudioChannelCount) * 31) + this.maxAudioBitrate) * 31) + (this.exceedAudioConstraintsIfNecessary ? 1 : 0)) * 31) + (this.allowAudioMixedMimeTypeAdaptiveness ? 1 : 0)) * 31) + (this.allowAudioMixedSampleRateAdaptiveness ? 1 : 0)) * 31) + (this.allowAudioMixedChannelCountAdaptiveness ? 1 : 0)) * 31) + (this.forceLowestBitrate ? 1 : 0)) * 31) + (this.forceHighestSupportedBitrate ? 1 : 0)) * 31) + (this.exceedRendererCapabilitiesIfNecessary ? 1 : 0)) * 31) + this.tunnelingAudioSessionId;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.maxVideoWidth);
            parcel.writeInt(this.maxVideoHeight);
            parcel.writeInt(this.maxVideoFrameRate);
            parcel.writeInt(this.maxVideoBitrate);
            Util.writeBoolean(parcel, this.exceedVideoConstraintsIfNecessary);
            Util.writeBoolean(parcel, this.allowVideoMixedMimeTypeAdaptiveness);
            Util.writeBoolean(parcel, this.allowVideoNonSeamlessAdaptiveness);
            parcel.writeInt(this.viewportWidth);
            parcel.writeInt(this.viewportHeight);
            Util.writeBoolean(parcel, this.viewportOrientationMayChange);
            parcel.writeInt(this.maxAudioChannelCount);
            parcel.writeInt(this.maxAudioBitrate);
            Util.writeBoolean(parcel, this.exceedAudioConstraintsIfNecessary);
            Util.writeBoolean(parcel, this.allowAudioMixedMimeTypeAdaptiveness);
            Util.writeBoolean(parcel, this.allowAudioMixedSampleRateAdaptiveness);
            Util.writeBoolean(parcel, this.allowAudioMixedChannelCountAdaptiveness);
            Util.writeBoolean(parcel, this.forceLowestBitrate);
            Util.writeBoolean(parcel, this.forceHighestSupportedBitrate);
            Util.writeBoolean(parcel, this.exceedRendererCapabilitiesIfNecessary);
            parcel.writeInt(this.tunnelingAudioSessionId);
            writeSelectionOverridesToParcel(parcel, this.selectionOverrides);
            parcel.writeSparseBooleanArray(this.rendererDisabledFlags);
        }

        private static SparseArray<Map<TrackGroupArray, SelectionOverride>> readSelectionOverrides(Parcel parcel) {
            int readInt = parcel.readInt();
            SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray = new SparseArray<>(readInt);
            for (int i = 0; i < readInt; i++) {
                int readInt2 = parcel.readInt();
                int readInt3 = parcel.readInt();
                HashMap hashMap = new HashMap(readInt3);
                for (int i2 = 0; i2 < readInt3; i2++) {
                    hashMap.put((TrackGroupArray) Assertions.checkNotNull(parcel.readParcelable(TrackGroupArray.class.getClassLoader())), (SelectionOverride) parcel.readParcelable(SelectionOverride.class.getClassLoader()));
                }
                sparseArray.put(readInt2, hashMap);
            }
            return sparseArray;
        }

        private static void writeSelectionOverridesToParcel(Parcel parcel, SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray) {
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i = 0; i < size; i++) {
                int keyAt = sparseArray.keyAt(i);
                Map valueAt = sparseArray.valueAt(i);
                int size2 = valueAt.size();
                parcel.writeInt(keyAt);
                parcel.writeInt(size2);
                for (Map.Entry entry : valueAt.entrySet()) {
                    parcel.writeParcelable((Parcelable) entry.getKey(), 0);
                    parcel.writeParcelable((Parcelable) entry.getValue(), 0);
                }
            }
        }

        private static boolean areRendererDisabledFlagsEqual(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
            int size = sparseBooleanArray.size();
            if (sparseBooleanArray2.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i)) < 0) {
                    return false;
                }
            }
            return true;
        }

        private static boolean areSelectionOverridesEqual(SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray, SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray2) {
            int size = sparseArray.size();
            if (sparseArray2.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                int indexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i));
                if (indexOfKey < 0 || !areSelectionOverridesEqual(sparseArray.valueAt(i), sparseArray2.valueAt(indexOfKey))) {
                    return false;
                }
            }
            return true;
        }

        /* JADX WARNING: Removed duplicated region for block: B:6:0x001a  */
        private static boolean areSelectionOverridesEqual(Map<TrackGroupArray, SelectionOverride> map, Map<TrackGroupArray, SelectionOverride> map2) {
            if (map2.size() != map.size()) {
                return false;
            }
            for (Map.Entry next : map.entrySet()) {
                TrackGroupArray trackGroupArray = (TrackGroupArray) next.getKey();
                if (!map2.containsKey(trackGroupArray) || !Util.areEqual(next.getValue(), map2.get(trackGroupArray))) {
                    return false;
                }
                while (r4.hasNext()) {
                }
            }
            return true;
        }
    }

    public static final class SelectionOverride implements Parcelable {
        public static final Parcelable.Creator<SelectionOverride> CREATOR = new Parcelable.Creator<SelectionOverride>() {
            /* class com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride.AnonymousClass1 */

            public final SelectionOverride createFromParcel(Parcel parcel) {
                return new SelectionOverride(parcel);
            }

            public final SelectionOverride[] newArray(int i) {
                return new SelectionOverride[i];
            }
        };
        public final int data;
        public final int groupIndex;
        public final int length;
        public final int reason;
        public final int[] tracks;

        public final int describeContents() {
            return 0;
        }

        public SelectionOverride(int i, int... iArr) {
            this(i, iArr, 2, 0);
        }

        public SelectionOverride(int i, int[] iArr, int i2, int i3) {
            this.groupIndex = i;
            this.tracks = Arrays.copyOf(iArr, iArr.length);
            this.length = iArr.length;
            this.reason = i2;
            this.data = i3;
            Arrays.sort(this.tracks);
        }

        SelectionOverride(Parcel parcel) {
            this.groupIndex = parcel.readInt();
            this.length = parcel.readByte();
            this.tracks = new int[this.length];
            parcel.readIntArray(this.tracks);
            this.reason = parcel.readInt();
            this.data = parcel.readInt();
        }

        public final boolean containsTrack(int i) {
            for (int i2 : this.tracks) {
                if (i2 == i) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return (((((this.groupIndex * 31) + Arrays.hashCode(this.tracks)) * 31) + this.reason) * 31) + this.data;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                SelectionOverride selectionOverride = (SelectionOverride) obj;
                return this.groupIndex == selectionOverride.groupIndex && Arrays.equals(this.tracks, selectionOverride.tracks) && this.reason == selectionOverride.reason && this.data == selectionOverride.data;
            }
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.groupIndex);
            parcel.writeInt(this.tracks.length);
            parcel.writeIntArray(this.tracks);
            parcel.writeInt(this.reason);
            parcel.writeInt(this.data);
        }
    }

    @Deprecated
    public DefaultTrackSelector() {
        this(new AdaptiveTrackSelection.Factory());
    }

    @Deprecated
    public DefaultTrackSelector(BandwidthMeter bandwidthMeter) {
        this(new AdaptiveTrackSelection.Factory(bandwidthMeter));
    }

    @Deprecated
    public DefaultTrackSelector(TrackSelection.Factory factory) {
        this(Parameters.DEFAULT_WITHOUT_CONTEXT, factory);
    }

    public DefaultTrackSelector(Context context) {
        this(context, new AdaptiveTrackSelection.Factory());
    }

    public DefaultTrackSelector(Context context, TrackSelection.Factory factory) {
        this(Parameters.getDefaults(context), factory);
    }

    public DefaultTrackSelector(Parameters parameters, TrackSelection.Factory factory) {
        this.trackSelectionFactory = factory;
        this.parametersReference = new AtomicReference<>(parameters);
    }

    public void setParameters(Parameters parameters) {
        Assertions.checkNotNull(parameters);
        if (!this.parametersReference.getAndSet(parameters).equals(parameters)) {
            invalidate();
        }
    }

    public void setParameters(ParametersBuilder parametersBuilder) {
        setParameters(parametersBuilder.build());
    }

    public Parameters getParameters() {
        return this.parametersReference.get();
    }

    public ParametersBuilder buildUponParameters() {
        return getParameters().buildUpon();
    }

    public void experimental_allowMultipleAdaptiveSelections() {
        this.allowMultipleAdaptiveSelections = true;
    }

    /* access modifiers changed from: protected */
    public final Pair<RendererConfiguration[], TrackSelection[]> selectTracks(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2) throws ExoPlaybackException {
        Parameters parameters = this.parametersReference.get();
        int rendererCount = mappedTrackInfo.getRendererCount();
        TrackSelection.Definition[] selectAllTracks = selectAllTracks(mappedTrackInfo, iArr, iArr2, parameters);
        int i = 0;
        while (true) {
            TrackSelection.Definition definition = null;
            if (i >= rendererCount) {
                break;
            }
            if (!parameters.getRendererDisabled(i)) {
                TrackGroupArray trackGroups = mappedTrackInfo.getTrackGroups(i);
                if (!parameters.hasSelectionOverride(i, trackGroups)) {
                    i++;
                } else {
                    SelectionOverride selectionOverride = parameters.getSelectionOverride(i, trackGroups);
                    if (selectionOverride != null) {
                        definition = new TrackSelection.Definition(trackGroups.get(selectionOverride.groupIndex), selectionOverride.tracks, selectionOverride.reason, Integer.valueOf(selectionOverride.data));
                    }
                }
            }
            selectAllTracks[i] = definition;
            i++;
        }
        TrackSelection[] createTrackSelections = this.trackSelectionFactory.createTrackSelections(selectAllTracks, getBandwidthMeter());
        RendererConfiguration[] rendererConfigurationArr = new RendererConfiguration[rendererCount];
        for (int i2 = 0; i2 < rendererCount; i2++) {
            rendererConfigurationArr[i2] = !parameters.getRendererDisabled(i2) && (mappedTrackInfo.getRendererType(i2) == 6 || createTrackSelections[i2] != null) ? RendererConfiguration.DEFAULT : null;
        }
        maybeConfigureRenderersForTunneling(mappedTrackInfo, iArr, rendererConfigurationArr, createTrackSelections, parameters.tunnelingAudioSessionId);
        return Pair.create(rendererConfigurationArr, createTrackSelections);
    }

    /* access modifiers changed from: protected */
    public TrackSelection.Definition[] selectAllTracks(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, Parameters parameters) throws ExoPlaybackException {
        int i;
        String str;
        int i2;
        String str2;
        AudioTrackScore audioTrackScore;
        int i3;
        MappingTrackSelector.MappedTrackInfo mappedTrackInfo2 = mappedTrackInfo;
        Parameters parameters2 = parameters;
        int rendererCount = mappedTrackInfo.getRendererCount();
        TrackSelection.Definition[] definitionArr = new TrackSelection.Definition[rendererCount];
        int i4 = 0;
        boolean z = false;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            i = 1;
            if (i5 >= rendererCount) {
                break;
            }
            if (2 == mappedTrackInfo2.getRendererType(i5)) {
                if (!z) {
                    definitionArr[i5] = selectVideoTrack(mappedTrackInfo2.getTrackGroups(i5), iArr[i5], iArr2[i5], parameters, true);
                    z = definitionArr[i5] != null;
                }
                if (mappedTrackInfo2.getTrackGroups(i5).length <= 0) {
                    i = 0;
                }
                i6 |= i;
            }
            i5++;
        }
        AudioTrackScore audioTrackScore2 = null;
        String str3 = null;
        int i7 = -1;
        int i8 = 0;
        while (i8 < rendererCount) {
            if (i == mappedTrackInfo2.getRendererType(i8)) {
                i3 = i7;
                audioTrackScore = audioTrackScore2;
                str2 = str3;
                i2 = i8;
                Pair<TrackSelection.Definition, AudioTrackScore> selectAudioTrack = selectAudioTrack(mappedTrackInfo2.getTrackGroups(i8), iArr[i8], iArr2[i8], parameters, this.allowMultipleAdaptiveSelections || i6 == 0);
                if (selectAudioTrack != null && (audioTrackScore == null || ((AudioTrackScore) selectAudioTrack.second).compareTo(audioTrackScore) > 0)) {
                    if (i3 != -1) {
                        definitionArr[i3] = null;
                    }
                    TrackSelection.Definition definition = (TrackSelection.Definition) selectAudioTrack.first;
                    definitionArr[i2] = definition;
                    String str4 = definition.group.getFormat(definition.tracks[0]).language;
                    audioTrackScore2 = (AudioTrackScore) selectAudioTrack.second;
                    str3 = str4;
                    i7 = i2;
                    i8 = i2 + 1;
                    i = 1;
                }
            } else {
                i3 = i7;
                audioTrackScore = audioTrackScore2;
                str2 = str3;
                i2 = i8;
            }
            i7 = i3;
            audioTrackScore2 = audioTrackScore;
            str3 = str2;
            i8 = i2 + 1;
            i = 1;
        }
        String str5 = str3;
        TextTrackScore textTrackScore = null;
        int i9 = -1;
        while (i4 < rendererCount) {
            int rendererType = mappedTrackInfo2.getRendererType(i4);
            if (rendererType != 1) {
                if (rendererType != 2) {
                    if (rendererType != 3) {
                        definitionArr[i4] = selectOtherTrack(rendererType, mappedTrackInfo2.getTrackGroups(i4), iArr[i4], parameters2);
                    } else {
                        str = str5;
                        Pair<TrackSelection.Definition, TextTrackScore> selectTextTrack = selectTextTrack(mappedTrackInfo2.getTrackGroups(i4), iArr[i4], parameters2, str);
                        if (selectTextTrack != null && (textTrackScore == null || ((TextTrackScore) selectTextTrack.second).compareTo(textTrackScore) > 0)) {
                            if (i9 != -1) {
                                definitionArr[i9] = null;
                            }
                            definitionArr[i4] = (TrackSelection.Definition) selectTextTrack.first;
                            textTrackScore = (TextTrackScore) selectTextTrack.second;
                            i9 = i4;
                        }
                    }
                }
                str = str5;
            } else {
                str = str5;
            }
            i4++;
            str5 = str;
        }
        return definitionArr;
    }

    /* access modifiers changed from: protected */
    public TrackSelection.Definition selectVideoTrack(TrackGroupArray trackGroupArray, int[][] iArr, int i, Parameters parameters, boolean z) throws ExoPlaybackException {
        TrackSelection.Definition selectAdaptiveVideoTrack = (parameters.forceHighestSupportedBitrate || parameters.forceLowestBitrate || !z) ? null : selectAdaptiveVideoTrack(trackGroupArray, iArr, i, parameters);
        return selectAdaptiveVideoTrack == null ? selectFixedVideoTrack(trackGroupArray, iArr, parameters) : selectAdaptiveVideoTrack;
    }

    private static TrackSelection.Definition selectAdaptiveVideoTrack(TrackGroupArray trackGroupArray, int[][] iArr, int i, Parameters parameters) {
        TrackGroupArray trackGroupArray2 = trackGroupArray;
        Parameters parameters2 = parameters;
        int i2 = parameters2.allowVideoNonSeamlessAdaptiveness ? 24 : 16;
        boolean z = parameters2.allowVideoMixedMimeTypeAdaptiveness && (i & i2) != 0;
        int i3 = 0;
        while (i3 < trackGroupArray2.length) {
            TrackGroup trackGroup = trackGroupArray2.get(i3);
            TrackGroup trackGroup2 = trackGroup;
            int[] adaptiveVideoTracksForGroup = getAdaptiveVideoTracksForGroup(trackGroup, iArr[i3], z, i2, parameters2.maxVideoWidth, parameters2.maxVideoHeight, parameters2.maxVideoFrameRate, parameters2.maxVideoBitrate, parameters2.viewportWidth, parameters2.viewportHeight, parameters2.viewportOrientationMayChange);
            if (adaptiveVideoTracksForGroup.length > 0) {
                return new TrackSelection.Definition(trackGroup2, adaptiveVideoTracksForGroup);
            }
            i3++;
            trackGroupArray2 = trackGroupArray;
        }
        return null;
    }

    private static int[] getAdaptiveVideoTracksForGroup(TrackGroup trackGroup, int[] iArr, boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z2) {
        String str;
        TrackGroup trackGroup2 = trackGroup;
        if (trackGroup2.length < 2) {
            return NO_TRACKS;
        }
        List<Integer> viewportFilteredTrackIndices = getViewportFilteredTrackIndices(trackGroup2, i6, i7, z2);
        if (viewportFilteredTrackIndices.size() < 2) {
            return NO_TRACKS;
        }
        if (!z) {
            HashSet hashSet = new HashSet();
            String str2 = null;
            int i8 = 0;
            for (int i9 = 0; i9 < viewportFilteredTrackIndices.size(); i9++) {
                String str3 = trackGroup2.getFormat(viewportFilteredTrackIndices.get(i9).intValue()).sampleMimeType;
                if (hashSet.add(str3)) {
                    String str4 = str3;
                    int adaptiveVideoTrackCountForMimeType = getAdaptiveVideoTrackCountForMimeType(trackGroup, iArr, i, str3, i2, i3, i4, i5, viewportFilteredTrackIndices);
                    if (adaptiveVideoTrackCountForMimeType > i8) {
                        i8 = adaptiveVideoTrackCountForMimeType;
                        str2 = str4;
                    }
                }
            }
            str = str2;
        } else {
            str = null;
        }
        filterAdaptiveVideoTrackCountForMimeType(trackGroup, iArr, i, str, i2, i3, i4, i5, viewportFilteredTrackIndices);
        return viewportFilteredTrackIndices.size() < 2 ? NO_TRACKS : Util.toArray(viewportFilteredTrackIndices);
    }

    private static int getAdaptiveVideoTrackCountForMimeType(TrackGroup trackGroup, int[] iArr, int i, String str, int i2, int i3, int i4, int i5, List<Integer> list) {
        int i6 = 0;
        for (int i7 = 0; i7 < list.size(); i7++) {
            int intValue = list.get(i7).intValue();
            if (isSupportedAdaptiveVideoTrack(trackGroup.getFormat(intValue), str, iArr[intValue], i, i2, i3, i4, i5)) {
                i6++;
            }
        }
        return i6;
    }

    private static void filterAdaptiveVideoTrackCountForMimeType(TrackGroup trackGroup, int[] iArr, int i, String str, int i2, int i3, int i4, int i5, List<Integer> list) {
        List<Integer> list2 = list;
        for (int size = list.size() - 1; size >= 0; size--) {
            int intValue = list2.get(size).intValue();
            if (!isSupportedAdaptiveVideoTrack(trackGroup.getFormat(intValue), str, iArr[intValue], i, i2, i3, i4, i5)) {
                list2.remove(size);
            }
        }
    }

    private static boolean isSupportedAdaptiveVideoTrack(Format format, String str, int i, int i2, int i3, int i4, int i5, int i6) {
        if ((format.roleFlags & 16384) == 0 && isSupported(i, false) && (i & i2) != 0 && ((str == null || Util.areEqual(format.sampleMimeType, str)) && ((format.width == -1 || format.width <= i3) && ((format.height == -1 || format.height <= i4) && ((format.frameRate == -1.0f || format.frameRate <= ((float) i5)) && (format.bitrate == -1 || format.bitrate <= i6)))))) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00a4, code lost:
        if (r0 < 0) goto L_0x00a6;
     */
    private static TrackSelection.Definition selectFixedVideoTrack(TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters) {
        int i;
        int i2;
        TrackGroupArray trackGroupArray2 = trackGroupArray;
        Parameters parameters2 = parameters;
        int i3 = -1;
        int i4 = 0;
        TrackGroup trackGroup = null;
        int i5 = 0;
        int i6 = 0;
        int i7 = -1;
        int i8 = -1;
        while (i4 < trackGroupArray2.length) {
            TrackGroup trackGroup2 = trackGroupArray2.get(i4);
            List<Integer> viewportFilteredTrackIndices = getViewportFilteredTrackIndices(trackGroup2, parameters2.viewportWidth, parameters2.viewportHeight, parameters2.viewportOrientationMayChange);
            int[] iArr2 = iArr[i4];
            int i9 = i8;
            int i10 = i7;
            int i11 = i6;
            int i12 = i5;
            TrackGroup trackGroup3 = trackGroup;
            int i13 = 0;
            while (i13 < trackGroup2.length) {
                Format format = trackGroup2.getFormat(i13);
                if ((format.roleFlags & 16384) == 0 && isSupported(iArr2[i13], parameters2.exceedRendererCapabilitiesIfNecessary)) {
                    boolean z = viewportFilteredTrackIndices.contains(Integer.valueOf(i13)) && (format.width == i3 || format.width <= parameters2.maxVideoWidth) && ((format.height == i3 || format.height <= parameters2.maxVideoHeight) && ((format.frameRate == -1.0f || format.frameRate <= ((float) parameters2.maxVideoFrameRate)) && (format.bitrate == i3 || format.bitrate <= parameters2.maxVideoBitrate)));
                    if (z || parameters2.exceedVideoConstraintsIfNecessary) {
                        int i14 = z ? 2 : 1;
                        boolean isSupported = isSupported(iArr2[i13], false);
                        if (isSupported) {
                            i14 += 1000;
                        }
                        boolean z2 = i14 > i11;
                        if (i14 == i11) {
                            int compareFormatValues = compareFormatValues(format.bitrate, i10);
                            i = i14;
                            if (!parameters2.forceLowestBitrate || compareFormatValues == 0) {
                                int pixelCount = format.getPixelCount();
                                if (pixelCount != i9) {
                                    i2 = compareFormatValues(pixelCount, i9);
                                } else {
                                    i2 = compareFormatValues(format.bitrate, i10);
                                }
                                if (isSupported) {
                                }
                                z2 = false;
                            }
                            z2 = true;
                        } else {
                            i = i14;
                        }
                        if (z2) {
                            i10 = format.bitrate;
                            i9 = format.getPixelCount();
                            i12 = i13;
                            trackGroup3 = trackGroup2;
                            i11 = i;
                        }
                    }
                }
                i13++;
                i3 = -1;
            }
            i4++;
            i3 = -1;
            trackGroupArray2 = trackGroupArray;
            trackGroup = trackGroup3;
            i5 = i12;
            i6 = i11;
            i7 = i10;
            i8 = i9;
        }
        if (trackGroup == null) {
            return null;
        }
        return new TrackSelection.Definition(trackGroup, i5);
    }

    /* access modifiers changed from: protected */
    public Pair<TrackSelection.Definition, AudioTrackScore> selectAudioTrack(TrackGroupArray trackGroupArray, int[][] iArr, int i, Parameters parameters, boolean z) throws ExoPlaybackException {
        TrackGroupArray trackGroupArray2 = trackGroupArray;
        Parameters parameters2 = parameters;
        TrackSelection.Definition definition = null;
        AudioTrackScore audioTrackScore = null;
        int i2 = 0;
        int i3 = -1;
        int i4 = -1;
        while (i2 < trackGroupArray2.length) {
            TrackGroup trackGroup = trackGroupArray2.get(i2);
            int[] iArr2 = iArr[i2];
            int i5 = i3;
            for (int i6 = 0; i6 < trackGroup.length; i6++) {
                if (isSupported(iArr2[i6], parameters2.exceedRendererCapabilitiesIfNecessary)) {
                    AudioTrackScore audioTrackScore2 = new AudioTrackScore(trackGroup.getFormat(i6), parameters2, iArr2[i6]);
                    if ((audioTrackScore2.isWithinConstraints || parameters2.exceedAudioConstraintsIfNecessary) && (audioTrackScore == null || audioTrackScore2.compareTo(audioTrackScore) > 0)) {
                        i5 = i2;
                        i4 = i6;
                        audioTrackScore = audioTrackScore2;
                    }
                }
            }
            i2++;
            i3 = i5;
        }
        if (i3 == -1) {
            return null;
        }
        TrackGroup trackGroup2 = trackGroupArray2.get(i3);
        if (!parameters2.forceHighestSupportedBitrate && !parameters2.forceLowestBitrate && z) {
            int[] adaptiveAudioTracks = getAdaptiveAudioTracks(trackGroup2, iArr[i3], i4, parameters2.maxAudioBitrate, parameters2.allowAudioMixedMimeTypeAdaptiveness, parameters2.allowAudioMixedSampleRateAdaptiveness, parameters2.allowAudioMixedChannelCountAdaptiveness);
            if (adaptiveAudioTracks.length > 1) {
                definition = new TrackSelection.Definition(trackGroup2, adaptiveAudioTracks);
            }
        }
        if (definition == null) {
            definition = new TrackSelection.Definition(trackGroup2, i4);
        }
        return Pair.create(definition, Assertions.checkNotNull(audioTrackScore));
    }

    private static int[] getAdaptiveAudioTracks(TrackGroup trackGroup, int[] iArr, int i, int i2, boolean z, boolean z2, boolean z3) {
        TrackGroup trackGroup2 = trackGroup;
        int i3 = i;
        Format format = trackGroup.getFormat(i);
        int[] iArr2 = new int[trackGroup2.length];
        int i4 = 0;
        for (int i5 = 0; i5 < trackGroup2.length; i5++) {
            if (i5 == i3 || isSupportedAdaptiveAudioTrack(trackGroup.getFormat(i5), iArr[i5], format, i2, z, z2, z3)) {
                iArr2[i4] = i5;
                i4++;
            }
        }
        return Arrays.copyOf(iArr2, i4);
    }

    private static boolean isSupportedAdaptiveAudioTrack(Format format, int i, Format format2, int i2, boolean z, boolean z2, boolean z3) {
        if (isSupported(i, false) && ((format.bitrate == -1 || format.bitrate <= i2) && ((z3 || (format.channelCount != -1 && format.channelCount == format2.channelCount)) && (z || (format.sampleMimeType != null && TextUtils.equals(format.sampleMimeType, format2.sampleMimeType)))))) {
            if (z2) {
                return true;
            }
            if (format.sampleRate == -1 || format.sampleRate != format2.sampleRate) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public Pair<TrackSelection.Definition, TextTrackScore> selectTextTrack(TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters, String str) throws ExoPlaybackException {
        TrackGroupArray trackGroupArray2 = trackGroupArray;
        Parameters parameters2 = parameters;
        TrackGroup trackGroup = null;
        TextTrackScore textTrackScore = null;
        int i = 0;
        int i2 = -1;
        while (i < trackGroupArray2.length) {
            TrackGroup trackGroup2 = trackGroupArray2.get(i);
            int[] iArr2 = iArr[i];
            TextTrackScore textTrackScore2 = textTrackScore;
            TrackGroup trackGroup3 = trackGroup;
            for (int i3 = 0; i3 < trackGroup2.length; i3++) {
                if (isSupported(iArr2[i3], parameters2.exceedRendererCapabilitiesIfNecessary)) {
                    TextTrackScore textTrackScore3 = new TextTrackScore(trackGroup2.getFormat(i3), parameters2, iArr2[i3], str);
                    if (textTrackScore3.isWithinConstraints && (textTrackScore2 == null || textTrackScore3.compareTo(textTrackScore2) > 0)) {
                        i2 = i3;
                        trackGroup3 = trackGroup2;
                        textTrackScore2 = textTrackScore3;
                    }
                }
            }
            i++;
            trackGroup = trackGroup3;
            textTrackScore = textTrackScore2;
        }
        if (trackGroup == null) {
            return null;
        }
        return Pair.create(new TrackSelection.Definition(trackGroup, i2), Assertions.checkNotNull(textTrackScore));
    }

    /* access modifiers changed from: protected */
    public TrackSelection.Definition selectOtherTrack(int i, TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters) throws ExoPlaybackException {
        TrackGroup trackGroup = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < trackGroupArray.length) {
            TrackGroup trackGroup2 = trackGroupArray.get(i2);
            int[] iArr2 = iArr[i2];
            int i5 = i4;
            TrackGroup trackGroup3 = trackGroup;
            for (int i6 = 0; i6 < trackGroup2.length; i6++) {
                if (isSupported(iArr2[i6], parameters.exceedRendererCapabilitiesIfNecessary)) {
                    int i7 = (trackGroup2.getFormat(i6).selectionFlags & 1) != 0 ? 2 : 1;
                    if (isSupported(iArr2[i6], false)) {
                        i7 += 1000;
                    }
                    if (i7 > i5) {
                        i3 = i6;
                        trackGroup3 = trackGroup2;
                        i5 = i7;
                    }
                }
            }
            i2++;
            trackGroup = trackGroup3;
            i4 = i5;
        }
        if (trackGroup == null) {
            return null;
        }
        return new TrackSelection.Definition(trackGroup, i3);
    }

    private static void maybeConfigureRenderersForTunneling(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, RendererConfiguration[] rendererConfigurationArr, TrackSelection[] trackSelectionArr, int i) {
        boolean z;
        if (i != 0) {
            boolean z2 = false;
            int i2 = 0;
            int i3 = -1;
            int i4 = -1;
            while (true) {
                if (i2 >= mappedTrackInfo.getRendererCount()) {
                    z = true;
                    break;
                }
                int rendererType = mappedTrackInfo.getRendererType(i2);
                TrackSelection trackSelection = trackSelectionArr[i2];
                if ((rendererType == 1 || rendererType == 2) && trackSelection != null && rendererSupportsTunneling(iArr[i2], mappedTrackInfo.getTrackGroups(i2), trackSelection)) {
                    if (rendererType == 1) {
                        if (i4 != -1) {
                            break;
                        }
                        i4 = i2;
                    } else if (i3 != -1) {
                        break;
                    } else {
                        i3 = i2;
                    }
                }
                i2++;
            }
            z = false;
            if (!(i4 == -1 || i3 == -1)) {
                z2 = true;
            }
            if (z && z2) {
                RendererConfiguration rendererConfiguration = new RendererConfiguration(i);
                rendererConfigurationArr[i4] = rendererConfiguration;
                rendererConfigurationArr[i3] = rendererConfiguration;
            }
        }
    }

    private static boolean rendererSupportsTunneling(int[][] iArr, TrackGroupArray trackGroupArray, TrackSelection trackSelection) {
        if (trackSelection == null) {
            return false;
        }
        int indexOf = trackGroupArray.indexOf(trackSelection.getTrackGroup());
        for (int i = 0; i < trackSelection.length(); i++) {
            if (RendererCapabilities.CC.getTunnelingSupport(iArr[indexOf][trackSelection.getIndexInTrackGroup(i)]) != 32) {
                return false;
            }
        }
        return true;
    }

    protected static boolean isSupported(int i, boolean z) {
        int formatSupport = RendererCapabilities.CC.getFormatSupport(i);
        if (formatSupport != 4) {
            return z && formatSupport == 3;
        }
        return true;
    }

    protected static String normalizeUndeterminedLanguageToNull(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    protected static int getFormatLanguageScore(Format format, String str, boolean z) {
        if (!TextUtils.isEmpty(str) && str.equals(format.language)) {
            return 4;
        }
        String normalizeUndeterminedLanguageToNull = normalizeUndeterminedLanguageToNull(str);
        String normalizeUndeterminedLanguageToNull2 = normalizeUndeterminedLanguageToNull(format.language);
        if (normalizeUndeterminedLanguageToNull2 == null || normalizeUndeterminedLanguageToNull == null) {
            if (!z || normalizeUndeterminedLanguageToNull2 != null) {
                return 0;
            }
            return 1;
        } else if (normalizeUndeterminedLanguageToNull2.startsWith(normalizeUndeterminedLanguageToNull) || normalizeUndeterminedLanguageToNull.startsWith(normalizeUndeterminedLanguageToNull2)) {
            return 3;
        } else {
            if (Util.splitAtFirst(normalizeUndeterminedLanguageToNull2, "-")[0].equals(Util.splitAtFirst(normalizeUndeterminedLanguageToNull, "-")[0])) {
                return 2;
            }
            return 0;
        }
    }

    private static List<Integer> getViewportFilteredTrackIndices(TrackGroup trackGroup, int i, int i2, boolean z) {
        ArrayList arrayList = new ArrayList(trackGroup.length);
        for (int i3 = 0; i3 < trackGroup.length; i3++) {
            arrayList.add(Integer.valueOf(i3));
        }
        if (!(i == Integer.MAX_VALUE || i2 == Integer.MAX_VALUE)) {
            int i4 = Integer.MAX_VALUE;
            for (int i5 = 0; i5 < trackGroup.length; i5++) {
                Format format = trackGroup.getFormat(i5);
                if (format.width > 0 && format.height > 0) {
                    Point maxVideoSizeInViewport = getMaxVideoSizeInViewport(z, i, i2, format.width, format.height);
                    int i6 = format.width * format.height;
                    if (format.width >= ((int) (((float) maxVideoSizeInViewport.x) * 0.98f)) && format.height >= ((int) (((float) maxVideoSizeInViewport.y) * 0.98f)) && i6 < i4) {
                        i4 = i6;
                    }
                }
            }
            if (i4 != Integer.MAX_VALUE) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    int pixelCount = trackGroup.getFormat(((Integer) arrayList.get(size)).intValue()).getPixelCount();
                    if (pixelCount == -1 || pixelCount > i4) {
                        arrayList.remove(size);
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000d, code lost:
        if (r1 != r3) goto L_0x0013;
     */
    private static Point getMaxVideoSizeInViewport(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            boolean z2 = true;
            boolean z3 = i3 > i4;
            if (i <= i2) {
                z2 = false;
            }
        }
        int i5 = i2;
        i2 = i;
        i = i5;
        int i6 = i3 * i;
        int i7 = i4 * i2;
        if (i6 >= i7) {
            return new Point(i2, Util.ceilDivide(i7, i3));
        }
        return new Point(Util.ceilDivide(i6, i4), i);
    }

    public static final class AudioTrackScore implements Comparable<AudioTrackScore> {
        private final int bitrate;
        private final int channelCount;
        private final boolean isDefaultSelectionFlag;
        public final boolean isWithinConstraints;
        private final boolean isWithinRendererCapabilities;
        private final String language;
        private final int localeLanguageMatchIndex;
        private final int localeLanguageScore;
        private final Parameters parameters;
        private final int preferredLanguageScore;
        private final int sampleRate;

        public AudioTrackScore(Format format, Parameters parameters2, int i) {
            this.parameters = parameters2;
            this.language = DefaultTrackSelector.normalizeUndeterminedLanguageToNull(format.language);
            int i2 = 0;
            this.isWithinRendererCapabilities = DefaultTrackSelector.isSupported(i, false);
            this.preferredLanguageScore = DefaultTrackSelector.getFormatLanguageScore(format, parameters2.preferredAudioLanguage, false);
            boolean z = true;
            this.isDefaultSelectionFlag = (format.selectionFlags & 1) != 0;
            this.channelCount = format.channelCount;
            this.sampleRate = format.sampleRate;
            this.bitrate = format.bitrate;
            if ((format.bitrate != -1 && format.bitrate > parameters2.maxAudioBitrate) || (format.channelCount != -1 && format.channelCount > parameters2.maxAudioChannelCount)) {
                z = false;
            }
            this.isWithinConstraints = z;
            String[] systemLanguageCodes = Util.getSystemLanguageCodes();
            int i3 = Integer.MAX_VALUE;
            int i4 = 0;
            while (true) {
                if (i4 >= systemLanguageCodes.length) {
                    break;
                }
                int formatLanguageScore = DefaultTrackSelector.getFormatLanguageScore(format, systemLanguageCodes[i4], false);
                if (formatLanguageScore > 0) {
                    i3 = i4;
                    i2 = formatLanguageScore;
                    break;
                }
                i4++;
            }
            this.localeLanguageMatchIndex = i3;
            this.localeLanguageScore = i2;
        }

        public final int compareTo(AudioTrackScore audioTrackScore) {
            int compareInts;
            int compareFormatValues;
            boolean z = this.isWithinRendererCapabilities;
            int i = 1;
            if (z != audioTrackScore.isWithinRendererCapabilities) {
                return z ? 1 : -1;
            }
            int i2 = this.preferredLanguageScore;
            int i3 = audioTrackScore.preferredLanguageScore;
            if (i2 != i3) {
                return DefaultTrackSelector.compareInts(i2, i3);
            }
            boolean z2 = this.isWithinConstraints;
            if (z2 != audioTrackScore.isWithinConstraints) {
                return z2 ? 1 : -1;
            }
            if (this.parameters.forceLowestBitrate && (compareFormatValues = DefaultTrackSelector.compareFormatValues(this.bitrate, audioTrackScore.bitrate)) != 0) {
                return compareFormatValues > 0 ? -1 : 1;
            }
            boolean z3 = this.isDefaultSelectionFlag;
            if (z3 != audioTrackScore.isDefaultSelectionFlag) {
                return z3 ? 1 : -1;
            }
            int i4 = this.localeLanguageMatchIndex;
            int i5 = audioTrackScore.localeLanguageMatchIndex;
            if (i4 != i5) {
                return -DefaultTrackSelector.compareInts(i4, i5);
            }
            int i6 = this.localeLanguageScore;
            int i7 = audioTrackScore.localeLanguageScore;
            if (i6 != i7) {
                return DefaultTrackSelector.compareInts(i6, i7);
            }
            if (!this.isWithinConstraints || !this.isWithinRendererCapabilities) {
                i = -1;
            }
            int i8 = this.channelCount;
            int i9 = audioTrackScore.channelCount;
            if (i8 != i9) {
                compareInts = DefaultTrackSelector.compareInts(i8, i9);
            } else {
                int i10 = this.sampleRate;
                int i11 = audioTrackScore.sampleRate;
                if (i10 != i11) {
                    compareInts = DefaultTrackSelector.compareInts(i10, i11);
                } else if (!Util.areEqual(this.language, audioTrackScore.language)) {
                    return 0;
                } else {
                    compareInts = DefaultTrackSelector.compareInts(this.bitrate, audioTrackScore.bitrate);
                }
            }
            return i * compareInts;
        }
    }

    public static final class TextTrackScore implements Comparable<TextTrackScore> {
        private final boolean hasCaptionRoleFlags;
        private final boolean hasPreferredIsForcedFlag;
        private final boolean isDefault;
        public final boolean isWithinConstraints;
        private final boolean isWithinRendererCapabilities;
        private final int preferredLanguageScore;
        private final int preferredRoleFlagsScore;
        private final int selectedAudioLanguageScore;

        public TextTrackScore(Format format, Parameters parameters, int i, String str) {
            boolean z = false;
            this.isWithinRendererCapabilities = DefaultTrackSelector.isSupported(i, false);
            int i2 = format.selectionFlags & (parameters.disabledTextTrackSelectionFlags ^ -1);
            this.isDefault = (i2 & 1) != 0;
            boolean z2 = (i2 & 2) != 0;
            this.preferredLanguageScore = DefaultTrackSelector.getFormatLanguageScore(format, parameters.preferredTextLanguage, parameters.selectUndeterminedTextLanguage);
            this.preferredRoleFlagsScore = Integer.bitCount(format.roleFlags & parameters.preferredTextRoleFlags);
            this.hasCaptionRoleFlags = (format.roleFlags & 1088) != 0;
            this.hasPreferredIsForcedFlag = (this.preferredLanguageScore > 0 && !z2) || (this.preferredLanguageScore == 0 && z2);
            this.selectedAudioLanguageScore = DefaultTrackSelector.getFormatLanguageScore(format, str, DefaultTrackSelector.normalizeUndeterminedLanguageToNull(str) == null);
            if (this.preferredLanguageScore > 0 || ((parameters.preferredTextLanguage == null && this.preferredRoleFlagsScore > 0) || this.isDefault || (z2 && this.selectedAudioLanguageScore > 0))) {
                z = true;
            }
            this.isWithinConstraints = z;
        }

        public final int compareTo(TextTrackScore textTrackScore) {
            boolean z;
            boolean z2 = this.isWithinRendererCapabilities;
            if (z2 != textTrackScore.isWithinRendererCapabilities) {
                return z2 ? 1 : -1;
            }
            int i = this.preferredLanguageScore;
            int i2 = textTrackScore.preferredLanguageScore;
            if (i != i2) {
                return DefaultTrackSelector.compareInts(i, i2);
            }
            int i3 = this.preferredRoleFlagsScore;
            int i4 = textTrackScore.preferredRoleFlagsScore;
            if (i3 != i4) {
                return DefaultTrackSelector.compareInts(i3, i4);
            }
            boolean z3 = this.isDefault;
            if (z3 != textTrackScore.isDefault) {
                return z3 ? 1 : -1;
            }
            boolean z4 = this.hasPreferredIsForcedFlag;
            if (z4 != textTrackScore.hasPreferredIsForcedFlag) {
                return z4 ? 1 : -1;
            }
            int i5 = this.selectedAudioLanguageScore;
            int i6 = textTrackScore.selectedAudioLanguageScore;
            if (i5 != i6) {
                return DefaultTrackSelector.compareInts(i5, i6);
            }
            if (i3 != 0 || (z = this.hasCaptionRoleFlags) == textTrackScore.hasCaptionRoleFlags) {
                return 0;
            }
            return z ? -1 : 1;
        }
    }
}
