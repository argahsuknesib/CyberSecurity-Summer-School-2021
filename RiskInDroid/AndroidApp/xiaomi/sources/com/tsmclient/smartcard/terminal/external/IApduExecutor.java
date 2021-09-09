package com.tsmclient.smartcard.terminal.external;

import java.io.IOException;

public interface IApduExecutor {
    ResponseList execute(IChannel iChannel, CommandList commandList) throws IOException, InterruptedException;
}
