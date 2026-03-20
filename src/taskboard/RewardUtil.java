package taskboard;

import java.util.List;

/**
 *
 * Author: Jack Belleville
 * Date:	 3/19/2026
 * File: RewardUtil.java
 * Desc:
 * RewardUtil is a utility class for generic helper methods.
 * All methods are static, no instantiation is needed.
 */
public class RewardUtil {

	/**
	 * printAll prints each item in the list on its own line using toString().
	 * @param <T> the type of elements in the list
	 * @param items the list of items to print
	 */
	public static <T> void printAll(List<T> items) {
		for (T item : items) {
			System.out.println(item); // System.out.println() calls toString() implicitly
		}
	}

	/**
	 * sumPoints returns the total points across all students in the list.
	 * Uses an upper-bounded wildcard to accept lists of Student or any subclass.
	 * @param students the list of students or subclass
	 * @return the total points across all students
	 */
	public static int sumPoints(List<? extends Student> students) {
		int total = 0;
		for (Student s : students) {
			total += s.getPoints();
		}
		return total;
	}

}
