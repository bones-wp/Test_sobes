import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "Form.txt";
        FileInputStream fis = new FileInputStream(fileName);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        Workers.Employee one = new Workers.Employee(br.readLine(), br.readLine(), br.readLine());

        System.out.println(one.fio + "\n" + one.dateBorn + "\n" + one.dateWork);

        fis.close();
    }
}
