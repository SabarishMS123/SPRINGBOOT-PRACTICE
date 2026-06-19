package in.sp.main;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.build.AllowSysOut;

import in.sp.entities.User;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	User user=new User();
    	user.setId(1);
    	user.setName("Sree");
    	user.setEmail("Sree123@gmail.com");
    	user.setPassword("sree123");
    	user.setGender("Female");
    	user.setCity("Salem");
//    	
    	
//    	for another user just change as user1
    	
//    	User users=new User();
//    	users.setName("Anu");
//    	users.setEmail("anu123@gmail.com");
//    	users.setPassword("anu123");
//    	users.setGender("Female");
//    	users.setCity("Salem");
//    	
    	
    	
        System.out.println( "Hello World!" );
        Configuration cfg = new Configuration();
		 cfg.configure("hibernate.cfg.xml"); // explicit file name
		 SessionFactory sf = cfg.buildSessionFactory();
		 Session session=sf.openSession();
		 Transaction transaction=session.beginTransaction();
		 
//		 ==============INSERT OPERATION=================
		 
//		 for insert operation -> save()
//		 try {
////			 session.save(user);
////			 session.save(users);
//			 transaction.commit();
//			 
//			 System.out.println("User Details are inserted Successfully!!!");
//		 }
//		 catch(Exception e){
//			 transaction.rollback();
//			 e.printStackTrace();
//			 
//			 System.out.println("User Details not inserted due to Errors!!!");
//		 }
		 
		 
//		 ===============SELECT OPERATION====================
//		 try {
//			 User users1=session.get(User.class,1L);
		 
//			 if(users1!=null) {
//				 
//			 
//		     System.out.println(users1.getId());
//		     System.out.println(users1.getName());
//		     System.out.println(users1.getEmail());
//		     System.out.println(users1.getPassword());
//		     System.out.println(users1.getGender());
//		     System.out.println(users1.getCity());
//		 }
//			 else {
//				 System.out.println("User not found!");
//			 }
//		 }
//		 catch(Exception e) {
//			 e.printStackTrace();
//			 
//		 }
//		 
		 
//		 ==============UPDATE OPERATIONS=========================
//		 User users2=new User();
//		 users2.setId(2);
//		 users2.setCity("Madurai");
		 
		 
//		 code is somewhat similar to insert operation

		 
//		 try {
//	 
////			To get full details in table without null at output in mysql
//		 
//		 User users2=session.get(User.class,2L);
//		 users2.setCity("Bangalore");
////		 
////		 
//			 session.saveOrUpdate(users2);
//			 transaction.commit();
////			 
//			 System.out.println("User Details are updated Successfully!!!");
//		 }
//		 catch(Exception e){
//			 transaction.rollback();
//			 e.printStackTrace();
////			 
//			 System.out.println("User Details not updated due to Errors!!!");
//		 }
		 
//		 
//		 
//		 
//		 
//		 =================DELETE OPERATION =========================
		 
		 try {
			 User users1=new User();
			 users1.setId(1L);
			 
			 session.delete(users1);
			 transaction.commit();
			 
			 System.out.println("USER DETAILS IS DELETED SUCCESSFULLY!!!");
		 }
	  catch(Exception e) {
		  transaction.rollback();
		  e.printStackTrace();
		  
		  System.out.println("USER DETAILS IS NOT DELETED DUE TO SOME ERRORS");
	  }
//		 
		 
		 
		 
		
		 

    }
}
