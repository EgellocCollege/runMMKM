package demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Executor {


    public String getCommand() {
        return command;
    }


    public void setCommand(String command) {
        this.command = command;
    }

    String command ;

    public Executor() { }

    public Executor(String command) {
        this.command = command;
    }

    ArrayList<String> responses = new ArrayList<>();


    public void exe(){
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader bis = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;

            while ((line = bis.readLine()) != null) {
                if (!line.isEmpty()){
                    responses.add(line);//line.replaceAll("package:","")
                }
            }
        } catch (IOException e) {
             System.out.println("IOException:" + e);
        }

//        for (String str:responses){
//            System.out.println(str);
//        }

    }

    public ArrayList<String> getResponses() {
        return responses;
    }


    public ArrayList<String> commit() {
        exe();
        return responses;
    }

}
