An Agile Scrum ‘Task Board’
==========================

Usage
-----
How to compile: ```cd [workspace]/scrumtaskboardcmd/src```

Compilation: ```javac me/siqi/scrumtaskboardcmd/*.java```

Execution: ```java me.siqi.scrumtaskboardcmd.MainProgram```

Test file: ```java me.siqi.scrumtaskboardcmd.MainProgramTest```

Explanation
-----------
Simple Java program, can run from cmd or Eclipse. Leverage MVC design pattern. Model is DataFactory class, Controller is is Controller class. Retrieve cmd from Scanner user input. Could write up an API doc but this program is simple enough to read from the program.

APIs
---
| Input  | Description |
| ------ | ----------- |
| create story \<id\> \<description\>  | Create a new user story with the given ID and description  |
| list stories  | List all user stories that have been created, including Id’s  |
| delete story \<id\>  | Delete the user story with the given ID  |
| complete story \<id\>  | Mark the user story with the given ID as completed  |
| create task \<storyId\> \<id\> \<description\>  | Create a new task with the given task ID and description, and associate it with the given storyId  |
| list tasks \<storyId\>  | List all the tasks associated with the given storyId  |
| delete task \<storyId\> \<id\>  | Deletes the task with the given ID associated with the given storyId  |
| move task \<storyId\> \<id\> \<new column\>  | Move the task to the new column (To Do, In Process, etc)  |
| update task \<storyId\> \<id\> \<new description\>  | Update/Modify a task’s description  |
