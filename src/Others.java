public class Others extends Workers {
    private String text;
    public Others(String fio, String dateBorn, String dateWork, String text) {
        super(fio, dateBorn, dateWork);
        this.text = text;
    }
    public Others (){}

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    @Override
    public String toString() {
        return "\n" + getClass() + "\n" + "ФИО: " + fio + "\n" + "Дата рождения: " + dateBorn + "\n"
                + "Дата принятия на работу: " + dateWork + "\n" + "Текстовое описание сотрудника: " + text;
    }

}