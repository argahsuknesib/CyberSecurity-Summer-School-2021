package com.xiaomi.smarthome.uwb;

import _m_j.hcc;
import _m_j.hcf;
import _m_j.hch;
import _m_j.heh;
import _m_j.hey;
import _m_j.ixe;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001Jq\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u0003\"\u0004\b\u0000\u0010\u0006\"\u0010\b\u0001\u0010\u0005*\n\u0012\u0004\u0012\u0002H\u0006\u0018\u00010\u0007\"\u0016\b\u0002\u0010\u0004*\u0010\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u0006\u0018\u00010\b2\u0006\u0010\t\u001a\u0002H\u00042\u0006\u0010\n\u001a\u0002H\u00052\u0010\u0010\u000b\u001a\f\u0012\u0006\b\u0001\u0012\u0002H\u0006\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"com/xiaomi/smarthome/uwb/UwbCardActivity$showCard$1", "Lcom/xiaomi/smarthome/newui/card/CardRenderFactory$CardItemCreater;", "createCardItem", "Lcom/xiaomi/smarthome/newui/card/CardItem;", "C", "E", "T", "Lcom/xiaomi/smarthome/newui/card/Card$CardType;", "Lcom/xiaomi/smarthome/newui/card/Card;", "card", "e", "prop", "", "(Lcom/xiaomi/smarthome/newui/card/Card;Lcom/xiaomi/smarthome/newui/card/Card$CardType;[Ljava/lang/Object;)Lcom/xiaomi/smarthome/newui/card/CardItem;", "uwb-card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UwbCardActivity$showCard$1 implements hch.O000000o {
    final /* synthetic */ hch.O000000o $creator;

    UwbCardActivity$showCard$1(hch.O000000o o000000o) {
        this.$creator = o000000o;
    }

    public final <T, E extends hcc.O000000o<T>, C extends hcc<E, T>> hcf<C, E, T> createCardItem(C c, E e, T[] tArr) {
        hcf<C, E, T> createCardItem = this.$creator.createCardItem(c, e, tArr);
        if (createCardItem instanceof hey) {
            ((hey) createCardItem).O0000oOo = "uwb_switchstatus";
        } else if (createCardItem instanceof heh) {
            ((heh) createCardItem).O0000o = "uwb_switchstatus";
        }
        ixe.O00000Oo(createCardItem, "cardItem");
        return createCardItem;
    }
}
