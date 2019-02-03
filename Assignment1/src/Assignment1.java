import java.util.Calendar;

public class Assignment1 {
    public static void main(String[] args) {
    }

    public String respondToGreeting (Greeting greeting) {
        if (greeting == Greeting.Hello) {
            return "Hi";
        } else if (greeting == Greeting.Greetings) {
            return "Salutations";
        } else {
            return "Sorry, I didn’t hear you";
        }
    }

    public String respondToHowAreYou (Feeling feeling) {
        if (feeling == Feeling.Fine) {
            return "I'm glad to hear that.";
        } else if (feeling == Feeling.Tired) {
            return "Maybe you should take a vacation.";
        } else {
            return "I’m not familiar with that condition. Is it serious?";
        }
    }

    public String respondToHowIsTheWeather(int temp, SkyCondition skyCondition) {
        if (skyCondition == SkyCondition.Sunny && temp > 70) {
            return "It’s beautiful out today warm and sunny";
        } else if (skyCondition == SkyCondition.Sunny && temp < 70) {
            return "It’s sunny out, but a little cooler than I’d like";
        } else if (skyCondition == SkyCondition.Rainy && temp > 70){
            return "It’s rainy, but at least it’s warm out!";
        }else if(skyCondition == SkyCondition.Rainy && temp < 70){
            return "It’s rainy and chilly, a good day to stay inside";
        }
        return "This is the whether I do not like";
    }


    public String respondHowIsYourSpouse(Person spouse) {
        String sexSub = spouse._sex == Sex.Male ? "He" : "She";
        String sex = spouse._sex == Sex.Male ? "His" : "Her";
        String doingWell = sexSub +  " is doing well, thank you. ";
        
        Calendar now = Calendar.getInstance();
        Calendar birthday = spouse._birthday;
        Calendar anni = spouse._anniversary;
        
        birthday.set(0, now.get(0));
        anni.set(0, now.get(0));
        
        int birthdayDiff = birthday.get(Calendar.DAY_OF_YEAR) - now.get(Calendar.DAY_OF_YEAR);
        int anniDiff = anni.get(Calendar.DAY_OF_YEAR) - now.get(Calendar.DAY_OF_YEAR);
        
        String futureBirthday = "Isn’t " + spouse._firstName + "’s birthday coming up? Please wish " + sex + " a happy birthday for me";
        String futureAnni = "Isn’t your anniversary coming up? Happy anniversary";
        String pastBirthday = "Didnt " + spouse._firstName + " just have a birthday? Please wish " + sex + " a happy birthday for me";
        String pastAnni = "Didnt " + spouse._firstName + " just have a anniversary? Happy anniversary to you both";
        
        if (birthdayDiff >= 0 && birthdayDiff <= 14 && anniDiff >= 0 && anniDiff <= 14) {
            return doingWell + " " + pastBirthday + " And " + pastAnni;
        } else if (birthdayDiff < 0 && birthdayDiff >= -14 && anniDiff < 0 && anniDiff >= -14) {
            return doingWell + " " + futureBirthday + " And " + futureAnni;
        } else if (birthdayDiff >= 0 && birthdayDiff <= 14) {
            return doingWell + " " + pastBirthday;
        } else if(birthdayDiff < 0 && birthdayDiff >= -14){
            return doingWell + " " + futureBirthday;
        } else if (anniDiff >= 0 && anniDiff <= 14){
            return doingWell + " " + pastAnni;
        } else if (anniDiff < 0 && anniDiff >= -14){
            return doingWell + " " + futureAnni;
        }
        return "";
    }


    public enum Greeting {
        Hello,
        Greetings
    }

    public enum Feeling {
        Fine,
        Tired
    }

    public enum SkyCondition {
        Sunny,
        Rainy
    }

    public enum Sex {
    	Male,
    	Female
    }
}