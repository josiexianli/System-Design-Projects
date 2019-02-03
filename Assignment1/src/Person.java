import java.util.Calendar;

public class Person {
	String _firstName;
	Assignment1.Sex _sex;
    Calendar  _birthday;
    Calendar  _anniversary;

    public Person(String firstName, Assignment1.Sex sex, Calendar birthday, Calendar anniversary) {
        this._firstName = firstName;
        this._sex = sex;
        this._birthday = birthday;
        this._anniversary = anniversary;
    }
}
