import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddEmployee extends JFrame implements ActionListener{

    JTextField fname, fage, fphone, femail, fsalary, faadhar;
    JRadioButton rbmale, rbfemale;
    JButton submit;
    JComboBox cbjob;

    AddEmployee(){
        setLayout(null);

        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60, 30, 120, 30);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblname);

        fname = new JTextField();
        fname.setBounds(200, 30, 150, 30);
        add(fname);

        JLabel lblage = new JLabel("AGE");
        lblage.setBounds(60, 80, 120, 30);
        lblage.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblage);

        fage = new JTextField();
        fage.setBounds(200, 80, 150, 30);
        add(fage);

        JLabel lblgender = new JLabel("GENDER");
        lblgender.setBounds(60, 130, 120, 30);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblgender);

        rbmale = new JRadioButton("Male");
        rbmale.setBounds(200, 130, 70, 30);
        rbmale.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);

        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(280, 130, 70, 30);
        rbfemale.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);

        JLabel lbljob = new JLabel("JOB");
        lbljob.setBounds(60, 180, 120, 30);
        lbljob.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lbljob);

        String str[] = {"Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Staff", "Room Service", "Chefs", "Waiter/Waitress", "Manager", "Accountant"};
        cbjob = new JComboBox(str);
        cbjob.setBounds(200, 180, 150, 30);
        cbjob.setBackground(Color.WHITE);
        add(cbjob);

        JLabel lblsalary = new JLabel("SALARY");
        lblsalary.setBounds(60, 230, 120, 30);
        lblsalary.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblsalary);

        fsalary = new JTextField();
        fsalary.setBounds(200, 230, 150, 30);
        add(fsalary);

        JLabel lblphone = new JLabel("PHONE");
        lblphone.setBounds(60, 280, 120, 30);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblphone);

        fphone = new JTextField();
        fphone.setBounds(200, 280, 150, 30);
        add(fphone);

        JLabel lblemail = new JLabel("EMAIL");
        lblemail.setBounds(60, 330, 120, 30);
        lblemail.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblemail);

        femail = new JTextField();
        femail.setBounds(200, 330, 150, 30);
        add(femail);

        JLabel lblaadhar = new JLabel("AADHAR");
        lblaadhar.setBounds(60, 380, 120, 30);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblaadhar);

        faadhar = new JTextField();
        faadhar.setBounds(200, 380, 150, 30);
        add(faadhar);

        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(200, 430, 150, 30);
        submit.addActionListener(this);
        add(submit);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 60, 450, 370);
        add(image);

        getContentPane().setBackground(Color.WHITE);
        setBounds(350, 200, 850, 540);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String name = fname.getText();
        String age = fage.getText();
        String salary = fsalary.getText();
        String phone = fphone.getText();
        String email = femail.getText();
        String aadhar = faadhar.getText();
        String gender = null;

        if(name.equals("")){
            JOptionPane.showMessageDialog(null, "Name should not be empty");
            return;
        }

        if(email.equals("") || !email.contains(".com") || !email.contains("@")){
            JOptionPane.showMessageDialog(null, "Enter a valid email!");
            return;
        }

        if(rbmale.isSelected()){
            gender = "Male";
        } 
        else if(rbfemale.isSelected()){
            gender = "Female";
        }
        String job = (String) cbjob.getSelectedItem();
        
        try{
            Conn conn = new Conn();
            String query = "insert into employee values('"+ name +"' ,'" + age + "' ,'" + gender + "' ,'" + job + "' ,'" + salary + "' ,'" + phone + "' ,'" + email + "' ,'" + aadhar + "')";
            conn.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Employee added successfully");

            setVisible(false);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String args[]){
        new AddEmployee();
    }
}
