package dns;

public class DnsInfo {
	private String domain;
	private int domain_id;
	private String record_id;
	private String record_line_id;
	private String record_line;
	private String sub_domain;
	private String record_type;
	private String value;
	private String LOGIN_TOKEN;
	private String ttl;
	private String mx;
	private String statu;
	
	@Override
	public String toString() {
		return "DNS信息为： [domain=" + domain + ", domain_id=" + domain_id + ", record_id=" + record_id
				+ ", record_line_id=" + record_line_id + ", record_line=" + record_line + ", sub_domain=" + sub_domain
				+ ", record_type=" + record_type + ", value=" + value + ", LOGIN_TOKEN=" + LOGIN_TOKEN + ", ttl=" + ttl
				+ ", mx=" + mx + ", statu=" + statu + "]";
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public int getDomain_id() {
		return domain_id;
	}
	public void setDomain_id(int domain_id) {
		this.domain_id = domain_id;
	}
	public String getRecord_id() {
		return record_id;
	}
	public void setRecord_id(String record_id) {
		this.record_id = record_id;
	}
	public String getRecord_line_id() {
		return record_line_id;
	}
	public void setRecord_line_id(String record_line_id) {
		this.record_line_id = record_line_id;
	}
	public String getRecord_line() {
		return record_line;
	}
	public void setRecord_line(String record_line) {
		this.record_line = record_line;
	}
	public String getSub_domain() {
		return sub_domain;
	}
	public void setSub_domain(String sub_domain) {
		this.sub_domain = sub_domain;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getLOGIN_TOKEN() {
		return LOGIN_TOKEN;
	}
	public void setLOGIN_TOKEN(String lOGIN_TOKEN) {
		LOGIN_TOKEN = lOGIN_TOKEN;
	}
	public String getRecord_type() {
		return record_type;
	}
	public void setRecord_type(String record_type) {
		this.record_type = record_type;
	}
	public String getTtl() {
		return ttl;
	}
	public void setTtl(String ttl) {
		this.ttl = ttl;
	}
	public String getMx() {
		return mx;
	}
	public void setMx(String mx) {
		this.mx = mx;
	}
	public String getStatu() {
		return statu;
	}
	public void setStatu(String statu) {
		this.statu = statu;
	}
	public String getDomain() {
		return domain;
	}
	
}
