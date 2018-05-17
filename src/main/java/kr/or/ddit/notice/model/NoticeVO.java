package kr.or.ddit.notice.model;

import java.util.Date;

public class NoticeVO {
	private Integer no_seq;
	private String no_mem_id;
	private String no_name;
	private String no_st;
	private Date no_dt;
	
	public NoticeVO() {
	}
	
	

	public NoticeVO(String no_mem_id, String no_name,
			String no_st) {
		super();
		this.no_mem_id = no_mem_id;
		this.no_name = no_name;
		this.no_st = no_st;
	}



	public Integer getNo_seq() {
		return no_seq;
	}

	public void setNo_seq(Integer no_seq) {
		this.no_seq = no_seq;
	}

	public String getNo_mem_id() {
		return no_mem_id;
	}

	public void setNo_mem_id(String no_mem_id) {
		this.no_mem_id = no_mem_id;
	}

	public String getNo_name() {
		return no_name;
	}

	public void setNo_name(String no_name) {
		this.no_name = no_name;
	}

	public String getNo_st() {
		return no_st;
	}

	public void setNo_st(String no_st) {
		this.no_st = no_st;
	}

	public Date getNo_dt() {
		return no_dt;
	}

	public void setNo_dt(Date no_dt) {
		this.no_dt = no_dt;
	}

	@Override
	public String toString() {
		return "NoticeVO [no_seq=" + no_seq + ", no_mem_id=" + no_mem_id
				+ ", no_name=" + no_name + ", no_st=" + no_st + ", no_dt="
				+ no_dt + "]";
	}
	
	
}
