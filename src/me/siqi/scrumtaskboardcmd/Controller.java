package me.siqi.scrumtaskboardcmd;

/*-----------------------------------------------------------------------------
 * Author:       Siqi Wu
 * Created:      26/07/2015
 * Last updated: 27/07/2015
 * 
 * Integrated Research – Graduate/Intern Software Engineer Assignment
 * An Agile Scrum ‘Task Board’
 * 
 * Controller: handle user input and call Model
 * Support nine functions:
 *   create story <id> <description>
 *   list stories
 *   delete story <id>
 *   complete story <id>
 *   create task <storyId> <id> <description>
 *   list tasks <storyId>
 *   delete task <storyId> <id>
 *   move task <storyId> <id> <new column>
 *   update task <storyId> <id> <new description>
 *---------------------------------------------------------------------------*/

public class Controller {
  
  public Controller() {
  }
  
  /**
   * 
   * @param dataFactory
   *          Model part
   * @param cmd
   *          User input command
   * @return flag
   *          0 represents success, 1 means fail
   */
  public int executeCommand(DataFactory dataFactory, String cmd) {
    String[] cmdParse = cmd.split("\\s+");
    
    if (cmdParse.length < 2) {
      System.err.println("IGNORE: Invalid command!!!");
    }
    String cmdType = cmdParse[0].toUpperCase() + "_" + cmdParse[1].toUpperCase();
    
    if (cmdParse.length == 2) {
      if (cmdType.equals("LIST_STORIES")) {
        return dataFactory.listStories();
      } else {
        System.err.println("IGNORE: Invalid command! Do you want list stories?");
        return 1;
      }
    }
    
    String storyId = cmdParse[2];
    storyId= storyId.replaceFirst ("^0*", "");
    try {
      Integer.parseInt(storyId);
    } catch (NumberFormatException nfe) {
      System.err.println("IGNORE: Story ID should be a number!!!");
      return 1;
    }
    
    if (cmdParse.length == 3) {
      if (cmdType.equals("DELETE_STORY")) {
        return dataFactory.deleteStory(storyId);
      } else if (cmdType.equals("COMPLETE_STORY")) {
        return dataFactory.completeStory(storyId);
      } else if (cmdType.equals("LIST_TASKS")) {
        return dataFactory.listTasks(storyId);
      } else {
        System.err.println("IGNORE: Invalid command for DELETE_STORY, COMPLETE_STORY"
            + " or LIST_TASKS!!!");
        return 1;
      }
    }
    
    if (cmdType.equals("CREATE_STORY")) {
      if (cmdParse.length < 4) {
        System.err.println("IGNORE: Invalid command for CREATE_STORY!!!");
        return 1;
      } else {
        return dataFactory.createStory(storyId, cmd.split("\\s+", 4)[3]);
      }
    }
    
    String taskId = cmdParse[3];
    taskId= taskId.replaceFirst ("^0*", "");
    try {
      Integer.parseInt(taskId);
    } catch (NumberFormatException nfe) {
      System.err.println("IGNORE: Task ID should be a number!!!");
      return 1;
    }
    
    if (cmdType.equals("CREATE_TASK")) {
      if (cmdParse.length < 5) {
        System.err.println("IGNORE: Invalid command for CREATE_TASK!!!");
        return 1;
      } else {
        return dataFactory.createTask(storyId, taskId, cmd.split("\\s+", 5)[4]);
      }
    } else if (cmdType.equals("DELETE_TASK")) {
      if (cmdParse.length != 4) {
        System.err.println("IGNORE: Invalid command for DELETE_TASK!!!");
        return 1;
      } else {
        return dataFactory.deleteTask(storyId, taskId);
      }
    } else if (cmdType.equals("MOVE_TASK")) {
      if (cmdParse.length < 5) {
        System.err.println("IGNORE: Invalid command for MOVE_TASK!!!");
        return 1;
      } else {
        String newPhase = cmd.split("\\s+", 5)[4].toUpperCase();
        if (newPhase.equals("TO DO") || newPhase.equals("IN PROCESS")
            || newPhase.equals("TO VERIFY") || newPhase.equals("DONE")) {
          return dataFactory.moveTask(storyId, taskId, newPhase);
        }
        System.err.println("IGNORE: Invalid phase input for MOVE_TASK!!!");
        return 1;
      }
    } else if (cmdType.equals("UPDATE_TASK")) {
      if (cmdParse.length < 5) {
        System.err.println("IGNORE: Invalid command for UPDATE_TASK!!!");
        return 1;
      } else {
        return dataFactory.updateTask(storyId, taskId, cmd.split("\\s+", 5)[4]);
      }
    }
    
    return 1;
  }
  
}
