import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class loginPage {

    private  static  final String url = "jdbc:mysql://localhost:3306/student_management_system";
    private  static  final String username = "root";
    private static final String password = "root";
    Statement statement;

    loginPage() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            statement = connection.createStatement();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        JFrame frame = new JFrame("EduRank");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(new GridLayout(1,2));

        ImageIcon titleLogo = new ImageIcon("F:\\Programming\\Java\\Please finish this one\\Images\\Title Logo.png");
        Image image = titleLogo.getImage();
        frame.setIconImage(image);


        JPanel imagePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon icon = new ImageIcon("F:\\Programming\\Java\\Please finish this one\\Images\\Login Page Cover.png");
                g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        imagePanel.setLayout(null);


        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);
        loginPanel.setBackground(Color.white);


        JLabel loginTextLabel = new JLabel("Log In");
        loginTextLabel.setBounds(70, 100, 200,100);
        loginTextLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
        loginTextLabel.setForeground(new Color(102,0,0));


        JLabel welcomeTextLabel = new JLabel("Hello again ! Please enter your details.");
        welcomeTextLabel.setBounds(70, 150, 300,100);
        welcomeTextLabel.setFont(new Font("Ariel", Font.BOLD, 15));
        welcomeTextLabel.setForeground(Color.darkGray);


        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(70, 210, 100,100);
        usernameLabel.setFont(new Font("Ariel", Font.BOLD, 15));
        usernameLabel.setForeground(Color.BLACK);


        JTextField usernameTextField = new JTextField();
        usernameTextField.setBounds(70, 280, 250, 35);
        usernameTextField.setFont(new Font("Ariel", Font.BOLD, 13));
        usernameTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                usernameTextField.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (usernameTextField.getText().isEmpty()) {
                    usernameTextField.setText("Please enter your username");
                }
            }
        });


        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(70, 300, 100,100);
        passwordLabel.setFont(new Font("Ariel", Font.BOLD, 15));
        passwordLabel.setForeground(Color.BLACK);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(70, 370, 250, 35);
        passwordField.setFont(new Font("Ariel", Font.BOLD, 13));
        passwordField.setEchoChar('*');


        JButton loginButton = new JButton("Login");
        loginButton.setBounds(95,460,200,35);
        loginButton.setFont(new Font("Ariel", Font.BOLD, 15));
        loginButton.setForeground(Color.BLACK);
        loginButton.setBackground(new Color(102,178,255));
        loginButton.setFocusable(false);
        ActionListener actionListener = e -> {
            if(e.getSource() == loginButton ) {

                String query = String.format("SELECT * FROM personal_details WHERE username = '%s' AND PASSWORD = '%s'", usernameTextField.getText(), new String(passwordField.getPassword()));
                try {
                    ResultSet resultSet = statement.executeQuery(query);
                    if(resultSet.next()) System.out.println("OK");

                    else if(usernameTextField.getText().isEmpty() || (new String(passwordField.getPassword())).isEmpty()) {
                        JOptionPane.showMessageDialog(null,"Information blank.",
                        "ERROR", JOptionPane.WARNING_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Invalid information !",
                                "ERROR", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }

            }
        };
        loginButton.addActionListener(actionListener);

        JLabel NoAccountLabel = new JLabel("Don't have an account ?");
        NoAccountLabel.setBounds(81, 500, 300,100);
        NoAccountLabel.setFont(new Font("Ariel", Font.BOLD, 14));
        NoAccountLabel.setForeground(Color.BLACK);

        JLabel signUPLabel = new JLabel("<html><u>Sign Up</u></html>");
        signUPLabel.setBounds(253, 500, 300,100);
        signUPLabel.setFont(new Font("Ariel", Font.BOLD, 14));
        signUPLabel.setForeground(new Color(204,0,0));
        signUPLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new signUpPage();
            }
        });


        loginPanel.add(usernameLabel);
        loginPanel.add(passwordLabel);
        loginPanel.add(loginTextLabel);
        loginPanel.add(welcomeTextLabel);
        loginPanel.add(usernameTextField);
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);
        loginPanel.add(NoAccountLabel);
        loginPanel.add(signUPLabel);


        frame.add(imagePanel);
        frame.add(loginPanel);

        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new loginPage();
    }

}



