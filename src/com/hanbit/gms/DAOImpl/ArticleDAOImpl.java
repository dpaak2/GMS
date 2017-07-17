package com.hanbit.gms.DAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hanbit.gms.DAO.ArticleDAO;
import com.hanbit.gms.constant.DB;
import com.hanbit.gms.domain.ArticleBean;

public class ArticleDAOImpl implements ArticleDAO{
	
	public ArticleDAOImpl(){
		try {
			Class.forName(DB.DRIVER);
		} catch (Exception e) {
			System.out.println("=====ARTICLE DAOIMPL::::LOAD FAILED");
			e.printStackTrace();
		}
	}

	@Override
	public int insertArticle(ArticleBean bean) {
		int insertArticle=0;
		try {
			Connection connection=DriverManager.getConnection(DB.URL,DB.ID,DB.PW);
			Statement stmt=connection.createStatement();
			String sql="INSERT INTO Board (article_seq,id,title,content,hitcount,regdate)"
					+ " VALUES (article_seq.nextval,'"+bean.getId()+"','"+bean.getTitle()+"','"+bean.getContent()+"',0,SYSDATE)";
			System.out.println("INSERT SQL: "+sql);
			insertArticle=stmt.executeUpdate(sql);
					
		} catch (SQLException e) {
			System.out.println("====insertArticle Fail");
			e.printStackTrace();
		}
		return insertArticle;
	}

	@Override
	public int countArticles() {
		int countArticles=0;
		try {
			Connection connection=DriverManager.getConnection(DB.URL,DB.ID,DB.PW);
			Statement stmt=connection.createStatement();
			String sql="SELECT COUNT(*) as article_count FROM Board";
			ResultSet rs= stmt.executeQuery(sql);
			if(rs.next()){
				countArticles=rs.getInt("article_count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return countArticles;
	}

	@Override
	public List<ArticleBean> listArticles() {
		List<ArticleBean> listArticles=new ArrayList<>();
		ArticleBean listBean=null;
		try {
			Connection connection=DriverManager.getConnection(DB.URL,DB.ID,DB.PW);
			Statement stmt=connection.createStatement();
			String sql="SELECT * FROM Board";
			ResultSet rs=stmt.executeQuery(sql);
			while (rs.next()) {
				listBean=new ArticleBean();
				listBean.setArticleSeq(rs.getInt("article_seq"));
				listBean.setId(rs.getString("id"));
				listBean.setTitle(rs.getString("title"));
				listBean.setContent(rs.getString("content"));
				listBean.setHitCount(rs.getInt("hitcount"));
				listBean.setRegdate(rs.getString("regdate"));
				listArticles.add(listBean);
			}
		} catch (SQLException e) {
			System.out.println("LIST ARTICLES FAILED");
			e.printStackTrace();
		}
		
		return listArticles;
	}

	@Override
	public ArticleBean selectBySeq(int seqNo) {
		ArticleBean bean=new ArticleBean();
		Connection connection;
		try {
			connection = DriverManager.getConnection(DB.URL,DB.ID,DB.PW);
			Statement stmt= connection.createStatement();
			String sql="SELECT * FROM Board WHERE article_seq='"+seqNo+"'";
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next()){
				bean.setArticleSeq(Integer.parseInt(rs.getString("article_seq")));
				bean.setId(rs.getString("id"));
				bean.setTitle(rs.getString("title"));
				bean.setContent(rs.getString("content"));
				bean.setRegdate(rs.getString("regdate"));
				bean.setHitCount(rs.getInt("hitcount"));
			}
		} catch (Exception e) {
			System.out.println("SELECT BY SEQ FAILE");
			e.printStackTrace();
		}
		return bean;
	}

	@Override
	public List<ArticleBean> selectById(String id) {
		List<ArticleBean> list= new ArrayList<>();
		ArticleBean temp= null;
		try {
			Connection connection= DriverManager.getConnection(DB.URL,DB.ID,DB.PW);
			Statement stmt=connection.createStatement();
			String sql="SELECT * FROM Board WHERE id LIKE '%"+id+"%'";
			System.out.println("selectBYID SQL::::"+sql);
			ResultSet rs= stmt.executeQuery(sql);
			while (rs.next()) {
				temp=new ArticleBean();
				temp.setArticleSeq(rs.getInt("article_seq"));
				temp.setId(rs.getString("id"));
				temp.setTitle(rs.getString("title"));
				temp.setContent(rs.getString("content"));
				temp.setHitCount(rs.getInt("hitcount"));
				temp.setRegdate(rs.getString("regdate"));
				list.add(temp);
			}
		} catch (Exception e) {
		System.out.println("SELECT BY ID FAILED====");
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int updateArticle(ArticleBean update) {
		int updateArticle=0;
		try {
			Connection connection= DriverManager.getConnection(DB.URL,DB.ID,DB.PW);
			Statement stmt=connection.createStatement();
			int updateSeqNo=update.getArticleSeq();
			String updateTitle=update.getTitle();
			String updateContent=update.getContent();
			//UPDATE Board SET title='강아지',content='우리집 강아지는 복슬강아지' WHERE article_seq='1014';
			String sql="UPDATE Board SET title='"+updateTitle+"',content='"+updateContent+"' WHERE article_seq='"+updateSeqNo+"'";
			updateArticle=stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println("====updateArticle DAo failed===");
			e.printStackTrace();
		}
		
		return updateArticle;
	}

	@Override
	public int deleteArticle(int seq) {
		int deleteArticle=0;
		try {
			Connection connection=DriverManager.getConnection(DB.URL,DB.ID,DB.PW);
			Statement stmt=connection.createStatement();
			//DELETE FROM table [WHERE conditions];
			String sql="DELETE FROM Board WHERE article_seq='"+seq+"'";
			deleteArticle =stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println("DELETE DAOI ERROR");
			e.printStackTrace();
		}
		
		return deleteArticle;
	}

}
