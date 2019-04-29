package Library;

import java.util.Scanner;

public class HandlerBorrow extends Handler {
    public HandlerBorrow(Model model) {
        super(model);
    }

    @Override
    public void doCmd() {
        System.out.println("请输入书籍编号和借阅人姓名，用空格分隔");
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] words = line.split(" ");
        try {
            int bookID = Integer.parseInt(words[0]);
            String borrower = words[1];
            System.out.println("您要借阅的是："+bookID + "借阅人" + borrower);
            model.updateDB(bookID, borrower);
            System.out.println("借阅成功！");
        }catch (NumberFormatException e) {
            System.out.println("您输入的编号超出范围！");
        }

    }
}
