package base;

import com.google.common.base.CharMatcher;

public class CharMatcherDrill {
    public static void main(String args[]){
        CharMatcherDrill tester = new CharMatcherDrill();
        tester.testCharMatcher();
    }

    private void testCharMatcher(){
        // only the digits will be ran
        System.out.println(CharMatcher.digit().replaceFrom("kincolle213","$"));
        System.out.println(CharMatcher.digit().retainFrom("kincolle123"));
        System.out.println(CharMatcher.javaLowerCase().replaceFrom("Kincle123","*"));

        System.out.println(CharMatcher.whitespace().trimAndCollapseFrom("     kincolle     ASAHINA ", ' '));
        // trim whitespace at ends, and replace/collapse whitespace into single spaces
        System.out.println(CharMatcher.javaDigit().replaceFrom("kincolle123", "*")); // star out all digits
        System.out.println(CharMatcher.javaDigit().or(CharMatcher.javaLowerCase()).retainFrom("Kincolle123"));
        // eliminate all characters that aren't digits or lowercase
//        System.out.println(CharMatcher.);
    }
}
