package sspack;

import java.util.*;

class Mystudent{
	 private int id;
	 private String name;
	 private double Mobile;
	 
	 Mystudent(){}
	 Mystudent(String name , double salary){
		 this.id=id;
		 this.name=name;
		 this.Mobile=Mobile;
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
		return Mobile;
	}
	public void setMobile(double Mobile) {
		this.Mobile = Mobile;
	}
	 
	public String toString() {
		return id+"\t"+name+"\t"+Mobile;
	}
}

class MyTransaction{
				void create (SortedMap<Integer, Mystudent> map, Mystudent student) {
				int id=-1;
				if(map.isEmpty()==true) {
					id=1;
				}
			else {
				              id=map.lastKey()+1;  //unboxing
			}	
	student.setId(id);
	
	map.put(student.getId(), student);
	System.out.println("inserted successfully");
}
				void show(SortedMap<Integer, Mystudent> map) {
				           if(map.isEmpty()==true) {
				        	   System.out.println("empty records!");
				        	   return;
				        }
				           Set<Integer> set=map.keySet();
				   		for(Iterator<Integer> itr=set.iterator(); 
				   				itr.hasNext()==true;) {
				   			Integer key=itr.next();
				   Mystudent student =map.get(key);
				   System.out.println("key="+key+"value="+student);
				   
				}
				}
				void delete(SortedMap<Integer, Mystudent> map, int id) {
					if(map.isEmpty()==true) {
						System.out.println("collection empty");
						return;
					}
					
					boolean found=map.containsKey(id);
					if(found==false) {
						System.out.println("invalid id given to delete");
						
					}
					else {
						Mystudent delstu=map.remove(id);
						System.out.println(delstu+" removed from collection");
					}
				}		
				void update(SortedMap<Integer, Mystudent>map , Mystudent student) {
					if(map.isEmpty()==true) {
						System.out.println("collection empty");
						return;
					}
					boolean found=map.containsKey(student.getId());
					if(found==false) {
						System.out.println("invalid key given to modify");
					}
					else {
						map.put(student.getId(), student);
						System.out.println("modified succuessfully");
					}
				}			
				}
				
public class Sortedmap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortedMap<Integer, Mystudent> map;
		map=new TreeMap<>(); //will work on same reference 
		
		MyTransaction myTransaction=new MyTransaction();
		
		while(true) {
			Scanner sc=new Scanner(System.in);
			
			System.out.println("1. admit new student");
			System.out.println("2. show all students");
			System.out.println("3. delete record of a student");
			System.out.println("4. updation of a student record");
			System.out.println("5. take exit");
			System.out.println("enter choice action....     1/2/3/4/5: ");
		
			int choice=sc.nextInt();
			switch(choice) {
			case 1: Mystudent student = new Mystudent();
			
			Scanner sc1=new Scanner(System.in);
			System.out.print("enter new student name: ");
			student.setName(sc1.nextLine());
			System.out.print("enter mobile number:");
			student.setMobile(sc1.nextDouble());
			
			myTransaction.create(map, student);
			break;
		case 2:
			myTransaction.show(map);
			break;
		case 3:
			Scanner sc2=new Scanner(System.in);
			System.out.print("enter  id to delete: ");
			int id=sc2.nextInt();
			myTransaction.delete(map, id);
			break;
		case 4:
			
			Mystudent student2 = new Mystudent();
			
			Scanner sc3=new Scanner(System.in);
			System.out.print("enter updated student name: ");
			student2.setName(sc3.nextLine());
			System.out.print("enter updated mobile number:");
			student2.setMobile(sc3.nextDouble());
			System.out.print("enter id  number to update:");
			student2.setId(sc3.nextInt());
			
			myTransaction.update(map, student2);
			break;
		
		case 5:
			if(map.isEmpty()==true) {
				System.out.println("collection empty");
			}
			else {
				Set<Integer> set=map.keySet();
				for(Iterator<Integer> itr=set.iterator(); 
						itr.hasNext()==true;) {
					Integer key=itr.next();
					Mystudent student3=map.get(key);
					System.out.println("key="+key+" value="+student3);
				}
			}
			System.out.println("thanx for using my software, have a nice day!");
			System.exit(0);
			default:
				System.out.println("please enter valid choice action!");
				break;
			}
			}
			
	}

}
