package com.hanbit.gms.DAO;
import java.util.List;
import com.hanbit.gms.domain.ArticleBean;

public interface ArticleDAO {
	public String insertArticle(ArticleBean bean);
	public String countArticles();
	public List<ArticleBean> listArticles(); 
	public ArticleBean selectBySeq(int seqNo);
	public List<ArticleBean> selectById(String id);
	public String updateArticle(ArticleBean update);
	public String deleteArticle(int seq);
}
