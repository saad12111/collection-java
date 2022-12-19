package collectioncrudpro;
import java.util.*;


class Student{
	private int id;
	private String fname;
	private String lname;
	private String mobno;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getMobno() {
		return mobno;
	}
	public void setMobno(String mobno) {
		this.mobno = mobno;
	}
	public Student() {}
	public Student(int id, String fname, String lname ,String mobno) {
		this.id=id;
		this.fname=fname;
		this.lname=lname;
		this.mobno=mobno;
	}
	
	public String toString() {
		String str=id+"\t "+fname+"\t "+lname+"\t"+mobno;
		return str;
	}
}
interface StudentDao {
	void add(Vector<Student>students);
	void show (Vector<Student>students);
	void delete(Vector<Student> students);
	void update(Vector<Student> students);
	int[] findid(Vector<Student> students);
}
class StudentDaoImpl implements StudentDao{

	@Override
	public void add(Vector<Student> students) {
		// TODO Auto-generated method stub
		Student student=new Student();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter student's first name:");
		student.setFname(sc.nextLine());
		System.out.println("enter student's Last name");
		student.setLname(sc.nextLine());
		System.out.println("enter student's Mobile number");
		student.setMobno(sc.nextLine());
		System.out.println("enter student id:");
		
		students.add(student);
		System.out.println(student.getId()+" record "+"  inserted in vector collection !");
	}

	@Override
	public void show(Vector<Student> students) {
		// TODO Auto-generated method stub
		if(students.isEmpty()==true) {
			System.out.println("collection is empty  ,  insert some records!");
			return;
		}
		
		Enumeration<Student> enumeration=students.elements();
		while(enumeration.hasMoreElements()==true) {
			Student element=enumeration.nextElement();
			System.out.println(element);
		}
	}

	@Override
	public void delete(Vector<Student> students) {
		// TODO Auto-generated method stub
		if(students.isEmpty()==true) {
			System.out.println("collection is empty");
			return;
		}
		Scanner sc=new Scanner(System.in);
		System.out.print("enter an id to delete record: ");
		int id=sc.nextInt();
		int index=-1;
		for(int i=0;i<students.size();i++) {
			Student student=students.get(i);
			if(student.getId()==id)
				index=i;
		}
		if(index==-1) 
			System.out.println("invalid  id given");
		else
		{
			students.remove(index);
			System.out.println("student removed with id="+id);
		}
	}

	@Override
	public void update(Vector<Student> students) {
		// TODO Auto-generated method stub
		if(students.isEmpty()==true) {
			System.out.println("collection is empty");
			return;
		}

		int[]  res=this.findid(students);
		if(res==null) {
			System.out.println("invalid id given");
			return;
		}
		
		Student student=new Student();
		
		Scanner sc=new Scanner(System.in);
		
		
		System.out.print("enter modified first name: ");
		student.setFname(sc.nextLine());
		
		System.out.print("enter modified Last name");;
		student.setLname(sc.nextLine());
		
		System.out.print("enter modified mobile number: ");
		student.setMobno(sc.nextLine());
		
		student.setId(res[1]);
		
		students.set(res[0], student);
		System.out.println("record modified with id="+res[1]);
		
	}

	@Override
	public int[] findid(Vector<Student> students) {
		// TODO Auto-generated method stub
Scanner sc=new Scanner(System.in);
		
		System.out.print("type existing  id to modify: ");
		int id=sc.nextInt();

		int index=-1; 
		for(int i=0;i<students.size();i++) {
			Student student2=students.get(i);
			if(student2.getId()==id) {
				
				index=i;
				break;
			}
		}

		if(index==-1) {
			int[] res=null;
			return res;
		}
		
		int[] res=new int[2];
		res[0]=index;
		res[1]=id;
		return res;
	}

	
	}
public class Vectordemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentDao dao=new StudentDaoImpl();
		Scanner sc=new Scanner(System.in);
		Vector<Student> students=new Vector<>();
		
	while(true) {
		System.out.println("1. insert a new record");
		System.out.println("2. fetch all records!");
		System.out.println("3. delete by  id");
		System.out.println("4. modify existing  record by id");
		System.out.println("5. exit program");
		System.out.println("enter your choice : 1/2/3/4/5");
		int choice=sc.nextInt();
		
		switch(choice) {
		case 1:
			 dao.add(students);
			 break;
		case 2:
			dao.show(students);
			break;
		case 3:
			dao.delete(students);
		case 4:
			dao.update(students);
		case 5:
			System.out.println("thanx for using my software , have a nice day !!");
			System.exit(0);
		}
	}
	}

}
