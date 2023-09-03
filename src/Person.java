import java.util.Calendar;

public class Person{


    String id;
    String FirstName;
    String LastName;
    String Title;
    int YearOfBirth;

    Calendar calendar;

    public Person (String id, String FirstName,String LastName, String Title, int YearOfBirth){

        this.id = id;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Title = Title;
        this.YearOfBirth = YearOfBirth;
         calendar = Calendar.getInstance();
    }

    public String toCSVDataRecord(){
        return id+","+FirstName+","+LastName+","+Title+","+Integer.toString(YearOfBirth);
    }

    public String fullName(){
        return FirstName + " " + LastName;
    }

    public String formalName(){
        return Title + " " + this.fullName();
    }

    public String getAge(){

        return Integer.toString(calendar.get(Calendar.YEAR) - YearOfBirth);

    }

    public String getAge(int year){

        return Integer.toString(calendar.get(Calendar.YEAR) - year);

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getYearOfBirth() {
        return YearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        YearOfBirth = yearOfBirth;
    }










}