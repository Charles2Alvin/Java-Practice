package Library;

public class Welcome {
    private static final int width = 50;
    /*构造一个重复字符s的字符串*/
    public String constructChar(int num, String s) {
        StringBuffer sBuffer = new StringBuffer();
        for (int i=0; i<num; i++) {
            sBuffer.append(s);
        }
        return sBuffer.toString();
    }
    /*简化的输出语句*/
    public void print(String s) {
        System.out.print(s);
    }
    public void println() {
        System.out.println();
    }
    /*构造一个居中显示提示语的字符串*/
    public String centralString(String s) {
        StringBuffer sBuffer = new StringBuffer();
        int length = s.length();
        int leftSpace = (width - length - 2)/2;
        int rightSpace = width-1-leftSpace-length-1;
        if (length % 2 != 0) {
            leftSpace = (int) Math.floor((width - length - 2)/2);
            rightSpace = width-1-leftSpace-length-1;
        }
        sBuffer.append("#");
        sBuffer.append(constructChar(leftSpace," "));
        sBuffer.append(s);
        sBuffer.append(constructChar(rightSpace," "));
        //sBuffer.append("#");
        //System.out.print(sBuffer.toString().length());
        return sBuffer.toString();
    }

    /*显示界面*/
    void showInterface(){
        //上边界
        print(constructChar(width,"#"));
        println();

        //欢迎语
        String welcomeSent = "Welcome to my new library!";
        print(centralString(welcomeSent));println();

        //显式功能
        String f1 = "1.查阅";
        String f2 = "2.借书";
        String f3 = "3.还书";
        String f4 = "4.退出";
        String f5 = "5.增加馆藏";
        print(centralString(f1));println();
        print(centralString(f2));println();
        print(centralString(f3));println();
        print(centralString(f4));println();
        print(centralString(f5));println();

        //下边界
        print(constructChar(50,"#"));println();

        print("请输入您的选择：");println();
    }
}
