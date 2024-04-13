package org.rhythm.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.rhythm.annotation.AutoFill;
import org.rhythm.entity.ArticleCatalogue;
import org.rhythm.entity.ArticleCategory;
import org.rhythm.enumeration.OperationType;

@Mapper
public interface ArticleCatalogueMapper {
    @AutoFill(value = OperationType.INSERT)
    @Insert("insert into article_catalogue (numbers, contents, positions) " +
            "VALUES " +
            "(#{numbers},#{contents},#{positions})")
    void insert(ArticleCatalogue catalogue);


    void update(ArticleCatalogue catalogue);
}