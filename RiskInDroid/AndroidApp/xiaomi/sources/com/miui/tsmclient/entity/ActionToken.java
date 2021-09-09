package com.miui.tsmclient.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;
import java.lang.reflect.Type;
import org.json.JSONObject;

public class ActionToken implements Parcelable, ObjectParser<ActionToken> {
    public static final Parcelable.Creator<ActionToken> CREATOR = new Parcelable.Creator<ActionToken>() {
        /* class com.miui.tsmclient.entity.ActionToken.AnonymousClass1 */

        public final ActionToken createFromParcel(Parcel parcel) {
            return new ActionToken(parcel);
        }

        public final ActionToken[] newArray(int i) {
            return new ActionToken[i];
        }
    };
    @SerializedName("rechargeAmount")
    public int mRechargeAmount;
    @SerializedName("token")
    public String mToken;
    @SerializedName("type")
    public TokenType mType;

    public int describeContents() {
        return 0;
    }

    public enum TokenType {
        unknown(0),
        issue(1),
        recharge(2),
        withdraw(3),
        issueAndRecharge(12);
        
        private int mId;

        private TokenType(int i) {
            this.mId = i;
        }

        public final int getId() {
            return this.mId;
        }

        public static TokenType newInstance(int i) {
            for (TokenType tokenType : values()) {
                if (tokenType.mId == i) {
                    return tokenType;
                }
            }
            return unknown;
        }
    }

    public static class TokenTypeDeserializer implements JsonDeserializer<TokenType> {
        public TokenType deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            return TokenType.newInstance(jsonElement.getAsInt());
        }
    }

    private ActionToken(Parcel parcel) {
        readFromParcel(parcel);
    }

    public ActionToken() {
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mToken);
        parcel.writeValue(this.mType);
        parcel.writeInt(this.mRechargeAmount);
    }

    public void readFromParcel(Parcel parcel) {
        this.mToken = parcel.readString();
        this.mType = (TokenType) parcel.readValue(TokenType.class.getClassLoader());
        this.mRechargeAmount = parcel.readInt();
    }

    public ActionToken parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mToken = jSONObject.optString("token");
            this.mType = TokenType.newInstance(jSONObject.optInt("type"));
            this.mRechargeAmount = jSONObject.optInt("rechargeAmount");
        }
        return this;
    }

    public boolean shouldAutoIssueOrWithdraw() {
        if (!isIssueType()) {
            return this.mType == TokenType.withdraw && !TextUtils.isEmpty(this.mToken);
        }
        return true;
    }

    public boolean isRechargeType() {
        return this.mType == TokenType.recharge;
    }

    public boolean isWithdrawType() {
        return this.mType == TokenType.withdraw;
    }

    public boolean isIssueType() {
        return this.mType == TokenType.issue || this.mType == TokenType.issueAndRecharge;
    }

    public boolean canShiftIn() {
        return isWithdrawType() && !TextUtils.isEmpty(this.mToken);
    }
}
