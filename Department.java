import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class Department extends JFrame implements ActionListener{

    JTable table;
    JButton back;
    Department(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel l1 = new JLabel("Department");
        l1.setBounds(150, 10, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Budget");
        l2.setBounds(500, 10, 100,20);
        add(l2);

        table = new JTable();
        table.setBounds(0, 40, 700, 350);
        add(table);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from department");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(300, 400, 120, 30);
        add(back);

        setBounds(400, 200, 700, 480);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }

    public static void main(String[] args) {
        new Department();
    }
}
