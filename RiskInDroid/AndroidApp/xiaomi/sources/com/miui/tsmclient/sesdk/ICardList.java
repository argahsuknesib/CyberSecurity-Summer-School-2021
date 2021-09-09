package com.miui.tsmclient.sesdk;

import com.miui.tsmclient.net.AuthApiException;
import java.util.List;

public interface ICardList {
    List<SeCard> getIssuedCardList(CardCategory cardCategory) throws AuthApiException;

    List<SeCard> getSupportedCardList(CardCategory cardCategory) throws AuthApiException;

    List<SeCard> getSupportedCardListWithGroup(CardCategory cardCategory) throws AuthApiException;
}
