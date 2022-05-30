package model;

public class Date {
    Integer day, month, year;
    String[] months = {"janeiro", "fevereiro", "março", "abril", "maio", "junho", "julho", "agosto", "setembro", "outubro", "novembro", "dezembro"};
    //overloading para caso não sejam passados parâmetros de inicialização
    public Date() {
        this(01,01,1970);
    }
    public Date(Integer day, Integer month, Integer year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    //EFFECTS: returns a string with the following date format: "25 de janeiro de 2021"
    public String getDateLongForm() {
        return Utils.toString(day) + " de " + months[month-1] + " de " + Utils.toString(year);
    }
    public String getDateShortForm() {
        return Utils.toString(day) + '/' + Utils.toString(month) + '/' + Utils.toString(year);
    }
    //SETTERS
    public void setDay(Integer day) {
        this.day = day;
    }
    public void setMonth(Integer month) {
        this.month = month;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
}
