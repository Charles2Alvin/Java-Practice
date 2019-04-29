package Timetable;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JTable table = new JTable(new TableData());
        //把表格加入滚动面板
        JScrollPane pane = new JScrollPane(table);
        //将面板加入窗口
        frame.add(pane);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
