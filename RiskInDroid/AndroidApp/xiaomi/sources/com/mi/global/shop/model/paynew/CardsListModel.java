package com.mi.global.shop.model.paynew;

import _m_j.bzm;
import com.mi.global.shop.model.common.UserCardsType;
import com.mi.global.shop.model.user.CardsList;
import com.squareup.wire.Wire;
import java.util.ArrayList;

public class CardsListModel {
    public ArrayList<bzm> cardList;

    public static CardsListModel parseCardsList(CardsList cardsList) {
        CardsListModel cardsListModel = new CardsListModel();
        cardsListModel.cardList = new ArrayList<>();
        for (UserCardsType next : cardsList.user_cards) {
            ArrayList<bzm> arrayList = cardsListModel.cardList;
            bzm bzm = new bzm();
            bzm.O00000Oo = (String) Wire.get(next.card_type, "");
            bzm.O00000o = (String) Wire.get(next.card_token, "");
            bzm.O00000oO = (String) Wire.get(next.card_no, "");
            bzm.O00000oo = (String) Wire.get(next.card_mode, "");
            bzm.f13494O000000o = ((String) Wire.get(next.expiry_month, "")) + " / " + ((String) Wire.get(next.expiry_year, ""));
            bzm.O0000O0o = (String) Wire.get(next.name_on_card, "");
            bzm.O0000OOo = (String) Wire.get(next.card_brand, "");
            arrayList.add(bzm);
        }
        return cardsListModel;
    }
}
