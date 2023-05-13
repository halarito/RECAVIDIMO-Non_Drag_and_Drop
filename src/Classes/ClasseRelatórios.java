
package Classes;

import Modulo.modulo;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;


public class ClasseRelatórios extends JInternalFrame{
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    JTable tabela = new JTable();
    
    public ClasseRelatórios(){
        
        conexao = modulo.conector();
        
        preencher();
        
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
        
        
        tabela.setBounds(10, 65, 545, 305);
        
        add(p1);
        
        p1.add(lbl1);
        p1.add(sep);
        p1.add(tabela);
        
        pack();
    }

    private void preencher() {
        
        String sql = "Select * from caso";

        try {
            pst = conexao.prepareStatement(sql);

            rs = pst.executeQuery();

            tabela.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }

    }
    
}
