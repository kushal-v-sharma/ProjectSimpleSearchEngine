import java.util.*;

public class SimpleSearchEngine {
    private Map<String, List<String>> documents;

    public SimpleSearchEngine() {
        documents = new HashMap<>();
    }

    public void addDocument(String documentId, String content) {
        List<String> words = Arrays.asList(content.toLowerCase().split("\\s+"));
        documents.put(documentId, words);
    }

    public List<String> search(String query) {
        List<String> results = new ArrayList<>();

        for (String documentId : documents.keySet()) {
            List<String> words = documents.get(documentId);
            if (words.contains(query.toLowerCase())) {
                results.add(documentId);
            }
        }

        return results;
    }

    public static void main(String[] args) {
        SimpleSearchEngine searchEngine = new SimpleSearchEngine();

        // Add documents to the search engine
        searchEngine.addDocument("doc1", "The cat is on the mat");
        searchEngine.addDocument("doc2", "The dog is chasing the cat");
        searchEngine.addDocument("doc3", "The bird is flying high");

        // Perform a search
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a search query: ");
        String query = scanner.nextLine();
        List<String> results = searchEngine.search(query);

        // Display search results
        if (results.isEmpty()) {
            System.out.println("No documents found");
        } else {
            System.out.println("Search results:");
            for (String documentId : results) {
                System.out.println("- Document ID: " + documentId);
                System.out.println("  Content: " + searchEngine.documents.get(documentId));
            }
        }

        scanner.close();
    }
}
