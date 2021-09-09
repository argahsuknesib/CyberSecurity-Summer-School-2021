package com.tsmclient.smartcard.handler;

import android.nfc.tech.TagTechnology;
import android.os.Bundle;
import com.tsmclient.smartcard.ByteArray;
import com.tsmclient.smartcard.exception.UnProcessableCardException;
import com.tsmclient.smartcard.terminal.IScTerminal;
import java.io.IOException;

public interface ISmartCardHandler<T extends TagTechnology> {
    public static final ByteArray AID_PPSE = ByteArray.wrap(new byte[]{50, 80, 65, 89, 46, 83, 89, 83, 46, 68, 68, 70, 48, 49});
    public static final ByteArray AID_PSE = ByteArray.wrap(new byte[]{49, 80, 65, 89, 46, 83, 89, 83, 46, 68, 68, 70, 48, 49});
    public static final ByteArray EMPTY_RECORD = ByteArray.wrap(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    public static final ByteArray EMPTY_RECORD_TWO = ByteArray.wrap(new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1});
    public static final ByteArray GET_BALANCE_CMD = ByteArray.wrap(new byte[]{Byte.MIN_VALUE, 92, 0, 2, 4});
    public static final ByteArray STATUS_APP_NOT_FOUND = ByteArray.wrap(new byte[]{106, -126});
    public static final ByteArray STATUS_ERROR_PARAM = ByteArray.wrap(new byte[]{106, -122});
    public static final ByteArray STATUS_OK = ByteArray.wrap(new byte[]{-112, 0});
    public static final ByteArray STATUS_RECORD_END = ByteArray.wrap(new byte[]{106, -125});

    int getTechType();

    Bundle onHandleCard(TagTechnology tagTechnology) throws IOException, UnProcessableCardException;

    Bundle onHandleCard(IScTerminal iScTerminal, Bundle bundle) throws IOException, UnProcessableCardException;
}
