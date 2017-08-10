

import java.util.ArrayList;
import java.util.List;

public class Book {

	public static void main(String[] args) {
		//_test();
		_test1();
	}
	
	static void _test(){
		Faculty f=new Faculty("S Roy","CS01" , "CSE","9210234505","1-B, IIT KGP");
		f.print_Info();
		Course c1=new Course(40,"NLP");
		Course c2=new Course(30,"IR");
		f.add_course(c1);
		f.add_course(c2);
		System.out.println("\n After adding 2 courses");
		f.print_Info();
		f.delete_course(c1);
		System.out.println("\n After deleting 1 course");
		f.print_Info();
	}
	static void _test1(){
		Course c1= new Course(40,"NLP");
		//Course c2=new Course(30,"OOSD");
		Student s1=new Student("ABC","CS001");
		//Student s2= new Student("BCD","CS002");
		//Student s3=new Student("CDE","CS003");
		//Student s4=new Student("EFG","CS004");
		c1.register_student(s1);
		c1.deregister_student(s1);
		s1.AddCourse(c1);
		s1.DeleteCourse(c1);
		/*c1.register_student(s2);
		c1.register_student(s3);
		c1.register_student(s4);
		c1.register_student(s3);
		c2.register_student(s4);
		c2.register_student(s1);
		c2.register_student(s2);
		c2.register_student(s3);*/
		c1.print_Info();
		//c2.print_Info();
		Faculty f=new Faculty("S Roy","CS01" , "CSE","9210234505","1-B, IIT KGP");
		f.print_Info();
		Course cx=new Course(40,"NLP");
		f.add_course(cx);
		f.delete_course(cx);
		Department d=new Department("CSE", "007");
		d.Add_Faculty(f);
		d.Add_Faculty(f);
		d.Add_Course(cx);
		d.Delete_Course(cx);
		d.Add_Student(s1);
		d.Delete_Student(s1);
	}

}





class Course {
	    String C_Name;
	    List<Student> students;			//student list is a type of Student Class
		int max_student;				//every student will be member of  upper student class,creates array list
		
		Course(int n,String name){
			max_student=n;
			C_Name=name;
		    students=new ArrayList<Student>();
		} 
		void register_student(Student st){		//integration callee method, store this st to array list
			students.add(st);
			st.AddCourse(this);
		}
		
		void deregister_student(Student st){
			students.remove(st);
			st.DeleteCourse(this);
		}
		void print_Info(){
			System.out.println("Course_Name:"+C_Name);
			System.out.println("Students in the course ");
			int i=1;
			for(Student s: students){
				System.out.println((i++)+" : "+s.name+" "+s.sid);
			}

		}
}




class Faculty {
	String f_name;
	String f_id;
	List<Course> teaches;
	String dept_id;
	String contact;
	String address;
	Faculty(String name, String id, String d_id,String contact1,String address1){
		f_name=name;
		f_id=id;
		dept_id=d_id;
		contact=contact1;
		address=address1;
		teaches=new ArrayList<Course>();
	}
	void add_course(Course c){
		teaches.add(c);
		
		
	}
	void setid(String id){
		f_id=id;
		
	}
	String getid(){
	    return f_id;	
	}
	void delete_course(Course c){
		teaches.remove(c);
	}
	void print_Info(){
		System.out.println("Name:"+f_name+"\nId:"+f_id+"\nDepartment ID:"+dept_id+"\nContact:"+contact+"\nAddress:"+address);
		System.out.println("Course Teaches:");
		int i=1;
		for(Course c:teaches){
			System.out.println((i++)+" : "+c.C_Name);
		}
	}
}





class Department {
	String d_name;
	String d_id;
	List<Course> c_offered;
	List<Faculty> fac;
	List<Student> stud;
		Department(String name,String id){				//constructor
			fac=new ArrayList<Faculty>();
			stud=new ArrayList<Student>();
			c_offered=new ArrayList<Course>();
			d_name=name;
			d_id=id;
		}
		public void Add_Faculty(Faculty a){			//integration callee Add_Faculty	as it takes object as parameter
			fac.add(a);
			a.getid();
		}
		public void Delete_Faculty(Faculty a){			//integration callee Add_Faculty	as it takes object as parameter
			fac.remove(a);
			a.setid("abc");
		}
		public void Add_Student(Student a){			//integration callee Add_Faculty	as it takes object as parameter
			stud.add(a);
		}
		public void Delete_Student(Student a){			//integration callee Add_Faculty	as it takes object as parameter
			stud.remove(a);
		}
		public void Add_Course(Course a){			//integration callee Add_Faculty	as it takes object as parameter
			c_offered.add(a);
		}
		public void Delete_Course(Course a){			//integration callee Add_Faculty	as it takes object as parameter
			c_offered.remove(a);
		}
}





class Student{
String name;
String sid;
String address;
List<Course> enrolled;   //list of enrolled of type Course class
int no_courses;
String dob;
int contact;
Student(String _name, String _roll_no){       //constructor
	enrolled=new ArrayList<Course>();
	this.name=_name;
    this.sid=_roll_no;              
}
void AddCourse(Course c){
	enrolled.add(c);
}
void DeleteCourse(Course c){
	enrolled.remove(c);

}

}
