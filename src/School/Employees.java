package School;

public class Employees {
    private String name;
    private String lastname;
    private String subject;

    public Employees(String name, String lastname, String subject) {
        this.name = name;
        this.lastname = lastname;
        this.subject = subject;
    }
    public String getName(){
        return name;
    }
    public String getLastname() {
        return lastname;
    }
    public String getFullName(){
        return name+" "+lastname;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String display(){
        return "Имя преподвателя: " + getFullName() + "\n" +
                "Предмет: " + getSubject() + "\n";
    }


}