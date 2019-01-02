package demo.TestCases;


import cmd.Commands;
import demo.Executor;

import java.util.ArrayList;

public class CurrentActivity {

    public static void main(String[] args) {

        Executor packages = new Executor(Commands.ADB_SHELL + Commands.SHOW_CURRENT_ACTIVITY);
        packages.exe();

        ArrayList<String> infos = packages.getResponses();

        for (String info : infos) {
                System.out.println(info);
        }

    }
}
