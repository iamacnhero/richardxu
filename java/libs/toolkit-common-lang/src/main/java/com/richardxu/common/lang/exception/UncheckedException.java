package com.richardxu.common.lang.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

import com.richardxu.common.lang.ExceptionUtil;

/**
 * Unchecked exception and also a wrapper for checked exceptions.
 * 
 * @author <a href="mailto:xuc@iphonele.com">saga67</a>
 * 
 * @version create on 2012-10-15 下午5:17:47
 */
public class UncheckedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3576107321861905483L;

	protected final Throwable cause;

	/**
	 * Divider between causes printouts.
	 */
	protected static final String CAUSE_DIV = "---[cause]------------------------------------------------------------------------";

	/**
	 * If set to <code>true</code> stack trace will be enhanced with cause's
	 * stack traces.
	 */
	protected final boolean showCauseDetails;

	// ----------------------------------------------------------------
	// constructors

	public UncheckedException(Throwable t) {
		super(t.getMessage());
		cause = t;
		this.showCauseDetails = true;
	}

	public UncheckedException(Throwable t, boolean showCauseDetails) {
		super(t.getMessage());
		cause = t;
		this.showCauseDetails = showCauseDetails;
	}

	public UncheckedException() {
		super();
		cause = null;
		this.showCauseDetails = false;
	}

	public UncheckedException(String message) {
		super(message);
		cause = null;
		this.showCauseDetails = false;
	}

	public UncheckedException(String message, Throwable t) {
		super(message, t);
		cause = t;
		this.showCauseDetails = true;
	}

	public UncheckedException(String message, Throwable t,
			boolean showCauseDetails) {
		super(message, t);
		cause = t;
		this.showCauseDetails = showCauseDetails;
	}

	// ---------------------------------------------------------------- stack
	// trace

	@Override
	public void printStackTrace() {
		printStackTrace(System.err);
	}

	@Override
	public void printStackTrace(PrintStream ps) {
		synchronized (ps) {
			super.printStackTrace(ps);
			if ((cause != null) && showCauseDetails) {
				Throwable rootCause = ExceptionUtil.getRootCause(cause);
				ps.println(CAUSE_DIV);
				rootCause.printStackTrace(ps);
			}
		}
	}

	@Override
	public void printStackTrace(PrintWriter pw) {
		synchronized (pw) {
			super.printStackTrace(pw);
			if ((cause != null) && showCauseDetails) {
				Throwable rootCause = ExceptionUtil.getRootCause(cause);
				pw.println(CAUSE_DIV);
				rootCause.printStackTrace(pw);
			}
		}
	}

	// ---------------------------------------------------------------- txt

	/**
	 * Returns the detail message, including the message from the nested
	 * exception if there is one.
	 */
	@Override
	public String getMessage() {
		return ExceptionUtil.buildMessage(super.getMessage(), cause);
	}

	// ---------------------------------------------------------------- wrap

	/**
	 * Wraps checked exceptions in a <code>UncheckedException</code>. Unchecked
	 * exceptions are not wrapped.
	 */
	public static RuntimeException wrapChecked(Throwable t) {
		if (t instanceof RuntimeException) {
			return (RuntimeException) t;
		}
		return new UncheckedException(t);
	}

	/**
	 * Wraps all exceptions in a <code>UncheckedException</code>
	 */
	public static RuntimeException wrap(Throwable t) {
		return new UncheckedException(t);
	}

	/**
	 * Wraps all exceptions in a <code>UncheckedException</code>
	 */
	public static RuntimeException wrap(Throwable t, String message) {
		return new UncheckedException(message, t);
	}

	// ---------------------------------------------------------------- cause

	/**
	 * Re-throws cause if exists.
	 */
	public void rethrow() throws Throwable {
		if (cause == null) {
			return;
		}
		throw cause;
	}

	/**
	 * Returns exception cause.
	 */
	@Override
	public Throwable getCause() {
		return cause;
	}

}
