package org.rhythm.service;

import org.rhythm.dto.ArticleDTO;
import org.rhythm.dto.ArticlePageQueryDTO;
import org.rhythm.entity.Article;
import org.rhythm.entity.ArticleCategory;
import org.rhythm.entity.User;
import org.rhythm.result.PageResult;

public interface ArticleService {
    void add(ArticleDTO articleDTO);

    void addCategory(ArticleCategory articleCategory);

    PageResult pageQuery(ArticlePageQueryDTO articlePageQueryDTO);

    void starOrStop(Integer status, Long id);

    Article getById(Long id);

    void update(ArticleDTO articleDTO);
}
