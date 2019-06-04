package com.osf.test.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("member")
@Data
public class MemberVO {
	private Integer miNum;
	private String miName;
	private String miId;
	private String miPwd;
	private Integer miTrans;
	private String miEmail;
	private String miBirth;
	private String miZipcode;
	private String miAddr1;
	private String miAddr2;
	private String miCredat;
	private String miCretim;
	private String miModdat;
	private String miModtim;
	private String miMainImg;
	private String miNick;
	private String miEtc;
}
