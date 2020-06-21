package CVConstruction;

import java.util.Comparator;

public class FurtherCourses implements Comparator<FurtherCourses>{

	// Further courses fields
	private String course;
	private String establishment;
	private String location;
	private String date;
	
	public String getCourse() {
		return course;
	}

	public String getEstablishment() {
		return establishment;
	}

	public String getLocation() {
		return location;
	}

	public String getDate() {
		return date;
	}
	
	public void printInfo(){
		System.out.println(course+"\n"+establishment+"\n"+location+"\n"+date);
	}
		
	public void saveFields(String newCourse, String newEstablishment, String newLocation, String newDate){
		course = newCourse;
		establishment = newEstablishment;
		location = newLocation;
		date = newDate;
	}
	
	@Override
	public boolean equals(Object obj){
		if (!(obj instanceof FurtherCourses)) return false;
		FurtherCourses other = (FurtherCourses)obj;
		return (this.course.equals(other.course)
				&& this.establishment.equals(other.establishment)
				&& this.location.equals(other.location)
				&& this.date.equals(other.date));
	}
	
	@Override
	public String toString(){
		return course+","+establishment+","+location+","+date;
	}
	
	@Override
	public int compare(FurtherCourses obj1, FurtherCourses obj2){
		String[] date1 = obj1.getDate().split("/",-1);
		String[] date2 = obj2.getDate().split("/",-1);
		try{
			if (date2[2].compareTo(date1[2]) > 0){
				return 1;
			} else if (date2[2].compareTo(date1[2]) < 0){
				return -1;
			} else if (date2[1].compareTo(date1[1]) > 0){
				return 1;
			} else if (date2[1].compareTo(date1[1]) < 0){
				return -1;
			} else if (date2[0].compareTo(date1[0]) > 0){
				return 1;
			} else if (date2[0].compareTo(date1[0]) < 0){
				return -1;
			}
			return 0;
		} catch(Exception e){
			return 0;
		}
	}
	
	public int compareObjects(FurtherCourses otherObj){
		String otherCourse = otherObj.getCourse();
		String otherEstablishment = otherObj.getEstablishment();
		String otherLocation = otherObj.getLocation();
		String otherDate = otherObj.getDate();
		
		if (!this.date.equals(otherDate)){
			return 1;
		} else if (!this.establishment.equals(otherEstablishment)) {
			return 1;
		} else if (!this.location.equals(otherLocation)){
			return 1;
		} else if (!this.course.equals(otherCourse)) {
			return 1;
		}
		
		return 0;
	}
	
}
