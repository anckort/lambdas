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
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
@AllArgsConstructor
@NoArgsConstructor
public final class Artist {
    @Setter@Getter
    private String name;
    @Setter@Getter
    private List<Artist> members;
    @Setter@Getter
    private String nationality;

    public Artist(String name, String nationality) {
        this(name, Collections.emptyList(), nationality);
    }

    public boolean isSolo() {
        return members.isEmpty();
    }

    public boolean isFrom(String nationality) {
        return this.nationality.equals(nationality);
    }

    @Override
    public String toString() {
        return getName();
    }

    public Artist copy() {
        List<Artist> members = getMembers().stream().map(Artist::copy).collect(toList());
        return new Artist(name, members, nationality);
    }

}
