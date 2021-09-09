package jadx.core.dex.nodes;

import jadx.core.dex.attributes.IAttributeNode;
import jadx.core.dex.info.AccessInfo;

public interface ICodeNode extends IDexNode, IAttributeNode {
	AccessInfo getAccessFlags();

	void setAccessFlags(AccessInfo newAccessFlags);
}
