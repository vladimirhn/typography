package domain.services.application;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class IdService {

    Random random = new Random();

    public long next() {
        long r = random.nextLong();
        return r < 0 ? -r : r;
    }
}
