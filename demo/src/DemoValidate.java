import java.util.Scanner;

public class DemoValidate {
    public static void main(String[] args) {
        // nhap vao so nguyen tuoi sinh vien phai lon hon 18
        Scanner scanner = new Scanner(System.in);
            System.out.println("Nhap vao tuoi sinh vien");
            int age  = 0;
            boolean isExis = true;
            do {
                try{
                    age = Integer.parseInt(scanner.nextLine());
                    if (age >= 18){
                        isExis = false;
                    } else {
                        System.err.println("tuoi sinh vien phai lon hon 18. vui long nhap lai");
                    }
                } catch (NumberFormatException ex1){
                    System.err.println("tuoi sinh vien phai la so nguyen. vui long nhap lai");
                }
            }while (isExis);
        System.out.println("tuoi sinh vien " + age);
    }
}
