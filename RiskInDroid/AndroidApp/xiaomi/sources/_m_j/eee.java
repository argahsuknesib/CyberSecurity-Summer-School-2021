package _m_j;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.xiaomi.mobilestats.data.ProtoMsg$StatsMsg;

public final class eee extends AbstractParser {
    public final /* synthetic */ Object parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return new ProtoMsg$StatsMsg.EventMsg(codedInputStream, extensionRegistryLite, (byte) 0);
    }
}
