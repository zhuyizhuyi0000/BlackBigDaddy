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
			wb = Workbook.getWorkbook(file);//���칤��book����
		}catch(Exception e){
			e.printStackTrace();
		}
//		if(wb ==null)
//			return null;
		Sheet sheet =wb.getSheet(0);//�������������
		
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
//	                String[] items = value.split("��");
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
                System.out.println("��" + x + "�У���" + y +"�еĵ�" + z + "�������ǣ�" + tab[x][y][z]);
            }
        }
    }
	}
}
		
		
//		if(sheet != null && sheet.length > 0){
//			
//		for(int i = 0;i < sheet.length; i++){//ѭ��������
//			int rowNum = sheet[i].getRows();//�õ���ǰ�����������
//			
//			for(int j=0;j < rowNum; j++){//ѭ����ǰ��������
//				Cell[] cells = sheet[i].getRow(j);//�õ���ǰ�е����е�Ԫ��
//				if(cells != null && cells.length>0){
//					
//					for(int k = 0;k < cells.length; k++){//ѭ�����е�Ԫ��
//						String cellValue =cells[k].getContents();
//						sb.append(cellValue + "\t");  //sb��������
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
