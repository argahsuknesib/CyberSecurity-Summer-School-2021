package _m_j;

import O000000o.O000000o.O00000Oo.d;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.chad.library.adapter.base.entity.SectionEntity;
import com.hannto.print.bean.PhotoBean;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

public final class O00O000o extends vq<PhotoBean, vr> {

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f6622O000000o;

    public O00O000o(List list, Context context) {
        super(R.layout.ht_album_grid_item, R.layout.ht_album_grid_head, list);
        this.f6622O000000o = context;
    }

    public final void O000000o(vr vrVar, SectionEntity sectionEntity) {
        vrVar.O000000o((int) R.id.album_grid_head, ((PhotoBean) sectionEntity).header);
    }

    public final void O000000o(vr vrVar, Object obj) {
        PhotoBean photoBean = (PhotoBean) obj;
        int i = this.f6622O000000o.getResources().getDisplayMetrics().widthPixels;
        if (photoBean.isCameraView) {
            View O00000Oo = vrVar.O00000Oo(R.id.view_background);
            O00000Oo.setVisibility(0);
            vrVar.O00000Oo(R.id.iv_photo).setVisibility(0);
            vrVar.O00000Oo(R.id.iv_album_item).setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) O00000Oo.getLayoutParams();
            int i2 = i / 4;
            layoutParams.width = i2;
            layoutParams.height = i2;
            O00000Oo.setLayoutParams(layoutParams);
        } else {
            vrVar.O00000Oo(R.id.view_background).setVisibility(8);
            vrVar.O00000Oo(R.id.iv_photo).setVisibility(8);
            ImageView imageView = (ImageView) vrVar.O00000Oo(R.id.iv_album_item);
            imageView.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
            int i3 = i / 4;
            layoutParams2.width = i3;
            layoutParams2.height = i3;
            imageView.setLayoutParams(layoutParams2);
            ((up) uo.O000000o(this.f6622O000000o).O000000o(photoBean.imageUri).O00000o0(i3)).O000000o(new oooOoO(photoBean)).O000000o((ImageView) vrVar.O00000Oo(R.id.iv_album_item));
            if (d.a.Single == d.O000000o().O0000Oo0) {
                vrVar.O00000Oo(R.id.checkbox_container, false);
            } else {
                vrVar.O00000Oo(R.id.checkbox_container, true);
                ArrayList<PhotoBean> arrayList = d.O000000o().O00000o0;
                Button button = (Button) vrVar.O00000Oo(R.id.checkbox);
                if (arrayList == null || !arrayList.contains(photoBean)) {
                    button.setBackgroundResource(R.mipmap.ht_photo_unselected_white);
                    button.setText("");
                } else {
                    button.setTextColor(-1);
                    button.setBackgroundResource(R.mipmap.ht_photo_selected);
                }
            }
        }
        vrVar.O000000o(R.id.iv_album_item).O000000o(R.id.checkbox_container).O000000o(R.id.checkbox).O000000o(R.id.view_background);
    }
}
