package com.example.languageapp;

public class numberstrail {
    private String english,miwok;
    private int resid=0;
    int songid=R.raw.songs;
    public numberstrail(String m,String n,int id)
    {
        english=m;
        miwok=n;
        this.songid=id;
    }
    public numberstrail(String m,String n,int id,int songid)
    {
        english=m;
        miwok=n;
        resid=id;
        this.songid=songid;
    }
    public numberstrail(String m,String n)
    {
        english=m;
        miwok=n;

    }


    public String geteng()
    {
        return english;
    }
    public String getMiwok()
    {
        return miwok;
    }
    public int getid()
    {
        return resid;
    }
    public int getSongid()
    {
        return songid;
    }

}
