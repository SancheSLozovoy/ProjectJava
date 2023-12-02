package School.GUI;



import School.Employees;
import School.Schedule;
import School.Students;
import School.School;
import School.Inventory;
import School.SchoolClass;


import javax.swing.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SchoolGUI extends JFrame {

    private School school;
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField10;
    private JSpinner spinner1;
    private JButton добавитьСотрудникаButton;
    private JButton добавитьСтудентаButton;
    private JButton добавитьРассписаниеButton;
    private JButton добавитьПредметButton;
    private JTextArea textArea1;
    private JTextField textField9;
    private JComboBox comboBox1;
    private JButton удалитьВыбранногоСотрудникаButton;
    private JComboBox comboBox2;
    private JButton удалитьВыбранногоСтудентаButton;
    private JTextField textField11;
    private JComboBox comboBox3;
    private JButton удалитьВыбраннуюПозициюButton;
    private JButton отправитьButton;

    public SchoolGUI() {
        this.getContentPane().add(panel1);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        school = new School();

        добавитьСотрудникаButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEmployee();
            }
        });
        удалитьВыбранногоСотрудникаButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeEmployee();
            }
        });

        добавитьСтудентаButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        удалитьВыбранногоСтудентаButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeStudent();
            }
        });

        добавитьРассписаниеButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addSchedule();
            }
        });

        добавитьПредметButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addInventory();
            }
        });

        удалитьВыбраннуюПозициюButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeInventory();
            }
        });

        отправитьButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendData();
            }
        });
    }

    private void sendData() {
        List<Employees> employeesList = school.getEmployees();
        List<Students> studentsList = school.getStudents();
        List<Inventory> inventoryList = school.getInventories();

        StringBuilder text = new StringBuilder();

        text.append("Сотрудники:\n");
        for (Employees employee : employeesList) {
            text.append(employee.display()).append("\n");
        }

        text.append("\nСтуденты:\n");
        for (Students student : studentsList) {
            text.append(student.display()).append("\n");
        }

        text.append("\nРасписание:\n");

        List<SchoolClass> schoolClasses = school.getSchoolClasses();

        for (SchoolClass schoolClass : schoolClasses) {

            List<Schedule> scheduleList = schoolClass.getSchedules();

            for (Schedule schedule : scheduleList) {
                text.append(schedule.display()).append("\n");
            }
        }

        text.append("\nИнвентарь:\n");
        for (Inventory item : inventoryList) {
            text.append(item.display()).append("\n");
        }

        JOptionPane.showMessageDialog(this, text.toString(), "Отправка", JOptionPane.INFORMATION_MESSAGE);
    }




    private void addEmployee() {
        String firstName = textField1.getText();
        String lastName = textField2.getText();
        String subject = textField3.getText();

        Employees employee = new Employees(firstName, lastName, subject);
        Employees addedEmployee = school.addEmpl(employee);

        textArea1.append("Добавленный сотрудник: \n" + addedEmployee.display() + "\n");

        displayEmployees();
    }

    private void removeEmployee() {
        int selectedIndex = comboBox1.getSelectedIndex();

        if (selectedIndex != -1) {
            List<Employees> employeesList = school.getEmployees();
            Employees removedEmployee = employeesList.remove(selectedIndex);

            school.delEmpl(removedEmployee);

            textArea1.append("Удален сотрудник: \n" + removedEmployee.display() + "\n");
            displayEmployees();
        }
    }

    private void displayEmployees() {
        comboBox1.removeAllItems();

        List<Employees> employeesList = school.getEmployees();
        for (Employees employee : employeesList) {
            comboBox1.addItem(employee.getFullName());
        }

        if (employeesList.size() > 0) {
            comboBox1.setSelectedIndex(0);
        }
    }

    private void addStudent() {
        String firstName = textField4.getText();
        String lastName = textField5.getText();
        String marksInput = textField6.getText();

        Students student = new Students(firstName, lastName);
        student.addMarksFromString(marksInput);

        Students addedStudent = school.addStudent(student);

        textArea1.append("Добавленный студент: \n" + addedStudent.display() + "\n");
        displayStudent();
    }

    private void removeStudent() {
        int selectedIndex = comboBox2.getSelectedIndex();

        if (selectedIndex != -1) {
            List<Students> studentsList = school.getStudents();
            Students removedStudent = studentsList.remove(selectedIndex);

            school.delStudent(removedStudent);

            textArea1.append("Удален студент: \n" + removedStudent.display() + "\n");
            displayStudent();
        }
    }

    private void displayStudent() {
        comboBox2.removeAllItems();

        List<Students> studentList = school.getStudents();
        for (Students student : studentList) {
            comboBox2.addItem(student.getFullName());
        }

        if (studentList.size() > 0) {
            comboBox2.setSelectedIndex(0);
        }
    }


    private void addSchedule() {
        String date = textField7.getText();
        String time = textField8.getText();
        String subject = textField9.getText();
        String className = textField11.getText();

        Schedule schedule = new Schedule(date, time, subject);

        SchoolClass schoolClass = new SchoolClass();
        schoolClass.addSchedule(schedule);

        school.addSchoolClass(schoolClass);

        textArea1.append("\nДобавленное расписание для класса " + className + ": \n" + schedule.display() + "\n");
    }

    private void addInventory() {
        String name = textField10.getText();
        int quantity = Integer.parseInt(spinner1.getValue().toString());

        Inventory inventory = new Inventory(name, quantity);
        Inventory addedInv = school.addInv(inventory);

        textArea1.append("Добавленный предмет инвентаря: \n" + addedInv.display() + "\n");

        displayInv();
    }

    private void removeInventory() {
        int selectedIndex = comboBox3.getSelectedIndex();

        if (selectedIndex != -1) {
            List<Inventory> inventoryList = school.getInventories();
            Inventory removedInv = inventoryList.remove(selectedIndex);

            school.delInv(removedInv);

            textArea1.append("Удален предмет: \n" + removedInv.display() + "\n");
            displayInv();
        }
    }
    private void displayInv() {
        comboBox3.removeAllItems();

        List<Inventory> inventoryList = school.getInventories();
        for (Inventory inventory : inventoryList) {
            comboBox3.addItem(inventory.getName());
        }

        if (inventoryList.size() > 0) {
            comboBox3.setSelectedIndex(0);
        }
    }
}


