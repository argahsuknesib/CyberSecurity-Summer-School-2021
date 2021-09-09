package com.tsmclient.smartcard.terminal;

import com.tsmclient.smartcard.ByteArray;
import com.tsmclient.smartcard.terminal.response.ScResponse;
import java.io.IOException;
import java.util.Map;

public interface IScTerminal {
    boolean activateCard(String str);

    void checkNfcEEStatus() throws IOException, InterruptedException;

    void close();

    boolean deactivateCard(String str);

    String getCIN() throws IOException, InterruptedException;

    String getCPLC() throws IOException, InterruptedException;

    Map<String, ByteArray> getCardActivationState(String str) throws InterruptedException;

    void getSEInfo() throws IOException, InterruptedException;

    String getSeid() throws IOException, InterruptedException;

    String getSignedSpiPK() throws IOException, InterruptedException;

    String getTerminalCategory();

    TerminalType getTerminalType();

    boolean isAppletExist(String str) throws IOException, InterruptedException;

    boolean isInterruptible();

    void open() throws IOException, InterruptedException;

    void setInterruptible(boolean z);

    ScResponse transmit(byte[] bArr) throws IOException, InterruptedException;
}
