package com.Godmode;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Main {

    public static void main(String[] args) {
        System.out.println(getDurationString(1500, 45));
        System.out.println(getDurationString(0));
    }

    public static String getDurationString(int minutes, int seconds) {
        if (minutes < 0 || seconds < 0 || seconds > 60) {
            return "Invalid value!";
        }
        int hour = minutes / 60;
        int remaining = minutes % 60;
        String hoursString = hour + "h";
        if (hour < 10) {
            hoursString = "0" + hoursString;
        }
        String remainingMinutesString = remaining + "m";
        if (remaining < 10) {
            remainingMinutesString = "0" + remainingMinutesString;
        }
        String secondsString = seconds + "s";
        if (seconds < 10) {
            secondsString = "0" + secondsString;
        }
        return hoursString + " " + remainingMinutesString + " " + secondsString;
    }

    public static String getDurationString(int seconds) {
        if (seconds < 0) {
            return "Invalid value!";
        }

        int minutes = seconds / 60;
        int remaining = seconds % 60;
        return getDurationString(minutes, remaining);
    }
}
