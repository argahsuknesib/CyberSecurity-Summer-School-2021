package jadx.core.dex.attributes.nodes;

import java.util.LinkedList;
import java.util.List;

import jadx.core.dex.attributes.AType;
import jadx.core.dex.attributes.IAttribute;
import jadx.core.dex.instructions.PhiInsn;

import static com.google.common.base.Ascii.NL;

public class PhiListAttr implements IAttribute {

	private final List<PhiInsn> list = new LinkedList<>();

	@Override
	public AType<PhiListAttr> getType() {
		return AType.PHI_LIST;
	}

	public List<PhiInsn> getList() {
		return list;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("PHI: ");
		for (PhiInsn phiInsn : list) {
			sb.append('r').append(phiInsn.getResult().getRegNum()).append(' ');
		}
		for (PhiInsn phiInsn : list) {
			sb.append(NL).append("  ").append(phiInsn).append(' ').append(phiInsn.getAttributesString());
		}
		return sb.toString();
	}
}
