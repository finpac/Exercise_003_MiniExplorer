/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniexplorer;

import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author Patrick
 */
public class DateiModell extends AbstractListModel{
    ArrayList <Datei> file = new ArrayList();
    FileComparer fComparer = new FileComparer();
    
    @Override
    public int getSize() {
        return file.size();
    }

    @Override
    public Object getElementAt(int index) {
        return file.get(index);
    }
   
    public void setStart(String pathname) 
    {
        file = fComparer.compare(new Datei(pathname, ".."));
        super.fireContentsChanged(this, 0, file.size());
    }

    void changeDirectory(Datei datei) {
        System.out.println("Change");
        if(datei.isDirectory())
        {
            file = fComparer.compare(datei);
            super.fireContentsChanged(this, 0, file.size());
        }
    }
    
    
}
