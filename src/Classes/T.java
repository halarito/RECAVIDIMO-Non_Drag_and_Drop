
package Classes;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;

public class T {
   
    public T(){
        JFrame p0 = new JFrame();
        p0.setBounds(1, 1, 573, 418);
        p0.setDefaultCloseOperation(EXIT_ON_CLOSE);
        p0.setLocationRelativeTo(null);
        p0.setLayout(null);
        p0.setVisible(true);
        p0.setResizable(false);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(255, 102, 255));
        p1.setBounds(1, 1, 565, 387);
        p1.setLayout(null);
        
        JLabel lbl1 = new JLabel("Relatório");
        lbl1.setBounds(1, 10, 560, 30);
        lbl1.setForeground(Color.BLACK);
        lbl1.setHorizontalAlignment(JLabel.CENTER);
        lbl1.setFont(new Font("Tahoma", Font.BOLD, 20));
        
        JSeparator sep = new JSeparator();
        sep.setBounds(10, 50, 545, 5);
        
        JTable tabela = new JTable();
        tabela.setBounds(10, 65, 545, 305);
        
        p0.add(p1);
        
        p1.add(lbl1);
        p1.add(sep);
        p1.add(tabela);
        
                
    }
    
    public static void main(String[] args) {
        
        new T();
        
    }
    
}
