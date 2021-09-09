package com.mi.global.shop.model.app;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

public final class UserProfile extends Message<UserProfile, Builder> {
    public static final ProtoAdapter<UserProfile> ADAPTER = new ProtoAdapter_UserProfile();
    public static final Long DEFAULT_USERID = 0L;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String icon;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String nickname;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 1)
    public final Long userId;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String userName;

    public UserProfile(Long l, String str, String str2, String str3) {
        this(l, str, str2, str3, ByteString.O00000Oo);
    }

    public UserProfile(Long l, String str, String str2, String str3, ByteString byteString) {
        super(ADAPTER, byteString);
        this.userId = l;
        this.userName = str;
        this.nickname = str2;
        this.icon = str3;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.userId = this.userId;
        builder.userName = this.userName;
        builder.nickname = this.nickname;
        builder.icon = this.icon;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserProfile)) {
            return false;
        }
        UserProfile userProfile = (UserProfile) obj;
        return Internal.equals(unknownFields(), userProfile.unknownFields()) && Internal.equals(this.userId, userProfile.userId) && Internal.equals(this.userName, userProfile.userName) && Internal.equals(this.nickname, userProfile.nickname) && Internal.equals(this.icon, userProfile.icon);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Long l = this.userId;
        int i2 = 0;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        String str = this.userName;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.nickname;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.icon;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.userId != null) {
            sb.append(", userId=");
            sb.append(this.userId);
        }
        if (this.userName != null) {
            sb.append(", userName=");
            sb.append(this.userName);
        }
        if (this.nickname != null) {
            sb.append(", nickname=");
            sb.append(this.nickname);
        }
        if (this.icon != null) {
            sb.append(", icon=");
            sb.append(this.icon);
        }
        StringBuilder replace = sb.replace(0, 2, "UserProfile{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<UserProfile, Builder> {
        public String icon;
        public String nickname;
        public Long userId;
        public String userName;

        public final Builder userId(Long l) {
            this.userId = l;
            return this;
        }

        public final Builder userName(String str) {
            this.userName = str;
            return this;
        }

        public final Builder nickname(String str) {
            this.nickname = str;
            return this;
        }

        public final Builder icon(String str) {
            this.icon = str;
            return this;
        }

        public final UserProfile build() {
            return new UserProfile(this.userId, this.userName, this.nickname, this.icon, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_UserProfile extends ProtoAdapter<UserProfile> {
        ProtoAdapter_UserProfile() {
            super(FieldEncoding.LENGTH_DELIMITED, UserProfile.class);
        }

        public final int encodedSize(UserProfile userProfile) {
            int i = 0;
            int encodedSizeWithTag = (userProfile.userId != null ? ProtoAdapter.INT64.encodedSizeWithTag(1, userProfile.userId) : 0) + (userProfile.userName != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, userProfile.userName) : 0) + (userProfile.nickname != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, userProfile.nickname) : 0);
            if (userProfile.icon != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(4, userProfile.icon);
            }
            return encodedSizeWithTag + i + userProfile.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, UserProfile userProfile) throws IOException {
            if (userProfile.userId != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 1, userProfile.userId);
            }
            if (userProfile.userName != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, userProfile.userName);
            }
            if (userProfile.nickname != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, userProfile.nickname);
            }
            if (userProfile.icon != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, userProfile.icon);
            }
            protoWriter.writeBytes(userProfile.unknownFields());
        }

        public final UserProfile decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.userId(ProtoAdapter.INT64.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.userName(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.nickname(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 4) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.icon(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public final UserProfile redact(UserProfile userProfile) {
            Builder newBuilder = userProfile.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
