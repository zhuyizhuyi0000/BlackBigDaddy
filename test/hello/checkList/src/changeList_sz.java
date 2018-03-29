import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;


public class changeList_sz {
	public static void main(String args[])
	{
		StringBuffer sb =new StringBuffer();
		Workbook wb =null;
		try{
			final String fileName="E:\\first.xls";
			File file =new File(fileName);
			wb = Workbook.getWorkbook(file);//构造工作book对象
		}catch(Exception e){
			e.printStackTrace();
		}
//		if(wb ==null)
//			return null;
		Sheet sheet =wb.getSheet(0);//创建工作表对象
		
		int rows = sheet.getRows();
		int cols = sheet.getColumns();
		String[][][] tab =new String[rows][cols][];
		for(int r=0;r < rows;r++)
		{
			Cell[] rowCells = sheet.getRow(r);
			for(int c=0; c<cols;c++)
			{
				Cell cell = rowCells[c];
				 String value = cell.getContents();
//	                String[] items = value.split("，");
//	                String[] values = new int[items.length];
//	                for(int i = 0; i < items.length; i++){
//	                    values[i] = items[i];
//	                }
//	                tab[r][c] = values;
			}
		}
	
	for(int x = 0; x < tab.length; x++){
        for(int y = 0; y < tab[x].length; y++){
            for(int z = 0; z < tab[x][y].length; z++){
                System.out.println("第" + x + "行，第" + y +"列的第" + z + "个数据是：" + tab[x][y][z]);
            }
        }
    }
	}
}
		
		
//		if(sheet != null && sheet.length > 0){
//			
//		for(int i = 0;i < sheet.length; i++){//循环工作表
//			int rowNum = sheet[i].getRows();//得到当前工作表的行数
//			
//			for(int j=0;j < rowNum; j++){//循环当前所有行数
//				Cell[] cells = sheet[i].getRow(j);//得到当前行的所有单元格
//				if(cells != null && cells.length>0){
//					
//					for(int k = 0;k < cells.length; k++){//循环所有单元格
//						String cellValue =cells[k].getContents();
//						sb.append(cellValue + "\t");  //sb在最上面
//					}
//				}
//				sb.append("\r\n");
//			}
//			sb.append("\r\n");
//		}
//		}
//		wb.close();
//		return sb.toString();
//	}
		
//	public static void main(String args[])
//	{
//		try{
//			final String fileName="E:\\first.xls";
////			System.out.println(readExcel(new File(fileName)));
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//	}
//}
