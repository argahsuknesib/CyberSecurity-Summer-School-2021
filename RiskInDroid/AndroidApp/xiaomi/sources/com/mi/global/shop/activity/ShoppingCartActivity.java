package com.mi.global.shop.activity;

import _m_j.byl;
import _m_j.cad;
import _m_j.cak;
import _m_j.cam;
import _m_j.cav;
import _m_j.cbz;
import _m_j.ccn;
import _m_j.ccr;
import _m_j.cec;
import _m_j.ced;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.facebook.appevents.AppEventsLogger;
import com.mi.global.shop.adapter.cart.CartBargainListAdapter;
import com.mi.global.shop.adapter.cart.CartGiftListAdapter;
import com.mi.global.shop.adapter.cart.CartItemListAdapter;
import com.mi.global.shop.adapter.cart.CartOfferListAdapter;
import com.mi.global.shop.newmodel.BaseResult;
import com.mi.global.shop.newmodel.cart.NewAddCartResult;
import com.mi.global.shop.newmodel.cart.NewCartBargainItem;
import com.mi.global.shop.newmodel.cart.NewCartData;
import com.mi.global.shop.newmodel.cart.NewCartGiftItem;
import com.mi.global.shop.newmodel.cart.NewCartItem;
import com.mi.global.shop.newmodel.cart.NewCartResult;
import com.mi.global.shop.newmodel.cart.NewCartSelectInfo;
import com.mi.global.shop.newmodel.cart.NewEditCartData;
import com.mi.global.shop.newmodel.cart.NewEditCartResult;
import com.mi.global.shop.widget.CommonButton;
import com.mi.global.shop.widget.CustomButtonView;
import com.mi.global.shop.widget.CustomTextView;
import com.mi.global.shop.widget.NoScrollListView;
import com.mi.global.shop.widget.dialog.CustomCancelDialog;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.Iterator;

public class ShoppingCartActivity extends BaseActivity implements ccn.O000000o, View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f4688O000000o = "ShoppingCartActivity";
    private AppEventsLogger O00000Oo;
    @BindView(2131493123)
    LinearLayout bargainLL;
    @BindView(2131493124)
    NoScrollListView bargainLV;
    @BindView(2131493126)
    CustomTextView cartBottomTotal;
    @BindView(2131493125)
    View cartBottomView;
    @BindView(2131493140)
    CustomTextView cartTotal;
    @BindView(2131493127)
    CustomButtonView checkoutBtn;
    @BindView(2131493128)
    LinearLayout emptyLL;
    @BindView(2131493129)
    View giftDivider;
    @BindView(2131493130)
    NoScrollListView giftLV;
    @BindView(2131493132)
    NoScrollListView itemLV;
    @BindView(2131493133)
    LinearLayout loadingLL;
    public CartGiftListAdapter mCartGiftListAdapter;
    @BindView(2131494139)
    View mHomeView;
    @BindView(2131493134)
    View mainFrame;
    public NewCartData newCartData;
    @BindView(2131493135)
    View offerDivider;
    @BindView(2131493136)
    NoScrollListView offerLV;
    @BindView(2131493907)
    View promoteLayout;
    @BindView(2131493137)
    CustomTextView promotionTV;
    @BindView(2131493138)
    CustomTextView shippingTV;
    @BindView(2131494068)
    View subtotalLayout;
    @BindView(2131493139)
    CustomTextView subtotalTV;
    @BindView(2131494157)
    View totalLayout;
    @BindView(2131493141)
    CommonButton viewBtn;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        O000000o((int) R.layout.shop_cart_activity);
        ButterKnife.bind(this);
        setTitle((int) R.string.cart_title);
        this.mCartView.setVisibility(4);
        this.mHomeView.setVisibility(0);
        this.mHomeView.setOnClickListener(this);
        this.viewBtn.setOnClickListener(this);
        getCartInfo();
    }

    public void updateView(NewCartData newCartData2) {
        if (newCartData2 == null) {
            String string = getString(R.string.shop_error_network);
            this.loadingLL.setVisibility(8);
            cec.O000000o(this, string, 0);
            setResult(0);
            finish();
            return;
        }
        this.loadingLL.setVisibility(8);
        this.emptyLL.setVisibility(8);
        this.mainFrame.setVisibility(8);
        this.cartBottomView.setVisibility(8);
        if (newCartData2.items == null || newCartData2.items.isEmpty()) {
            this.emptyLL.setVisibility(0);
            updateShoppingCart(0);
            return;
        }
        String str = f4688O000000o;
        ccr.O00000Oo(str, "updateView items number:" + newCartData2.items.size());
        updateShoppingCart(newCartData2.items.size());
        for (int i = 0; i < newCartData2.items.size(); i++) {
            if (newCartData2.items.get(i).cartTTL == 0 || System.currentTimeMillis() <= newCartData2.items.get(i).cartTTL * 1000) {
                newCartData2.items.get(i).timeout = false;
            } else {
                newCartData2.items.get(i).timeout = true;
            }
        }
        this.mainFrame.setVisibility(0);
        this.cartBottomView.setVisibility(0);
        CartItemListAdapter cartItemListAdapter = new CartItemListAdapter(this);
        cartItemListAdapter.O00000o0();
        cartItemListAdapter.O000000o(newCartData2.items);
        this.itemLV.setAdapter((ListAdapter) cartItemListAdapter);
        if (newCartData2.activitys == null || newCartData2.activitys.gift == null || newCartData2.activitys.gift.size() <= 0) {
            this.giftDivider.setVisibility(8);
            this.giftLV.setVisibility(8);
        } else {
            this.giftDivider.setVisibility(0);
            this.giftLV.setVisibility(0);
            this.mCartGiftListAdapter = new CartGiftListAdapter(this);
            this.mCartGiftListAdapter.O00000o0();
            this.mCartGiftListAdapter.O000000o((ArrayList) newCartData2.activitys.gift);
            this.giftLV.setAdapter((ListAdapter) this.mCartGiftListAdapter);
        }
        if (newCartData2.activitys == null || (newCartData2.activitys.reduction == null && newCartData2.activitys.postFree == null)) {
            this.offerDivider.setVisibility(8);
            this.offerLV.setVisibility(8);
        } else {
            ArrayList arrayList = new ArrayList();
            if (newCartData2.activitys.reduction != null) {
                for (int i2 = 0; i2 < newCartData2.activitys.reduction.size(); i2++) {
                    arrayList.add(newCartData2.activitys.reduction.get(i2).actName);
                }
            }
            if (newCartData2.activitys.postFree != null) {
                arrayList.add(newCartData2.activitys.postFree.actName);
            }
            if (arrayList.size() > 0) {
                this.offerDivider.setVisibility(0);
                this.offerLV.setVisibility(0);
                CartOfferListAdapter cartOfferListAdapter = new CartOfferListAdapter(this);
                cartOfferListAdapter.O00000o0();
                cartOfferListAdapter.O000000o(arrayList);
                this.offerLV.setAdapter((ListAdapter) cartOfferListAdapter);
            } else {
                this.offerDivider.setVisibility(8);
                this.offerLV.setVisibility(8);
            }
        }
        if (((double) newCartData2.postFreeBalance) <= 0.0d || newCartData2.postFree) {
            this.shippingTV.setText(byl.O00000oO().getString(R.string.cart_freedelivery));
        } else {
            String string2 = byl.O00000oO().getString(R.string.cart_shippingfee);
            this.shippingTV.setText(String.format(string2, cad.O00000o0() + newCartData2.postFreeBalance_txt));
        }
        if (newCartData2.bargains == null || newCartData2.bargains.size() <= 0) {
            this.bargainLL.setVisibility(8);
        } else {
            CartBargainListAdapter cartBargainListAdapter = new CartBargainListAdapter(this);
            cartBargainListAdapter.O00000o0();
            cartBargainListAdapter.O000000o((ArrayList) newCartData2.bargains);
            this.bargainLV.setAdapter((ListAdapter) cartBargainListAdapter);
            this.bargainLL.setVisibility(0);
        }
        CustomTextView customTextView = this.subtotalTV;
        customTextView.setText(cad.O00000o0() + newCartData2.productMoney_txt);
        if (TextUtils.isEmpty(newCartData2.activityDiscountMoney_txt) || newCartData2.activityDiscountMoney_txt.equalsIgnoreCase("0")) {
            this.promoteLayout.setVisibility(8);
        } else {
            this.promoteLayout.setVisibility(0);
            CustomTextView customTextView2 = this.promotionTV;
            customTextView2.setText(" -" + cad.O00000o0() + newCartData2.activityDiscountMoney_txt);
        }
        CustomTextView customTextView3 = this.cartTotal;
        customTextView3.setText(cad.O00000o0() + newCartData2.orderMoney_txt);
        CustomTextView customTextView4 = this.cartBottomTotal;
        customTextView4.setText("Total  " + cad.O00000o0() + newCartData2.orderMoney_txt);
        this.checkoutBtn.setEnabled(true);
        this.checkoutBtn.setOnClickListener(this);
    }

    public void getCartInfo() {
        runOnUiThread(new Runnable() {
            /* class com.mi.global.shop.activity.ShoppingCartActivity.AnonymousClass1 */

            public final void run() {
                ShoppingCartActivity.this.loadingLL.setVisibility(0);
                ShoppingCartActivity.this.checkoutBtn.setEnabled(false);
            }
        });
        cam cam = new cam(cav.O000OOo(), NewCartResult.class, new cak<NewCartResult>() {
            /* class com.mi.global.shop.activity.ShoppingCartActivity.AnonymousClass2 */

            public final /* synthetic */ void O000000o(BaseResult baseResult) {
                ShoppingCartActivity.this.newCartData = ((NewCartResult) baseResult).data;
                ShoppingCartActivity shoppingCartActivity = ShoppingCartActivity.this;
                shoppingCartActivity.updateView(shoppingCartActivity.newCartData);
                if (ShoppingCartActivity.this.newCartData != null) {
                    ShoppingCartActivity shoppingCartActivity2 = ShoppingCartActivity.this;
                    shoppingCartActivity2.showPageNotice(shoppingCartActivity2.newCartData.pagemsg);
                }
            }

            public final void O000000o(String str) {
                super.O000000o(str);
                ShoppingCartActivity.this.loadingLL.setVisibility(8);
                ShoppingCartActivity.this.finish();
            }
        });
        cam.setTag(f4688O000000o);
        ced.f13683O000000o.add(cam);
    }

    public void delItemDialog(final String str) {
        CustomCancelDialog.Builder builder = new CustomCancelDialog.Builder(this);
        builder.f4982O000000o = getString(R.string.cart_delpromote);
        builder.O000000o(Boolean.TRUE).O000000o(getString(R.string.orderview_confirm), new DialogInterface.OnClickListener() {
            /* class com.mi.global.shop.activity.ShoppingCartActivity.AnonymousClass3 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                ShoppingCartActivity.this.delCartRequest(str);
            }
        }).O000000o(getString(R.string.orderview_no));
        builder.O000000o().show();
    }

    public void onLogin(String str, String str2, String str3) {
        getCartInfo();
        super.onLogin(str, str2, str3);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.title_bar_home) {
            onBackPressed();
        } else if (id == R.id.cart_viewbtn) {
            setResult(-1);
            finish();
        } else if (id == R.id.cart_checkout) {
            gotoCheckout();
        }
    }

    public void gotoCheckout() {
        if (!ccn.O0000o00().O0000o0O()) {
            ccr.O00000Oo(f4688O000000o, "OnClickLog in");
            if (byl.O0000O0o.O00000oo.equals("community_sdk")) {
                gotoAccount();
            } else {
                byl.O00000o0();
            }
        } else {
            NewCartData newCartData2 = this.newCartData;
            if (!(newCartData2 == null || newCartData2.items == null)) {
                ArrayList arrayList = new ArrayList();
                Iterator<NewCartItem> it = this.newCartData.items.iterator();
                while (it.hasNext()) {
                    NewCartItem next = it.next();
                    if (!next.isInsurance && (next.is_cos || next.timeout)) {
                        arrayList.add(next);
                    }
                }
                if (arrayList.size() > 0) {
                    cbz O000000o2 = cbz.O000000o(arrayList);
                    O000000o2.setCancelable(false);
                    O000000o2.show(getSupportFragmentManager().O000000o(), "cart");
                    return;
                }
            }
            startActivityForResult(new Intent(this, CheckoutActivity.class), 16);
        }
    }

    public void updateCartRequest(final String str, final int i) {
        if (!TextUtils.isEmpty(str) && i >= 0) {
            this.checkoutBtn.setEnabled(false);
            cam cam = new cam(cav.O000000o(cav.O00oOooO(), "", str, "", String.valueOf(i)), NewEditCartResult.class, new cak<NewEditCartResult>() {
                /* class com.mi.global.shop.activity.ShoppingCartActivity.AnonymousClass4 */

                public final /* synthetic */ void O000000o(BaseResult baseResult) {
                    ShoppingCartActivity.this.updateSuccess(((NewEditCartResult) baseResult).data, str, i);
                }

                public final void O000000o(String str) {
                    super.O000000o(str);
                    ShoppingCartActivity shoppingCartActivity = ShoppingCartActivity.this;
                    shoppingCartActivity.updateView(shoppingCartActivity.newCartData);
                }
            });
            cam.setTag(f4688O000000o);
            ced.f13683O000000o.add(cam);
        }
    }

    public void delCartRequest(final String str) {
        if (!TextUtils.isEmpty(str)) {
            cam cam = new cam(cav.O000000o(cav.O0000ooO(), "", str, "", ""), NewEditCartResult.class, new cak<NewEditCartResult>() {
                /* class com.mi.global.shop.activity.ShoppingCartActivity.AnonymousClass5 */

                public final /* synthetic */ void O000000o(BaseResult baseResult) {
                    ShoppingCartActivity.this.delSuccess(((NewEditCartResult) baseResult).data, str);
                }

                public final void O000000o(String str) {
                    super.O000000o(str);
                }
            });
            cam.setTag(f4688O000000o);
            ced.f13683O000000o.add(cam);
        }
    }

    public void deleteInvalidCart() {
        NewCartData newCartData2 = this.newCartData;
        if (newCartData2 != null && newCartData2.items != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<NewCartItem> it = this.newCartData.items.iterator();
            while (it.hasNext()) {
                NewCartItem next = it.next();
                if (next.is_cos || next.timeout) {
                    if (TextUtils.isEmpty(sb.toString())) {
                        sb.append(next.itemId);
                    } else {
                        sb.append(",");
                        sb.append(next.itemId);
                    }
                }
            }
            if (!TextUtils.isEmpty(sb.toString())) {
                final String sb2 = sb.toString();
                if (!TextUtils.isEmpty(sb2)) {
                    this.loadingLL.setVisibility(0);
                    cam cam = new cam(cav.O000000o(cav.O0000ooo(), sb2), NewEditCartResult.class, new cak<NewEditCartResult>() {
                        /* class com.mi.global.shop.activity.ShoppingCartActivity.AnonymousClass6 */

                        public final /* synthetic */ void O000000o(BaseResult baseResult) {
                            ShoppingCartActivity.this.loadingLL.setVisibility(8);
                            ShoppingCartActivity.this.delBatchCartSuccess(((NewEditCartResult) baseResult).data, sb2);
                        }

                        public final void O000000o(String str) {
                            super.O000000o(str);
                            ShoppingCartActivity.this.loadingLL.setVisibility(8);
                            ShoppingCartActivity.this.getCartInfo();
                        }
                    });
                    cam.setTag(f4688O000000o);
                    ced.f13683O000000o.add(cam);
                }
            }
        }
    }

    public void delBatchCartSuccess(NewEditCartData newEditCartData, String str) {
        if (newEditCartData != null && this.newCartData != null && !TextUtils.isEmpty(str)) {
            String[] split = str.split(",");
            if (newEditCartData.totalWithoutGift >= 0) {
                updateShoppingCart(newEditCartData.totalWithoutGift);
            }
            if (!TextUtils.isEmpty(newEditCartData.CartActivityDiscountMoney)) {
                this.newCartData.activityDiscountMoney_txt = cad.O00000o0(newEditCartData.CartActivityDiscountMoney);
            }
            if (!TextUtils.isEmpty(newEditCartData.CartOrderMoney)) {
                this.newCartData.orderMoney_txt = cad.O00000o0(newEditCartData.CartOrderMoney);
            }
            if (!TextUtils.isEmpty(newEditCartData.CartProductMoney)) {
                this.newCartData.productMoney_txt = cad.O00000o0(newEditCartData.CartProductMoney);
            }
            if (!Float.isNaN(newEditCartData.CartPostFreeBalance)) {
                this.newCartData.postFreeBalance = newEditCartData.CartPostFreeBalance;
                this.newCartData.postFreeBalance_txt = cad.O00000o0(String.valueOf(newEditCartData.CartPostFreeBalance));
            }
            if (this.newCartData.items != null) {
                ccr.O00000Oo(f4688O000000o, "delSuccess before , has item:" + this.newCartData.items.size());
                for (String O000000o2 : split) {
                    O000000o(newEditCartData, O000000o2);
                }
            }
            if (this.newCartData.items != null) {
                ccr.O00000Oo(f4688O000000o, "delSuccess item remain:" + this.newCartData.items.size());
            }
            this.newCartData.activitys = newEditCartData.activitys;
            this.newCartData.bargains = newEditCartData.bargains;
            updateView(this.newCartData);
        }
    }

    private void O000000o(NewEditCartData newEditCartData, String str) {
        String str2;
        boolean z;
        Boolean bool = Boolean.FALSE;
        int i = 0;
        while (true) {
            if (i >= this.newCartData.items.size()) {
                str2 = "";
                break;
            } else if (this.newCartData.items.get(i).itemId.equalsIgnoreCase(str)) {
                if (this.newCartData.items.get(i).properties == null || TextUtils.isEmpty(this.newCartData.items.get(i).properties.parent_itemId)) {
                    str2 = "";
                } else {
                    bool = Boolean.TRUE;
                    str2 = this.newCartData.items.get(i).properties.parent_itemId;
                }
                String str3 = f4688O000000o;
                ccr.O00000Oo(str3, "delSuccess remove:" + this.newCartData.items.get(i).itemId);
                this.newCartData.items.remove(i);
            } else {
                i++;
            }
        }
        if (bool.booleanValue()) {
            int i2 = 0;
            while (true) {
                if (i2 < this.newCartData.items.size()) {
                    if (this.newCartData.items.get(i2).itemId.equalsIgnoreCase(str2) && this.newCartData.items.get(i2).properties != null && this.newCartData.items.get(i2).properties.insurance != null) {
                        this.newCartData.items.get(i2).properties.insurance.itemId = "";
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
        }
        for (int i3 = 0; i3 < this.newCartData.items.size(); i3++) {
            NewCartItem newCartItem = this.newCartData.items.get(i3);
            if ("bargain".equalsIgnoreCase(newCartItem.getType)) {
                if (newEditCartData.bargains != null) {
                    int size = newEditCartData.bargains.size();
                }
                if (newEditCartData.bargains != null) {
                    Iterator<NewCartBargainItem> it = newEditCartData.bargains.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        NewCartBargainItem next = it.next();
                        String str4 = f4688O000000o;
                        ccr.O00000Oo(str4, "delSuccess remain bargain:" + next.bargainItemId);
                        if (newCartItem.itemId.contains(next.bargainItemId)) {
                            z = false;
                            break;
                        }
                    }
                }
                z = true;
                if (z) {
                    String str5 = f4688O000000o;
                    ccr.O00000Oo(str5, "delSuccess remove bargain item:" + this.newCartData.items.get(i3).itemId);
                    this.newCartData.items.remove(i3);
                }
            }
        }
        for (int i4 = 0; i4 < this.newCartData.items.size(); i4++) {
            if (this.newCartData.items.get(i4).properties != null && "insurance".equalsIgnoreCase(this.newCartData.items.get(i4).getType) && str.equalsIgnoreCase(this.newCartData.items.get(i4).properties.parent_itemId)) {
                this.newCartData.items.remove(i4);
                ccr.O00000Oo(f4688O000000o, "delSuccess remove insurance item:".concat(String.valueOf(str)));
            }
        }
    }

    public void delSuccess(NewEditCartData newEditCartData, String str) {
        if (newEditCartData != null && this.newCartData != null) {
            if (newEditCartData.totalWithoutGift >= 0) {
                updateShoppingCart(newEditCartData.totalWithoutGift);
            }
            if (!TextUtils.isEmpty(newEditCartData.CartActivityDiscountMoney)) {
                this.newCartData.activityDiscountMoney_txt = cad.O00000o0(newEditCartData.CartActivityDiscountMoney);
            }
            if (!TextUtils.isEmpty(newEditCartData.CartOrderMoney)) {
                this.newCartData.orderMoney_txt = cad.O00000o0(newEditCartData.CartOrderMoney);
            }
            if (!TextUtils.isEmpty(newEditCartData.CartProductMoney)) {
                this.newCartData.productMoney_txt = cad.O00000o0(newEditCartData.CartProductMoney);
            }
            if (!Float.isNaN(newEditCartData.CartPostFreeBalance)) {
                this.newCartData.postFreeBalance = newEditCartData.CartPostFreeBalance;
                this.newCartData.postFreeBalance_txt = cad.O00000o0(String.valueOf(newEditCartData.CartPostFreeBalance));
            }
            if (this.newCartData.items != null) {
                String str2 = f4688O000000o;
                ccr.O00000Oo(str2, "delSuccess before , has item:" + this.newCartData.items.size());
                O000000o(newEditCartData, str);
            }
            if (this.newCartData.items != null) {
                String str3 = f4688O000000o;
                ccr.O00000Oo(str3, "delSuccess item remain:" + this.newCartData.items.size());
            }
            this.newCartData.activitys = newEditCartData.activitys;
            this.newCartData.bargains = newEditCartData.bargains;
            updateView(this.newCartData);
        }
    }

    public void updateSuccess(NewEditCartData newEditCartData, String str, int i) {
        if (newEditCartData != null && this.newCartData != null) {
            if (newEditCartData.totalWithoutGift >= 0) {
                updateShoppingCart(newEditCartData.totalWithoutGift);
            }
            if (!TextUtils.isEmpty(newEditCartData.CartActivityDiscountMoney)) {
                this.newCartData.activityDiscountMoney_txt = cad.O00000o0(String.valueOf(newEditCartData.CartActivityDiscountMoney));
            }
            if (!TextUtils.isEmpty(newEditCartData.CartOrderMoney)) {
                this.newCartData.orderMoney_txt = cad.O00000o0(String.valueOf(newEditCartData.CartOrderMoney));
            }
            if (!TextUtils.isEmpty(newEditCartData.CartProductMoney)) {
                this.newCartData.productMoney_txt = cad.O00000o0(String.valueOf(newEditCartData.CartProductMoney));
            }
            if (!Float.isNaN(newEditCartData.CartPostFreeBalance)) {
                this.newCartData.postFreeBalance = newEditCartData.CartPostFreeBalance;
                this.newCartData.postFreeBalance_txt = cad.O00000o0(String.valueOf(newEditCartData.CartPostFreeBalance));
            }
            if (this.newCartData.items != null) {
                Iterator<NewCartItem> it = this.newCartData.items.iterator();
                while (it.hasNext()) {
                    NewCartItem next = it.next();
                    if (next.itemId.equalsIgnoreCase(str)) {
                        next.num = i;
                        next.subtotal = next.salePrice * ((float) i);
                        next.subtotal_txt = cad.O00000o0(String.valueOf(next.subtotal));
                        if (!(next.properties == null || next.properties.insurance == null || TextUtils.isEmpty(next.properties.insurance.itemId))) {
                            next.properties.insurance.num = i;
                        }
                    }
                    if (next.properties != null && !TextUtils.isEmpty(next.properties.parent_itemId) && next.properties.parent_itemId.equalsIgnoreCase(str) && "insurance".equalsIgnoreCase(next.getType)) {
                        next.num = i;
                        next.subtotal = next.salePrice * ((float) i);
                        next.subtotal_txt = cad.O00000o0(String.valueOf(next.subtotal));
                    }
                }
            }
            this.newCartData.activitys = newEditCartData.activitys;
            this.newCartData.bargains = newEditCartData.bargains;
            if (this.newCartData.items != null) {
                if (this.newCartData.bargains == null || this.newCartData.bargains.size() <= 0) {
                    for (int i2 = 0; i2 < this.newCartData.items.size(); i2++) {
                        if ("bargain".equalsIgnoreCase(this.newCartData.items.get(i2).getType)) {
                            this.newCartData.items.remove(i2);
                        }
                    }
                } else {
                    Boolean bool = Boolean.FALSE;
                    for (int i3 = 0; i3 < this.newCartData.items.size(); i3++) {
                        NewCartItem newCartItem = this.newCartData.items.get(i3);
                        if ("bargain".equalsIgnoreCase(newCartItem.getType)) {
                            Boolean bool2 = Boolean.FALSE;
                            int i4 = 0;
                            while (true) {
                                if (i4 >= this.newCartData.bargains.size()) {
                                    break;
                                } else if (newCartItem.itemId.toLowerCase().contains(this.newCartData.bargains.get(i4).bargainItemId.toLowerCase())) {
                                    bool2 = Boolean.TRUE;
                                    break;
                                } else {
                                    i4++;
                                }
                            }
                            if (!bool2.booleanValue()) {
                                this.newCartData.items.remove(i3);
                            }
                        }
                    }
                }
            }
            updateView(this.newCartData);
        }
    }

    public void addCartSuccess() {
        int shoppingCart = getShoppingCart();
        int i = 1;
        if (shoppingCart > 0) {
            i = 1 + shoppingCart;
        }
        updateShoppingCart(i);
    }

    public void addCartRequest(String str, final boolean z) {
        if (!TextUtils.isEmpty(str)) {
            ccr.O00000Oo(f4688O000000o, "recordCartEvent : itemId".concat(String.valueOf(str)));
            if (this.O00000Oo == null) {
                this.O00000Oo = AppEventsLogger.newLogger(this);
            }
            try {
                Bundle bundle = new Bundle();
                bundle.putString("fb_content_id", str);
                this.O00000Oo.logEvent("fb_mobile_add_to_cart", 1.0d, bundle);
            } catch (Exception e) {
                e.printStackTrace();
            }
            cam cam = new cam(cav.O000000o(cav.O0000oo(), str, "", "", ""), NewAddCartResult.class, new cak<NewAddCartResult>() {
                /* class com.mi.global.shop.activity.ShoppingCartActivity.AnonymousClass7 */

                public final void O000000o(String str) {
                    super.O000000o(str);
                }

                public final /* synthetic */ void O000000o(BaseResult baseResult) {
                    if (z) {
                        ShoppingCartActivity.this.getCartInfo();
                    }
                    ShoppingCartActivity.this.addCartSuccess();
                }
            });
            cam.setTag(f4688O000000o);
            ced.f13683O000000o.add(cam);
        }
    }

    public void chooseGift(NewCartGiftItem newCartGiftItem, NewCartSelectInfo newCartSelectInfo) {
        NewCartData newCartData2 = this.newCartData;
        if (newCartData2 != null && newCartData2.activitys != null && newCartData2.activitys.gift != null && this.mCartGiftListAdapter != null) {
            int i = 0;
            while (true) {
                if (i >= newCartData2.activitys.gift.size()) {
                    break;
                } else if (newCartGiftItem.itemId.equalsIgnoreCase(newCartData2.activitys.gift.get(i).itemId)) {
                    newCartData2.activitys.gift.get(i).product_name = newCartSelectInfo.product_name;
                    newCartData2.activitys.gift.get(i).image_url = newCartSelectInfo.image_url;
                    break;
                } else {
                    i++;
                }
            }
            this.mCartGiftListAdapter.notifyDataSetChanged();
        }
    }

    public String getBarginItembyId(String str) {
        NewCartData newCartData2 = this.newCartData;
        if (!(newCartData2 == null || newCartData2.items == null)) {
            for (int i = 0; i < this.newCartData.items.size(); i++) {
                NewCartItem newCartItem = this.newCartData.items.get(i);
                if (newCartItem.itemId.startsWith(str) && "bargain".equalsIgnoreCase(newCartItem.getType)) {
                    return newCartItem.itemId;
                }
            }
        }
        return "";
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 16) {
            if (i2 == -1) {
                setResult(-1);
                finish();
            }
            if (!(i2 == 0 && intent == null)) {
            }
        } else if (i != 23) {
            if (i != 20) {
                if (i == 21 && i2 == -1) {
                    getCartInfo();
                }
            } else if (i2 == -1) {
                getCartInfo();
            }
        } else if (i2 == -1) {
            getCartInfo();
        }
    }
}
