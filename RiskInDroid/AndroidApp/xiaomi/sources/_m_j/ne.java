package _m_j;

import com.adobe.xmp.XMPException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public final class ne {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Object f2197O000000o = new Object();
    private static DocumentBuilderFactory O00000Oo = O000000o();

    private static DocumentBuilderFactory O000000o() {
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        newInstance.setNamespaceAware(true);
        newInstance.setIgnoringComments(true);
        try {
            newInstance.setFeature("http://javax.xml.XMLConstants/feature/secure-processing", true);
            newInstance.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            newInstance.setFeature("http://xml.org/sax/features/external-general-entities", false);
            newInstance.setFeature("http://xerces.apache.org/xerces2-j/features.html#disallow-doctype-decl", false);
            newInstance.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            newInstance.setFeature("http://xerces.apache.org/xerces2-j/features.html#external-parameter-entities", false);
            newInstance.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            newInstance.setXIncludeAware(false);
            newInstance.setExpandEntityReferences(false);
        } catch (Exception unused) {
        }
        return newInstance;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:1|2|(2:4|5)|6|7|8) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0017 */
    private static Document O000000o(mt mtVar, nq nqVar) throws XMPException {
        InputSource inputSource = new InputSource(mtVar.O000000o());
        try {
            if (nqVar.O0000O0o()) {
                O00000Oo.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            }
            return O000000o(inputSource);
        } catch (XMPException e) {
            if (e.getErrorCode() == 201 || e.getErrorCode() == 204) {
                if (nqVar.O00000o()) {
                    mtVar = mw.O000000o(mtVar);
                }
                if (!nqVar.O00000o0()) {
                    return O000000o(new InputSource(mtVar.O000000o()));
                }
                try {
                    return O000000o(new InputSource(new mu(new InputStreamReader(mtVar.O000000o(), mtVar.O00000Oo()))));
                } catch (UnsupportedEncodingException unused) {
                    throw new XMPException("Unsupported Encoding", 9, e);
                }
            } else {
                throw e;
            }
        }
    }

    private static Document O000000o(InputStream inputStream, nq nqVar) throws XMPException {
        if (!nqVar.O00000o() && !nqVar.O00000o0()) {
            return O000000o(new InputSource(inputStream));
        }
        try {
            return O000000o(new mt(inputStream), nqVar);
        } catch (IOException e) {
            throw new XMPException("Error reading the XML-file", 204, e);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:0|1|2|(2:4|5)|6|7|8) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0018 */
    private static Document O000000o(String str, nq nqVar) throws XMPException {
        new InputSource(new StringReader(str));
        try {
            if (nqVar.O0000O0o()) {
                O00000Oo.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            }
            return O000000o(new InputSource(new StringReader(str)));
        } catch (XMPException e) {
            if (e.getErrorCode() == 201 && nqVar.O00000o0()) {
                return O000000o(new InputSource(new mu(new StringReader(str))));
            }
            throw e;
        }
    }

    private static Document O000000o(InputSource inputSource) throws XMPException {
        try {
            DocumentBuilder newDocumentBuilder = O00000Oo.newDocumentBuilder();
            newDocumentBuilder.setErrorHandler(null);
            return newDocumentBuilder.parse(inputSource);
        } catch (SAXException e) {
            throw new XMPException("XML parsing failure", 201, e);
        } catch (ParserConfigurationException e2) {
            throw new XMPException("XML Parser not correctly configured", 0, e2);
        } catch (IOException e3) {
            throw new XMPException("Error reading the XML-file", 204, e3);
        }
    }

    private static Object[] O000000o(Node node, boolean z, Object[] objArr) {
        while (true) {
            NodeList childNodes = node.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node item = childNodes.item(i);
                if (7 == item.getNodeType()) {
                    ProcessingInstruction processingInstruction = (ProcessingInstruction) item;
                    if ("xpacket".equals(processingInstruction.getTarget())) {
                        if (objArr != null) {
                            objArr[2] = processingInstruction.getData();
                        }
                    }
                }
                if (!(3 == item.getNodeType() || 7 == item.getNodeType())) {
                    String namespaceURI = item.getNamespaceURI();
                    String localName = item.getLocalName();
                    if (("xmpmeta".equals(localName) || "xapmeta".equals(localName)) && "adobe:ns:meta/".equals(namespaceURI)) {
                        node = item;
                        z = false;
                    } else if (z || !"RDF".equals(localName) || !"http://www.w3.org/1999/02/22-rdf-syntax-ns#".equals(namespaceURI)) {
                        Object[] O000000o2 = O000000o(item, z, objArr);
                        if (O000000o2 != null) {
                            return O000000o2;
                        }
                    } else {
                        if (objArr != null) {
                            objArr[0] = item;
                            objArr[1] = f2197O000000o;
                        }
                        return objArr;
                    }
                }
            }
            return null;
        }
    }

    public static mo O000000o(Object obj, nq nqVar) throws XMPException {
        if (obj == null) {
            throw new XMPException("Parameter must not be null", 4);
        } else if (!(obj instanceof String) || ((String) obj).length() != 0) {
            nq nqVar2 = new nq();
            Object[] O000000o2 = O000000o(obj instanceof InputStream ? O000000o((InputStream) obj, nqVar2) : obj instanceof byte[] ? O000000o(new mt((byte[]) obj), nqVar2) : O000000o((String) obj, nqVar2), nqVar2.O000000o(), new Object[3]);
            if (O000000o2 == null || O000000o2[1] != f2197O000000o) {
                return new nd();
            }
            nd O000000o3 = my.O000000o((Node) O000000o2[0]);
            O000000o3.O00000Oo = (String) O000000o2[2];
            return !nqVar2.O00000oo() ? nh.O000000o(O000000o3, nqVar2) : O000000o3;
        } else {
            throw new XMPException("Parameter must not be null or empty", 4);
        }
    }
}
