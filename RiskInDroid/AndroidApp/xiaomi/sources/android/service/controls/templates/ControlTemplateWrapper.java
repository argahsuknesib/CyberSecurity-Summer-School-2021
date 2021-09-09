package android.service.controls.templates;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

public final class ControlTemplateWrapper implements Parcelable {
    public static final Parcelable.Creator<ControlTemplateWrapper> CREATOR = new Parcelable.Creator<ControlTemplateWrapper>() {
        /* class android.service.controls.templates.ControlTemplateWrapper.AnonymousClass1 */

        public final ControlTemplateWrapper createFromParcel(Parcel parcel) {
            return new ControlTemplateWrapper(ControlTemplate.createTemplateFromBundle(parcel.readBundle()));
        }

        public final ControlTemplateWrapper[] newArray(int i) {
            return new ControlTemplateWrapper[i];
        }
    };
    private final ControlTemplate mControlTemplate;

    public final int describeContents() {
        return 0;
    }

    public ControlTemplateWrapper(ControlTemplate controlTemplate) {
        Objects.requireNonNull(controlTemplate);
        this.mControlTemplate = controlTemplate;
    }

    public final ControlTemplate getWrappedTemplate() {
        return this.mControlTemplate;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.mControlTemplate.getDataBundle());
    }
}
