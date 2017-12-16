package sk.upjs.ics.entity.impl;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import sk.upjs.ics.entity.IEntity;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Tomas on 8.11.2017.
 */

@Entity
@Table(name = "Target")
public class Target implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"IDTARGET\"", unique = true)
    private Long id;

    @JsonProperty("Anonymised")
    @ApiModelProperty(notes = "JSON \"true\" or \"false\" value.")
    @Column(name = "\"ANONYMISED\"")
    private Boolean anonymised;

    @Type(type = "jsonStringArray")
    @ApiModelProperty(notes = "Autonomous system numbers.")
    @Column(name = "\"ASN\"")
    private List<String> asn;

    @JsonProperty("AttachHand")
    @Type(type = "jsonStringArray")
    @ApiModelProperty(notes = "Array of attachment identifiers.")
    @Column(name = "\"ATTACHHAND\"")
    private List<String> attachHand;

    @JsonProperty("Description")
    @ApiModelProperty(notes = "Free text human readable additional description.")
    @Column(name = "\"DESCRIPTION\"")
    private String description;

    @JsonProperty("Email")
    @Type(type = "jsonStringArray")
    @ApiModelProperty(notes = "Array of email addresses.")
    @Column(name = "\"EMAIL\"")
    private List<String> email;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "\"EVENTID\"", referencedColumnName = "\"IDEVENT\"")
    private Event event;

    @JsonProperty("Hostname")
    @Type(type = "jsonStringArray")
    @ApiModelProperty(notes = "Array of hostnames.")
    @Column(name = "\"HOSTNAME\"")
    private List<String> hostname;

    @JsonProperty("Imprecise")
    @ApiModelProperty(notes = "JSON \"true\" or \"false\" value.")
    @Column(name = "\"IMPRECISE\"")
    private Boolean imprecise;

    @JsonProperty("IP4")
    @Type(type = "jsonStringArray")
    @ApiModelProperty(notes = "Array of IPv4 addresses.")
    @Column(name = "\"IP4\"")
    private List<String> ip4;

    @JsonProperty("IP6")
    @Type(type = "jsonStringArray")
    @ApiModelProperty(notes = "Array of IPv6 addresses.")
    @Column(name = "\"IP6\"")
    private List<String> ip6;

    @JsonProperty("MAC")
    @Type(type = "jsonStringArray")
    @ApiModelProperty(notes = "Array of MAC addresses.")
    @Column(name = "\"MAC\"")
    private List<String> mac;

    @JsonProperty("Netname")
    @Type(type = "jsonStringArray")
    @ApiModelProperty(notes = "Array of RIR network identifiers.")
    @Column(name = "\"NETNAME\"")
    private List<String> netname;

    @JsonProperty("Note")
    @ApiModelProperty(notes = "Free text human readable additional note.")
    @Column(name = "\"NOTE\"")
    private String note;

    @JsonProperty("Port")
    @Type(type = "jsonStringArray")
    @ApiModelProperty(notes = "Array of port numbers.")
    @Column(name = "\"PORT\"")
    private List<String> port;

    @JsonProperty("Proto")
    @Type(type = "jsonStringArray")
    @ApiModelProperty(notes = "Array of protocol names.")
    @Column(name = "\"PROTO\"")
    private List<String> proto;

    @JsonProperty("Ref")
    @Type(type = "jsonStringArray")
    @ApiModelProperty(notes = "Array of references.")
    @Column(name = "\"REF\"")
    private List<String> ref;

    @JsonProperty("Router")
    @Type(type = "jsonStringArray")
    @ApiModelProperty(notes = "Array of router/interface paths.")
    @Column(name = "\"ROUTER\"")
    private List<String> router;

    @JsonProperty("Spoofed")
    @ApiModelProperty(notes = "JSON \"true\" or \"false\" value.")
    @Column(name = "\"SPOOFED\"")
    private Boolean spoofed;

    @JsonProperty("Type")
    @Type(type = "jsonStringArray")
    @ApiModelProperty(notes = "Array of source/target categories.")
    @Column(name = "\"TYPE\"")
    private List<String> type;

    @JsonProperty("URL")
    @Type(type = "jsonStringArray")
    @ApiModelProperty(notes = "Array of URLs.")
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

    public List<String> getIp4() {
        return ip4;
    }

    public void setIp4(List<String> iP4) {
        this.ip4 = iP4;
    }

    public List<String> getIp6() {
        return ip6;
    }

    public void setIp6(List<String> iP6) {
        this.ip6 = iP6;
    }

    public List<String> getMac() {
        return mac;
    }

    public void setMac(List<String> mAC) {
        this.mac = mAC;
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
