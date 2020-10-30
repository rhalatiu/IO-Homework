package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import school.siit.Athlete;
import school.siit.TimeComparator;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */

    @Test
    public void calculateResult(){
        Athlete a1 = new Athlete("11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo");
        Athlete a2 = new Athlete("1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo");
        Athlete a3 = new Athlete("27,Piotr Smitzer,CZ,30:10,xxxxx,xxxxx,xxxxx");

        assertEquals(a1.getTotalTime(), new Integer(1857));
        assertEquals(a3.getAthleteSummary(), "Piotr Smitzer 30:10 (30:10 + 0)");

    }

    @Test
    public void verifySorting(){
        Athlete a1 = new Athlete("11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo");
        Athlete a2 = new Athlete("1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo");
        Athlete a3 = new Athlete("27,Piotr Smitzer,CZ,30:10,xxxxx,xxxxx,xxxxx");

        ArrayList<Athlete> athletes = new ArrayList<>();
        athletes.add(a1);
        athletes.add(a2);
        athletes.add(a3);
        Collections.sort(athletes, new TimeComparator());
        assertEquals(athletes.get(0).getName(), "Piotr Smitzer");
        assertEquals(athletes.get(1).getName(), "Jimmy Smiles");
        assertEquals(athletes.get(2).getName(), "Umar Jorgson");
    }

    @Test
    public void verifySorting2(){
        Athlete a1 = new Athlete("11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo");
        Athlete a2 = new Athlete("1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo");
        Athlete a3 = new Athlete("27,Piotr Smitzer,CZ,30:10,xxxxx,xxxxx,xxxxx");

        ArrayList<Athlete> athletes = new ArrayList<>();
        athletes.add(a1);
        athletes.add(a2);
        athletes.add(a3);
        Collections.sort(athletes, new TimeComparator());
        assertEquals(athletes.get(0).getName(), "Piotr Smitzer");
        assertEquals(athletes.get(1).getName(), "Jimmy Smiles");
        assertEquals(athletes.get(2).getName(), "mar Jorgson");
    }
}