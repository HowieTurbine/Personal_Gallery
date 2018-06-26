package com.hibernate.model;

import javax.persistence.*;

@Entity
@Table(name = "id_list", schema = "gallery_data", catalog = "")
public class IdListEntity {
    private int id;
    private int idImg;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_img")
    public int getIdImg() {
        return idImg;
    }

    public void setIdImg(int idImg) {
        this.idImg = idImg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IdListEntity that = (IdListEntity) o;

        if (id != that.id) return false;
        if (idImg != that.idImg) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idImg;
        return result;
    }
}
