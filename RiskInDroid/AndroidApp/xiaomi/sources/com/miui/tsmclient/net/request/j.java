package com.miui.tsmclient.net.request;

import com.miui.tsmclient.common.data.CommonResponseInfo;
import com.miui.tsmclient.common.net.request.SecureRequest;
import com.miui.tsmclient.entity.MifareCardInfo;
import com.miui.tsmclient.entity.c;
import java.io.IOException;

public class j extends SecureRequest<CommonResponseInfo> {

    /* renamed from: a  reason: collision with root package name */
    private MifareCardInfo f3894a;

    public j(MifareCardInfo mifareCardInfo, c.a aVar) {
        super(0, "api/%s/doorCardV2/updateArt", CommonResponseInfo.class);
        this.f3894a = mifareCardInfo;
        addParams("vcmAid", this.f3894a.mAid);
        if (aVar != null) {
            addParams("artId", String.valueOf(aVar.a()));
        }
    }

    public void addExtraParams() throws IOException {
        try {
            addParams("cplc", this.f3894a.getTerminal().getCPLC());
        } catch (IOException | InterruptedException e) {
            throw new IOException("UpdateDoorCardArtRequest getExtraParams failed", e);
        }
    }
}
