/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.Collections.unmodifiableList;
import static java.util.stream.Collectors.toList;

@AllArgsConstructor
@NoArgsConstructor
public class Album implements Performance {
    @Getter@Setter
    private String name;
    @Getter@Setter
    private List<Track> tracks;
    @Getter@Setter
    private List<Artist> musicians;

    public Artist getMainMusician() {
        return musicians.get(0);
    }

    public Stream<Artist> getMusicians() {
        return musicians.stream();
    }

    public Album copy() {
        List<Track> tracks = getTracks().stream().map(Track::copy).collect(toList());
        List<Artist> musicians = getMusicians().map(Artist::copy).collect(toList());
        return new Album(name, tracks, musicians);
    }

}
