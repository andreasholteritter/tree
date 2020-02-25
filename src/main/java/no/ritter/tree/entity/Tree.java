package no.ritter.tree.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trees")
public class Tree {

    @Id
    private int id;
    private String name;

    public Tree() {}

    public Tree(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
