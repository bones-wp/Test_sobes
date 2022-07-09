import java.io.*;
import java.util.ArrayList;

public class Workers {
    String fio, dateBorn, dateWork;

    static String fileName = "Form.txt";
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

    public static void add() throws IOException {
        int count = 0;
        count = count++;

        employees.add(count, new Employee(br.readLine(), br.readLine(), br.readLine()));
        fis.close();
    }

    public static void print() {
        System.out.println('\n' + "Список сотрудников: " + '\n');
        for (Workers a : employees) {
            System.out.println(a);
        }

    }

    public Workers(String fio, String dateBorn, String dateWork) throws FileNotFoundException {
        this.fio = fio;
        this.dateBorn = dateBorn;
        this.dateWork = dateWork;
    }

    static class Employee extends Workers {
        public Employee(String fio, String dateBorn, String dateWork) throws FileNotFoundException {
            super(fio, dateBorn, dateWork);
        }

        @Override
        public String toString() {
            return fio + "\n" + dateBorn + "\n" + dateWork;
        }

    }

    static class Manager extends Workers {
        ArrayList<Employee> subordinates = new ArrayList<>();

        public Manager(String fio, String dateBorn, String dateWork) throws FileNotFoundException {
            super(fio, dateBorn, dateWork);
            this.subordinates = subordinates;
        }
    }

    static class Others extends Workers {
        String anketa;

        public Others(String fio, String dateBorn, String dateWork) throws FileNotFoundException {
            super(fio, dateBorn, dateWork);
            this.anketa = anketa;
        }
    }

}
