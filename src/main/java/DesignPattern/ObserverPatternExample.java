package DesignPattern;


import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String message);
}

class JobObserver implements Observer {
    String name;

    JobObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + "->" + message);
    }
}

interface Jobs {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver();
}

class JobPublisher implements Jobs {
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

// multiple observers are notified when a job is published
public class ObserverPatternExample {
    public static void main(String[] args) {
        JobPublisher jobPublisher = new JobPublisher();
        JobObserver sub1 = new JobObserver("Unni");
        JobObserver sub2 = new JobObserver("Rishi");

        jobPublisher.addObserver(sub1);
        jobPublisher.addObserver(sub2);

        jobPublisher.publishJob("Java");

        jobPublisher.removeObserver(sub1);

        //notify subscribers who are actively seeking
        jobPublisher.publishJob("Js");

    }
}
