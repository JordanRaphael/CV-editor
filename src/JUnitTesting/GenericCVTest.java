package JUnitTesting;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import CVConstruction.EducationAndTraining;
import CVConstruction.FurtherCourses;
import CVConstruction.GenericCV;

public class GenericCVTest {

	@Test
	public void generalInformationTest(){
		GenericCV tester = new GenericCV();
		
		tester.generalInformationSaveFields("Argi", "Papanoutsou", "25210", "6906", "argi@cs.com");
		assertEquals("Argi", tester.getGeneralInformationName());
		assertEquals("Papanoutsou", tester.getGeneralInformationAddress());
		assertEquals("25210", tester.getGeneralInformationHomeTelephone());
		assertEquals("6906", tester.getGeneralInformationMobileTelephone());
		assertEquals("argi@cs.com", tester.getGeneralInformationEmail());
	}
	
	@Test
	public void professionalProfileTest(){
		GenericCV tester = new GenericCV();
		
		tester.professionalProfileSaveFields("This is professional's profile test paragraph!");
		assertEquals("This is professional's profile test paragraph!", tester.getProfessionalProfileParagraph());
	}
	
	@Test
	public void educationAndTrainingTest(){
		GenericCV tester = new GenericCV();
		
		ArrayList<EducationAndTraining> testArray = new ArrayList<EducationAndTraining>();
		EducationAndTraining testObj1 = new EducationAndTraining();
		EducationAndTraining testObj2 = new EducationAndTraining();
		testObj1.saveFields("qualification2", "establishment2", "location2", "2/2/2");
		testObj2.saveFields("qualification1", "establishment1", "location1", "1/1/1");
		testArray.add(testObj1);
		testArray.add(testObj2);
		
		tester.educationAndTrainingSaveFields("qualification2", "establishment2", "location2", "2/2/2");
		tester.educationAndTrainingSaveFields("qualification1", "establishment1", "location1", "1/1/1");
		
		assertEquals(testArray, tester.getEducationAndTrainingObjects());
		
	}
	
	@Test
	public void updateEducationAndTrainingTest(){
		GenericCV tester = new GenericCV();
		
		ArrayList<EducationAndTraining> testArrayUpdated = new ArrayList<EducationAndTraining>();
		
		EducationAndTraining testObj1Updated = new EducationAndTraining();
		EducationAndTraining testObj2Updated = new EducationAndTraining();
		
		testObj1Updated.saveFields("qualificationUpdated2", "establishmentUpdated2", "locationUpdated2", "2/2/2Updated2");
		testObj2Updated.saveFields("qualificationUpdated1", "establishmentUpdated1", "locationUpdated1", "2/2/2Updated1");
		
		testArrayUpdated.add(testObj1Updated);
		testArrayUpdated.add(testObj2Updated);
		
		tester.educationAndTrainingSaveFields("qualification2", "establishment2", "location2", "2/2/2");
		tester.educationAndTrainingSaveFields("qualification1", "establishment1", "location1", "1/1/1");
		
		ArrayList<EducationAndTraining> arrayToUpdate = tester.getEducationAndTrainingObjects();

		EducationAndTraining testObj1 = arrayToUpdate.get(0);
		EducationAndTraining testObj2 = arrayToUpdate.get(1);
		
		tester.updateEducationAndTraining(testObj1, "qualificationUpdated2", "establishmentUpdated2", "locationUpdated2", "2/2/2Updated2");
		tester.updateEducationAndTraining(testObj2, "qualificationUpdated1", "establishmentUpdated1", "locationUpdated1", "2/2/2Updated1");
		
		assertEquals(testArrayUpdated, tester.getEducationAndTrainingObjects());
	}
	
	@Test
	public void deleteEducationAndTrainingTest(){
		GenericCV tester = new GenericCV();
		
		tester.educationAndTrainingSaveFields("qualification2", "establishment2", "location2", "2/2/2");
		tester.educationAndTrainingSaveFields("qualification1", "establishment1", "location1", "1/1/1");
		
		ArrayList<EducationAndTraining> arrayToDelete = tester.getEducationAndTrainingObjects();

		EducationAndTraining objToDelete1 = arrayToDelete.get(0);
		EducationAndTraining objToDelete2 = arrayToDelete.get(1);
		
		tester.deleteEducationAndTraining(objToDelete1);
		tester.deleteEducationAndTraining(objToDelete2);
		
		ArrayList<EducationAndTraining> arrayToCheckIfDeleted = tester.getEducationAndTrainingObjects();

		assertEquals(true, arrayToCheckIfDeleted.isEmpty());
	}
	
	@Test
	public void furtherCoursesTest(){
		GenericCV tester = new GenericCV();
		
		ArrayList<FurtherCourses> testArray = new ArrayList<FurtherCourses>();
		FurtherCourses testObj1 = new FurtherCourses();
		FurtherCourses testObj2 = new FurtherCourses();
		testObj1.saveFields("course2", "establishment2", "location2", "2/2/2");
		testObj2.saveFields("course1", "establishment1", "location1", "1/1/1");
		testArray.add(testObj1);
		testArray.add(testObj2);
		
		tester.furtherCoursesSaveFields("course2", "establishment2", "location2", "2/2/2");
		tester.furtherCoursesSaveFields("course1", "establishment1", "location1", "1/1/1");
		
		assertEquals(testArray, tester.getFurtherCoursesObjects());
	}
	
	@Test
	public void updateFurtherCoursesTest(){
		GenericCV tester = new GenericCV();
		
		ArrayList<FurtherCourses> testArrayUpdated = new ArrayList<FurtherCourses>();
		
		FurtherCourses testObj1 = new FurtherCourses();
		FurtherCourses testObj2 = new FurtherCourses();
		
		FurtherCourses testObj1Updated = new FurtherCourses();
		FurtherCourses testObj2Updated = new FurtherCourses();
		
		testObj1Updated.saveFields("courseUpdated2", "establishmentUpdated2", "locationUpdated2", "2/2/2Updated2");
		testObj2Updated.saveFields("courseUpdated1", "establishmentUpdated1", "locationUpdated1", "2/2/2Updated1");
		
		testArrayUpdated.add(testObj1Updated);
		testArrayUpdated.add(testObj2Updated);
		
		tester.furtherCoursesSaveFields("course2", "establishment2", "location2", "2/2/2");
		tester.furtherCoursesSaveFields("course1", "establishment1", "location1", "1/1/1");
		
		ArrayList<FurtherCourses> arrayToUpdate = tester.getFurtherCoursesObjects();

		testObj1 = arrayToUpdate.get(0);
		testObj2 = arrayToUpdate.get(1);
		
		tester.updateFurtherCourses(testObj1, "courseUpdated2", "establishmentUpdated2", "locationUpdated2", "2/2/2Updated2");
		tester.updateFurtherCourses(testObj2, "courseUpdated1", "establishmentUpdated1", "locationUpdated1", "2/2/2Updated1");
		
		assertEquals(testArrayUpdated, tester.getFurtherCoursesObjects());
	}
	
	@Test
	public void deleteFurtherCoursesTest(){
		GenericCV tester = new GenericCV();
		
		tester.furtherCoursesSaveFields("course2", "establishment2", "location2", "2/2/2");
		tester.furtherCoursesSaveFields("course1", "establishment1", "location1", "1/1/1");
		
		ArrayList<FurtherCourses> arrayToDelete = tester.getFurtherCoursesObjects();

		FurtherCourses objToDelete1 = arrayToDelete.get(0);
		FurtherCourses objToDelete2 = arrayToDelete.get(1);
		
		tester.deleteFurtherCourses(objToDelete1);
		tester.deleteFurtherCourses(objToDelete2);
		
		ArrayList<FurtherCourses> arrayToCheckIfDeleted = tester.getFurtherCoursesObjects();

		assertEquals(true, arrayToCheckIfDeleted.isEmpty());
	}
	
	@Test
	public void additionalInformationTest(){
		GenericCV tester = new GenericCV();
		
		tester.additionalInformationSave("This is additional's information test paragraph!");
		assertEquals("This is additional's information test paragraph!", tester.getAdditionalInformationParagraph());
	}
	
	@Test
	public void interestsTest(){
		GenericCV tester = new GenericCV();
		
		tester.interestsSave("This is interest's test paragraph!");
		assertEquals("This is interest's test paragraph!", tester.getInterestsParagraph());
	}

}
