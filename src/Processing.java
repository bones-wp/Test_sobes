import java.io.*;
import java.util.ArrayList;

public class Processing {
    int count = 0;

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
    private BufferedReader choiceBr = new BufferedReader(new InputStreamReader(System.in));

    static ArrayList<Workers.Employee> employees = new ArrayList<>();
    static ArrayList<Workers.Employee> subordinates = new ArrayList<>();

    public void start () throws IOException {
        choice();
        enter(choiceBr.readLine());
    }

    private void enter (String string) throws IOException {

        switch (string) {
            case "1":
                employees.add(count, new Workers.Employee("Работник", br.readLine(), br.readLine(), br.readLine()));
                count++;
                print();
                break;
            case "2":
                employees.add(count, new Workers.Employee("Менеджер", br.readLine(), br.readLine(), br.readLine()));
                count++;
                print();
                break;
            case "3":
                employees.add(count, new Workers.Employee("Руководитель", br.readLine(), br.readLine(), br.readLine()));
                count++;
                print();
                break;
            case "4":
                System.out.println("---Введите номер сотрудника, которого хотите удалить---"+ "\n");
                employees.remove (Integer.parseInt(choiceBr.readLine()));
                print();
                break;
            case "5":
                System.out.println("---Введите номер сотрудника, тип которого хотите изменить. Затем введите желаемый новый тип---" + "\n");
                employees.set ((Integer.parseInt(choiceBr.readLine())), new Workers.Employee(choiceBr.readLine(), br.readLine(), br.readLine(), br.readLine()));
                print();
                break;
        }
        enter(choiceBr.readLine());
    }

    private void choice(){
        System.out.println("Что Вы хотите сделать? \n" + "1. Добавить работника \n" + "2. Добавить Менеджера \n" +
                "3. Добавить другого сотрудника \n" + "4. Удалить сотрудника \n" + "5. Изменить тип сотрудника \n"
                + "6. Привязать сотрудника к менеджеру \n" + "7. Сортировать список по фамилиям, датам принятия на работу \n");
    }

    public static void print() {
        System.out.println("Список сотрудников: ");
        for (Workers a : employees) {
            System.out.println(a);
        }
    }

}
