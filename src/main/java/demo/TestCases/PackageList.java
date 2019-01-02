package demo.TestCases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PackageList {


    String command ;


    ArrayList<String> responses = new ArrayList<>();


    public void exe(){
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader bis = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;

            while ((line = bis.readLine()) != null) {
                if (!line.isEmpty()){
                    responses.add(line.replaceAll("package:",""));
                }
            }
        } catch (IOException e) {
            // System.out.println("MainActivity.runCommand,e=" + e);
        }

        for (String str:responses){
            System.out.println(str);
        }

    }

}
