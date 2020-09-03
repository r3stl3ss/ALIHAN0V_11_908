import java.util.Comparator;
import java.util.PriorityQueue;

public class StudentsComparing {
    public static void main(String[] args) {
        Comparator<Student> comparatorByName = new Comparator<Student>() {
            @Override
            public int compare(Student firstSpeciman, Student secondSpeciman) {
                return firstSpeciman.getName().compareTo(secondSpeciman.getName());
            }
        };
        Comparator<Student> comparatorByAge = new Comparator<Student>() {
            @Override
            public int compare(Student firstSpeciman, Student secondSpeciman) {
                return firstSpeciman.getAge() - secondSpeciman.getAge();
            }
        };
        Comparator<Student> comparatorByCourse = new Comparator<Student>() {
            @Override
            public int compare(Student firstSpeciman, Student secondSpeciman) {
                return firstSpeciman.getCourse() - secondSpeciman.getCourse();
            }
        };
        PriorityQueue<Student> studentsPriorityQueueByAge = new PriorityQueue<Student>(comparatorByAge);
        PriorityQueue<Student> studentsPriorityQueueByCourse = new PriorityQueue<>(comparatorByCourse);
        PriorityQueue<Student> studentsPriorityQueueByName = new PriorityQueue<>(comparatorByName);
        Student[] zachislen = new Student[5];
        zachislen[0] = new Student("Mihail", 18, 1);
        zachislen[1] = new Student("Rinat", 20, 3);
        zachislen[2] = new Student("Alsu", 25, 1);
        zachislen[3] = new Student("Ruslan", 19, 4);
        zachislen[4] = new Student("Lena", 23, 2);
        for (int i = 0; i <= 4; i++) {
            studentsPriorityQueueByAge.add(zachislen[i]);
            studentsPriorityQueueByCourse.add(zachislen[i]);
            studentsPriorityQueueByName.add(zachislen[i]);
        }
        System.out.println("Сначала обработаем очередь, сформированную с приоритетом по возрасту:");
        while (!studentsPriorityQueueByAge.isEmpty()) {
            System.out.println(studentsPriorityQueueByAge.remove().toString());
        }
        System.out.println("Теперь по курсу:");
        while (!studentsPriorityQueueByCourse.isEmpty()) {
            System.out.println(studentsPriorityQueueByCourse.remove().toString());
        }
        System.out.println("И под конец - по имени:");
        while (!studentsPriorityQueueByName.isEmpty()) {
            System.out.println(studentsPriorityQueueByName.remove().toString());
        }

    }
}
