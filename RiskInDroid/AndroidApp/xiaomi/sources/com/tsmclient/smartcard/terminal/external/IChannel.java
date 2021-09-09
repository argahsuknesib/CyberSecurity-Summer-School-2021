package com.tsmclient.smartcard.terminal.external;

import java.io.IOException;

public interface IChannel {
    void close() throws IOException, InterruptedException;

    void open() throws IOException, InterruptedException;

    byte[] transceive(byte[] bArr) throws IOException, InterruptedException;
}
