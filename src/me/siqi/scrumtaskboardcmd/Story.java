package me.siqi.scrumtaskboardcmd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*-----------------------------------------------------------------------------
 * Author:       Siqi Wu
 * Created:      26/07/2015
 * Last updated: 27/07/2015
 * 
 * Integrated Research – Graduate/Intern Software Engineer Assignment
 * An Agile Scrum ‘Task Board’
 * 
 * Model helper: Story class, define properties and functions of story object
 * Use 4 TreeMap to represent 4 different phases
 *---------------------------------------------------------------------------*/

public class Story {
  
  public static final Map<String, Integer> typeCast = createCasting();
  
  public static Map<String, Integer> createCasting() {
    Map<String, Integer> result = new HashMap<String, Integer>();
    result.put("TO DO", 0);
    result.put("IN PROCESS", 1);
    result.put("TO VERIFY", 2);
    result.put("DONE", 3);
    return Collections.unmodifiableMap(result);
  }
  
  private String storyId;
  private String storyDesc;
  private boolean isDone;
  private TreeMap<String, Task> toDoTasks;
  private TreeMap<String, Task> inProcessTasks;
  private TreeMap<String, Task> toVerifyTasks;
  private TreeMap<String, Task> doneTasks;
  private List<TreeMap<String, Task>> variableList;
  
  public Story(String storyId, String storyDesc) {
    this.storyId = storyId;
    this.storyDesc = storyDesc;
    this.isDone = false;
    this.toDoTasks = new TreeMap<String, Task>();
    this.inProcessTasks = new TreeMap<String, Task>();
    this.toVerifyTasks = new TreeMap<String, Task>();
    this.doneTasks = new TreeMap<String, Task>();
    this.variableList = new ArrayList<TreeMap<String, Task>>();
    variableList.add(toDoTasks);
    variableList.add(inProcessTasks);
    variableList.add(toVerifyTasks);
    variableList.add(doneTasks);
  }
  
  public String getStoryId() {
    return storyId;
  }
  
  public boolean isDone() {
    return isDone;
  }
  
  public TreeMap<String, Task> getTasks(String type) {
    return variableList.get(typeCast.get(type));
  }
  
  public String listTasks() {
    String res = this.toString() + "\n";
    res += listTasks("TO DO");
    res += listTasks("IN PROCESS");
    res += listTasks("TO VERIFY");
    res += listTasks("DONE");
    return res;
  }
  
  public String listTasks(String type) {
    String res = "--" + type + " Task: \n";
    Iterator<Task> iterator = getTasks(type).values().iterator();
    while (iterator.hasNext()) {
      res += "    " + iterator.next().toString() + "\n";
    }
    return res;
  }
  
  public TreeMap<String, Task> getAllTasks() {
    TreeMap<String, Task> allTasks = new TreeMap<String, Task>();
    allTasks.putAll(toDoTasks);
    allTasks.putAll(inProcessTasks);
    allTasks.putAll(toVerifyTasks);
    allTasks.putAll(doneTasks);
    return allTasks;
  }
  
  public int completeStory() {
    if (toDoTasks.isEmpty() && inProcessTasks.isEmpty() && toVerifyTasks.isEmpty()) {
      this.isDone = true;
      return 0;
    }
    return 1;
  }
  
  public int deleteTask(String taskId) {
    TreeMap<String, Task> allTasks = getAllTasks();
    if (allTasks.containsKey(taskId)) {
      String phase = allTasks.get(taskId).getPhase();
      int variableId = typeCast.get(phase);
      variableList.get(variableId).remove(taskId);
      return 0;
    }
    System.err.println("Task ID not exists in story.");
    return 1;
  }
  
  public int moveTask(String taskId, String newColumn) {
    TreeMap<String, Task> allTasks = getAllTasks();
    if (allTasks.containsKey(taskId)) {
      String phase = allTasks.get(taskId).getPhase();
      int oldVariableId = typeCast.get(phase);
      int newVariableId = typeCast.get(newColumn);
      if (oldVariableId+1 == newVariableId || newVariableId == 0
          || (oldVariableId != 3 && newVariableId <= oldVariableId)) {
        Task task = variableList.get(oldVariableId).remove(taskId);
        variableList.get(newVariableId).put(taskId, task);
        task.setPhase(newColumn);
        return 0;
      }
      System.err.println("IGNORED: Invalid move!!!");
      return 1;
    }
    return 1;
  }
  
  public int updateTask(String taskId, String taskDesc) {
    TreeMap<String, Task> allTasks = getAllTasks();
    if (allTasks.containsKey(taskId)) {
      String phase = allTasks.get(taskId).getPhase();
      int variableId = typeCast.get(phase);
      variableList.get(variableId).get(taskId).setTaskDesc(taskDesc);
      return 0;
    }
    return 1;
  }

  public String toString() {
    return storyId + " | " + storyDesc;
  }
  
}
