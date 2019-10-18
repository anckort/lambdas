/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public final class Track {
    @Getter
    private final String name;
    @Getter
    private final int length;

    public Track copy() {
        return new Track(name, length);
    }

}
