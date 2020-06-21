package CVConstruction;

import java.util.ArrayList;

public class GenericCV {

	// Template Selection
	private String templateSelection;

	// General Information fields
	private String generalInformationName;
	private String generalInformationAddress;
	private String generalInformationHomeTelephone;
	private String generalInformationMobileTelephone;
	private String generalInformationEmail;
	
	// Professional Profile fields
	private String professionalProfileParagraph;

	// Education and Training objects
	private ArrayList<EducationAndTraining> educationAndTrainingObjects = new ArrayList<EducationAndTraining>();
	
	// Further Courses objects
	private ArrayList<FurtherCourses> furtherCoursesObjects = new ArrayList<FurtherCourses>();
	
	// Additional Information fields
	private String additionalInformationParagraph;

	// Interests fields
	private String interestsParagraph;
	
	public String getAdditionalInformationParagraph() {
		return additionalInformationParagraph;
	}
	
	public String getInterestsParagraph() {
		return interestsParagraph;
	}

	public String getProfessionalProfileParagraph() {
		return professionalProfileParagraph;
	}
	
	public String getGeneralInformationName() {
		return generalInformationName;
	}

	public String getGeneralInformationAddress() {
		return generalInformationAddress;
	}

	public String getGeneralInformationHomeTelephone() {
		return generalInformationHomeTelephone;
	}

	public String getGeneralInformationMobileTelephone() {
		return generalInformationMobileTelephone;
	}

	public String getGeneralInformationEmail() {
		return generalInformationEmail;
	}
	
	public ArrayList<EducationAndTraining> getEducationAndTrainingObjects() {
		educationAndTrainingObjects.sort(new EducationAndTraining());
		return educationAndTrainingObjects;
	}

	public ArrayList<FurtherCourses> getFurtherCoursesObjects() {
		furtherCoursesObjects.sort(new FurtherCourses());
		return furtherCoursesObjects;
	}
	
	
	public void deleteEducationAndTraining(EducationAndTraining objectToDelete){
		educationAndTrainingObjects.remove(objectToDelete);
	}
	
	public void deleteFurtherCourses(FurtherCourses objectToDelete){
		furtherCoursesObjects.remove(objectToDelete);
	}

	public void generalInformationSaveFields(String newName, String newAddress, String newHomeTelephone, String newMobileTelephone, String newEmail){
		generalInformationName = newName;
		generalInformationAddress = newAddress;
		generalInformationHomeTelephone = newHomeTelephone;
		generalInformationMobileTelephone = newMobileTelephone;
		generalInformationEmail = newEmail;
	}
	
	

	public void professionalProfileSaveFields(String newParagraph){
		professionalProfileParagraph = newParagraph;
	}
	
	public void educationAndTrainingSaveFields(String newQualification, String newEstablishment, String newLocation, String newDate){
		EducationAndTraining object = new EducationAndTraining();
		object.saveFields(newQualification, newEstablishment, newLocation, newDate);
		educationAndTrainingObjects.add(object);
	}
	
	public void furtherCoursesSaveFields(String newCourse, String newEstablishment, String newLocation, String newDate){
		FurtherCourses object = new FurtherCourses();
		object.saveFields(newCourse, newEstablishment, newLocation, newDate);
		furtherCoursesObjects.add(object);
	}
	
	public void additionalInformationSave(String newParagraph){
		additionalInformationParagraph = newParagraph;
	}
	
	public void interestsSave(String newParagraph){
		interestsParagraph = newParagraph;
	}
	
	public void setTemplateSelection(String template){
		templateSelection = template;
	}
	
	public void updateEducationAndTraining(EducationAndTraining objectToEdit, String newQualification, String newEstablishment, String newLocation, String newDate){
		objectToEdit.saveFields(newQualification, newEstablishment, newLocation, newDate);
	}
	
	public void updateFurtherCourses(FurtherCourses objectToEdit, String newCourse, String newEstablishment, String newLocation, String newDate){
		objectToEdit.saveFields(newCourse, newEstablishment, newLocation, newDate);
	}
	
	public String getTemplateSelection(){
		return templateSelection;
	}

	// SETTERS FOR TXT
	public void setGeneralInformationName(String generalInformationName) {
		this.generalInformationName = generalInformationName;
	}

	public void setGeneralInformationAddress(String generalInformationAddress) {
		this.generalInformationAddress = generalInformationAddress;
	}

	public void setGeneralInformationHomeTelephone(String generalInformationHomeTelephone) {
		this.generalInformationHomeTelephone = generalInformationHomeTelephone;
	}

	public void setGeneralInformationMobileTelephone(String generalInformationMobileTelephone) {
		this.generalInformationMobileTelephone = generalInformationMobileTelephone;
	}

	public void setGeneralInformationEmail(String generalInformationEmail) {
		this.generalInformationEmail = generalInformationEmail;
	}

	public void setProfessionalProfileParagraph(String professionalProfileParagraph) {
		this.professionalProfileParagraph = professionalProfileParagraph;
	}

	public void setEducationAndTrainingObjects(ArrayList<EducationAndTraining> educationAndTrainingObjects) {
		this.educationAndTrainingObjects = educationAndTrainingObjects;
	}

	public void setFurtherCoursesObjects(ArrayList<FurtherCourses> furtherCoursesObjects) {
		this.furtherCoursesObjects = furtherCoursesObjects;
	}

	public void setAdditionalInformationParagraph(String additionalInformationParagraph) {
		this.additionalInformationParagraph = additionalInformationParagraph;
	}

	public void setInterestsParagraph(String interestsParagraph) {
		this.interestsParagraph = interestsParagraph;
	}
}




