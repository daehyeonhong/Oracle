package model;

import java.util.Date;

public class Board {
	private int bno;
	private String title;
	private String content;
	private Date regdate;

	public Board(int bno, String title, String content, Date regdate) {
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
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

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "Board [bno=" + bno + ", title=" + title + ", content=" + content + ", regdate=" + regdate + "]";
	}

}
