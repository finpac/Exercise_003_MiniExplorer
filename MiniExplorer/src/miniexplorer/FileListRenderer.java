/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniexplorer;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Patrick
 */
public class FileListRenderer implements ListCellRenderer<Datei>
{

    @Override
    public Component getListCellRendererComponent(JList<? extends Datei> explorerList, Datei datei, int index, boolean isSelected, boolean cellHasFocus) 
    {
        String pathname = System.getProperty("user.dir");
        JLabel label = new JLabel(datei.toString());
        label.setOpaque(true);
        if(index == 0 || datei.isDirectory())
        {
            label.setBackground(Color.gray);
            label.setForeground(Color.red);
        }
        else
        {
            label.setBackground(Color.LIGHT_GRAY);
            label.setForeground(Color.blue);
        }
        if(isSelected)
        {
           label.setBackground(Color.blue);
           label.setForeground(Color.white);
        }
        
        return label;
    }
    
}
