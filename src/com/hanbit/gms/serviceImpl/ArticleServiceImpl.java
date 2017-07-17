package com.hanbit.gms.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.hanbit.gms.DAO.ArticleDAO;
import com.hanbit.gms.DAOImpl.ArticleDAOImpl;
import com.hanbit.gms.domain.ArticleBean;
import com.hanbit.gms.service.ArticleService;

public class ArticleServiceImpl implements ArticleService {
	@Override
	public String addArticle(ArticleBean bean) {
		String addResult="";
		ArticleDAO dao= new ArticleDAOImpl();
		if(dao.insertArticle(bean)==1){
			addResult="등록이 완료 되었습니다.";
		}else{
			addResult="등록이 실패되었습니다.";
		}
		 
		return addResult;
	}
	
	@Override
	public int countArticles() {
		ArticleDAO dao= new ArticleDAOImpl();
		return dao.countArticles();
	}

	@Override
	public ArticleBean findBySeq(int seqNo) {
		ArticleDAO dao=new ArticleDAOImpl();
		return dao.selectBySeq(seqNo);
	}

	@Override
	public List<ArticleBean> findById(String id) {
		List<ArticleBean> findByIdList =new ArrayList<>();
		ArticleDAO dao=new ArticleDAOImpl();
		findByIdList=dao.selectById(id);
		return findByIdList;
	}

	@Override
	public String updateArticle(ArticleBean update) {
		String updateArticle="";
		ArticleDAO dao=new ArticleDAOImpl();
		if(dao.updateArticle(update)==1){
			updateArticle="update success";
		}else{
			updateArticle="update fail";
		}
		return updateArticle;
	}

	@Override
	public String deleteArticle(int seq) {
		String deleteArticle="";
		ArticleDAO dao=new ArticleDAOImpl();
		if(dao.deleteArticle(seq)==1){
			deleteArticle="성공적으로 삭제되었습니다.";
		}else{
			deleteArticle="delete failed";
		}
		return deleteArticle;
	}

	@Override
	public List<ArticleBean> listArticles() {
		List<ArticleBean> listArticles= new ArrayList<>();
		ArticleDAO dao= new ArticleDAOImpl();
		listArticles=dao.listArticles();
		return listArticles;
	}



}
