package demo;


import cmd.Commands;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class main {

    public static void main(String[] args){

//        runtimeExec();
//        System.out.println(System.getProperty("user.dir")); // 当前路径

         new Executor(Commands.ScreenCap).exe();

         new Executor(Commands.PULL).exe();

        new Executor(Commands.ADB_REBOOT).exe();


        SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        java.util.Date d = null;
        try {
            d = format.parse("2018-12-31 17:11:37.010");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(d.getTime());
//        java.sql.Time time = new java.sql.Time(d.getTime());
//        return time.valueOf(d);



        Executor appStartor = new Executor();



//        System.out.println("MainActivity.runCommand");
//        Process adbProcess = null;
//        DataOutputStream out;
//        BufferedReader bis;
//        String line = null;
//        System.out.println(System.getProperty("user.dir"));
//        try {
//            adbProcess = Runtime.getRuntime().exec("echo %cd%");
////            out = new DataOutputStream(adbProcess.getOutputStream());
//            bis = new BufferedReader(new InputStreamReader(adbProcess.getInputStream()));
//
////            out.write("env | grep USER\r\n".getBytes());
////            out.flush();
//            while ((line = bis.readLine()) != null) {
//                if (!line.isEmpty()){
//                    System.out.println(line);
//                }
//            }
//
//            while ((line = bis.readLine()) != null) {
//                if (!line.isEmpty()){
//                    System.out.println(line);
//                }
//            }
//
//        } catch (IOException e) {
//            System.out.println("MainActivity.runCommand,e=" + e);
//        }




    }

    public static boolean runtimeExec(String cmd, File path) {
        Process proc;
        try {
            StringBuilder builder=new StringBuilder();
            builder.append("cmd /c ");
            builder.append(path);
            builder.append(File.separator);
            builder.append(cmd);
            Runtime rt = Runtime.getRuntime();
            proc = rt.exec(builder.toString());
            InputStream  stderr = proc.getErrorStream();
            InputStreamReader isr = new InputStreamReader(stderr);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            int exitVal = proc.waitFor();
            return exitVal == 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean runtimeExec() {
        Process proc;
        try {

            System.out.println(System.getProperty("user.dir")); // 当前路径
            Runtime rt = Runtime.getRuntime();
            proc = rt.exec("cmd  cd /d d://");
            InputStream  stderr = proc.getErrorStream();
            System.out.println(System.getProperty("user.dir")); // 当前路径
            InputStreamReader isr = new InputStreamReader(stderr);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            System.out.println(System.getProperty("user.dir")); // 当前路径

            int exitVal = proc.waitFor();
            return exitVal == 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



}
