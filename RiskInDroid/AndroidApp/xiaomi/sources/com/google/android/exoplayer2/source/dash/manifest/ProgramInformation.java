package com.google.android.exoplayer2.source.dash.manifest;

import com.google.android.exoplayer2.util.Util;

public class ProgramInformation {
    public final String copyright;
    public final String lang;
    public final String moreInformationURL;
    public final String source;
    public final String title;

    public ProgramInformation(String str, String str2, String str3, String str4, String str5) {
        this.title = str;
        this.source = str2;
        this.copyright = str3;
        this.moreInformationURL = str4;
        this.lang = str5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ProgramInformation programInformation = (ProgramInformation) obj;
            return Util.areEqual(this.title, programInformation.title) && Util.areEqual(this.source, programInformation.source) && Util.areEqual(this.copyright, programInformation.copyright) && Util.areEqual(this.moreInformationURL, programInformation.moreInformationURL) && Util.areEqual(this.lang, programInformation.lang);
        }
    }

    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
        String str2 = this.source;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.copyright;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.moreInformationURL;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.lang;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return hashCode4 + i;
    }
}
