package yingdg.exercise.se.stringtool;

//import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yingdg on 2017/8/14.
 */
public class 判断字符只包含数字 {
    /*
    检查一个字符串只包含数字

    第一、三种方式只能校验不含负号“-”的数字
     */
    public static boolean isStrAllNumber1(String str) {
        if (Objects.isNull(str) || str.length() == 0) {
            return false;
        }

        // jdk自带api
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }

    /*
    修改正则表达式实现校验负数，将正则表达式修改为“^-?[0-9]+”，
    修改为“-?[0-9]+.?[0-9]+”即可匹配所有数字
     */
    public static boolean isStrAllNumber2(String str) {
        // 正则表达式
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()) {
            return true;
        }

        return false;
    }

//    public static boolean isStrAllNumber3(String str) {
//        // apache commons lang包封装
//        return StringUtils.isNumeric(str);
//    }

    public static void main(String[] args) {
        System.out.println(isStrAllNumber1("-123"));
        System.out.println(isStrAllNumber2("-123"));
//        System.out.println(isStrAllNumber3("123"));
    }
}
