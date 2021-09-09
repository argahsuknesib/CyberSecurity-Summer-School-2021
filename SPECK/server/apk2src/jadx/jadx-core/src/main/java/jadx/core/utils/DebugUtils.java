package jadx.core.utils;

import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.jetbrains.annotations.TestOnly;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jadx.core.codegen.CodeWriter;
import jadx.core.codegen.InsnGen;
import jadx.core.codegen.MethodGen;
import jadx.core.dex.attributes.IAttributeNode;
import jadx.core.dex.nodes.BlockNode;
import jadx.core.dex.nodes.IBlock;
import jadx.core.dex.nodes.IContainer;
import jadx.core.dex.nodes.IRegion;
import jadx.core.dex.nodes.InsnNode;
import jadx.core.dex.nodes.MethodNode;
import jadx.core.dex.visitors.AbstractVisitor;
import jadx.core.dex.visitors.DotGraphVisitor;
import jadx.core.dex.visitors.IDexTreeVisitor;
import jadx.core.dex.visitors.regions.DepthRegionTraversal;
import jadx.core.dex.visitors.regions.TracedRegionVisitor;
import jadx.core.utils.exceptions.CodegenException;
import jadx.core.utils.exceptions.JadxException;

import static jadx.core.codegen.CodeWriter.NL;

@Deprecated
@TestOnly
public class DebugUtils {
	private static final Logger LOG = LoggerFactory.getLogger(DebugUtils.class);

	private DebugUtils() {
	}

	public static void dump(MethodNode mth) {
		dump(mth, "dump");
	}

	public static void dumpRaw(MethodNode mth, String desc) {
		File out = new File("test-graph-" + desc + "-tmp");
		DotGraphVisitor.dumpRaw().save(out, mth);
	}

	public static IDexTreeVisitor dumpRawVisitor(String desc) {
		return new AbstractVisitor() {
			@Override
			public void visit(MethodNode mth) throws JadxException {
				dumpRaw(mth, desc);
			}
		};
	}

	public static void dump(MethodNode mth, String desc) {
		File out = new File("test-graph-" + desc + "-tmp");
		DotGraphVisitor.dump().save(out, mth);
		DotGraphVisitor.dumpRaw().save(out, mth);
		DotGraphVisitor.dumpRegions().save(out, mth);
	}

	public static void printRegionsWithBlock(MethodNode mth, BlockNode block) {
		Set<IRegion> regions = new LinkedHashSet<>();
		DepthRegionTraversal.traverse(mth, new TracedRegionVisitor() {
			@Override
			public void processBlockTraced(MethodNode mth, IBlock container, IRegion currentRegion) {
				if (block.equals(container)) {
					regions.add(currentRegion);
				}
			}
		});
		LOG.debug(" Found block: {} in regions: {}", block, regions);
	}

	public static IDexTreeVisitor printRegionsVisitor() {
		return new AbstractVisitor() {
			@Override
			public void visit(MethodNode mth) throws JadxException {
				printRegions(mth, true);
			}
		};
	}

	public static void printRegions(MethodNode mth) {
		printRegions(mth, false);
	}

	public static void printRegions(MethodNode mth, boolean printInsns) {
		printRegion(mth, mth.getRegion(), printInsns);
	}

	public static void printRegion(MethodNode mth, IRegion region, boolean printInsns) {
		CodeWriter cw = new CodeWriter();
		cw.startLine('|').add(mth.toString());
		printRegion(mth, region, cw, "|  ", printInsns);
		LOG.debug("{}{}", NL, cw.finish().getCodeStr());
	}

	private static void printRegion(MethodNode mth, IRegion region, CodeWriter cw, String indent, boolean printInsns) {
		printWithAttributes(cw, indent, region.toString(), region);
		indent += "|  ";
		for (IContainer container : region.getSubBlocks()) {
			if (container instanceof IRegion) {
				printRegion(mth, (IRegion) container, cw, indent, printInsns);
			} else {
				printWithAttributes(cw, indent, container.toString(), container);
				if (printInsns && container instanceof IBlock) {
					IBlock block = (IBlock) container;
					printInsns(mth, cw, indent, block);
				}
			}
		}
	}

	private static void printInsns(MethodNode mth, CodeWriter cw, String indent, IBlock block) {
		for (InsnNode insn : block.getInstructions()) {
			try {
				MethodGen mg = MethodGen.getFallbackMethodGen(mth);
				InsnGen ig = new InsnGen(mg, true);
				CodeWriter code = new CodeWriter();
				ig.makeInsn(insn, code);
				String codeStr = code.finish().getCodeStr();

				List<String> insnStrings = Arrays.stream(codeStr.split(NL))
						.filter(StringUtils::notBlank)
						.map(s -> "|> " + s)
						.collect(Collectors.toList());
				Iterator<String> it = insnStrings.iterator();
				while (true) {
					String insnStr = it.next();
					if (it.hasNext()) {
						cw.startLine(indent).add(insnStr);
					} else {
						printWithAttributes(cw, indent, insnStr, insn);
						break;
					}
				}
			} catch (CodegenException e) {
				cw.startLine(indent).add(">!! ").add(insn.toString());
			}
		}
	}

	private static void printWithAttributes(CodeWriter cw, String indent, String codeStr, IAttributeNode attrNode) {
		String str = attrNode.isAttrStorageEmpty() ? codeStr : codeStr + ' ' + attrNode.getAttributesString();
		List<String> attrStrings = Arrays.stream(str.split(NL))
				.filter(StringUtils::notBlank)
				.collect(Collectors.toList());
		Iterator<String> it = attrStrings.iterator();
		if (!it.hasNext()) {
			return;
		}
		cw.startLine(indent).add(it.next());
		while (it.hasNext()) {
			cw.startLine(indent).add("|+  ").add(it.next());
		}
	}

	public static void printMap(Map<?, ?> map, String desc) {
		LOG.debug("Map {} (size = {}):", desc, map.size());
		for (Map.Entry<?, ?> entry : map.entrySet()) {
			LOG.debug("  {}: {}", entry.getKey(), entry.getValue());
		}
	}
}
