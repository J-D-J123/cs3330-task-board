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
	public AbstractQuest(int id, String name, int basepoints, boolean completed) {
	
		// fail fast condition where 
		// id > 0 name cannot be null or blank and basepoints > 0 = make object
		if (id > 0 && ((name != null) || (!name.isBlank())) && (basepoints > 0)) {
			quest_id = id; 
			quest_title = name; 
			quest_basepoints = basepoints; 
			quest_completed = completed; 
		}
	}
	
	// use Quest Interface here... 
}
