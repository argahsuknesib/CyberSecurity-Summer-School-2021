package com.mobikwik.sdk.lib.utils;

import java.io.IOException;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class Checksum {
    private String checksum;
    private String status;

    public static Checksum parseChecksumResponse(String str) {
        String str2;
        String str3;
        Checksum checksum2;
        Checksum checksum3 = null;
        try {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            newPullParser.setInput(new StringReader(str));
            newPullParser.nextTag();
            newPullParser.require(2, null, null);
            String name = newPullParser.getName();
            if (name.equals("checksum")) {
                str3 = null;
                str2 = null;
                while (newPullParser.nextTag() == 2) {
                    newPullParser.require(2, null, null);
                    String name2 = newPullParser.getName();
                    if (name2.equals("status")) {
                        str3 = newPullParser.nextText().toUpperCase();
                    } else {
                        if (!name2.equals("msg")) {
                            if (!name2.equalsIgnoreCase("checksumValue")) {
                                newPullParser.nextText();
                            }
                        }
                        str2 = newPullParser.nextText();
                    }
                    newPullParser.require(3, null, name2);
                }
                newPullParser.require(3, null, name);
            } else {
                str3 = null;
                str2 = null;
            }
            if (Utils.isNull(str3) || Utils.isNull(str2)) {
                checksum2 = null;
            } else {
                checksum2 = new Checksum();
                try {
                    checksum2.status = str3;
                    checksum2.checksum = str2;
                } catch (XmlPullParserException e) {
                    XmlPullParserException xmlPullParserException = e;
                    checksum3 = checksum2;
                    e = xmlPullParserException;
                } catch (IOException e2) {
                    IOException iOException = e2;
                    checksum3 = checksum2;
                    e = iOException;
                    e.printStackTrace();
                    return checksum3;
                }
            }
            return checksum2;
        } catch (XmlPullParserException e3) {
            e = e3;
            e.printStackTrace();
            return checksum3;
        } catch (IOException e4) {
            e = e4;
            e.printStackTrace();
            return checksum3;
        }
    }

    public String getChecksum() {
        return this.checksum;
    }

    public String getStatus() {
        return this.status;
    }
}
