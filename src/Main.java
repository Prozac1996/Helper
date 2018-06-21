import javafx.embed.swing.JFXPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<String[]> infos = new ArrayList<>();
        final int[] index = {0};

        JFrame jFrame = new JFrame("小可爱");
        Box box = Box.createVerticalBox();
        
        JButton jBtn_1 = new JButton("复制1");
        JTextField jTextField_1 = new JTextField("区域1");
        jBtn_1.addActionListener(e -> {
            String text1 = jTextField_1.getText();
            setSysClipboardText(text1);
        });
        Box box1 = Box.createHorizontalBox();
        box1.add(jTextField_1);
        box1.add(jBtn_1);

        JButton jBtn_2 = new JButton("复制2");
        JTextField jTextField_2 = new JTextField("区域2");
        jBtn_2.addActionListener(e -> {
            String text2 = jTextField_2.getText();
            setSysClipboardText(text2);
        });
        Box box2 = Box.createHorizontalBox();
        box2.add(jTextField_2);
        box2.add(jBtn_2);

        JButton jBtn_3 = new JButton("复制3");
        JTextField jTextField_3 = new JTextField("区域3");
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
        JButton jBtn_5_2 = new JButton("下一个");
        JTextArea jTextArea_1 = new JTextArea("邮箱源格式");
        JScrollPane jScrollPane_1 = new JScrollPane();
        jScrollPane_1.setViewportView(jTextArea_1);
        jBtn_5.addActionListener((e) -> {
            String str = jTextArea_1.getText();
            String[] lines = str.split("\n");
            for ( String line : lines ){
                String[] info = line.split("----");
                infos.add(info);

            }
        });
        jBtn_5_2.addActionListener((e)->{
            String[] info = infos.get(index[0]);
            index[0]++;
            jTextField_1.setText(info[2]);
            jTextField_2.setText(info[0]);
            jTextField_3.setText(info[1]);
            jTextField_4.setText("2018@asdfg");

        });
        box5.add(jScrollPane_1);
        box5.add(jBtn_5);
        box5.add(jBtn_5_2);

        box.add(box5);
        box.add(box1);
        box.add(box2);
        box.add(box3);
        box.add(box4);


        jFrame.add(box);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void setSysClipboardText(String writeMe) {
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable tText = new StringSelection(writeMe);
        clip.setContents(tText, null);
    }
}
