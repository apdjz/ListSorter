import java.io.*;
import java.util.*;

public class organizer {
 public static void main(String[] args) throws Exception {
 
   BufferedReader reader = new BufferedReader(new FileReader("jobList.txt"));

   //add a comparator to the map. We want to compare the string ignoring the case.
   //the treemap object will use this comparator to do comparison between 2 keys
   Map < String, String > map = new TreeMap < String, String > (new Comparator < String > () {
    @Override
    public int compare(String o1, String o2) {
     return o1.compareToIgnoreCase(o2);
    }
   });

   String key = "", value = "", line;
   //read a key. Then keep reading all lines and collect them as value until a blank line is seen
   while ((key = reader.readLine()) != null) {
    value = "";
    while ((line = reader.readLine()) != null)
    {
     if (line.trim().equals("")) //is it a blank line. then finished reading all lines for value
      break;
     value += line + "\n";
    }

    map.put(key, value);
   }

   reader.close();
   FileWriter writer = new FileWriter("jobList.txt");
   for (String k: map.keySet()) {
    writer.write(k + "\n" + map.get(k));
    writer.write('\n');
   }
   writer.close();
  }
  /*
     private static String getField(String lines) {
         return lines;
     }
  */
}
