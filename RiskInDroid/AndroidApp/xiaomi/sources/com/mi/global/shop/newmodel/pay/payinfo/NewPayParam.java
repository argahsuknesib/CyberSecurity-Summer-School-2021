package com.mi.global.shop.newmodel.pay.payinfo;

import _m_j.jax;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;
import java.util.ArrayList;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public class NewPayParam {
    @SerializedName("amount")
    public String amount;
    @SerializedName("email")
    public String email;
    @SerializedName("enforce_paymethod")
    public String enforce_paymethod;
    @SerializedName("firstname")
    public String firstname;
    @SerializedName("furl")
    public String furl;
    @SerializedName("hash")
    public String hash;
    @SerializedName("key")
    public String key;
    @SerializedName("pay_url")
    public String pay_url;
    @SerializedName("phone")
    public String phone;
    @SerializedName("productinfo")
    public String productinfo;
    @SerializedName("sign")
    public String sign;
    @SerializedName("supportStoreCards")
    public boolean supportStoreCards;
    @SerializedName("surl")
    public String surl;
    @SerializedName("txnid")
    public String txnid;
    @SerializedName("user_cards")
    public ArrayList<NewUserCardsType> user_cards = new ArrayList<>();
    @SerializedName("user_credentials")
    public String user_credentials;

    public static NewPayParam decode(byte[] bArr) throws IOException {
        return decode(new ProtoReader(new jax().O00000o0(bArr)));
    }

    public static NewPayParam decode(ProtoReader protoReader) throws IOException {
        NewPayParam newPayParam = new NewPayParam();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag != -1) {
                switch (nextTag) {
                    case 1:
                        newPayParam.key = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 2:
                        newPayParam.txnid = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 3:
                        newPayParam.amount = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 4:
                        newPayParam.productinfo = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 5:
                        newPayParam.firstname = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 6:
                        newPayParam.email = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 7:
                        newPayParam.phone = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        newPayParam.surl = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 9:
                        newPayParam.furl = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 10:
                        newPayParam.enforce_paymethod = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 11:
                        newPayParam.user_credentials = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        newPayParam.pay_url = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 13:
                        newPayParam.hash = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 14:
                        newPayParam.user_cards.add(NewUserCardsType.decode(protoReader));
                        break;
                    case GmsLogger.MAX_PII_TAG_LENGTH:
                        newPayParam.sign = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 16:
                        newPayParam.supportStoreCards = ProtoAdapter.BOOL.decode(protoReader).booleanValue();
                        break;
                    default:
                        protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                        break;
                }
            } else {
                protoReader.endMessage(beginMessage);
                return newPayParam;
            }
        }
    }
}
