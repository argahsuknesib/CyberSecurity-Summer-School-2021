package jadx.core.dex.attributes;

public enum AFlag {
	MTH_ENTER_BLOCK,
	TRY_ENTER,
	TRY_LEAVE,

	LOOP_START,
	LOOP_END,

	SYNTHETIC,

	RETURN, // block contains only return instruction
	ORIG_RETURN,

	DONT_WRAP,
	DONT_INLINE,
	DONT_GENERATE, // process as usual, but don't output to generated code
	COMMENT_OUT, // process as usual, but comment insn in generated code
	REMOVE, // can be completely removed

	HIDDEN, // instruction used inside other instruction but not listed in args

	RESTART_CODEGEN,
	DONT_RENAME, // do not rename during deobfuscation
	ADDED_TO_REGION,

	FINALLY_INSNS,

	SKIP_FIRST_ARG,
	SKIP_ARG, // skip argument in invoke call
	ANONYMOUS_CONSTRUCTOR,
	ANONYMOUS_CLASS,

	THIS,

	/**
	 * RegisterArg attribute for method arguments
	 */
	METHOD_ARGUMENT,

	/**
	 * Type of RegisterArg or SSAVar can't be changed
	 */
	IMMUTABLE_TYPE,

	/**
	 * Force inline instruction with inline assign
	 */
	FORCE_ASSIGN_INLINE,

	CUSTOM_DECLARE, // variable for this register don't need declaration
	DECLARE_VAR,

	ELSE_IF_CHAIN,

	WRAPPED,
	ARITH_ONEARG,

	FALL_THROUGH,

	EXPLICIT_GENERICS,
	VARARG_CALL,

	/**
	 * Use constants with explicit type: cast '(byte) 1' or type letter '7L'
	 */
	EXPLICIT_PRIMITIVE_TYPE,
	EXPLICIT_CAST,

	INCONSISTENT_CODE, // warning about incorrect decompilation
}
