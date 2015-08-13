package me.siqi.scrumtaskboardcmd;

import java.util.Scanner;

/*-----------------------------------------------------------------------------
 * Author:       Siqi Wu
 * Created:      26/07/2015
 * Last updated: 27/07/2015
 * 
 * How to compile: cd [workspace]/scrumtaskboardcmd/src
 * Compilation:  javac me/siqi/scrumtaskboardcmd/*.java
 * Execution:    java me.siqi.scrumtaskboardcmd.MainProgram
 * 
 * Integrated Research – Graduate/Intern Software Engineer Assignment
 * An Agile Scrum ‘Task Board’
 * 
 * Main entry program, leverage MVC design pattern
 * Model is class DataFactory
 * Controller is is class Controller
 * Retrieve cmd from Scanner user input
 *---------------------------------------------------------------------------*/

public class MainProgram {
  
  public static void main(String[] args) {
    DataFactory dataFactory = new DataFactory();
    Controller controller = new Controller();
    
    Scanner scan = new Scanner(System.in);
    while (scan.hasNextLine()) {
      String cmd = scan.nextLine();
      if (cmd.trim().length() > 0) {
        controller.executeCommand(dataFactory, cmd);
      }
    }
  }

}
