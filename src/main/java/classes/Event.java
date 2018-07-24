package classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test")
public class Event {
	private Integer id;
	private String ssoid;
	private String ts;
	private String grp;
	private String type;
	private String subtype;
	private String url;
	private String orgid;
	private String formid;
	private String code;
	private String itpa;
	private String sudirresponse;
	private String ymdh;
	
	public Event() {}
	
	public Event(String ssoid, String ts, String grp, String type, String subtype, String url, String orgid, String formid, String code, String itpa, String sudirresponse, String ymdh) {
		this.ssoid = ssoid;
		this.ts = ts;
		this.grp = grp;
		this.type = type;
		this.subtype = subtype;
		this.url = url;
		this.orgid = orgid;
		this.formid = formid;
		this.code = code;
		this.itpa = itpa;
		this.sudirresponse = sudirresponse;
		this.ymdh = ymdh;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSsoid() {
		return ssoid;
	}
	public void setSsoid(String ssoid) {
		this.ssoid = ssoid;
	}
	public String getTs() {
		return ts;
	}
	public void setTs(String ts) {
		this.ts = ts;
	}
	public String getGrp() {
		return grp;
	}
	public void setGrp(String grp) {
		this.grp = grp;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSubtype() {
		return subtype;
	}
	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getOrgid() {
		return orgid;
	}
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}
	public String getFormid() {
		return formid;
	}
	public void setFormid(String formid) {
		this.formid = formid;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getItpa() {
		return itpa;
	}
	public void setItpa(String itpa) {
		this.itpa = itpa;
	}
	public String getSudirresponse() {
		return sudirresponse;
	}
	public void setSudirresponse(String sudirresponse) {
		this.sudirresponse = sudirresponse;
	}
	public String getYmdh() {
		return ymdh;
	}
	public void setYmdh(String ymdh) {
		this.ymdh = ymdh;
	}
}
