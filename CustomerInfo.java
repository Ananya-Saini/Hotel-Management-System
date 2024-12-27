import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class CustomerInfo extends JFrame implements ActionListener{

    JTable table;
    JButton back;
    CustomerInfo(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel l1 = new JLabel("Document");
        l1.setBounds(30, 10, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Name");
        l2.setBounds(150, 10, 100,20);
        add(l2);

        JLabel l3 = new JLabel("Number");
        l3.setBounds(250, 10, 100,20);
        add(l3);

        JLabel l4 = new JLabel("Age");
        l4.setBounds(380, 10, 100,20);
        add(l4);

        JLabel l5 = new JLabel("Gender");
        l5.setBounds(480, 10, 100,20);
        add(l5);

        JLabel l6 = new JLabel("Country");
        l6.setBounds(590, 10, 100,20);
        add(l6);

        JLabel l7 = new JLabel("Deposit");
        l7.setBounds(710, 10, 100,20);
        add(l7);

        JLabel l8 = new JLabel("Room");
        l8.setBounds(830, 10, 100,20);
        add(l8);

        JLabel l9 = new JLabel("Checkin Time");
        l9.setBounds(910, 10, 100,20);
        add(l9);

        table = new JTable();
        table.setBounds(0, 40, 1020, 400);
        add(table);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customers");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(420, 500, 120, 30);
        add(back);

        setBounds(300,200, 1020, 600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }

    public static void main(String[] args) {
        new CustomerInfo();
    }
}
