/**
 * 
 */
package com.richardxu.common.lang.reflection;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.richardxu.common.lang.ArrayUtil;
import com.richardxu.common.lang.ClassUtil;
import com.richardxu.common.lang.SystemUtil;

/**
 * 有关<code>Member</code>处理的工具类。<p>
 * 
 * @author saga67
 * 
 * @version create on 2011-10-28 上午3:21:42
 */
class MemberUtil {
	// TODO extract an interface to implement compareParameterSets(...)?

	private static final int ACCESS_TEST = Modifier.PUBLIC | Modifier.PROTECTED
			| Modifier.PRIVATE;

	private static final Method IS_SYNTHETIC;
	static {
		Method isSynthetic = null;
		if (SystemUtil.getJavaInfo().isJavaVersionAtLeast(1.5f)) {
			// cannot call synthetic methods:
			try {
				isSynthetic = Member.class.getMethod("isSynthetic",
						ArrayUtil.EMPTY_CLASS_ARRAY);
			} catch (Exception e) {
				//ignore
			}
		}
		IS_SYNTHETIC = isSynthetic;
	}

	/** Array of primitive number types ordered by "promotability" */
	private static final Class<?>[] ORDERED_PRIMITIVE_TYPES = { Byte.TYPE,
			Short.TYPE, Character.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE,
			Double.TYPE };
	
	private MemberUtil() {
		
	}

	/**
	 * XXX Default access superclass workaround
	 * 
	 * When a public class has a default access superclass with public members,
	 * these members are accessible. Calling them from compiled code works fine.
	 * Unfortunately, on some JVMs, using reflection to invoke these members
	 * seems to (wrongly) to prevent access even when the modifer is public.
	 * Calling setAccessible(true) solves the problem but will only work from
	 * sufficiently privileged code. Better workarounds would be gratefully
	 * accepted.
	 * 
	 * @param o
	 *            the AccessibleObject to set as accessible
	 */
	static void setAccessibleWorkaround(AccessibleObject o) {
		if (o == null || o.isAccessible()) {
			return;
		}
		Member m = (Member) o;
		if (Modifier.isPublic(m.getModifiers())
				&& isPackageAccess(m.getDeclaringClass().getModifiers())) {
			try {
				o.setAccessible(true);
			} catch (SecurityException e) {
				// ignore in favor of subsequent IllegalAccessException
			}
		}
	}

	/**
	 * Learn whether a given set of modifiers implies package access.
	 * 
	 * @param modifiers
	 *            to test
	 * @return true unless package/protected/private modifier detected
	 */
	static boolean isPackageAccess(int modifiers) {
		return (modifiers & ACCESS_TEST) == 0;
	}

	/**
	 * Check a Member for basic accessibility.
	 * 
	 * @param m
	 *            Member to check
	 * @return true if <code>m</code> is accessible
	 */
	static boolean isAccessible(Member m) {
		return m != null && Modifier.isPublic(m.getModifiers())
				&& !isSynthetic(m);
	}

	/**
	 * Try to learn whether a given member, on JDK >= 1.5, is synthetic.
	 * 
	 * @param m
	 *            Member to check
	 * @return true if <code>m</code> was introduced by the compiler.
	 */
	static boolean isSynthetic(Member m) {
		if (IS_SYNTHETIC != null) {
			try {
				return ((Boolean) IS_SYNTHETIC.invoke(m, (Object[]) null))
						.booleanValue();
			} catch (Exception e) {
			}
		}
		return false;
	}

	/**
	 * Compare the relative fitness of two sets of parameter types in terms of
	 * matching a third set of runtime parameter types, such that a list ordered
	 * by the results of the comparison would return the best match first
	 * (least).
	 * 
	 * @param left
	 *            the "left" parameter set
	 * @param right
	 *            the "right" parameter set
	 * @param actual
	 *            the runtime parameter types to match against <code>left</code>
	 *            /<code>right</code>
	 * @return int consistent with <code>compare</code> semantics
	 */
	static int compareParameterTypes(Class<?>[] left, Class<?>[] right,
			Class<?>[] actual) {
		float leftCost = getTotalTransformationCost(actual, left);
		float rightCost = getTotalTransformationCost(actual, right);
		return leftCost < rightCost ? -1 : rightCost < leftCost ? 1 : 0;
	}

	/**
	 * Returns the sum of the object transformation cost for each class in the
	 * source argument list.
	 * 
	 * @param srcArgs
	 *            The source arguments
	 * @param destArgs
	 *            The destination arguments
	 * @return The total transformation cost
	 */
	private static float getTotalTransformationCost(Class<?>[] srcArgs,
			Class<?>[] destArgs) {
		float totalCost = 0.0f;
		for (int i = 0; i < srcArgs.length; i++) {
			Class<?> srcClass, destClass;
			srcClass = srcArgs[i];
			destClass = destArgs[i];
			totalCost += getObjectTransformationCost(srcClass, destClass);
		}
		return totalCost;
	}

	/**
	 * Gets the number of steps required needed to turn the source class into
	 * the destination class. This represents the number of steps in the object
	 * hierarchy graph.
	 * 
	 * @param srcClass
	 *            The source class
	 * @param destClass
	 *            The destination class
	 * @return The cost of transforming an object
	 */
	private static float getObjectTransformationCost(Class<?> srcClass,
			Class<?> destClass) {
		if (destClass.isPrimitive()) {
			return getPrimitivePromotionCost(srcClass, destClass);
		}
		float cost = 0.0f;
		while (srcClass != null && !destClass.equals(srcClass)) {
			if (destClass.isInterface()
					&& ClassUtil.isAssignable(srcClass, destClass)) {
				// slight penalty for interface match.
				// we still want an exact match to override an interface match,
				// but
				// an interface match should override anything where we have to
				// get a superclass.
				cost += 0.25f;
				break;
			}
			cost++;
			srcClass = srcClass.getSuperclass();
		}
		/*
		 * If the destination class is null, we've travelled all the way up to
		 * an Object match. We'll penalize this by adding 1.5 to the cost.
		 */
		if (srcClass == null) {
			cost += 1.5f;
		}
		return cost;
	}

	/**
	 * Get the number of steps required to promote a primitive number to another
	 * type.
	 * 
	 * @param srcClass
	 *            the (primitive) source class
	 * @param destClass
	 *            the (primitive) destination class
	 * @return The cost of promoting the primitive
	 */
	private static float getPrimitivePromotionCost(final Class<?> srcClass,
			final Class<?> destClass) {
		float cost = 0.0f;
		Class<?> cls = srcClass;
		if (!cls.isPrimitive()) {
			// slight unwrapping penalty
			cost += 0.1f;
			cls = ClassUtil.getPrimitiveType(cls);
		}
		for (int i = 0; cls != destClass && i < ORDERED_PRIMITIVE_TYPES.length; i++) {
			if (cls == ORDERED_PRIMITIVE_TYPES[i]) {
				cost += 0.1f;
				if (i < ORDERED_PRIMITIVE_TYPES.length - 1) {
					cls = ORDERED_PRIMITIVE_TYPES[i + 1];
				}
			}
		}
		return cost;
	}

}
