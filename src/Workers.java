import java.util.ArrayList;

public class Workers {
    String fio, dateBorn, dateWork;

    public Workers(String fio, String dateBorn, String dateWork){
        this.fio = fio;
        this.dateBorn = dateBorn;
        this.dateWork = dateWork;
    }

    static class Manager extends Workers {
        static ArrayList<Manager> subordinates = new ArrayList<>();
        public Manager(String fio, String dateBorn, String dateWork) {
            super(fio, dateBorn, dateWork);
        }
    }

    static class Others extends Workers {
        public Others(String fio, String dateBorn, String dateWork) {
            super(fio, dateBorn, dateWork);
        }
    }

    @Override
    public String toString() {
        return "\n" + getClass() + "\n" + "ФИО: " + fio + "\n" + "Дата рождения: " + dateBorn + "\n" + "Дата принятия на работу: " + dateWork;
    }


}
