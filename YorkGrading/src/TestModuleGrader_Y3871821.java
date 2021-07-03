/**
 * Program to test the ModuleGrader methods.
 * 
 * 
 */

public class TestModuleGrader_Y3871821 {

	public static void main(String[] args) {
		
		//create a new ModuleGrader object
		ModuleGrader_Y3871821 grader = new ModuleGrader_Y3871821();
		
		//test the methods
		System.out.println(grader.gradeModule(50));
		System.out.println(grader.gradeModule(63));
		System.out.println(grader.gradeModule(74));
		System.out.println(grader.gradeModule(43));
		System.out.println(grader.gradeModule(99));
		System.out.println(grader.gradeModule(23));
		
		grader.getValidModuleMark();
		
		
		grader.startModuleGrading();
	}
	
}
