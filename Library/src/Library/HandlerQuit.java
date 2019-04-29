package Library;

public class HandlerQuit extends Handler {
    public HandlerQuit(Model model) {
        super(model);
    }

    @Override
    public void doCmd() {
        model.closeConn();
        String s = "感谢您的光临，再见！";
        System.out.println(s);
    }

    @Override
    public boolean isQuit() {
        return true;
    }
}
