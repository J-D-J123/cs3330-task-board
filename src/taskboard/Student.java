package taskboard;
/*Work for Student done by Tucker Potts
 * */

import java.util.Objects;

public class Student {
	private String name;
	private int points = 0;// need to be > 0

	/*
	* constructor to get the name of the student.
	*/
	public Student(String name) {
		if(name == null || name.isBlank()) {//enforcing invariants here
			throw new IllegalArgumentException("You're going to have to re-enter that name");
		}
		this.name = name;
	}
	/*
	* This method adds points to the student. The points can't be negative or zero.
	*/
	public void addPoints(int amount) {
		if(amount <= 0) {//need to enforce fail fast validation
			throw new IllegalArgumentException("We're trying to ADD points here!");
		}
		points += amount;
	}
	/*
	* Pretty simple, just a getter for the points of the students
	*/
	public int getPoints(){
		return points;
	}
	
	@Override
	public String toString() {//toString to list student name and points
		return "Student name:" + name + ", student points:" + points;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(name, other.name);
	}
	
}
