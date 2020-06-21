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

public class OutputParserLatex implements OutputParser{
	
	private GenericCV cv;
	private PrintWriter writer;
	private String filename = "information.tex";
	private String tab = "\\hspace{35pt}";
	
	
	public OutputParserLatex(GenericCV obj){
		this.cv = obj;
	}
	
	public OutputParserLatex(GenericCV obj, String filename){
		this.cv = obj;
		this.filename = filename;
	}

	@Override
	public void generateFile() {
		try
		{
			writer = new PrintWriter(filename,"UTF-8");
			
			writer.println("\\documentclass{article}\n\\usepackage[T1]{fontenc}\n\\usepackage[english]{babel}\n\\usepackage[document]{ragged2e}\n\\title{Curriculum Vitae}\n\n\\begin{document}\n \\maketitle\n");
			
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
			
			writer.println("\\end{document}");
			
			writer.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	private void printGeneralInformation() {
		writer.println("GENERAL INFORMATION : \\\\~\\\\");
	    writer.println(tab+"Name : " + cv.getGeneralInformationName()+"\\\\");
	    writer.println(tab+"Address : " + cv.getGeneralInformationAddress()+"\\\\");
	    writer.println(tab+"Home Telephone : " + cv.getGeneralInformationHomeTelephone()+"\\\\");
	    writer.println(tab+"Mobile Telephone : " + cv.getGeneralInformationMobileTelephone()+"\\\\");
	    writer.println(tab+"Email : " + cv.getGeneralInformationEmail()+"\\\\~\\\\\n");
	}

	private void printProfessionalProfile() {
		writer.println("PROFESSIONAL PROFILE : \\\\~\\\\");
	    String lines[] = cv.getProfessionalProfileParagraph().split("\n");
	    for (String line : lines){
	    	writer.println(tab+line+"\\\\");
	    }
	    writer.println("~\\\\");
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
		
		writer.println("SKILLS AND EXPERIENCE :\\\\~\\\\");
	    
	    for (SkillsAndExperience object : list){
	    	writer.println(tab+"SKILLS AND EXPERIENCE ON <"+object.getTitle()+">\\\\");
	    	ArrayList<String> paragraphs = new ArrayList<String>();
	    	paragraphs = object.getParagraph();
	    	for (String paragraph : paragraphs){
	    		writer.print(tab+tab+"-");
	    		String lines[] = paragraph.split("\n");
	    		writer.println(lines[0]+"\\\\");
	    		for (int i = 1 ; i < lines.length ; i++){
	    			writer.println(tab+tab+" "+lines[i]+"\\\\");
	    		}
	    	    writer.println("~\\\\");
	    	}
	    	writer.println("~\\\\");
	    }
	}
	
	private void printCareerSummary(){
		FunctionalCV obj = (FunctionalCV) cv; 
		
		writer.println("CAREER SUMMARY :\\\\~\\\\");
	    ArrayList<CareerSummary> listOfCareerSummary = new ArrayList<CareerSummary>();
	    listOfCareerSummary = obj.getCareerSummaryObjects();
	    
	    for (CareerSummary object : listOfCareerSummary){
	    	writer.println(tab+"Company Name : " + object.getCompanyName()+"\\\\");
	    	writer.println(tab+"Job Title : " + object.getJobTitle()+"\\\\");
	    	writer.println(tab+"Date : " + object.getDate()+"\\\\~\\\\");
	    }
	    writer.println("~\\\\");
	}
	
	private void printCoreStrengths(){
		ChronologicalCV obj = (ChronologicalCV)cv;
		
		writer.println("CORE STRENGTHS :\\\\~\\\\");
		String lines[] = obj.getCoreStrengthsParagraph().split("\n");
		
		for (String line : lines){
	    	writer.println(tab+line+"\\\\");
	    }
	    writer.println("~\\\\");
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
		
		writer.println("PROFESSIONAL EXPERIENCE :\\\\~\\\\");
		
		for (ProfessionalExperience item : listOfProfessionalExperience){
			writer.println(tab+"Company Name : "+item.getCompanyName()+"\\\\");
			writer.println(tab+"Job Title : "+item.getJobTitle()+"\\\\");
			writer.println(tab+"Date : "+item.getDate()+"\\\\");
			
			String lines[] = item.getParagraph().split("\n");
			
			for (String line : lines){
		    	writer.println(tab+line+"\\\\");
		    }
		    writer.println("~\\\\");
		    
		    ArrayList<String> achievements = item.getAchievements();
		    
		    for (String achievement : achievements){
		    	writer.println(tab+tab+"- "+achievement+"\\\\");
		    }
		    writer.println("~\\\\");
		    
		}
	}
	
	private void printEducationAndTraining(){
		
		writer.println("EDUCATION AND TRAINING :\\\\~\\\\");
	    ArrayList<EducationAndTraining> listOfEducationAndTraining = new ArrayList<EducationAndTraining>();
	    listOfEducationAndTraining = cv.getEducationAndTrainingObjects();
	    
	    for (EducationAndTraining object : listOfEducationAndTraining){
	    	writer.println(tab+"Qualification : " + object.getQualification()+"\\\\");
	    	writer.println(tab+"Establishment : " + object.getEstablishment()+"\\\\");
	    	writer.println(tab+"Location : " + object.getLocation()+"\\\\");
	    	writer.println(tab+"Date : " + object.getDate()+"\\\\~\\\\");
	    }
	    
	    writer.println("");
	}
	
	private void printFurtherCourse(){
		
		writer.println("FURTHER COURSES :\\\\~\\\\");
	    ArrayList<FurtherCourses> listOfFurtherCourses = new ArrayList<FurtherCourses>();
	    listOfFurtherCourses = cv.getFurtherCoursesObjects();
	    
	    for (FurtherCourses object : listOfFurtherCourses){
	    	writer.println(tab+"Course : " + object.getCourse()+"\\\\");
	    	writer.println(tab+"Establishment : " +object.getEstablishment()+"\\\\");
	    	writer.println(tab+"Location : " + object.getLocation()+"\\\\");
	    	writer.println(tab+"Date : " + object.getDate()+"\\\\~\\\\");
	    }
	    writer.println("");
	}
	
	private void printAdditionalInformation(){
		writer.println("ADDITIONAL INFORMATION :\\\\~\\\\");
	    String lines[] = cv.getAdditionalInformationParagraph().split("\n");
	    
	    for (String line : lines){
	    	writer.println(tab+line+"\\\\");
	    }
	    writer.println("~\\\\");
	}
	
	private void printInterests(){
		writer.println("INTERESTS :\\\\~\\\\");
	    String lines[] = cv.getInterestsParagraph().split("\n");
	    
	    for (String line : lines){
	    	writer.println(tab+line+"\\\\");
	    }
	    writer.println("~\\\\");
	}


}
