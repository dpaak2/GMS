package com.hanbit.gms.controller;

import javax.swing.JOptionPane;

import com.hanbit.gms.constant.Butt;
import com.hanbit.gms.domain.ArticleBean;
import com.hanbit.gms.service.ArticleService;
import com.hanbit.gms.serviceImpl.ArticleServiceImpl;

public class BoardController {
	public static void main(String[] args) {
		Butt[] buttons = { Butt.EXIT, Butt.ADD, Butt.COUNT, Butt.LIST, Butt.FIND_SEQ, Butt.FIND_ID, Butt.UPDATE,
				Butt.DEL };
		ArticleBean article =null;
		
		while (true) {
			switch ((Butt)JOptionPane.showInputDialog(null,
					"BOARD ADMIN",
					"SELECT MENU",
					JOptionPane.QUESTION_MESSAGE,
					null,
					buttons,
					buttons[1]
					)) {
			case EXIT:JOptionPane.showMessageDialog(null, "system closed");	return;
			case ADD:
				article= new ArticleBean();
				article.setId(JOptionPane.showInputDialog("id"));
				article.setTitle(JOptionPane.showInputDialog("title"));
				article.setContent(JOptionPane.showInputDialog("content"));
				JOptionPane.showMessageDialog(null,ArticleServiceImpl.getInstance().addArticle(article));
				break;
			case COUNT:
				JOptionPane.showMessageDialog(null, ArticleServiceImpl.getInstance().countArticles());
				break;
			case LIST:
				JOptionPane.showMessageDialog(null,ArticleServiceImpl.getInstance().listArticles());
				break;
			case FIND_SEQ:
				int seqNo= Integer.parseInt(JOptionPane.showInputDialog("찾으실 article sequence number를 입력하세요"));
				JOptionPane.showMessageDialog(null,ArticleServiceImpl.getInstance().findBySeq(seqNo));
				break;
			case FIND_ID:
				JOptionPane.showMessageDialog(null,ArticleServiceImpl.getInstance().findById(JOptionPane.showInputDialog("조회하실 아이디 입력")));
				break;
			case UPDATE:
				article= new ArticleBean();
				int articleSeq=Integer.parseInt(JOptionPane.showInputDialog("update seqno?"));
				article.setArticleSeq(articleSeq);
				article.setTitle(JOptionPane.showInputDialog("update title"));
				article.setContent(JOptionPane.showInputDialog("update content"));
				JOptionPane.showMessageDialog(null,ArticleServiceImpl.getInstance().updateArticle(article));
				break;
			case DEL:
				int deleteSeq= Integer.parseInt(JOptionPane.showInputDialog("delete seq number?"));
				JOptionPane.showMessageDialog(null, ArticleServiceImpl.getInstance().deleteArticle(deleteSeq));
				break;
			default:
				break;
			}
		}
	}
}
