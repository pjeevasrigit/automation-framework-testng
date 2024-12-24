package Utility;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import pojo.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class csvReaderUtility {
    public static Iterator<Object[]> readCSVFile(String fileName) {

        // File csvFilePath=new File(System.getProperty("user.dir") + "\\testData\\loginData.csv");
        File csvFile=new File(System.getProperty("user.dir") + "\\testData\\"+fileName);
        FileReader fileReader=null;
        CSVReader csvReader;
        String[] line ;
        List<Object[]> userDataList = new ArrayList<>();

        try {
             fileReader=new FileReader(csvFile);
             csvReader=new CSVReader(fileReader);
             csvReader.readNext();

            while ((line = csvReader.readNext()) != null) {
                User userData = new User(line[0], line[1]); // Assuming two columns: username and password
                userDataList.add(new Object[]{userData}); // Wrap User in Object[]
            }
           



        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }

        return userDataList.iterator();
    }
}
