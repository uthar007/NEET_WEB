package utils;

public class Params {
    public static void main(String[] args){
        ExcelUtils excelUtils=new ExcelUtils(Constants.Path_TestData);
        String Testname=excelUtils.getCellData("Test","Physics",2);
        System.out.println(Testname);
    }
}
