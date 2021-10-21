package HyperioDev;

//****************Import required java packages we will be using in our program*****************************************************

import javax.swing.JOptionPane;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.util.Scanner;
import java.util.Formatter;


public class Poised {
	
		//The main method starts our java program
		public static void main (String [] args)
	   {
		 			 
//*********************************Create arrays and variables*******************************************************************
			
			//Firstly I create arrays for the projects, architects, contractors and customers.
			//I will append or add the respective objects to each of these arrays.
			List<Project> projects = new ArrayList<Project>();
			List<Architect> architects = new ArrayList<Architect>();
			List<Contractor> contractors = new ArrayList<Contractor>();
			List<Customer> customers = new ArrayList<Customer>();
		 
			//Declare user option variable - this will store the user's option for the task they want to perform
			int user_choice;
			
			//The outstanding variable stores the value outstanding for the respective project
			float outstanding = 0;
			
			
//***************************Read in Projects file and append details to respective arrays****************************************
			
			
			 //First I open the projects.txt file if it exits and read in the existing projects
			 File text = new File("projects.txt");
			   
			 try {
			 //Creating Scanner instance to read File in Java
		     Scanner scnr = new Scanner(text);
		     
		     //The below code reads in each line from the projects.txt file and creates the respective objects to be added to the respective arrays
		     
		     while(scnr.hasNextLine()){
		    	 
		    	 	//We split the line by "," and link to the line_split array
		            String line = scnr.nextLine();
		            String[] line_split = line.split(",",-1);
		            
		            //From here we create variables to hold the project details
		            int prj_num = Integer.parseInt(line_split[0]);
		            String prj_name = line_split[1];
		            String prj_type = line_split[2];
		            String prj_address = line_split[3];
		            int prj_erf = Integer.parseInt(line_split[4]);
		            float prj_charged = Float.parseFloat(line_split[5]);
		            float prj_paid = Float.parseFloat(line_split[6]);
		            String prj_deadline = line_split[7];
		            String prj_overdue = line_split[8];
		            String prj_completion = line_split[9];
		            String prj_status = line_split[10];
		            
		            //Here we create the variables to hold the architect details
		            String arc_name = line_split[11];
		            String arc_tel = line_split[12];
		            String arc_email = line_split[13];
		            String arc_address = line_split[14];
		            
		            //Next we use this to create an Architect object an add to the architects array
		            Architect arc = new Architect(arc_name, arc_tel, arc_email, arc_address);
		            architects.add(arc);
		            
		            //Here we create the variables to hold the contractor details
		            String con_name = line_split[15];
		            String con_tel = line_split[16];
		            String con_email = line_split[17];
		            String con_address = line_split[18];
		            
		            //Next we use this to create an Contractor object an add to the contractors array
		            Contractor con = new Contractor(con_name, con_tel, con_email, con_address);
		            contractors.add(con);
		            
		            //Here we create the variables to hold the customer details
		            String cus_name = line_split[19];
		            String cus_tel = line_split[20];
		            String cus_email = line_split[21];
		            String cus_address = line_split[22];
		            
		            //Next we use this to create an Customer object an add to the customers array
		            Customer cus = new Customer(cus_name, cus_tel, cus_email, cus_address);
		            customers.add(cus);
		            
		            //Lastly we create the Project object with all the project details and append to the projects array
		            Project proj = new Project(prj_num, prj_name, prj_type, prj_address, prj_erf, prj_charged, prj_paid, prj_deadline, prj_overdue, prj_completion, prj_status, arc, con, cus);
		            projects.add(proj);
		     	}
		     } catch (Exception e) {
		    	 System.out.println("There are no saved projects currently");
		     }
			

//************************Next if there are existing projects I print out details that user can use to identify the projects*************
			 
			 //If there is existing project then print project identifiers
			 if (projects.size() > 0) {
				 System.out.println("Current Projects:");
				 
				 for(int i=0; i<projects.size(); i++) {
					 int j = i+1;
					 System.out.println("Project "+j);
					 String out = "";
					 //out += 
					 System.out.println("Name: "+projects.get(i).name);
					 System.out.println("Number: "+projects.get(i).number+"\n");
					 
				 }
			 }
			 
			 
			 //If there is existing architects then print architect identifiers
			 if (architects.size() > 0) {
				 System.out.println("Current Architects:");
				 
				 for(int i=0; i<architects.size(); i++) {
					 int j = i+1;
					 System.out.println("Architect "+j);
					 String out = "";
					 System.out.println("Name: "+architects.get(i).name);
					 System.out.println("Email: "+architects.get(i).email+"\n"); 
				 }
			 }
			 
			 
			//If there is existing contractors then print contractor identifiers
			 if (contractors.size() > 0) {
				 System.out.println("Current contractors:");
				 
				 for(int i=0; i<contractors.size(); i++) {
					 int j = i+1;
					 System.out.println("Contractor "+j);
					 String out = "";
					 System.out.println("Name: "+contractors.get(i).name);
					 System.out.println("Email: "+contractors.get(i).email+"\n");	 
				 }
			 }
			 
			 
			//If there is existing customers then print customer identifiers
			 if (customers.size() > 0) {
				 System.out.println("Current customers:");
				 
				 for(int i=0; i<customers.size(); i++) {
					 int j = i+1;
					 System.out.println("Customer "+j);
					 String out = "";
					 System.out.println("Name: "+customers.get(i).name);
					 System.out.println("Email: "+customers.get(i).email+"\n");	 
				 }
			 }
		
//***********Next I execute a do while loop that performs the users chosen task so long as the user does not want to exit the program***********************		
			
			//Do-While loop
			do 
			{
				//Create a GUI for the user to choose which task/option they want to perform
				user_choice = user_options();

				//If user selects 1, then we add the project instance with the user inputs
				if(user_choice == 1) {
					
					//Create skeleton objects and append to respective array
					Architect architect = new Architect(" ", " ", " ", " ");
					architects.add(architect);
					Contractor contractor = new Contractor(" ", " ", " ", " ");
					contractors.add(contractor);
					Customer customer = new Customer(" ", " ", " ", " ");
					customers.add(customer);
					Project project = new Project(0, " ", " ", " ", 0, 0, 0, " ", "No","Not Complete", "Not Finalised", architect, contractor, customer); 
					projects.add(project);
		
					//Ask user for project details by calling the appropriate extract method
					project.number = extractInt("Project Number? ");
					project.name = extractString("Project Name? ");
					project.type = extractString("Project Type? (building, apartment, etc...) ");
					project.address = extractString("Project Address? ");
					project.erf = extractInt("ERF Number? ");
					project.charged = extractFloat("Amount Charged?: ");
					project.paid = extractFloat("Amount Paid?: ");
					project.deadline = extractString("Project Deadline? ");
				
					//Here we calculate the amount outstanding
					outstanding = (project.charged - project.paid);
					

					//Ask user for architect details by calling the appropriate extract method
					architect.name = extractString("Architect Name? ");
					architect.telNumber = extractString("Architect Telephone? ");
					architect.email = extractString("Architect Email? ");
					architect.address = extractString("Achitect Address ");

					
					//Ask user for contractor details by calling the appropriate extract method
					contractor.name = extractString("Contractor Name? ");
					contractor.telNumber = extractString("Contractor Telephone? ");
					contractor.email = extractString("Contractor Email? ");
					contractor.address = extractString("Contractor Address? ");
					
					
					//Ask user for customer details by calling the appropriate extract method
					customer.name = extractString("Customer Name? ");
					customer.telNumber = extractString("Customer Telephone? ");
					customer.email = extractString("Customer Email? ");
					customer.address = extractString("Customer Address? ");
			
					
					//Here we check if the user entered a project name, if not we make the project name equal
					//to the prject.type and surname of the customer
					String[] arr = customer.name.split(" ");
					String surname = arr[(arr.length - 1)];
					String projName = project.type+" "+surname;
					if (project.name.equals("") || project.name.equals(" ")) {
						project.name = projName;
					}
				}

			
				//If the user selects choice 2 then we allow the user to update the project details
				else if (user_choice == 2) {
					Project project = null;
					
					
					//We first need to identify the project the user wants to edit
					//The user can identify the project either by name or by number
					//we call the refactored project_filter method for this
					int identity_project = project_filter();
					
						if(identity_project == 1) {
							
							int num = Integer.parseInt(JOptionPane.showInputDialog("Project Number? "));
							
							for (Project prj : projects ) {
								if(prj.number == num) {
									project = prj;
								}
							}
						
						} else if (identity_project == 2) {
							
							//String name = extractString("Project Name? ");
							String name = JOptionPane.showInputDialog("Project Name? ");
							
							for (Project prj : projects ) {
								if(prj.name.equalsIgnoreCase(name)) {
									project = prj;
								}
							}
						}
				
					//Once the project has been identified we ask the user what the details they would like to change	
					if (project != null) {
						
						//We create a project choice variable and then in the do loop, the user can select the field they want to edit
						
						int project_choice;	
					
					do {
						
						//We call the refactored project_options method to get the filed the user wants to edit
						project_choice = project_options();
						
						if (project_choice == 1) {
							project.number = extractInt("Project Number? ");
						}
						else if (project_choice == 2) {
							project.name = extractString("Project Name? ");
						} else if (project_choice == 3 ) {
							project.type = extractString("Project Type? (building, apartment, etc...) ");
						} else if (project_choice == 4) {
							project.address = extractString("Project Address? ");
						} else if (project_choice ==5) {
							project.erf = extractInt("ERF Number? ");
						} else if (project_choice == 6) {
							project.charged = extractFloat("Amount Charged? (floating number): ");
						} else if (project_choice == 7) {
							project.paid = extractFloat("Amount Paid? (floating number): ");
						} else if (project_choice == 8) {
							project.deadline = extractString("Project Deadline? ");
						} else if(project_choice == 9) {
							project.overdue = extractString("Is the project overdue (Yes or No)? ");
							
							//Below we do some defensive programming to ensure the user on enters "Yes" or "No" for overdue
							String[] answers = {"Yes","No"};
							
							boolean present = Arrays.asList(answers).contains(project.overdue);
							
							do {
								project.overdue = extractString("Is the project overdue (Yes or No)? ");
								 present = Arrays.asList(answers).contains(project.overdue);
							} while (!present);
							
						
							
						} else if (project_choice == 10) {
							project.status = extractString("Project Status (Finalised or Not Finalised)? ");
							
							//Below we do some defensive programming to ensure the user on enters "Finalised" or "Not Finalised" for status
							String[] answers = {"Finalised","Not Finalised"};
							
							boolean present = Arrays.asList(answers).contains(project.status);
							
							do {
								project.status = extractString("Project Status (Finalised or Not Finalised)? ");
								 present = Arrays.asList(answers).contains(project.status);
							} while (!present);
						}
						
						
						//We then calculate the new amount outstanding
						outstanding = (project.charged - project.paid);
						//Here we check if the user entered a project name, if not we make the project name equal
						//to the prject.type and surname of the customer
						String[] arr = project.customer.name.split(" ");
						String surname = arr[(arr.length - 1)];
						String projName = project.type+" "+surname;
						if (project.name.equals("")) {
							project.name = projName;
						}
					
					}while (project_choice != -1);
				
				} else {
					System.out.println("Cannot find Project");
				}
				
				}
			
			
				//If the user selects option 3 then we allow the user to update architect details
				else if (user_choice == 3) {

					//We first need to identify the architect the user wants to edit
					//The user can identify the architect by name
					String architectName = JOptionPane.showInputDialog("Architect's Name? ");
					
					Architect architect = null;
					
					for (Architect arch : architects ) {
						if(arch.name.equalsIgnoreCase(architectName)) {
							architect = arch;
						}
					}
					
					
					//If architect has been identified then we provide the user with options for the field they want to change
					if(architect != null) {
						
						int architect_details;
						architect_details = person_options();
					
						do 
						{
						
							if (architect_details == 1) {
								architect.name = extractString("Update Architect Name? ");
								architect_details = person_options();
							} else if (architect_details == 2) {
								architect.telNumber = extractString("Update Architect Telephone? ");
								architect_details = person_options();
							} else if (architect_details == 3) {
								architect.email = extractString("Update Architect Email? ");
								architect_details = person_options();
							} else if (architect_details == 4) {
								architect.address = extractString("Update Architect Address? ");
								architect_details = person_options();
							}
					
						}while(architect_details != -1);
					
					}
					else {
						System.out.println("Cannot find architect");
					}
				}
		
				//Choice 4 allows the user to edit the contractor details
				else if (user_choice == 4) {
					
					//We first need to identify the contractor the user wants to edit
					//The user can identify the contractor either by name

					String contractorName = JOptionPane.showInputDialog("Contractor's Name? ");
					Contractor contractor = null;
					
					for (Contractor cont : contractors ) {
						if(cont.name.equalsIgnoreCase(contractorName)) {
							contractor = cont;
						}
					}
					
					//If contractor has been identified then we provide the user with options for the field they want to change
					if (contractor != null) {
						int contractor_details;
						contractor_details = person_options();
					
						do 
						{
							
							if (contractor_details == 1) {
								contractor.name = extractString("Update Contractor Name? ");
								contractor_details = person_options();
							} else if (contractor_details == 2) {
								contractor.telNumber = extractString("Update Contractor Telephone? ");
								contractor_details = person_options();
							} else if (contractor_details == 3) {
								contractor.email = extractString("Update Contractor Email? ");
								contractor_details = person_options();
							} else if (contractor_details == 4) {
								contractor.address = extractString("Update Contractor Address? ");
								contractor_details = person_options();
							}
					
						}while(contractor_details != -1);
					
					} else {
						System.out.println("Cannot find contractor");
					}
				}
				
				
				//Choice 5 allows the user to edit the customer details
				else if (user_choice == 5) {
					
					//We first need to identify the customer the user wants to edit
					//The user can identify the customer by name
					String customerName = JOptionPane.showInputDialog("Customer's Name? ");
					Customer customer = null;
					
					for (Customer cust : customers) {
						if(cust.name.equalsIgnoreCase(customerName)) {
							customer = cust;
						}
					}
					
					//If customer has been identified then we provide the user with options for the field they want to change
					if(customer != null) {
						int customer_details;
						customer_details = person_options();
					
						do 
						{
						
							if (customer_details == 1) {
								customer.name = extractString("Update Customer Name? ");
								customer_details = person_options();
							} else if (customer_details == 2) {
								customer.telNumber = extractString("Update Customer Telephone? ");
								customer_details = person_options();
							} else if (customer_details == 3) {
								customer.email = extractString("Update Customer Email? ");
								customer_details = person_options();
							} else if (customer_details == 4) {
								customer.address = extractString("Update Customer Address? ");
								customer_details = person_options();
							}
					
						}while(customer_details != -1);
					
					} else {
						System.out.println("Cannot find customer");
					}
				}
			
				//If the user selects choice 6 then an invoice to the customer for the project is printed on screen
				else if (user_choice == 6) {	
					
					Project project = null;
						
					//We first identify the project either by name or by number
					int identity_project = project_filter();
					
						if(identity_project == 1) {
							
							int num = Integer.parseInt(JOptionPane.showInputDialog("Project Number? "));
							
							for (Project prj : projects ) {
								if(prj.number == num) {
									project = prj;
								}
							}
						
						} else if (identity_project == 2) {
							
								String name = JOptionPane.showInputDialog("Project Name? ");
							
							for (Project prj : projects ) {
								if(prj.name.equalsIgnoreCase(name)) {
									project = prj;
								}
							}
						}
					
						
					//Once the project has been identified we do the below
					if (project != null) {
						
						System.out.println("\n");
						System.out.println("Finalise Project:");
						
						//Check if there is an amount outstanding or if the project has been paid
						//If the project has been paid the no invoice is generated
						outstanding = project.charged - project.paid;
						
						if (outstanding > 0) {
				
							//if(project.type != " ") {
							if(!(" ".equals(project.type))) {
								//Here we ask the user for a project completion date
								project.completion = extractString("Project Completion Date? ");
								
								
								//Here we update the project status to finalised
								project.status = "Finalised";
			
								//If the project is finalised then we call the finalise method to print the report
								finalise(project.customer, project, outstanding);
			
							} else {
								System.out.print("Please complete project details \n");
							}
				
						}
			
						else {
							//If the amount outstanding is zero then no invoice is generated and we print 
							//the project ahs been paid in full
							System.out.print("Project Fully Paid \n");
						}
			
					} else {
						System.out.println("Cannot find project");
					}
				}
				
				//If the user selects 7 then we print a list of projects that are not complete by calling the notCompleted method
				else if (user_choice == 7) {
					
					System.out.println("Projects Not Complete: \n");
					
					notCompleted(projects);
					
					
				//If the user selects 8 then we print a list of projects that are overdue by calling the overdue method
				} else if (user_choice == 8) {
					
					System.out.println("Projects Overdue: \n");
					
					overdue(projects);
				
				}
				
				
				//If the user selects 9 then we save all details to the projects.txt file by calling the writeProj method
				else if (user_choice == 9) {
				
					
					writeProj(projects);
				}
			} while (user_choice != -1);    //we continue to prompt the user until they enter -1 to exit the program
		
		}


//******************************************************************************************************************************
//************************Below are Methods that I have Refactored**************************************************************
	  
	 
	//The below method displays a GUI user option for the user. The user can then select which action they want to perform
	//If the user does not enter a valid input then the GUI will pop up again and continue to ask the user until a valid 
	//input is entered
	public static int user_options() {
		String user_option;
		user_option = JOptionPane.showInputDialog( "User Options\n"+
				"1. Add Project\n"+
				"2. Update Project Details\n"+
				"3. Update Architect Details\n"+
				"4. Update Contractor Details\n"+
				"5. Update Customer Details\n"+
				"6. Finalise Project\n"+
				"7. Projects Not Complete\n"+
				"8. Projects Overdue\n"+
				"9. Save Project\n"+
				"-1 Quit Program");
		
		//Below we do some defensive programming to ensure the user selects the right option
		String[] options = {"-1", "1", "2", "3","4","5","6","7","8","9"};
		
		boolean present = Arrays.asList(options).contains(user_option);
		
		if (present) {
			
			try {
				int user_choice = Integer.parseInt(user_option);
				return user_choice;
			} 
			catch (Exception e){
				return user_options();
			}
			
			
		} else {
			return user_options();
		}		
	}
	
	
	
	//This method asks the user to select a field they want to change
	public static int project_options() {
		String user_option;
		user_option = JOptionPane.showInputDialog( "Change Project Details\n"+
				"1. Project Number\n"+
				"2. Project Name\n"+
				"3. Project Type\n"+
				"4. Project Address\n"+
				"5. Project ERF Number\n"+
				"6. Project Amount Charged\n"+
				"7. Project Amount Paid\n"+
				"8. Project Deadline\n"+
				"9. Project Overdue\n"+
				"10. Project Status\n"+
				"-1 Quit Program");
		
		
		//Below we do some defensive programming to ensure the user selects the right option
		String[] options = {"-1", "1", "2", "3","4","5","6","7","8","9", "10"};
		
		boolean present = Arrays.asList(options).contains(user_option);
		
		if (present) {
			
			try {
				int user_choice = Integer.parseInt(user_option);
				return user_choice;
			} 
			catch (Exception e){
				return project_options();
			}
			
			
		} else {
			return project_options();
		}		
	}
	
	
	
	//The below method asks the user to select a field of the persons details they want to change
	public static int person_options() {
		String user_option;
		user_option = JOptionPane.showInputDialog( "Update Person Details\n"+
				"1. Name\n"+
				"2. telNumber\n"+
				"3. Email\n"+
				"4. Address\n"+
				"-1 Quit Program");
		
		//Below we do some defensive programming to ensure the user selects the right option
		String[] options = {"-1", "1", "2", "3","4"};
		
		boolean present = Arrays.asList(options).contains(user_option);
		
		if (present) {
			
			try {
				int user_choice = Integer.parseInt(user_option);
				return user_choice;
			} 
			catch (Exception e){
				return person_options();
			}
			
			
		} else {
			return person_options();
		}		
	}
	
	
	//The below method is used find out how the user wants to identify the project either by name or number
	public static int project_filter() {
		String user_option;
		user_option = JOptionPane.showInputDialog( "Identify Project by: \n"+
				"1. Number\n"+
				"2. Name\n"+
				"-1 Quit Program");
		
		//Below we do some defensive programming to ensure the user selects the right option
		String[] options = {"-1", "1", "2"};
		
		boolean present = Arrays.asList(options).contains(user_option);
		
		if (present) {
			
			try {
				int user_choice = Integer.parseInt(user_option);
				return user_choice;
			} 
			catch (Exception e){
				return project_filter();
			}
			
			
		} else {
			return project_filter();
		}		
	}
	
	
	 
		//The below method asks a user for an integer input. The method also checks that a valid integer has been entered
		//If not then the method will continue to ask the user until a valid integer is entered
		public static int extractInt(String input_field) {

			String number_input = JOptionPane.showInputDialog(input_field);
			
			try {
				return Integer.parseInt(number_input);
			} catch(Exception e) {
				System.out.println("Please enter a valid number: ");
				return extractInt(input_field);
			}
		}
		
		
		
		//The below method asks a user for a string input. The method also checks that a valid string has been entered
		//If not then the method will continue to ask the user until a valid string is entered
		public static String extractString(String input_field) {

			String string_input = JOptionPane.showInputDialog(input_field);
			
			try {
				return string_input;
			} catch(Exception e) {
				System.out.println("Please enter a valid input: ");
				return extractString(input_field);
			}
		}
		
		
		
		//The below method asks a user for a float input. The method also checks that a valid float has been entered
		//If not then the method will continue to ask the user until a valid float is entered
		public static Float extractFloat(String input_field) {

			String string_input = JOptionPane.showInputDialog(input_field);
			
			try {
				return Float.parseFloat(string_input);
			} catch(Exception e) {
				System.out.println("Please enter a valid (floating) number: ");
				return extractFloat(input_field);
			}
		}
		
		
		
		//The below method prints the report when the project is finalised
		public static void finalise(Customer customer, Project project, float outstanding) {
			PrintStream out = System.out;
			out.println("\n");
			out.println("Invoice:");
			out.println("Customer Details:");
			out.println("Name: \t\t"+customer.name);
			out.println("Telephone: \t"+customer.telNumber);
			out.println("Email: \t\t"+customer.email);
			out.println("Address: \t"+customer.address);
			out.println("\nProject Details:");
			out.println("Name: \t\t"+project.name);
			out.println("Status: \t"+project.status);
			out.println("Completion: \t"+project.completion);
			out.println("Oustanding: \t"+outstanding);
			out.println("\n");
		}
		
		
		//This method basically gets the project details and writes it to the projects.txt file
		public static void writeProj(List<Project> projects) {
			if(projects.size() > 0) {
				
				List<String> tasks = new ArrayList<String>();
				
				for (Project proj : projects) {
					String out = "";
					out += proj.number+",";
					out += proj.name+",";
					out += proj.type+",";
					out += proj.address+",";
					out += proj.erf+",";
					out += proj.charged+",";
					out += proj.paid+",";
					out += proj.deadline+",";
					out += proj.overdue+",";
					out += proj.completion+",";							
					out += proj.status+",";
					out += proj.architect.name+",";
					out += proj.architect.telNumber+",";
					out += proj.architect.email+",";
					out += proj.architect.address+",";
					out += proj.contractor.name+",";
					out += proj.contractor.telNumber+",";
					out += proj.contractor.email+",";
					out += proj.contractor.address+",";
					out += proj.customer.name+",";
					out += proj.customer.telNumber+",";
					out += proj.customer.email+",";
					out += proj.customer.address+", \r\n";
					
					tasks.add(out);
				}
					
					// create a new formatter
					try {
					Formatter printProjects = new Formatter("projects.txt");

					// print the results from the tasks array to the output file
			        for (int i = 0; i<tasks.size(); i++) {
			        printProjects.format("%s", tasks.get(i));
			        }
			        printProjects.close(); // we close the file here
	  
					} 
			  
					catch (Exception e) {
						System.out.println("Error");  //here we catch any exceptions
					}		
				
			}
		}
		
		
		//Here we identify overdue projects and print their details
		public static void overdue(List<Project> projects) {
			for (Project pj : projects) {
				
				if (pj.overdue.equals("Yes")) {
					String out = "";
					out += "Name: "+pj.name+"\n";
					out += "Number: "+pj.number+"\n\n";
					System.out.println(out);
				}
			}
		}

		//Here we identify not completed projects and print their details
		public static void notCompleted(List<Project> projects) {
			for (Project pj : projects) {

				if (pj.status.equals("Not Finalised")) {
					String out = "";
					out += "Name: "+pj.name+"\n";
					out += "Number: "+pj.number+"\n\n";
					System.out.println(out);
				}
			}
		}
		
//*************************************end of refactored methods*******************************************************************
//*********************************************************************************************************************************
}
