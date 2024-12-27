import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.*;

public class AddCustomer extends JFrame implements ActionListener{

    JTextField tfname, tfnumber, tfcountry, tfage, tfdeposit;
    JButton add, cancel;
    JRadioButton rmale, rfemale;
    JComboBox idCombo;
    Choice croom;
    JLabel checkintime;
    AddCustomer(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("NEW CUSTOMER FORM");
        heading.setFont(new Font("Raleway", Font.BOLD, 20));
        heading.setBounds(100, 20, 300, 30);
        add(heading);

        JLabel lblid = new JLabel("ID");
        lblid.setFont(new Font("Raleway", Font.PLAIN, 16));
        lblid.setBounds(35, 80, 100, 20);
        add(lblid);

        String idOptions[] = {"Aadhar Card", "Passport", "Driving License", "Voter-id Card", "Ration Card"};
        idCombo = new JComboBox(idOptions);
        idCombo.setBounds(200, 80,150, 25);
        idCombo.setBackground(Color.WHITE);
        add(idCombo);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setFont(new Font("Raleway", Font.PLAIN, 16));
        lblnumber.setBounds(35, 120, 100, 20);
        add(lblnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(200, 120, 150, 25);
        add(tfnumber);

        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Raleway", Font.PLAIN, 16));
        lblname.setBounds(35, 160, 100, 20);
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 160, 150, 25);
        add(tfname);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setFont(new Font("Raleway", Font.PLAIN, 16));
        lblgender.setBounds(35, 200, 120, 20);
        add(lblgender);

        rmale = new JRadioButton("Male");
        rmale.setBackground(Color.WHITE);
        rmale.setBounds(200, 200, 60, 25);
        add(rmale);

        rfemale = new JRadioButton("Female");
        rfemale.setBackground(Color.WHITE);
        rfemale.setBounds(260, 200, 100, 25);
        add(rfemale);

        JLabel lblage = new JLabel("Age");
        lblage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblage.setBounds(35, 240, 120, 20);
        add(lblage);

        tfage = new JTextField();
        tfage.setBounds(200, 240, 150, 25);
        add(tfage);

        JLabel lblcountry = new JLabel("Country");
        lblcountry.setFont(new Font("Raleway", Font.PLAIN, 16));
        lblcountry.setBounds(35, 280, 100, 20);
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(200, 280, 150, 25);
        add(tfcountry);

        JLabel lblroom = new JLabel("Room Number");
        lblroom.setFont(new Font("Raleway", Font.PLAIN, 16));
        lblroom.setBounds(35, 320, 150, 20);
        add(lblroom);

        croom = new Choice();
        
        try {
            Conn conn = new Conn();
            String query = "select * from rooms";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                croom.add(rs.getString("roomnumber"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        croom.setBounds(200, 320, 150, 25);
        add(croom);

        JLabel time = new JLabel("Checkin Time");
        time.setFont(new Font("Raleway", Font.PLAIN, 16));
        time.setBounds(35, 360, 150, 20);
        add(time);

        Date date = new Date();
        
        checkintime = new JLabel("" + date);
        checkintime.setBounds(200, 360, 150, 25);
        checkintime.setFont(new Font("Raleway", Font.PLAIN, 14));
        add(checkintime);

        JLabel lbldeposit = new JLabel("Deposit");
        lbldeposit.setFont(new Font("Raleway", Font.PLAIN, 16));
        lbldeposit.setBounds(35, 400, 100, 20);
        add(lbldeposit);

        tfdeposit = new JTextField();
        tfdeposit.setBounds(200, 400, 150, 25);
        add(tfdeposit);


        add = new JButton("Add Customer");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60, 450, 130, 30);
        add.addActionListener(this);
        add(add);

        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220, 450, 130, 30);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 300, 450);
        add(image);

        setBounds(350, 200, 750, 550);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            String id = (String) idCombo.getSelectedItem();
            String name = tfname.getText();
            String number = tfnumber.getText();
            String age = tfage.getText();
            String country = tfcountry.getText();
            String deposit = tfdeposit.getText();
            String gender = null;
            if(rmale.isSelected()){
                gender = "Male";
            }
            else{
                gender = "Female";
            }
            String room = croom.getSelectedItem();
            String time = checkintime.getText();

            try {
                Conn conn = new Conn();

                String str = "insert into customers values('" + id + "','" + name+ "','" + number+ "','" + age + "','" + gender + "','" + country + "','" + deposit + "','"  + room + "','" + time +"')";

                String str2 = "update rooms set availability = 'Occupied' where roomnumber ='" + room + "'";

                conn.s.executeUpdate(str);
                conn.s.executeUpdate(str2);

                JOptionPane.showMessageDialog(null, "New Customer added successfully");
                setVisible(false);
                new Reception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == cancel){
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new AddCustomer();
    }
}
