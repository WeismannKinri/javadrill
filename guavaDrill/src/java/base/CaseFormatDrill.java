package base;

import com.google.common.base.CaseFormat;

public class CaseFormatDrill {
    public static void main(String args[]){
        CaseFormatDrill tester = new CaseFormatDrill();
        tester.testCaseFormat();
    }

    private void testCaseFormat(){

        //from LOWER_HYPHEN to LOWER_CAMEL
        System.out.println("from test-data to " + CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL, "test-data"));
        //from LOWER_UNDERSCORE to LOWER_CAMEL
        System.out.println("from test_data to " + CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "test_data"));
        //from UPPER_UNDERSCORE to UPPER_CAMEL
        System.out.println("from test_data to " + CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, "test_data"));

        //from LOWER_CAMEL to LOWER_UNDERSCORE
        System.out.println("from testdata to " + CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, "testdata"));
        //from LOWER_CAMEL to LOWER_UNDERSCORE
        System.out.println("from TestData to " + CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, "TestData"));
        //from LOWER_CAMEL to LOWER_HYPHEN
        System.out.println("from testdata to " + CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_HYPHEN, "testData"));

        System.out.println(CaseFormat.valueOf(CaseFormat.UPPER_UNDERSCORE.toString()));


    }
}
