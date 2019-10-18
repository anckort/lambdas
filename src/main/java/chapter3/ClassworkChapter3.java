package chapter3;

import entity.Album;
import entity.Artist;
import entity.Track;
import services.SampleData;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Character.isDigit;


public class ClassworkChapter3 {
    private static final int ONE_MINUTE_LENGTH = 60;

    public static void working() {
//        //testing of example page 39
//        List<String> beginningWithNumbers = Stream.of("a","1abc","2abc","bca2").filter(value -> isDigit(value.charAt(0))).collect(Collectors.toList());
//        System.out.println(beginningWithNumbers.stream().map(String::valueOf).collect(Collectors.joining(", ")));
//        //testing of example page 43
//        int sum = Stream.of(1,2,3,4,5,6,7,8).reduce(0,(acc,element)->acc+element);
//        System.out.println(sum);

        // testing
        Album album = SampleData.manyTrackAlbum;
        List<Album> albums = SampleData.albums;
        //System.out.println(album.getMusicians().map(Artist::getName).collect(Collectors.joining(", ")));

        System.out.println("All songs:");
        System.out.println(albums.stream().flatMap(album1 -> album1.getTracks()
                .stream()).map(Track::getName)
                .collect(Collectors.joining(", ")));

//        System.out.println(album.getTracks().stream().map(Track::getName).collect(Collectors.joining(", ")));
        System.out.println(String.format("All song which length more then %s second", ONE_MINUTE_LENGTH));
        System.out.println(albums.stream().flatMap(album1 -> album1.getTracks().stream())
                .filter(track -> track.getLength() > ONE_MINUTE_LENGTH)
                .map(Track::getName)
                .collect(Collectors.joining(", ")));


//        System.out.println(album.getTracks().stream().filter(track -> track.getLength() > ONE_MINUTE_LENGTH).map(track -> track.getName()).collect(Collectors.joining(", ")));
    }
}
