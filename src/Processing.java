import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Processing {

    String fileName = "Employees.txt";
    FileInputStream fis = new FileInputStream(fileName);


    BufferedReader br = new BufferedReader(new InputStreamReader(fis));
    private Scanner choiceBr = new Scanner(System.in);

    ArrayList<Workers> employees = new ArrayList<Workers>();

    public Processing() throws FileNotFoundException {
    }

    public void start() throws IOException {
        choice();
        enter(choiceBr.next());
    }

    private void enter(String string) throws IOException {

        switch (string) {
            case "addWorker":
                employees.add(new Workers(br.readLine(), br.readLine(), br.readLine()));
                System.out.println("Работник добавлен");
                break;
            case "addManager":
                employees.add(new Manager(br.readLine(), br.readLine(), br.readLine()));
                System.out.println("Менеджер добавлен");
                break;
            case "addOther":
                employees.add(new Others(br.readLine(), br.readLine(), br.readLine(), br.readLine()));
                System.out.println("Сотрудник добавлен");
                break;
            case "delWorker":
                System.out.println("---Введите номер по порядку сотрудника, которого хотите удалить---" + "\n");
                employees.remove(choiceBr.nextInt() - 1);
                break;
            case "replace":
                System.out.println("Введите номер по порядку сотрудника, тип которого хотите изменить: " );

                int j = (choiceBr.nextInt() - 1);
                Workers worker = employees.get(j);

                System.out.println("Введите кем он будет теперь: "+
                        "\n" + "-- 1 -- --- Рабочий" + "\n" + "-- 2 -- --- Менеджер" + "\n" + "-- 3 -- --- Другое" + "\n");
                int k = (choiceBr.nextInt());
                switch (k) {
                    case 1:
                        Workers newWorker = new Workers();
                        newWorker.setFio(worker.fio);
                        newWorker.setDateBorn(worker.dateBorn);
                        newWorker.setDateWork(worker.dateWork);
                        employees.remove(j);
                        employees.add(newWorker);
                        break;
                    case 2:
                        Manager manager = new Manager();
                        manager.setFio(worker.fio);
                        manager.setDateBorn(worker.dateBorn);
                        manager.setDateWork(worker.dateWork);
                        employees.remove(j);
                        employees.add(manager);
                        break;
                    case 3:
                        Others other = new Others();
                        other.setFio(worker.fio);
                        other.setDateBorn(worker.dateBorn);
                        other.setDateWork(worker.dateWork);
                        System.out.println("Введите описание сотрудника: ");
                        String line = choiceBr.nextLine();
                        other.setText(line);
                        employees.remove(j);
                        employees.add(other);
                        break;
                }
            case "toManager":
                System.out.println("Введите номер по порядку сотрудника - менеджера, которому хотите добавить в подчинение людей: ");
                int f = (choiceBr.nextInt() - 1);
                Workers oldManager = employees.get(f);

                Manager newManager = new Manager();
                newManager.setFio(oldManager.fio);
                newManager.setDateBorn(oldManager.dateBorn);
                newManager.setDateWork(oldManager.dateWork);
                employees.remove(f);

                System.out.println("Введите номер по порядку сотрудника, которого хотите добавить в подчинение к менеджеру: ");
                int s = (choiceBr.nextInt() - 1);
                newManager.addWorker(employees.get(s));
                employees.add(newManager);

                newManager.printSub();
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
                        employees.sort(((o1, o2) -> o1.fio.compareTo(o2.fio)));

                        //employees.sort(new Comparator<Workers>() {
                         //   @Override
                            //public int compare(Workers o1, Workers o2) {
                            //    return o1.fio.compareTo(o2.fio);
                            //}
                        //});
                        print();
                        break;
                    case 2:
                        employees.sort(((o1, o2) -> o1.dateWork.compareTo(o2.dateWork)));

                        //employees.sort(new Comparator<Workers>() {
                            //@Override
                            //public int compare(Workers o1, Workers o2) {
                                //return o1.dateWork.compareTo(o2.dateWork);
                            //}
                        //});
                        print();
                        break;
                }
            }
            enter(choiceBr.next());
    }

        private void choice () {
            System.out.println("Что Вы хотите сделать? \n" + "Добавить работника -> addWorker \n" + "Добавить Менеджера -> addManager \n" +
                    "Добавить другого сотрудника -> addOther \n" + "Удалить сотрудника - delWorker \n" + "Изменить тип сотрудника -> replace \n"
                    + "Привязать сотрудника к менеджеру - toManager \n" + "Сортировать список по фамилиям, датам принятия на работу -> sort \n" +
                    "Распечатать список всех сотрудников -> print \n");
        }

        public void print () {
            System.out.println("Список сотрудников: ");
            for (Workers a : employees) {
                System.out.println(a);
            }
        }
}



