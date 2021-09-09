package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;

public final class SpliceNullCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceNullCommand> CREATOR = new Parcelable.Creator<SpliceNullCommand>() {
        /* class com.google.android.exoplayer2.metadata.scte35.SpliceNullCommand.AnonymousClass1 */

        public final SpliceNullCommand createFromParcel(Parcel parcel) {
            return new SpliceNullCommand();
        }

        public final SpliceNullCommand[] newArray(int i) {
            return new SpliceNullCommand[i];
        }
    };

    public final void writeToParcel(Parcel parcel, int i) {
    }
}
