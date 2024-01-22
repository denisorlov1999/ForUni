package module;

interface UniversityMember {
    void displayDetails();
}

class Student implements UniversityMember {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void displayDetails() {
        System.out.println("Студент: " + name);
    }
}

class Teacher implements UniversityMember {
    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    @Override
    public void displayDetails() {
        System.out.println("Викладач: " + name);
    }
}

class PetriFactory {
    public UniversityMember createUniversityMember(String memberType, String name) {
        switch (memberType.toLowerCase()) {
            case "студент":
                return new Student(name);
            case "викладач":
                return new Teacher(name);
            default:
                throw new IllegalArgumentException("Невідомий тип учасника університету: " + memberType);
        }
    }
}


public class Main {
    public static void main(String[] args) {
        PetriFactory petriFactory = new PetriFactory();

        UniversityMember student1 = petriFactory.createUniversityMember("студент", "Іван Петров");
        UniversityMember teacher1 = petriFactory.createUniversityMember("викладач", "Ольга Іванова");

        student1.displayDetails();
        teacher1.displayDetails();
    }
}
