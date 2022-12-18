package dtos;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Food {
    private String id;
    private String name;
    private float weight;
    private String type;
    private int place;
    private Date expiredDate;

    public Food(String id, String name, float weight, String type, int place, Date expiredDate) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.type = type;
        this.place = place;
        this.expiredDate = expiredDate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    @Override
    public String toString() {
        String parsedExpDate = new SimpleDateFormat("dd/MM/yyyy").format(this.expiredDate);
        return this.id + ", " + this.name + ", " + this.weight + ", " + this.type + ", " + this.place + ", " + parsedExpDate + "\n";
    }
}
