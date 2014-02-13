package com.lpsil.sar.proxy;

import java.util.ArrayList;
import java.util.HashMap;

public class Blacklist
{
    public HashMap<String, ArrayList<String>> blackliste;
    public Blacklist()
    {
        this.blackliste = new HashMap<String, ArrayList<String>>();
        ArrayList<String> listeSites = new ArrayList<String>();
        listeSites.add("www.youporn.com");
        this.blackliste.put("127.0.0.1",listeSites);
    }
}
