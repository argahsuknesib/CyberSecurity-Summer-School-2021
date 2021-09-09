package com.mi.global.shop.newmodel.virtualview;

import _m_j.jax;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;

public class VirtualViewModel {
    public VersionInfo version_info = new VersionInfo();

    public static VirtualViewModel decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static VirtualViewModel decode(ProtoReader protoReader) throws IOException {
        VirtualViewModel virtualViewModel = new VirtualViewModel();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessage(beginMessage);
                return virtualViewModel;
            } else if (nextTag != 1) {
                protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
            } else {
                virtualViewModel.version_info = VersionInfo.decode(protoReader);
            }
        }
    }

    public static class VersionInfo {
        @SerializedName("md5")
        public String md5;
        @SerializedName("notes")
        public String notes;
        @SerializedName("url")
        public String url;
        @SerializedName("version")
        public String version;

        public static VersionInfo decode(byte[] bArr) throws IOException {
            return decode(new ProtoReader(new jax().O00000o0(bArr)));
        }

        public static VersionInfo decode(ProtoReader protoReader) throws IOException {
            VersionInfo versionInfo = new VersionInfo();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return versionInfo;
                } else if (nextTag == 1) {
                    versionInfo.version = ProtoAdapter.STRING.decode(protoReader);
                } else if (nextTag == 2) {
                    versionInfo.url = ProtoAdapter.STRING.decode(protoReader);
                } else if (nextTag == 3) {
                    versionInfo.notes = ProtoAdapter.STRING.decode(protoReader);
                } else if (nextTag != 4) {
                    protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                } else {
                    versionInfo.md5 = ProtoAdapter.STRING.decode(protoReader);
                }
            }
        }
    }
}
