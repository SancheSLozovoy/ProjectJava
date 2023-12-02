package School;

import java.util.ArrayList;
import java.util.List;

public class School{
    private int emplCount;
    private String directorName;
    private String name;
    private List<Students> students;
    private List<Employees> employees;
    private List<Inventory> inventories;
    private List<Schedule> schedule;
    private List<SchoolClass> schoolClasses;

    private static final String description;


    public School() {
        this.emplCount = 0;
        this.directorName = "O. O. Omagad";
        this.name = "The Best School in The World";

        schoolClasses = new ArrayList<>();
        students = new ArrayList<>();
        employees = new ArrayList<>();
        inventories = new ArrayList<>();
    }

    public Employees addEmpl(Employees empl){
        employees.add(empl);
        emplCount++;
        return empl;
    }
    public List<SchoolClass> getSchoolClasses() {
        return schoolClasses;
    }
    public void addSchoolClass(SchoolClass schoolClass) {
        schoolClasses.add(schoolClass);
    }
    public List<Employees> getEmployees() {
        return employees;
    }
    public List<Students> getStudents() {
        return students;
    }
    public List<Inventory> getInventories() {
        return inventories;
    }
    public List<Schedule> getSchedule() {
        return schedule;
    }

    public void delEmpl(Employees empl){
        employees.remove(empl);
        emplCount--;
    }

    public Students addStudent(Students student){
        students.add(student);
        return student;
    }
    public void delStudent(Students student){
        students.remove(student);
    }

    public Inventory addInv(Inventory inv){
        inventories.add(inv);
        return inv;
    }
    public void delInv(Inventory inv){
        inventories.remove(inv);
    }

    public String getName(){
        return name;
    }

    public void setSchedule(List<Schedule> schedule) {
        this.schedule = schedule;
    }
    public String display(){
        return "\n"+ description+"\n" + "Название школы: " + getName() + "\n" +
                "В ней преподают: " + emplCount + " " + "Учителей";
    }

    static{
        description = "Описание школы";
    }

}