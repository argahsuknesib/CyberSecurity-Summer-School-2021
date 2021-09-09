package jadx.core.clsp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jadx.core.dex.info.MethodInfo;
import jadx.core.dex.instructions.args.ArgType;
import jadx.core.dex.nodes.ClassNode;
import jadx.core.dex.nodes.IMethodDetails;
import jadx.core.dex.nodes.RootNode;
import jadx.core.utils.exceptions.DecodeException;
import jadx.core.utils.exceptions.JadxRuntimeException;

/**
 * Classes hierarchy graph with methods additional info
 */
public class ClspGraph {
	private static final Logger LOG = LoggerFactory.getLogger(ClspGraph.class);

	private final RootNode root;
	private final Map<String, Set<String>> ancestorCache = Collections.synchronizedMap(new WeakHashMap<>());
	private Map<String, ClspClass> nameMap;

	private final Set<String> missingClasses = new HashSet<>();

	public ClspGraph(RootNode rootNode) {
		this.root = rootNode;
	}

	public void load() throws IOException, DecodeException {
		ClsSet set = new ClsSet(root);
		set.loadFromClstFile();
		addClasspath(set);
	}

	public void addClasspath(ClsSet set) {
		if (nameMap == null) {
			nameMap = new HashMap<>(set.getClassesCount());
			set.addToMap(nameMap);
		} else {
			throw new JadxRuntimeException("Classpath already loaded");
		}
	}

	public void addApp(List<ClassNode> classes) {
		if (nameMap == null) {
			throw new JadxRuntimeException("Classpath must be loaded first");
		}
		int size = classes.size();
		ClspClass[] nClasses = new ClspClass[size];
		int k = 0;
		for (ClassNode cls : classes) {
			nClasses[k++] = addClass(cls);
		}
		for (int i = 0; i < size; i++) {
			nClasses[i].setParents(ClsSet.makeParentsArray(classes.get(i)));
		}
	}

	public boolean isClsKnown(String fullName) {
		return nameMap.containsKey(fullName);
	}

	public ClspClass getClsDetails(ArgType type) {
		return nameMap.get(type.getObject());
	}

	@Nullable
	public IMethodDetails getMethodDetails(MethodInfo methodInfo) {
		ClspClass cls = nameMap.get(methodInfo.getDeclClass().getRawName());
		if (cls == null) {
			return null;
		}
		ClspMethod clspMethod = getMethodFromClass(cls, methodInfo);
		if (clspMethod != null) {
			return clspMethod;
		}
		// deep search
		for (ArgType parent : cls.getParents()) {
			ClspClass clspParent = getClspClass(parent);
			if (clspParent != null) {
				ClspMethod methodFromParent = getMethodFromClass(clspParent, methodInfo);
				if (methodFromParent != null) {
					return methodFromParent;
				}
			}
		}
		// all other methods in known ClspClass are 'simple'
		return new SimpleMethodDetails(methodInfo);
	}

	private ClspMethod getMethodFromClass(ClspClass cls, MethodInfo methodInfo) {
		return cls.getMethodsMap().get(methodInfo.getShortId());
	}

	private ClspClass addClass(ClassNode cls) {
		ArgType clsType = cls.getClassInfo().getType();
		String rawName = clsType.getObject();
		ClspClass clspClass = new ClspClass(clsType, -1);
		nameMap.put(rawName, clspClass);
		return clspClass;
	}

	/**
	 * @return {@code clsName} instanceof {@code implClsName}
	 */
	public boolean isImplements(String clsName, String implClsName) {
		Set<String> anc = getAncestors(clsName);
		return anc.contains(implClsName);
	}

	public List<String> getImplementations(String clsName) {
		List<String> list = new ArrayList<>();
		for (String cls : nameMap.keySet()) {
			if (isImplements(cls, clsName)) {
				list.add(cls);
			}
		}
		return list;
	}

	public String getCommonAncestor(String clsName, String implClsName) {
		if (clsName.equals(implClsName)) {
			return clsName;
		}
		ClspClass cls = nameMap.get(implClsName);
		if (cls == null) {
			missingClasses.add(clsName);
			return null;
		}
		if (isImplements(clsName, implClsName)) {
			return implClsName;
		}
		Set<String> anc = getAncestors(clsName);
		return searchCommonParent(anc, cls);
	}

	private String searchCommonParent(Set<String> anc, ClspClass cls) {
		for (ArgType p : cls.getParents()) {
			String name = p.getObject();
			if (anc.contains(name)) {
				return name;
			}
			ClspClass nCls = getClspClass(p);
			if (nCls != null) {
				String r = searchCommonParent(anc, nCls);
				if (r != null) {
					return r;
				}
			}
		}
		return null;
	}

	public Set<String> getAncestors(String clsName) {
		Set<String> result = ancestorCache.get(clsName);
		if (result != null) {
			return result;
		}
		ClspClass cls = nameMap.get(clsName);
		if (cls == null) {
			missingClasses.add(clsName);
			return Collections.emptySet();
		}
		result = new HashSet<>();
		addAncestorsNames(cls, result);
		if (result.isEmpty()) {
			result = Collections.emptySet();
		}
		ancestorCache.put(clsName, result);
		return result;
	}

	private void addAncestorsNames(ClspClass cls, Set<String> result) {
		boolean isNew = result.add(cls.getName());
		if (isNew) {
			for (ArgType parentType : cls.getParents()) {
				if (parentType == null) {
					continue;
				}
				ClspClass parentCls = getClspClass(parentType);
				if (parentCls != null) {
					addAncestorsNames(parentCls, result);
				}
			}
		}
	}

	@Nullable
	private ClspClass getClspClass(ArgType clsType) {
		ClspClass clspClass = nameMap.get(clsType.getObject());
		if (clspClass == null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("External class not found: {}", clsType.getObject());
			}
		}
		return clspClass;
	}

	public void printMissingClasses() {
		int count = missingClasses.size();
		if (count == 0) {
			return;
		}
		LOG.warn("Found {} references to unknown classes", count);
		if (LOG.isDebugEnabled()) {
			List<String> clsNames = new ArrayList<>(missingClasses);
			Collections.sort(clsNames);
			for (String cls : clsNames) {
				LOG.debug("  {}", cls);
			}
		}
	}
}
