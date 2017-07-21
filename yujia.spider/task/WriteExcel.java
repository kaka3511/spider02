package task;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;




  
public class WriteExcel {  
    private static final String EXCEL_XLS = "xls";  
    private static final String EXCEL_XLSX = "xlsx";  
  
    
    @Test
    public void fun(){
    	List<YuJia> dataList = new ArrayList<>();
    	dataList.add(new YuJia("add", "address_norm", "name", "tel"));
    	dataList.add(new YuJia("add1", "address_norm1", "name1", "tel1"));
    	dataList.add(new YuJia("add2", "address_norm2", "name2", "tel2"));
    	writeMyExcel(dataList, 7, "d:\\北京市.xls");
    }
    
    public static void writeMyExcel(List<YuJia> dataList, int cloumnCount,String finalXlsxPath){  
        OutputStream out = null;  
        try {  
            // 获取总列数  
            int columnNumCount = cloumnCount;  
            // 读取Excel文档  
            File finalXlsxFile = new File(finalXlsxPath);  
            Workbook workBook = getWorkbok(finalXlsxFile);  
            // sheet 对应一个工作页  
            Sheet sheet = workBook.getSheetAt(0);  
            /** 
             * 删除原有数据，除了属性列 
             */  
            int rowNumber = sheet.getLastRowNum();  // 第一行从0开始算  
            System.out.println("原始数据总行数，除属性列：" + rowNumber);  
            for (int i = 1; i <= rowNumber; i++) {  
                Row row = sheet.getRow(i);  
                sheet.removeRow(row);  
            }  
            // 创建文件输出流，输出电子表格：这个必须有，否则你在sheet上做的任何操作都不会有效  
            out =  new FileOutputStream(finalXlsxPath);  
            workBook.write(out);  
            /** 
             * 往Excel中写新数据 
             */  
            for (int j = 0; j < dataList.size(); j++) {  
                // 创建一行：从第二行开始，跳过属性列  
                Row row = sheet.createRow(j + 1);  
                // 得到要插入的每一条记录  
                YuJia o = dataList.get(j);  
                String name = o.getName();
                String tel = o.getTel();
                String address_norm = o.getAddress_norm();
                String addr= o.getAddr();
                for (int k = 0; k <= columnNumCount; k++) {  
                // 在一行内循环  
                Cell one = row.createCell(0);  
                one.setCellValue(name); 
                
                Cell two = row.createCell(1);  
                two.setCellValue(tel); 
                
                Cell three = row.createCell(2);  
                three.setCellValue(address_norm); 
                
                Cell four = row.createCell(3);  
                four.setCellValue(addr); 
          
                }  
            }  
            // 创建文件输出流，准备输出电子表格：这个必须有，否则你在sheet上做的任何操作都不会有效  
            out =  new FileOutputStream(finalXlsxPath);  
            workBook.write(out);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally{  
            try {  
                if(out != null){  
                    out.flush();  
                    out.close();  
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        System.out.println("数据导出成功");  
    }  
    
    
    
    public static void writeExcel(List<Map> dataList, int cloumnCount,String finalXlsxPath){  
        OutputStream out = null;  
        try {  
            // 获取总列数  
            int columnNumCount = cloumnCount;  
            // 读取Excel文档  
            File finalXlsxFile = new File(finalXlsxPath);  
            Workbook workBook = getWorkbok(finalXlsxFile);  
            // sheet 对应一个工作页  
            Sheet sheet = workBook.getSheetAt(0);  
            /** 
             * 删除原有数据，除了属性列 
             */  
            int rowNumber = sheet.getLastRowNum();  // 第一行从0开始算  
            System.out.println("原始数据总行数，除属性列：" + rowNumber);  
            for (int i = 1; i <= rowNumber; i++) {  
                Row row = sheet.getRow(i);  
                sheet.removeRow(row);  
            }  
            // 创建文件输出流，输出电子表格：这个必须有，否则你在sheet上做的任何操作都不会有效  
            out =  new FileOutputStream(finalXlsxPath);  
            workBook.write(out);  
            /** 
             * 往Excel中写新数据 
             */  
            for (int j = 0; j < dataList.size(); j++) {  
                // 创建一行：从第二行开始，跳过属性列  
                Row row = sheet.createRow(j + 1);  
                // 得到要插入的每一条记录  
                Map dataMap = dataList.get(j);  
                String name = dataMap.get("1").toString();  
                String address = dataMap.get("2").toString();  
                for (int k = 0; k <= columnNumCount; k++) {  
                // 在一行内循环  
                Cell first = row.createCell(0);  
                first.setCellValue(name); 
                
                Cell two = row.createCell(1);  
                two.setCellValue(address); 
          
                }  
            }  
            // 创建文件输出流，准备输出电子表格：这个必须有，否则你在sheet上做的任何操作都不会有效  
            out =  new FileOutputStream(finalXlsxPath);  
            workBook.write(out);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally{  
            try {  
                if(out != null){  
                    out.flush();  
                    out.close();  
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        System.out.println("数据导出成功");  
    }  
  
    /** 
     * 判断Excel的版本,获取Workbook 
     * @param in 
     * @param filename 
     * @return 
     * @throws IOException 
     */  
    public static Workbook getWorkbok(File file) throws IOException{  
        Workbook wb = null;  
        FileInputStream in = new FileInputStream(file);  
        if(file.getName().endsWith(EXCEL_XLS)){  //Excel 2003  
            wb = new HSSFWorkbook(in);  
        }else if(file.getName().endsWith(EXCEL_XLSX)){  // Excel 2007/2010  
            wb = new XSSFWorkbook(in);  
        }  
        return wb;  
    }  
}  
