package br.com.niceflix.niceflix.controller;

import br.com.niceflix.niceflix.entity.Category;
import br.com.niceflix.niceflix.mapper.CategoryMapper;
import br.com.niceflix.niceflix.request.CategoryRequest;
import br.com.niceflix.niceflix.response.CategoryResponse;
import br.com.niceflix.niceflix.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("niceflix/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping()
    public ResponseEntity<List<CategoryResponse>> findAllCategory() {
        return ResponseEntity.ok(categoryService.findAll()
                .stream()
                .map(CategoryMapper::toCategoryResponse)
                .toList());
    }

    @PostMapping()
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody CategoryRequest request) {
        Category newCategory = CategoryMapper.toCategory(request);
        Category savedCategory = categoryService.createCategory(newCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(CategoryMapper.toCategoryResponse(savedCategory));

    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> findByIdCategory(@PathVariable Long id) {
        return categoryService.getByIdCategory(id)
                .map(category -> ResponseEntity.ok(CategoryMapper.toCategoryResponse(category)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByIdCategory(@PathVariable Long id) {
        categoryService.deleteByIdCategory(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
