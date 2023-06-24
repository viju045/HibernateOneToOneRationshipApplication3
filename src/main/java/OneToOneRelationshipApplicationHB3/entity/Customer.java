package OneToOneRelationshipApplicationHB3.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
//This is my Third appliction Of OneToOne Realtionship application in Hibernate.
@Entity
public class Customer {
    @Id
    @GeneratedValue(generator = "gen")
    @GenericGenerator(name = "gen",strategy = "foreign",parameters ={@org.hibernate.annotations.Parameter(name = "property",value = "cusTransaction")} )
    private long id;
    private String name;
    private String address;
    private String email;
    @OneToOne
    @PrimaryKeyJoinColumn
    private Cus_Transaction cusTransaction;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cus_Transaction getCusTransaction() {
        return cusTransaction;
    }

    public void setCusTransaction(Cus_Transaction cusTransaction) {
        this.cusTransaction = cusTransaction;
    }
}
