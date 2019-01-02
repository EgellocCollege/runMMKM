package cmd;

public class Commands {

    public static final String  CMD_LINE_PATH = "echo %cd%";
    public static final String  ADB_SHELL = "adb shell";
    public static final String  ADB_REBOOT = "adb reboot";
    public static final String  ADB_DEVICES = "adb devices";
    public static final String  ADB_GET_STATE = "adb get-state";
    public static final String  ADB_WAIT_FOR_DEVICE = "adb wait-for-device";
    public static final String  PM_LIST = "pm list package";

    public static final String  ADB_LOGCAT_CLEAR = "adb logcat -c -b main -b events -b radio -b system";

    public static final String  ADB_LOGCAT_EVENTS = "adb logcat -d -b events";



    public static final String  WM_SIZE = "wm size";

    public static final String  SHOW_CURRENT_ACTIVITY = " dumpsys window windows | grep mCurrentFocus";

    public static final String  START_CAMERA= "adb shell am start -n com.android.camera/.Camera";

    public static final String  START_APP = "adb shell monkey -p %s -c android.intent.category.LAUNCHER 1";

    public static final String  START_WEB = "adb shell am start -a android.intent.action.VIEW -d https://www.huawei.com";

    public static final String  CALL_100000 = "adb shell am start -a android.intent.action.CALL -d tel:100000";

    public static final String  INPUT_KEYEVENT_HOME = "adb shell input keyevent 3";

    public static final String  ScreenCap = "adb shell screencap -p /sdcard/screen.png";
    public static final String  PULL = "adb pull /sdcard/screen.png sc.png";


    public static final String  CHECK_USER = "env | grep USER";

    public static String getCmd(String basicCmd,String arg){
       return  String.format(basicCmd,arg);
    }

}
