package models;

import javax.persistence.Entity;

@Entity
public class Phone extends BaseEntity {
    private String number;

    public Phone()  {
    }

    public Phone(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}
