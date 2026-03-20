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
 *  - milestone bonus: extra bonus if days >= 5 
 *  - choice this becuase they will have a motivation to get their specific tasks done 
 *  - when they do they will get more points 
 */

public class StreakQuest extends AbstractQuest{
	
	// required data
	private int streakQuest_days; 
	
	// open design choice specific data (milestone bonus)
	private final int milestone_bonus_requirment = 5; 
	
	// open design choice milestone bonus application 
	private final int milestone_bonus_points = 2; // number 2 from the assignment pdf 
	
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
	 * getMileStoneBonus() returns the bonus minimum requirment on that specific Quest
	 * @return an int 
	 */
	public int getMileStoneBonusRequirmenet() {
		
		return milestone_bonus_requirment; 
	}
	
	/**
	 * getMileStoneBonusPoints() returns the bonus amount per hour on that specific Quest
	 * @return an int 
	 */
	public int getMileStoneBonusPoints() {
		
		return milestone_bonus_points; 
	}
	
	@Override 
	/**
	 * calculatePoints(Student s) calculates the amount of points awareded to the student
	 * @return int of the mile stone reached or not depending on the amount of days
	 */
	protected int calculatePoints(Student s) {
		
		// check to see if the days are greater than the milestone bonus requiremnt 
		if (getDays() >= getMileStoneBonusRequirmenet()) {
			
			// multiply the bonus amount of points multiplied by the amount of days worked plus their base point amount
			return getBasePoints() + (getDays() * getMileStoneBonusPoints());
		}
		
		// else return the base points and no special milestone reached 
		return getBasePoints(); 
	}
	
} // end of StreakQuest.java
