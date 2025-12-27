package br.com.niceflix.niceflix.service;

import br.com.niceflix.niceflix.entity.Streaming;
import br.com.niceflix.niceflix.repository.StreamingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StreamingService {
    private final StreamingRepository streamingRepository;

    public List<Streaming> findAll(){
        return streamingRepository.findAll();
    }

    public Streaming createStreaming(@RequestBody Streaming streaming){
        return streamingRepository.save(streaming);
    }
    public Optional<Streaming> getByIdStreaming(Long id){
        return streamingRepository.findById(id);
    }
    public void deleteByIdStreaming(Long id){
        streamingRepository.deleteById(id);
    }

}
