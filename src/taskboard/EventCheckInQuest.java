package taskboard;

/**
 * Author: Joey Johnson
 * Date:	 3/16/2026
 * File: EventCheckInQuest.java
 * Desc:
 * A student completes this by checking in at an event
 * Required data: 
 * 		- String eventName (not null/ blank)
 * Completion rule: 
 * 		- awards exactly basePoints
 */

public class EventCheckInQuest extends AbstractQuest {

	private String event_name; 
	
	/**
	 * EventCheckInQuest(...) checks in the 
	 * @param id is the id of the quest
	 * @param title the title of the quest
	 * @param basepoints the amount of points it is
	 * @param eventName the event title
	 */
	public EventCheckInQuest(int id, String title, int basepoints, String eventName) {
	
		// call AbstractQuest consturctor to set up Quest 
		super(id, title, basepoints); 
		
		// check if eventName is null or blank if so throw an Illegal Argument 
		if (eventName == null || eventName.isBlank()) {
			
			throw new IllegalArgumentException("eventName cannot be null or blank :)");
		}
		
		event_name = eventName; 
	}
	
	@Override 
	/**
	 * calculatePoints(Student s) 
	 * @param s is the specific student that finished the Task
	 * @return int of the amount of points that Student got
	 */
	protected int calculatePoints(Student s) {
		
		return getBasePoints(); 
	}
}
