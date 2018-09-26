/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniexplorer;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Patrick
 */
public class FileComparer {
    
    public ArrayList<Datei> compare(Datei nextDir) {
        ArrayList<Datei> list = new ArrayList<>();
        
        File[] filearray = nextDir.listFiles();
        
        for(File x : filearray)
        {
            list.add(new Datei(x.getAbsolutePath()));
        }
        
        if(nextDir.getParentFile() != null)
        {
            Datei x = new Datei(nextDir.getParentFile().getAbsolutePath(),"..");
            x.setParent(true);
            list.add(x);
        }
        
        Collections.sort(list, new Comparator<Datei>() 
        {
            @Override
            public int compare(Datei datei, Datei datei1) {
                if(datei.isParent())
                    return -1;
                if(datei.isDirectory() && datei1.isFile())
                {
                    return -1;
                }
                if(datei.isFile() && datei1.isDirectory())
                {
                    return 1;
                }    
                if((datei.isFile() && datei1.isFile()) || (datei.isDirectory() && datei1.isDirectory()))
                    return datei.getName().compareTo(datei1.getName());
                return 0;
            }
        }
        );
        return list;
    }
}
