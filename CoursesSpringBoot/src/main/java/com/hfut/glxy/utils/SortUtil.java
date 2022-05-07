package com.hfut.glxy.utils;

import com.hfut.glxy.entity.Chapter;
import com.hfut.glxy.entity.Unit;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * ProjectName: Courses <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018/4/25 10:58 <br/>
 *
 * @author students_ManagementSchool
 * @since JDK 1.8
 */
public class SortUtil {

    public static void sortChapters(List<Chapter> chapters){

        Collections.sort(chapters,new Comparator<Chapter>() {

            @Override
            public int compare(Chapter c1, Chapter c2) {
                // TODO Auto-generated method stub
                char number1;
                char number11;
                char number12;
                char number2;
                char number21;
                char number22;
                int n1;
                int n2;

                if (c1.getNumber().length()==3){
                    number1=c1.getNumber().charAt(1);
                    n1=Integer.parseInt(String.valueOf(number1));
                }else{
                    number11=c1.getNumber().charAt(1);
                    number12=c1.getNumber().charAt(2);
                    n1=Integer.parseInt(String.valueOf(number11))*10+Integer.parseInt(String.valueOf(number12));
                }
                if (c2.getNumber().length()==3){
                    number2=c2.getNumber().charAt(1);
                    n2=Integer.parseInt(String.valueOf(number2));
                }else{
                    number21=c2.getNumber().charAt(1);
                    number22=c2.getNumber().charAt(2);
                    n2=Integer.parseInt(String.valueOf(number21))*10+Integer.parseInt(String.valueOf(number22));
                }
                return n1-n2;
            }
        });
    }

    public static void sortUnits(List<Unit> units){

        Collections.sort(units,new Comparator<Unit>() {

            @Override
            public int compare(Unit u1, Unit u2) {
                // TODO Auto-generated method stub

                char number1;
                char number11;
                char number12;
                char number2;
                char number21;
                char number22;
                int n1;
                int n2;

                if (u1.getNumber().length()==3){
                    number1=u1.getNumber().charAt(1);
                    n1=Integer.parseInt(String.valueOf(number1));
                }else{
                    number11=u1.getNumber().charAt(1);
                    number12=u1.getNumber().charAt(2);
                    n1=Integer.parseInt(String.valueOf(number11))*10+Integer.parseInt(String.valueOf(number12));
                }
                if (u2.getNumber().length()==3){
                    number2=u2.getNumber().charAt(1);
                    n2=Integer.parseInt(String.valueOf(number2));
                }else{
                    number21=u2.getNumber().charAt(1);
                    number22=u2.getNumber().charAt(2);
                    n2=Integer.parseInt(String.valueOf(number21))*10+Integer.parseInt(String.valueOf(number22));
                }
                return n1-n2;
            }
        });
    }

    public static void sortMaps(List<Map> maps){

        Collections.sort(maps,new Comparator<Map>() {

            @Override
            public int compare(Map m1, Map m2) {
                // TODO Auto-generated method stub

                Unit u1=(Unit)m1.get("unit");
                Unit u2=(Unit)m2.get("unit");

                char number1;
                char number11;
                char number12;
                char number2;
                char number21;
                char number22;
                int n1;
                int n2;

                if (u1.getNumber().length()==3){
                    number1=u1.getNumber().charAt(1);
                    n1=Integer.parseInt(String.valueOf(number1));
                }else{
                    number11=u1.getNumber().charAt(1);
                    number12=u1.getNumber().charAt(2);
                    n1=Integer.parseInt(String.valueOf(number11))*10+Integer.parseInt(String.valueOf(number12));
                }
                if (u2.getNumber().length()==3){
                    number2=u2.getNumber().charAt(1);
                    n2=Integer.parseInt(String.valueOf(number2));
                }else{
                    number21=u2.getNumber().charAt(1);
                    number22=u2.getNumber().charAt(2);
                    n2=Integer.parseInt(String.valueOf(number21))*10+Integer.parseInt(String.valueOf(number22));
                }
                return n1-n2;
            }
        });

    }

}
