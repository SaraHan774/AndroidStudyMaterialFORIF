package sample1001;

import java.util.ArrayList;

public class ArrayListEx {

    //ArrayList - size(), get(index), remove(Object), add(Object)

    private ArrayList<Movie> arrayList = new ArrayList<>();

    public void iterateMovies(){
        for(int i = 0; i < arrayList.size(); i++){
            System.out.println("Printing : " + arrayList.get(i).getMovieTitle());
        }
    }

    public void makeMoviesList(){
        for(int i = 0; i < 10; i++){
            arrayList.add(new Movie(movieTitleHelper(i)));
        }
        System.out.println("Added " + arrayList.size() + " movies!");
    }

    public void deleteMovieByIndex(int index){
        Movie movie = arrayList.get(index);
        System.out.println("deleting " + movie.getMovieTitle());
        arrayList.remove(movie);
    }

    private String movieTitleHelper(int index){
        return "movie #" + index;
    }

}
