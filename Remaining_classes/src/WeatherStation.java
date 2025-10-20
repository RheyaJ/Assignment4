import java.util.*;

interface Observer {
    void update(int temperature);
}

class PhoneDisplay implements Observer {
    @Override
    public void update(int temperature) {
        System.out.println("Phone shows: " + temperature + "°C");
    }
}

class TVDisplay implements Observer {
    @Override
    public void update(int temperature) {
        System.out.println("TV shows: " + temperature + "°C");
    }
}

class WeatherStation {
    private List<Observer> observers;
    private int temperature;

    public WeatherStation() {
        observers = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setTemp(int temperature) {
        this.temperature = temperature;
        System.out.println("Temperature changed to " + temperature);
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }

    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        PhoneDisplay phone = new PhoneDisplay();
        TVDisplay tv = new TVDisplay();

        station.addObserver(phone);
        station.addObserver(tv);

        station.setTemp(25);
        station.setTemp(30);
    }
}
