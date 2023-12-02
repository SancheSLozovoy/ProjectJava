package School;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Students implements Marks {
    private String name;
    private String lastname;
    private List<Integer> marks;

    public Students(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
        this.marks = new ArrayList<>();
    }

    public String getFullName() {
        return name + " " + lastname;
    }

    @Override
    public void addMark(int mark) {
        marks.add(mark);
    }

    @Override
    public void delMark(Marks mark) {
        marks.remove(mark);
    }

    public void addMarksFromString(String marksString) {
        String[] marksArray = marksString.split(" ");
        for (String mark : marksArray) {
            try {
                int intMark = Integer.parseInt(mark.trim());
                marks.add(intMark);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка при добавлении оценки: " + mark);
            }
        }
    }

    public int getMarksCount() {
        return marks.size();
    }

    public String display() {
        String result = "Студент: " + getFullName() + "\n" +
                "Количество оценок: " + getMarksCount();

        if (getMarksCount() > 0) {
            result += "\nОценки: " + Arrays.toString(marks.toArray());
        }

        return result;
    }
}
