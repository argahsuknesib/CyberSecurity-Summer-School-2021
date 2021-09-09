package _m_j;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;

public final class hac extends RecyclerView.O0000Oo {

    /* renamed from: O000000o  reason: collision with root package name */
    private final int f18686O000000o = gpc.O000000o(7.0f);
    private Paint O00000Oo = new Paint();

    public hac() {
        this.O00000Oo.setColor(ServiceApplication.getAppContext().getResources().getColor(R.color.mj_color_background));
    }

    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
        if (!(recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            rect.contains(0, 0, 0, 0);
        } else if (recyclerView.getChildAdapterPosition(view) == 0) {
            rect.top = this.f18686O000000o;
        } else {
            rect.top = 0;
        }
    }

    public final void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
        super.onDraw(canvas, recyclerView, o000OO0o);
    }
}
