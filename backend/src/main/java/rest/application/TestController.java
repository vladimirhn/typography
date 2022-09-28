package rest.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
public class TestController {

    @GetMapping("/test")
    public String get() {

        return null;
    }
}
