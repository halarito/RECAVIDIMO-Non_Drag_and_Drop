
package Classes;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.Timer;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class ClassePrincipal extends JFrame{

    static String nome;
    static String perfil;
    JLabel lbldata = new JLabel();
    
    public ClassePrincipal(String nome, String perfil){
        
        Date dataSistema = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        lbldata.setText(formato.format(dataSistema));
        
        /*Timer timer = new Timer(1000, new hora());
        timer.start();*/
        
        this.nome = nome;
        this.perfil = perfil;
        JFrame p0 = new JFrame("RECAVIDIMO");
        p0.setBounds(10, 10, 900, 620);
        p0.setDefaultCloseOperation(EXIT_ON_CLOSE);
        p0.setLocationRelativeTo(null);
        p0.setLayout(null);
        p0.setVisible(true);
        p0.setResizable(false);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(255, 102, 255));
        p1.setBounds(1, 1, 892, 140);
        p1.setLayout(null);
        
        JLabel lbl1 = new JLabel("RECAVIDIMO");
        lbl1.setBounds(350, 30, 450, 30);
        lbl1.setHorizontalAlignment(JLabel.CENTER);
        lbl1.setForeground(Color.BLACK);
        lbl1.setFont(new Font("Sylfaen", Font.BOLD, 30));
        
        JLabel lbl2 = new JLabel("Registro de Casos de Violação Dos Direitos Da Mulher");
        lbl2.setBounds(350, 70, 450, 30);
        lbl2.setHorizontalAlignment(JLabel.CENTER);
        lbl2.setForeground(Color.BLACK);
        lbl2.setFont(new Font("Sylfaen", Font.PLAIN, 18));
        
        JLabel lbl4 = new JLabel("Data:");
        lbl4.setBounds(750, 110, 50, 30);
        lbl4.setHorizontalAlignment(JLabel.CENTER);
        lbl4.setForeground(Color.BLACK);
        
        
        lbldata.setBounds(805, 110, 70, 30);
        lbldata.setHorizontalAlignment(JLabel.CENTER);
        lbldata.setForeground(Color.BLACK);
        
        
        ImageIcon view = new ImageIcon(getClass().getResource("IMG_5856.png"));
        
        JLabel lbl3 = new JLabel(view);
        lbl3.setBounds(55, 10, 240, 120);
        lbl3.setHorizontalAlignment(JLabel.CENTER);
        lbl3.setBackground(new Color(255, 102, 255));
        
        JPanel p2 = new JPanel();
        p2.setBounds(1, 143, 892, 448);
        p2.setLayout(null);
        
        JLabel lbl5 = new JLabel("Menú");
        lbl5.setBounds(10, 15, 280, 30);
        lbl5.setHorizontalAlignment(JLabel.CENTER);
        lbl5.setFont(new Font("Tahoma", Font.BOLD, 24));
        lbl5.setForeground(Color.BLACK);
        
        JButton bt0 = new JButton("Casos");
        bt0.setBounds(10, 60, 280, 40);
        bt0.setActionCommand("chamar1");
        bt0.addActionListener(action2);
        
        
        JButton bt1 = new JButton("Usuários");
        bt1.setBounds(10, 110, 280, 40);
        bt1.setActionCommand("chamar");
        bt1.addActionListener(action1);
        
        JButton bt2 = new JButton("Leis Fundamentais");
        bt2.setBounds(10, 160, 280, 40);
        bt2.setActionCommand("leis");
        bt2.addActionListener(action4);
        
        JButton bt3 = new JButton("Relatórios");
        bt3.setBounds(10, 210, 280, 40);
        bt3.setActionCommand("rel");
        bt3.addActionListener(action5);
        
        JButton bt4 = new JButton("Sair");
        bt4.setBounds(10, 300, 280, 40);
        bt4.setActionCommand("sair");
        bt4.addActionListener(action3);
        
        JLabel lbl6 = new JLabel("Usuário:");
        lbl6.setBounds(10, 360, 70, 30);
        lbl6.setHorizontalAlignment(JLabel.CENTER);
        lbl6.setForeground(Color.BLACK);
        
        JLabel txtusu = new JLabel(this.nome);
        txtusu.setBounds(85, 360, 210, 30);
        txtusu.setHorizontalAlignment(JLabel.CENTER);
                
        JLabel lbl7 = new JLabel("Cargo:");
        lbl7.setBounds(10, 400, 70, 30);
        lbl7.setHorizontalAlignment(JLabel.CENTER);
        lbl7.setForeground(Color.BLACK);
        
        JLabel txtcar = new JLabel(this.perfil);
        txtcar.setBounds(85, 400, 210, 30);
        txtcar.setHorizontalAlignment(JLabel.CENTER);
        
        p3.setBounds(305, 15, 575, 420);
        p3.setLayout(null);
        
        p0.add(p1);
        p0.add(p2);
        
        p1.add(lbl1);
        p1.add(lbl2);
        p1.add(lbl3);
        p1.add(lbl4);
        p1.add(lbldata);
        
        p2.add(lbl5);
        p2.add(bt0);
        p2.add(bt1);
        p2.add(bt2);
        p2.add(bt3);
        p2.add(bt4);
        p2.add(lbl6);
        p2.add(lbl7);
        p2.add(p3);
        p2.add(txtusu);
        p2.add(txtcar);
    }
    
    JDesktopPane p3 = new JDesktopPane();
    ActionListener action1 = new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if("chamar".equals(e.getActionCommand())){
                
                ClasseUsuarios uso = new ClasseUsuarios();
                p3.add(uso).setVisible(true);
                
            }
            
        }
        
    };
    
    ActionListener action2 = new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if("chamar1".equals(e.getActionCommand())){
                
                ClasseCasos uso = new ClasseCasos();
                p3.add(uso).setVisible(true);
                
            }
            
        }
        
    };
    
    ActionListener action3 = new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if("sair".equals(e.getActionCommand())){
                
                System.exit(0);
                
            }
            
        }
        
    };
    
    ActionListener action4 = new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if("leis".equals(e.getActionCommand())){
                
                ClasseLeis leis = new ClasseLeis();
                p3.add(leis);
                        leis.setVisible(true);
                
            }
            
        }
        
    };
    
    ActionListener action5 = new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if("rel".equals(e.getActionCommand())){
                
                ClasseRelatórios rel = new ClasseRelatórios();
                p3.add(rel).setVisible(true);
                
            }
            
        }
        
    };
    
    public static void main(String[] args) {

        new ClassePrincipal(nome, perfil);
        
    }
    
    /*class hora implements ActionListener{
    public void actionPerformed(ActionEvent e){
        Calendar now = Calendar.getInstance();
        
    }*/

}
    

