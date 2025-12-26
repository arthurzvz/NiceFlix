package br.com.niceflix.niceflix.service;

import br.com.niceflix.niceflix.entity.Category;
import br.com.niceflix.niceflix.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category createCategory(@RequestBody Category category){
        return categoryRepository.save(category);
    }
    public Optional<Category> getByIdCategory(Long id){
        return categoryRepository.findById(id);
    }
    public void deleteByIdCategory(Long id){
        categoryRepository.deleteById(id);
    }

}
