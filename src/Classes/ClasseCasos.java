package Classes;

import Modulo.modulo;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;


public class ClasseCasos extends JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    JPanel p1 = new JPanel();

    JLabel lbl1 = new JLabel("Registro de Casos");
    JLabel lbl2 = new JLabel("Nome: ");
    JLabel lbl3 = new JLabel("ID: ");
    JLabel lbl4 = new JLabel("Local: ");
    JLabel lbl5 = new JLabel("Bairro: ");
    JLabel lbl6 = new JLabel("Data: ");
    JLabel lbl7 = new JLabel("Acusado: ");
    JLabel lbl8 = new JLabel("Tipo de violação: ");

    JTextField field0 = new JTextField();
    JTextField field1 = new JTextField();
    JTextField field2 = new JTextField();
    JTextField field3 = new JTextField();
    JTextField field4 = new JTextField();
    JTextField field5 = new JTextField();

    JSeparator sep = new JSeparator();
    JSeparator sep1 = new JSeparator();

    JComboBox cb1 = new JComboBox();

    JButton botao1 = new JButton("Adicionar");
    JButton botao2 = new JButton("Editar");
    JButton botao3 = new JButton("Excluir");

    public ClasseCasos() {

        conexao = modulo.conector();
        
        p1.setBackground(new Color(255, 102, 255));
        p1.setBounds(1, 1, 565, 387);
        p1.setLayout(null);

        lbl1.setBounds(1, 10, 560, 30);
        lbl1.setForeground(Color.BLACK);
        lbl1.setHorizontalAlignment(JLabel.CENTER);
        lbl1.setFont(new Font("Tahoma", Font.BOLD, 20));

        sep.setBounds(10, 50, 545, 5);

        lbl2.setBounds(20, 80, 120, 30);
        lbl2.setHorizontalAlignment(JLabel.CENTER);
        lbl2.setForeground(Color.BLACK);
        lbl2.setFont(new Font("Tahoma", Font.PLAIN, 16));

        field0.setBounds(140, 80, 290, 30);
        field0.setHorizontalAlignment(JTextField.CENTER);

        lbl3.setBounds(430, 80, 50, 30);
        lbl3.setHorizontalAlignment(JLabel.CENTER);
        lbl3.setForeground(Color.BLACK);
        lbl3.setFont(new Font("Tahoma", Font.PLAIN, 16));

        field1.setBounds(485, 80, 50, 30);
        field1.setHorizontalAlignment(JTextField.CENTER);

        lbl4.setBounds(20, 120, 120, 30);
        lbl4.setHorizontalAlignment(JLabel.CENTER);
        lbl4.setForeground(Color.BLACK);
        lbl4.setFont(new Font("Tahoma", Font.PLAIN, 16));

        field2.setBounds(140, 120, 395, 30);
        field2.setHorizontalAlignment(JTextField.CENTER);

        lbl5.setBounds(20, 160, 120, 30);
        lbl5.setHorizontalAlignment(JLabel.CENTER);
        lbl5.setForeground(Color.BLACK);
        lbl5.setFont(new Font("Tahoma", Font.PLAIN, 16));

        field3.setBounds(140, 160, 395, 30);
        field3.setHorizontalAlignment(JTextField.CENTER);

        lbl6.setBounds(20, 200, 120, 30);
        lbl6.setHorizontalAlignment(JLabel.CENTER);
        lbl6.setForeground(Color.BLACK);
        lbl6.setFont(new Font("Tahoma", Font.PLAIN, 16));

        field4.setBounds(140, 200, 395, 30);
        field4.setHorizontalAlignment(JTextField.CENTER);

        lbl7.setBounds(20, 240, 120, 30);
        lbl7.setHorizontalAlignment(JLabel.CENTER);
        lbl7.setForeground(Color.BLACK);
        lbl7.setFont(new Font("Tahoma", Font.PLAIN, 16));

        field5.setBounds(140, 240, 395, 30);
        field5.setHorizontalAlignment(JTextField.CENTER);

        lbl8.setBounds(20, 280, 150, 30);
        lbl8.setHorizontalAlignment(JLabel.CENTER);
        lbl8.setForeground(Color.BLACK);
        lbl8.setFont(new Font("Tahoma", Font.PLAIN, 16));

        cb1.setBounds(170, 280, 365, 30);

        cb1.addItem("Sexual");
        cb1.addItem("Domestica");
        cb1.addItem("Verbal");

        sep1.setBounds(10, 330, 545, 5);

        botao1.setBounds(130, 340, 100, 40);
        botao1.setActionCommand("add");
        botao1.addActionListener(action1);
        
        botao2.setBounds(240, 340, 100, 40);
        botao2.setActionCommand("act");
        botao2.addActionListener(action2);
        
        botao3.setBounds(350, 340, 100, 40);
        botao3.setActionCommand("del");
        botao3.addActionListener(action3);
        
        add(p1);

        p1.add(lbl1);
        p1.add(sep);
        p1.add(lbl2);
        p1.add(lbl3);
        p1.add(lbl4);
        p1.add(lbl5);
        p1.add(lbl6);
        p1.add(lbl8);
        p1.add(lbl7);
        p1.add(field0);
        p1.add(field1);
        p1.add(field2);
        p1.add(field3);
        p1.add(field4);
        p1.add(field5);
        p1.add(cb1);
        p1.add(botao1);
        p1.add(botao2);
        p1.add(botao3);
        p1.add(sep1);

        pack();
    }
    
    void registar(){
    
        String inserir = "insert into caso (nome, local, bairro, data, acusado, tipo_violacao) values(?, ?, ?, ?, ?, ?)";
    
        try {
            pst = conexao.prepareStatement(inserir);
            pst.setString(1, field0.getText());
            pst.setString(2, field2.getText());
            pst.setString(3, field3.getText());
            pst.setString(4, field4.getText());
            pst.setString(5, field5.getText());
            pst.setString(6, (String) cb1.getSelectedItem());
            
            
            if (field0.getText().isEmpty() || field2.getText().isEmpty() || field3.getText().isEmpty() || field4.getText().isEmpty() || field5.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios");
            }
            
            else{
                int ad = JOptionPane.showConfirmDialog(rootPane, "Adicionar caso?","Confirmar", JOptionPane.YES_NO_OPTION);
                if(ad == JOptionPane.YES_OPTION){
                    int execute = pst.executeUpdate();
                    if(execute > 0){
                    JOptionPane.showMessageDialog(null, "Caso adicionado com sucesso");
                    }
                    else{
                    JOptionPane.showMessageDialog(null, "Adição não sucedida");
                    }
                }
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    void actualizar() {
        
        //System.out.println("act");
        
        String act = "update caso set nome = ?, local = ?, bairro = ?, data = ?, acusado = ?, tipo_violacao = ? where id = ?";

        try {

                String id = field1.getText();

                pst = conexao.prepareStatement(act);

                pst.setString(1, field0.getText());
            pst.setString(2, field2.getText());
            pst.setString(3, field3.getText());
            pst.setString(4, field4.getText());
            pst.setString(5, field5.getText());
            pst.setString(6, (String)cb1.getSelectedItem());
            
            pst.setString(7, id);
            
                if (field0.getText().isEmpty() || field2.getText().isEmpty() || field3.getText().isEmpty() || field4.getText().isEmpty() || field5.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios");
            }
            
            else{
                    int per = JOptionPane.showConfirmDialog(rootPane, "Acualizar caso? ", "Confirme", JOptionPane.YES_NO_OPTION);

                    if (per == JOptionPane.YES_OPTION) {
                        int actua = pst.executeUpdate();

                        if (actua > 0) {
                            JOptionPane.showMessageDialog(rootPane, "Caso actualizado com sucesso!");
                            
                            field0.setText(null);
                            field1.setText(null);
                            field2.setText(null);
                            field3.setText(null);
                            field4.setText(null);
                            field5.setText(null);
                            
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Actualizacao nao sucedida!");

                        }
                    }

                }

           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
    
    void apagar() {

        String apag = "delete from caso where id = ?";

        try {

            if (!"".equals(field1.getText())) {

                
                String id = field1.getText();

                pst = conexao.prepareStatement(apag);

                pst.setString(1, id);

                int per = JOptionPane.showConfirmDialog(rootPane, "Eliminar caso? ", "Confirme", JOptionPane.YES_NO_OPTION);

                if (per == JOptionPane.YES_OPTION) {
                    int ap = pst.executeUpdate();

                    if (ap > 0) {
                        JOptionPane.showMessageDialog(rootPane, "Caso Eliminado com sucesso!");
                  
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Eliminação nao sucedida!");

                    }
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Insira o id do caso");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);

        }
    }

    ActionListener action1 = new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if("add".equals(e.getActionCommand())){
                
                registar();
                
            }
            
        }
        
    };
    
    ActionListener action2 = new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if("act".equals(e.getActionCommand())){
                
                actualizar();
                
            }
            
        }
        
    };
    
    ActionListener action3 = new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if("del".equals(e.getActionCommand())){
                
                apagar();
                
            }
            
        }
        
    };

    
    
}
