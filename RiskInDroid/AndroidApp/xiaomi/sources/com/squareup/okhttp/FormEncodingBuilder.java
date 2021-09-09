package com.squareup.okhttp;

import _m_j.jax;

public final class FormEncodingBuilder {
    private static final MediaType CONTENT_TYPE = MediaType.parse("application/x-www-form-urlencoded");
    private final jax content = new jax();

    public final FormEncodingBuilder add(String str, String str2) {
        if (this.content.O00000Oo > 0) {
            this.content.O0000Oo(38);
        }
        HttpUrl.canonicalize(this.content, str, 0, str.length(), " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, true, true);
        this.content.O0000Oo(61);
        HttpUrl.canonicalize(this.content, str2, 0, str2.length(), " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, true, true);
        return this;
    }

    public final FormEncodingBuilder addEncoded(String str, String str2) {
        if (this.content.O00000Oo > 0) {
            this.content.O0000Oo(38);
        }
        HttpUrl.canonicalize(this.content, str, 0, str.length(), " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, true, true);
        this.content.O0000Oo(61);
        HttpUrl.canonicalize(this.content, str2, 0, str2.length(), " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, true, true);
        return this;
    }

    public final RequestBody build() {
        return RequestBody.create(CONTENT_TYPE, this.content.O0000ooO());
    }
}
