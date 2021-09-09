package android.service.controls.templates;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.Objects;

public final class ControlButton implements Parcelable {
    public static final Parcelable.Creator<ControlButton> CREATOR = new Parcelable.Creator<ControlButton>() {
        /* class android.service.controls.templates.ControlButton.AnonymousClass1 */

        public final ControlButton createFromParcel(Parcel parcel) {
            return new ControlButton(parcel);
        }

        public final ControlButton[] newArray(int i) {
            return new ControlButton[i];
        }
    };
    private final CharSequence mActionDescription;
    private final boolean mChecked;

    public final int describeContents() {
        return 0;
    }

    public ControlButton(boolean z, CharSequence charSequence) {
        Objects.requireNonNull(charSequence);
        this.mChecked = z;
        this.mActionDescription = charSequence;
    }

    public final boolean isChecked() {
        return this.mChecked;
    }

    public final CharSequence getActionDescription() {
        return this.mActionDescription;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.mChecked ? (byte) 1 : 0);
        TextUtils.writeToParcel(this.mActionDescription, parcel, i);
    }

    public ControlButton(Parcel parcel) {
        this.mChecked = parcel.readByte() != 0;
        this.mActionDescription = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
    }
}
