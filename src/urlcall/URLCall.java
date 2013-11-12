/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package urlcall;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author motaz
 */
public class URLCall {

    /**
    */
    public static void main(String[] args) {
        
      String result = callURL("http://www.google.com", "UTF-8");
      System.out.println(result);
        // TODO code application logic here
    }
    
    public static String callURL(String aURL, String encoding) {
        try {
            URL myURL = new URL(aURL);
            URLConnection myURLConnection = myURL.openConnection();
            myURLConnection.connect();        
    
            BufferedReader in = new BufferedReader(new InputStreamReader(
                                    myURLConnection.getInputStream(), encoding));
            String output = "";
            String inputLine;
            while ((inputLine = in.readLine()) != null) 
             output = output.concat(inputLine);
            in.close();    
    
            return(output);
            
    } catch (Exception ex) {

        return("Error: " + ex.toString());
    }
    }  
}
