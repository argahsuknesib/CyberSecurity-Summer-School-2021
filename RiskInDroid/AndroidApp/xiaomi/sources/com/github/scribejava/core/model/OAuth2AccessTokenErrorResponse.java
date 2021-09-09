package com.github.scribejava.core.model;

import com.github.scribejava.core.exceptions.OAuthException;
import java.net.URI;

public class OAuth2AccessTokenErrorResponse extends OAuthException {
    private static final long serialVersionUID = 2309424849700276816L;
    private final ErrorCode errorCode;
    private final String errorDescription;
    private final URI errorUri;
    private final String rawResponse;

    public enum ErrorCode {
        invalid_request,
        invalid_client,
        invalid_grant,
        unauthorized_client,
        unsupported_grant_type,
        invalid_scope
    }

    public OAuth2AccessTokenErrorResponse(ErrorCode errorCode2, String str, URI uri, String str2) {
        super(str2);
        if (errorCode2 != null) {
            this.errorCode = errorCode2;
            this.errorDescription = str;
            this.errorUri = uri;
            this.rawResponse = str2;
            return;
        }
        throw new IllegalArgumentException("errorCode must not be null");
    }

    public ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public String getErrorDescription() {
        return this.errorDescription;
    }

    public URI getErrorUri() {
        return this.errorUri;
    }

    public String getRawResponse() {
        return this.rawResponse;
    }
}
