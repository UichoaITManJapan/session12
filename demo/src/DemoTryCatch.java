import java.util.Scanner;

public class DemoTryCatch {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println(" nhap vao so thu 1");
            int number1 = Integer.parseInt(scanner.nextLine());
            System.out.println("nhap vao so thu 2");
            int number2 = Integer.parseInt(scanner.nextLine());
            int divide = number1 / number2;
            System.out.println(" thuong 2 so la :" + divide);
        } catch (Exception ex) {
            System.out.println("co loi xay ra");
        } finally {
            System.err.println("ket thuc chuong trinh");
        }
    }
}
