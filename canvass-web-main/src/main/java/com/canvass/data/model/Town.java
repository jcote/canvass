package com.canvass.data.model;

import com.canvass.data.DataModel;

import javax.persistence.*;

/**
 * Created By: jordancote
 * Created On: 12/7/13
 */
@Entity
@Table(name="town")
public class Town extends DataModel {
    @Id
    @GeneratedValue
    private long id;

    @Basic
    @Column(unique = true)
    private String name;
}
