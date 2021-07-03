/**
 * Program to set the correct module grade.
 * 
 * 
 */

import java.util.Scanner;

public class ModuleGrader_Y3871821 {
	
	//variable to hold the module mark
	private int moduleMark;
	
	//method that takes a mark and returns a grade
	public String gradeModule(int mark) {
		
		//variable holding the grade value
		String grade;
		
		//check the mark and assign the appropriate grade 
		if(mark <= 100 && mark >= 70) {
			grade = "Excellent";
		}
		else if(mark <= 69 && mark >= 60) {
			grade = "Good";
		}
		else if(mark <=59 && mark >= 50) {
			grade = "Satisfactory";
		}
		else if(mark <=49 && mark >= 40) {
			grade = "Compensatable fail";
		}
		else {
			grade = "Outright fail";
		}
		
		//return the grade
		return grade;
	}
	
	//method that prompts the user for a valid mark in the range 0-100
	public void getValidModuleMark() {
		
		//create new scanner object
		Scanner sc = new Scanner(System.in);
		
		//prompt the user for input
		System.out.print("Enter your module mark: ");
		moduleMark = sc.nextInt();
		
		//re-prompt the user if the input was invalid
		while(moduleMark < 0 || moduleMark > 100) {
			System.out.print("Enter a valid mark between 0 and 100: ");
			moduleMark = sc.nextInt();
		}
		
	}
	
	//method to display grade
	public void startModuleGrading() {
		char input;
		do {
			//get a valid mark and display the grade
			System.out.println("*********** Module Grading Program ***********");
			getValidModuleMark();
			System.out.println(gradeModule(moduleMark));
		
			Scanner sc = new Scanner(System.in);
			//check if the user would like to continue grading
			System.out.print("Would you like to continue grading?(Enter Y/N):  ");
			input = sc.next().charAt(0);
			System.out.println();
		} while (input == 'y' || input == 'Y');
		
	}

}
