/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniexplorer;

import java.io.File;

/**
 *
 * @author Patrick
 */
public class Datei extends File{
    private File dir;
    private String pathname;
    private String name;
    private String attributes = " ";
    private boolean hasParent ;
    private long size = 0;
    
    public Datei(String pathname, String name)
    {
        super(pathname);
        this.name = name;
    }

    Datei(String pathname) {
        super(pathname);
        name = this.getName();
        hasParent = false;
        if(this.isFile())
        {
            if(this.canRead())
                attributes += " R ";
            if(this.canWrite())
                attributes += " W ";
            if(this.canExecute())
                attributes += " E ";
            if(this.isHidden())
                attributes += " H ";
        }
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
}
