package com.wheic.myapplication.adapters;

import java.util.ArrayList;

public class Data
{
   static ArrayList<model> eduData= new ArrayList<>();
   static ArrayList<model> healthcareData= new ArrayList<>();

    public static ArrayList<model> getEducationData()
    {
        model m1=new model("Saturn","3D model of a Saturn");
        model m2=new model("Satellite","3D model of a satellite");
        model m3=new model("Black Hole ","3D model of a Black hole");

        eduData.add(m1);
        eduData.add(m2);
        eduData.add(m3);

        return eduData;
    }

    public static ArrayList<model> getHealthcareData()
    {
        model m4=new model("Eye","3D model of an eye");
        model m5=new model("Skull","3D model of a skull");
        model m6=new model("ear ","3D model of a ear");

        healthcareData.add(m4);
        healthcareData.add(m5);
        healthcareData.add(m6);
        return healthcareData;
    }
}
