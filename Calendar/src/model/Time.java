package model;


public class Time {
    Integer hour;
    Integer minute;
    Integer second;
    String ampm;
    Boolean isAmPm;
    public Time (Integer hour, Integer minute, Integer second, String ampm, Boolean isAmPm) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.ampm = ampm;
        this.isAmPm = isAmPm;
    }
    public Time (Integer hour, Integer minute, Integer second, String ampm) {
        this(hour, minute, second, ampm, true);
    }
    public Time (Integer hour, Integer minute, Integer second) {
        this(hour, minute, second, (hour < 13 ? "AM" : "PM"), false);
    }
    public Time() {
        this(0,0,0);
    }
    public String getTime() {
        if (isAmPm) {
            return getAmPmTime();
        }
        return getRegularTime();
    }
    public String getTime(String ampm) {
        if (ampm.equals("ampm")) {
            return getAmPmTime();
        }
        return getRegularTime();
    }
    public String getRegularTime() {
        return Utils.toString(hour) + ':' + Utils.toString(minute) + ':' + Utils.toString(second);
    }

    public String getAmPmTime() {
        return getRegularTime() + ' ' + ampm;
    }
    //SETTERS
    public void set(Integer hour, Integer minute, Integer second, String ampm, Boolean isAmPm) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.ampm = ampm;
        this.isAmPm = isAmPm;
    }
    public void set(Integer hour, Integer minute, Integer second, String ampm) {
        set(hour, minute, second, ampm,  true);
    }
    public void set(Integer hour, Integer minute, Integer second) {

        set(hour, minute, second, ampm,  false);
    }
    public void setHour(Integer hour) {
        this.hour = hour;

    }
    public void setMinute(Integer minute) {
        this.minute = minute;
    }
    public void setSecond(Integer second) {
        this.second = second;
    }
    /*
    public void setAmPm(Boolean isAmPm) {
        if (isAmPm != this.isAmPm) {
            if (isAmPm) {
                changeToAmPm();
            }
            else {
                changeToRegular();
            }
        }
    }
    */

    public void changeToRegular() {
        isAmPm = false;
        if (ampm.equals("PM")) {
            hour += 12;
            hour = (hour == 24) ? 0 : hour;
        }

    }
    public void changeToAmPm() {
        isAmPm = true;
        if (hour > 12) {
            ampm = "PM";
            hour -= 12;
        }
        else {
            ampm = "AM";
        }
    }
}
