package br.com.deivisondfs2.android.domain;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by deivisonfrancisco on 29/04/16.
 */
public class Team implements Parcelable{

    public static final Integer THREE_POINTS = 3;
    public static final Integer TWO_POINTS = 2;
    public static final Integer ONE_POINT = 1;

    private int codigo;
    private String name;
    private int points;

    private int totalThreePoints;
    private int totalTwoPoints;
    private int totalOnePoints;

    public Team(int codigo, String nome, int pontos) {
        this.codigo = codigo;
        this.name = nome;
        this.points = pontos;
    }

    public Team(Parcel parcel){
        this.codigo = parcel.readInt();
        this.name = parcel.readString();
        this.points = parcel.readInt();
        this.totalThreePoints = parcel.readInt();
        this.totalTwoPoints = parcel.readInt();
        this.totalOnePoints = parcel.readInt();
    }

    public static final Parcelable.Creator<Team> CREATOR
            = new Parcelable.Creator<Team>() {
        public Team createFromParcel(Parcel in) {
            return new Team(in);
        }

        public Team[] newArray(int size) {
            return new Team[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(codigo);
        parcel.writeString(name);
        parcel.writeInt(points);
        parcel.writeInt(totalThreePoints);
        parcel.writeInt(totalTwoPoints);
        parcel.writeInt(totalOnePoints);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalThreePoints() {
        return totalThreePoints;
    }

    public void setTotalThreePoints(int totalThreePoints) {
        this.totalThreePoints = totalThreePoints;
    }

    public int getTotalTwoPoints() {
        return totalTwoPoints;
    }

    public void setTotalTwoPoints(int totalTwoPoints) {
        this.totalTwoPoints = totalTwoPoints;
    }

    public int getTotalOnePoints() {
        return totalOnePoints;
    }

    public void setTotalOnePoints(int totalOnePoints) {
        this.totalOnePoints = totalOnePoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Team)) return false;

        Team team = (Team) o;

        return codigo == team.codigo;

    }

    @Override
    public int hashCode() {
        return codigo;
    }

    public void addPoints(int points){
        verirySpecificPoints(points);
        this.points += points;
    }

    private void verirySpecificPoints(int points) {
        if (points == THREE_POINTS){
            totalThreePoints++;
        }
        if (points == TWO_POINTS){
            totalTwoPoints++;
        }
        if (points == ONE_POINT){
            totalOnePoints++;
        }
    }


}
