package SEM;

// Интерфейс SEM.Person
interface Person {
    void doWork();

    void haveRest();
}

// Класс Работник, реализующий интерфейс SEM.Person
class Worker implements Person {
    @Override
    public void doWork() {
        System.out.println("SEM.Worker is working hard.");
    }

    @Override
    public void haveRest() {
        System.out.println("SEM.Worker doesn't know how to rest.");
    }
}

// Класс Бездельник, реализующий интерфейс SEM.Person
class LazyPerson implements Person {
    @Override
    public void doWork() {
        System.out.println("Lazy person doesn't know how to work.");
    }

    @Override
    public void haveRest() {
        System.out.println("Lazy person is resting.");
    }
}

// Обобщенный класс SEM.Workplace
class Workplace<T extends Person> {
    private T[] people;

    public Workplace(T[] people) {
        this.people = people;
    }

    public void performWork() {
        for (T person : people) {
            person.doWork();
        }
    }

    public void takeBreak() {
        for (T person : people) {
            person.haveRest();
        }
    }
}

// Обобщенный класс SEM.Club
class Club<T extends Person> {
    private T[] people;

    public Club(T[] people) {
        this.people = people;
    }

    public void party() {
        for (T person : people) {
            person.haveRest();
        }
    }
}

public class EX4 {
    public static void main(String[] args) {
        Worker worker1 = new Worker();
        Worker worker2 = new Worker();
        LazyPerson lazyPerson1 = new LazyPerson();
        LazyPerson lazyPerson2 = new LazyPerson();

        Workplace<Worker> workOffice = new Workplace<>(new Worker[]{worker1, worker2});
        workOffice.performWork();
        workOffice.takeBreak();

        Workplace<LazyPerson> lazyClub = new Workplace<>(new LazyPerson[]{lazyPerson1, lazyPerson2});
        lazyClub.performWork();
        lazyClub.takeBreak();

        Club<LazyPerson> lazyPeopleClub = new Club<>(new LazyPerson[]{lazyPerson1, lazyPerson2});
        lazyPeopleClub.party();
    }
}
