import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Workers.addEmp();
        Workers.addEmp();

        Workers.print();

        Workers.fis.close();
    }
}
