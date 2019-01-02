package demo;

import cmd.Commands;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class run {
    public static void main(String[] main){


        System.out.println("MainActivity.runCommand");
        Process adbProcess = null;
        DataOutputStream out;
        BufferedReader bis;
        String line = null;

        try {
            adbProcess = Runtime.getRuntime().exec(Commands.ADB_SHELL);
            out = new DataOutputStream(adbProcess.getOutputStream());
            bis = new BufferedReader(new InputStreamReader(adbProcess.getInputStream()));

            out.write("env | grep USER\r\n".getBytes());
            out.flush();
            while ((line = bis.readLine()) != null) {
                if (!line.isEmpty()){
                    System.out.println(line);
                }
            }

            while ((line = bis.readLine()) != null) {
                if (!line.isEmpty()){
                    System.out.println(line);
                }
            }

        } catch (IOException e) {
            System.out.println("MainActivity.runCommand,e=" + e);
        }

//        DataOutputStream out = new DataOutputStream(adbProcess.getOutputStream());
//        BufferedReader bis = new BufferedReader(new InputStreamReader(adbProcess.getInputStream()));
//        String line = null;

//        try {
//            out.write("env | grep USER\r\n".getBytes());
//            out.flush();
//            while ((line = bis.readLine()) != null) {
//                if (!line.isEmpty()){
//                    System.out.println(line);
//                }
//            }
//        } catch (IOException e) {
//            System.out.println("MainActivity.runCommand,e=" + e);
//        }


        System.out.println("MainActivity.runCommand,e=");
    }
}


//        System.out.println("Hello");
//        Observable.just("Helloword")
//                .subscribe(new Consumer<String>() {
//                    @Override
//                    public void accept(String s) throws Exception {
//                        System.out.println(s);
//                    }
//                });