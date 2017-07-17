package com.hanbit.gms.service;
import java.util.List;
import com.hanbit.gms.domain.ArticleBean;

public interface ArticleService {
	public String addArticle(ArticleBean bean);
	public int countArticles();
	public List<ArticleBean> listArticles(); 
	public ArticleBean findBySeq(int seqNo);
	public List<ArticleBean> findById(String id); 
	public String updateArticle(ArticleBean update);
	public String deleteArticle(int seq);
}
