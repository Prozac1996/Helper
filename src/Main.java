import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {

    static JTextField jTextField_1,jTextField_2,jTextField_3,jTextField_6_1,jTextField_6_2,jTextField_6_3;
    static JComboBox jComboBox;

    static ArrayList<String[]> infos = new ArrayList<>();
    static ArrayList<String[]> results = new ArrayList<>();

    public static void main(String[] args) {

        final int[] index = {0};

        JFrame jFrame = new JFrame("大可爱");
        Box box = Box.createVerticalBox();

        JButton jBtn_1 = new JButton("复制1");
        jTextField_1 = new JTextField("区域1");
        jBtn_1.addActionListener(e -> {
            String text1 = jTextField_1.getText();
            setSysClipboardText(text1);
        });
        Box box1 = Box.createHorizontalBox();
        box1.add(jTextField_1);
        box1.add(jBtn_1);

        JButton jBtn_2 = new JButton("复制2");
        jTextField_2 = new JTextField("区域2");
        jBtn_2.addActionListener(e -> {
            String text2 = jTextField_2.getText();
            setSysClipboardText(text2);
        });
        Box box2 = Box.createHorizontalBox();
        box2.add(jTextField_2);
        box2.add(jBtn_2);

        JButton jBtn_3 = new JButton("复制3");
        jTextField_3 = new JTextField("区域3");
        jBtn_3.addActionListener(e -> {
            String text3 = jTextField_3.getText();
            setSysClipboardText(text3);
        });
        Box box3 = Box.createHorizontalBox();
        box3.add(jTextField_3);
        box3.add(jBtn_3);

        JButton jBtn_4 = new JButton("复制4");
        JTextField jTextField_4 = new JTextField("区域4");
        jBtn_4.addActionListener(e -> {
            String text4 = jTextField_4.getText();
            setSysClipboardText(text4);
        });
        Box box4 = Box.createHorizontalBox();
        box4.add(jTextField_4);
        box4.add(jBtn_4);


        Box box5 = Box.createHorizontalBox();
        JButton jBtn_5 = new JButton("格式化邮箱");
        JTextArea jTextArea_1 = new JTextArea();
        JScrollPane jScrollPane_1 = new JScrollPane();
        jScrollPane_1.setViewportView(jTextArea_1);
        jBtn_5.addActionListener((e) -> {
            index[0] = 0;
            infos.clear();
            results.clear();
            String str = jTextArea_1.getText();
            String[] lines = str.split("\n");
            for ( String line : lines ){
                String[] info = line.split("----");
                infos.add(info);
            }
            if(index[0] < infos.size()){
                String[] info = infos.get(index[0]);
                jTextField_1.setText("2018@asdfg");
                jTextField_2.setText(info[2]);
                jTextField_3.setText(info[3]);
                index[0]++;
            }else{
                JOptionPane.showMessageDialog(jFrame,"吃一口屎冷静下","你的邮箱输完了",JOptionPane.INFORMATION_MESSAGE);
            }

        });
        box5.add(jScrollPane_1);
        box5.add(jBtn_5);
//        box5.add(jBtn_5_2);

        Box box6 = Box.createHorizontalBox();
        jTextField_6_1 = new JTextField();
        jTextField_6_1.addFocusListener(new JTextFieldHintListener("IP",jTextField_6_1));
        jTextField_6_2 = new JTextField();
        jTextField_6_2.addFocusListener(new JTextFieldHintListener("手机号",jTextField_6_2));
        jTextField_6_3 = new JTextField();
        jTextField_6_3.addFocusListener(new JTextFieldHintListener("房屋ID",jTextField_6_3));
        box6.add(jTextField_6_1);
        box6.add(jTextField_6_2);
        box6.add(jTextField_6_3);

        Box box7 = Box.createHorizontalBox();
        JButton jButton_7 = new JButton("格式化所有信息并复制到剪切板");
        jButton_7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb;
                StringBuilder sb_sum = new StringBuilder();
                for(String[] result : results){
                    sb = new StringBuilder();
                    for (int i = 0; i < result.length; i++) {
                        sb.append(result[i]);
                        sb.append("\t");
                    }
                    sb_sum.append(sb.toString());
                    sb_sum.append("\n");
                }
                setSysClipboardText(sb_sum.toString());
                JOptionPane.showMessageDialog(jFrame,"提示","复制成功了宝",JOptionPane.INFORMATION_MESSAGE);

            }
        });
        box7.add(jButton_7);

        //国家选择,状态选择
        Box box8 = Box.createHorizontalBox();
        JButton jBtn_8_1 = new JButton("成功");
        JButton jBtn_8_2 = new JButton("失败");
        jComboBox = new JComboBox();
        jComboBox.addItem("ph");
        jComboBox.addItem("vn");
        jComboBox.addItem("kh");
        box8.add(jComboBox);
        jBtn_8_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertResultData(true);
                jTextField_6_1.setText("");
                jTextField_6_2.setText("");
                jTextField_6_3.setText("");
                if(index[0] < infos.size()){
                    String[] info = infos.get(index[0]);
                    jTextField_1.setText("2018@asdfg");
                    jTextField_2.setText(info[2]);
                    jTextField_3.setText(info[3]);
                    index[0]++;
                }else{
                    JOptionPane.showMessageDialog(jFrame,"吃一口屎冷静下","你的邮箱输完了",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        jBtn_8_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertResultData(false);
                jTextField_6_1.setText("");
                jTextField_6_2.setText("");
                jTextField_6_3.setText("");
                if(index[0] < infos.size()){
                    String[] info = infos.get(index[0]);
                    jTextField_1.setText("2018@asdfg");
                    jTextField_2.setText(info[2]);
                    jTextField_3.setText(info[3]);
                    index[0]++;
                }else{
                    JOptionPane.showMessageDialog(jFrame,"吃一口屎冷静下","你的邮箱输完了",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        box8.add(jBtn_8_1);
        box8.add(jBtn_8_2);

        box.add(box5);
        box.add(box1);
        box.add(box2);
        box.add(box3);
        box.add(box4);
        box.add(box6);
        box.add(box8);
        box.add(box7);

        jFrame.add(box);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //复制信息到剪切板
    public static void setSysClipboardText(String writeMe) {
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable tText = new StringSelection(writeMe);
        clip.setContents(tText, null);
    }

    //插入结果数据
    public static void insertResultData(boolean state){
        String[] result = new String[10];
        result[0] = jTextField_1.getText();     //固定密码
        result[1] = " ";                        //账户
        result[2] = " ";                        //密码
        result[3] = jTextField_2.getText();     //邮箱账户
        result[4] = jTextField_3.getText();     //邮箱密码
        result[5] = jTextField_6_1.getText();   //IP
        result[6] = (String) jComboBox.getSelectedItem();//国家简写
        result[7] = jTextField_6_3.getText();   //房屋ID
        result[8] = jTextField_6_2.getText();   //手机号
        result[9] = state?"成功":"失败";
        results.add(result);
    }

}
