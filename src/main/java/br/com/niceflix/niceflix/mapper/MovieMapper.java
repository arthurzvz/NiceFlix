package br.com.niceflix.niceflix.mapper;

import br.com.niceflix.niceflix.entity.Category;
import br.com.niceflix.niceflix.entity.Movie;
import br.com.niceflix.niceflix.entity.Streaming;
import br.com.niceflix.niceflix.request.MovieRequest;
import br.com.niceflix.niceflix.response.CategoryResponse;
import br.com.niceflix.niceflix.response.MovieResponse;
import br.com.niceflix.niceflix.response.StreamingResponse;

import java.util.List;

public class MovieMapper {
    public static Movie toMovie(MovieRequest request){
        List<Category> categories = request.categories().stream()
                .map(categoryId -> Category.builder().id(categoryId).build())
                .toList();

        List<Streaming> streamings = request.streamings().stream()
                .map(streamingId -> Streaming.builder().id(streamingId).build())
                .toList();
        return Movie.builder()
                .title(request.title())
                .description(request.description())
                .releaseDate(request.releaseDate())
                .rating(request.rating())
                .categories(categories)
                .streamings(streamings)
                .build();
    }
    public static MovieResponse toMovieResponse(Movie movie){
        List<CategoryResponse> categories = movie.getCategories().stream()
                .map(category -> CategoryMapper.toCategoryResponse(category))
                .toList();

        List<StreamingResponse> streamings = movie.getStreamings().stream()
                .map(streaming -> StreamingMapper.toStreamingResponse(streaming))
                .toList();
        return MovieResponse.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .description(movie.getDescription())
                .rating(movie.getRating())
                .categories(categories)
                .streamings(streamings)


                .build();
    }

}
