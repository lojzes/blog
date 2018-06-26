package com.lojzes;

import com.lojzes.model.Student;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<Student> students = new ArrayList<>();
        students.add(new Student(10,"测试1"));
        students.add(new Student(11,"测试2"));
        String filep = "/student-tpl.xlsx";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = dateFormat.format(new Date());
        try(InputStream is = App.class.getResourceAsStream(filep)) {
            try (OutputStream os = new FileOutputStream("d:/test_output.xlsx")) {
                Context context = new Context();
                context.putVar("exportDate", format);
                context.putVar("exportTotal", 2);
                context.putVar("exportUser", "测试员");
                context.putVar("students", students);
                JxlsHelper.getInstance().processTemplate(is, os, context);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
