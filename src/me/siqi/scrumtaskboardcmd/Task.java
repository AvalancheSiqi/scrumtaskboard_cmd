package me.siqi.scrumtaskboardcmd;

/*-----------------------------------------------------------------------------
 * Author:       Siqi Wu
 * Created:      26/07/2015
 * Last updated: 27/07/2015
 * 
 * Integrated Research – Graduate/Intern Software Engineer Assignment
 * An Agile Scrum ‘Task Board’
 * 
 * Model helper: Task class, define properties and functions of task object
 * Few properties, add phase property to assist Story class
 *---------------------------------------------------------------------------*/

public class Task {
  
  private String storyId;
  private String taskId;
  private String taskDesc;
  private String phase;
  
  public Task(String storyId, String taskId, String taskDesc) {
    this.storyId = storyId;
    this.taskId = taskId;
    this.taskDesc = taskDesc;
    this.phase = "TO DO";
  }
  
  public String getPhase() {
    return phase;
  }
  
  public void setPhase(String phase) {
    this.phase = phase;
  }
  
  public void setTaskDesc(String taskDesc) {
    this.taskDesc = taskDesc;
  }
  
  public String toString() {
    return taskId + " | " + taskDesc;
  }
  
}
