package Library;

import java.util.Scanner;

public class HandlerReturn extends Handler {
    public HandlerReturn(Model model) {
        super(model);
    }

    @Override
    public void doCmd() {
        System.out.println("请输入您归还的图书的编号");
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        try {
            long bookNum = Long.parseLong(line);
            System.out.println("您要归还的是："+bookNum);
            System.out.println("归还成功！");
        }catch (NumberFormatException e) {
            System.out.println("您输入的编号超出范围！");
        }
    }
}
