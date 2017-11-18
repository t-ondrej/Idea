package entity.impl;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import entity.IEntity;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Tomas on 8.11.2017.
 */

@Entity
@Table(name = "Target", schema = "events")
public class Target implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"IDTARGET\"", unique = true)
    private Long id;

    @JsonProperty("Anonymised")
    @Column(name = "\"ANONYMISED\"")
    private Boolean anonymised;

    @Type(type = "jsonStringArray")
    @Column(name = "\"ASN\"")
    private List<String> asn;

    @JsonProperty("AttachHand")
    @Type(type = "jsonStringArray")
    @Column(name = "\"ATTACHHAND\"")
    private List<String> attachHand;

    @JsonProperty("Description")
    @Column(name = "\"DESCRIPTION\"")
    private String description;

    @JsonProperty("Email")
    @Type(type = "jsonStringArray")
    @Column(name = "\"EMAIL\"")
    private List<String> email;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "\"EVENTID\"", referencedColumnName = "\"IDEVENT\"")
    private Event event;

    @JsonProperty("Hostname")
    @Type(type = "jsonStringArray")
    @Column(name = "\"HOSTNAME\"")
    private List<String> hostname;

    @JsonProperty("Imprecise")
    @Column(name = "\"IMPRECISE\"")
    private Boolean imprecise;

    @JsonProperty("IP4")
    @Type(type = "jsonStringArray")
    @Column(name = "\"IP4\"")
    private List<String> iP4;

    @JsonProperty("IP6")
    @Type(type = "jsonStringArray")
    @Column(name = "\"IP6\"")
    private List<String> iP6;

    @JsonProperty("MAC")
    @Type(type = "jsonStringArray")
    @Column(name = "\"MAC\"")
    private List<String> mAC;

    @JsonProperty("Netname")
    @Type(type = "jsonStringArray")
    @Column(name = "\"NETNAME\"")
    private List<String> netname;

    @JsonProperty("Note")
    @Column(name = "\"NOTE\"")
    private String note;

    @JsonProperty("Port")
    @Type(type = "jsonStringArray")
    @Column(name = "\"PORT\"")
    private List<String> port;

    @JsonProperty("Proto")
    @Type(type = "jsonStringArray")
    @Column(name = "\"PROTO\"")
    private List<String> proto;

    @JsonProperty("Ref")
    @Type(type = "jsonStringArray")
    @Column(name = "\"REF\"")
    private List<String> ref;

    @JsonProperty("Router")
    @Type(type = "jsonStringArray")
    @Column(name = "\"ROUTER\"")
    private List<String> router;

    @JsonProperty("Spoofed")
    @Column(name = "\"SPOOFED\"")
    private Boolean spoofed;

    @JsonProperty("Type")
    @Type(type = "jsonStringArray")
    @Column(name = "\"TYPE\"")
    private List<String> type;

    @JsonProperty("URL")
    @Type(type = "jsonStringArray")
    @Column(name = "\"URL\"")
    private List<String> url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getAnonymised() {
        return anonymised;
    }

    public void setAnonymised(Boolean anonymised) {
        this.anonymised = anonymised;
    }

    public List<String> getAsn() {
        return asn;
    }

    public void setAsn(List<String> asn) {
        this.asn = asn;
    }

    public List<String> getAttachHand() {
        return attachHand;
    }

    public void setAttachHand(List<String> attachHand) {
        this.attachHand = attachHand;
    }

    public List<String> getEmail() {
        return email;
    }

    public void setEmail(List<String> email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public List<String> getHostname() {
        return hostname;
    }

    public void setHostname(List<String> hostname) {
        this.hostname = hostname;
    }

    public Boolean getImprecise() {
        return imprecise;
    }

    public void setImprecise(Boolean imprecise) {
        this.imprecise = imprecise;
    }

    public List<String> getiP4() {
        return iP4;
    }

    public void setiP4(List<String> iP4) {
        this.iP4 = iP4;
    }

    public List<String> getiP6() {
        return iP6;
    }

    public void setiP6(List<String> iP6) {
        this.iP6 = iP6;
    }

    public List<String> getmAC() {
        return mAC;
    }

    public void setmAC(List<String> mAC) {
        this.mAC = mAC;
    }

    public List<String> getNetname() {
        return netname;
    }

    public void setNetname(List<String> netname) {
        this.netname = netname;
    }

    public List<String> getPort() {
        return port;
    }

    public void setPort(List<String> port) {
        this.port = port;
    }

    public List<String> getRef() {
        return ref;
    }

    public void setRef(List<String> ref) {
        this.ref = ref;
    }

    public List<String> getRouter() {
        return router;
    }

    public void setRouter(List<String> router) {
        this.router = router;
    }

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }

    public List<String> getUrl() {
        return url;
    }

    public void setUrl(List<String> url) {
        this.url = url;
    }

    public Boolean getSpoofed() {
        return spoofed;
    }

    public void setSpoofed(Boolean spoofed) {
        this.spoofed = spoofed;
    }

    public List<String> getProto() {
        return proto;
    }

    public void setProto(List<String> proto) {
        this.proto = proto;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Target{" +
                "id=" + id +
                '}';
    }
}
