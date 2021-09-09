package com.mobikwik.sdk.lib.payinstrument;

import com.mobikwik.sdk.lib.utils.CardUtils;
import com.mobikwik.sdk.lib.utils.RSAEncUtils;
import com.mobikwik.sdk.lib.utils.Utils;
import java.io.Serializable;
import java.util.Calendar;

public class Card implements PaymentInstrument, Serializable {
    public String cardCvv;
    public String cardExpiryMonth;
    public String cardExpiryYear;
    public String cardHoldersName;
    public String cardNumber;
    String cardValidityError;
    public boolean saveCard;
    public String savedCardId;

    public static class Builder {
        private String cardCvv;
        private String cardExpiryMonth;
        private String cardExpiryYear;
        private String cardHoldersName;
        private String cardId;
        private String cardNumber;
        private boolean saveCard;

        public Card build() {
            Card card = new Card();
            card.cardNumber = this.cardNumber;
            card.savedCardId = this.cardId;
            String str = this.cardExpiryYear;
            if (str == null) {
                str = "";
            }
            card.cardExpiryYear = str;
            String str2 = this.cardExpiryMonth;
            if (str2 == null) {
                str2 = "";
            }
            card.cardExpiryMonth = str2;
            String str3 = this.cardCvv;
            if (str3 == null) {
                str3 = "";
            }
            card.cardCvv = str3;
            card.cardHoldersName = this.cardHoldersName;
            if (!card.isSavedCard() && this.cardNumber != null) {
                card.saveCard = this.saveCard;
            }
            return card;
        }

        public Builder setCardCVV(String str) {
            this.cardCvv = str;
            return this;
        }

        public Builder setCardExpMonth(String str) {
            this.cardExpiryMonth = str;
            return this;
        }

        public Builder setCardExpYear(String str) {
            this.cardExpiryYear = str;
            return this;
        }

        public Builder setCardFamily(int i) {
            return this;
        }

        public Builder setCardId(String str) {
            this.cardId = str;
            return this;
        }

        public Builder setCardNumber(String str) {
            this.cardNumber = str;
            return this;
        }

        public Builder setNameOnCard(String str) {
            this.cardHoldersName = str;
            return this;
        }

        public Builder setStoreThisCard(boolean z) {
            this.saveCard = z;
            return this;
        }
    }

    private Card() {
    }

    public Card encrypt(RSAEncUtils rSAEncUtils) {
        Card card = new Card();
        String str = this.savedCardId;
        if (str != null) {
            card.savedCardId = str;
        } else {
            card.cardNumber = rSAEncUtils.encrypt(this.cardNumber);
            card.cardExpiryMonth = rSAEncUtils.encrypt(this.cardExpiryMonth);
            card.cardExpiryYear = rSAEncUtils.encrypt(this.cardExpiryYear);
        }
        card.cardCvv = rSAEncUtils.encrypt(this.cardCvv);
        card.cardHoldersName = this.cardHoldersName;
        card.saveCard = this.saveCard;
        return card;
    }

    public String getCardCVV() {
        return this.cardCvv;
    }

    public String getCardExpMonth() {
        return this.cardExpiryMonth;
    }

    public String getCardExpYear() {
        return this.cardExpiryYear;
    }

    public String getCardId() {
        return this.savedCardId;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public String getNameOnCard() {
        return this.cardHoldersName;
    }

    public boolean isSavedCard() {
        return this.savedCardId != null;
    }

    public boolean isToStoreThisCard() {
        return this.saveCard;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a1, code lost:
        if (r7.cardCvv.length() == 3) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a9, code lost:
        if (r7.cardCvv.length() == 4) goto L_0x00ab;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00b2  */
    public boolean isValid() {
        String str;
        boolean z;
        String str2;
        boolean z2;
        if (isSavedCard()) {
            str = null;
            Utils.print("Card.isValid : cardType ".concat(String.valueOf(str)));
            boolean equalsIgnoreCase = "maestro".equalsIgnoreCase(str);
            if (!isSavedCard()) {
            }
            z = true;
            if (!z) {
            }
        } else if (this.cardNumber.length() < 13 || this.cardNumber.length() > 19 || !CardUtils.validateCardNumber(this.cardNumber)) {
            str2 = "Invalid card number";
        } else {
            str = CardUtils.detectType(this.cardNumber);
            Utils.print("Card.isValid : cardType ".concat(String.valueOf(str)));
            boolean equalsIgnoreCase2 = "maestro".equalsIgnoreCase(str);
            if (!isSavedCard()) {
                z = !Utils.isNull(this.cardCvv) && Utils.isNumeric(this.cardCvv) && (this.cardCvv.length() == 3 || this.cardCvv.length() == 4);
                if (Utils.isNull(this.cardCvv)) {
                    this.cardCvv = "";
                }
                if (!z) {
                    str2 = "Invalid card cvv";
                } else {
                    if (!isSavedCard() && (!Utils.isNull(this.cardExpiryYear) || !Utils.isNull(this.cardExpiryMonth) || !equalsIgnoreCase2)) {
                        if (Utils.isNull(this.cardExpiryYear) || Utils.isNull(this.cardExpiryMonth)) {
                            str2 = "Invalid card Expiry";
                        } else {
                            int parseInt = (Integer.parseInt(this.cardExpiryYear) - (Calendar.getInstance().get(1) - 2000)) + 1;
                            if (parseInt <= 0 || parseInt > 30) {
                                str2 = "Invalid card Expiry Year";
                            } else {
                                int parseInt2 = Integer.parseInt(this.cardExpiryMonth);
                                if (parseInt2 <= 0 || parseInt2 > 12) {
                                    this.cardValidityError = "Invalid card Expiry Month";
                                    return false;
                                }
                                int i = Calendar.getInstance().get(2) + 1;
                                if (parseInt == 1 && parseInt2 < i) {
                                    this.cardValidityError = "Invalid card Expiry Month";
                                    return false;
                                }
                            }
                        }
                    }
                    return true;
                }
            } else {
                if (!Utils.isNull(this.cardCvv) || !equalsIgnoreCase2) {
                    z2 = false;
                } else {
                    this.cardCvv = "";
                    z2 = true;
                }
                if (!Utils.isNull(this.cardCvv)) {
                    if (Utils.isNumeric(this.cardCvv)) {
                    }
                }
            }
            z = true;
            if (!z) {
            }
        }
        this.cardValidityError = str2;
        return false;
    }
}
