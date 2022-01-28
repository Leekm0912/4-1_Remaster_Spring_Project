package db.vo;

import java.sql.Date;

public class ItemVO {
	private int 등록번호;
	private String 주소;
	private String 매도자ID;
	private Date 등록일자;

	public int get등록번호() {
		return 등록번호;
	}

	public void set등록번호(int 등록번호) {
		this.등록번호 = 등록번호;
	}

	public String get주소() {
		return 주소;
	}

	public void set주소(String 주소) {
		this.주소 = 주소;
	}

	public String get매도자ID() {
		return 매도자ID;
	}

	public void set매도자ID(String 매도자id) {
		매도자ID = 매도자id;
	}

	public Date get등록일자() {
		return 등록일자;
	}

	public void set등록일자(Date 등록일자) {
		this.등록일자 = 등록일자;
	}
}
