package Comparator;

import java.util.ArrayList;
import java.util.Iterator;

import CVConstruction.CareerSummary;
import CVConstruction.ChronologicalCV;
import CVConstruction.CombinedCV;
import CVConstruction.EducationAndTraining;
import CVConstruction.FunctionalCV;
import CVConstruction.FurtherCourses;
import CVConstruction.GenericCV;
import CVConstruction.ProfessionalExperience;
import CVConstruction.SkillsAndExperience;
import UserInterface.MainWindow;

public class Comparison {
	
	private GenericCV cvToCompare1;
	private GenericCV cvToCompare2;
	private GenericCV mergedCV;
	
	public Comparison (GenericCV cvToCompare1,GenericCV cvToCompare2){
		
		this.cvToCompare1 = cvToCompare1;
		this.cvToCompare2 = cvToCompare2;
		
		if (cvToCompare1 instanceof FunctionalCV){
			mergedCV = new FunctionalCV();
		} else if (cvToCompare1 instanceof ChronologicalCV) {
			mergedCV = new ChronologicalCV();
		} else {
			mergedCV = new CombinedCV();
		}
	}
	
	public void compareCV(){
		String returnedParagraph;
		String paragraph1;
		String paragraph2;

		compareGeneralInformation();

		paragraph1 = cvToCompare1.getProfessionalProfileParagraph();
		paragraph2 = cvToCompare2.getProfessionalProfileParagraph();

		returnedParagraph = compareParagraphs(paragraph1, paragraph2,"Please choose the Professional Profile paragraph you prefer");
			
		mergedCV.professionalProfileSaveFields(returnedParagraph);		
		
		if (cvToCompare1 instanceof FunctionalCV){
			compareSkillsAndExperience();
			compareCareerSummary();
			
		} else if (cvToCompare1 instanceof ChronologicalCV){
			paragraph1 = ((ChronologicalCV) cvToCompare1).getCoreStrengthsParagraph();
			paragraph2 = ((ChronologicalCV) cvToCompare2).getCoreStrengthsParagraph();

			returnedParagraph = compareParagraphs(paragraph1, paragraph2,"Please choose the Core Strengths paragraph you prefer");
				
			((ChronologicalCV) mergedCV).coreStrengthsSave(returnedParagraph);

			compareProfessionalExperience();
			
		} else {
			compareSkillsAndExperience();
			compareProfessionalExperience();
		}
		
		compareEducationAndTraining();

		compareFurtherCourser();
		
		paragraph1 = cvToCompare1.getAdditionalInformationParagraph();
		paragraph2 = cvToCompare2.getAdditionalInformationParagraph();

		returnedParagraph = compareParagraphs(paragraph1, paragraph2,"Please choose the Additional Information paragraph you prefer");
			
		mergedCV.additionalInformationSave(returnedParagraph);

		paragraph1 = cvToCompare1.getInterestsParagraph();
		paragraph2 = cvToCompare2.getInterestsParagraph();

		returnedParagraph = compareParagraphs(paragraph1, paragraph2,"Please choose the Interests paragraph you prefer");
		
		mergedCV.interestsSave(returnedParagraph);		

	}
	
	private void compareProfessionalExperience(){
		ArrayList<ProfessionalExperience> arrayList1 = ((ChronologicalCV)cvToCompare1).getProfessionalExperienceObjects();
		ArrayList<ProfessionalExperience> arrayList2 = ((ChronologicalCV)cvToCompare2).getProfessionalExperienceObjects();
		ArrayList<ProfessionalExperience> arrayList3 = new ArrayList<ProfessionalExperience>();
		
		if (cvToCompare1 instanceof ChronologicalCV){
			arrayList1 = ((ChronologicalCV)cvToCompare1).getProfessionalExperienceObjects();
			arrayList2 = ((ChronologicalCV)cvToCompare2).getProfessionalExperienceObjects();
		} else {
			arrayList1 = ((CombinedCV)cvToCompare1).getProfessionalExperienceObjects();
			arrayList2 = ((CombinedCV)cvToCompare2).getProfessionalExperienceObjects();
		}
		
		boolean continueFlag = false;
		
		for (ProfessionalExperience item1 : arrayList1){
			
			Iterator<ProfessionalExperience> iterator = arrayList2.iterator();
			
			while(iterator.hasNext()){
				
				ProfessionalExperience item2 = iterator.next();
				
				if (item1.equals(item2)){
					MainWindow.dialogMessage("Now you are going to choose the items for the fields of Professional Experience");

					ArrayList<String> achievementsToAsk = item1.getAchievements();
					achievementsToAsk.addAll(item2.getAchievements());
					ArrayList<String> confirmedAchievements = new ArrayList<String>();
					
					for (String paragraph : achievementsToAsk){
						int choice = MainWindow.chooseDialog(paragraph);
						if (choice == 0) { confirmedAchievements.add(paragraph); }
					}
					
					ProfessionalExperience professionalExperienceObj = new ProfessionalExperience();
					professionalExperienceObj.save(item1.getJobTitle(), item1.getJobTitle(), item1.getDate(), item1.getParagraph(), confirmedAchievements);
					arrayList3.add(professionalExperienceObj);
					iterator.remove();
					
					continueFlag = true;
					break;
				}
				
			}
			
			if (continueFlag){
				continueFlag = false;
				continue;
			} else{
				arrayList3.add(item1);
			}
			
		}
		
		arrayList3.addAll(arrayList2);
		
		if (mergedCV instanceof ChronologicalCV){
			((ChronologicalCV) mergedCV).setProfessionalExperience(arrayList3);
		} else {
			((CombinedCV) mergedCV).setProfessionalExperience(arrayList3);
		}
	}
	
	private void compareCareerSummary(){
		ArrayList<CareerSummary> arrayList1 = ((FunctionalCV) cvToCompare1).getCareerSummaryObjects();
		ArrayList<CareerSummary> arrayList2 = ((FunctionalCV) cvToCompare2).getCareerSummaryObjects();
		ArrayList<CareerSummary> arrayList3 = new ArrayList<CareerSummary>();
		
		for (CareerSummary item1 : arrayList1){
			
			Iterator<CareerSummary> iterator = arrayList2.iterator();
			
			while(iterator.hasNext()){
				
				CareerSummary item2 = iterator.next();
				if (item1.equals(item2)){
					iterator.remove();
				}
			}
			
		}
		
		arrayList1.addAll(arrayList2);
		
		MainWindow.dialogMessage("Now you are going to choose Career Summary bullets");
		
		for (CareerSummary item : arrayList1){
			int choice = MainWindow.chooseDialog(item);
			if (choice == 0) { arrayList3.add(item); }
		}
		
		((FunctionalCV) mergedCV).setCareerSummaryObjects(arrayList3);
	}
	
	private void compareSkillsAndExperience(){
		
		ArrayList<SkillsAndExperience> arrayList1 = ((FunctionalCV)cvToCompare1).getSkillsAndExperienceObjects();
		ArrayList<SkillsAndExperience> arrayList2 = ((FunctionalCV)cvToCompare2).getSkillsAndExperienceObjects();
		ArrayList<SkillsAndExperience> arrayList3 = new ArrayList<SkillsAndExperience>();
		
		if (cvToCompare1 instanceof FunctionalCV){
			arrayList1 = ((FunctionalCV)cvToCompare1).getSkillsAndExperienceObjects();
			arrayList2 = ((FunctionalCV)cvToCompare2).getSkillsAndExperienceObjects();
		} else {
			arrayList1 = ((CombinedCV)cvToCompare1).getSkillsAndExperienceObjects();
			arrayList2 = ((CombinedCV)cvToCompare2).getSkillsAndExperienceObjects();
		}
		
		
		
		boolean continueFlag = false;
		
		for (SkillsAndExperience item1 : arrayList1){
			String title1 = item1.getTitle();
			
			Iterator<SkillsAndExperience> iterator = arrayList2.iterator();
			
			while(iterator.hasNext()){
				
				SkillsAndExperience item2 = iterator.next();
				String title2 = item2.getTitle();
				
				if (title1.equals(title2)){
					MainWindow.dialogMessage("Now you are going to choose the items for the "+title1);

					ArrayList<String> paragraphsToAsk = item1.getParagraph();
					paragraphsToAsk.addAll(item2.getParagraph());
					ArrayList<String> confirmedParagraphs = new ArrayList<String>();
					
					for (String paragraph : paragraphsToAsk){
						int choice = MainWindow.chooseDialog(paragraph);
						if (choice == 0) { confirmedParagraphs.add(paragraph); }
					}
					
					SkillsAndExperience skillsAndExperienceObj = new SkillsAndExperience();
					skillsAndExperienceObj.saveTitle(title1);
					for (String paragraph : confirmedParagraphs){
						skillsAndExperienceObj.saveParagraph(paragraph);
					}
					arrayList3.add(skillsAndExperienceObj);
					iterator.remove();
					
					continueFlag = true;
					break;
				}
				
			}
			
			if (continueFlag){
				continueFlag = false;
				continue;
			} else{
				arrayList3.add(item1);
			}
			
		}
		
		arrayList3.addAll(arrayList2);
		
		if (mergedCV instanceof FunctionalCV){
			((FunctionalCV) mergedCV).setSkillsAndExperienceObjects(arrayList3);
		} else {
			((CombinedCV) mergedCV).setSkillsAndExperienceObjects(arrayList3);
		}
		
		
	}
	
	private void compareFurtherCourser(){
		ArrayList<FurtherCourses> arrayList1 = cvToCompare1.getFurtherCoursesObjects();
		ArrayList<FurtherCourses> arrayList2 = cvToCompare2.getFurtherCoursesObjects();
		ArrayList<FurtherCourses> arrayList3 = new ArrayList<FurtherCourses>();
		
		for (FurtherCourses item1 : arrayList1){
			
			Iterator<FurtherCourses> iterator = arrayList2.iterator();
			
			while(iterator.hasNext()){
				
				FurtherCourses item2 = iterator.next();
				if (item1.equals(item2)){
					iterator.remove();
				}
			}
			
		}
		
		arrayList1.addAll(arrayList2);
		
		MainWindow.dialogMessage("Now you are going to choose Further Courses bullets");
		
		for (FurtherCourses item : arrayList1){
			int choice = MainWindow.chooseDialog(item);
			if (choice == 0) { arrayList3.add(item); }
		}
		
		mergedCV.setFurtherCoursesObjects(arrayList3);
	}
	
	private String compareParagraphs(String paragraph1, String paragraph2,String message){
		String finalParagraph = paragraph1;
		
		if (!paragraph1.equals(paragraph2)){
			int choice = MainWindow.mergeOptionDialog(paragraph1, paragraph2, message);
			if (choice == 1){ finalParagraph = paragraph2; }
			else if (choice == 2) { finalParagraph = paragraph1 + "\n" + paragraph2; }
		}
		
		return finalParagraph;
	}
	
	private void compareEducationAndTraining(){
		ArrayList<EducationAndTraining> arrayList1 = cvToCompare1.getEducationAndTrainingObjects();
		ArrayList<EducationAndTraining> arrayList2 = cvToCompare2.getEducationAndTrainingObjects();
		ArrayList<EducationAndTraining> arrayList3 = new ArrayList<EducationAndTraining>();
		
		for (EducationAndTraining item1 : arrayList1){
			
			Iterator<EducationAndTraining> iterator = arrayList2.iterator();
			
			while(iterator.hasNext()){
				
				EducationAndTraining item2 = iterator.next();
				if (item1.equals(item2)){
					iterator.remove();
				}
			}
			
		}
		
		arrayList1.addAll(arrayList2);
		
		MainWindow.dialogMessage("Now you are going to choose Education And Training bullets");
		
		for (EducationAndTraining item : arrayList1){
			int choice = MainWindow.chooseDialog(item);
			if (choice == 0) { arrayList3.add(item); }
		}
		
		mergedCV.setEducationAndTrainingObjects(arrayList3);
	}
	
	private void compareGeneralInformation(){
		String name1 = cvToCompare1.getGeneralInformationName();
		String name2 = cvToCompare2.getGeneralInformationName();
		String name3 = name1;
		
		if (!name1.equals(name2)){
			MainWindow.dialogMessage("The names are different!");
			System.exit(1);
		}
		
		String address1 = cvToCompare1.getGeneralInformationAddress();
		String address2 = cvToCompare2.getGeneralInformationAddress();
		String address3 = address1;
		
		if (!address1.equals(address2)){
			int choice = MainWindow.optionDialog(address1, address2,"Choose the Address you prefer");
			if (choice == 1){ address3 = address2; }
		}
		
		String homeTelephone1 = cvToCompare1.getGeneralInformationHomeTelephone();
		String homeTelephone2 = cvToCompare2.getGeneralInformationHomeTelephone();
		String homeTelephone3 = homeTelephone1;
		
		if (!homeTelephone1.equals(homeTelephone2)){
			int choice = MainWindow.optionDialog(homeTelephone1, homeTelephone2,"Choose the Home Telephone you prefer");
			if (choice == 1){ homeTelephone3 = homeTelephone2; }
		}
		
		String mobileTelephone1 = cvToCompare1.getGeneralInformationMobileTelephone();
		String mobileTelephone2 = cvToCompare2.getGeneralInformationMobileTelephone();
		String mobileTelephone3 = mobileTelephone1;
		
		if (!mobileTelephone1.equals(mobileTelephone2)){
			int choice = MainWindow.optionDialog(mobileTelephone1, mobileTelephone2,"Choose the Mobile Telephone you prefer");
			if (choice == 1){ mobileTelephone3 = mobileTelephone2; }
		}
		
		String email1 = cvToCompare1.getGeneralInformationEmail();
		String email2 = cvToCompare2.getGeneralInformationEmail();
		String email3 = email1;
		
		if (!email1.equals(email2)){
			int choice = MainWindow.optionDialog(email1, email2,"Choose the Email you prefer");
			if (choice == 1) { email3 = email2; }
		}
		
		mergedCV.generalInformationSaveFields(name3, address3, homeTelephone3, mobileTelephone3, email3);
	}

}
