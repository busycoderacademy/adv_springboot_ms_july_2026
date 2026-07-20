package com.basics.gof.behavioural.observer;

import java.util.ArrayList;
import java.util.List;

//Subject (Observable)
interface Subject {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(String message);
}
//Observer (Subscriber)
interface Observer {
    void update(String message);
}

//Concrete Subject
class NewsAgency implements Subject {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers(String message) {
        for (Observer o : observers) {
            o.update(message);
        }
    }

    public void setNews(String news) {
        System.out.println("Agency: " + news);
        notifyObservers(news);
    }
}

//Concrete Observers
class EmailSubscriber implements Observer {
    public void update(String message) {
        System.out.println("Email received: " + message);
    }
}

class SMSSubscriber implements Observer {
    public void update(String message) {
        System.out.println("SMS received: " + message);
    }
}
public class DemoObserver {
    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();
        Observer email = new EmailSubscriber();
        Observer sms = new SMSSubscriber();

        agency.addObserver(email);
        agency.addObserver(sms);

        agency.setNews("Java 21 Released!");
    }
}
