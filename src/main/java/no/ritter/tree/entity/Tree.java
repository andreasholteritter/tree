package no.ritter.tree.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trees")
public class Tree {

    @Id
    private long id;
    private String name;

    public Tree() {}

    public Tree(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
