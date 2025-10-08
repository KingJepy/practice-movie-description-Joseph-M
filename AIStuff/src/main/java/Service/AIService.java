package AI.Fundementals.AIStuff.Service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import org.springframework.stereotype.Service;

import org.apache.http.HttpException;
import java.io.IOException;
import java.util.Scanner;

@Service
public class AIService {

    private final Client client;

    public AIService () {
        this.client = Client.builder()
                .apiKey(System.getenv("GOOGLE_API_KEY")).build();

    }

    //this is whats asked to the ai. we build a prompt
    public String generateDescription(String title, int rating) {
        String prompt = ("Write a description of the movie titled " + title + " thats rated " + rating + ".");

        GenerateContentResponse response = client.models.generateContent(
                "gemini-2.0-flash-001",
                prompt,
                null
        );
        return response.text();
    }
}
