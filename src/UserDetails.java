import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;


/*
 * Creating Interface DetailsValidatation containing userDetailsVerify abstract method
 * */

interface DetailsValidatation{
    public void userDetailsVerify() throws InvalidDetails;
}

/*
 * Class Containing main method
 * */
public class UserDetails {

    public static void main(String[] args) throws InvalidDetails {


        DetailsValidatation userDetailsVerify = () -> {                             //Using lambda Expression taking details and validating it.


            UserDetails userDetails = new UserDetails();                    //Taking inputs from User
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Your Name : ");
            String name = scanner.next();
            System.out.println("Enter your Last Name : ");
            String lastName = scanner.next();
            System.out.println("Enter your Email ID : ");
            String email = scanner.next();
            System.out.println("Enter Your Password : ");
            String password = scanner.next();                                       //Declaring regex for name, Lastname,email,password.


            String nameRegex = "^[A-Z a-z]{3}";
            String lastNameRegex = "^[A-Z]{1}[A-Z a-z]{2}";
            String emailRegex = "^(abc)[\\.]{1}[a-z,A-Z]{3}[\\@]{1}(bl)[\\.]{1}(co)[\\.][a-z]{2}$";
            String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{8,}$";

            Pattern namePattern = Pattern.compile(nameRegex);                            //making pattern objects of name,Lastname,email,password.
            Pattern lastNamePattern = Pattern.compile(lastNameRegex);
            Pattern emailPattern = Pattern.compile(emailRegex);
            Pattern passwordPattern = Pattern.compile(passwordRegex);


            if (namePattern.matcher(name).matches() == false)                   // checking details in correct format or not and throwing Exception to specific type if find any
            {
                throw new InvalidDetails(" Name Entered is not Valid");
            }
            else if ((namePattern.matcher(lastName).matches() == false))
            {
                throw new InvalidDetails(" Last Name Entered is not Valid");
            }
            else if ((namePattern.matcher(email).matches() == false))
            {
                throw new InvalidDetails("  Email Entered is not Valid");
            }
            else if ((namePattern.matcher(password).matches() == false))
            {
                throw new InvalidDetails(" Password Entered is not Valid");
            }

        };
    }
}
