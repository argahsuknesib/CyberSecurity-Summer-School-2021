package android.service.controls.actions;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

public final class ControlActionWrapper implements Parcelable {
    public static final Parcelable.Creator<ControlActionWrapper> CREATOR = new Parcelable.Creator<ControlActionWrapper>() {
        /* class android.service.controls.actions.ControlActionWrapper.AnonymousClass1 */

        public final ControlActionWrapper createFromParcel(Parcel parcel) {
            return new ControlActionWrapper(ControlAction.createActionFromBundle(parcel.readBundle()));
        }

        public final ControlActionWrapper[] newArray(int i) {
            return new ControlActionWrapper[i];
        }
    };
    private final ControlAction mControlAction;

    public final int describeContents() {
        return 0;
    }

    public ControlActionWrapper(ControlAction controlAction) {
        Objects.requireNonNull(controlAction);
        this.mControlAction = controlAction;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.mControlAction.getDataBundle());
    }

    public final ControlAction getWrappedAction() {
        return this.mControlAction;
    }
}
