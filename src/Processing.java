import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Processing {

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
    private Scanner choiceBr = new Scanner(System.in);

    static ArrayList<Workers> employees = new ArrayList<>();

    public void start () throws IOException {
        choice();
        enter(choiceBr.next());
    }

    private void enter (String string) throws IOException {

        switch (string) {
            case "1":
                employees.add(new Workers (br.readLine(), br.readLine(), br.readLine()));
                print();
                break;
            case "2":
                employees.add(new Workers.Manager (br.readLine(), br.readLine(), br.readLine()));
                print();
                break;
            case "3":
                employees.add(new Workers.Others (br.readLine(), br.readLine(), br.readLine()));
                print();
                break;
            case "4":
                System.out.println("---Введите номер по порядку сотрудника, которого хотите удалить---"+ "\n");
                employees.remove (choiceBr.nextInt() - 1);
                print();
                break;
            case "5":
                System.out.println("Введите номер по порядку сотрудника, тип которого хотите изменить. Затем введите желаемый новый тип: " +
                        "\n" + "-- 1 -- --- Рабочий" + "\n" + "-- 2 -- --- Менеджер" + "\n" + "-- 3 -- --- Другое" + "\n");

                int j = (choiceBr.nextInt() - 1);
                int k = (choiceBr.nextInt());
                switch (k){
                    case 1:
                        employees.set (j, new Workers(" ", " ", " "));
                    case 2:
                        employees.set (j, new Workers.Manager(" ", " ", " "));
                    case 3:
                        employees.set (j, new Workers.Others (" ", " ", " "));
                }
                print();
                break;
            case "6":
                Workers.Manager.addSub((choiceBr.nextInt() - 1), );
        }
        enter(choiceBr.next());
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
