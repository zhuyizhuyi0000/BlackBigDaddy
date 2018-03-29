package abctest;
import java.util.*;
import java.io.*;

import au.com.bytecode.opencsv.CSVReader;



public class readcvswahaha {
	public static void main(String args[]) throws IOException {
		File file = new File("/Users/yizhu/Downloads/diediecsv.csv");
		InputStreamReader fReader=new InputStreamReader(new FileInputStream(file),"GBK");   
        CSVReader csvReader = new CSVReader(fReader);    
        String[] strs = csvReader.readNext();    
        if(strs != null && strs.length > 0){    
            for(String str : strs)    
                if(null != str && !str.equals(""))    
                    System.out.print(str + " , ");    
            System.out.println("\n---------------"+strs[0]+" "+strs[1]);    
        }    
        List<String[]> list = csvReader.readAll();    
        for(String[] ss : list){    
            for(String s : ss)    
                if(null != s && !s.equals(""))    
                    System.out.print(s + " , ");    
            System.out.println("======"+ss[0]+" "+ss[1]);    
        }    
        csvReader.close();    
	}
}

//class ReadCSVFile {  
//    
//    private static final String ADDRESS_FILE = "/Users/yizhu/Downloads/diediecsv";  
//      
//    /** 
//     *  
//     * 读取csv中的内容 
//     *  
//     * @return 
//     * @throws IOException  
//     * @return List<String[]> 
//     * @exception 异常描述 
//     * @see 
//     */  
//    public static List<String[]> readCSVFile(File file, int startRow, String characters) throws IOException{  
//        List<String[]> strArrayList = new ArrayList<String[]>();  
//          
//        CSVReader reader = null;  
//        if (",".equalsIgnoreCase(characters)){  
//            reader = new CSVReader(new FileReader(file));  
//        } else {  
//            //带分隔符  
//            reader = new CSVReader(new FileReader(file),characters.toCharArray()[0]);  
//        }  
//          
//        String[] nextLine;  
//        int i = 1;  
//        while ((nextLine = reader.readNext()) != null) {  
////          System.out.println("Name: [" + nextLine[0] + "]\nAddress: [" + nextLine[1] + "]\nEmail: [" + nextLine[2] + "]");  
//              
//            if (i>=startRow)  
//                strArrayList.add(nextLine);  
//              
//            i++;  
//        }  
//          
//        return strArrayList;  
//    }  
//      
//    /** 
//     *  
//     * 读取csv中的内容 
//     * Map key:csvFileFirstRow csv文件，表头标题； 
//     *     key:csvFileContent  csv文件，内容(除去表头内容) 
//     *  
//     * @param file       csv文件对象 
//     * @param startRow   开始行 
//     * @param characters 分隔符 
//     * @return 
//     * @throws IOException  
//     * @return Map<String,List<String[]>> 
//     * @exception 异常描述 
//     * @see 
//     */  
//    public static Map<String, List<String[]>> readCSVFileWithMap(File file, int startRow, String characters) throws IOException{  
//        List<String[]> csvFileFirstRowArrayList = new ArrayList<String[]>();  
//        List<String[]> strArrayList = new ArrayList<String[]>();  
//          
//        CSVReader reader = null;  
//        if (",".equalsIgnoreCase(characters)){  
//            reader = new CSVReader(new FileReader(file));  
//        } else {  
//            //带分隔符  
//            reader = new CSVReader(new FileReader(file),characters.toCharArray()[0]);  
//        }  
//          
//        String[] nextLine;  
//        int i = 1;  
//        while ((nextLine = reader.readNext()) != null) {  
////          System.out.println("Name: [" + nextLine[0] + "]\nAddress: [" + nextLine[1] + "]\nEmail: [" + nextLine[2] + "]");  
//              
//            if (i>=startRow)  
//                strArrayList.add(nextLine);  
//            else   
//                csvFileFirstRowArrayList.add(nextLine);  
//              
//            i++;  
//        }  
//          
//        Map<String, List<String[]>> map = new HashMap<String, List<String[]>>();  
//        map.put("csvFileFirstRow", csvFileFirstRowArrayList);  
//        map.put("csvFileContent", strArrayList);  
//        return map;  
//    }  
//      
//      
//}  