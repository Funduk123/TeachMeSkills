package homework.dto;

public abstract class Employee {

    private String firstName;
    private String surname;
    private int experience;
    protected Position position;
    
    public Employee() {
    }

    public Employee(String firstName, String surname, int experience) {
        this.firstName = firstName;
        this.surname = surname;
        this.experience = experience;
    }

    public double salary() {
        if (experience == 0) {
            return 1000 * position.coefficient;
        }
        return 1000 * position.coefficient * experience;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public double getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return "имя: " + firstName +
                ", фамилия: " + surname +
                ", стаж: " + experience +
                ", должность: " + position;
    }
}
