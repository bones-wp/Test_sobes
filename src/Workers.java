import java.io.*;
import java.util.ArrayList;

public class Workers {
    String fio, dateBorn, dateWork;

    public Workers(String fio, String dateBorn, String dateWork) {
        this.fio = fio;
        this.dateBorn = dateBorn;
        this.dateWork = dateWork;
    }

    static class Employee extends Workers {
        public Employee(String fio, String dateBorn, String dateWork) {
            super(fio, dateBorn, dateWork);
        }
    }

    static class Manager extends Workers {
        ArrayList<Employee> subordinates = new ArrayList<>();
        public Manager(String fio, String dateBorn, String dateWork)  {
            super(fio, dateBorn, dateWork);
            this.subordinates = subordinates;
        }
    }

    static class Others extends Workers {
        String anketa;
        public Others(String fio, String dateBorn, String dateWork) {
            super(fio, dateBorn, dateWork);
            this.anketa = anketa;
        }
    }

}
