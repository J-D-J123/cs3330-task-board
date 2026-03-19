package taskboard;

/**
 * Author: Joey Johnson
 * Date:	 3/16/2026
 * File: AbstractQuest.java
 * Desc: 
 * 
 * Common fields (id, title, basepoints, completed)
 * Common validation (fail fast)
 * Common getters (no fail checks)
 * A helpful toString()
 * 
 * Requirment 
 * 	- id > 0 
 * 	- title is not null or blank  
 * 	- basePoints > 0 
 * 	
 * Requried behavior: 
 * 	- A constructor that validates invariatns (throw IllegalArgumentException)
 *  - Abstract classes and abstract methods are part of what we covered idk why it says that lol
 */

public abstract class AbstractQuest implements Quest{

	private int quest_id; 
	private String quest_title;
	private int	quest_basepoints; 
	private boolean quest_completed; 
	
	/**
	 * AbstractQuest(...) is the fail fast constructor for the AbstractQuest
	 * @param id is the QuestId of the AbstractQuest
	 * @param name is the String (name of the quest)
	 * @param basepoints is the basepoints for the AbstractQuest to be awarded
	 * @param completed boolean if the AbstractQuest is completed or not 
	 */
	public AbstractQuest(int id, String title, int basepoints) {
	
		// fail fast condition where 
		// id > 0 name cannot be null or blank and basepoints > 0 = make object
		if (id <= 0) {
			
			throw new IllegalArgumentException("quest_id must be greater than 0");
		}
		
		if (title == null || title.isBlank()) {
			
			throw new IllegalArgumentException("quest_title is null or blank");
		}
		
		if (basepoints <= 0) {
			
			throw new IllegalArgumentException("quest_basepoints must be greater than 0");
		}
		
		quest_id = id; 
		quest_title = title; 
		quest_basepoints = basepoints; 
	}
	
	// repeative getters uggghh
	@Override 
	/**
	 * getId() 
	 * @returns the int of the Quest id 
	 */
	public int getId() {
		
		return quest_id; 
	}
	
	@Override 
	/**
	 * getTitle() 
	 * @return a String of the quest_title
	 */
	public String getTitle() {
		
		return quest_title; 
	}
	
	@Override 
	/**
	 * getBasePoints() 
	 * @return an integer of the basepoints of the Quest
	 */
	public int getBasePoints() {
		
		return quest_basepoints; 
	}
	
	@Override 
	/**
	 * isCompleted() 
	 * @returns a boolean either true if a Quest was completed or false if not
	 */
	public boolean isCompleted() {
		
		return quest_completed; 
	}
	
	@Override
	/**
	 * completeFor(Student s) 
	 * @param s is the Student object that is completing this task
	 * @return quest_point_amount 0 means the Quest was already compleated otherwise it will return the quest_basepoint amount 
	 */
	public int completeFor(Student s) {
		
		// only add if the quest is completed 
		if (!isCompleted()) {
			
			// complete the Quest
			quest_completed = true; 
			
			// get the quest point amount
			int quest_point_amount = calculatePoints(s); 
			
			// add quest_basepoints to s 
			s.addPoints(quest_point_amount); 
			
			// return the Quest basepoint amount 
			return quest_point_amount; 
		}
		
		// else the Quest was already completed so do not add more points 
		return 0; 
	}
	
	/**
	 * calculatePoints(Student s) calculates the amount of points the student should get depending on how much the Quest is worth
	 * @param s is the Student object completing the Quest
	 * @return an int of the amount of points the s earned 
	 */
	protected abstract int calculatePoints(Student s);
	
	/**
	 * toSring() 
	 * @returns a String with the object's status vairables ex. id, title, basepoints, and completed
	 */
	public String toString() {
		
		return "Quest id: " + quest_id + ", Title: " + quest_title + " BasePoints: " + quest_basepoints + ", Completed: " + quest_completed;
	}
} // end of AbstractQuest.java
