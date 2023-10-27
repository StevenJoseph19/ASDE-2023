package org.acme.lombok;

import java.time.LocalDate;

import lombok.*;

/**
 * @Data is a convenient shortcut annotation that bundles the features of
 * @ToString, @EqualsAndHashCode, @Getter / @Setter and @RequiredArgsConstructor together.
 */

//@Data
@Getter
@Setter
@EqualsAndHashCode
//    @NoArgsConstructor
//    @RequiredArgsConstructor
//@AllArgsConstructor
@ToString
public class UserLombokModel {
    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private LocalDate createdDate;
    private LocalDate updatedDate;
    private String gender;
}