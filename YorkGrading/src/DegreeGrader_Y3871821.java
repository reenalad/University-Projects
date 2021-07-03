/**
 * Program to set the degree classification
 * 
 */

import java.util.Scanner;


public class DegreeGrader_Y3871821 {

	//variables to hold each mark
	private int moduleAverage;
	private int ismAverage;
	private int compFailedCredits;
	private int outFailedModule;
	
	//method that returns the degree classification
	public String gradeDegree(int avg, int ismAvg, int compFail, int outFail) {
		String classification;
		
		if ((avg >= 70) && (ismAvg >= 70) && (compFail == 0) && (outFail == 0)) {
			classification = "Distinction";
		}
		else if ((avg >= 60) && (ismAvg >= 60) && (compFail <= 20) && (outFail == 0)) {
			classification = "Merit";
		}
		else if ((avg >= 50) && (ismAvg >= 50) && (compFail <= 40) && (outFail == 0)) {
			classification = "Pass";
		}
		else {
			classification = "Fail";
		}
		
		return classification;
	}
	
	//method that prompts the user for a valid mark for the modules
	public void getModuleAverage() {
			
		//create new scanner object
		Scanner sc = new Scanner(System.in);
			
		//prompt the user for input
		System.out.print("Enter your module average: ");
		moduleAverage = sc.nextInt();
			
		//re-prompt if input is not valid
		while(moduleAverage < 0 || moduleAverage > 100) {
			System.out.print("Enter a valid mark between 0 and 100: ");
			moduleAverage = sc.nextInt();
		}
			
	}
	
	//method that prompts for valid ism average mark
	public void getIsmAverage() {
		
		//create new scanner object
		Scanner sc = new Scanner(System.in);
			
		//prompt the user for input
		System.out.print("Enter your ISM module average: ");
		ismAverage = sc.nextInt();
		
		//re-prompt if input is not valid
		while(ismAverage < 0 || ismAverage > 100) {
			System.out.print("Enter a valid mark between 0 and 100: ");
			ismAverage = sc.nextInt();
		}
			
	}
	
	//method that prompts for number of failed credits
	public void getCompFailCredits() {
		
		//create new scanner object
		Scanner sc = new Scanner(System.in);
			
		//prompt the user for input
		System.out.print("Enter the number of compensatable failed credits: ");
		compFailedCredits = sc.nextInt();
			
		//re-prompt if input is not valid
		while(compFailedCredits < 0 || compFailedCredits > 180) {
			System.out.print("Enter a valid mark between 0 and 180: ");
			compFailedCredits = sc.nextInt();
		}
			
	}
	
	//method that prompts for number of failed modules
	public void getFailedModules() {
		
		//create new scanner object
		Scanner sc = new Scanner(System.in);
			
		//prompt the user for input
		System.out.print("Enter the number of failed modules: ");
		outFailedModule = sc.nextInt();
			
		//re-prompt if input is not valid
		while(outFailedModule < 0 || outFailedModule > 11) {
			System.out.print("Enter a valid mark between 0 and 11: ");
			outFailedModule = sc.nextInt();
		}
			
	}
	
	//method to display grade
		public void startDegreeGrading() {
			char input;
			do {
				//get a valid mark and display the degree classification
				System.out.println("*********** Degree Classification Program ***********");
				getModuleAverage();
				getIsmAverage();
				getCompFailCredits();
				getFailedModules();
				System.out.println(gradeDegree(moduleAverage, ismAverage, compFailedCredits, outFailedModule));
			
				Scanner sc = new Scanner(System.in);
				//check if the user would like to continue grading
				System.out.print("Would you like to continue grading?(Enter Y/N):  ");
				input = sc.next().charAt(0);
				System.out.println();
			} while (input == 'y' || input == 'Y');
			
		}
}
