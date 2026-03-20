package taskboard;

/**
 * Author: Joey Johnson
 * Date:	 3/16/2026
 * File: VolunteerQuest.java
 
 * Desc:
 * A student completes this by volunteering some number of hours 
 * Required additonal data:
 * 		- int days (must be positive)
 */

public class VolunteerQuest extends AbstractQuest{
	
	private int volunteerQuest_hours; 
	
	
	/**
	 * VolunteerQuest() is the construtor that takes in a reuqired itn hours
	 * @param id is the Quest number 
	 * @param title is the name of the Quest
	 * @param basepoints is the amount of points for the Quest
	 * @param hours is the amount of hours required for the Quest
	 */
	public VolunteerQuest(int id, String title, int basepoints, int hours) {
		
		super(id, title, basepoints);
		
		// hours cannot be negative or 0 
		// for example a task can take 30 min which is < 1 hour
		if (hours <= 0) {
			
			throw new IllegalArgumentException("hours is negative");
		}
		
		// else add hours to the volunteerQuest_hours 
		volunteerQuest_hours = hours; 
	}
	
	/**
	 * getVolunteerQuestHours() is a helper that returns the volunteerQuest_hours
	 * @return an int of the volunteerQuest_hours
	 */
	public int getVolunteerQuestHours() {
		
		return volunteerQuest_hours; 
	}
	
	@Override
	/**
	 * calculatePoints(Student s) calculates their amount of points that should be awared depending
	 * on their base points multiplied by their hours worked 
	 * @return int for points to be awareded to the student 
	 */
	protected int calculatePoints(Student s) {
		
		return getBasePoints() * getVolunteerQuestHours(); 
	}

} // end of VolunteerQuest.java
