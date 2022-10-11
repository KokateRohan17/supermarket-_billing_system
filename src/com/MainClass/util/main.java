package com.MainClass.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import com.DAOclass.util.Dao;
import com.getset.util.Getsetclass;

public class main {
	

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("\t\t\t\t\t "+"  "+"Metro Mart SuperMarket Shop");  
        System.out.println("\t\t\t\t\t3/98 Mecrobertganj New Mumbai");  
        System.out.println("\t\t\t\t\t"  +"    " +"Opposite Metro Walk");  
        System.out.println("GSTIN: 03AWBPP8756K592"+"\t\t\t\t\t\t\tContact: (+91) 9988776655"); 
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");    
        LocalDate obj= LocalDate.now(); 
        Calendar calendar = Calendar.getInstance();  
        String[] days = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };  
        //prints current date and time  
        System.out.println("Date: "+(obj)+"  "+days[calendar.get(Calendar.DAY_OF_WEEK) - 1]);
		
        System.out.println("///////////////////////////////////////******************************************///////////////////////////////////");
        while(true){
        System.out.println("1.Create New List");
		System.out.println("2.Update List");
		System.out.println("3.Delate List");
		System.out.println("4.Search By ID");
		System.out.println("5.Show All List");
	        
	
		System.out.println("Enter Your Choice");
		int Choice=sc.nextInt();
		int id;
		String name;
		float price = 0;
		int qty;
		float totalprice;

		
		switch(Choice){
		
		case 1:System.out.println("Enter product id : ");
		id=sc.nextInt();
		System.out.println("Enter product name : ");
		name=sc.next();
		System.out.println("Enter product quantity");
		qty=sc.nextInt();
		System.out.println("Enter product Price : ");
		price=sc.nextFloat();
		
		totalprice=qty*price;
		
		boolean res=Dao.insertRecord(id,name,qty,price,totalprice);
		if(res)
			System.out.println("Created List Successfully");
		else
			System.out.println("Not created");
		break;
		case 2:System.out.println("Enter id");
			id=sc.nextInt();
			Getsetclass get=Dao.searchById(id);
			System.out.println("What do you want to update?");
	 		System.out.println("1. Product name");
	 		System.out.println("2. product Price");
	 		System.out.println("3. Product Quantity");
	 		int update =sc.nextInt();
	 		switch(update) {
	 		case 1: System.out.println("Enter New Product Name:");
	 		name = sc.next();
	 		get.setName(name);				 		 	
	 		break;
	 		case 2: System.out.println("Enter New Product price:");
			price = sc.nextInt();
			get.setPrice(price);
			break;
	 		
	 		case 3: System.out.println("Enter New Product quantity:");
			qty = sc.nextInt();
			get.setPrice(qty);	
			totalprice=qty*price;
			break;
	 		}
	 		res=Dao.updateRecord(get);
	 		if(res)
	 			System.out.println("updated successfuly");
	 		else
	 			System.out.println("not updated");
	 		break;
	 		
			case 3:
			System.out.print("Enter the ID of the product:");
	 		 id = sc.nextInt();	
	 		 res =Dao.deleteRecord(id);
			if(res)
				System.out.println("Deleted Successfully");
			else
				System.out.println("Not Deleted");
		break;
			
			
			
			
			case 4:
			System.out.print("Enter the ID of the product:");
			 id = sc.nextInt();
			 get = Dao.searchById(id);
			 if(get.getId() != 0)
				 System.out.println(get);
			 break;
			 
			 
			 
			 
			case 5:List<Getsetclass> p= Dao.getAllRecords();
	  		
	  		for(Getsetclass s:p) {
	  			System.out.println(s);
	  		}
	  		
	  		break;

		
		    }
		}
		
		

	}

}
