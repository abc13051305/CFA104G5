package ezs.ser_repo.model;

import java.io.Serializable;
import java.sql.Date;

public class SerRepVO implements Serializable{
	private Integer rpID;
	private Integer rpOrdID;
	private Integer rpMemID;
	private String rpTxt;
	private Date rpDate;
	private Byte rpStatus;
	public Integer getRpID() {
		return rpID;
	}
	public void setRpID(Integer rpID) {
		this.rpID = rpID;
	}
	public Integer getRpOrdID() {
		return rpOrdID;
	}
	public void setRpOrdID(Integer rpOrdID) {
		this.rpOrdID = rpOrdID;
	}
	public Integer getRpMemID() {
		return rpMemID;
	}
	public void setRpMemID(Integer rpMemID) {
		this.rpMemID = rpMemID;
	}
	public String getRpTxt() {
		return rpTxt;
	}
	public void setRpTxt(String rpTxt) {
		this.rpTxt = rpTxt;
	}
	public Date getRpDate() {
		return rpDate;
	}
	public void setRpDate(Date rpDate) {
		this.rpDate = rpDate;
	}
	public Byte getRpStatus() {
		return rpStatus;
	}
	public void setRpStatus(Byte rpStatus) {
		this.rpStatus = rpStatus;
	}

}
