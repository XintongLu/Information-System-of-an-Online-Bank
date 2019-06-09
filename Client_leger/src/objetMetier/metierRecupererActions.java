package objetMetier;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import beans.Actions;
public class metierRecupererActions
{
    private String header[];
    private Object body[][];
	private ArrayList<Actions> array = new ArrayList<Actions>();
    private String lastFileName = null;
    private String lastSheetName = null;

    public metierRecupererActions()
    {
        try
        {
            this.setLastFileName("/Program Files/eclipse/eclipse-workspace/worskpace_advancedJava/Projet S8/WebContent/WEB-INF/lib/cac.xlsx");
            this.setLastSheetName("Feuil1");
            FileInputStream file = new FileInputStream("/Program Files/eclipse/eclipse-workspace/worskpace_advancedJava/Projet S8/WebContent/WEB-INF/lib/cac.xlsx");
            Workbook workbook = WorkbookFactory.create(file);
            final Sheet sheet = workbook.getSheet("Feuil1");
            int top = sheet.getFirstRowNum();
            int bottom = sheet.getLastRowNum();
            Row line = sheet.getRow(top);
            int start = line.getFirstCellNum();
            int end = line.getLastCellNum();    
            int length = end - start;
            while(length == 0)
            {
                top++;
                line = sheet.getRow(top);
                start = line.getFirstCellNum();
                end = line.getLastCellNum();    
                length = end - start;
            }
            int hight = bottom - top;
            System.out.println("hight : " + hight);
            this.header =  new String[length];
            this.body = new Object[hight][length];
			/*
			 * for (int i = 0; i < length; i++) { header[i] = line.getCell(start +
			 * i).getStringCellValue(); }
			 * 
			 * 
			 * for (int index = 0; index < hight; index++) { line = sheet.getRow(index + top
			 * + 1); for (int i = 0; i < length; i++) { Cell cellule = line.getCell(start +
			 * i); switch (cellule.getCellType()) { case STRING : this.body[index][i] =
			 * cellule.getStringCellValue(); break; case BOOLEAN : this.body[index][i] =
			 * cellule.getBooleanCellValue(); break; default : this.body[index][i] =
			 * cellule.getNumericCellValue(); } } }
			 */ 
        	for (int j = 0; j < 40; j++) {
        		System.out.println("top : " + top);
				line = sheet.getRow(j + top+28 );
				String nom = line.getCell(0).getStringCellValue();
				System.out.println(nom);

				float ouverture = (float) line.getCell(1).getNumericCellValue();
				float haut = (float) line.getCell(2).getNumericCellValue();
				float bas = (float) line.getCell(3).getNumericCellValue();
				float volume = (float) line.getCell(4).getNumericCellValue();
				float dernier = (float) line.getCell(6).getNumericCellValue();

				Actions action = new Actions(nom, ouverture, haut, bas, volume, dernier);
				System.out.println(nom);
				System.out.println(dernier);
				this.array.add(action);

			}
            workbook.close();
            file.close();
        }catch (IOException e) {
			e.printStackTrace();
		}
      
    }
    
	/*
	 * public void saveAs(String fileName, String sheetName) { try { if
	 * (this.getLastFileName().compareTo(fileName) != 0)
	 * this.setLastFileName(fileName); if (this.getLastSheetName() != sheetName)
	 * this.setLastSheetName(sheetName); Workbook workbook = new HSSFWorkbook();
	 * Sheet sheet = workbook.createSheet(sheetName); Row row = sheet.createRow(0);
	 * for(int i = 0; i < this.getHeader().length; i++) {
	 * row.createCell(i).setCellValue(this.getHeader()[i]); }
	 * 
	 * for (int index = 0; index < this.getBody().length; index++) { row =
	 * sheet.createRow(index + 1); for (int i = 0; i < this.getBody()[index].length;
	 * i++) { String valeur = String.valueOf(this.getBody()[index][i]);
	 * row.createCell(i).setCellValue(valeur); } } FileOutputStream fileOut = new
	 * FileOutputStream(fileName); workbook.write(fileOut); workbook.close();
	 * fileOut.close(); } catch (IOException e) { e.printStackTrace(); } }
	 * 
	 * public void save() { this.saveAs(this.getLastFileName(),
	 * this.getLastSheetName()); }
	 */
    public String[] getHeader() 
    {
        return this.header;
    }
    
    public Object[][] getBody() 
    {
        return this.body;
    }
    public ArrayList<Actions> actions() {
		return this.array;
	}

    public String getLastFileName() {
        return this.lastFileName;
    }

    private void setLastFileName(String lastFileName) {
        this.lastFileName = lastFileName;
    }

    public String getLastSheetName() {
        return this.lastSheetName;
    }

    private void setLastSheetName(String lastSheetName) {
        this.lastSheetName = lastSheetName;
    }
}