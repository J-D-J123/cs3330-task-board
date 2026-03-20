package taskboard;

/**
 * Author: Joey Johnson
 * Date:	3/19/2026
 * File: StreakQuest.java
 * Desc: 
 
 * 
 * Requirment 
 *	- int days must be positive 
 * 	
 * Design choice: 
 *  - linear bonus: when called they will have a constant bonus applied to their
 *  - amount of points: in this case their days will be multiplied by 2 then added to their basepoints
 */

public class StreakQuest extends AbstractQuest{
	
	// required data
	private int streakQuest_days; 
	
	// open design choice linear bonus application 
	private final int linear_bonus_points = 2; // number 2 from the assignment pdf 
	
	/**
	 * StreakQuest(...) is the contstructor for StreakQuest 
	 * @param id is the id of the specific Quest
	 * @param title is the title of the Quest
	 * @param basepoints specific amount of basepoints the user gets
	 * @param days the amount of days it will take (must be greater or equal to 0)
	 */
	public StreakQuest(int id, String title, int basepoints, int days) {
		
		super(id, title, basepoints); 
		
		if (days <= 0) {
			throw new IllegalArgumentException("days are negative");
		}
		
		streakQuest_days = days;
	}
	
	/**
	 * getDays() returns the amount of days on that specific Quest
	 * @return an int 
	 */
	public int getDays() {
		
		return streakQuest_days; 
	}
	
	/**
	 * getLinearBonus() returns the bonus amount per hour on that specific Quest
	 * @return an int 
	 */
	public int getLinearBonus() {
		
		return linear_bonus_points; 
	}
	
	@Override 
	/**
	 * calculatePoints(Student s) calculates the amount of points awareded to the student
	 * @return int of the mile stone reached or not depending on the amount of days
	 */
	protected int calculatePoints(Student s) {
			
		// linear bonus: basePoints + (days * 2)
		// getDays() = amount of days
		// getLinearBonus() = bonus caculated linearly
		// getBasePoints() = basepoints for the specific Quest
		return getBasePoints() + (getDays() * getLinearBonus());
	}
	
} // end of StreakQuest.java
