package Class;

import java.io.Serializable;

public class Ticket implements Serializable {
    private Integer id;
    private String name;
    private String type;
    private String time;
    private int price;
    private int day;
    private String month;
    private int place;
    private int age;

    public Ticket() {
    }

    public Ticket(Integer id, String name, String type, String time, int price, int day, String month, int place, int age) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.time = time;
        this.price = price;
        this.day = day;
        this.month = month;
        this.place = place;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }



    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return
                 id + ") " + "Name: " +
                 name +
                " " + "Time: " +
                 time + " Price: " +
                 price + '\n' +
                "Day:  " + day + " Month: " +
                 month +
                " Place: " + place;

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
