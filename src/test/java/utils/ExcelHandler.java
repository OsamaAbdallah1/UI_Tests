package utils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelHandler {

    private Workbook workbook;

    public ExcelHandler(String excelFilePath) throws IOException {
        FileInputStream file = new FileInputStream(new File(excelFilePath));
       workbook = new XSSFWorkbook(file);
    }

    public String getCellData(int sheetIndex, int rowNum, int colNum) {
        Sheet sheet = workbook.getSheetAt(sheetIndex);
        Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(colNum);
        return cell.getStringCellValue();
    }




}
