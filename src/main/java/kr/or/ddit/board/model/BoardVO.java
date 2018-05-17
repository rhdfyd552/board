package kr.or.ddit.board.model;

import java.util.Date;

public class BoardVO {
	private Integer board_seq;
	private Integer pboard_seq;
	private Integer category_seq;
	private Integer group_seq;
	private String title;
	private String content;
	private String reg_id;
	private Date reg_dt;
	private String del_yn;
	public Integer getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(Integer board_seq) {
		this.board_seq = board_seq;
	}
	public Integer getPboard_seq() {
		return pboard_seq;
	}
	public void setPboard_seq(Integer pboard_seq) {
		this.pboard_seq = pboard_seq;
	}
	public Integer getCategory_seq() {
		return category_seq;
	}
	public void setCategory_seq(Integer category_seq) {
		this.category_seq = category_seq;
	}
	public Integer getGroup_seq() {
		return group_seq;
	}
	public void setGroup_seq(Integer group_seq) {
		this.group_seq = group_seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReg_id() {
		return reg_id;
	}
	public void setReg_id(String reg_id) {
		this.reg_id = reg_id;
	}
	public Date getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}
	public String getDel_yn() {
		return del_yn;
	}
	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}
	@Override
	public String toString() {
		return "BoardVO [board_seq=" + board_seq + ", pboard_seq=" + pboard_seq
				+ ", category_seq=" + category_seq + ", group_seq=" + group_seq
				+ ", title=" + title + ", content=" + content + ", reg_id="
				+ reg_id + ", reg_dt=" + reg_dt + ", del_yn=" + del_yn + "]";
	}
	
	
	
}
