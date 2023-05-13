package Classes;

import javax.swing.*;
import java.awt.*;
import Modulo.modulo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClasseLogin extends JFrame{

    static String nome;
    static String perfil;
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    JFrame t = new JFrame("CLASSE LOGIN");
    ImageIcon view = new ImageIcon(getClass().getResource("IMG_5856.png"));
    JLabel label1 = new JLabel(view);
    JLabel label2 = new JLabel("RECAVIDIMO");
    JSeparator separator = new JSeparator();
    JLabel label3 = new JLabel("Entrada");
    JLabel label4 = new JLabel("Nome do usuário:");
    JTextField field1 = new JTextField();
    JLabel label5 = new JLabel("Palavra passe:");
    JPasswordField field2 = new JPasswordField();
    JButton button1 = new JButton("Sair");
    JButton button2 = new JButton("Entrar");

    public ClasseLogin() {

        conexao = modulo.conector();

        t.setBounds(1, 1, 255, 440);
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        t.setLayout(null);
        t.setLocationRelativeTo(null);
        t.setVisible(true);

        label1.setBounds(1, 10, 240, 140);
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setBackground(Color.GRAY);

        label2.setBounds(10, 150, 220, 30);
        label2.setHorizontalAlignment(JLabel.CENTER);
        label2.setFont(new Font("Tahoma", Font.BOLD, 18));

        separator.setBounds(10, 185, 220, 5);

        label3.setBounds(1, 190, 220, 30);
        label3.setHorizontalAlignment(JLabel.CENTER);
        label3.setFont(new Font("Tahoma", Font.ITALIC, 14));
        label3.setForeground(Color.BLACK);

        label4.setBounds(10, 225, 100, 25);

        field1.setBounds(10, 255, 220, 30);

        label5.setBounds(10, 295, 100, 25);

        field2.setBounds(10, 325, 220, 30);

        button1.setBounds(10, 365, 80, 30);
        button1.setActionCommand("sair");
        button1.addActionListener(action1);
        
        button2.setBounds(150, 365, 80, 30);
button2.setActionCommand("entrar");
        button2.addActionListener(action2);
        
        t.add(label1);
        t.add(label2);
        t.add(label3);
        t.add(separator);
        t.add(label4);
        t.add(field1);
        t.add(label5);
        t.add(field2);
        t.add(button1);
        t.add(button2);

    }

    ActionListener action1 = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(e.getActionCommand().equals("sair")){
                
                int sair = JOptionPane.showConfirmDialog(null, "Sair?", "Confirme", JOptionPane.YES_NO_OPTION);
                   
                    if(sair == JOptionPane.YES_OPTION){
                       
                       System.exit(0);
                       
                    }
                
            }
        }
    };
    
    ActionListener action2 = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(e.getActionCommand().equals("entrar")){
                
                entrar();
                
            }
        }
    };
    
    void entrar() {

        String centrar = "select * from usuario where user = ? and pass = ?";

        try {
            System.out.println(conexao);
            pst = conexao.prepareStatement(centrar);
            
            pst.setString(1, field1.getText());
            pst.setString(2, field2.getText());

            rs = pst.executeQuery();

            if (rs.next()) {

                nome = rs.getString("nome");
                perfil = rs.getString("cargo");
                
                ClassePrincipal tela = new ClassePrincipal(nome, perfil);
                tela.setVisible(true);
                t.dispose();


            } else {
                System.out.println(conexao);
                JOptionPane.showMessageDialog(null, "Senha ou usuario incorrecto");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public static void main(String[] args) {

        new ClasseLogin();

    }

}
