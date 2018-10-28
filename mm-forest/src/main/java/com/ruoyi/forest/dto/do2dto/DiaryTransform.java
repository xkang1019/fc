package com.ruoyi.forest.dto.do2dto;

public class DiaryTransform {

    public Integer booleanToString(boolean value){
        if(value){
            return 1;
        }
        return 0;
    }

    public boolean strToBoolean(Integer num){
        if (num==1) {
            return true;
        }
        return false;
    }

    public String arrayToString(String[] value){
        if (value!=null) {
            StringBuilder str = new StringBuilder();

            for (int a = 0; a < value.length; a++) {
                str.append(value[a]);
                if (a < value.length - 1) {
                    str.append(",");
                }
            }
            return str.toString();
        }
        return "";
    }

    public String[] stringToArray(String str){

            return str.split(",");

    }



}
