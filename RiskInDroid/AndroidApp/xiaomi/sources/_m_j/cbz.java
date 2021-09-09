package _m_j;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertDialog;
import com.mi.global.shop.activity.ShoppingCartActivity;
import com.mi.global.shop.adapter.cart.CartInvalidItemListAdapter;
import com.mi.global.shop.newmodel.cart.NewCartItem;
import com.mi.global.shop.widget.MaxHeightListView;
import com.mi.util.Device;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

public class cbz extends dz {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f13610O000000o = "cbz";
    private MaxHeightListView O00000Oo;
    private ArrayList<NewCartItem> O00000o;
    private CartInvalidItemListAdapter O00000o0;

    public static cbz O000000o(ArrayList<NewCartItem> arrayList) {
        cbz cbz = new cbz();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("items", arrayList);
        cbz.setArguments(bundle);
        return cbz;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCancelable(true);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.O00000o = arguments.getParcelableArrayList("items");
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        View inflate = LayoutInflater.from(getContext()).inflate((int) R.layout.shop_cart_dialog_fragment, (ViewGroup) null);
        inflate.findViewById(R.id.content).getLayoutParams().width = (Device.f5099O000000o / 4) * 3;
        inflate.findViewById(R.id.cancel_btn).setOnClickListener(new View.OnClickListener() {
            /* class _m_j.cbz.AnonymousClass1 */

            public final void onClick(View view) {
                cbz.this.dismiss();
            }
        });
        inflate.findViewById(R.id.remove_btn).setOnClickListener(new View.OnClickListener() {
            /* class _m_j.cbz.AnonymousClass2 */

            public final void onClick(View view) {
                cbz.this.dismiss();
                if (cbz.this.getActivity() instanceof ShoppingCartActivity) {
                    ((ShoppingCartActivity) cbz.this.getActivity()).deleteInvalidCart();
                }
            }
        });
        this.O00000Oo = (MaxHeightListView) inflate.findViewById(R.id.list);
        this.O00000Oo.setMaxHeight(cdy.O000000o(getContext(), 170.0f));
        this.O00000o0 = new CartInvalidItemListAdapter(getContext());
        this.O00000o0.O000000o((List) this.O00000o);
        this.O00000Oo.setAdapter((ListAdapter) this.O00000o0);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setView(inflate);
        AlertDialog create = builder.create();
        create.getWindow().getDecorView().setBackgroundResource(17170445);
        return create;
    }
}
