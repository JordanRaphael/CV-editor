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

public class InputParserTXT implements InputParser{
	
	private GenericCV cv;
	private BufferedReader reader;
	private String filename = "information.txt";
	
	public InputParserTXT(GenericCV cv){
		this.cv = cv;
	}
	
	public InputParserTXT(GenericCV cv,String filename){
		this.cv = cv;
		this.filename = filename;
	}
	
	@Override
	public GenericCV readFromFile(){
		
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
		
		while (!(line = reader.readLine()).startsWith("PROFESSIONAL PROFILE")){
			
			if (line.isEmpty()) { continue; }
			
			String[] parts = line.split(":");
			
			parts[0] = parts[0].trim();
			
			if (parts[0].startsWith("Name")){
				name = parts[1];
			} else if (parts[0].startsWith("Address")){
				address = parts[1];
			} else if (parts[0].startsWith("Home Telephone")){
				homeTelephone = parts[1];
			} else if (parts[0].startsWith("Mobile Telephone")){
				mobileTelephone = parts[1];
			} else if (parts[0].startsWith("Email")){
				email = parts[1];
			}
			
		}
		
		obj.generalInformationSaveFields(name.trim(), address.trim(), homeTelephone.trim(), mobileTelephone.trim(), email.trim());
	}
	
	private String readParagraph(String nextSection) throws IOException{
		String line;
		String paragraph = "";
		
		while (!((line = reader.readLine()).startsWith(nextSection))){
			line = line.trim();
			paragraph += line+"\n";
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
			if (line.startsWith("SKILLS AND EXPERIENCE ON")){
				
				parts = line.split("<");
				parts2 = parts[1].split(">");
				title = parts2[0];
				obj.skillsAndExperienceSaveTitle(title.trim());
				
			}
			if (line.startsWith("*")){
				parts = line.split("\\*");
				paragraph = parts[1]+"\n";
				while (!((line = reader.readLine()).isEmpty())){
					line = line.trim();
					paragraph += line+"\n";
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
			if (line.startsWith("SKILLS AND EXPERIENCE ON")){
				
				parts = line.split("<");
				parts2 = parts[1].split(">");
				title = parts2[0];
				obj.skillsAndExperienceSaveTitle(title);
				
			}
			if (line.startsWith("*")){
				parts = line.split("\\*");
				paragraph = parts[1]+"\n";
				while (!((line = reader.readLine()).isEmpty())){
					line = line.trim();
					paragraph += line+"\n";
				}
				
				obj.skillsAndExperienceSaveParagraph(paragraph.trim());
			}
			
		}
	}
	
	private void readProfessionalExperience(ChronologicalCV obj) throws IOException{
		String companyName = "";
		String jobTitle = "";
		String paragraph = "";
		String date = "";
		ArrayList<String> achievements = new ArrayList<String>();
		String parts[];
		
		
		String line;
		while (!((line = reader.readLine()).startsWith("EDUCATION AND TRAINING"))){
			
			line = line.trim();
			
			if (line.isEmpty()) { continue; }
			
			if (line.startsWith("Company Name")){
				if (!(companyName.isEmpty())){
					obj.professionalExperienceSave(companyName.trim(), jobTitle.trim(), date.trim(), paragraph.trim(), achievements);
				}
				parts = line.split(":");
				parts[1] = parts[1].trim();
				companyName = parts[1];
			} else if (line.startsWith("Job Title")){
				parts = line.split(":");
				parts[1] = parts[1].trim();
				jobTitle = parts[1];
			} else if (line.startsWith("Date")){
				parts = line.split(":");
				parts[1] = parts[1].trim();
				date = parts[1];
			} else if (line.startsWith("*")){
				parts = line.split("\\*");
				parts[1] = parts[1].trim(); 
				achievements.add(parts[1].trim());
			} else {
				paragraph = line+"\n";
				
				while (!((line = reader.readLine()).isEmpty())){
					paragraph += line.trim()+"\n";
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
		
		
		String line;
		while (!((line = reader.readLine()).startsWith("EDUCATION AND TRAINING"))){
			
			line = line.trim();
			
			if (line.isEmpty()) { continue; }
			
			if (line.startsWith("Company Name")){
				if (!(companyName.isEmpty())){
					obj.professionalExperienceSave(companyName.trim(), jobTitle.trim(), date.trim(), paragraph.trim(), achievements);
				}
				parts = line.split(":");
				parts[1] = parts[1].trim();
				companyName = parts[1];
			} else if (line.startsWith("Job Title")){
				parts = line.split(":");
				parts[1] = parts[1].trim();
				jobTitle = parts[1];
			} else if (line.startsWith("Date")){
				parts = line.split(":");
				parts[1] = parts[1].trim();
				date = parts[1];
			} else if (line.startsWith("*")){
				parts = line.split("\\*");
				parts[1] = parts[1].trim(); 
				achievements.add(parts[1].trim());
			} else {
				paragraph = line+"\n";
				
				while (!((line = reader.readLine()).isEmpty())){
					paragraph += line.trim()+"\n";
				}
				
			}
			
		}
		
		obj.professionalExperienceSave(companyName.trim(), jobTitle.trim(), date.trim(), paragraph.trim(), achievements);
	}
	
	private void readCareerSummary(FunctionalCV obj) throws IOException{
		String companyName = "";
		String jobTitle = "";
		String date = "";
		String parts[];
		
		
		String line;
		while (!((line = reader.readLine()).startsWith("EDUCATION AND TRAINING"))){
			
			line = line.trim();
			
			if (line.isEmpty() || (!line.contains(":"))) { continue; }
			
			parts = line.split(":");
			parts[1] = parts[1].trim();
			if (line.startsWith("Company Name")){
				if (!(companyName.isEmpty())){
					obj.careerSummarySave(companyName.trim(), jobTitle.trim(), date.trim());
				}
				companyName = parts[1];
			} else if (line.startsWith("Job Title")){
				
				jobTitle = parts[1];
			} else if (line.startsWith("Date")){
				
				date = parts[1];
			} 
			
		}
		
		obj.careerSummarySave(companyName.trim(), jobTitle.trim(), date.trim());
	}
	
	private void readEducationAndTraining(GenericCV obj) throws IOException{
		String qualification = "";
		String establishment = "";
		String location = "";
		String date = "";
		String line;
		String parts[];
		
		while (!((line = reader.readLine()).startsWith("FURTHER COURSES"))){
			
			line = line.trim();
			
			if (line.isEmpty()) { continue; }
			
			parts = line.split(":");
			
			parts[1]= parts[1].trim();
			
			if (parts[0].startsWith("Qualification")){
				if (!(qualification.isEmpty())){
					obj.educationAndTrainingSaveFields(qualification.trim(), establishment.trim(), location.trim(), date.trim());
				}
				qualification = parts[1];
			} else if (parts[0].startsWith("Establishment")){
				establishment = parts[1];
			} else if (parts[0].startsWith("Location")){
				location = parts[1];
			} else if (parts[0].startsWith("Date")){
				date = parts[1];
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
		
		while (!((line = reader.readLine()).startsWith("ADDITIONAL INFORMATION"))){
			
			line = line.trim();
			
			if (line.isEmpty()) { continue; }
			
			parts = line.split(":");
			
			parts[1]= parts[1].trim();
			
			if (parts[0].startsWith("Course")){
				if (!(course.isEmpty())){
					obj.furtherCoursesSaveFields(course.trim(), establishment.trim(), location.trim(), date.trim());
				}
				course = parts[1];
			} else if (parts[0].startsWith("Establishment")){
				establishment = parts[1];
			} else if (parts[0].startsWith("Location")){
				location = parts[1];
			} else if (parts[0].startsWith("Date")){
				date = parts[1];
			}
		}
		
		obj.furtherCoursesSaveFields(course.trim(), establishment.trim(), location.trim(), date.trim());
	}
	
	private void readInterests(GenericCV obj) throws IOException{
		String line;
		String paragraph = "";
		
		while ((line = reader.readLine()) != null){
			line = line.trim();
			paragraph += line+"\n";
		}
		
		obj.interestsSave(paragraph.trim());
	}
}
