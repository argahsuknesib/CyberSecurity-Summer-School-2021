package com.xiaomi.smarthome.miui;

import _m_j.fml;
import _m_j.fqw;
import _m_j.ft;
import _m_j.gfx;
import _m_j.ggb;
import _m_j.go;
import _m_j.gpc;
import _m_j.gs;
import _m_j.gyv;
import _m_j.hfq;
import _m_j.hsf;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.miot.BinderParcel;
import com.xiaomi.miot.service.ICallback;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.device.MiioDeviceV2;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseWhiteActivity;
import com.xiaomi.smarthome.homeroom.model.GridViewData;
import com.xiaomi.smarthome.homeroom.model.Home;
import java.util.ArrayList;

public class CommonDeviceEditActivity extends BaseWhiteActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private gs f9988O000000o;
    private GridLayoutManager O00000Oo;
    private TextView O00000o;
    private RecyclerView O00000o0;
    private ICallback O00000oO;
    private O00000Oo O00000oo = new O00000Oo();
    private Rect O0000O0o = new Rect();
    private boolean O0000OOo = false;
    private BroadcastReceiver O0000Oo = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.miui.CommonDeviceEditActivity.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            if ("action_on_login_success".equals(intent.getAction())) {
                ggb.O00000Oo().O000000o(false);
            }
        }
    };
    private int O0000Oo0 = 8;
    private boolean O0000OoO;
    public gyv mGridAdapter;
    public AutoMaskLinearLayout mRootView;

    class O00000Oo extends go {
        O00000Oo() {
        }

        public final boolean O000000o(RecyclerView.O000OOo0 o000OOo0, int i, int i2, int i3, int i4) {
            if (!(o000OOo0 instanceof gyv.O000000o) || !CommonDeviceEditActivity.this.mGridAdapter.O0000Oo0) {
                return super.O000000o(o000OOo0, i, i2, i3, i4);
            }
            return false;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().setFlags(134217728, 134217728);
        }
        setContentView((int) R.layout.activity_common_device_edit);
        Parcelable parcelableExtra = getIntent().getParcelableExtra("extra");
        this.O0000OoO = getIntent().getBooleanExtra("fileter_key", false);
        if (parcelableExtra != null) {
            this.O00000oO = ICallback.Stub.asInterface(((BinderParcel) parcelableExtra).f6030O000000o);
        }
        this.mRootView = (AutoMaskLinearLayout) findViewById(R.id.al_root);
        this.mRootView.setBackgroundDrawable(new ColorDrawable(-7829368));
        Intent intent = getIntent();
        if (intent != null) {
            this.O0000OOo = intent.getBooleanExtra("show_camera_card", false);
            this.O0000Oo0 = intent.getIntExtra("show_card_count", this.O0000Oo0);
        }
        this.O00000o = (TextView) findViewById(R.id.back);
        this.O00000o.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miui.CommonDeviceEditActivity.AnonymousClass2 */

            public final void onClick(View view) {
                CommonDeviceEditActivity.this.finish();
            }
        });
        this.O00000o0 = (RecyclerView) findViewById(R.id.recyclerview);
        this.mGridAdapter = new gyv(getContext(), this.mRootView, this.O0000OOo, this.O0000Oo0);
        this.f9988O000000o = new gs(new O00000o0());
        this.f9988O000000o.O000000o(this.O00000o0);
        this.O00000Oo = new GridLayoutManager(getContext(), 2);
        this.mGridAdapter.O00000oo = new hfq() {
            /* class com.xiaomi.smarthome.miui.$$Lambda$CommonDeviceEditActivity$2UDPeExwGMYeRG8arDdWaeQdSIE */

            public final void onStartDrag(RecyclerView.O000OOo0 o000OOo0) {
                CommonDeviceEditActivity.this.O000000o(o000OOo0);
            }
        };
        this.O00000o0.setLayoutManager(this.O00000Oo);
        this.O00000o0.setItemAnimator(this.O00000oo);
        this.mGridAdapter.O000000o();
        this.O00000o0.setAdapter(this.mGridAdapter);
        this.O00000o0.addOnScrollListener(new RecyclerView.O00oOooO() {
            /* class com.xiaomi.smarthome.miui.CommonDeviceEditActivity.AnonymousClass3 */

            public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
            }

            public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                CommonDeviceEditActivity.this.mRootView.setScrolledY(-i2);
                CommonDeviceEditActivity.this.mRootView.invalidate();
            }
        });
        this.O00000o0.addItemDecoration(new O000000o(gpc.O000000o(6.0f)));
        if (ServiceApplication.getStateNotifier().f15923O000000o != 4) {
            ft.O000000o(getContext()).O000000o(this.O0000Oo, new IntentFilter("action_on_login_success"));
            return;
        }
        CoreApi.O000000o().O000000o(this, $$Lambda$CommonDeviceEditActivity$Ez4U9KlNiOWne__kBdadN0tJtQ.INSTANCE);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(RecyclerView.O000OOo0 o000OOo0) {
        Home O0000Oo02 = ggb.O00000Oo().O0000Oo0();
        if (O0000Oo02 == null || O0000Oo02.isOwner()) {
            this.f9988O000000o.O00000Oo(o000OOo0);
            o000OOo0.itemView.getDrawingRect(this.O0000O0o);
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onDestroy() {
        super.onDestroy();
        try {
            ft.O000000o(getContext()).O000000o(this.O0000Oo);
        } catch (Exception unused) {
        }
        gyv gyv = this.mGridAdapter;
        ft.O000000o(gyv.O00000o0).O000000o(gyv.O0000OOo);
    }

    public void onPause() {
        super.onPause();
        if (this.mGridAdapter.O0000O0o && this.O00000oO != null) {
            ServiceApplication.getGlobalWorkerHandler().post(new hsf(this.O00000oO, false, this.O0000OoO));
        }
    }

    class O00000o0 extends gs.O000000o {
        public final void O000000o(RecyclerView.O000OOo0 o000OOo0) {
        }

        public final boolean O000000o() {
            return false;
        }

        O00000o0() {
        }

        public final int O000000o(RecyclerView recyclerView, RecyclerView.O000OOo0 o000OOo0) {
            return gs.O000000o.O000000o(15);
        }

        public final boolean O000000o(RecyclerView.O000OOo0 o000OOo0, RecyclerView.O000OOo0 o000OOo02) {
            return CommonDeviceEditActivity.this.mGridAdapter.O000000o(o000OOo0.getAdapterPosition(), o000OOo02.getAdapterPosition());
        }

        public final void O00000o(RecyclerView recyclerView, RecyclerView.O000OOo0 o000OOo0) {
            super.O00000o(recyclerView, o000OOo0);
        }

        public final void O000000o(RecyclerView recyclerView, RecyclerView.O000OOo0 o000OOo0, int i, RecyclerView.O000OOo0 o000OOo02, int i2, int i3, int i4) {
            super.O000000o(recyclerView, o000OOo0, i, o000OOo02, i2, i3, i4);
        }

        public final void O000000o(RecyclerView.O000OOo0 o000OOo0, int i) {
            super.O000000o(o000OOo0, i);
            if (i == 0) {
                AutoMaskLinearLayout autoMaskLinearLayout = CommonDeviceEditActivity.this.mRootView;
                autoMaskLinearLayout.O00000oo = false;
                autoMaskLinearLayout.postInvalidate();
                gyv gyv = CommonDeviceEditActivity.this.mGridAdapter;
                gyv.O0000Oo0 = false;
                if (gyv.O00000oO != null && !gyv.O00000oO.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < gyv.O00000oO.size(); i2++) {
                        GridViewData gridViewData = gyv.O00000oO.get(i2);
                        if (!(gridViewData == null || gridViewData.f8988O000000o == GridViewData.GridType.TYPE_ADD_TO_COMMON || gridViewData.f8988O000000o == GridViewData.GridType.TYPE_TIPS)) {
                            if (gridViewData.f8988O000000o == GridViewData.GridType.TYPE_NORMAL && gridViewData.O00000Oo != null) {
                                arrayList.add(gridViewData.O00000Oo.did);
                            } else if (gridViewData.f8988O000000o == GridViewData.GridType.TYPE_IR) {
                                MiioDeviceV2 miioDeviceV2 = new MiioDeviceV2();
                                miioDeviceV2.name = gyv.O00000o0.getString(R.string.group_type_phoneir);
                                miioDeviceV2.did = fml.O000000o();
                                miioDeviceV2.model = fqw.O000000o();
                                arrayList.add("com.xiaomi.smarthome.common_use.ir_did");
                            }
                        }
                    }
                    gfx.O000000o().O000000o(arrayList, ggb.O00000Oo().O0000Oo0());
                    gyv.O0000O0o = true;
                }
            }
        }
    }

    public class O000000o extends RecyclerView.O0000Oo {
        private int O00000Oo = 2;
        private boolean O00000o;
        private int O00000o0;

        public O000000o(int i) {
            this.O00000o0 = i;
            this.O00000o = true;
        }

        public final void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
            super.onDraw(canvas, recyclerView, o000OO0o);
        }

        public final void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
            super.onDrawOver(canvas, recyclerView, o000OO0o);
        }

        public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            int i = this.O00000Oo;
            int i2 = childAdapterPosition % i;
            if (this.O00000o) {
                gyv gyv = CommonDeviceEditActivity.this.mGridAdapter;
                char c = 0;
                int i3 = 0;
                char c2 = 0;
                while (true) {
                    if (i3 >= gyv.O00000oO.size()) {
                        break;
                    } else if (i3 != childAdapterPosition) {
                        if (gyv.O00000oO.get(i3).f8988O000000o == GridViewData.GridType.TYPE_TIPS) {
                            c2 ^= 1;
                        }
                        i3++;
                    } else if (gyv.O00000oO.get(i3).f8988O000000o != GridViewData.GridType.TYPE_TIPS) {
                        if (i3 % 2 == 0) {
                            c = 1;
                        }
                        c = (c ^ c2) != 0 ? (char) 1 : 2;
                    }
                }
                if (c == 0) {
                    int i4 = this.O00000o0;
                    rect.left = i4;
                    rect.right = i4;
                } else if (c == 1) {
                    int i5 = this.O00000o0;
                    rect.left = i5;
                    rect.right = i5 / 2;
                } else {
                    int i6 = this.O00000o0;
                    rect.left = i6 / 2;
                    rect.right = i6;
                }
                rect.bottom = this.O00000o0;
                return;
            }
            int i7 = this.O00000o0;
            rect.left = (i2 * i7) / i;
            rect.right = i7 - (((i2 + 1) * i7) / i);
            if (childAdapterPosition >= i) {
                rect.top = i7;
            }
        }
    }
}
