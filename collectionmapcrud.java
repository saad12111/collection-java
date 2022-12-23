package sspack;
import java.util.*;

class Students{
	private int id;
	private String name;
	private double mobile;
	
	Students() {
		// TODO Auto-generated constructor stub
	}
	Students(int id, String name, double mobile){
		this.id=id;
		this.name=name;
		this.mobile=mobile;
		}
	
	public String toString() {
		return id+"\t"+name+"\t"+mobile;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMobile() {
		return mobile;
	}
	public void setMobile(double mobile) {
		this.mobile = mobile;
	}
	
}

class Transaction{
					void show(Map<Integer, Students> map) {
						if(map.isEmpty()==true) {
									System.out.println("empty records in collection!");
									return;
						}
						
					Set<Map.Entry<Integer, Students>> set=map.entrySet();
					Iterator<Map.Entry<Integer, Students>> itr=set.iterator();
					while (itr.hasNext()==true) {
						Map.Entry<Integer, Students> element=itr.next();
						Integer key=element.getKey();
						Students student=element.getValue();
						System.out.println("key..."+key+"value..."+student);
						}
					}
				
				void insert(Map<Integer,Students> map, Students student) {
					map.put(student.getId(), student);
					System.out.println("record inserted successfully!!");
					}
				
				void delete(Map<Integer, Students> map, int id) {
					if(map.isEmpty()==true) {
						System.out.println("emptyy!!");
						return;
					}
				
				if(map.containsKey(id)==true) {
					System.out.println("key found!!");
					Students studel =map.remove(id);
					System.out.println("record removed!!");
				}
				else {
					System.out.println("invalid id");
				}
				}
	void update(Map<Integer, Students> map, Students Student ) {
		if(map.isEmpty()==true) {
			System.out.println("empty!!");
			return;
		}
	if(map.containsKey(Student.getId())==true) {
		System.out.println("key found!");
		map.put(Student.getId(), Student);
		System.out.println("modified successfully!!");
	}	
	else {
		System.out.println("invalid key");
	}
	}				
}
public class collectionmapcrud {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Map<Integer, Students> map;
			map=new HashMap<Integer, Students>();
			
			Transaction transaction = new Transaction();
			
	while(true) {
		Scanner sc=new Scanner (System.in);
		
		System.out.println("1. register new student");
		System.out.println("2. display all students");
		System.out.println("3. delete students records");
		System.out.println("4. update students records");
		System.out.println("5. exit software");
		System.out.println("enter what operation you want to do here! ");
		
		int choice=sc.nextInt();
		
		switch(choice) {
		case 1: 
			Scanner sc1=new Scanner(System.in);
			Students student=new Students();
			System.out.println("enter new student name:  ");
			student.setName(sc1.nextLine());
			
			System.out.println("enter  student contact info:  ");
			student.setMobile(sc1.nextDouble());
			
			System.out.println("enter new student id:  ");
			student.setId(sc1.nextInt());
			
			transaction.insert(map, student);
			break;
		
		case 2:
			transaction.show(map);
			break;
		case 3: Scanner sc2=new Scanner(System.in);	
				System.out.print("enter employee id to delete: ");
		       int id=sc2.nextInt();
		      transaction.delete(map, id);
		break;
		case 4: Scanner sc3=new Scanner(System.in);	
		Students student1=new Students();
		        System.out.println("enter updated name:");
		        student1.setName(sc3.nextLine());
		        System.out.println("enter updated contact:");
		        student1.setMobile(sc3.nextDouble());
		        System.out.println("enter updated id:");
		        student1.setId(sc3.nextInt());
		        
		      transaction.update(map, student1);
		  break;
		  
		case 5: System.exit(0);
		        default:
		        	System.out.println("invalid action !");
		        	break;
		}
	}
	}

}
