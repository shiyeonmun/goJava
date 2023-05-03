package ch15.sec02.exam01;

public class Board {
	private String subject;
	private String content;
	private String writer;
	
	public Board(String subject, String content, String writer) {
		this.subject = subject;
		this.content = content;
		this.writer = writer;
	}

	public String getSubject() {return subject; }
	public void setSubject(String subject) {this.subject = subject;}
	public String getContent() {return subject; }
	public void setContent(String content) {this.content = content;}
	public String getWriter() {return subject; }
	public void setWriter(String writer) {this.writer = subject;}
	
	
}
