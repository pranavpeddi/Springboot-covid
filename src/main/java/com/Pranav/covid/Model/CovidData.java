package com.Pranav.covid.Model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;
import java.util.Date;



@Data
@Entity


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class CovidData {

    @Id
    private long id;

    private String country_cont;
    private long confirmed;
    private long deaths;
    private long newcases;
    private long recovery;
    private Date today;


}
