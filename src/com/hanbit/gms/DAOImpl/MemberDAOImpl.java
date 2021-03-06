package com.hanbit.gms.DAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.Data;

import com.hanbit.gms.DAO.MemberDAO;
import com.hanbit.gms.constant.DB;
import com.hanbit.gms.constant.SQL;
import com.hanbit.gms.constant.Vendor;
import com.hanbit.gms.domain.MemberBean;
import com.hanbit.gms.factory.DatabaseFactory;

public class MemberDAOImpl implements MemberDAO {
	public static MemberDAO instance= new MemberDAOImpl();
	public static MemberDAO getInstance() {
		return instance;
	}
	public MemberDAOImpl(){}
	
	
	
	
	@Override
	public String insertMember(MemberBean bean) {
		String insertMember="";
		System.out.println("inserMember dao: "+bean.toString());
		try {
			PreparedStatement pstmt=DatabaseFactory.createDatabase(Vendor.ORACLE, DB.ID, DB.PW).getConnection().prepareStatement(SQL.MEMBER_INSERT);
			pstmt.setString(1, bean.getId());
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getPw());
			pstmt.setString(4, bean.getSsn());
			insertMember=String.valueOf(pstmt.executeUpdate());
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
			ResultSet rs =DatabaseFactory.createDatabase(Vendor.ORACLE, DB.ID, DB.PW).getConnection().prepareStatement(SQL.MEMBER_LIST).executeQuery();
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
	public String countMembers() {
		String count = "";
		try {
			PreparedStatement pstmt=DatabaseFactory.createDatabase(Vendor.ORACLE, DB.ID, DB.PW).getConnection().prepareStatement(SQL.MEMBER_COUNT);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getString("member_count");
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
			PreparedStatement pstmt= DatabaseFactory.createDatabase(Vendor.ORACLE, DB.ID, DB.PW).getConnection().prepareStatement(SQL.MEMBER_FINDBYID);
			pstmt.setString(1, id);
			ResultSet rs =pstmt.executeQuery();
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
			PreparedStatement pstmt=DatabaseFactory.createDatabase(Vendor.ORACLE, DB.ID, DB.PW).getConnection().prepareStatement(SQL.MEMBER_FINDBYNAME);
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
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
	public String updateProfile(MemberBean bean) {
		String updateResult = "";
		try {
			PreparedStatement pstmt=DatabaseFactory.createDatabase(Vendor.ORACLE, DB.ID, DB.PW).getConnection().prepareStatement(SQL.MEMBER_UPDATE);
			pstmt.setString(1, bean.getPw());
			pstmt.setString(2, bean.getId());
			updateResult=String.valueOf(pstmt.executeUpdate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updateResult;
	}

	@Override
	public String deleteUser(String id) {
		String deleteUser = "";
		try {
			PreparedStatement pstmt=DatabaseFactory.createDatabase(Vendor.ORACLE, DB.ID, DB.PW).getConnection().prepareStatement(SQL.MEMBER_DELETE);
			pstmt.setString(1, id);
			deleteUser=String.valueOf(pstmt.executeUpdate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleteUser;
	}
}
