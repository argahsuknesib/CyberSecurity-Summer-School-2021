package _m_j;

import com.adobe.xmp.XMPException;
import java.util.ArrayList;
import java.util.Iterator;
import org.w3c.dom.Attr;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class my {

    /* renamed from: O000000o  reason: collision with root package name */
    static final /* synthetic */ boolean f2189O000000o = (!my.class.desiredAssertionStatus());

    private static nf O000000o(nf nfVar, String str, String str2) throws XMPException {
        if ("xml:lang".equals(str)) {
            str2 = na.O000000o(str2);
        }
        nf nfVar2 = new nf(str, str2, null);
        nfVar.O00000o(nfVar2);
        return nfVar2;
    }

    private static void O000000o() throws XMPException {
        throw new XMPException("ParseTypeLiteral property element not allowed", 203);
    }

    private static void O000000o(nd ndVar, nf nfVar, Node node, boolean z) throws XMPException {
        int O00000o0 = O00000o0(node);
        if (O00000o0 != 8 && O00000o0 != 0) {
            throw new XMPException("Node element must be rdf:Description or typed node", 202);
        } else if (!z || O00000o0 != 0) {
            O00000Oo(ndVar, nfVar, node, z);
            O00000o0(ndVar, nfVar, node, z);
        } else {
            throw new XMPException("Top level typed node not allowed", 203);
        }
    }

    private static boolean O000000o(int i) {
        return i != 8 && !O00000Oo(i) && !O00000o0(i);
    }

    private static void O00000Oo() throws XMPException {
        throw new XMPException("ParseTypeCollection property element not allowed", 203);
    }

    private static boolean O00000Oo(int i) {
        return 10 <= i && i <= 12;
    }

    private static boolean O00000Oo(Node node) {
        if (node.getNodeType() != 3) {
            return false;
        }
        String nodeValue = node.getNodeValue();
        for (int i = 0; i < nodeValue.length(); i++) {
            if (!Character.isWhitespace(nodeValue.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static void O00000o(nd ndVar, nf nfVar, Node node, boolean z) throws XMPException {
        if (O000000o(O00000o0(node))) {
            NamedNodeMap attributes = node.getAttributes();
            ArrayList<String> arrayList = null;
            for (int i = 0; i < attributes.getLength(); i++) {
                Node item = attributes.item(i);
                if ("xmlns".equals(item.getPrefix()) || (item.getPrefix() == null && "xmlns".equals(item.getNodeName()))) {
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    arrayList.add(item.getNodeName());
                }
            }
            if (arrayList != null) {
                for (String removeNamedItem : arrayList) {
                    attributes.removeNamedItem(removeNamedItem);
                }
            }
            if (attributes.getLength() <= 3) {
                int i2 = 0;
                while (i2 < attributes.getLength()) {
                    Node item2 = attributes.item(i2);
                    String localName = item2.getLocalName();
                    String namespaceURI = item2.getNamespaceURI();
                    String nodeValue = item2.getNodeValue();
                    if ("xml:lang".equals(item2.getNodeName()) && (!"ID".equals(localName) || !"http://www.w3.org/1999/02/22-rdf-syntax-ns#".equals(namespaceURI))) {
                        i2++;
                    } else if ("datatype".equals(localName) && "http://www.w3.org/1999/02/22-rdf-syntax-ns#".equals(namespaceURI)) {
                        O00000oo(ndVar, nfVar, node, z);
                        return;
                    } else if (!"parseType".equals(localName) || !"http://www.w3.org/1999/02/22-rdf-syntax-ns#".equals(namespaceURI)) {
                        O0000OOo(ndVar, nfVar, node, z);
                        return;
                    } else if ("Literal".equals(nodeValue)) {
                        O000000o();
                        return;
                    } else if ("Resource".equals(nodeValue)) {
                        O0000O0o(ndVar, nfVar, node, z);
                        return;
                    } else if ("Collection".equals(nodeValue)) {
                        O00000Oo();
                        return;
                    } else {
                        O00000o0();
                        return;
                    }
                }
                if (node.hasChildNodes()) {
                    for (int i3 = 0; i3 < node.getChildNodes().getLength(); i3++) {
                        if (node.getChildNodes().item(i3).getNodeType() != 3) {
                            O00000oO(ndVar, nfVar, node, z);
                            return;
                        }
                    }
                    O00000oo(ndVar, nfVar, node, z);
                    return;
                }
            }
            O0000OOo(ndVar, nfVar, node, z);
            return;
        }
        throw new XMPException("Invalid property element name", 202);
    }

    private static int O00000o0(Node node) {
        String localName = node.getLocalName();
        String namespaceURI = node.getNamespaceURI();
        if (namespaceURI == null && (("about".equals(localName) || "ID".equals(localName)) && (node instanceof Attr) && "http://www.w3.org/1999/02/22-rdf-syntax-ns#".equals(((Attr) node).getOwnerElement().getNamespaceURI()))) {
            namespaceURI = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
        }
        if (!"http://www.w3.org/1999/02/22-rdf-syntax-ns#".equals(namespaceURI)) {
            return 0;
        }
        if ("li".equals(localName)) {
            return 9;
        }
        if ("parseType".equals(localName)) {
            return 4;
        }
        if ("Description".equals(localName)) {
            return 8;
        }
        if ("about".equals(localName)) {
            return 3;
        }
        if ("resource".equals(localName)) {
            return 5;
        }
        if ("RDF".equals(localName)) {
            return 1;
        }
        if ("ID".equals(localName)) {
            return 2;
        }
        if ("nodeID".equals(localName)) {
            return 6;
        }
        if ("datatype".equals(localName)) {
            return 7;
        }
        if ("aboutEach".equals(localName)) {
            return 10;
        }
        if ("aboutEachPrefix".equals(localName)) {
            return 11;
        }
        return "bagID".equals(localName) ? 12 : 0;
    }

    private static void O00000o0() throws XMPException {
        throw new XMPException("ParseTypeOther property element not allowed", 203);
    }

    private static void O00000o0(nd ndVar, nf nfVar, Node node, boolean z) throws XMPException {
        for (int i = 0; i < node.getChildNodes().getLength(); i++) {
            Node item = node.getChildNodes().item(i);
            if (!O00000Oo(item)) {
                if (item.getNodeType() == 1) {
                    O00000o(ndVar, nfVar, item, z);
                } else {
                    throw new XMPException("Expected property element node not found", 202);
                }
            }
        }
    }

    private static boolean O00000o0(int i) {
        return i > 0 && i <= 7;
    }

    static nd O000000o(Node node) throws XMPException {
        nd ndVar = new nd();
        if (node.hasAttributes()) {
            nf nfVar = ndVar.f2196O000000o;
            for (int i = 0; i < node.getChildNodes().getLength(); i++) {
                Node item = node.getChildNodes().item(i);
                if (!O00000Oo(item)) {
                    O000000o(ndVar, nfVar, item, true);
                }
            }
            return ndVar;
        }
        throw new XMPException("Invalid attributes of rdf:RDF element", 202);
    }

    private static void O00000Oo(nd ndVar, nf nfVar, Node node, boolean z) throws XMPException {
        int i = 0;
        for (int i2 = 0; i2 < node.getAttributes().getLength(); i2++) {
            Node item = node.getAttributes().item(i2);
            if (!"xmlns".equals(item.getPrefix()) && (item.getPrefix() != null || !"xmlns".equals(item.getNodeName()))) {
                int O00000o0 = O00000o0(item);
                if (O00000o0 == 0) {
                    O000000o(ndVar, nfVar, item, item.getNodeValue(), z);
                } else if (O00000o0 != 6 && O00000o0 != 2 && O00000o0 != 3) {
                    throw new XMPException("Invalid nodeElement attribute", 202);
                } else if (i <= 0) {
                    i++;
                    if (z && O00000o0 == 3) {
                        if (nfVar.f2198O000000o == null || nfVar.f2198O000000o.length() <= 0) {
                            nfVar.f2198O000000o = item.getNodeValue();
                        } else if (!nfVar.f2198O000000o.equals(item.getNodeValue())) {
                            throw new XMPException("Mismatched top level rdf:about values", 203);
                        }
                    }
                } else {
                    throw new XMPException("Mutally exclusive about, ID, nodeID attributes", 202);
                }
            }
        }
    }

    private static void O00000oO(nd ndVar, nf nfVar, Node node, boolean z) throws XMPException {
        if (!z || !"iX:changes".equals(node.getNodeName())) {
            nf O000000o2 = O000000o(ndVar, nfVar, node, "", z);
            for (int i = 0; i < node.getAttributes().getLength(); i++) {
                Node item = node.getAttributes().item(i);
                if (!"xmlns".equals(item.getPrefix()) && (item.getPrefix() != null || !"xmlns".equals(item.getNodeName()))) {
                    String localName = item.getLocalName();
                    String namespaceURI = item.getNamespaceURI();
                    if ("xml:lang".equals(item.getNodeName())) {
                        O000000o(O000000o2, "xml:lang", item.getNodeValue());
                    } else if (!"ID".equals(localName) || !"http://www.w3.org/1999/02/22-rdf-syntax-ns#".equals(namespaceURI)) {
                        throw new XMPException("Invalid attribute for resource property element", 202);
                    }
                }
            }
            boolean z2 = false;
            for (int i2 = 0; i2 < node.getChildNodes().getLength(); i2++) {
                Node item2 = node.getChildNodes().item(i2);
                if (!O00000Oo(item2)) {
                    if (item2.getNodeType() == 1 && !z2) {
                        boolean equals = "http://www.w3.org/1999/02/22-rdf-syntax-ns#".equals(item2.getNamespaceURI());
                        String localName2 = item2.getLocalName();
                        if (equals && "Bag".equals(localName2)) {
                            O000000o2.O0000OOo().O00000oo();
                        } else if (equals && "Seq".equals(localName2)) {
                            O000000o2.O0000OOo().O00000oo().O0000OOo();
                        } else if (!equals || !"Alt".equals(localName2)) {
                            O000000o2.O0000OOo().O00000o(true);
                            if (!equals && !"Description".equals(localName2)) {
                                String namespaceURI2 = item2.getNamespaceURI();
                                if (namespaceURI2 != null) {
                                    O000000o(O000000o2, "rdf:type", namespaceURI2 + ':' + localName2);
                                } else {
                                    throw new XMPException("All XML elements must be in a namespace", 203);
                                }
                            }
                        } else {
                            O000000o2.O0000OOo().O00000oo().O0000OOo().O0000Oo();
                        }
                        O000000o(ndVar, O000000o2, item2, false);
                        if (O000000o2.O0000Oo) {
                            O000000o(O000000o2);
                        } else if (O000000o2.O0000OOo().O0000Oo0()) {
                            ng.O000000o(O000000o2);
                        }
                        z2 = true;
                    } else if (z2) {
                        throw new XMPException("Invalid child of resource property element", 202);
                    } else {
                        throw new XMPException("Children of resource property element must be XML elements", 202);
                    }
                }
            }
            if (!z2) {
                throw new XMPException("Missing child of resource property element", 202);
            }
        }
    }

    private static void O00000oo(nd ndVar, nf nfVar, Node node, boolean z) throws XMPException {
        nf O000000o2 = O000000o(ndVar, nfVar, node, null, z);
        int i = 0;
        for (int i2 = 0; i2 < node.getAttributes().getLength(); i2++) {
            Node item = node.getAttributes().item(i2);
            if (!"xmlns".equals(item.getPrefix()) && (item.getPrefix() != null || !"xmlns".equals(item.getNodeName()))) {
                String namespaceURI = item.getNamespaceURI();
                String localName = item.getLocalName();
                if ("xml:lang".equals(item.getNodeName())) {
                    O000000o(O000000o2, "xml:lang", item.getNodeValue());
                } else if (!"http://www.w3.org/1999/02/22-rdf-syntax-ns#".equals(namespaceURI) || (!"ID".equals(localName) && !"datatype".equals(localName))) {
                    throw new XMPException("Invalid attribute for literal property element", 202);
                }
            }
        }
        String str = "";
        while (i < node.getChildNodes().getLength()) {
            Node item2 = node.getChildNodes().item(i);
            if (item2.getNodeType() == 3) {
                str = str + item2.getNodeValue();
                i++;
            } else {
                throw new XMPException("Invalid child of literal property element", 202);
            }
        }
        O000000o2.O00000Oo = str;
    }

    private static void O0000O0o(nd ndVar, nf nfVar, Node node, boolean z) throws XMPException {
        nf O000000o2 = O000000o(ndVar, nfVar, node, "", z);
        O000000o2.O0000OOo().O00000o(true);
        for (int i = 0; i < node.getAttributes().getLength(); i++) {
            Node item = node.getAttributes().item(i);
            if (!"xmlns".equals(item.getPrefix()) && (item.getPrefix() != null || !"xmlns".equals(item.getNodeName()))) {
                String localName = item.getLocalName();
                String namespaceURI = item.getNamespaceURI();
                if ("xml:lang".equals(item.getNodeName())) {
                    O000000o(O000000o2, "xml:lang", item.getNodeValue());
                } else if (!"http://www.w3.org/1999/02/22-rdf-syntax-ns#".equals(namespaceURI) || (!"ID".equals(localName) && !"parseType".equals(localName))) {
                    throw new XMPException("Invalid attribute for ParseTypeResource property element", 202);
                }
            }
        }
        O00000o0(ndVar, O000000o2, node, false);
        if (O000000o2.O0000Oo) {
            O000000o(O000000o2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x00eb  */
    private static void O0000OOo(nd ndVar, nf nfVar, Node node, boolean z) throws XMPException {
        boolean z2;
        int i;
        String nodeName;
        String nodeValue;
        nd ndVar2 = ndVar;
        if (!node.hasChildNodes()) {
            Node node2 = null;
            boolean z3 = false;
            boolean z4 = false;
            boolean z5 = false;
            boolean z6 = false;
            for (int i2 = 0; i2 < node.getAttributes().getLength(); i2++) {
                Node item = node.getAttributes().item(i2);
                if (!"xmlns".equals(item.getPrefix()) && (item.getPrefix() != null || !"xmlns".equals(item.getNodeName()))) {
                    int O00000o0 = O00000o0(item);
                    if (O00000o0 != 0) {
                        if (O00000o0 == 2) {
                            continue;
                        } else if (O00000o0 != 5) {
                            if (O00000o0 != 6) {
                                throw new XMPException("Unrecognized attribute of empty property element", 202);
                            } else if (!z4) {
                                z6 = true;
                            } else {
                                throw new XMPException("Empty property element can't have both rdf:resource and rdf:nodeID", 202);
                            }
                        } else if (z6) {
                            throw new XMPException("Empty property element can't have both rdf:resource and rdf:nodeID", 202);
                        } else if (!z3) {
                            if (!z3) {
                                node2 = item;
                            }
                            z4 = true;
                        } else {
                            throw new XMPException("Empty property element can't have both rdf:value and rdf:resource", 203);
                        }
                    } else if (!"value".equals(item.getLocalName()) || !"http://www.w3.org/1999/02/22-rdf-syntax-ns#".equals(item.getNamespaceURI())) {
                        if (!"xml:lang".equals(item.getNodeName())) {
                            z5 = true;
                        }
                    } else if (!z4) {
                        node2 = item;
                        z3 = true;
                    } else {
                        throw new XMPException("Empty property element can't have both rdf:value and rdf:resource", 203);
                    }
                }
            }
            String str = "";
            nf O000000o2 = O000000o(ndVar2, nfVar, node, str, z);
            if (z3 || z4) {
                if (node2 != null) {
                    str = node2.getNodeValue();
                }
                O000000o2.O00000Oo = str;
                if (!z3) {
                    O000000o2.O0000OOo().O000000o(2, true);
                }
            } else if (z5) {
                z2 = true;
                O000000o2.O0000OOo().O00000o(true);
                for (i = 0; i < node.getAttributes().getLength(); i++) {
                    Node item2 = node.getAttributes().item(i);
                    if (item2 != node2 && !"xmlns".equals(item2.getPrefix()) && (item2.getPrefix() != null || !"xmlns".equals(item2.getNodeName()))) {
                        int O00000o02 = O00000o0(item2);
                        if (O00000o02 != 0) {
                            if (O00000o02 != 2) {
                                if (O00000o02 == 5) {
                                    nodeValue = item2.getNodeValue();
                                    nodeName = "rdf:resource";
                                } else if (O00000o02 != 6) {
                                    throw new XMPException("Unrecognized attribute of empty property element", 202);
                                }
                            }
                        } else if (!z2) {
                            nodeName = item2.getNodeName();
                            nodeValue = item2.getNodeValue();
                        } else if ("xml:lang".equals(item2.getNodeName())) {
                            O000000o(O000000o2, "xml:lang", item2.getNodeValue());
                        } else {
                            O000000o(ndVar2, O000000o2, item2, item2.getNodeValue(), false);
                        }
                        O000000o(O000000o2, nodeName, nodeValue);
                    }
                }
                return;
            }
            z2 = false;
            while (i < node.getAttributes().getLength()) {
            }
            return;
        }
        throw new XMPException("Nested content not allowed with rdf:resource or property attributes", 202);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ng.O000000o(_m_j.nf, java.lang.String, java.lang.String, boolean):_m_j.nf
     arg types: [_m_j.nf, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.ng.O000000o(_m_j.nf, java.lang.String, java.lang.String, int):int
      _m_j.ng.O000000o(_m_j.nf, _m_j.nk, boolean, _m_j.nr):_m_j.nf
      _m_j.ng.O000000o(_m_j.nf, java.lang.String, java.lang.String, boolean):_m_j.nf */
    private static nf O000000o(nd ndVar, nf nfVar, Node node, String str, boolean z) throws XMPException {
        mq O000000o2 = mp.O000000o();
        String namespaceURI = node.getNamespaceURI();
        if (namespaceURI != null) {
            if ("http://purl.org/dc/1.1/".equals(namespaceURI)) {
                namespaceURI = "http://purl.org/dc/elements/1.1/";
            }
            String O000000o3 = O000000o2.O000000o(namespaceURI);
            if (O000000o3 == null) {
                O000000o3 = O000000o2.O000000o(namespaceURI, node.getPrefix() != null ? node.getPrefix() : "_dflt");
            }
            String str2 = O000000o3 + node.getLocalName();
            nr nrVar = new nr();
            boolean z2 = false;
            if (z) {
                nfVar = ng.O000000o(ndVar.f2196O000000o, namespaceURI, "_dflt", true);
                nfVar.O0000O0o = false;
                if (O000000o2.O00000o0(str2) != null) {
                    ndVar.f2196O000000o.O0000OOo = true;
                    nfVar.O0000OOo = true;
                    z2 = true;
                }
            }
            boolean equals = "rdf:li".equals(str2);
            boolean equals2 = "rdf:value".equals(str2);
            nf nfVar2 = new nf(str2, str, nrVar);
            nfVar2.O0000Oo0 = z2;
            if (!equals2) {
                nfVar.O000000o(nfVar2);
            } else {
                nfVar.O00000Oo(nfVar2);
            }
            if (equals2) {
                if (z || !nfVar.O0000OOo().O00000o0()) {
                    throw new XMPException("Misplaced rdf:value element", 202);
                }
                nfVar.O0000Oo = true;
            }
            if (equals) {
                if (nfVar.O0000OOo().O00000o()) {
                    nfVar2.f2198O000000o = "[]";
                } else {
                    throw new XMPException("Misplaced rdf:li element", 202);
                }
            }
            return nfVar2;
        }
        throw new XMPException("XML namespace required for all elements and attributes", 202);
    }

    private static void O000000o(nf nfVar) throws XMPException {
        if (f2189O000000o || (nfVar.O0000OOo().O00000o0() && nfVar.O00000o())) {
            nf O000000o2 = nfVar.O000000o(1);
            if (f2189O000000o || "rdf:value".equals(O000000o2.f2198O000000o)) {
                if (O000000o2.O0000OOo().O00000Oo()) {
                    if (!nfVar.O0000OOo().O00000Oo()) {
                        nf O00000Oo = O000000o2.O00000Oo(1);
                        O000000o2.O00000oO(O00000Oo);
                        nfVar.O00000o(O00000Oo);
                    } else {
                        throw new XMPException("Redundant xml:lang for rdf:value element", 203);
                    }
                }
                for (int i = 1; i <= O000000o2.O00000o0(); i++) {
                    nfVar.O00000o(O000000o2.O00000Oo(i));
                }
                for (int i2 = 2; i2 <= nfVar.O00000Oo(); i2++) {
                    nfVar.O00000o(nfVar.O000000o(i2));
                }
                if (f2189O000000o || nfVar.O0000OOo().O00000o0() || nfVar.O0000Oo) {
                    nfVar.O0000Oo = false;
                    nfVar.O0000OOo().O00000o(false);
                    nfVar.O0000OOo().O000000o(O000000o2.O0000OOo());
                    nfVar.O00000Oo = O000000o2.O00000Oo;
                    nfVar.O00000o = null;
                    Iterator O00000oO = O000000o2.O00000oO();
                    while (O00000oO.hasNext()) {
                        nfVar.O000000o((nf) O00000oO.next());
                    }
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }
}
