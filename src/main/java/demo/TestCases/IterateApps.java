package demo.TestCases;

import cmd.Commands;
import demo.Executor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

public class IterateApps {
    public static void main(String[] args){
        Executor pkg_exe =  new Executor(Commands.ADB_SHELL + " " + Commands.PM_LIST ); // 获取日志

        ArrayList<String> packages = pkg_exe.commit();



        for (String pkg:packages) {
            System.out.println(pkg);

            ArrayList<String> startupAppInfos = new  Executor(Commands.getCmd(Commands.START_APP,pkg.replace("package:",""))).commit();

            System.out.println("重启耗时计算开始，CMD :" + Commands.getCmd(Commands.START_APP,pkg));// new Date()为获取当前系统时间
            try{
                Thread.sleep(1000);
            }catch (Exception e){

            }

            for (String startupAppInfo:startupAppInfos) {
                System.out.println(startupAppInfo); // ** No activities found to run, monkey aborted.
            }
          
        }
    }
}
