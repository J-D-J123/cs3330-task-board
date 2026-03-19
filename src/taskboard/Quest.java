package taskboard;

/**
 * Author: Joey Johnson
 * Date:	 3/16/2026
 * File: Quest.java
 * 
 * Desc:
 * - int getId()
 * - String getTitle()
 * - int getBasePoints()
 * - boolean isCompleted()
 * - int compeleteFor(Student s)
 * 
 * Critical Rule: 
 * 	- Must update the quest's completion state
 *  - award points to the student (directly or indirectly)
 *  - and return the number of points awarded 
 */

public interface Quest {

	/**
	 * getId() gets the id of this
	 * @return a int 
	 */
	int getId(); 
	
	/**
	 * getTitle() gets the title of this
	 * @return String
	 */
	String getTitle();
	
	/**
	 * getBasePoints() returns the amount of basePoints for this
	 * @return a String
	 */
	int getBasePoints();
	
	/**
	 * isCompleted() determins if the status of the quest is completed 
	 * @return true if completed if not then false 
	 */
	boolean isCompleted();
	
	/**
	 * completeFor(Student s) compltes the quest for the specific student s
	 * @param s specific student doing the quest
	 * @return the number of points awarded to the student 
	 */
	int completeFor(Student s);
	
} // end of Quest.java
