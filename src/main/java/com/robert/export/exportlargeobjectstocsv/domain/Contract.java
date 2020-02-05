package com.robert.export.exportlargeobjectstocsv.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CONTRACT")
public class Contract {

    @Id @Column
    public String id;
    @Column
    public String title;
    @Column
    public String data1;
    @Column
    public String data2;
    @Column
    public String data3;
    @Column
    public String data4;
    @Column
    public String data5;
    @Column
    public String data6;
    @Column
    public String data7;

    @ElementCollection
    @CollectionTable(name = "list1", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "value")
    public Set<String> list1;
    @ElementCollection
    @CollectionTable(name = "list2", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "value")
    public Set<String> list2;

}