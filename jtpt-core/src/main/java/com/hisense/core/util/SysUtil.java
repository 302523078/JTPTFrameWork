package com.hisense.core.util;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by bcm on 14-2-24.
 */
public class SysUtil {
    public static String SCHEMA_PATH;
    public static final String DEFAULT_PWD = "888888";// 默认密码
    /**
     * 将日期格式化成yyyy-MM-dd格式的字符串
     * @param d - 日期
     * @return
     */
    public static String date2Str(Date d) {
        SimpleDateFormat df = new SimpleDateFormat();
        df.applyPattern("yyyy-MM-dd");
        return df.format(d);
    }
    /**
     * 将日期格式化成yyyy-MM-dd hh:mm格式的字符串
     * @param d
     * @return
     */
    public static String datetime2Str(Date d) {
        SimpleDateFormat df = new SimpleDateFormat();
        df.applyPattern("yyyy-MM-dd HH:mm:ss");
        return df.format(d);
    }

    /**
     * 将yyyy-MM-dd格式的字符串转换成日期
     * @param str
     * @return -成功返回Date，失败返回null
     */
    public static Date str2Date(String str) {
        SimpleDateFormat df = new SimpleDateFormat();
        df.applyPattern("yyyy-MM-dd");
        try {
            return df.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 将yyyy-MM-dd hh:mm格式的字符串转换成日期
     * @param str
     * @return -成功返回Date，失败返回null
     */
    public static Date str2Datetime(String str) {

        if(SysUtil.isNull(str) || str.equals("null"))
            return null;

        if(str.indexOf("T")>0){
            str=str.replaceAll("T", " ");
        }
        SimpleDateFormat df = new SimpleDateFormat();
        df.applyPattern("yyyy-MM-dd HH:mm:ss");
        try {
            return df.parse(str);
        } catch (ParseException e) {
            df.applyPattern("yyyy-MM-dd HH:mm");
            try {
                return df.parse(str);
            } catch (ParseException e1) {
                e1.printStackTrace();
                return null;
            }
        }
    }
    /**
     * 获得指定日期的后一天
     * @param specifiedDay
     * @return
     * @throws Exception
     */
    public static String getSpecifiedDayNext(String specifiedDay){
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        Date date=null;
        try {
            date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day=c.get(Calendar.DATE);
        c.set(Calendar.DATE,day+1);

        String dayBefore=new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        return dayBefore;
    }
    /**
     * 获取yyyy-MM-dd格式的当前日期字符串
     * @return
     */
    public static String todayAsStr() {
        return date2Str(new Date());
    }

    /**
     * 检查指定路径是否存在
     * @param path
     * @return
     */
    public static boolean pathExists(String path) {
        File f = new File(path);
        return f.exists();
    }

    /**
     * 获取WEB-INF目录的绝对路径
     * @return
     */
    public static String webInfPath() {
        return new File(SysUtil.class.getResource("/").getPath()).getParent().replaceAll("%20", " ");
    }

    /**
     * 获取网站根目录的绝对路径
     * @return
     */
    public static String webWebPath() {
        return new File(webInfPath()).getParent().replaceAll("%20", " ");
    }

    /**
     * 获取照片保存绝对路径
     * 照片按类名分子文件夹存放
     * @param clsName 类名
     * @return
     */
    public static String photoPath(String clsName) {
        String path = webWebPath() + "\\photo\\" + clsName;
        File f = new File(path);
        if (!f.exists())
            f.mkdirs();
        return path;
    }
    public static String photoUrl(String clsName) {
        return "photo/" + clsName;
    }

    /**
     * 获取软件更新文件目录的绝对路径
     * @return
     */
    public static String appPatchPath() {
        return webWebPath() + "\\update\\app";
    }

    /**
     * 获取数据库更新文件目录的绝对路径
     * @return
     */
    public static String dbPatchPath() {
        return webWebPath() + "\\update\\db";
    }

    public static String tempPath() {
        return webWebPath() + "\\temp";
    }

    /**
     * 复制文件
     * @return
     */
    public static void copyFile(String sourceFile, String targetFile) throws IOException {
        BufferedInputStream inBuff = null;
        BufferedOutputStream outBuff = null;
        try {
            // 新建文件输入流并对它进行缓冲
            inBuff = new BufferedInputStream(new FileInputStream(sourceFile));

            // 新建文件输出流并对它进行缓冲
            outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));

            // 缓冲数组
            byte[] b = new byte[1024 * 5];
            int len;
            while ((len = inBuff.read(b)) != -1) {
                outBuff.write(b, 0, len);
            }
            // 刷新此缓冲的输出流
            outBuff.flush();
        } finally {
            // 关闭流
            if (inBuff != null)
                inBuff.close();
            if (outBuff != null)
                outBuff.close();
        }
    }

    /**
     * 删除指定文件
     * @param filename 要删除的文件
     * @throws java.io.IOException
     */
    public static void deleteFile(String filename) throws IOException {
        File f = new File(filename);
        f.delete();
    }

    /**
     * 根据字段名生成BO对象属性名
     * @param columnName
     * @return
     */
    public static String columnName2FieldName(String columnName) {
        return columnName.toLowerCase();
    }

//    /**
//     * 生成文件CRC16校验码
//     * @param filename
//     * @return
//     */
//    public static String fileCRC16(String filename) {
//        File f = new File(filename);
//        int size = (int)f.length();
//        byte buff[] = new byte[size];
//        try {
//            FileInputStream fs = new FileInputStream(f);
//            try {
//                fs.read(buff);
//                return CRC16Util.evalCRC16(buff);
//            } finally {
//                fs.close();
//            }
//        } catch (Exception ex) {
//            return "";
//        }
//    }

    public static boolean isNullOrEmpty(String str){
        if(null==str)
            return true;
        else if("".equals(str))
            return true;
        else
            return false;
    }

    /**
     * 将二进制形式字符串转化为int类型数字 方便做“与”运算
     * @param str
     * @return
     */
    public static int binaryStringToInt(String str){
        int result = 0;
        int strLen = str.length();
        for(int i = 0 ;i < strLen;i++){
            if('0' == str.charAt(i)){
                result = result * 2;
            }else if('1' == str.charAt(i)){
                result = result * 2 + 1;
            }
        }
        return result;
    }

    /**
     * 得到一个长度为length 以 1开头后面全为0的二进制形式的字符串
     * @param length
     * @return
     */
    public static String toBinaryStingByLength(int length){
        StringBuffer resultB = new StringBuffer();
        for(int i = 0 ;i < length;i++){
            if(i == 0){
                resultB.append('1');
            }else{
                resultB.append('0');
            }
        }
        return resultB.toString();
    }

    /**
     * 判断一个字符串是否是NULL 或者是空格
     *
     * @param
     *
     * @return 如果是NULL或者是空格 则返回TRUE，否则返回FALSE
     * @action
     */
    public static boolean isNull(String str) {
        if (null == str || "".equals(str.trim())) {
            return true;
        }
        return false;
    }

    public static boolean isNotNull(String str) {
        return !isNull(str);
    }
}

