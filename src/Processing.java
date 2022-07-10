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
            case "1":
                employees.add(new Workers(br.readLine(), br.readLine(), br.readLine()));
                print();
                break;
            case "2":
                employees.add(new Workers.Manager(br.readLine(), br.readLine(), br.readLine()));
                print();
                break;
            case "3":
                employees.add(new Workers.Others(br.readLine(), br.readLine(), br.readLine()));
                print();
                break;
            case "4":
                System.out.println("---Введите номер по порядку сотрудника, которого хотите удалить---" + "\n");
                employees.remove(choiceBr.nextInt() - 1);
                print();
                break;
            case "5":
                System.out.println("Введите номер по порядку сотрудника, тип которого хотите изменить. Затем введите желаемый новый тип: " +
                        "\n" + "-- 1 -- --- Рабочий" + "\n" + "-- 2 -- --- Менеджер" + "\n" + "-- 3 -- --- Другое" + "\n");

                int j = (choiceBr.nextInt() - 1);
                int k = (choiceBr.nextInt());
                switch (k) {
                    case 1:
                        employees.set(j, new Workers(" ", " ", " "));
                        break;
                    case 2:
                        employees.set(j, new Workers.Manager(" ", " ", " "));
                        break;
                    case 3:
                        employees.set(j, new Workers.Others(" ", " ", " "));
                        break;
                }
            case "6":
                Workers.Manager.addSub((choiceBr.nextInt() - 1), new Workers(" ", " ", " "));

            case "7":
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
            System.out.println("Что Вы хотите сделать? \n" + "1. Добавить работника \n" + "2. Добавить Менеджера \n" +
                    "3. Добавить другого сотрудника \n" + "4. Удалить сотрудника \n" + "5. Изменить тип сотрудника \n"
                    + "6. Привязать сотрудника к менеджеру \n" + "7. Сортировать список по фамилиям, датам принятия на работу \n");
        }

        public static void print () {
            System.out.println("Список сотрудников: ");
            for (Workers a : employees) {
                System.out.println(a);
            }
        }

    }
