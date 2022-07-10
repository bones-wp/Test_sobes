import java.util.ArrayList;

public class Workers {
    String type, fio, dateBorn, dateWork;

    public Workers(String fio, String dateBorn, String dateWork){
        this.fio = fio;
        this.dateBorn = dateBorn;
        this.dateWork = dateWork;
    }

    static class Manager extends Workers {
        public Manager(String fio, String dateBorn, String dateWork) {
            super(fio, dateBorn, dateWork);
        }

        static ArrayList<Workers> subordinates = new ArrayList<>();
    }

    static class Others extends Workers {
        public Others(String fio, String dateBorn, String dateWork) {
            super(fio, dateBorn, dateWork);
        }
    }

    @Override
    public String toString() {
        return "\n" + type + "\n" + fio + "\n" + dateBorn + "\n" + dateWork;
    }


}
