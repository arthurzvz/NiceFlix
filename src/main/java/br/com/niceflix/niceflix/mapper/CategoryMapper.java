package br.com.niceflix.niceflix.mapper;

import br.com.niceflix.niceflix.entity.Category;
import br.com.niceflix.niceflix.request.CategoryRequest;
import br.com.niceflix.niceflix.response.CategoryResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {
    public static Category toCategory(CategoryRequest requestRequest) {
        return Category
                .builder()
                .name(requestRequest.name())
                .build();
    }

    public static CategoryResponse toCategoryResponse(Category category) {
        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
