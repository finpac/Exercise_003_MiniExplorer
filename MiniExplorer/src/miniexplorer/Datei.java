/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniexplorer;

import java.io.File;
import java.text.SimpleDateFormat;

/**
 *
 * @author Patrick
 */
public class Datei extends File{
    private File dir;
    private String pathname;
    private String name;
    private boolean hasParent ;
    private long size = 0;
    private SimpleDateFormat sdf = new SimpleDateFormat();
    
    public Datei(String pathname, String name)
    {
        super(pathname);
        this.name = name;
    }

    Datei(String pathname) {
        super(pathname);
        name = this.getName();
        hasParent = false;
        size = this.length()/1024;
    }

    public File getDir() {
        return dir;
    }
    
    public void setParent(boolean hasParent) {
        this.hasParent = hasParent;
    }

    public boolean isParent() {
        return hasParent;
    }
    
    @Override
    public String toString() {
        if(isDirectory())
        {
            return String.format(name) ;
        }
        return String.format("%-15S  %5s Groesse: %5d KB",name, sdf.format(lastModified()), size);
    }
}
