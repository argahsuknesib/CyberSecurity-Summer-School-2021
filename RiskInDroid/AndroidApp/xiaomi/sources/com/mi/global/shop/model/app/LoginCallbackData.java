package com.mi.global.shop.model.app;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

public final class LoginCallbackData extends Message<LoginCallbackData, Builder> {
    public static final ProtoAdapter<LoginCallbackData> ADAPTER = new ProtoAdapter_LoginCallbackData();
    public static final Integer DEFAULT_CART = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer cart;
    @WireField(adapter = "com.mi.global.shop.model.app.CookieInfo#ADAPTER", label = WireField.Label.REPEATED, tag = 3)
    public final List<CookieInfo> cookies;
    @WireField(adapter = "com.mi.global.shop.model.app.UserProfile#ADAPTER", tag = 1)
    public final UserProfile profile;

    public LoginCallbackData(UserProfile userProfile, Integer num, List<CookieInfo> list) {
        this(userProfile, num, list, ByteString.O00000Oo);
    }

    public LoginCallbackData(UserProfile userProfile, Integer num, List<CookieInfo> list, ByteString byteString) {
        super(ADAPTER, byteString);
        this.profile = userProfile;
        this.cart = num;
        this.cookies = Internal.immutableCopyOf("cookies", list);
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.profile = this.profile;
        builder.cart = this.cart;
        builder.cookies = Internal.copyOf("cookies", this.cookies);
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LoginCallbackData)) {
            return false;
        }
        LoginCallbackData loginCallbackData = (LoginCallbackData) obj;
        return Internal.equals(unknownFields(), loginCallbackData.unknownFields()) && Internal.equals(this.profile, loginCallbackData.profile) && Internal.equals(this.cart, loginCallbackData.cart) && Internal.equals(this.cookies, loginCallbackData.cookies);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        UserProfile userProfile = this.profile;
        int i2 = 0;
        int hashCode2 = (hashCode + (userProfile != null ? userProfile.hashCode() : 0)) * 37;
        Integer num = this.cart;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = (hashCode2 + i2) * 37;
        List<CookieInfo> list = this.cookies;
        int hashCode3 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode3;
        return hashCode3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.profile != null) {
            sb.append(", profile=");
            sb.append(this.profile);
        }
        if (this.cart != null) {
            sb.append(", cart=");
            sb.append(this.cart);
        }
        if (this.cookies != null) {
            sb.append(", cookies=");
            sb.append(this.cookies);
        }
        StringBuilder replace = sb.replace(0, 2, "LoginCallbackData{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<LoginCallbackData, Builder> {
        public Integer cart;
        public List<CookieInfo> cookies = Internal.newMutableList();
        public UserProfile profile;

        public final Builder profile(UserProfile userProfile) {
            this.profile = userProfile;
            return this;
        }

        public final Builder cart(Integer num) {
            this.cart = num;
            return this;
        }

        public final Builder cookies(List<CookieInfo> list) {
            Internal.checkElementsNotNull(list);
            this.cookies = list;
            return this;
        }

        public final LoginCallbackData build() {
            return new LoginCallbackData(this.profile, this.cart, this.cookies, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_LoginCallbackData extends ProtoAdapter<LoginCallbackData> {
        ProtoAdapter_LoginCallbackData() {
            super(FieldEncoding.LENGTH_DELIMITED, LoginCallbackData.class);
        }

        public final int encodedSize(LoginCallbackData loginCallbackData) {
            int i = 0;
            int encodedSizeWithTag = loginCallbackData.profile != null ? UserProfile.ADAPTER.encodedSizeWithTag(1, loginCallbackData.profile) : 0;
            if (loginCallbackData.cart != null) {
                i = ProtoAdapter.INT32.encodedSizeWithTag(2, loginCallbackData.cart);
            }
            return encodedSizeWithTag + i + CookieInfo.ADAPTER.asRepeated().encodedSizeWithTag(3, loginCallbackData.cookies) + loginCallbackData.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, LoginCallbackData loginCallbackData) throws IOException {
            if (loginCallbackData.profile != null) {
                UserProfile.ADAPTER.encodeWithTag(protoWriter, 1, loginCallbackData.profile);
            }
            if (loginCallbackData.cart != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 2, loginCallbackData.cart);
            }
            if (loginCallbackData.cookies != null) {
                CookieInfo.ADAPTER.asRepeated().encodeWithTag(protoWriter, 3, loginCallbackData.cookies);
            }
            protoWriter.writeBytes(loginCallbackData.unknownFields());
        }

        public final LoginCallbackData decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.profile(UserProfile.ADAPTER.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.cart(ProtoAdapter.INT32.decode(protoReader));
                } else if (nextTag != 3) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.cookies.add(CookieInfo.ADAPTER.decode(protoReader));
                }
            }
        }

        public final LoginCallbackData redact(LoginCallbackData loginCallbackData) {
            Builder newBuilder = loginCallbackData.newBuilder();
            if (newBuilder.profile != null) {
                newBuilder.profile = UserProfile.ADAPTER.redact(newBuilder.profile);
            }
            Internal.redactElements(newBuilder.cookies, CookieInfo.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
