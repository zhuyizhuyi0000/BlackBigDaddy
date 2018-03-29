import java.io.File;
import jxl.*;

public class changeList {
	public static String readExcel(File file)
	{
		StringBuffer sb =new StringBuffer();
		Workbook wb =null;
		try{
			wb = Workbook.getWorkbook(file);//���칤��book����
		}catch(Exception e){
			e.printStackTrace();
		}
		if(wb ==null)
			return null;
		Sheet[] sheet =wb.getSheets();//�������������
		if(sheet != null && sheet.length > 0){
			
		for(int i = 0;i < sheet.length; i++){//ѭ��������
			int rowNum = sheet[i].getRows();//�õ���ǰ�����������
			
			for(int j=0;j < rowNum; j++){//ѭ����ǰ��������
				Cell[] cells = sheet[i].getRow(j);//�õ���ǰ�е����е�Ԫ��
				if(cells != null && cells.length>0){
					
					for(int k = 0;k < cells.length; k++){//ѭ�����е�Ԫ��
						String cellValue =cells[k].getContents();
						sb.append(cellValue + "\t");  //sb��������
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
