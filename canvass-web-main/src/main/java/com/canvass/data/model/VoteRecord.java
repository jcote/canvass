package com.canvass.data.model;

import com.canvass.data.DataModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created By: jordancote
 * Created On: 12/7/13
 */
@Entity
@Table(name="vote_record")
public class VoteRecord extends DataModel {

    @Id
    @GeneratedValue
    private long id;


}
