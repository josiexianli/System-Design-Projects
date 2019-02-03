import static org.junit.jupiter.api.Assertions.*;
import java.util.Calendar;
import org.junit.jupiter.api.Test;

public class Assignment1_Tests {
	@Test
	void testRespondToGreeting() {
		Assignment1 sut = new Assignment1();
		Assignment1.Greeting greeting = Assignment1.Greeting.Hello;
		assertEquals("Hi", sut.respondToGreeting(greeting));
		greeting = Assignment1.Greeting.Greetings;
		assertEquals("Salutations", sut.respondToGreeting(greeting));
		greeting = null;
		assertEquals("Sorry, I didn’t hear you", sut.respondToGreeting(greeting));
	}
	
	@Test
	void testRespondToHowAreYou() {
		Assignment1 sut = new Assignment1();
		Assignment1.Feeling feeling = Assignment1.Feeling.Fine;
		assertEquals("I'm glad to hear that.", sut.respondToHowAreYou(feeling));
		feeling = Assignment1.Feeling.Tired;
		assertEquals("Maybe you should take a vacation.", sut.respondToHowAreYou(feeling));
		feeling = null;
		assertEquals("I’m not familiar with that condition. Is it serious?", sut.respondToHowAreYou(feeling));
	}
	
	@Test
	void testRespondToHowIsTheWeather() {
		Assignment1 sut = new Assignment1();
		
		Assignment1.SkyCondition skyCondition = Assignment1.SkyCondition.Sunny;
		int temp = 75;
		assertEquals("It’s beautiful out today warm and sunny", sut.respondToHowIsTheWeather(temp, skyCondition));
		
		temp = 65;
		assertEquals("It’s sunny out, but a little cooler than I’d like", sut.respondToHowIsTheWeather(temp, skyCondition));
		
		skyCondition = Assignment1.SkyCondition.Rainy;
		assertEquals("It’s rainy and chilly, a good day to stay inside", sut.respondToHowIsTheWeather(temp, skyCondition));
		
		temp = 75;
		assertEquals("It’s rainy, but at least it’s warm out!", sut.respondToHowIsTheWeather(temp, skyCondition));
		
		skyCondition = null;
		assertEquals("This is the whether I do not like", sut.respondToHowIsTheWeather(temp, skyCondition));
	}
	
	@Test
	void testRespondHowIsYourSpouse() {
		Assignment1 sut = new Assignment1();
		
		//past birthday + past anniversary
		Calendar birthday = Calendar.getInstance();
		birthday.set(1992, 1, 5);
		Calendar anni = Calendar.getInstance();
		anni.set(1992, 1, 5);
		
		String sexSub = "She";
        String sex = "Her";
        String doingWell = sexSub +  " is doing well, thank you. ";
		Person person = new Person("Test", Assignment1.Sex.Female, birthday, anni);
        String pastBirthday = "Didnt Test just have a birthday? Please wish " + sex + " a happy birthday for me";
        String pastAnni = "Didnt Test just have a anniversary? Happy anniversary to you both";
		assertEquals(doingWell + " " + pastBirthday + " And " + pastAnni, sut.respondHowIsYourSpouse(person));
		
		//future birthday + future anniversary
		birthday = Calendar.getInstance();
		birthday.set(1992, 1, 1);
		anni = Calendar.getInstance();
		anni.set(1992, 1, 1);
		person = new Person("Test", Assignment1.Sex.Female, birthday, anni);
		String futureBirthday = "Isn’t Test’s birthday coming up? Please wish " + sex + " a happy birthday for me";
        String futureAnni = "Isn’t your anniversary coming up? Happy anniversary";
		assertEquals(doingWell + " " + futureBirthday + " And " + futureAnni, sut.respondHowIsYourSpouse(person));
		
		//past birthday
		birthday = Calendar.getInstance();
		birthday.set(1992, 1, 5);
		anni = Calendar.getInstance();
		anni.set(1992, 10, 1);
		person = new Person("Test", Assignment1.Sex.Female, birthday, anni);
		assertEquals(doingWell + " " + pastBirthday, sut.respondHowIsYourSpouse(person));
		
		//future birthday
		birthday = Calendar.getInstance();
		birthday.set(1992, 1, 1);
		anni = Calendar.getInstance();
		anni.set(1992, 10, 1);
		person = new Person("Test", Assignment1.Sex.Female, birthday, anni);
		assertEquals(doingWell + " " + futureBirthday, sut.respondHowIsYourSpouse(person));
		
		//past anniversary
		birthday = Calendar.getInstance();
		birthday.set(1992, 10, 1);
		anni = Calendar.getInstance();
		anni.set(1992, 1, 5);
		person = new Person("Test", Assignment1.Sex.Female, birthday, anni);
		assertEquals(doingWell + " " + pastAnni, sut.respondHowIsYourSpouse(person));
		
		//future anniversary
		birthday = Calendar.getInstance();
		birthday.set(1992, 10, 1);
		anni = Calendar.getInstance();
		anni.set(1992, 1, 2);
		person = new Person("Test", Assignment1.Sex.Female, birthday, anni);
		assertEquals(doingWell + " " + futureAnni, sut.respondHowIsYourSpouse(person));
		
		
	}
}
