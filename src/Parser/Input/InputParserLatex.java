package Parser.Input;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import CVConstruction.ChronologicalCV;
import CVConstruction.CombinedCV;
import CVConstruction.FunctionalCV;
import CVConstruction.GenericCV;

public class InputParserLatex implements InputParser{
	
	private GenericCV cv;
	private BufferedReader reader;
	private String filename = "information.txt";
	
	public InputParserLatex(GenericCV cv){
		this.cv = cv;
	}
	
	public InputParserLatex(GenericCV cv, String filename){
		this.cv = cv;
		this.filename = filename;
	}


	@Override
	public GenericCV readFromFile() {
		
		try
		{
			reader = new BufferedReader(new InputStreamReader(
				    new FileInputStream(filename), "UTF-8"));
			
			if (cv instanceof FunctionalCV){
				FunctionalCV obj = (FunctionalCV) cv;
				
				readGeneralInformation(obj);
				
				obj.professionalProfileSaveFields(readParagraph("SKILLS AND EXPERIENCE"));
				
				readSkillsAndExperience(obj);
				readCareerSummary(obj);
				readEducationAndTraining(obj);
				readFurtherCourses(obj);
				
				obj.additionalInformationSave(readParagraph("INTERESTS"));
				
				readInterests(obj);
				
			} else if (cv instanceof ChronologicalCV){
				ChronologicalCV obj = (ChronologicalCV) cv;
				
				readGeneralInformation(obj);
				
				obj.professionalProfileSaveFields(readParagraph("CORE STRENGTHS"));
				
				obj.coreStrengthsSave(readParagraph("PROFESSIONAL EXPERIENCE"));
				
				readProfessionalExperience(obj);
				readEducationAndTraining(obj);
				readFurtherCourses(obj);
				
				obj.additionalInformationSave(readParagraph("INTERESTS"));
				
				readInterests(obj);
				
			} else {
				CombinedCV obj = (CombinedCV) cv;
				
				readGeneralInformation(obj);
				
				obj.professionalProfileSaveFields(readParagraph("SKILLS AND EXPERIENCE"));
				
				readSkillsAndExperience(obj);
				readProfessionalExperience(obj);
				readEducationAndTraining(obj);
				readFurtherCourses(obj);
				
				obj.additionalInformationSave(readParagraph("INTERESTS"));
				
				readInterests(obj);

			}
			
			
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return cv;
		
	}
	
	
	
	private void readGeneralInformation(GenericCV obj) throws IOException{
		String line;
		String name = "";
		String address = "";
		String homeTelephone = "";
		String mobileTelephone = "";
		String email = "";
		String parts[];
		String parts2[];
		
		while (!(line = reader.readLine()).startsWith("PROFESSIONAL PROFILE")){
			
			if (line.isEmpty() || (!line.contains(":"))) { continue; }
			
			parts = line.split(":");
			
			parts[0] = parts[0].trim();
			
			parts2 = parts[1].split("\\\\");
			
			if (parts[0].startsWith("\\hspace{35pt}Name")){
				name = parts2[0];
			} else if (parts[0].startsWith("\\hspace{35pt}Address")){
				address = parts2[0];
			} else if (parts[0].startsWith("\\hspace{35pt}Home Telephone")){
				homeTelephone = parts2[0];
			} else if (parts[0].startsWith("\\hspace{35pt}Mobile Telephone")){
				mobileTelephone = parts2[0];
			} else if (parts[0].startsWith("\\hspace{35pt}Email")){
				email = parts2[0];
			}
			
		}

		obj.generalInformationSaveFields(name.trim(), address.trim(), homeTelephone.trim(), mobileTelephone.trim(), email.trim());
	}
	
	private void readInterests(GenericCV obj) throws IOException{
		String line;
		String paragraph = "";
		String parts[];
		String parts2[];
		
		while ((line = reader.readLine()) != null){
			line = line.trim();
			
			if (line.isEmpty() || (!line.contains("\\hspace{35pt}"))) { continue; }
			
			parts = line.split("hspace\\{35pt\\}");
			
			parts2 = parts[1].split("\\\\");
			
			if( !(parts2.length > 0) ){ continue; }
			
			paragraph += parts2[0]+"\n";
		}
		
		obj.interestsSave(paragraph.trim());
	}
	
	private String readParagraph(String nextSection) throws IOException{
		String line;
		String parts[];
		String parts2[];
		String paragraph = "";
		
		while (!((line = reader.readLine()).startsWith(nextSection))){
			
			line = line.trim();
			
			if (line.isEmpty() || (!line.contains("\\hspace{35pt}"))) { continue; }
			
			parts = line.split("hspace\\{35pt\\}");
			
			parts2 = parts[1].split("\\\\");
			
			if( !(parts2.length > 0) ){ continue; }
			
			paragraph += parts2[0]+"\n";
		}
		
		
		
		return paragraph.trim();
	}
	
	private void readSkillsAndExperience(FunctionalCV obj) throws IOException{
		String paragraph = "";
		String title = "";
		String parts[];
		String parts2[];
		
		String line;
		while (!((line = reader.readLine()).startsWith("CAREER SUMMARY"))){
			line = line.trim();
			if (line.startsWith("\\hspace{35pt}SKILLS AND EXPERIENCE ON")){
				
				parts = line.split("<");
				parts2 = parts[1].split(">");
				title = parts2[0];
				obj.skillsAndExperienceSaveTitle(title);
			}
			if (line.startsWith("\\hspace{35pt}\\hspace{35pt}-")){
				parts = line.split("-");
				parts2 = parts[1].split("\\\\");
				paragraph = parts2[0]+"\n";
				while (!((line = reader.readLine()).startsWith("~\\\\"))){
					
					parts = line.split("hspace\\{35pt\\}");
					parts[2] = parts[2].trim();
					parts2 = parts[2].split("\\\\");
					paragraph += parts2[0]+"\n";
				}
				
				obj.skillsAndExperienceSaveParagraph(paragraph.trim());
			}
			
		}
		
	}
	
	private void readSkillsAndExperience(CombinedCV obj) throws IOException{
		String paragraph = "";
		String title = "";
		String parts[];
		String parts2[];
		
		String line;
		while (!((line = reader.readLine()).startsWith("PROFESSIONAL EXPERIENCE"))){
			line = line.trim();
			if (line.startsWith("\\hspace{35pt}SKILLS AND EXPERIENCE ON")){
				
				parts = line.split("<");
				parts2 = parts[1].split(">");
				title = parts2[0];
				obj.skillsAndExperienceSaveTitle(title);
			}
			if (line.startsWith("\\hspace{35pt}\\hspace{35pt}-")){
				parts = line.split("-");
				parts2 = parts[1].split("\\\\");
				paragraph = parts2[0]+"\n";
				while (!((line = reader.readLine()).startsWith("~\\\\"))){
					
					parts = line.split("hspace\\{35pt\\}");
					parts[2] = parts[2].trim();
					parts2 = parts[2].split("\\\\");
					paragraph += parts2[0]+"\n";
				}
				
				obj.skillsAndExperienceSaveParagraph(paragraph.trim());
			}
			
		}
		
	}
	
	private void readCareerSummary(FunctionalCV obj) throws IOException{
		String companyName = "";
		String jobTitle = "";
		String date = "";
		String parts[];
		String parts2[];
		
		
		String line;
		while (!((line = reader.readLine()).startsWith("EDUCATION AND TRAINING"))){
			
			line = line.trim();
			
			if (line.isEmpty() || (!line.contains(":"))) { continue; }
			
			parts = line.split(":");
			parts[1] = parts[1].trim();
			parts2 = parts[1].split("\\\\");
			
			if (line.startsWith("\\hspace{35pt}Company Name")){
				if (!(companyName.isEmpty())){
					
					obj.careerSummarySave(companyName, jobTitle, date);
				}
				companyName = parts2[0];
			} else if (line.startsWith("\\hspace{35pt}Job Title")){
				jobTitle = parts2[0];
			} else if (line.startsWith("\\hspace{35pt}Date")){
				date = parts2[0];
			} 
			
		}
		
		obj.careerSummarySave(companyName.trim(), jobTitle.trim(), date.trim());
	}
	
	private void readProfessionalExperience(ChronologicalCV obj) throws IOException{
		String companyName = "";
		String jobTitle = "";
		String paragraph = "";
		String date = "";
		ArrayList<String> achievements = new ArrayList<String>();
		String parts[];
		String parts2[];
		
		
		String line;
		while (!((line = reader.readLine()).startsWith("EDUCATION AND TRAINING"))){
			
			line = line.trim();
			
			if (line.isEmpty() || (!line.contains("\\hspace{35pt}"))) { continue; }
			
			parts = line.split("hspace\\{35pt\\}");
			
			if (parts[1].startsWith("Company Name")){
				if (!(companyName.isEmpty())){
					
					obj.professionalExperienceSave(companyName.trim(), jobTitle.trim(), date.trim(), paragraph.trim(), achievements);
					achievements.clear();
				}
				parts2 = parts[1].split(":");
				parts2[1] = parts2[1].trim();
				parts = parts2[1].split("\\\\");
				companyName = parts[0];
			} else if (parts[1].startsWith("Job Title")){
				parts2 = parts[1].split(":");
				parts2[1] = parts2[1].trim();
				parts = parts2[1].split("\\\\");
				jobTitle = parts[0];
			} else if (parts[1].startsWith("Date")){
				parts2 = parts[1].split(":");
				parts2[1] = parts2[1].trim();
				parts = parts2[1].split("\\\\");
				date = parts[0];
			} else if (parts[1].startsWith("\\")){
				parts = line.split("-");
				parts[1] = parts[1].trim();
				parts2 = parts[1].split("\\\\");
				achievements.add(parts2[0].trim());
			} else {
				
				if (line.isEmpty() || (!line.contains("\\hspace{35pt}"))) { continue; }
				
				parts = line.split("hspace\\{35pt\\}");
				
				parts2 = parts[1].split("\\\\");
				
				if( !(parts2.length > 0) ){ continue; }
				
				paragraph = parts2[0]+"\n";
				
				while (!((line = reader.readLine()).startsWith("~\\\\"))){
					
					line = line.trim();
					
					if (line.isEmpty() || (!line.contains("\\hspace{35pt}"))) { continue; }
					
					parts = line.split("hspace\\{35pt\\}");
					
					parts2 = parts[1].split("\\\\");
					
					if( !(parts2.length > 0) ){ continue; }
					
					paragraph += parts2[0]+"\n";
					
				}
				
			}
			
		}
		
		obj.professionalExperienceSave(companyName.trim(), jobTitle.trim(), date.trim(), paragraph.trim(), achievements);
	}
	
	private void readProfessionalExperience(CombinedCV obj) throws IOException{
		String companyName = "";
		String jobTitle = "";
		String paragraph = "";
		String date = "";
		ArrayList<String> achievements = new ArrayList<String>();
		String parts[];
		String parts2[];
		
		
		String line;
		while (!((line = reader.readLine()).startsWith("EDUCATION AND TRAINING"))){
			
			line = line.trim();
			
			if (line.isEmpty() || (!line.contains("\\hspace{35pt}"))) { continue; }
			
			parts = line.split("hspace\\{35pt\\}");
			
			if (parts[1].startsWith("Company Name")){
				if (!(companyName.isEmpty())){
					
					obj.professionalExperienceSave(companyName.trim(), jobTitle.trim(), date.trim(), paragraph.trim(), achievements);
					achievements.clear();
				}
				parts2 = parts[1].split(":");
				parts2[1] = parts2[1].trim();
				parts = parts2[1].split("\\\\");
				companyName = parts[0];
			} else if (parts[1].startsWith("Job Title")){
				parts2 = parts[1].split(":");
				parts2[1] = parts2[1].trim();
				parts = parts2[1].split("\\\\");
				jobTitle = parts[0];
			} else if (parts[1].startsWith("Date")){
				parts2 = parts[1].split(":");
				parts2[1] = parts2[1].trim();
				parts = parts2[1].split("\\\\");
				date = parts[0];
			} else if (parts[1].startsWith("\\")){
				parts = line.split("-");
				parts[1] = parts[1].trim();
				parts2 = parts[1].split("\\\\");
				achievements.add(parts2[0].trim());
			} else {
				
				if (line.isEmpty() || (!line.contains("\\hspace{35pt}"))) { continue; }
				
				parts = line.split("hspace\\{35pt\\}");
				
				parts2 = parts[1].split("\\\\");
				
				if( !(parts2.length > 0) ){ continue; }
				
				paragraph = parts2[0]+"\n";
				
				while (!((line = reader.readLine()).startsWith("~\\\\"))){
					
					line = line.trim();
					
					if (line.isEmpty() || (!line.contains("\\hspace{35pt}"))) { continue; }
					
					parts = line.split("hspace\\{35pt\\}");
					
					parts2 = parts[1].split("\\\\");
					
					if( !(parts2.length > 0) ){ continue; }
					
					paragraph += parts2[0]+"\n";
					
				}
				
			}
			
		}
		
		obj.professionalExperienceSave(companyName.trim(), jobTitle.trim(), date.trim(), paragraph.trim(), achievements);
	}
	
	
	private void readEducationAndTraining(GenericCV obj) throws IOException{
		String qualification = "";
		String establishment = "";
		String location = "";
		String date = "";
		String line;
		String parts[];
		String parts2[];
		
		while (!((line = reader.readLine()).startsWith("FURTHER COURSES"))){
			
			line = line.trim();
			
			if (line.isEmpty()) { continue; }
			
			parts = line.split(":");
			
			parts[1]= parts[1].trim();
			
			
			parts2 = parts[1].split("\\\\");
			
			if (parts[0].startsWith("\\hspace{35pt}Qualification")){
				if (!(qualification.isEmpty())){
					
					obj.educationAndTrainingSaveFields(qualification.trim(), establishment.trim(), location.trim(), date.trim());
				}
				qualification = parts2[0];
			} else if (parts[0].startsWith("\\hspace{35pt}Establishment")){
				establishment = parts2[0];
			} else if (parts[0].startsWith("\\hspace{35pt}Location")){
				location = parts2[0];
			} else if (parts[0].startsWith("\\hspace{35pt}Date")){
				date = parts2[0];
			}
		}
		
		obj.educationAndTrainingSaveFields(qualification.trim(), establishment.trim(), location.trim(), date.trim());
	}
	
	private void readFurtherCourses(GenericCV obj) throws IOException{
		String course = "";
		String establishment = "";
		String location = "";
		String date = "";
		String line;
		String parts[];
		String parts2[];
		
		while (!((line = reader.readLine()).startsWith("ADDITIONAL INFORMATION"))){
			
			line = line.trim();
			
			if (line.isEmpty()) { continue; }
			
			parts = line.split(":");
			
			parts[1]= parts[1].trim();
			
			parts2 = parts[1].split("\\\\");
			
			if (parts[0].startsWith("\\hspace{35pt}Course")){
				if (!(course.isEmpty())){
					
					obj.furtherCoursesSaveFields(course.trim(), establishment.trim(), location.trim(), date.trim());
				}
				course = parts2[0];
			} else if (parts[0].startsWith("\\hspace{35pt}Establishment")){
				establishment = parts2[0];
			} else if (parts[0].startsWith("\\hspace{35pt}Location")){
				location = parts2[0];
			} else if (parts[0].startsWith("\\hspace{35pt}Date")){
				date = parts2[0];
			}
		}
		
		obj.furtherCoursesSaveFields(course.trim(), establishment.trim(), location.trim(), date.trim());
	}
	

}
