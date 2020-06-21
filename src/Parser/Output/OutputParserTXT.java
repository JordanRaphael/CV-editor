package Parser.Output;

import java.io.PrintWriter;
import java.util.ArrayList;

import CVConstruction.CareerSummary;
import CVConstruction.ChronologicalCV;
import CVConstruction.CombinedCV;
import CVConstruction.EducationAndTraining;
import CVConstruction.FunctionalCV;
import CVConstruction.FurtherCourses;
import CVConstruction.GenericCV;
import CVConstruction.ProfessionalExperience;
import CVConstruction.SkillsAndExperience;

public class OutputParserTXT implements OutputParser{

	private GenericCV cv;
	private PrintWriter writer;
	private String filename = "information.txt";
	
	public OutputParserTXT(GenericCV obj){
		this.cv = obj;
	}
	
	public OutputParserTXT(GenericCV obj, String filename){
		this.cv = obj;
		this.filename = filename;
	}
	
	@Override
	public void generateFile(){
		try
		{
			writer = new PrintWriter(filename, "UTF-8");
			
			printGeneralInformation();
			printProfessionalProfile();
			
			if (cv instanceof FunctionalCV){
				printSkillsAndExperience();
				printCareerSummary();
				
			} else if (cv instanceof ChronologicalCV){
				printCoreStrengths();
				printProfessionalExperience();
				
			} else {
				printSkillsAndExperience();
				printProfessionalExperience();
				
			}
			
			printEducationAndTraining();
			printFurtherCourse();
			printAdditionalInformation();
			printInterests();
			
			writer.close();
			
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	private void printGeneralInformation(){
		writer.println("GENERAL INFORMATION : \n");
	    writer.println("\tName : " + cv.getGeneralInformationName());
	    writer.println("\tAddress : " + cv.getGeneralInformationAddress());
	    writer.println("\tHome Telephone : " + cv.getGeneralInformationHomeTelephone());
	    writer.println("\tMobile Telephone : " + cv.getGeneralInformationMobileTelephone());
	    writer.println("\tEmail : " + cv.getGeneralInformationEmail()+"\n");
	    writer.println("");
	}
	
	private void printProfessionalProfile(){
		writer.println("PROFESSIONAL PROFILE :\n");
	    String lines[] = cv.getProfessionalProfileParagraph().split("\n");
	    for (String line : lines){
	    	writer.println("\t"+line);
	    }
	    writer.println("");
	}
	
	private void printSkillsAndExperience(){
		
		 ArrayList<SkillsAndExperience> list = new ArrayList<SkillsAndExperience>();
		
		if (cv instanceof FunctionalCV){
			FunctionalCV obj = (FunctionalCV)cv;
			list = obj.getSkillsAndExperienceObjects();
		} else {
			CombinedCV obj = (CombinedCV)cv;
			list = obj.getSkillsAndExperienceObjects();
		}
		
		writer.println("SKILLS AND EXPERIENCE : \n");
	    
	    for (SkillsAndExperience object : list){
	    	writer.println("\tSKILLS AND EXPERIENCE ON <"+object.getTitle()+">");
	    	ArrayList<String> paragraphs = new ArrayList<String>();
	    	paragraphs = object.getParagraph();
	    	for (String paragraph : paragraphs){
	    		writer.print("\t\t\u2022");
	    		String lines[] = paragraph.split("\n");
	    		writer.println(lines[0]);
	    		for (int i = 1 ; i < lines.length ; i++){
	    			writer.println("\t\t "+lines[i]);
	    		}
	    	    writer.println("\n");
	    	}
	    	writer.println("\n");
	    }
	}
	
	private void printCareerSummary(){
		FunctionalCV obj = (FunctionalCV) cv; 
		
		writer.println("CAREER SUMMARY :\n");
	    ArrayList<CareerSummary> listOfCareerSummary = new ArrayList<CareerSummary>();
	    listOfCareerSummary = obj.getCareerSummaryObjects();
	    
	    for (CareerSummary object : listOfCareerSummary){
	    	writer.println("\tCompany Name : " + object.getCompanyName()+"\n");
	    	writer.println("\tJob Title : " + object.getJobTitle()+"\n");
	    	writer.println("\tDate : " + object.getDate()+"\n");
	    }
	    writer.println("");
	}
	
	private void printEducationAndTraining(){
		
		writer.println("EDUCATION AND TRAINING :\n");
	    ArrayList<EducationAndTraining> listOfEducationAndTraining = new ArrayList<EducationAndTraining>();
	    listOfEducationAndTraining = cv.getEducationAndTrainingObjects();
	    
	    for (EducationAndTraining object : listOfEducationAndTraining){
	    	writer.println("\tQualification : " + object.getQualification()+"\n");
	    	writer.println("\tEstablishment : " + object.getEstablishment()+"\n");
	    	writer.println("\tLocation : " + object.getLocation()+"\n");
	    	writer.println("\tDate : " + object.getDate()+"\n");
	    }
	    
	    writer.println("");
	}
	
	private void printFurtherCourse(){
		
		writer.println("FURTHER COURSES :\n");
	    ArrayList<FurtherCourses> listOfFurtherCourses = new ArrayList<FurtherCourses>();
	    listOfFurtherCourses = cv.getFurtherCoursesObjects();
	    
	    for (FurtherCourses object : listOfFurtherCourses){
	    	writer.println("\tCourse : " + object.getCourse()+"\n");
	    	writer.println("\tEstablishment : " +object.getEstablishment()+"\n");
	    	writer.println("\tLocation : " + object.getLocation()+"\n");
	    	writer.println("\tDate : " + object.getDate()+"\n");
	    }
	    writer.println("");
	}
	
	private void printAdditionalInformation(){
		writer.println("ADDITIONAL INFORMATION :\n");
	    String lines[] = cv.getAdditionalInformationParagraph().split("\n");
	    
	    for (String line : lines){
	    	writer.println("\t"+line);
	    }
	    writer.println("");
	}
	
	private void printInterests(){
		writer.println("INTERESTS : ");
	    String lines[] = cv.getInterestsParagraph().split("\n");
	    
	    for (String line : lines){
	    	writer.println("\t"+line);
	    }
	    writer.println("");
	}
	
	private void printCoreStrengths(){
		ChronologicalCV obj = (ChronologicalCV)cv;
		
		writer.println("CORE STRENGTHS :");
		String lines[] = obj.getCoreStrengthsParagraph().split("\n");
		
		for (String line : lines){
	    	writer.println("\t"+line);
	    }
	    writer.println("");
	}
	
	private void printProfessionalExperience(){
		
		ArrayList<ProfessionalExperience> listOfProfessionalExperience = new ArrayList<ProfessionalExperience>();
		
		if (cv instanceof ChronologicalCV){
			ChronologicalCV obj = (ChronologicalCV)cv;
			listOfProfessionalExperience = obj.getProfessionalExperienceObjects();
		} else {
			CombinedCV obj = (CombinedCV)cv;
			listOfProfessionalExperience = obj.getProfessionalExperienceObjects();
		}
		
		writer.println("PROFESSIONAL EXPERIENCE : \n");
		
		for (ProfessionalExperience item : listOfProfessionalExperience){
			writer.println("\tCompany Name : "+item.getCompanyName()+"\n");
			writer.println("\tJob Title : "+item.getJobTitle()+"\n");
			writer.println("\tDate : "+item.getDate());
			
			String lines[] = item.getParagraph().split("\n");
			
			for (String line : lines){
		    	writer.println("\t"+line);
		    }
		    writer.println("");
		    
		    ArrayList<String> achievements = item.getAchievements();
		    
		    for (String achievement : achievements){
		    	writer.println("\t\t* "+achievement);
		    }
		    writer.println("");
		    
		}
	}
	
}
