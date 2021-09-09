package jadx.api.impl;

import java.util.Collections;
import java.util.Map;

import jadx.api.CodePosition;
import jadx.api.ICodeInfo;

public class SimpleCodeInfo implements ICodeInfo {

	private final String code;
	private final Map<Integer, Integer> lineMapping;
	private final Map<CodePosition, Object> annotations;

	public SimpleCodeInfo(String code) {
		this(code, Collections.emptyMap(), Collections.emptyMap());
	}

	public SimpleCodeInfo(ICodeInfo codeInfo) {
		this(codeInfo.getCodeStr(), codeInfo.getLineMapping(), codeInfo.getAnnotations());
	}

	public SimpleCodeInfo(String code, Map<Integer, Integer> lineMapping, Map<CodePosition, Object> annotations) {
		this.code = code;
		this.lineMapping = lineMapping;
		this.annotations = annotations;
	}

	@Override
	public String getCodeStr() {
		return code;
	}

	@Override
	public Map<Integer, Integer> getLineMapping() {
		return lineMapping;
	}

	@Override
	public Map<CodePosition, Object> getAnnotations() {
		return annotations;
	}

	@Override
	public String toString() {
		return code;
	}
}
