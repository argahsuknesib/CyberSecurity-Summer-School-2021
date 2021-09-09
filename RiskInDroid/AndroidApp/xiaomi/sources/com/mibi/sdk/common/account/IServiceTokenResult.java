package com.mibi.sdk.common.account;

import android.content.Intent;

public interface IServiceTokenResult {
    String getCUserId();

    String getErrorCodeName();

    String getErrorMessage();

    String getErrorStackTrace();

    Intent getIntent();

    String getPh();

    String getSecurity();

    String getServiceToken();

    String getSid();

    String getSlh();

    String getUserId();

    boolean isPeeked();
}
