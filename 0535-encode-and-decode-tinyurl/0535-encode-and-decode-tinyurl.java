public class Codec {

    private Map<String, String> urlToTiny;
    private Map<String, String> tinyToUrl;
    private int counter;
    private String baseUrl = "http://tinyurl.com/";

    public Codec() {
        urlToTiny = new HashMap<>();
        tinyToUrl = new HashMap<>();
        counter = 0;
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {

         if (urlToTiny.containsKey(longUrl)) {
            return baseUrl + urlToTiny.get(longUrl);
        }

        String tinyUrl = baseUrl + String.valueOf(counter);
        urlToTiny.put(longUrl, String.valueOf(counter));
        tinyToUrl.put(String.valueOf(counter), longUrl);
        counter++;
        return tinyUrl;
        
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {

         String tinyKey = shortUrl.replace(baseUrl, "");
        if (tinyToUrl.containsKey(tinyKey)) {
            return tinyToUrl.get(tinyKey);
        }
        return null; 
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));