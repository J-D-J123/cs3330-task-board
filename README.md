# cs3330-task-board

Campus Quest: A Polymorphic Task Board
CMP_SC/INFOTC 3330 - Programming Assignment 2
Spring 2026

===== Team Members and Parts Implemented =====

Joey Johnson (Core Quest Hierarchy)
  - Quest.java, AbstractQuest.java, EventCheckInQuest.java, VolunteerQuest.java, StreakQuest.java

Tucker Potts (Board & Student Model)
  - Student.java, QuestBoard.java

Jack Belleville (Utilities & Main Demo)
  - RewardUtil.java, Main.java, README.txt, screenshots

===== Design Choices =====

1. Can a quest be completed more than once?
   No, completeFor() returns 0 if already completed.

2. Can the same quest be assigned to the same student multiple times?
   No, assignQuest() throws IllegalArgumentException if the quest is already assigned.

3. StreakQuest scoring rule:
   Linear bonus: basePoints + (days * 2).