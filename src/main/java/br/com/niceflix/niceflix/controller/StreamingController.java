package br.com.niceflix.niceflix.controller;

import br.com.niceflix.niceflix.entity.Streaming;
import br.com.niceflix.niceflix.mapper.StreamingMapper;
import br.com.niceflix.niceflix.request.StreamingRequest;
import br.com.niceflix.niceflix.response.StreamingResponse;
import br.com.niceflix.niceflix.service.StreamingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/niceflix/streaming")
@RequiredArgsConstructor
public class StreamingController {

    private final StreamingService streamingService;

    @GetMapping()
    public ResponseEntity<List<StreamingResponse>> findAllStreaming() {
        return ResponseEntity.ok(streamingService.findAll()
                .stream()
                .map(StreamingMapper::toStreamingResponse)
                .toList());
    }

    @PostMapping()
    public ResponseEntity<StreamingResponse> createStreaming(@RequestBody StreamingRequest request) {
        Streaming newStreaming = StreamingMapper.toStreaming(request);
        Streaming savedStreaming = streamingService.createStreaming(newStreaming);
        return ResponseEntity.status(HttpStatus.CREATED).body(StreamingMapper.toStreamingResponse(savedStreaming));

    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingResponse> findByIdStreaming(@PathVariable Long id) {
        return streamingService.getByIdStreaming(id)
                .map(streaming -> ResponseEntity.ok(StreamingMapper.toStreamingResponse(streaming)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByIdStreaming(@PathVariable Long id) {
        streamingService.deleteByIdStreaming(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
