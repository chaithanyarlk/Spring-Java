package com.example.models;

public class Song{
     String songNameString;
     String artist;

     public void setSongName(String songName){
          this.songNameString = songName;
     }

     public void setArtist(String artist){
          this.artist = artist;
     }

     public String getSongName(){
          return this.songNameString;
     }

     public String getArtist(){
          return this.artist;
     }

     public void playSong(){
          System.out.println("Playing song "+this.songNameString+" by "+this.artist);
     }
}