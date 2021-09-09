package _m_j;

import android.view.View;
import com.hannto.print.bean.PhotoBean;
import com.hannto.print.pickimage.activity.PickPhotoPreviewActivity;
import java.util.ArrayList;

public final class O00O0o implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    public final /* synthetic */ ArrayList f6631O000000o;
    public final /* synthetic */ PhotoBean O00000Oo;
    public final /* synthetic */ PickPhotoPreviewActivity O00000o0;

    public O00O0o(PickPhotoPreviewActivity pickPhotoPreviewActivity, ArrayList arrayList, PhotoBean photoBean) {
        this.O00000o0 = pickPhotoPreviewActivity;
        this.f6631O000000o = arrayList;
        this.O00000Oo = photoBean;
    }

    public final void onClick(View view) {
        this.f6631O000000o.add(this.O00000Oo);
        PickPhotoPreviewActivity pickPhotoPreviewActivity = this.O00000o0;
        pickPhotoPreviewActivity.a(pickPhotoPreviewActivity.e);
    }
}
