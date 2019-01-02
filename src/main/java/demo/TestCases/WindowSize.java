package demo.TestCases;

import cmd.Commands;
import demo.Executor;

import java.util.ArrayList;

public class WindowSize {
    public static void main(String[] args){
        Executor events_log_exe =  new Executor(Commands.ADB_SHELL + " " + Commands.WM_SIZE); // 获取日志
        events_log_exe.exe();

        ArrayList<String> logs = events_log_exe.getResponses();
        for (String info:logs
             ) {
            System.out.println(info);
        }
    }
}
