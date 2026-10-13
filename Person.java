public class Person {

    protected String name;

    public Person(String name) {
        this.name = name;
        System.out.println("1. Person: " + name);
    }

    String describe() {
        return name;
    }
}

class Student extends Person {
    protected double gpa;

    Student(String name, double gpa) {
        super(name);
        this.gpa = gpa;
        System.out.println("2. Student: GPA = " + gpa);
    }
}

class Postgrad extends Student {
    private String thesis;

    Postgrad(String name, double gpa, String thesis) {
        super(name, gpa);
        this.thesis = thesis;
        System.out.println("3. Postgrad: " + thesis);
    }

    String card() {
        return super.describe() + " | GPA = " + gpa + " | " + thesis;
    }

    public static void main(String[] args) {
        Postgrad hodan = new Postgrad("Hodan", 3.8, "Somali NLP");
        System.out.println(hodan.card());
    }


}