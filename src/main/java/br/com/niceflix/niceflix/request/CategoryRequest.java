package br.com.niceflix.niceflix.request;

import lombok.Builder;

@Builder
public record CategoryRequest(String name) {
}
