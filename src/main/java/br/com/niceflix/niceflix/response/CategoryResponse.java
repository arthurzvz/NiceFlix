package br.com.niceflix.niceflix.response;

import lombok.Builder;

@Builder
public record CategoryResponse(Long id, String name) {
}
