package com.mi.global.shop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import android.webkit.WebView;
import java.util.ArrayList;

public class BaseWebView extends WebView {

    /* renamed from: O000000o  reason: collision with root package name */
    public ArrayList<String> f4948O000000o = new ArrayList<>();

    public BaseWebView(Context context) {
        super(context);
    }

    public BaseWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BaseWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public String getLastUrl() {
        WebHistoryItem itemAtIndex;
        WebBackForwardList copyBackForwardList = copyBackForwardList();
        return (copyBackForwardList == null || copyBackForwardList.getSize() <= 1 || (itemAtIndex = copyBackForwardList.getItemAtIndex(copyBackForwardList.getCurrentIndex() - 1)) == null) ? "" : itemAtIndex.getUrl();
    }

    public String getLastTitle() {
        WebHistoryItem itemAtIndex;
        WebBackForwardList copyBackForwardList = copyBackForwardList();
        return (copyBackForwardList == null || copyBackForwardList.getSize() <= 1 || (itemAtIndex = copyBackForwardList.getItemAtIndex(copyBackForwardList.getCurrentIndex() - 1)) == null) ? "" : itemAtIndex.getTitle();
    }

    public String getCurrentUrl() {
        WebHistoryItem itemAtIndex;
        WebBackForwardList copyBackForwardList = copyBackForwardList();
        return (copyBackForwardList == null || copyBackForwardList.getSize() <= 1 || (itemAtIndex = copyBackForwardList.getItemAtIndex(copyBackForwardList.getCurrentIndex())) == null) ? "" : itemAtIndex.getUrl();
    }

    public String getCurrentTitle() {
        WebHistoryItem itemAtIndex;
        WebBackForwardList copyBackForwardList = copyBackForwardList();
        return (copyBackForwardList == null || copyBackForwardList.getSize() <= 1 || (itemAtIndex = copyBackForwardList.getItemAtIndex(copyBackForwardList.getCurrentIndex())) == null) ? "" : itemAtIndex.getTitle();
    }
}
