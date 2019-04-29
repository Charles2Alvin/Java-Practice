//package Library;
//
//import java.util.Scanner;
//
//public class HandlerFunction {
//    public void borrow() {
//        System.out.println("请输入书籍编号和借阅人姓名，用空格分隔");
//        Scanner in = new Scanner(System.in);
//        String line = in.nextLine();
//        String[] words = line.split(" ");
//        try {
//            int bookID = Integer.parseInt(words[0]);
//            String borrower = words[1];
//            System.out.println("您要借阅的是："+bookID + "借阅人" + borrower);
//            model.updateDB(bookID, borrower);
//            System.out.println("借阅成功！");
//        }catch (NumberFormatException e) {
//            System.out.println("您输入的编号超出范围！");
//        }
//
//    }
//    public void searchBook() {
//        System.out.println("请选择：1.查看所有库存 2.查阅书籍");
//        System.out.println("请输入您查阅的图书的编号");
//        Scanner in = new Scanner(System.in);
//        String line = in.nextLine();
//        try {
//            int choice = Integer.parseInt(line);
//            if (choice == 1) {
//                this.model.retrieveDB();
//            }else if (choice ==2) {
//                int bookNum = Integer.parseInt(in.nextLine());
//                System.out.println("您要查阅的是："+bookNum);
//                System.out.println("查阅成功！");
//            }
//        }catch (NumberFormatException e) {
//            System.out.println("您输入的编号超出范围！");
//        }
//    }
//}
