import java.util.*;
import java.io.*;
@FunctionalInterface
interface constraint{
String test(String t);
}
//class for inputting info
class EmployInfo{
String name;
String father_name;
String email;
String position;
String employ_id;
String employ_salary;
String employ_contact;
Scanner sc=new Scanner(System.in);
//lambda expression
constraint c =(String t)->{
while(true)
{if(t.indexOf("@gmail.com")==-1){
                System.out.println("Please enter a valid gmail id.");
                System.out.print("Employee Email: ");
                t=sc.nextLine();
            }
            else{
              break;  
            }}
return t;
};
 public void getInfo()
{
System.out.print("Employee name: ");
name=sc.nextLine();
System.out.print("Father's name: ");
father_name=sc.nextLine();
System.out.print("Employee ID: ");
employ_id=sc.nextLine();
System.out.print("Employee Email: ");
email=sc.nextLine();
email=c.test(email);
System.out.print("Employee position: ");
position=sc.nextLine();
System.out.print("Employee contact no.: ");
employ_contact=sc.nextLine();
while (true){
            if(employ_contact.length()!=10){
                System.out.println("Please enter a valid contact Number");
                System.out.print("Employee contact no.: ");
                employ_contact=sc.nextLine();
            }
            else{
                break;
            }
        }
System.out.print("Employee salary: ");
employ_salary=sc.nextLine();
}
}
// adding new employee
class Add_employ extends EmployInfo{
public void createFile()
{ 
EmployInfo emp=new EmployInfo();
emp.getInfo();
try{
File f1=new File("file"+emp.employ_id+".txt");//create seperate file of each employee
if(f1.createNewFile())
{
FileWriter myWriter = new FileWriter("file"+emp.employ_id+".txt");
myWriter.write("Employee ID:"+emp.employ_id+"\n"+"Employee Name     :"+emp.name+"\n"+
"Father's Name     :"+emp.father_name+"/n"+"Employee Contact  :"+emp.employ_contact+"\n"+
"Email Information :"+emp.email+"\n"+"Employee position :"+emp.position+"\n"+
"Employee Salary   :"+emp.employ_salary);
myWriter.close();
System.out.println("employee added");
}
else {
System.out.println("employee already exist");
}
}catch(Exception e){System.out.println(e);} // handling Exception while writing in file
}
}
// removing employee class
class remove_employ{ 
    public void removeFile(String ID){
      
    File file = new File("file"+ID+".txt");   
      if(file.exists()) 
       {if(file.delete());
         { System.out.println("employee removed successfully");} }
      else
       { 
            System.out.println("employee does not exist"); 
       } 
}
}
// employee updating class
class update_employ{ 
public void updateFile(String s,String o,String n) throws IOException
{ File file = new File("file"+s+".txt");
        Scanner sc = new Scanner(file); 
  String fileContext="";
    while (sc.hasNextLine()) 
     { fileContext =fileContext+"\n"+sc.nextLine(); }
        FileWriter myWriter = new FileWriter("file"+s+".txt");
        fileContext = fileContext.replaceAll(o,n);
        myWriter.write(fileContext);
myWriter.close();
}
}
// view employee info class
class view_employ{
public void viewFile(String s) throws Exception
{  
    File file = new File("file"+s+".txt"); 
    Scanner sc = new Scanner(file); 
  
    while (sc.hasNextLine()) 
     { System.out.println(sc.nextLine()); }
   }
} 
//main class
class Demo{
public static void main(String arv[])
{
Scanner sc=new Scanner(System.in);
view_employ epv =new view_employ(); 
System.out.println("\n"+"\n"
  +"\n"+"\n"+"\n"
  +"\t  *******************************************************"+"\n"
  +"\t  **                                                   **"+"\n"
  +"\t  **                   You Are In                      **"+"\n"
  +"\t  **                                                   **"+"\n"
  +"\t  **                  Employee Menu                    **"+"\n"
  +"\t  **                                                   **"+"\n"
  +"\t  *******************************************************"+"\n"
  +"\n");
 System.out.println("\t\t  What do you want to do for employee  "      +"\n"
        +"\t\t  ==================================="      +"\n"
        +"\n"
        +"     \n\n\t 1  =>  Add employee  "
        +"     \n\n\t 2  =>  view employee \n"
        +"     \n\n\t 3  =>  Remove employee \n"
        +"      \n\n\t 4  =>  update employee \n"
        +         "\t===     ------------------ "+"\n"
        );

int i=0;
while(i<5)// choice loop(menu)
{System.out.println("enter choice");
i=Integer.parseInt(sc.nextLine());
switch(i){
case 1:// adding employee
{
Add_employ ep =new Add_employ();
ep.createFile();
break;
}
case 2:// view employee
{System.out.println("Enter Employee ID :");
String s=sc.nextLine();
try{
epv.viewFile(s);}
catch(Exception e){System.out.println(e);}
break;
}
case 3:// deleting employee
{System.out.println("Enter Employee ID :");
String s=sc.nextLine();
remove_employ epr =new remove_employ();
epr.removeFile(s);
break;
}
case 4://updating employee
{
System.out.println("Enter Employee ID :");
String I=sc.nextLine(); 
try{
epv.viewFile(I);}
catch(Exception e){System.out.println(e);}
update_employ epu = new update_employ();
System.out.println("enter the detail you want to change same as above:");
String s=sc.nextLine();
System.out.println("enter new Detail:");
String n=sc.nextLine();
try{epu.updateFile(I,s,n);}
catch(IOException e){System.out.println(e);}
}
}
}
}
}
