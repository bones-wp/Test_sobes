import java.util.ArrayList;

public class Manager extends Workers {
    ArrayList<Workers> subordinates = new ArrayList<>();

    public Manager(String fio, String dateBorn, String dateWork) {
        super(fio, dateBorn, dateWork);
    }
    public Manager (){}

    public void setSubordinates(ArrayList<Workers> subordinates) {
        this.subordinates = subordinates;
    }
    public void addWorker (Workers worker) {
        this.subordinates.add(worker);
    }
    @Override
    public String toString() {
        return "\n" + getClass() + "\n" + "ФИО: " + fio + "\n" + "Дата рождения: " + dateBorn + "\n"
                + "Дата принятия на работу: " + dateWork + "\n" + "Список подчинённых сотрудников: " + subordinates;
    }
    public void printSub () {
        System.out.println("Список сотрудников в подчиненнии менеджера: ");
        for (Workers a : subordinates) {
            System.out.println(a);
        }
    }

}