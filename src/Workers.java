import java.io.*;
import java.util.ArrayList;

public class Workers {
    String type, fio, dateBorn, dateWork;

    static String fileName = "Employees.txt";
    static FileInputStream fis;
    static {
        try {
            fis = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(fis));

    static ArrayList<Employee> employees = new ArrayList<>();
    static ArrayList<Employee> subordinates = new ArrayList<>();


    public static void addEmp() throws IOException {
        int count = 0;
        count = count++;
        employees.add(count, new Employee("Работник", br.readLine(), br.readLine(), br.readLine()));
    }

    public static void print() {
        System.out.println("Список сотрудников: ");
        for (Workers a : employees) {
            System.out.println(a);
        }
    }

    public Workers(String type, String fio, String dateBorn, String dateWork) throws FileNotFoundException {
        this.type = type;
        this.fio = fio;
        this.dateBorn = dateBorn;
        this.dateWork = dateWork;
    }

    static class Employee extends Workers {
        public Employee(String type, String fio, String dateBorn, String dateWork) throws FileNotFoundException {
            super(type , fio, dateBorn, dateWork);
        }
    }

    static class Manager extends Workers {
        public Manager(String type, String fio, String dateBorn, String dateWork) throws FileNotFoundException {
            super(type, fio, dateBorn, dateWork);
        }
    }

    static class Others extends Workers {
        public Others(String type, String fio, String dateBorn, String dateWork) throws FileNotFoundException {
            super(type, fio, dateBorn, dateWork);
        }
    }

    @Override
    public String toString() {
        return "\n" + type + "\n" + fio + "\n" + dateBorn + "\n" + dateWork;
    }


}
