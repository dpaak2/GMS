package com.hanbit.gms.constant;

public class SQL {
	public static final String MEMBER_INSERT = String.format("INSERT INTO %s(id, name, password, ssn, regdate) VALUES(?,?,?,?,SYSDATE)", DB.TABLE_MEMBER);
	public static final String MEMBER_LIST = String.format("SELECT * FROM %s", "Member");
	public static final String MEMBER_FINDBYNAME=String.format("SELECT * FROM %s WHERE %s=?", DB.TABLE_MEMBER,DB.MEMBER_NAME);
	public static final String MEMBER_FINDBYID=String.format("SELECT * FROM %s WHERE %s=?", DB.TABLE_MEMBER,DB.MEMBER_ID);
	public static final String MEMBER_COUNT=String.format("SELECT COUNT(*) as %s FROM %s",DB.MEMBER_COUNT,DB.TABLE_MEMBER);
	public static final String MEMBER_UPDATE=String.format("UPDATE %s SET %s=? WHERE %s=?", DB.TABLE_MEMBER,DB.MEMBER_PW,DB.MEMBER_ID);
	public static final String MEMBER_DELETE=String.format("DELETE FROM %s WHERE %s=?", DB.TABLE_MEMBER,DB.MEMBER_ID);
	public static final String ARTICLE_INSERT=String.format("INSERT INTO %s (article_seq,id,title,content,hitcount,regdate) VALUES (article_seq.nextval,?,?,?,0,SYSDATE)", DB.TABLE_BOARD);
	public static final String ARTICLE_COUT=String.format("SELECT COUNT(*) AS %s FROM %s",DB.ARTICLE_COUNT, DB.TABLE_BOARD);
	public static final String ARTICLE_LIST=String.format("SELECT * FROM %s", DB.TABLE_BOARD);
	public static final String ARTICLE_SELECTBYSEQ=String.format("SELECT * FROM %s WHERE %s=?", DB.TABLE_BOARD,DB.ARTICLE_SEQ);
	public static final String ARTICLE_SELECTBYID=String.format("SELECT * FROM %s WHERE %s=?", DB.TABLE_BOARD,DB.MEMBER_ID);
	public static final String ARTICLE_UPDATE=String.format("UPDATE %s SET %s=?,%s=? WHERE %s=?", DB.TABLE_BOARD,DB.ARTICLE_TITLE,DB.ARTICLE_CONTENT,DB.ARTICLE_SEQ);
	public static final String ARTICLE_DELETE=String.format("DELETE FROM %s WHERE %s=?", DB.TABLE_BOARD,DB.ARTICLE_SEQ);
	
}
