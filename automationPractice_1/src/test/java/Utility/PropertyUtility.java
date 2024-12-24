package Utility;

import constants.Env;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtility {
    public static String readProperty(Env env,String propName) {
System.out.println("path"+System.getProperty("user.dir"));
File propFile=new File(System.getProperty("user.dir")+"\\src\\config\\"+env+".properties");
        FileReader fileReader= null;
        Properties prop=new Properties();
        try {
            fileReader = new FileReader(propFile);
            prop.load(fileReader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String value= prop.getProperty(propName.toUpperCase());
       return value;

    }
}
