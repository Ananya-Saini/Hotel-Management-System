import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AddRooms extends JFrame implements ActionListener{

    JTextField tfroom, tfprice;
    JButton add, cancel;
    JComboBox occupancyCombo, availableCombo, cleanCombo;
    AddRooms(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add Rooms");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(150, 20, 200, 20);
        add(heading);

        JLabel lblroomno = new JLabel("Room Number");
        lblroomno.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblroomno.setBounds(60, 80, 120, 30);
        add(lblroomno);

        tfroom = new JTextField();
        tfroom.setBounds(200, 80, 150, 30);
        add(tfroom);

        JLabel lblavailable = new JLabel("Availability");
        lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblavailable.setBounds(60, 130, 120, 30);
        add(lblavailable);

        String availableOptions[] = {"Available", "Occupied"};
        availableCombo = new JComboBox(availableOptions);
        availableCombo.setBounds(200, 130,150, 30);
        availableCombo.setBackground(Color.WHITE);
        add(availableCombo);

        JLabel lblclean = new JLabel("Cleaning Status");
        lblclean.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblclean.setBounds(60, 180, 120, 30);
        add(lblclean);

        String cleaningOptions[] = {"Clean", "Not Clean"};
        cleanCombo = new JComboBox(cleaningOptions);
        cleanCombo.setBounds(200, 180,150, 30);
        cleanCombo.setBackground(Color.WHITE);
        add(cleanCombo);

        JLabel lblprice = new JLabel("Price");
        lblprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblprice.setBounds(60, 230, 120, 30);
        add(lblprice);

        tfprice = new JTextField();
        tfprice.setBounds(200, 230, 150, 30);
        add(tfprice);

        JLabel lblOccupancy = new JLabel("Occupancy");
        lblOccupancy.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblOccupancy.setBounds(60, 280, 120, 30);
        add(lblOccupancy);

        String occupancyOptions[] = {"Single", "Double"};
        occupancyCombo = new JComboBox(occupancyOptions);
        occupancyCombo.setBounds(200, 280,150, 30);
        occupancyCombo.setBackground(Color.WHITE);
        add(occupancyCombo);

        add = new JButton("Add Room");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60, 350, 130, 30);
        add.addActionListener(this);
        add(add);

        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220, 350, 130, 30);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400, 30, 500, 300);
        add(image);

        setBounds(330, 200, 940, 470);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            String room = tfroom.getText();
            String availability = (String) availableCombo.getSelectedItem();
            String status = (String) cleanCombo.getSelectedItem();
            String price = tfprice.getText();
            String occupancy = (String) occupancyCombo.getSelectedItem();

            try {
                Conn conn = new Conn();
                String str = "insert into rooms values('" + room+ "','" + availability+ "','" + status+ "','" + price + "','" + occupancy +"')";
                conn.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "New Room added successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == cancel){
            setVisible(false);
            new Dashboard();
        }
    }

    public static void main(String[] args) {
        new AddRooms();
    }
}
