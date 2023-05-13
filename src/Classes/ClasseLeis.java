
package Classes;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class ClasseLeis extends JInternalFrame{

    public ClasseLeis(){
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(255, 102, 255));
        p1.setBounds(1, 1, 565, 387);
        p1.setLayout(null);
        
        JLabel lbl1 = new JLabel("Leis Fundamentais");
        lbl1.setBounds(1, 15, 560, 30);
        lbl1.setForeground(Color.BLACK);
        lbl1.setHorizontalAlignment(JLabel.CENTER);
        lbl1.setFont(new Font("Tahoma", Font.BOLD, 20));
        
        JSeparator sep = new JSeparator();
        sep.setBounds(10, 60, 545, 5);
        
        JLabel lbl2 = new JLabel("Lei nº 22/2019, \"Lei da Família\"");
        lbl2.setBounds(1, 120, 560, 30);
        lbl2.setForeground(Color.BLACK);
        lbl2.setHorizontalAlignment(JLabel.CENTER);
        lbl2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        JLabel lbl3 = new JLabel("Lei nº 19/2019, \"Lei de combate a uniões prematuras\"");
        lbl3.setBounds(1, 160, 560, 30);
        lbl3.setForeground(Color.BLACK);
        lbl3.setHorizontalAlignment(JLabel.CENTER);
        lbl3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        JLabel lbl4 = new JLabel("Texto da  lei nº 6/2008, prevenção e combate ao trafico de pessoas ");
        lbl4.setBounds(1, 200, 560, 30);
        lbl4.setForeground(Color.BLACK);
        lbl4.setHorizontalAlignment(JLabel.CENTER);
        lbl4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        JLabel lbl5 = new JLabel("Texto da lei  nº 10/2004, \"Lei da Família\"");
        lbl5.setBounds(1, 240, 560, 30);
        lbl5.setForeground(Color.BLACK);
        lbl5.setHorizontalAlignment(JLabel.CENTER);
        lbl5.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        
        add(p1);
        
        p1.add(lbl1);
        p1.add(sep);
        p1.add(lbl2);
        p1.add(lbl3);
        p1.add(lbl4);
        p1.add(lbl5);
        
        pack();
    }
    
}
