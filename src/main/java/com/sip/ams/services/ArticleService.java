package com.sip.ams.services;

import java.util.List;
import java.util.Optional;

import com.sip.ams.entities.Article;

public interface ArticleService {
	List<Article>listArticles();
	Article getArticle(long id);
	Article saveArticle(long idProvider, Article article);
	void deleteArticle(long id);
	Optional<Article>findArticleById(long id);
}
