/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication12;

import java.util.ArrayList;

/**
 *
 * @author skas
 */
public class SomeStr {
    public static void main(String [] args)
    {
        ArrayList<String> allCountriesTweet = new ArrayList<>();
        String []countries = {"GB", "USA"};
        String [] splitBy = {"go", "team"};
        for( int j = 0; j < splitBy.length; j++)
        {
            
            String tweetData = "BestgoUSATeamEvergoGBLol";
            System.out.println("test");

            String [] splitTweet = tweetData.split(splitBy[j]);

            for(int i = 0; i < splitTweet.length; i++)
            {
                for(int x = 0; x < countries.length; x++)
                {
                    if(splitTweet[i].contains(countries[x]))
                    {
                        allCountriesTweet.add(tweetData);
                    }
                }
            }
        }
        
        System.out.println(allCountriesTweet);
        
    }
}
