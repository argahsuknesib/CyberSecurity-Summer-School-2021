package com.xiaomi.accountsdk.request;

import com.xiaomi.accountsdk.request.SimpleRequest;
import java.io.IOException;

public abstract class PassportSimpleRequest extends PassportRequest {
    protected final PassportRequestArguments arguments;

    public abstract String getMethod();

    protected PassportSimpleRequest(PassportRequestArguments passportRequestArguments) {
        if (passportRequestArguments != null) {
            this.arguments = passportRequestArguments;
            return;
        }
        throw new IllegalArgumentException("arguments can't be null");
    }

    public PassportSimpleRequest copy() {
        PassportRequestArguments copy = this.arguments.copy();
        if (this instanceof GetAsString) {
            return new GetAsString(copy);
        }
        if (this instanceof PostAsString) {
            return new PostAsString(copy);
        }
        throw new IllegalStateException("");
    }

    public boolean isHTTPS() {
        return this.arguments.url != null && this.arguments.url.toLowerCase().startsWith("https");
    }

    public static class GetAsString extends PassportSimpleRequest {
        public String getMethod() {
            return "GET";
        }

        public GetAsString(PassportRequestArguments passportRequestArguments) {
            super(passportRequestArguments);
        }

        public SimpleRequest.StringContent execute() throws IOException, PassportRequestException {
            try {
                return SimpleRequestForAccount.getAsString(this.arguments.url, this.arguments.params, this.arguments.headers, this.arguments.cookies, this.arguments.readBody, this.arguments.timeoutMillis);
            } catch (AccessDeniedException e) {
                throw new PassportRequestException(e);
            } catch (AuthenticationFailureException e2) {
                throw new PassportRequestException(e2);
            }
        }
    }

    public static class PostAsString extends PassportSimpleRequest {
        public String getMethod() {
            return "POST";
        }

        public PostAsString(PassportRequestArguments passportRequestArguments) {
            super(passportRequestArguments);
        }

        public SimpleRequest.StringContent execute() throws IOException, PassportRequestException {
            try {
                return SimpleRequestForAccount.postAsString(this.arguments.url, this.arguments.params, this.arguments.cookies, this.arguments.headers, this.arguments.urlParams, this.arguments.readBody, this.arguments.timeoutMillis);
            } catch (AccessDeniedException e) {
                throw new PassportRequestException(e);
            } catch (AuthenticationFailureException e2) {
                throw new PassportRequestException(e2);
            }
        }
    }
}
