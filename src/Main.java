import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        String fileName = "Form.txt";
        FileInputStream fis = new FileInputStream(fileName);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        ArrayList<Workers.Employee> employees = new ArrayList<>();

        int count = 0;
        count = count++;

        employees.add(count, new Workers.Employee(br.readLine(), br.readLine(), br.readLine()));

        for (Workers a : employees) {
            System.out.println(a);
        }

        fis.close();
    }
}
