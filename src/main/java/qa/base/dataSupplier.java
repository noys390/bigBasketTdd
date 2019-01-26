package qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class dataSupplier {	
	public String[][] getDataSupply(String path, String sheetName) throws Exception  {
	FileInputStream stream = new FileInputStream(path);
	  Workbook workbook = WorkbookFactory.create(stream);
	  Sheet s = workbook.getSheet(sheetName);
	  int rowcount = s.getLastRowNum();
	  int cellcount = s.getRow(0).getLastCellNum();
	  String data[][] = new String[rowcount][cellcount];
	  for (int i = 1; i <= rowcount; i++) {
		  
	     for (int j = 0; j < cellcount; j++) {
	       Cell c = s.getRow(i).getCell(j);
	        try {
	             if (c.getCellType() == c.CELL_TYPE_STRING) {
	              data[i - 1][j] = c.getStringCellValue();
	                    } 
	            else
	            {
	              data[i - 1][j] = String.valueOf(c.getNumericCellValue());
	               }
	        } catch (Exception e) {}
	   }
	  }
	  return data;
	 }
 
		
}
