import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

    public static void main(String[] args){


        String year =   new SimpleDateFormat("yyyy").format(new Date()) ;

        String info = "12-31 05:03:35.620   253   253 I auditd  : type=1404 audit(0.0:3): enforcing=1 old_enforcing=0 auid=4294967295 ses=4294967295";
        System.out.println( year + "-" + info.substring(0,18));

        System.out.println(20811/1000.0);


    }


}
