package learn.cat.domain;

import learn.cat.data.SightingRepository;
import org.springframework.stereotype.Service;

@Service
public class SightingService {

    private final SightingRepository repository;

    public SightingService(SightingRepository repository) { this.repository = repository; }

}
