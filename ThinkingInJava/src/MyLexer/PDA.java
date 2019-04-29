package MyLexer;

import java.util.*;

public class PDA {
    //状态的总数
    static int STATE_NUM;
    //栈的开始状态、终止状态、开始符号
    static String START_STATE,FINAL_STATE; static final String START_STACK_SYMBOL = "Z";
    //PDA用的栈
    static Stack<String> stack = new Stack<>();

    //当前状态
    static String current_state;

    LinkedList<LexHandler> handlers = new LinkedList<>();
    //存储状态与处理器配对的哈希表
    HashMap<String, LexHandler> map = new HashMap<>();

    //构造器负责初始化状态总数，始末状态，处理器数组，以及当前状态
    public PDA(int state_num, String start_state, String final_state) {
        STATE_NUM = state_num;
        handlers.add(new LexHandler0());
        handlers.add(new LexHandler1());
        handlers.add(new LexHandler2());
        for (int i = 0; i < STATE_NUM; i++) {
            map.put("q"+i, handlers.get(i));
        }
        START_STATE = start_state;
        FINAL_STATE = final_state;
        current_state = START_STATE;
    }

    //根据当前状态处理读入字符的handler
    interface LexHandler {
        boolean run(String c, String STACK_TOP);
    }
    interface ServiceFactory {
        LexHandler getHandler();
    }
    static class LexHandler0 implements LexHandler {
        @Override
        public boolean run(String c, String top) {
            System.out.println("Handler 0");
            if (c.equals("0") || c.equals("1")) {
                System.out.println("Handler 0: Push "+c);
                stack.push(c);
                return true;
            } else if (c.equals("c")) {
                System.out.println("Handler 0: Read c");
                System.out.println("Handler 0: State switched to q1");
                current_state = "q1";
                return true;
            } else  {
                System.out.println("Handler 0: no match for" +c);
                return false;
            }
        }
        public static ServiceFactory factory = LexHandler0::new;

    }
    static class LexHandler1 implements LexHandler {
        @Override
        public boolean run(String c, String top) {
            System.out.println("Handler 1");
            if (top == START_STACK_SYMBOL) {
                System.out.println("Handler 1: State swithed to q2");
                current_state = FINAL_STATE;
                return true;
            }
            else if ((c.equals("0") && top.equals("0")) || (c.equals("1") && top.equals("1"))) {
                System.out.println("Handler 0: Pop "+c);
                stack.pop();
                return true;
            } else return false;
        }
        public static ServiceFactory factory = LexHandler1::new;
    }
    static class LexHandler2 implements LexHandler {
        @Override
        public boolean run(String c, String STACK_TOP) {
            return true;
        }
        public static ServiceFactory factory = LexHandler2::new;
    }

    private boolean parse(String input) {
        stack.push(START_STACK_SYMBOL);
        LexHandler handler = null;
        for (int i = 0; i < input.length(); i++) {
            //读取栈顶
            String top = stack.peek();
            //读取第i个字符
            String c = String.valueOf(input.charAt(i));
            //提取对应的处理器
            handler = map.get(current_state);
            System.out.println("Main: read "+c+" "+top);
            //只要有一步出现异常，就表明不匹配
            if (!handler.run(c, top)) return false;
        }
        //处理epsilon-production
        handler.run("", stack.peek());
        return stack.peek() == START_STACK_SYMBOL && current_state == FINAL_STATE;
    }
    private void showResult(boolean accepted, String input) {
        System.out.println();
        if (accepted) System.out.println("The PDA accepts the input string: "+ input + " !");
        else System.out.println("The PDA rejects the input string: "+ input + " .");
    }
    public static void main(String[] args) {
        PDA pda = new PDA(3, "q0", "q2");
        String test = "01111c11110";
        pda.showResult(pda.parse(test),test);
    }

}
