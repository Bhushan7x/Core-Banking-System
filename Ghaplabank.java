import java.util.*;
class Ghaplabank 
{

	static String username;
	static String phone;
	static String pin;
	static Long adhar;
	static String pan;
	static double bal;
	static final String ifsc = "Ghapla70000";
	static final long accountNo = 17741451512121L;
	static ArrayList<String>tran = new ArrayList<String>();
	static Scanner sc = new Scanner(System.in);
	static int attempt = 3;
	
	public static void main(String[] args) 
	{
		for (; ; )
		{
		  System.out.println();
		  System.out.println("       Wel-come      ");
		  System.out.println("   ***Ghapla bank ***");
		  System.out.println();
		  System.out.println("1: Existing User");
		  System.out.println("2: New User");
		  System.out.println("Enter an option : ");
		  int opt = sc.nextInt();
		  System.out.println();
		  switch (opt)
		  {
		  case 1:
		  { 
			  login();break;
		  }
		  case 2:
		  { 
			  createAccount();break;
		  }
		  default : { System.out.println("Invalid Option");break; }
		 
		  }

		}
	
	}
	public static void login() {
    if (username != null) {
        for (; attempt > 0; attempt--) {
            System.out.println("    ****Login*****    ");
            System.out.println("username/phone : ");
            sc.nextLine(); 
            String cred1 = sc.nextLine();
            System.out.println("Password : ");
            String cred2 = sc.next();
            
            if ((cred1.equals(username) || cred1.equals(phone)) && cred2.equals(pin)) 
			{
                homePage();
                return;
            } else
			{
                System.out.println("Wrong credentials. Attempts left: " + (attempt - 1));
            }
        }
        System.out.println("Too many failed attempts. Exiting.");
        System.exit(0);
    } 
	else 
	{
        System.out.println("Create Your Account First.");
    }
}


	public static void createAccount()
	{
		System.out.println("       ********Account Creation********     ");
		System.out.println();
		System.out.println("username : ");
		System.out.println();
		sc.nextLine();
		username = sc.nextLine();
		System.out.println("Phone Number : ");
		phone = sc.next();
		System.out.println("Pin : ");
		pin = sc.next();
		System.out.println("Adhar number : ");
		adhar = sc.nextLong();
		System.out.println("Pan : ");
		pan = sc.next();
		System.out.println("Deposit Ammount  : ");
		bal = sc.nextDouble();
		tran.add("Deposit :" +bal+ "rs");
		System.out.println();
		System.out.println("Account Create Sucessfully : ");
		System.out.println();
		login();
	}
	public static void homePage()
	{
		for (; ; )
		{
			System.out.println();
			System.out.println("      ***** Home Page *****");
			System.out.println();
			System.out.println("1: Deposit ");
			System.out.println("1: Withdraw ");
			System.out.println("3: Check Balance");
			System.out.println("4: Statement");
			System.out.println("5: Edit User ");
			System.out.println("6: Loan ");
			System.out.println("7: Logout ");
			System.out.println();
			System.out.println("Enter An Option : ");
			int opt = sc.nextInt();
			System.out.println();
			switch (opt)
			{
			case 1:{ depositAmount();break;}
			case 2:{ withdrawAmount(); break;}
			case 3:{ checkBalance();break;}
			case 4:{ statement();break;}
			case 5:{ editUser();break;}
			case 6:{ loan();break;}
			case 7:{ System.out.println("Thank U  Visit Again");
			System.exit(0);}
			default : 	{ System.out.println("Wrong Option ");break;}
			
			}


		}
	
	}
	 public static void depositAmount()
	{
			System.out.println("    *****Deposit Amount*****   ");
	        System.out.println();
			System.out.println("Enter the deposit ammount");
			double depositAmt = sc.nextDouble();
			tran.add("Deposit :" + depositAmt+ "rs");
			bal+=depositAmt;
			System.out.println("Amount Deposit Sucessfully");
	}
	public static void withdrawAmount()
	{
		
		System.out.println("     ****Withdraw Amount****     ");
		System.out.println();
		System.out.println("Amount : ");
		double withAmt = sc.nextDouble();
		System.out.println("Pin : ");
		String userPin = sc.next();
		if (userPin.equals(pin))
		{
			if (withAmt<=bal)
			{
				bal -=withAmt;
				tran.add("Withdraw :" + withAmt+"rs");
				System.out.println("Amount Withdraw Sucessfully");

			}
			else 
			{
				System.out.println("Insuffient funds");
			}
		}
		else
		{
			System.out.println("Incorrect Pin");
		}
	}
		
	public static void checkBalance()
	{
		System.out.println("    ****Check Balance****    ");
		System.out.println();
		System.out.println("Pin : " );
		String userPin = sc.next();
		if (userPin.equals(pin))
		{
			System.out.println(username + "Ur Account Balance is : " + bal + "Rs");
		}
		else 
		{
			System.out.println("Incorrect pin");
		}


	}
	public static void statement()
	{
		System.out.println("         *******Statement********         ");
		System.out.println();
		for (String i : tran )
		{
			System.out.println(i);
		}
	}
	public static void editUser()
	{
		System.out.println("    *****Update User****     ");
		System.out.println();
		System.out.println("1 : Change Username");
		System.out.println("2 : Change Phone Number");
		System.out.println("3 : Change Pin");
		System.out.println("4 : Go Back");
		System.out.println("Enter An Option");

		int option = sc.nextInt();
		sc.nextLine();
		switch (option)
		{
		case 1:changeUsername();break;
		case 2:changePhoneNumber();break;
		case 3:changePin();break;
		case 4:return;
		default:System.out.println("Invalid Option");
		
		
		}
	
	}
	public static void changeUsername()
{
    System.out.println("Enter New Username: ");
    String newUsername = sc.nextLine();
    username = newUsername;
    System.out.println("Username updated successfully to: " + username);
}
    public static void changePhoneNumber() 
{
    System.out.println("Enter New Phone Number: ");
    String newPhone = sc.nextLine();
    phone = newPhone;
    System.out.println("Phone number updated successfully to: " + phone);
}
	
	public static void changePin()
 {
    System.out.println("Enter Current PIN: ");
    String currentPin = sc.next();
    if (currentPin.equals(pin))
  {
        System.out.println("Enter New PIN: ");
        String newPin = sc.next();
        pin = newPin;
        System.out.println("PIN updated successfully.");
  }
	else 
	{
        System.out.println("Incorrect PIN. Please try again.");
    }
}
	
	public static void loan()
	{
		System.out.println("    *****Loan****     ");
		System.out.println("1: Home Loan ");
		System.out.println("2: Priciple Loan  ");
		System.out.println("3: Gold Loan ");
		System.out.println("4: Car Loan ");
		System.out.println("5: Education Loan ");
		
		System.out.println();
		System.out.println("Principle Amount ");
		double amt = sc.nextDouble();
		System.out.println("Tensure (month) ");
		int ten = sc.nextInt();
		System.out.println("Enter an option for loan type ");
		int opt = sc.nextInt();
		double roi = 0;
		String type = "";
		switch (opt)
		{
		case 1:roi = 7.5;type= "home";break;
		case 2:roi = 9.5;type= "personal";break;
		case 3:roi = 3.5;type= "gold";break;
		case 4:roi = 8.5;type= "car";break;
		case 5:roi = 7.7;type= "education";break;
		default :System.out.println("Wrong Option Enter");

		
		}
		double interest = (amt * roi / 100) * ((ten / 12) + (ten % 12) / 10.0);

		System.out.println("Loan Type :"+type+"Loan");
		System.out.println("Principle :"+amt+"Rs");
		System.out.println("Roi :"+roi+"%");
		System.out.println("Interest  :"+interest);
		System.out.println("Total Amount :"+(amt+interest));
		System.out.println("Monthly EMI :"+ (float)((amt+interest)/ten));

	
	}


}

