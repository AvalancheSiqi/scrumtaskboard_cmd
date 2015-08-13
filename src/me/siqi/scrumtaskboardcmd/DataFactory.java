package me.siqi.scrumtaskboardcmd;

import java.util.Iterator;
import java.util.TreeMap;

/*-----------------------------------------------------------------------------
 * Author:       Siqi Wu
 * Created:      26/07/2015
 * Last updated: 27/07/2015
 * 
 * Integrated Research – Graduate/Intern Software Engineer Assignment
 * An Agile Scrum ‘Task Board’
 * 
 * Model: program main logic are defined here
 * Use TreeMap data structure to support fast look up of stories
 *---------------------------------------------------------------------------*/

public class DataFactory {
  
  private TreeMap<String, Story> storyMap;
  
  public DataFactory() {
    storyMap = new TreeMap<String, Story>();
  }
  
  public int createStory(String storyId, String storyDesc) {
    if (storyMap.containsKey(storyId)) {
      System.err.println("IGNORED: Not Allowed! Story ID already exists.");
      return 1;
    }
    storyMap.put(storyId, new Story(storyId, storyDesc));
    return 0;
  }
  
  public int listStories() {
    Iterator<Story> iter = storyMap.values().iterator();
    while (iter.hasNext()) {
      Story story = iter.next();
      if (!story.isDone()) {
        System.out.println(story.toString());
      }
    }
    return 0;
  }
  
  public int deleteStory(String storyId) {
    if (storyMap.containsKey(storyId)) {
      storyMap.remove(storyId);
      return 0;
    }
    System.err.println("IGNORED: Story ID not exists.");
    return 1;
  }
  
  public int completeStory(String storyId) {
    if (storyMap.containsKey(storyId)) {
      if (storyMap.get(storyId).completeStory() == 0) {
        return 0;
      }
    }
    System.err.println("IGNORED: Can not complete story with undone stuff");
    return 1;
  }
  
  public int createTask(String storyId, String taskId, String taskDesc) {
    if (storyMap.containsKey(storyId)) {
      storyMap.get(storyId).getTasks("TO DO").put(taskId, new Task(storyId, taskId, taskDesc));
    } else {
      createStory(storyId, null);
      createTask(storyId, taskId, taskDesc);
    }
    return 0;
  }
  
  public int listTasks(String storyId) {
    if (storyMap.containsKey(storyId)) {
      Story story = storyMap.get(storyId);
      System.out.println(story.listTasks());
      return 0;
    }
    return 1;
  }
  
  public int deleteTask(String storyId, String taskId) {
    if (storyMap.containsKey(storyId)) {
      return storyMap.get(storyId).deleteTask(taskId);
    }
    System.err.println("IGNORED: Story ID not exists.");
    return 1;
  }
  
  public int moveTask(String storyId, String taskId, String newColumn) {
    if (storyMap.containsKey(storyId)) {
      Story story = storyMap.get(storyId);
      if (story.isDone()) {
        System.err.println("IGNORED: Can not edit done story");
        return 1;
      }
      return story.moveTask(taskId, newColumn);
    }
    return 1;
  }
  
  public int updateTask(String storyId, String taskId, String newTaskDesc) {
    if (storyMap.containsKey(storyId)) {
      Story story = storyMap.get(storyId);
      if (story.isDone()) {
        System.err.println("IGNORED: Can not edit done story");
        return 1;
      }
      return story.updateTask(taskId, newTaskDesc);
    }
    return 1;
  }
  
}
