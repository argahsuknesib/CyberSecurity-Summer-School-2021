package _m_j;

import com.adobe.xmp.XMPException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public final class ni implements mq {

    /* renamed from: O000000o  reason: collision with root package name */
    private Map f2202O000000o = new HashMap();
    private Map O00000Oo = new HashMap();
    private Pattern O00000o = Pattern.compile("[/*?\\[\\]]");
    private Map O00000o0 = new HashMap();

    public final synchronized String O000000o(String str) {
        return (String) this.f2202O000000o.get(str);
    }

    public final synchronized String O00000Oo(String str) {
        if (str != null) {
            if (!str.endsWith(":")) {
                str = str + ":";
            }
        }
        return (String) this.O00000Oo.get(str);
    }

    public final synchronized ns O00000o0(String str) {
        return (ns) this.O00000o0.get(str);
    }

    public ni() {
        try {
            O000000o("http://www.w3.org/XML/1998/namespace", "xml");
            O000000o("http://www.w3.org/1999/02/22-rdf-syntax-ns#", "rdf");
            O000000o("http://purl.org/dc/elements/1.1/", "dc");
            O000000o("http://iptc.org/std/Iptc4xmpCore/1.0/xmlns/", "Iptc4xmpCore");
            O000000o("http://iptc.org/std/Iptc4xmpExt/2008-02-29/", "Iptc4xmpExt");
            O000000o("http://ns.adobe.com/DICOM/", "DICOM");
            O000000o("http://ns.useplus.org/ldf/xmp/1.0/", "plus");
            O000000o("adobe:ns:meta/", "x");
            O000000o("http://ns.adobe.com/iX/1.0/", "iX");
            O000000o("http://ns.adobe.com/xap/1.0/", "xmp");
            O000000o("http://ns.adobe.com/xap/1.0/rights/", "xmpRights");
            O000000o("http://ns.adobe.com/xap/1.0/mm/", "xmpMM");
            O000000o("http://ns.adobe.com/xap/1.0/bj/", "xmpBJ");
            O000000o("http://ns.adobe.com/xmp/note/", "xmpNote");
            O000000o("http://ns.adobe.com/pdf/1.3/", "pdf");
            O000000o("http://ns.adobe.com/pdfx/1.3/", "pdfx");
            O000000o("http://www.npes.org/pdfx/ns/id/", "pdfxid");
            O000000o("http://www.aiim.org/pdfa/ns/schema#", "pdfaSchema");
            O000000o("http://www.aiim.org/pdfa/ns/property#", "pdfaProperty");
            O000000o("http://www.aiim.org/pdfa/ns/type#", "pdfaType");
            O000000o("http://www.aiim.org/pdfa/ns/field#", "pdfaField");
            O000000o("http://www.aiim.org/pdfa/ns/id/", "pdfaid");
            O000000o("http://www.aiim.org/pdfa/ns/extension/", "pdfaExtension");
            O000000o("http://ns.adobe.com/photoshop/1.0/", "photoshop");
            O000000o("http://ns.adobe.com/album/1.0/", "album");
            O000000o("http://ns.adobe.com/exif/1.0/", "exif");
            O000000o("http://cipa.jp/exif/1.0/", "exifEX");
            O000000o("http://ns.adobe.com/exif/1.0/aux/", "aux");
            O000000o("http://ns.adobe.com/tiff/1.0/", "tiff");
            O000000o("http://ns.adobe.com/png/1.0/", "png");
            O000000o("http://ns.adobe.com/jpeg/1.0/", "jpeg");
            O000000o("http://ns.adobe.com/jp2k/1.0/", "jp2k");
            O000000o("http://ns.adobe.com/camera-raw-settings/1.0/", "crs");
            O000000o("http://ns.adobe.com/StockPhoto/1.0/", "bmsp");
            O000000o("http://ns.adobe.com/creatorAtom/1.0/", "creatorAtom");
            O000000o("http://ns.adobe.com/asf/1.0/", "asf");
            O000000o("http://ns.adobe.com/xmp/wav/1.0/", "wav");
            O000000o("http://ns.adobe.com/bwf/bext/1.0/", "bext");
            O000000o("http://ns.adobe.com/riff/info/", "riffinfo");
            O000000o("http://ns.adobe.com/xmp/1.0/Script/", "xmpScript");
            O000000o("http://ns.adobe.com/TransformXMP/", "txmp");
            O000000o("http://ns.adobe.com/swf/1.0/", "swf");
            O000000o("http://ns.adobe.com/xmp/1.0/DynamicMedia/", "xmpDM");
            O000000o("http://ns.adobe.com/xmp/transient/1.0/", "xmpx");
            O000000o("http://ns.adobe.com/xap/1.0/t/", "xmpT");
            O000000o("http://ns.adobe.com/xap/1.0/t/pg/", "xmpTPg");
            O000000o("http://ns.adobe.com/xap/1.0/g/", "xmpG");
            O000000o("http://ns.adobe.com/xap/1.0/g/img/", "xmpGImg");
            O000000o("http://ns.adobe.com/xap/1.0/sType/Font#", "stFnt");
            O000000o("http://ns.adobe.com/xap/1.0/sType/Dimensions#", "stDim");
            O000000o("http://ns.adobe.com/xap/1.0/sType/ResourceEvent#", "stEvt");
            O000000o("http://ns.adobe.com/xap/1.0/sType/ResourceRef#", "stRef");
            O000000o("http://ns.adobe.com/xap/1.0/sType/Version#", "stVer");
            O000000o("http://ns.adobe.com/xap/1.0/sType/Job#", "stJob");
            O000000o("http://ns.adobe.com/xap/1.0/sType/ManifestItem#", "stMfs");
            O000000o("http://ns.adobe.com/xmp/Identifier/qual/1.0/", "xmpidq");
            nn nnVar = new nn();
            nnVar.O000000o(1536, true);
            nn nnVar2 = new nn();
            nnVar2.O000000o(7680, true);
            O000000o("http://ns.adobe.com/xap/1.0/", "Author", "http://purl.org/dc/elements/1.1/", "creator", nnVar);
            O000000o("http://ns.adobe.com/xap/1.0/", "Authors", "http://purl.org/dc/elements/1.1/", "creator", null);
            O000000o("http://ns.adobe.com/xap/1.0/", "Description", "http://purl.org/dc/elements/1.1/", "description", null);
            O000000o("http://ns.adobe.com/xap/1.0/", "Format", "http://purl.org/dc/elements/1.1/", "format", null);
            O000000o("http://ns.adobe.com/xap/1.0/", "Keywords", "http://purl.org/dc/elements/1.1/", "subject", null);
            O000000o("http://ns.adobe.com/xap/1.0/", "Locale", "http://purl.org/dc/elements/1.1/", "language", null);
            O000000o("http://ns.adobe.com/xap/1.0/", "Title", "http://purl.org/dc/elements/1.1/", "title", null);
            O000000o("http://ns.adobe.com/xap/1.0/rights/", "Copyright", "http://purl.org/dc/elements/1.1/", "rights", null);
            O000000o("http://ns.adobe.com/pdf/1.3/", "Author", "http://purl.org/dc/elements/1.1/", "creator", nnVar);
            O000000o("http://ns.adobe.com/pdf/1.3/", "BaseURL", "http://ns.adobe.com/xap/1.0/", "BaseURL", null);
            O000000o("http://ns.adobe.com/pdf/1.3/", "CreationDate", "http://ns.adobe.com/xap/1.0/", "CreateDate", null);
            O000000o("http://ns.adobe.com/pdf/1.3/", "Creator", "http://ns.adobe.com/xap/1.0/", "CreatorTool", null);
            O000000o("http://ns.adobe.com/pdf/1.3/", "ModDate", "http://ns.adobe.com/xap/1.0/", "ModifyDate", null);
            O000000o("http://ns.adobe.com/pdf/1.3/", "Subject", "http://purl.org/dc/elements/1.1/", "description", nnVar2);
            O000000o("http://ns.adobe.com/pdf/1.3/", "Title", "http://purl.org/dc/elements/1.1/", "title", nnVar2);
            O000000o("http://ns.adobe.com/photoshop/1.0/", "Author", "http://purl.org/dc/elements/1.1/", "creator", nnVar);
            O000000o("http://ns.adobe.com/photoshop/1.0/", "Caption", "http://purl.org/dc/elements/1.1/", "description", nnVar2);
            O000000o("http://ns.adobe.com/photoshop/1.0/", "Copyright", "http://purl.org/dc/elements/1.1/", "rights", nnVar2);
            O000000o("http://ns.adobe.com/photoshop/1.0/", "Keywords", "http://purl.org/dc/elements/1.1/", "subject", null);
            O000000o("http://ns.adobe.com/photoshop/1.0/", "Marked", "http://ns.adobe.com/xap/1.0/rights/", "Marked", null);
            O000000o("http://ns.adobe.com/photoshop/1.0/", "Title", "http://purl.org/dc/elements/1.1/", "title", nnVar2);
            O000000o("http://ns.adobe.com/photoshop/1.0/", "WebStatement", "http://ns.adobe.com/xap/1.0/rights/", "WebStatement", null);
            O000000o("http://ns.adobe.com/tiff/1.0/", "Artist", "http://purl.org/dc/elements/1.1/", "creator", nnVar);
            O000000o("http://ns.adobe.com/tiff/1.0/", "Copyright", "http://purl.org/dc/elements/1.1/", "rights", null);
            O000000o("http://ns.adobe.com/tiff/1.0/", "DateTime", "http://ns.adobe.com/xap/1.0/", "ModifyDate", null);
            O000000o("http://ns.adobe.com/tiff/1.0/", "ImageDescription", "http://purl.org/dc/elements/1.1/", "description", null);
            O000000o("http://ns.adobe.com/tiff/1.0/", "Software", "http://ns.adobe.com/xap/1.0/", "CreatorTool", null);
            O000000o("http://ns.adobe.com/png/1.0/", "Author", "http://purl.org/dc/elements/1.1/", "creator", nnVar);
            O000000o("http://ns.adobe.com/png/1.0/", "Copyright", "http://purl.org/dc/elements/1.1/", "rights", nnVar2);
            O000000o("http://ns.adobe.com/png/1.0/", "CreationTime", "http://ns.adobe.com/xap/1.0/", "CreateDate", null);
            O000000o("http://ns.adobe.com/png/1.0/", "Description", "http://purl.org/dc/elements/1.1/", "description", nnVar2);
            O000000o("http://ns.adobe.com/png/1.0/", "ModificationTime", "http://ns.adobe.com/xap/1.0/", "ModifyDate", null);
            O000000o("http://ns.adobe.com/png/1.0/", "Software", "http://ns.adobe.com/xap/1.0/", "CreatorTool", null);
            O000000o("http://ns.adobe.com/png/1.0/", "Title", "http://purl.org/dc/elements/1.1/", "title", nnVar2);
        } catch (XMPException unused) {
            throw new RuntimeException("The XMPSchemaRegistry cannot be initialized!");
        }
    }

    public final synchronized String O000000o(String str, String str2) throws XMPException {
        mx.O00000Oo(str);
        if (str2 == null || str2.length() == 0) {
            throw new XMPException("Empty prefix", 4);
        }
        if (str2.charAt(str2.length() - 1) != ':') {
            str2 = str2 + ':';
        }
        if (na.O00000oO(str2.substring(0, str2.length() - 1))) {
            String str3 = (String) this.f2202O000000o.get(str);
            String str4 = (String) this.O00000Oo.get(str2);
            if (str3 != null) {
                return str3;
            }
            if (str4 != null) {
                String str5 = str2;
                int i = 1;
                while (this.O00000Oo.containsKey(str5)) {
                    str5 = str2.substring(0, str2.length() - 1) + "_" + i + "_:";
                    i++;
                }
                str2 = str5;
            }
            this.O00000Oo.put(str2, str);
            this.f2202O000000o.put(str, str2);
            return str2;
        }
        throw new XMPException("The prefix is a bad XML name", 201);
    }

    private synchronized void O000000o(String str, String str2, String str3, String str4, nn nnVar) throws XMPException {
        mx.O00000Oo(str);
        mx.O000000o(str2);
        mx.O00000Oo(str3);
        mx.O000000o(str4);
        final nn nnVar2 = nnVar != null ? new nn(ng.O000000o(nnVar.O00000o()).f2207O000000o) : new nn();
        if (this.O00000o.matcher(str2).find() || this.O00000o.matcher(str4).find()) {
            throw new XMPException("Alias and actual property names must be simple", 102);
        }
        String O000000o2 = O000000o(str);
        final String O000000o3 = O000000o(str3);
        if (O000000o2 == null) {
            throw new XMPException("Alias namespace is not registered", 101);
        } else if (O000000o3 != null) {
            String str5 = O000000o2 + str2;
            if (!this.O00000o0.containsKey(str5)) {
                if (!this.O00000o0.containsKey(O000000o3 + str4)) {
                    final String str6 = str3;
                    final String str7 = str4;
                    this.O00000o0.put(str5, new ns() {
                        /* class _m_j.ni.AnonymousClass1 */

                        public final String O000000o() {
                            return str6;
                        }

                        public final String O00000Oo() {
                            return O000000o3;
                        }

                        public final nn O00000o() {
                            return nnVar2;
                        }

                        public final String O00000o0() {
                            return str7;
                        }

                        public final String toString() {
                            return O000000o3 + str7 + " NS(" + str6 + "), FORM (" + nnVar2 + ")";
                        }
                    });
                } else {
                    throw new XMPException("Actual property is already an alias, use the base property", 4);
                }
            } else {
                throw new XMPException("Alias is already existing", 4);
            }
        } else {
            throw new XMPException("Actual namespace is not registered", 101);
        }
    }
}
