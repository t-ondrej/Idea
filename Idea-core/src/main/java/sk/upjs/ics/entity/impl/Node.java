package sk.upjs.ics.entity.impl;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import sk.upjs.ics.entity.IEntity;
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
    @ApiModelProperty(notes = "String, containing time offset, intended for representing difference between two timestamps. Format is time part of [[http://tools.ietf.org/html/rfc3339|RFC 3339]], optionally prepended by \"D\" or \"d\" separator and number of days (which can have arbitrary number number of digits). \"D\" separator has been chosen to distinguish from internet time, and as a memory aid for \"duration\" or \"days\". For example \"536D10:20:30.5\" means 536 days, 10 hours, 20 seconds, 30.5 seconds, whereas 00:05:00 represents five minutes.")
    @Column(name = "\"AGGRWIN\"")
    private Time aggrWin;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "\"EVENTID\"", referencedColumnName = "\"IDEVENT\"")
    private Event event;

    @JsonProperty("Name")
    @ApiModelProperty(notes = "Namespaced identifier. Dot separated list of labels, with significance from left to right – leftmost denoting largest containing realm, rightmost denoting single entity. Country – organisation – suborganizations – machine – local scheme akin to \"org.example.csirt.northwest.honeypot.jabberwock\" is strongly recommended. Label case is insignificant, label can contain only letters, numbers or underscore and must not start with number.")
    @Column(name = "\"NAME\"")
    private String name;

    @JsonProperty("Note")
    @ApiModelProperty(notes = "Free text human readable additional description.")
    @Column(name = "\"NOTE\"")
    private String note;

    @JsonProperty("SW")
    @Type(type = "jsonStringArray")
    @ApiModelProperty(notes = "Array of detection software names.")
    @Column(name = "\"SW\"")
    private List<String> sw;

    @JsonProperty("Type")
    @Type(type = "jsonStringArray")
    @ApiModelProperty(notes = "Array of detection node types.")
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

    public List<String> getSw() {
        return sw;
    }

    public void setSw(List<String> sW) {
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
