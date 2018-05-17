package kr.or.ddit.file.model;

public class FileVO {
	private int fi_seq;
	private int fi_board_seq;
	private String fi_path;
	private String fi_name;
	
	public String getFi_name() {
		return fi_name;
	}
	public void setFi_name(String fi_name) {
		this.fi_name = fi_name;
	}
	public int getFi_seq() {
		return fi_seq;
	}
	public void setFi_seq(int fi_seq) {
		this.fi_seq = fi_seq;
	}
	public int getFi_board_seq() {
		return fi_board_seq;
	}
	public void setFi_board_seq(int fi_board_seq) {
		this.fi_board_seq = fi_board_seq;
	}
	public String getFi_path() {
		return fi_path;
	}
	public void setFi_path(String fi_path) {
		this.fi_path = fi_path;
	}
	
	
}
