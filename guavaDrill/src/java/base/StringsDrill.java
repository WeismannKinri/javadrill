package base;

import com.google.common.base.Strings;

public class StringsDrill {
    public static void main(String[] args) {
        //repeat the given string x times.
        System.out.println(Strings.repeat("kincolle",2));
        //add identified char to fulfill the string user give
        System.out.println(Strings.padEnd("kincolle",11,'*'));
        System.out.println(Strings.padStart("kincolle",11,'*'));

        System.out.println(Strings.isNullOrEmpty(""));//return true
        System.out.println(Strings.nullToEmpty(null));//return ""
        System.out.println(Strings.nullToEmpty("kincolle`"));//return "kincolle"
        System.out.println(Strings.emptyToNull(""));//return null
        System.out.println(Strings.emptyToNull("kincolle"));//return "kincolle"

        System.out.println(Strings.commonPrefix("aaab", "aac"));//"aa" or return ""
        System.out.println(Strings.commonSuffix("aaac", "aac"));//"aac" or return ""
    }
}
