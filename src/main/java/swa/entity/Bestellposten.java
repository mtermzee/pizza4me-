package swa.entity;

import javax.enterprise.inject.Vetoed;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "OrderItem")
@Vetoed
@Cacheable
public class Bestellposten {
    @Id
    @SequenceGenerator(name = "orderItemSeq", sequenceName = "orderItem_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "orderItemSeq")
    private int id;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Pizza pizza;
    private int amount;

    public Bestellposten() {
    }

    public Bestellposten(Pizza pizza, int amount) {
        this.pizza = pizza;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
