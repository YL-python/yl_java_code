package main.java.Swing.LED2;

import main.java.Swing.LED.LEDLoadingBtn;
import main.java.Swing.LED.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Test2 {
    static int page = 1;
    static LEDSettingTableModel ledtm = new LEDSettingTableModel();

    static JTable t = new JTable(ledtm);

    public static void main(String[] args) {
        final JFrame f = new JFrame("Test1");
        f.setSize(500, 400);
        f.setLocationRelativeTo(null);
        f.setLayout(new BorderLayout());
        JScrollPane sp = new JScrollPane(t);
        sp.setPreferredSize(new Dimension(500, 300));
        // 设置选择模式为 只能选中一行
        t.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // 选中第一行 （基本0）
        t.getSelectionModel().setSelectionInterval(0, 0);
        t.setRowHeight(25);
        //面板1
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        JButton bAdd = new JButton("-添加-");
        JButton bDelete = new JButton("-删除-");
        JButton bModify = new JButton("-修改-");
        JButton bOver = new JButton("-完成-");
        bDelete.setSize(80, 30);
        bAdd.setSize(80, 30);
        bModify.setSize(80, 30);
        bOver.setSize(80, 30);
        p.add(bAdd);
        p.add(bDelete);
        p.add(bModify);
        p.add(bOver);

        // 添加按钮绑定事件
        bAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddJDialog(f).setVisible(true);
            }
        });

        f.add(p, BorderLayout.CENTER);
        f.add(sp, BorderLayout.NORTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public static class AddJDialog extends JDialog {

        main.java.Swing.LED.LEDSetting ledsetting = new main.java.Swing.LED.LEDSetting();
        JButton b = new JButton("提交");

        AddJDialog(JFrame f) {
            super(f);
            LEDLoadingBtn ledLoadingBtn = new LEDLoadingBtn();
            ledLoadingBtn.showBtn(this,ledsetting);
            this.setSize(300, 300);
            this.setModal(true);
            int gap = 50;
            this.setLayout(null);
            this.setLocationRelativeTo(f);

            b.setBounds(110, 210, 80, 30);

            this.add(b);

            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    LEDSetting ledSetting = new LEDSetting();
                    ledSetting.setColorList(ledsetting.getColorList());
                    ledSetting.setTime(ledsetting.getTime());
                    page = 1;
                    JOptionPane.showMessageDialog(f, "提交成功 ");

                    AddJDialog.this.setVisible(false);
//                    updateTable();
                }
            });
        }
    }

    public static String checkMessage(JTextField tf1, JTextField tf2){
        String name = tf1.getText();
        String hp = tf2.getText();

        DecimalFormat df =new DecimalFormat("#000000.00");
        //处理name
        if(name.length() > 10){
            return "输入的name已经超过字数允许";
        }
        try{
            Float.parseFloat(hp);
        }catch(NumberFormatException e){
            return "您输入的hp不是一个合法的数字";
        }

        return null;
    }
}
