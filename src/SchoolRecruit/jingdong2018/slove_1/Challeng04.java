package SchoolRecruit.jingdong2018.slove_1;


import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

/********************************************************************************
 * CodingInterviewGuide -- SchoolRecruit.jingdong2018.slove_1
 * @version 2017/09/24 22:49
 * @author xitangking, xtwyzh@gmail.com,xtwroot.com
 * xtwroot Copyrights (c) 2017. All rights reserved.
 ********************************************************************************/

public class Challeng04 {
    public static void main(String[] args) {
        String str = "http://www.pythonchallenge.com/pc/def/linkedlist.php?nothing=";
        String urlStr = str + "37278";
        for (int i = 0; i < 400; i++) {

            URL url = null;
            try {
                url = new URL(urlStr);
                InputStream is = url.openConnection().getInputStream();
                BufferedReader bis = new BufferedReader(new InputStreamReader(is));
                String s = bis.readLine();
                System.out.println(s);
                String s1 = s.split("is ")[1];
                urlStr = str + s1;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
