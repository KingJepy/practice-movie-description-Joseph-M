package Controller;

import Models.MovieModel;
import Service.AIService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final AIService aiService;
    private final List<MovieModel> movies = new ArrayList<>();

    public MovieController(AIService aiService) {
        this.aiService = aiService;
    }

    @PostMapping
    public MovieModel addMovie(@RequestBody MovieModel request) {
        // Generate AI description
        String description = aiService.generateDescription(request.getTitle(), request.getRating());

        MovieModel movie = new MovieModel(request.getTitle(), request.getRating(), description);
        movies.add(movie);

        return movie; // return the newly added movie
    }

    @GetMapping
    public List<MovieModel> getMovies() {
        return movies; // return the list of movies
    }
}
