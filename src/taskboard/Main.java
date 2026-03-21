package taskboard;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) {
		//Create 3 students
		Student s1 = new Student("Jack");
		Student s2 = new Student("Joey");
		Student s3 = new Student("Tucker");
		Student s4 = new Student("Jack");
		
		//Create 6 quests
		Quest q1 = new EventCheckInQuest(1, "Basketball Game Check-In", 5, "Basketball Game");
		Quest q2 = new EventCheckInQuest(2, "Art Exhibit Check-In", 5, "Art Exhibit");
		
		Quest q3 = new VolunteerQuest(3, "Pick Up Trash", 20, 4);
		Quest q4 = new VolunteerQuest(4, "Event Staff", 20, 2);
		
		Quest q5 = new StreakQuest(5, "Class Attendence", 2, 5);
		Quest q6 = new StreakQuest(6, "Good Grades", 5, 5);
		
		//Create QuestBoard
		QuestBoard board = new QuestBoard();
		//Add all quests
		board.addQuest(q1);
		board.addQuest(q2);
		board.addQuest(q3);
		board.addQuest(q4);
		board.addQuest(q5);
		board.addQuest(q6);
		
		//Assign at least 4 quests across at least 2 students
		board.assignQuest(s2, 1);
		board.assignQuest(s1, 2);
		board.assignQuest(s1, 3);
		board.assignQuest(s1, 5);
		
		//Complete at least 3 quests across different quest types
//		board.completeQuest(s4, 5);
		board.completeQuest(s2, 1);
		board.completeQuest(s1, 3);
		board.completeQuest(s1, 5);
		
		//Print all quests, assignments for each student, final student point totals, and the total points across students using RewardUtil.sumPoints
		System.out.println("\n===== All Quests =====");
		board.printAllQuests();
		
		System.out.println("\n===== Assignments =====");
		board.printAssignmentsFor(s1);
		board.printAssignmentsFor(s2);
		board.printAssignmentsFor(s3);
//		board.printAssignmentsFor(s4);
		
		System.out.println("\n===== Student Totals =====");
		List<Student> studentList = new ArrayList<>();
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
//		studentList.add(s4);
		RewardUtil.printAll(studentList);
		
		System.out.println("\nTotal Points Across All Students: " + RewardUtil.sumPoints(studentList));
		
		//HashSet demo (s4 should be equal to s1, meaning it should only add "Jack" once here)
		System.out.println("\n===== HashSet Demo =====");
		HashSet<Student> studentSet = new HashSet<>();
		studentSet.add(s1);
		studentSet.add(s2);
		studentSet.add(s3);
		studentSet.add(s4);
		System.out.println("Added 4 students (one duplicate), set size: " + studentSet.size());
		
		//Fail fast test (Should not be able to add the same quest twice)
		System.out.println("\n===== HashSet Test =====");
		board.addQuest(q1);
	}
}
