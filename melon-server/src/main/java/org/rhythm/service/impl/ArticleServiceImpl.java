package org.rhythm.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.rhythm.constant.MessageConstant;
import org.rhythm.dto.ArticleDTO;
import org.rhythm.dto.ArticlePageQueryDTO;
import org.rhythm.entity.Article;
import org.rhythm.entity.ArticleCatalogue;
import org.rhythm.entity.ArticleCategory;
import org.rhythm.exception.ArticleCategoryNotFoundException;
import org.rhythm.mapper.ArticleCatalogueMapper;
import org.rhythm.mapper.ArticleCategoryMapper;
import org.rhythm.mapper.ArticleMapper;
import org.rhythm.result.PageResult;
import org.rhythm.service.ArticleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private ArticleCategoryMapper categoryMapper;
    @Autowired
    private ArticleCatalogueMapper catalogueMapper;

    @Override
    public void add(ArticleDTO articleDTO) {
        Article article = Article.builder()
                .categoryId(articleDTO.getCategoryId())
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();
        BeanUtils.copyProperties(articleDTO, article);

        ArticleCategory category = categoryMapper.getById(articleDTO.getCategoryId());
        if(category == null){
            throw new ArticleCategoryNotFoundException(MessageConstant.ARTICLE_CATEGORY_NOT_FOUNT + " : " + articleDTO.getCategoryId());
        }

        ArticleCatalogue catalogue = ArticleCatalogue.builder()
                .articleId(article.getId())
                .numbers(articleDTO.getCatalogueNumbers())
                .contents(articleDTO.getCatalogueContents())
                .positions(articleDTO.getCataloguePositions())
                .build();
        catalogueMapper.insert(catalogue);
        log.info("article : {}", article);
        log.info("category : {}", category);
        log.info("catalogue : {}", catalogue);

        articleMapper.insert(article);
    }

    @Override
    public void addCategory(ArticleCategory articleCategory) {
        categoryMapper.insert(articleCategory);
    }

    @Override
    public PageResult pageQuery(ArticlePageQueryDTO articlePageQueryDTO) {
        //开始分页查询
        PageHelper.startPage(articlePageQueryDTO.getPage(), articlePageQueryDTO.getPageSize());
        Page<Article> page = articleMapper.pageQuery(articlePageQueryDTO);
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public void starOrStop(Integer status, Long id) {
        Article article = Article.builder()
                .status(status)
                .id(id)
                .build();
        articleMapper.update(article);
    }

    @Override
    public Article getById(Long id) {
        Article article = articleMapper.getById(id);
        return article;
    }

    @Override
    public void update(ArticleDTO articleDTO) {
        Article article = Article.builder()
                .categoryId(articleDTO.getCategoryId())
                .updateTime(LocalDateTime.now())
                .build();
        BeanUtils.copyProperties(articleDTO, article);

        ArticleCategory category = categoryMapper.getById(articleDTO.getCategoryId());
        if(category == null){
            throw new ArticleCategoryNotFoundException(MessageConstant.ARTICLE_CATEGORY_NOT_FOUNT + " : " + articleDTO.getCategoryId());
        }
        articleMapper.update(article);

        ArticleCatalogue catalogue = ArticleCatalogue.builder()
                .articleId(article.getId())
                .numbers(articleDTO.getCatalogueNumbers())
                .contents(articleDTO.getCatalogueContents())
                .positions(articleDTO.getCataloguePositions())
                .build();
        catalogueMapper.update(catalogue);
    }

    @Override
    public List<ArticleCategory> getCategories() {
        List<ArticleCategory> categoryList = catalogueMapper.list();
        log.info("ArticleCategoryList : {}", categoryList);
        return categoryList;
    }
}
