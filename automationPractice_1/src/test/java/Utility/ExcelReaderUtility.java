package Utility;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pojo.User;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReaderUtility {
public static Iterator<Object[]> readExcelFile(String fileName){
    XSSFWorkbook xssfWorkbook;
    XSSFSheet xssfSheet;
    List<Object[]>  userList = new ArrayList<>();
    User userData;
    Row row;
    Cell emailAddressCell;
    Cell passwordCell;


    try {
        xssfWorkbook=new XSSFWorkbook(System.getProperty("user.dir") + "\\testData\\"+fileName);
        xssfSheet=xssfWorkbook.getSheet("LoginDataSheet");

        Iterator<Row> rowIterator = xssfSheet.iterator();
        rowIterator.next(); //skip column header
        while (rowIterator.hasNext()){
            row=rowIterator.next();
            emailAddressCell = row.getCell(0);
            passwordCell=row.getCell(1);
            userData=new User(emailAddressCell.toString(),passwordCell.toString());
            System.out.println(userData);
            userList.add(new Object[]{userData});
        }
        xssfWorkbook.close();

    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    return userList.iterator();
}
}
