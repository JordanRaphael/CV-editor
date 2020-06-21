package JUnitTesting;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import CVConstruction.FunctionalCV;
import CVConstruction.FurtherCourses;
import Parser.Input.InputParser;
import Parser.Input.InputParserTXT;
import Parser.Output.OutputParser;
import Parser.Output.OutputParserTXT;

public class ParserTest {

	@Test
	public void writeReadToFileTest() {
		FunctionalCV writeCVTest = new FunctionalCV();	
		
		String nameTest = "argi";
		String addressTest = "papanoutsou";
		String mobileTelephoneTest = "697634522";
		String homeTelephoneTest = "210344353463";
		String emailTest = "testMail@hotmail.com";
		
		String professionalProfileTest = "My professional Profile Paragraph";
		
		String courseTest = "myCourse Test";
		String establishmentTest = "establishment Test";
		String locationTest = "location Test";
		String dateTest = "20/05/2017";
		
		String additionalInformationTest = "Addittional information Test";
		
		String interestsTest = "Interests Test";
		
		writeCVTest.generalInformationSaveFields(nameTest, addressTest, homeTelephoneTest, mobileTelephoneTest, emailTest);
		writeCVTest.professionalProfileSaveFields(professionalProfileTest);
		writeCVTest.furtherCoursesSaveFields(courseTest, establishmentTest, locationTest, dateTest);
		writeCVTest.additionalInformationSave(additionalInformationTest);
		writeCVTest.interestsSave(interestsTest);
		
		String testFilename = "testFile.txt";
		
		OutputParser outputParserTest = new OutputParserTXT(writeCVTest,testFilename);
		outputParserTest.generateFile();
		
		FunctionalCV readCVTest = new FunctionalCV();
		
		InputParser inputParserTest = new InputParserTXT(readCVTest,testFilename);
		inputParserTest.readFromFile();
		
		assertEquals(nameTest, readCVTest.getGeneralInformationName());
		assertEquals(addressTest, readCVTest.getGeneralInformationAddress());
		assertEquals(mobileTelephoneTest, readCVTest.getGeneralInformationMobileTelephone());
		assertEquals(homeTelephoneTest, readCVTest.getGeneralInformationHomeTelephone());
		assertEquals(emailTest, readCVTest.getGeneralInformationEmail());
		
		assertEquals(professionalProfileTest, readCVTest.getProfessionalProfileParagraph());
		
		FurtherCourses furtherCourserTestObj = readCVTest.getFurtherCoursesObjects().get(0);
		
		assertEquals(courseTest, furtherCourserTestObj.getCourse());
		assertEquals(establishmentTest, furtherCourserTestObj.getEstablishment());
		assertEquals(locationTest, furtherCourserTestObj.getLocation());
		assertEquals(dateTest, furtherCourserTestObj.getDate());
		
		assertEquals(additionalInformationTest, readCVTest.getAdditionalInformationParagraph());
		
		assertEquals(interestsTest, readCVTest.getInterestsParagraph());
		
	}

}
