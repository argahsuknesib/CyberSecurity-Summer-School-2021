package _m_j;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

public final class ckv implements View.OnClickListener {

    /* renamed from: O000000o */
    public static final int camera_ic_player_delete = 2132083396;

    /* renamed from: O00000Oo */
    public static final int camera_ic_player_snapshot = 2132083402;

    /* renamed from: O00000o */
    public static final int camera_ic_player_share = 2132083401;

    /* renamed from: O00000o0 */
    public static final int camera_ic_player_download = 2132083397;
    public ImageView O00000oO;
    public O00000Oo O00000oo;
    private ImageView O0000O0o;
    private List<ImageView> O0000OOo = new ArrayList();
    private boolean O0000Oo;
    private O000000o O0000Oo0;
    private final View O0000OoO;

    public interface O000000o {
        void onActionClick(int i);
    }

    public interface O00000Oo {
        void onBack();
    }

    public ckv(View view, O000000o o000000o, boolean z, int... iArr) {
        this.O0000OoO = view.findViewById(R.id.videoViewTopCtrl);
        this.O0000O0o = (ImageView) view.findViewById(R.id.ivBack);
        this.O00000oO = (ImageView) view.findViewById(R.id.ivBack2);
        this.O0000O0o.setOnClickListener(this);
        if (iArr == null) {
            ((View) this.O0000O0o.getParent()).setBackground(null);
            return;
        }
        int[] iArr2 = {R.id.ivAction1, R.id.ivAction2, R.id.ivAction3, R.id.ivAction4};
        this.O0000Oo = z;
        int i = 0;
        while (i < iArr.length && i < 4) {
            ImageView imageView = (ImageView) view.findViewById(iArr2[i]);
            imageView.setImageResource(iArr[i]);
            imageView.setOnClickListener(this);
            imageView.setTag(Integer.valueOf(iArr[i]));
            this.O0000OOo.add(imageView);
            if (z) {
                imageView.setVisibility(0);
            }
            i++;
        }
        this.O0000Oo0 = o000000o;
    }

    public final void onClick(View view) {
        if (view.getId() == R.id.ivBack) {
            O00000Oo o00000Oo = this.O00000oo;
            if (o00000Oo != null) {
                o00000Oo.onBack();
                return;
            }
            return;
        }
        O000000o o000000o = this.O0000Oo0;
        if (o000000o != null) {
            o000000o.onActionClick(((Integer) view.getTag()).intValue());
        }
    }

    public final void O000000o(boolean z) {
        View view;
        if (z) {
            for (int i = 0; i < this.O0000OOo.size(); i++) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.O0000OOo.get(i).getLayoutParams();
                layoutParams.setMarginStart((int) this.O0000O0o.getContext().getResources().getDimension(R.dimen.general_player_top_ctrl_icon_left_margin));
                this.O0000OOo.get(i).setLayoutParams(layoutParams);
                if (!this.O0000Oo) {
                    this.O0000OOo.get(i).setVisibility(8);
                }
            }
            View view2 = this.O0000OoO;
            if (view2 != null) {
                view2.setPadding(0, 0, 0, 0);
            }
            this.O0000O0o.setVisibility(8);
            return;
        }
        for (int i2 = 0; i2 < this.O0000OOo.size(); i2++) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.O0000OOo.get(i2).getLayoutParams();
            layoutParams2.setMarginStart((int) this.O0000O0o.getContext().getResources().getDimension(R.dimen.general_player_top_ctrl_icon_left_margin_landscape));
            this.O0000OOo.get(i2).setLayoutParams(layoutParams2);
            if (!this.O0000Oo) {
                this.O0000OOo.get(i2).setVisibility(0);
            }
        }
        if (hyy.O000000o() && (view = this.O0000OoO) != null) {
            view.setPadding(gpc.O000000o(50.0f), 0, gpc.O000000o(50.0f), 0);
        }
        this.O0000O0o.setVisibility(0);
    }
}
