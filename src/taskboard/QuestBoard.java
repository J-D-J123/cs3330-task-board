package taskboard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Work for QuestBoard done by Tucker Potts
 * */
public class QuestBoard {
	private Map<Integer,Quest> questsById = new HashMap<>();
	private Map<Student, List<Quest>> assignments = new HashMap<>();
	
	public void addQuest(Quest q){
		
		int id = q.getId();//just to make it a little cleaner for the fail-fast validation
		
		if(questsById.containsKey(id)) {//grabs any duplicate keys
			throw new IllegalArgumentException("That's a duplicate ID!");
		}
		
		questsById.put(id, q);//add the quest along with the ID key
		
	}
	
	public Quest findQuest(int id) {
		
		if(!questsById.containsKey(id)) {//To check if there is no ID in the hash map
			throw new IllegalArgumentException("There is no quest with that ID"); 
		}
		
		return questsById.get(id);
	}
	
	/*
	 * Important: For the design choice with assignQuest, I decided that the same quest
	 * CANNOT be assigned the same student multiple times
	 * */
	public void assignQuest(Student s, int questId) {
		
		Quest q = questsById.get(questId);

		if (q == null) {
	    	throw new IllegalArgumentException("Alas, there is no quest...");
	    }

	    List<Quest> Quests = assignments.get(s);

	    if (Quests.contains(q)) {//open design choice: student can't do the same quest again
	    	throw new IllegalArgumentException("The student has already done this quest!");
	    }
	    
	    Quests.add(q);
	}
	
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
	
	public void printAllQuests() {
		
		for(Quest q : questsById.values()) {
			System.out.println(q);//prints out each of the quests
		}
	}
	
	public void printAssignmentsFor(Student s) {
		
		List<Quest> Quests = assignments.get(s);

		if (Quests == null || Quests.isEmpty()) {//to check if the list is empty
	    	System.out.println("No asignment for " + s);
	        return;
	    }

		for (Quest q : Quests) {
			System.out.println(q);//prints out each of the assignments
		}
	}
}
