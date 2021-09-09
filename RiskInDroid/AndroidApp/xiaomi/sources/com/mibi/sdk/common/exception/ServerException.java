package com.mibi.sdk.common.exception;

import com.xiaomi.smarthome.R;
import java.net.URL;

public class ServerException extends PaymentException {
    private int mResponseCode;
    private URL mUrl;

    public int getErrorCode() {
        return 6;
    }

    public int getErrorSummaryRes() {
        return R.string.mibi_error_server_summary;
    }

    public String getIdentifier() {
        return "SR";
    }

    public ServerException(Throwable th) {
        super(th);
    }

    public ServerException(int i, URL url) {
        super(Integer.toString(i));
        this.mResponseCode = i;
        this.mUrl = url;
    }

    public int getResponseCode() {
        return this.mResponseCode;
    }

    public URL getUrl() {
        return this.mUrl;
    }
}
