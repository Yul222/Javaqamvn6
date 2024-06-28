public class MovieManager {

    private String[] movies = new String[0];
    private int limit;

    public MovieManager() {
        this.limit = 5; // Лимит по умолчанию
    }

    public MovieManager(int limit) {
        this.limit = limit;
    }

    public String[] addMovie(String movie) {
        String[] tmp = new String[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = movie;
        movies = tmp;
        return tmp;
    }

    public String[] findAll() {
        return movies;
    }

    public String[] findLast() {
        int resultLength;
        if (movies.length < limit) {
            resultLength = movies.length;
        } else {
            resultLength = limit;
        }
        String[] ans = new String[resultLength];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = movies[movies.length - 1 - i];
        }
        return ans;
    }
}