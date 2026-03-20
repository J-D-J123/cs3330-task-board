package taskboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Work for QuestBoard done by Tucker Potts
 * */
public class QuestBoard {
	private Map<Integer,Quest> questsById = new HashMap<>();
	private Map<Student, List<Quest>> assignments = new HashMap<>();

	/*
	* This method adds a quest and its id to the list of questsById and checks first to see if there
	* are any duplicate ids before it adds the quest.
	*/
	public void addQuest(Quest q){
		
		int id = q.getId();//just to make it a little cleaner for the fail-fast validation
		
		if(questsById.containsKey(id)) {//grabs any duplicate keys
			throw new IllegalArgumentException("That's a duplicate ID!");
		}
		
		questsById.put(id, q);//add the quest along with the ID key
		
	}
	/*
	* This method finds the quest through its id, returns null if there isn't a quest with that id.
	*/
	public Quest findQuest(int id) {
		
		if(!questsById.containsKey(id)) {//To check if there is no ID in the hash map
			return null;
		}
		
		return questsById.get(id);
	}
	
	/*
	 * Important: For the design choice with assignQuest, I decided that the same quest
	 * CANNOT be assigned the same student multiple times
	 *
	 * This method assigns a quest to a student by looking up that quest's id. Once it finds the quest id, it assigns
	 * that existing quest to the student and checks first to see if the student is being assigned the quest for the
	 * first time. 
	 * */
	public void assignQuest(Student s, int questId) {
		
		Quest q = questsById.get(questId);

		if(q == null){
			throw new IllegalArgumentException("There isn't a quest with that ID!");
		}
		
	    List<Quest> Quests = assignments.get(s);

		if(Quests == null){
			Quests = new ArrayList<>();
			assignments.put(s, Quests);
		}
	    if (Quests.contains(q)) {//open design choice: student can't do the same quest again
	    	throw new IllegalArgumentException("The student has already done this quest!");
	    }
	    
	    Quests.add(q);
	}
	/*
	* This method finds the quest that the student has completed and goes through the list of the assigned quests
	* to the student until the id matches the one that's given. It then calls the q.completeFor() polymorphically
	* and returns the awarded points.
	*/
	public int completeQuest(Student s, int questId) {
		
		List<Quest> Quests = assignments.get(s);

		if (Quests == null) {
			throw new IllegalArgumentException("Student doesn't have any assignments");
		}

		for (Quest q : Quests) {//goes through the array

			if (q.getId() == questId) {

				int points = q.completeFor(s);
				return points;//returns points of completed quest
			}
		}
		
		throw new IllegalArgumentException("There doesn't seem to be any quests...");
	}
	/*
	* This method prints all the quests that are currently available for the students.
	*/
	public void printAllQuests() {
		
		for(Quest q : questsById.values()) {
			System.out.println(q);//prints out each of the quests
		}
	}
	/*
	* This method prints all the assignments for a student by going through all the assigned quests the student has.
	*/
	public void printAssignmentsFor(Student s) {
		
		List<Quest> assignmentList = assignments.get(s);

		if (assignmentList == null || assignmentList.isEmpty()) {//to check if the list is empty
	    	System.out.println("No assignments for " + s);
	        return;
	    }

		for (Quest q : Quests) {
			System.out.println(q);//prints out each of the assignments
		}
	}
	/*
	* This method calculates the sum points of all the quests that the student has completed.
	*/
	public int getPoints(Student s){
		
		int totalPoints = 0;
		
		List<Quest> Quests = assignments.get(s);
			
		if (Quests == null || Quests.isEmpty()) {//another check to see if the list is empty
	        return 0;
	    }

		for(Quest q : Quests){
			if(q.isCompleted()){//to check if the quest is actually completed 
				totalPoints += q.getBasePoints();
			}
		}
		return totalPoints;
	}
}
