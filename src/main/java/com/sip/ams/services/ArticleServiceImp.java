package com.sip.ams.services;
import com.sip.ams.exceptions.ResourceNotFoundException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sip.ams.entities.Article;
import com.sip.ams.repositories.ArticleRepository;
import com.sip.ams.repositories.ProviderRepository;

@Service
public class ArticleServiceImp implements ArticleService{

	private final ArticleRepository articleRepository;
	private final ProviderRepository providerRepository;
	
	public ArticleServiceImp(ArticleRepository articleRepository,ProviderRepository providerRepository) {
		this.articleRepository = articleRepository;
		this.providerRepository = providerRepository;
	}

	@Override
	public List<Article> listArticles() {
		// TODO Auto-generated method stub
		return (List<Article>)this.articleRepository.findAll();
	}

	@Override
	public Article getArticle(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Article saveArticle(long idProvider, Article article) {
		return this.providerRepository.findById(idProvider).map(provider -> {
			article.setProvider(provider);
			return articleRepository.save(article);
			}).orElseThrow(() -> new ResourceNotFoundException("ProviderId " + idProvider + " not found"));

	}

	@Override
	public void deleteArticle(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Article> findArticleById(long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
