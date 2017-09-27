package models;

import javax.persistence.*;

@Entity
public class User extends BaseEntity {

    @Column(name = "NAME")
    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @OneToOne(fetch= FetchType.EAGER, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name="ADDRESS_ID")
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
