package DesignPattern;


import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String message);
}

class Subscriber implements Observer {
    String name;

    Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + "->" + message);
    }
}

interface Subject {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver();
}

class JobService implements Subject {
    List<Observer> observers = new ArrayList<>();
    String job;

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(job);
        }
    }

    public void publishJob(String job) {
        this.job = job;
        notifyObserver();
    }
}

public class ObserverPatternExample {
    public static void main(String[] args) {
        JobService jobService = new JobService();
        Subscriber sub1 = new Subscriber("Unni");
        Subscriber sub2 = new Subscriber("Rishi");

        jobService.addObserver(sub1);
        jobService.addObserver(sub2);

        jobService.publishJob("Java");

        jobService.removeObserver(sub1);

        jobService.publishJob("Js");

    }
}
