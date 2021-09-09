package jadx.gui.treemodel;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.jetbrains.annotations.Nullable;

import jadx.api.ICodeInfo;
import jadx.api.JadxDecompiler;
import jadx.api.JavaNode;

public abstract class JNode extends DefaultMutableTreeNode {

	private static final long serialVersionUID = -5154479091781041008L;

	public abstract JClass getJParent();

	/**
	 * Return top level JClass or self if already at top.
	 */
	public JClass getRootClass() {
		return null;
	}

	public JavaNode getJavaNode() {
		return null;
	}

	public String getContent() {
		return null;
	}

	public String getSmali() {
		return null;
	}

	public String getSyntaxName() {
		return SyntaxConstants.SYNTAX_STYLE_NONE;
	}

	public int getLine() {
		return 0;
	}

	@Nullable
	public ICodeInfo getCodeInfo() {
		return null;
	}

	public final Integer getSourceLine(int line) {
		ICodeInfo codeInfo = getCodeInfo();
		if (codeInfo == null) {
			return null;
		}
		return codeInfo.getLineMapping().get(line);
	}

	@Nullable
	public JavaNode getJavaNodeAtPosition(JadxDecompiler decompiler, int line, int offset) {
		ICodeInfo codeInfo = getCodeInfo();
		if (codeInfo == null) {
			return null;
		}
		return decompiler.getJavaNodeAtPosition(codeInfo, line, offset);
	}

	public abstract Icon getIcon();

	public String getName() {
		JavaNode javaNode = getJavaNode();
		if (javaNode == null) {
			return null;
		}
		return javaNode.getName();
	}

	public abstract String makeString();

	public String makeDescString() {
		return null;
	}

	public boolean hasDescString() {
		return false;
	}

	public String makeLongString() {
		return makeString();
	}

	@Override
	public String toString() {
		return makeString();
	}
}
