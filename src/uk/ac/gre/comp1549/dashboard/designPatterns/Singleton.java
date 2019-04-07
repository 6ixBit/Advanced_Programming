package uk.ac.gre.comp1549.dashboard.designPatterns;

import java.io.File;
import java.io.IOException;
import org.xml.sax.SAXException;

public class Singleton { //Singleton design pattern class

    private static Singleton instance = null;

    private Singleton() { //Private constructor
    }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

      /**
     * convertToFileURL() is a utility method just used if DashboardDemoMain is
     * run in standalone mode to test the class
     *
     * @param filename - name of the xml file
     * @return filename in URL format e.g "file:///c:/files/file.xml"
     */
    public static String convertToFileURL(String filename) { //Colud use this for Singleton pattern
        String path = new File(filename).getAbsolutePath();
        if (File.separatorChar != '/') {
            path = path.replace(File.separatorChar, '/');
        }

        if (!path.startsWith("/")) {
            path = "/" + path;
        }
        return "file:" + path;
    }
    //Initially tried using the Singleton Des pattern to process Script file method but controlling all that data was hectic when I implemented it
    //As the XML reader object had ot be the exact same one being used in the DashboardEvent class otherwise we'll get problems during run time
    
}
