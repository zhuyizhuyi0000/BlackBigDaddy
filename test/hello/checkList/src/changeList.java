import java.io.File;
import jxl.*;

public class changeList {
	public static String readExcel(File file)
	{
		StringBuffer sb =new StringBuffer();
		Workbook wb =null;
		try{
			wb = Workbook.getWorkbook(file);//构造工作book对象
		}catch(Exception e){
			e.printStackTrace();
		}
		if(wb ==null)
			return null;
		Sheet[] sheet =wb.getSheets();//创建工作表对象
		if(sheet != null && sheet.length > 0){
			
		for(int i = 0;i < sheet.length; i++){//循环工作表
			int rowNum = sheet[i].getRows();//得到当前工作表的行数
			
			for(int j=0;j < rowNum; j++){//循环当前所有行数
				Cell[] cells = sheet[i].getRow(j);//得到当前行的所有单元格
				if(cells != null && cells.length>0){
					
					for(int k = 0;k < cells.length; k++){//循环所有单元格
						String cellValue =cells[k].getContents();
						sb.append(cellValue + "\t");  //sb在最上面
					}
				}
				sb.append("\r\n");
			}
			sb.append("\r\n");
		}
		}
		wb.close();
		return sb.toString();
	}
	
	
	
	public static void main(String args[])
	{
		try{
			final String fileName="E:\\first.xls";
			System.out.println(readExcel(new File(fileName)));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
