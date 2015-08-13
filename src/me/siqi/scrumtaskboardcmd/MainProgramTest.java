package me.siqi.scrumtaskboardcmd;

import me.siqi.scrumtaskboardcmd.Controller;
import me.siqi.scrumtaskboardcmd.DataFactory;

/*-----------------------------------------------------------------------------
 * Author:       Siqi Wu
 * Created:      26/07/2015
 * Last updated: 27/07/2015
 * 
 * How to compile: cd [workspace]/scrumtaskboardcmd/src
 * Compilation:  javac me/siqi/scrumtaskboardcmd/*.java
 * Execution:    java me.siqi.scrumtaskboardcmd.MainProgramTest
 * 
 * Integrated Research – Graduate/Intern Software Engineer Assignment
 * An Agile Scrum ‘Task Board’
 * 
 * Test program of the Scrum Task Board
 *---------------------------------------------------------------------------*/

public class MainProgramTest {
  
  public static void main(String[] args) throws InterruptedException {
    DataFactory dataFactory = new DataFactory();
    Controller controller = new Controller();
    
    System.out.println("--------------------------------------------");
    
    System.out.println("** Test create story: singleton text **");
    controller.executeCommand(dataFactory, "create story 1 singleton");
    controller.executeCommand(dataFactory, "list stories");
    Thread.sleep(10);
    System.out.println("--------------------------------------------");
    
    System.out.println("** Test create story: texts with empty spaces **");
    controller.executeCommand(dataFactory, "create story 3 multiple words");
    controller.executeCommand(dataFactory, "list stories");
    Thread.sleep(10);
    System.out.println("--------------------------------------------");
    
    System.out.println("** Test create story: texts with quotes **");
    controller.executeCommand(dataFactory, "create story 6 \"what about quotes?\"");
    controller.executeCommand(dataFactory, "list stories");
    Thread.sleep(10);
    System.out.println("--------------------------------------------");
    
    System.out.println("** Test create story: story id starts unnecessary zeros **");
    controller.executeCommand(dataFactory, "create story 002 2 digits id?");
    controller.executeCommand(dataFactory, "list stories");
    Thread.sleep(10);
    System.out.println("--------------------------------------------");
    
    System.out.println("** Test create story: invalid, non-number story id, not allow! **");
    controller.executeCommand(dataFactory, "create story str non-number storyid");
//    controller.executeCommand(dataFactory, "list stories");
    Thread.sleep(10);
    System.out.println("--------------------------------------------");
    
    System.out.println("** Test create story: invalid, duplicate story id, not allow! **");
    controller.executeCommand(dataFactory, "create story 3 storyid collison");
//    controller.executeCommand(dataFactory, "list stories");
    Thread.sleep(10);
    System.out.println("--------------------------------------------");
    
    System.out.println("** Test delete story: delete story 1 **");
    controller.executeCommand(dataFactory, "delete story 1");
    controller.executeCommand(dataFactory, "list stories");
    Thread.sleep(10);
    System.out.println("--------------------------------------------");
    
    System.out.println("** Test delete story: invalid, delete story 1, non-exist **");
    controller.executeCommand(dataFactory, "delete story 1");
//    controller.executeCommand(dataFactory, "list stories");
    Thread.sleep(10);
    System.out.println("--------------------------------------------");
    
    System.out.println("** Test complete story: not showing completed story 3 **");
    controller.executeCommand(dataFactory, "complete story 3");
    controller.executeCommand(dataFactory, "list stories");
    Thread.sleep(10);
    System.out.println("--------------------------------------------");
    
    System.out.println("");
    System.out.println("Story model test DONE!");
    System.out.println("Now start to test Task model!");
    Thread.sleep(10);
    System.out.println("--------------------------------------------");
    System.out.println("");
    
    System.out.println("** Test create task: create task singleton **");
    controller.executeCommand(dataFactory, "create task 6 01 newtask");
    controller.executeCommand(dataFactory, "list tasks 6");
    Thread.sleep(10);
    System.out.println("--------------------------------------------");
    
    System.out.println("** Test create task: create task multiple lines **");
    controller.executeCommand(dataFactory, "create task 6 3 multiple lines");
    controller.executeCommand(dataFactory, "list tasks 6");
    Thread.sleep(10);
    System.out.println("--------------------------------------------");
    
    System.out.println("** Test create task: create task texts with quotes **");
    controller.executeCommand(dataFactory, "create task 6 6 \"now I have quotes\"");
    controller.executeCommand(dataFactory, "list tasks 6");
    Thread.sleep(10);
    System.out.println("--------------------------------------------");
    
    System.out.println("** Test delete task: delete task function **");
    controller.executeCommand(dataFactory, "delete task 6 3");
    controller.executeCommand(dataFactory, "list tasks 6");
    Thread.sleep(10);
    System.out.println("--------------------------------------------");
    
    System.out.println("** Test delete task: invalid, non-exist story id **");
    controller.executeCommand(dataFactory, "delete task 9 3");
    Thread.sleep(10);
    System.out.println("--------------------------------------------");
    
    System.out.println("** Test delete task: invalid, non-exist task id **");
    controller.executeCommand(dataFactory, "delete task 6 3");
//    controller.executeCommand(dataFactory, "list tasks 6");
    Thread.sleep(10);
    System.out.println("--------------------------------------------");
    
    System.out.println("** Test move task: TODO to INPROCESS **");
    controller.executeCommand(dataFactory, "move task 6 1 in process");
    controller.executeCommand(dataFactory, "list tasks 6");
    Thread.sleep(10);
    System.out.println("--------------------------------------------");
    
    System.out.println("** Test move task: INPROCESS to TOVERIFY **");
    controller.executeCommand(dataFactory, "move task 6 1 To Verify");
    controller.executeCommand(dataFactory, "list tasks 6");
    Thread.sleep(10);
    System.out.println("--------------------------------------------");
    
    System.out.println("** Test move task: TOVERIFY to DONE **");
    controller.executeCommand(dataFactory, "move task 6 1 DONE");
    controller.executeCommand(dataFactory, "list tasks 6");
    Thread.sleep(10);
    System.out.println("--------------------------------------------");
    
    System.out.println("** Test move task: invalid, two steps **");
    controller.executeCommand(dataFactory, "move task 6 6 To Verify");
//    controller.executeCommand(dataFactory, "list tasks 6");
    Thread.sleep(10);
    System.out.println("--------------------------------------------");
    
    System.out.println("** Test move task: invalid, can not go from DONE **");
    controller.executeCommand(dataFactory, "move task 6 1 To Verify");
//    controller.executeCommand(dataFactory, "list tasks 6");
    Thread.sleep(10);
    System.out.println("--------------------------------------------");
    
    System.out.println("** Test move task: move task function, TODO to INPROCESS **");
    controller.executeCommand(dataFactory, "move task 6 6 in process");
    controller.executeCommand(dataFactory, "list tasks 6");
    Thread.sleep(10);
    System.out.println("--------------------------------------------");
    
    System.out.println("** Test move task: move task function, INPROCESS to TODO **");
    controller.executeCommand(dataFactory, "move task 6 6 to do");
    controller.executeCommand(dataFactory, "list tasks 6");
    Thread.sleep(10);
    System.out.println("--------------------------------------------");
    
    System.out.println("** Test update task: update task function **");
    controller.executeCommand(dataFactory, "update task 6 6 \"this is a new description\"");
    controller.executeCommand(dataFactory, "list tasks 6");
    Thread.sleep(10);
    System.out.println("--------------------------------------------");
    
    System.out.println("** Test update task: can update done task **");
    controller.executeCommand(dataFactory, "update task 6 1 changed a done task");
    controller.executeCommand(dataFactory, "list tasks 6");
    Thread.sleep(10);
    System.out.println("--------------------------------------------");
    
    System.out.println("** Test update task: invalid, can not complete story with undone stuff **");
    controller.executeCommand(dataFactory, "complete story 6");
//    controller.executeCommand(dataFactory, "list stories");
    Thread.sleep(10);
    System.out.println("--------------------------------------------");
    
    System.out.println("** Test update task: invalid, can not update done story **");
    controller.executeCommand(dataFactory, "delete task 6 6");
    controller.executeCommand(dataFactory, "complete story 6");
//    controller.executeCommand(dataFactory, "list stories");
    controller.executeCommand(dataFactory, "update task 6 1 can not change a done story");
//    controller.executeCommand(dataFactory, "list tasks 6");
    Thread.sleep(10);
    System.out.println("--------------------------------------------");
    
  }
    
}
