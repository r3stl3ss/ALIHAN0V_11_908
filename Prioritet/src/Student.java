public class Student {
    private String name;
    private int age;
    private int course;



    public Student(String name, int age, int course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(byte course) {
        this.course = course;
    }

    public String toString() {
        return "Student " + name + ", " + course + " course, " + age + " y/o.";
    }
}
