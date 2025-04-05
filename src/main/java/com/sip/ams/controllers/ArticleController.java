package com.sip.ams.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.sip.ams.entities.Article;
import com.sip.ams.services.ArticleService;
@RestController
@RequestMapping({"/articles","/home"})
//@CrossOrigin("*")
public class ArticleController {

	private final ArticleService articleService;
	
	public ArticleController(ArticleService articleService) {
		super();
		this.articleService = articleService;
	}

	@GetMapping("/")
    public List<Article> getAllArticles() {
        return this.articleService.listArticles() ;
    }
	
	@PostMapping("/{idProvider}")
    public Article saveAllArticle(@PathVariable("idProvider")long id, @RequestBody Article article) {
        return this.articleService.saveArticle(id, article) ;
    }

}
