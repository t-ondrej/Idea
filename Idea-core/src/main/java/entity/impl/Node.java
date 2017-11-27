package entity.impl;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import entity.IEntity;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tomas on 8.11.2017.
 */
@Entity
@Table(name = "Node")
public class Node implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"IDNODE\"", unique = true)
    private Long id;

    @JsonProperty("AggrWin")
    @Column(name = "\"AGGRWIN\"")
    private Time aggrWin;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "\"EVENTID\"", referencedColumnName = "\"IDEVENT\"")
    private Event event;

    @JsonProperty("Name")
    @Column(name = "\"NAME\"")
    private String name;

    @JsonProperty("Note")
    @Column(name = "\"NOTE\"")
    private String note;

    @JsonProperty("SW")
    @Type(type = "jsonStringArray")
    @Column(name = "\"SW\"")
    private List<String> sw;

    @JsonProperty("Type")
    @Type(type = "jsonStringArray")
    @Column(name = "\"TYPE\"")
    private List<String> type = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Time getAggrWin() {
        return aggrWin;
    }

    public void setAggrWin(Time aggrWin) {
        this.aggrWin = aggrWin;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<String> getsSw() {
        return sw;
    }

    public void setsSw(List<String> sW) {
        this.sw = sW;
    }

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                '}';
    }
}
