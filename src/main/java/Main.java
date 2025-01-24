import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) {

        try {
            HttpClient client = HttpClient.newHttpClient();
            URI ipinfoUri = new URI("https://ipinfo.io");

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(ipinfoUri)
                    .header("Accept", "application/json")
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String body = response.body();
            System.out.println(body);

        } catch (InterruptedException | IOException | URISyntaxException e) {
            e.printStackTrace();
        }

    }
}