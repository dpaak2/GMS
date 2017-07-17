package com.hanbit.gms.DAO;
import java.util.List;
import com.hanbit.gms.domain.ArticleBean;

public interface ArticleDAO {
	public int insertArticle(ArticleBean bean);
	public int countArticles();
	public List<ArticleBean> listArticles(); 
	public ArticleBean selectBySeq(int seqNo);
	public List<ArticleBean> selectById(String id);
	public int updateArticle(ArticleBean update);
	public int deleteArticle(int seq);
}
