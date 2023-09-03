import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class PersonGenerator {


    public static void main(String[] args) {

        String FileName;
        File outFile;
        PrintWriter personPrinter;
        ArrayList<Person> PersonData = new ArrayList<Person>();
        Scanner in = new Scanner(System.in);
        String id;
        String FirstName;
        String LastName;
        String Title;
        int YearOfBirth;
        int personCounter = 0;
        int index =0;

        id = SafeInput.getNonZeroLenString(in,"Enter an id for the person");
        FirstName = SafeInput.getNonZeroLenString(in,"Enter a first name for the person");
        LastName = SafeInput.getNonZeroLenString(in,"Enter a last name for the person");
        Title = SafeInput.getNonZeroLenString(in,"Enter a title for the person");
        YearOfBirth = SafeInput.getRangedInt(in, "Enter a year of birth for the person", 1000,2000);

        System.out.printf("The person you created is: %n" +
                        "id: %s%n" +
                        "name: %s %s %s%n" +
                        "born in %d",
                id, Title, FirstName, LastName, YearOfBirth);


        Person toAdd = new  Person(id,FirstName,LastName,Title,YearOfBirth);

        PersonData.add(toAdd);


        while(SafeInput.getYNConfirm(in,"Do you want to create another person?")){

            personCounter++;

            id = SafeInput.getNonZeroLenString(in,"Enter an id for the person");
            FirstName = SafeInput.getNonZeroLenString(in,"Enter a first name for the person");
            LastName = SafeInput.getNonZeroLenString(in,"Enter a last name for the person");
            Title = SafeInput.getNonZeroLenString(in,"Enter a title for the person");
            YearOfBirth = SafeInput.getRangedInt(in, "Enter a year of birth for the person", 1000,2000);

            System.out.printf("The person you created is: %n" +
                            "id: %s%n" +
                            "name: %s %s %s%n" +
                            "born in %d",
                    id, Title, FirstName, LastName, YearOfBirth);


            toAdd = new Person(id, Title, FirstName, LastName, YearOfBirth);
            PersonData.add(toAdd);



        }

        try {

            FileName = SafeInput.getNonZeroLenString(in, "Enter a name for the file");
            outFile = new File(FileName + ".txt");
            System.out.println("File created: " + outFile.getName());

            FileWriter personWriter = new FileWriter(outFile.getName());
            personPrinter = new PrintWriter(personWriter);

            //personWriter.write("This is a test.");

            while (index <= personCounter){

                personPrinter.println(PersonData.get(index).toCSVDataRecord());


                index++;
            }

            personWriter.close();

        }

        catch (IOException e){

            System.out.println("An error occurred.");
            e.printStackTrace();

        }

    }

}