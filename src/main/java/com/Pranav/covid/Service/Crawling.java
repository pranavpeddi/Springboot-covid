package com.Pranav.covid.Service;


import com.Pranav.covid.Model.CovidData;
import com.Pranav.covid.Repository.CovidDataRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
    public class Crawling {


    @Autowired
private CovidDataRepository covidDataRepository;

 public void extractData()
 {
     try
     {
         CovidData covidData=new CovidData();
       final String url="https://www.worldometers.info/coronavirus/#countries";
         List <String>l1=new ArrayList();

         Document doc= Jsoup.connect(url).get();

         for(Element row:doc.select("#main_table_countries_today tr"))
         {

             if(row.select("td:nth-child(2)").text().equals(""))
             {
                 continue;
             }
             else
             {
                 String  ticker=row.select("td:nth-child(2)").text();
                 if(!ticker.contains("Total:"))
                 {
                     covidData.setCountry_cont(ticker);
                 }

                 String confirmed=row.select("td:nth-child(3) ").text().replaceAll(",","");


                 Long confir1=Long.parseLong(confirmed);
              System.out.println("Confirmed cases: "+confir1);
              covidData.setConfirmed(confir1);
                 String newcases=row.select("td:nth-child(4)").text();
                         if(!newcases.equals(""))
                         {
                             if(newcases.contains("+"))
                             {

                                 Long newc=Long.parseLong(newcases.substring(1,newcases.length()).replaceAll(",",""));
                                 System.out.print("new cases" + newc);
                                 covidData.setNewcases(newc);
                             }

                         }


                String d1=row.select("td:nth-child(5)").text().replaceAll(",","");
                         if(!d1.equals(""))
                         {       Long deaths=Long.parseLong(d1);
                             covidData.setDeaths(deaths);

                         }

                 String newrecovery=row.select("td:nth-child(6)").text().replaceAll(",","");
                 if(!newrecovery.equals(""))
                 {
                     Long   recovered=Long.parseLong(newrecovery);
                     System.out.println(recovered);
                     covidData.setRecovery(recovered);
                 }



             }


         }
         covidDataRepository.save(covidData);

     }
     catch (Exception e)
     {
         e.printStackTrace();
     }
 }
}
