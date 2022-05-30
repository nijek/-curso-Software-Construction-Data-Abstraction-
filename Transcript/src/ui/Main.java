package ui;

import Model.Transcript;

public class Main {
    public static void main(String[] args){
        Transcript t1 = new Transcript("Jane Doe", 7830);
        Transcript t2 = new Transcript("Ada Lovelace", 8853);
        Transcript t3 = new Transcript("Maria Fernanda Azolin", 1225);

        t1.addGrade("CPSC-210", 3.5);
        t1.addGrade("ENGL-201", 4.0);
        t1.addGrade("CPSC-110", 3.1);

        t2.addGrade("CPSC-210", 4.5);
        t2.addGrade("ENGL-201", 4.1);
        t2.addGrade("CPSC-110", 3.9);

        t3.addGrade("CPSC-210", 4.7);
        t3.addGrade("ENGL-201", 4.9);
        t3.addGrade("CPSC-110", 3.0);
        
        System.out.printf("%s: \n", t1.getStudentName());
        System.out.printf("%s: \n", t2.getStudentName());
        System.out.printf("%s: \n", t3.getStudentName());

        t1.printTranscript();
        t2.printTranscript();
        t3.printTranscript();

        System.out.println(t1.getStudentGPA());
        System.out.println(t2.getStudentGPA());
        System.out.println(t3.getStudentGPA());

    }
}
