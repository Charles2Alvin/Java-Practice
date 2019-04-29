package Library;

public class Login extends Welcome {
    private static final int width = 60;
    @Override
    void showInterface() {
        //上边界
        print(constructChar(width,"#"));
        println();

        //欢迎语
        String welcomeSent = "Welcome to my new library";
        print(centralString(welcomeSent));println();

        //显式功能
        String f1 = "1.账号登陆";
        println();
        String f2 = "2.注册账号";
        print(centralString(f1));println();
        print(centralString(f2));println();

        //下边界
        print(constructChar(50,"#"));println();

        print("请输入您的选择：");println();
    }
}
