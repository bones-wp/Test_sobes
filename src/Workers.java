import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Workers {
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    String fio;
    LocalDate dateBorn, dateWork;

    public Workers(String fio, String dateBorn, String dateWork){
        this.fio = fio;
        this.dateBorn = LocalDate.parse(dateBorn, dateFormatter);
        this.dateWork = LocalDate.parse(dateWork, dateFormatter);
    }
    public Workers (){}

    @Override
    public String toString() {
        return "\n" + getClass() + "\n" + "ФИО: " + fio + "\n" + "Дата рождения: " + dateBorn + "\n" + "Дата принятия на работу: " + dateWork;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setDateBorn(LocalDate dateBorn) {
        this.dateBorn = dateBorn;
    }

    public void setDateWork(LocalDate dateWork) {
        this.dateWork = dateWork;
    }

    public String getFio() {
        return fio;
    }

    public LocalDate getDateBorn() {
        return dateBorn;
    }

    public LocalDate getDateWork() {
        return dateWork;
    }
}
