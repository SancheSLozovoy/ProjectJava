package School;

public class Schedule {
    private String date;
    private String time;
    private String subject;


    public Schedule(String date, String time, String subject) {
        this.date = date;
        this.time = time;
        this.subject = subject;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String display(){
        return "\n"+"Расписание: "+"\n" +
                "Дата: " + getDate() + "\n" +
                "Время: " + getTime() + "\n" +
                "Урок: " + getSubject() + "\n";
    }
}