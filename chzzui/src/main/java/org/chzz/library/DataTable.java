package org.chzz.library;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * ============================================================
 * 版权 ：深圳市医友智能技术有限公司 版权所有 (c)   2016/6/8
 * 作者:copy   xiaoxinxing12@qq.com
 * 版本 ：1.0
 * 创建日期 ： 2016/6/8--9:31
 * 描述 ：
 * 修订历史 ：
 * ============================================================
 **/
public class DataTable {
    /**
     * @param args
     */
    public static void main(String[] args) {

        // System.out.println(getBeanFilesList("com.pdt.bean.Dictionary"));

        System.out.println(genCreateTableSql("org.chzz.library.Bean"));

        //  System.out.println(genInsertSql("com.pdt.bean.Dictionary"));
    }

    public static String getBeanName(String bean) {
        try {
            Class clz = Class.forName(bean);
            String clzStr = clz.toString();
            //得到类名
            String beanName = clzStr.substring(clzStr.lastIndexOf(".") + 1).toLowerCase();
            return beanName;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static List<String> getBeanPropertyList(String bean) {
        try {
            Class clz = Class.forName(bean);
            Field[] strs = clz.getDeclaredFields();
            List<String> propertyList = new ArrayList<String>();
            for (int i = 0; i < strs.length; i++) {
                String protype = strs[i].getType().toString();

                switch (protype.toString()) {
                    case "class java.lang.String":
                        propertyList.add(protype.substring(protype.lastIndexOf(".") + 1) + "`" + strs[i].getName());
                        break;
                    case "interface java.util.List":
                        protype = strs[i].toString();
                        protype = protype.replace("private java.util.List", "");
                        protype = protype.substring(0, protype.lastIndexOf(".")) + "$" + toUpperCaseFirstOne(protype.substring(protype.lastIndexOf(".") + 1, protype.length()) + "Entity");


                            System.out.println(genCreateTableSql(protype.trim()));



                        break;
                    default:
                        protype = protype.replace("class ", "");
                        System.out.println(genCreateTableSql(protype));
                        break;
                }

            }
            return propertyList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static String getBeanFilesList(String bean) {
        try {
            Class clz = Class.forName(bean);
            Field[] strs = clz.getDeclaredFields();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < strs.length; i++) {
                String protype = strs[i].getType().toString();
                if (!strs[i].getName().equals("tableName") && !strs[i].getType().equals("List")) {
                    sb.append(strs[i].getName() + ",");
                }
            }
            sb.deleteCharAt(sb.toString().lastIndexOf(","));
            return sb.toString();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 生成建表語句
     *
     * @param bean
     * @return
     */
    public static String genCreateTableSql(String bean) {
        if (null == bean || "".equals(bean))
            return "";
        List<String> beanPropertyList = getBeanPropertyList(bean);
        StringBuffer sb = new StringBuffer("create table wnk_pdt_" + getBeanName(bean) + "(\n");
        for (String string : beanPropertyList) {
            String[] propertys = string.split("`");
            if (!propertys[1].equals("tableName") && !propertys[1].equals("param") && !propertys[0].equals("List")) {
                if (propertys[1].equals("id")) {
                    sb.append("   id bigint primary key auto_increment,\n");
                } else {
                    if (propertys[0].equals("int")) {
                        sb.append("   " + propertys[1] + " int default 0 comment '',\n");
                    } else if (propertys[0].equals("String")) {
                        sb.append("   " + propertys[1] + " varchar(2000) default '' comment '',\n");
                    } else if (propertys[0].equals("double")) {
                        sb.append("   " + propertys[1] + " double(10,2) default 0.0 comment '',\n");
                    } else if (propertys[0].equals("Date")) {
                        sb.append("   " + propertys[1] + " datetime comment '',\n");
                    }
                }
            }
        }
        sb.append(")");
        if (sb.lastIndexOf(",") != -1)
            sb.deleteCharAt(sb.lastIndexOf(","));
        return sb.toString();
    }

    /**
     * 生成查询语句
     *
     * @param bean
     * @return
     */
    public static String genSelectAllSql(String bean) {
        String filesList = getBeanFilesList(bean);
        return "select \n " + filesList + " \n from \n wnk_pdt_" + getBeanName(bean) + "";
    }

    /**
     * 生成插入语句
     *
     * @param
     * @return
     */
//    public static String genInsertSql(String bean){
//        String filesList =  getBeanFilesList(bean);
//        int fl = DataUtil.getCountSonStr(filesList,",")+1;
//        String wenhao = "";
//        for (int i = 0; i < fl; i++) {
//            if(i==fl-1){
//                wenhao = wenhao+"?";
//            }else{
//                wenhao = wenhao+"?,";
//            }
//        }
//        return "insert into wnk_pdt_"+getBeanName(bean)+"("+filesList+") values("+wenhao+")";
//    }
    public static String toUpperCaseFirstOne(String s) {
        if (Character.isUpperCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
    }
}
