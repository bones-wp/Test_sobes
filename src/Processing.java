import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

    public void start() throws IOException {
        choice();
        enter(choiceBr.next());
    }

    private void enter(String string) throws IOException {

        switch (string) {
            case "addWorker":
                employees.add(new Workers(br.readLine(), br.readLine(), br.readLine()));
                break;
            case "addManager":
                employees.add(new Workers.Manager(br.readLine(), br.readLine(), br.readLine()));
                break;
            case "addOther":
                employees.add(new Workers.Others(br.readLine(), br.readLine(), br.readLine()));
                break;
            case "delWorker":
                System.out.println("---Введите номер по порядку сотрудника, которого хотите удалить---" + "\n");
                employees.remove(choiceBr.nextInt() - 1);
                break;
            case "replace":
                System.out.println("Введите номер по порядку сотрудника, тип которого хотите изменить. Затем введите желаемый новый тип: " +
                        "\n" + "-- 1 -- --- Рабочий" + "\n" + "-- 2 -- --- Менеджер" + "\n" + "-- 3 -- --- Другое" + "\n");

                int j = (choiceBr.nextInt() - 1);
                int k = (choiceBr.nextInt());
                switch (k) {
                    case 1:
                        //Collections.replaceAll (employees, getClass(), new Workers());
                        break;
                    case 2:
                        employees.set(j, new Workers.Manager(" ", " ", " "));
                        break;
                    case 3:
                        employees.set(j, new Workers.Others(" ", " ", " "));
                        break;
                }
            case "toManager":
                int f = (choiceBr.nextInt() - 1);
                Workers.Manager.subordinates.addAll(f, employees);
                printSub();
                break;

            case "print":
                print();
                break;

            case "sort":
                System.out.println("Введите номер желаемой сортировки: " +
                        "\n" + "-- 1 -- --- по ФИО" + "\n" + "-- 2 -- --- дате принятия на работу" + "\n");

                int l = (choiceBr.nextInt());
                switch (l) {
                    case 1:
                        Comparator<Workers> compareByFIO = new Comparator<Workers>() {
                            @Override
                            public int compare(Workers o1, Workers o2) {
                                return o1.fio.compareTo(o2.fio);
                            }
                        };
                        Collections.sort(employees, compareByFIO);
                        print();
                        break;
                    case 2:
                        Comparator<Workers> compareByDate = new Comparator<Workers>() {
                            @Override
                            public int compare(Workers o1, Workers o2) {
                                return o1.dateWork.compareTo(o2.dateWork);
                            }
                        };
                        Collections.sort(employees, compareByDate);
                        print();
                        break;
                }
            }
            enter(choiceBr.next());

    }

        private void choice () {
            System.out.println("Что Вы хотите сделать? \n" + "Добавить работника -> addWorker \n" + "Добавить Менеджера -> addManager \n" +
                    "Добавить другого сотрудника -> addOther \n" + "Удалить сотрудника - delWorker \n" + "Изменить тип сотрудника -> replace \n"
                    + "Привязать сотрудника к менеджеру - toManager\n" + "Сортировать список по фамилиям, датам принятия на работу -> sort \n");
        }

        public static void print () {
            System.out.println("Список сотрудников: ");
            for (Workers a : employees) {
                System.out.println(a);
            }
        }
        public static void printSub () {
        System.out.println("Список сотрудников в подчиненнии менеджера: ");
        for (Workers a : Workers.Manager.subordinates) {
            System.out.println(a);
        }
    }


}
