package demoTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class Student{
	String studentName;
	int rollNumber;
	String address;
	String phoneNumber;
	Student(
	String studentName,
	int rollNumber,
	String address,
	String phoneNumber){
		this.studentName=studentName;
		this.rollNumber=rollNumber;
		this.address=address;
		this.phoneNumber=phoneNumber;
	}
	public void DetailsOfStudent() {
		System.out.println("My name is"+studentName+"Roll no"+rollNumber+"from"+address+"contact"+phoneNumber);
	}
}
class Grades extends Student{
	String grade;
	
	Grades(String studentName,String grade){
		super(studentName, 0,null,null);
//		super(studentName,0,0,0);=error
		this.grade=grade;
		
		
	}
	public String positionBasedOnGrade(String grade) {
		if(Integer.parseInt(grade)<=5) {
			return "Pre-Primary";
			
		}else if(Integer.parseInt(grade)>=5 && Integer.parseInt(grade)<=8) {
			return "Primary";
		}else {
			return "Higher";
		}
	}
}

public class FirstTest {

	public static void main(String[] args) {
		Grades[] g=new Grades[] {new Grades("AMir","5"),
				new Grades("sadaf","10"),
				new Grades("nikhath","7")};
		Grades gMethod=new Grades("AMir","5");
		gMethod.positionBasedOnGrade("5");
		
		for(Grades g1:g) {
			String gradeValue=g1.positionBasedOnGrade(g1.grade);
			System.out.println("My name is"+g1.studentName+"Student of"+gradeValue+"Grade");
			
		}
//		Student[] s1=new Student[] {
//			new Student("AMir",910,"HYD","910065"),
//			new Student("sadaf",123,"BANG","832893"),
//			new Student("nikhath",124,"India","382173")
//		};
//		for(Student s:s1) {
//			System.out.println("My name is"+s.studentName+"Roll no"+s.rollNumber+"from"+s.address+"contact"+s.phoneNumber);
//		}
	}

}
