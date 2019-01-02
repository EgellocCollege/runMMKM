package demo.TestCases;

import cmd.Commands;
import demo.Executor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PickUpTime {
    public static void main(String[] args){

//        runtimeExec();
//        System.out.println(System.getProperty("user.dir")); // 当前路径

        System.out.println("重启耗时计算开始，运行中:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));// new Date()为获取当前系统时间

        new Executor(Commands.ADB_LOGCAT_CLEAR).exe(); // 清除以前的日志
        new Executor(Commands.ADB_REBOOT).exe(); // 重新启动

        System.out.println("等待设备启动中:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));// new Date()为获取当前系统时间

        Long startTimeStramp = new Date().getTime();
        new Executor(Commands.ADB_WAIT_FOR_DEVICE).exe();// 等待设备上线
        Long endTimeStramp = new Date().getTime();
        System.out.println("等待设备实现中:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));// new Date()为获取当前系统时间
        System.out.println("重启耗时计算完成 ,数据源自计时 ，共耗时(秒)：" + (endTimeStramp-startTimeStramp)/1000.0  );// new Date()为获取当前系统时间


        Executor events_log_exe =  new Executor(Commands.ADB_LOGCAT_EVENTS); // 获取日志
        events_log_exe.exe();

        ArrayList<String> logs = events_log_exe.getResponses();

        String Setup_fitler = "boot_progress_start";
        String Launcher_fitler = "am_create_activity";

        String setupInfo = null;
        String endInfo= null;

        for (String log:logs) {
            if (log.contains(Setup_fitler)){
                setupInfo = log;
                break;
            }
        }

        for (String log:logs) {
            if (log.contains(Launcher_fitler)){
                 endInfo = log;
                break;
            }
        }

        System.out.println("Power On Info ：" + setupInfo);
        System.out.println("Launcher Info ：" + endInfo);

        if (setupInfo.isEmpty()|| setupInfo == null || endInfo.isEmpty()|| endInfo == null){
            System.out.println("获取信息失败 ！");
            return;
        }

        String year =   new SimpleDateFormat("yyyy").format(new Date()) ;

        String startTime = year + "-" + setupInfo.substring(0,18);
        String endTime   = year + "-" + endInfo.substring(0,18);

        Double time = (StringToDate(endTime) - StringToDate(startTime))/1000.0 ;

        System.out.println("重启耗时计算完成,数据源自日志数据 ：" +  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())  + "，共耗时(秒)：" + time  );// new Date()为获取当前系统时间


            // 获取日志 分析
       //   System.out.println("重启耗时：" + (endTime-startTime+1));

    }

    public static  long StringToDate(String date){
        SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        java.util.Date d = null;
        try {
            d = format.parse(date); // "2018-12-31 17:11:37.010"
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(d.getTime());
        return d.getTime();
    }

}
