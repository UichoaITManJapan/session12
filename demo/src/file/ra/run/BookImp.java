package file.ra.run;
import file.ra.entity.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookImp {
    private static List<Book> booksList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isRunning = true;
        do {
            System.out.println("*************************MENU************************");
            System.out.println("1. Nhập thông tin các sách");
            System.out.println("2. In thông tin các sách ra file demo.txt");
            System.out.println("3. Đọc file demo.txt và in ra các sách có giá trong khoảng 10000 đến 20000");
            System.out.println("4. Thoát");
            System.out.println("=======================================================");
            try{
                System.out.println("Chọn :");
                int choice = Integer.parseInt(scanner.nextLine());
                System.out.println("=======================================================");
                switch (choice){
                    case 1:
                        inputBook();
                        break;
                    case 2:
                        writeDataToFile(booksList);
                        break;
                    case 3:
                        List<Book> listBookRead = readDataToFile();
                        for (Book book: listBookRead) {
                            if (book.getPrice() >= 10000 && book.getPrice() <=20000){
                                System.out.println(book);
                            }
                        }
                        break;
                    case 4:
                        isRunning = false;
                        System.out.println("Thoát chương trình.");
                        break;
                    default:
                        System.err.println("Vui lòng lựa chọn từ 1-5!");
                }
            }catch (NumberFormatException nfe){
                System.err.println("Lỗi " + nfe.getMessage() + ". Vui lòng nhập lại!");
            }

        }while (isRunning);
    }

    public static void inputBook(){
        System.out.println("nhập số lượng sách");
        try {
            int n = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < n; i++) {
                System.out.println("Nhập thông tin sách thứ " + (i + 1));
                System.out.println("Nhập mã sách :");
                String bookId = scanner.nextLine();
                System.out.println("nhập tên sách :");
                String bookName = scanner.nextLine();
                System.out.println("Nhập giá sách :");
                float price = Float.parseFloat(scanner.nextLine());
                booksList.add(new Book(bookId, bookName, price));
                System.out.println("=======================================================");
            }
        }catch(Exception e){
                System.err.println("Lỗi " + e.getMessage() + ".Vui lòng nhập lại!");
            }
    }
     static File file = new File("demo.txt");
    public static void writeDataToFile(List<Book> booksList){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(booksList);
            oos.flush();
        } catch (FileNotFoundException ex1){
            System.err.println( " File không tồn tại!");
        } catch (IOException ex2){
            System.err.println("lỗi khi ghi dữ liệu ra file!");
        } catch (Exception ex){
            System.err.println("Xảy ra lỗi khi ghi dữ liệu ra file!");
        } finally {
            try{
                if (oos != null){
                    oos.close();
                }
                if (fos != null){
                    fos.close();
                }
            } catch (IOException ex1){
                System.err.println("Xảy ra lỗi khi đóng các stream!");
            } catch (Exception ex){
                System.err.println("xảy ra lỗi trong quá trình đóng các stream!");
            }
        }
    }

    public static List<Book> readDataToFile(){
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        List<Book> bookListRead = null;
        try{
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            bookListRead = (List<Book>) ois.readObject();
        } catch (FileNotFoundException ex1){
            System.err.println("không tồn tại file!");
        } catch (IOException ex2){
            System.err.println("lỗi khi đọc file!");
        } catch (Exception ex){
            System.err.println("Có lỗi trong qúa trình đọc dữ liều từ file!");
        } finally {
            try {
                if (ois != null){
                    ois.close();
                }
                if (fis != null){
                    fis.close();
                }
            } catch (IOException ex1){
                System.err.println("lỗi khi đóng file!");
            } catch (Exception ex2){
                System.err.println("có lỗi trong quá trình đóng các stream!");
            }
        }
        return  bookListRead;
    }

}
