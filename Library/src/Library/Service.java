package Library;

import java.util.HashMap;
import java.util.Scanner;

public class Service {
    /*Model类管理与数据库books表的交互*/
    private Model model = new Model();
    /*userModel类管理与数据库users表的交互*/
    private userModel users = new userModel();
    private HashMap<Integer,Handler> Handlers = new HashMap<Integer,Handler>();
    private Welcome welcome = new Welcome();
    private Login login = new Login();
    /*Service类协调并提供各种服务，包括用户登陆，图书馆界面*/
    public Service() {
        Handlers.put(1,new HandlerConsult(model));
        Handlers.put(2,new HandlerBorrow(model));
        Handlers.put(3,new HandlerReturn(model));
        Handlers.put(4,new HandlerQuit(model));
    }
    /*根据输入的功能编号传唤对应的处理器*/
    public void handle(Model model) {
        Scanner in = new Scanner(System.in);
        while (true) {
            String line = in.nextLine();
            int choice = Integer.parseInt(line);
            Handler handler = Handlers.get(choice);
            try {
                handler.doCmd();
                if (handler.isQuit()) {
                    break;
                }
            }catch (NullPointerException e) {
                System.out.println("请输入数字1～4来选择功能");
            }
        }
    }
    /*欢迎界面*/
    public void welcome() {
        this.welcome.showInterface();
    }
    /*登陆账号*/
    public void login() {
        this.users.connectDB();
        this.login.showInterface();
    }

    public static void main(String[] args) {
        Service service = new Service();
        service.login();
        service.model.connectDB();
        service.welcome();
        service.handle(service.model);
        service.model.closeConn();
    }
}
