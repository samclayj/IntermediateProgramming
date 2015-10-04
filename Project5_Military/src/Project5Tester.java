import java.util.ArrayList;


public class Project5Tester {

    
    public static void main(String[] args) {
        Name name1 = new Name("John","Smith");
        Name name2 = new Name("IDoNotHaveAFirstName");
        
        Pilot p1 = new Pilot(name1,"Jan. 1, 2013", "1234", 23, "East Wing", 1259, new Plane("hasBeen", "no where"));
        Military m1 = new Military (name2, "Jan. 2, 2013", "1235", 24, "Awesome Command");
        
        Person person1 = new Person(new Name("Smith"), "Jan. 3, 2013", "1236");
        
        Person person2 = new Person(new Name("John","Jones"),"Jan. 4, 2013", "1237");
        
        
        Military m2 = new Military(new Name("Rock","Hard"), "Jan. 5, 2013", "1238", 25, "Awesome Command");
        
        Plane plane1 = new Plane("F-22","classified");
        
        Pilot p2 = new Pilot(new Name("ThinksHighly","OfSelf"),"Jan.6, 2013","1239",26,"West Command",567898765432L,plane1);
        
        
        ArrayList<Person> people = new ArrayList<Person>();
        people.add(p1);
        people.add(m1);
        people.add(person1);
        people.add(person2);
        people.add(m2);
        people.add(p2);
        
        ArrayList<Military> marines = new ArrayList<Military>();
        marines.add(p1);
        marines.add(m1);
        marines.add(m2);
        marines.add(p2);
        
        ArrayList<Pilot> pilots = new ArrayList<Pilot>();
        
        pilots.add(p1);
        pilots.add(p2);
        
        System.out.println("Here is the list of people with their information:");
        
        for (Person p : people)
            System.out.println(p.getName().getGivenName() + " " + p.getName().getSurName() + " born on " + p.getBirthday() + " with a ssn of " + p.getSSN());
        
        System.out.println("\nHere is the list of military personnell with their information:");
        
        for (Military p : marines)
            System.out.println(p.getName().getGivenName() + " " + p.getName().getSurName() + " born on " + p.getBirthday() + " with a ssn of " + p.getSSN() + " militaryID of " + p.getMilitaryID() + " with the assigned unit of " + p.getAssignedUnit());
        
        System.out.println("\nHere is the list of the pilots with their information:");
        
        for (Pilot p : pilots)
            System.out.println(p.getName().getGivenName() + " " + p.getName().getSurName() + " born on " + p.getBirthday() + " with a ssn of " + p.getSSN() + " militaryID of " + p.getMilitaryID() + " with the assigned unit of " + p.getAssignedUnit() + " with the hours logged of " + p.getHoursLogged() + " with the assigned plane of " + p.getAssignedPlane().getName() + " this is at the following location " + p.getAssignedPlane().getLocation());
    }

}
