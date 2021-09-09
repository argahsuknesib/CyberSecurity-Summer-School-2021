package jadx.core.dex.visitors;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jetbrains.annotations.Nullable;

import jadx.api.JadxArgs;
import jadx.core.Consts;
import jadx.core.codegen.json.JsonMappingGen;
import jadx.core.deobf.Deobfuscator;
import jadx.core.deobf.NameMapper;
import jadx.core.dex.attributes.AFlag;
import jadx.core.dex.attributes.nodes.RenameReasonAttr;
import jadx.core.dex.info.AccessInfo;
import jadx.core.dex.info.ClassInfo;
import jadx.core.dex.info.FieldInfo;
import jadx.core.dex.nodes.ClassNode;
import jadx.core.dex.nodes.DexNode;
import jadx.core.dex.nodes.FieldNode;
import jadx.core.dex.nodes.MethodNode;
import jadx.core.dex.nodes.RootNode;
import jadx.core.utils.files.FileUtils;
import jadx.core.utils.files.InputFile;

public class RenameVisitor extends AbstractVisitor {

	@Override
	public void init(RootNode root) {
		List<DexNode> dexNodes = root.getDexNodes();
		if (dexNodes.isEmpty()) {
			return;
		}
		InputFile firstInputFile = dexNodes.get(0).getDexFile().getInputFile();
		Path inputFilePath = firstInputFile.getFile().getAbsoluteFile().toPath();
		String baseName = FileUtils.getPathBaseName(inputFilePath);
		Path deobfMapPath = inputFilePath.getParent().resolve(baseName + ".jobf");

		JadxArgs args = root.getArgs();
		Deobfuscator deobfuscator = new Deobfuscator(args, dexNodes, deobfMapPath);
		if (args.isDeobfuscationOn()) {
			deobfuscator.execute();
		}

		checkClasses(deobfuscator, root, args);

		if (args.isDeobfuscationOn()) {
			deobfuscator.savePresets();
			deobfuscator.clear();
		}
		if (args.isJsonOutput()) {
			JsonMappingGen.dump(root);
		}
	}

	private static void checkClasses(Deobfuscator deobfuscator, RootNode root, JadxArgs args) {
		List<ClassNode> classes = root.getClasses(true);
		for (ClassNode cls : classes) {
			checkClassName(deobfuscator, cls, args);
			checkFields(deobfuscator, cls, args);
			checkMethods(deobfuscator, cls, args);
		}
		if (!args.isFsCaseSensitive() && args.isRenameCaseSensitive()) {
			Set<String> clsFullPaths = new HashSet<>(classes.size());
			for (ClassNode cls : classes) {
				ClassInfo clsInfo = cls.getClassInfo();
				if (!clsFullPaths.add(clsInfo.getAliasFullPath().toLowerCase())) {
					String newShortName = deobfuscator.getClsAlias(cls);
					clsInfo.changeShortName(newShortName);
					cls.addAttr(new RenameReasonAttr(cls).append("case insensitive filesystem"));
					clsFullPaths.add(clsInfo.getAliasFullPath().toLowerCase());
				}
			}
		}
		processRootPackages(deobfuscator, root, classes);
	}

	private static void checkClassName(Deobfuscator deobfuscator, ClassNode cls, JadxArgs args) {
		ClassInfo classInfo = cls.getClassInfo();
		String clsName = classInfo.getAliasShortName();

		String newShortName = fixClsShortName(args, clsName);
		if (newShortName == null) {
			// rename failed, use deobfuscator
			String deobfName = deobfuscator.getClsAlias(cls);
			classInfo.changeShortName(deobfName);
			cls.addAttr(new RenameReasonAttr(cls).notPrintable());
			return;
		}
		if (!newShortName.equals(clsName)) {
			classInfo.changeShortName(newShortName);
			cls.addAttr(new RenameReasonAttr(cls).append("invalid class name"));
		}
		if (classInfo.isInner() && args.isRenameValid()) {
			// check inner classes names
			ClassInfo parentClass = classInfo.getParentClass();
			while (parentClass != null) {
				if (parentClass.getAliasShortName().equals(clsName)) {
					String clsAlias = deobfuscator.getClsAlias(cls);
					classInfo.changeShortName(clsAlias);
					cls.addAttr(new RenameReasonAttr(cls).append("collision with other inner class name"));
					break;
				}
				parentClass = parentClass.getParentClass();
			}
		}
		checkPackage(deobfuscator, cls, classInfo, args);
	}

	private static void checkPackage(Deobfuscator deobfuscator, ClassNode cls, ClassInfo classInfo, JadxArgs args) {
		if (classInfo.isInner()) {
			return;
		}
		String aliasPkg = classInfo.getAliasPkg();
		if (args.isRenameValid() && aliasPkg.isEmpty()) {
			classInfo.changePkg(Consts.DEFAULT_PACKAGE_NAME);
			cls.addAttr(new RenameReasonAttr(cls).append("default package"));
			return;
		}
		String fullPkgAlias = deobfuscator.getPkgAlias(cls);
		if (!fullPkgAlias.equals(aliasPkg)) {
			classInfo.changePkg(fullPkgAlias);
			cls.addAttr(new RenameReasonAttr(cls).append("invalid package"));
		}
	}

	@Nullable
	private static String fixClsShortName(JadxArgs args, String clsName) {
		char firstChar = clsName.charAt(0);
		boolean renameValid = args.isRenameValid();
		if (Character.isDigit(firstChar) && renameValid) {
			return Consts.ANONYMOUS_CLASS_PREFIX + NameMapper.removeInvalidCharsMiddle(clsName);
		}
		if (firstChar == '$' && renameValid) {
			return 'C' + NameMapper.removeInvalidCharsMiddle(clsName);
		}
		String cleanClsName = args.isRenamePrintable()
				? NameMapper.removeInvalidChars(clsName, "C")
				: clsName;
		if (cleanClsName.isEmpty()) {
			return null;
		}
		if (renameValid && !NameMapper.isValidIdentifier(cleanClsName)) {
			return 'C' + cleanClsName;
		}
		return cleanClsName;
	}

	private static void checkFields(Deobfuscator deobfuscator, ClassNode cls, JadxArgs args) {
		Set<String> names = new HashSet<>();
		for (FieldNode field : cls.getFields()) {
			FieldInfo fieldInfo = field.getFieldInfo();
			String fieldName = fieldInfo.getAlias();
			boolean notUnique = !names.add(fieldName);
			boolean notValid = args.isRenameValid() && !NameMapper.isValidIdentifier(fieldName);
			boolean notPrintable = args.isRenamePrintable() && !NameMapper.isAllCharsPrintable(fieldName);
			if (notUnique || notValid || notPrintable) {
				deobfuscator.forceRenameField(field);
				field.addAttr(new RenameReasonAttr(field, notValid, notPrintable));
				if (notUnique) {
					field.addAttr(new RenameReasonAttr(field).append("collision with other field name"));
				}
			}
		}
	}

	private static void checkMethods(Deobfuscator deobfuscator, ClassNode cls, JadxArgs args) {
		List<MethodNode> methods = new ArrayList<>(cls.getMethods().size());
		for (MethodNode method : cls.getMethods()) {
			if (!method.getAccessFlags().isConstructor()) {
				methods.add(method);
			}
		}

		for (MethodNode mth : methods) {
			String alias = mth.getAlias();

			boolean notValid = args.isRenameValid() && !NameMapper.isValidIdentifier(alias);
			boolean notPrintable = args.isRenamePrintable() && !NameMapper.isAllCharsPrintable(alias);
			if (notValid || notPrintable) {
				deobfuscator.forceRenameMethod(mth);
				mth.addAttr(new RenameReasonAttr(mth, notValid, notPrintable));
			}
		}
		Set<String> names = new HashSet<>(methods.size());
		for (MethodNode mth : methods) {
			AccessInfo accessFlags = mth.getAccessFlags();
			if (accessFlags.isBridge() || accessFlags.isSynthetic()
					|| mth.contains(AFlag.DONT_GENERATE) /* this flag not set yet */) {
				continue;
			}
			String signature = mth.getMethodInfo().makeSignature(true, false);
			if (!names.add(signature)) {
				deobfuscator.forceRenameMethod(mth);
				mth.addAttr(new RenameReasonAttr("collision with other method in class"));
			}
		}
	}

	private static void processRootPackages(Deobfuscator deobfuscator, RootNode root, List<ClassNode> classes) {
		Set<String> rootPkgs = collectRootPkgs(classes);
		root.getCacheStorage().setRootPkgs(rootPkgs);

		if (root.getArgs().isRenameValid()) {
			// rename field if collide with any root package
			for (ClassNode cls : classes) {
				for (FieldNode field : cls.getFields()) {
					if (rootPkgs.contains(field.getAlias())) {
						deobfuscator.forceRenameField(field);
						field.addAttr(new RenameReasonAttr("collision with root package name"));
					}
				}
			}
		}
	}

	private static Set<String> collectRootPkgs(List<ClassNode> classes) {
		Set<String> fullPkgs = new HashSet<>();
		for (ClassNode cls : classes) {
			fullPkgs.add(cls.getClassInfo().getAliasPkg());
		}
		Set<String> rootPkgs = new HashSet<>();
		for (String pkg : fullPkgs) {
			String rootPkg = getRootPkg(pkg);
			if (rootPkg != null) {
				rootPkgs.add(rootPkg);
			}
		}
		return rootPkgs;
	}

	@Nullable
	private static String getRootPkg(String pkg) {
		if (pkg.isEmpty()) {
			return null;
		}
		int dotPos = pkg.indexOf('.');
		if (dotPos < 0) {
			return pkg;
		}
		return pkg.substring(0, dotPos);
	}
}
