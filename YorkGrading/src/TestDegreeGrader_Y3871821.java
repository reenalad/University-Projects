/**
 * Program to test the DegreeGrader methods.
 * 
 * 
 */

public class TestDegreeGrader_Y3871821 {

	public static void main(String[] args) {
		//create a new DegreeGrader object
		DegreeGrader_Y3871821 degreeGrader = new DegreeGrader_Y3871821();
				
		//test the methods
		System.out.println(degreeGrader.gradeDegree(78, 53, 0, 0));
		System.out.println(degreeGrader.gradeDegree(85, 73, 20, 0));
		System.out.println(degreeGrader.gradeDegree(36, 48, 5, 0));
		System.out.println(degreeGrader.gradeDegree(50, 57, 0, 1));
		System.out.println(degreeGrader.gradeDegree(52, 53, 42, 0));
		System.out.println(degreeGrader.gradeDegree(72, 80, 0, 0));
		
		degreeGrader.getModuleAverage();
		degreeGrader.getIsmAverage();
		degreeGrader.getCompFailCredits();
		degreeGrader.getFailedModules();
		
		degreeGrader.startDegreeGrading();
		
	}

	
}


