package _m_j;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.LinkedListMultimap;
import com.xiaomi.infra.galaxy.fds.SubResource;
import com.xiaomi.infra.galaxy.fds.auth.signature.SignAlgorithm;
import com.xiaomi.infra.galaxy.fds.auth.signature.XiaomiHeader;
import com.xiaomi.infra.galaxy.fds.model.HttpMethod;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class dwp {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Log f15005O000000o = LogFactory.getLog(dwp.class);
    private static final Set<String> O00000Oo = new HashSet();
    private static final String O00000o0 = XiaomiHeader.DATE.getName();

    static {
        for (SubResource name : SubResource.values()) {
            O00000Oo.add(name.getName());
        }
    }

    private static String O000000o(LinkedListMultimap<String, String> linkedListMultimap) {
        if (linkedListMultimap == null) {
            return "";
        }
        TreeMap treeMap = new TreeMap();
        for (String str : linkedListMultimap.keySet()) {
            String lowerCase = str.toLowerCase();
            if (lowerCase.startsWith("x-xiaomi-")) {
                treeMap.put(lowerCase, Joiner.on(',').join(linkedListMultimap.get((Object) str)));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : treeMap.entrySet()) {
            sb.append((String) entry.getKey());
            sb.append(":");
            sb.append((String) entry.getValue());
            sb.append("\n");
        }
        return sb.toString();
    }

    private static String O000000o(URI uri) {
        StringBuilder sb = new StringBuilder();
        sb.append(uri.getPath());
        TreeMap treeMap = new TreeMap();
        for (Map.Entry next : dwq.O000000o(uri).entries()) {
            String str = (String) next.getKey();
            if (O00000Oo.contains(str)) {
                treeMap.put(str, (String) next.getValue());
            }
        }
        if (!treeMap.isEmpty()) {
            sb.append("?");
            boolean z = true;
            for (Map.Entry entry : treeMap.entrySet()) {
                if (z) {
                    z = false;
                    sb.append((String) entry.getKey());
                } else {
                    sb.append("&");
                    sb.append((String) entry.getKey());
                }
                if (!((String) entry.getValue()).isEmpty()) {
                    sb.append("=");
                    sb.append((String) entry.getValue());
                }
            }
        }
        return sb.toString();
    }

    private static List<String> O000000o(LinkedListMultimap<String, String> linkedListMultimap, String str) {
        LinkedList linkedList = new LinkedList();
        if (linkedListMultimap == null) {
            linkedList.add("");
            return linkedList;
        }
        List<String> list = linkedListMultimap.get((Object) str);
        if (list != null && !list.isEmpty()) {
            return list;
        }
        linkedList.add("");
        return linkedList;
    }

    public static String O000000o(HttpMethod httpMethod, URI uri, LinkedListMultimap linkedListMultimap, String str, String str2, SignAlgorithm signAlgorithm) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        String str3;
        String str4;
        Preconditions.checkNotNull(httpMethod);
        Preconditions.checkNotNull(uri);
        Preconditions.checkNotNull(str2);
        Preconditions.checkNotNull(signAlgorithm);
        StringBuilder sb = new StringBuilder();
        sb.append(httpMethod.name());
        sb.append("\n");
        sb.append(O000000o(linkedListMultimap, "content-md5").get(0));
        sb.append("\n");
        String str5 = "multipart/form-data";
        if (linkedListMultimap != null) {
            List list = linkedListMultimap.get((Object) "content-type");
            if (list == null || list.isEmpty()) {
                str4 = "";
            } else {
                str4 = (String) list.get(0);
            }
            if (!str4.startsWith(str5)) {
                str5 = str4;
            }
        } else {
            str5 = "";
        }
        sb.append(str5);
        sb.append("\n");
        List<String> list2 = dwq.O000000o(uri).get((Object) "Expires");
        long parseLong = (list2 == null || list2.isEmpty()) ? 0 : Long.parseLong(list2.get(0));
        if (parseLong > 0) {
            sb.append(parseLong);
            sb.append("\n");
        } else {
            if ("".equals(O000000o(linkedListMultimap, O00000o0).get(0))) {
                str3 = O000000o(linkedListMultimap, "date").get(0);
            } else {
                str3 = "";
            }
            if (str3 == null) {
                str3 = "";
            }
            sb.append(str3);
            sb.append("\n");
        }
        sb.append(O000000o(linkedListMultimap));
        sb.append(O000000o(uri));
        String sb2 = sb.toString();
        if (f15005O000000o.isDebugEnabled()) {
            Log log = f15005O000000o;
            log.debug("Sign for request: " + httpMethod + " " + uri + ", stringToSign=" + sb2);
        }
        Mac instance = Mac.getInstance(signAlgorithm.name());
        instance.init(new SecretKeySpec(str2.getBytes(), signAlgorithm.name()));
        String O000000o2 = dwo.O000000o(instance.doFinal(sb2.getBytes("UTF-8")));
        return "Galaxy-V2 " + str + ":" + O000000o2;
    }
}
