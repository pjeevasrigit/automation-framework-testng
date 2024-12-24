package dataProviders;

import Utility.ExcelReaderUtility;
import Utility.csvReaderUtility;
import com.google.gson.Gson;
import org.testng.annotations.DataProvider;
import pojo.TestData;
import pojo.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginDataProvider {
    @DataProvider(name = "LoginTestDataProvider")
    public Iterator<Object[]> LoginDataProvider(){
        Gson gson=new Gson();
        File testDatafile=new File(System.getProperty("user.dir") + "\\testData\\loginData.json");
        System.out.println("test file path");
        TestData testData;
        try {
            FileReader fileReader=new FileReader(testDatafile);
            testData=gson.fromJson(fileReader, TestData.class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        List<Object[]> dataToReturn = new ArrayList<Object[]>();
         for(User user:testData.getData()){
             dataToReturn.add(new Object[] {user} );
         }
         return dataToReturn.iterator();
    }

    @DataProvider(name = "LoginTestCSVDataProvider")
        public Iterator<Object[]> loginCSVDataProvider(){
        return csvReaderUtility.readCSVFile("loginData.csv");

    }

    @DataProvider(name = "LoginTestExcelDataProvider")
    public Iterator<Object[]> loginExcelDataProvider(){
        return ExcelReaderUtility.readExcelFile("loginData.xlsx");

    }


}
