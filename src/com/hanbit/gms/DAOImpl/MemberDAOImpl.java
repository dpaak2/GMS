package com.hanbit.gms.DAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hanbit.gms.DAO.MemberDAO;
import com.hanbit.gms.constant.DB;
import com.hanbit.gms.domain.MemberBean;

public class MemberDAOImpl implements MemberDAO {
	public static MemberDAO instance= new MemberDAOImpl();
	public static MemberDAO getInstance() {
		try {
			Class.forName(DB.DRIVER);
		} catch (Exception e) {
			System.out.println("SYSTEM FAILED ");
			e.printStackTrace();
		}
		return instance;
	}
	public MemberDAOImpl(){}
	
	
	
	
	@Override
	public int insertMember(MemberBean bean) {
		int insertMember=0;
		System.out.println("inserMember dao: "+bean.toString());
		try {
			Connection connection=DriverManager.getConnection(DB.URL, DB.ID, DB.PW);
			Statement stmt=connection.createStatement();
			//INSERT INTO Member(id, name, password, ssn, regdate) VALUES('jinjin','김진은','1','930929-212345',SYSDATE);
			String sql=String.format("INSERT INTO %s(id, name, password, ssn, regdate) VALUES('%s','%s','%s','%s',SYSDATE)"
					,DB.TABLE_MEMBER,bean.getId(),bean.getName(),bean.getPw(),bean.getSsn());
			System.out.println("DAO sql: "+sql);
			insertMember=stmt.executeUpdate(sql);
			
			System.out.println("DAOIMPL: "+ insertMember);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("dao insertMember int: "+insertMember);
		return insertMember;
	}

	@Override
	public List<MemberBean> selectAll() {
		List<MemberBean> memberList = new ArrayList<>();
		MemberBean temp = null;
		try {
			ResultSet rs = DriverManager.getConnection(DB.URL, DB.ID, DB.PW).createStatement()
					.executeQuery(String.format("SELECT * FROM %s",DB.TABLE_MEMBER));
			while (rs.next()) {
				temp = new MemberBean();
				temp.setId(rs.getString(DB.MEMBER_ID));
				temp.setName(rs.getString(DB.MEMBER_NAME));
				temp.setPw(rs.getString(DB.MEMBER_PW));
				temp.setSsn(rs.getString(DB.MEMBER_SSN));
				temp.setRegedate(rs.getString(DB.MEMBER_REGDATE));
				memberList.add(temp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return memberList;
	}

	@Override
	public int countMembers() {
		int count = 0;
		try {
			Class.forName(DB.DRIVER);
			Connection connection = DriverManager.getConnection(DB.URL, DB.ID, DB.PW);
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(String.format("SELECT COUNT(*) as member_count FROM %s",DB.TABLE_MEMBER));
			if (rs.next()) {
				count = Integer.parseInt(rs.getString("member_count"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("DB count: " + count);
		return count;
	}

	@Override
	public MemberBean selectById(String id) {
		MemberBean bean = new MemberBean();
		try {
			Class.forName(DB.DRIVER);
			Connection connection = DriverManager.getConnection(DB.URL, DB.ID, DB.PW);
			Statement stmt = connection.createStatement();
			String sql =String.format("SELECT * FROM Member WHERE id='%a'",id) ;
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				// id, name, password,ssn,regdate
				bean.setId(rs.getString(DB.ID));
				bean.setName(rs.getString(DB.MEMBER_NAME));
				bean.setPw(rs.getString(DB.MEMBER_PW));
				bean.setSsn(rs.getString(DB.PW));
				bean.setRegedate(rs.getString(DB.MEMBER_REGDATE));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("DB FIND BY ID: " + bean.toString());
		return bean;
	}

	@Override
	public List<MemberBean> selectByName(String name) {
		List<MemberBean> nameList = new ArrayList<>();
		MemberBean temp= null;
		try {
			Class.forName(DB.DRIVER);
			Connection connection = DriverManager.getConnection(DB.URL, DB.ID, DB.PW);
			Statement stmt = connection.createStatement();
			String sql = "SELECT * FROM %s WHERE name LIKE '%"+name+"%'";
			System.out.println("DAO SQL: "+sql);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				temp=new MemberBean();				
				temp.setId(rs.getString(DB.MEMBER_ID));
				temp.setName(rs.getString(DB.MEMBER_NAME));
				temp.setPw(rs.getString(DB.MEMBER_PW));
				temp.setSsn(rs.getString(DB.MEMBER_SSN));
				temp.setRegedate(rs.getString(DB.MEMBER_REGDATE));
				nameList.add(temp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("nameLIST DAO: "+nameList.toString());
		return nameList;
	}

	@Override
	public int updateProfile(MemberBean bean) {
		int updateResult = 0;
		try {
			Class.forName(DB.DRIVER);
			String sql = "UPDATE FROM Member WHERE id='"+bean.getId()+"'";
			updateResult=DriverManager.getConnection(DB.URL, DB.ID, DB.PW).createStatement().executeUpdate(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return updateResult;
	}

	@Override
	public int deleteUser(String id) {
		int deleteUser = 0;
		try {
			Class.forName(DB.DRIVER);
			DriverManager.getConnection(DB.URL, DB.ID, DB.PW).createStatement().executeUpdate("DELETE FROM MEMBER WHERE id='skim';");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleteUser;
	}
}
