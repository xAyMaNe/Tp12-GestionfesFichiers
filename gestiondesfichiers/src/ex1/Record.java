package ex1;

import java.io.Serializable;

public class Record implements Serializable {
    public int id;
    public String name;
    public double score;
    
    public Record(int id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }
    
    @Override
    public String toString() {
        return id + "," + name + "," + score;
    }
}
