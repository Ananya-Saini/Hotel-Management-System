import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AddDriver extends JFrame implements ActionListener{

    JTextField tfname, tfcompany, tfage, tfModel, tfLocation;
    JButton add, cancel;
    JComboBox genderCombo, availableCombo;
    AddDriver(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add Driver");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(150, 10, 200, 20);
        add(heading);

        JLabel lblname = new JLabel("NAME");
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblname.setBounds(60, 70, 120, 30);
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 70, 150, 30);
        add(tfname);

        JLabel lblage = new JLabel("AGE");
        lblage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblage.setBounds(60, 110, 120, 30);
        add(lblage);

        tfage = new JTextField();
        tfage.setBounds(200, 110, 150, 30);
        add(tfage);

        JLabel lblgender = new JLabel("GENDER");
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblgender.setBounds(60, 150, 120, 30);
        add(lblgender);

        String genderOptions[] = {"Male", "Female"};
        genderCombo = new JComboBox(genderOptions);
        genderCombo.setBounds(200, 150,150, 30);
        genderCombo.setBackground(Color.WHITE);
        add(genderCombo);

        JLabel lblcompany = new JLabel("CAR COMPANY");
        lblcompany.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblcompany.setBounds(60, 190, 120, 30);
        add(lblcompany);

        tfcompany = new JTextField();
        tfcompany.setBounds(200, 190, 150, 30);
        add(tfcompany);

        JLabel lblModel = new JLabel("CAR MODEL");
        lblModel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblModel.setBounds(60, 230, 120, 30);
        add(lblModel);

        tfModel = new JTextField();
        tfModel.setBounds(200, 230, 150, 30);
        add(tfModel);

        JLabel lblavailable = new JLabel("AVAILABILITY");
        lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblavailable.setBounds(60, 270, 120, 30);
        add(lblavailable);

        String availableOptions[] = {"Available", "Busy"};
        availableCombo = new JComboBox(availableOptions);
        availableCombo.setBounds(200, 270,150, 30);
        availableCombo.setBackground(Color.WHITE);
        add(availableCombo);

        JLabel lblLocation = new JLabel("LOCATION");
        lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblLocation.setBounds(60, 310, 120, 30);
        add(lblLocation);

        tfLocation = new JTextField();
        tfLocation.setBounds(200, 310, 150, 30);
        add(tfLocation);

        add = new JButton("Add Driver");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60, 370, 130, 30);
        add.addActionListener(this);
        add(add);

        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220, 370, 130, 30);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 30, 500, 300);
        add(image);

        setBounds(300, 200, 980, 470);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            String name = tfname.getText();
            String age = tfage.getText();
            String gender = (String) genderCombo.getSelectedItem();
            String company = tfcompany.getText();
            String model = tfModel.getText();
            String available = (String) availableCombo.getSelectedItem();
            String location = tfLocation.getText();

            try {
                Conn conn = new Conn();
                String str = "insert into drivers values('" + name+ "','" + age + "','" + gender + "','" + company + "','" + model + "','" + available + "','" + location+"')";
                conn.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "New Driver added successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == cancel){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddDriver();
    }
}
