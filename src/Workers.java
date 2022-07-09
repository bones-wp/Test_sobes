public class Workers {
    String type, fio, dateBorn, dateWork;

    public Workers(String type, String fio, String dateBorn, String dateWork){
        this.type = type;
        this.fio = fio;
        this.dateBorn = dateBorn;
        this.dateWork = dateWork;
    }

    static class Employee extends Workers {
        public Employee(String type, String fio, String dateBorn, String dateWork) {
            super(type, fio, dateBorn, dateWork);
        }
    }

    static class Manager extends Workers {
        public Manager(String type, String fio, String dateBorn, String dateWork) {
            super(type, fio, dateBorn, dateWork);
        }
    }

    static class Others extends Workers {
        public Others(String type, String fio, String dateBorn, String dateWork) {
            super(type, fio, dateBorn, dateWork);
        }
    }

    @Override
    public String toString() {
        return "\n" +  "\n" + type + "\n" + fio + "\n" + dateBorn + "\n" + dateWork;
    }


}
