package jadx.gui.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.jetbrains.annotations.Nullable;

public class JumpManager {

	private final List<JumpPosition> list = new ArrayList<>();
	private int currentPos = 0;

	public void addPosition(JumpPosition pos) {
		if (ignoreJump(pos)) {
			return;
		}
		currentPos++;
		if (currentPos >= list.size()) {
			list.add(pos);
			currentPos = list.size() - 1;
		} else {
			list.set(currentPos, pos);
			int size = list.size();
			for (int i = currentPos + 1; i < size; i++) {
				list.set(i, null);
			}
		}
	}

	private boolean ignoreJump(JumpPosition pos) {
		JumpPosition current = getCurrent();
		if (current == null) {
			return false;
		}
		if (pos.equals(current)) {
			return true;
		}
		if (Objects.equals(current.getNode(), pos.getNode())) {
			// undefined jump line in same node // TODO: find the cause
			if (pos.getLine() == 0) {
				return true;
			}
			if (current.getLine() == 0) {
				// replace current
				getPrev();
				return false;
			}
			return false;
		}
		return false;
	}

	@Nullable
	private JumpPosition getCurrent() {
		if (currentPos >= 0 && currentPos < list.size()) {
			return list.get(currentPos);
		}
		return null;
	}

	@Nullable
	public JumpPosition getPrev() {
		if (currentPos == 0) {
			return null;
		}
		currentPos--;
		return list.get(currentPos);
	}

	@Nullable
	public JumpPosition getNext() {
		int size = list.size();
		if (size == 0) {
			currentPos = 0;
			return null;
		}
		int newPos = currentPos + 1;
		if (newPos >= size) {
			currentPos = size - 1;
			return null;
		}
		JumpPosition position = list.get(newPos);
		if (position == null) {
			return null;
		}
		currentPos = newPos;
		return position;
	}
}
