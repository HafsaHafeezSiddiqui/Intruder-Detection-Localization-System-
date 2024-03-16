package pckgnew;

import java.util.List;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.jpl7.*; // importing library files....


public class New {   
    
//    public static void printAdjacency(Map<String, int[]> adjM, int javaVar1, int javaVar2) {
//        
//    }
    

    
    public static void main(String[] args) {
        Query q = new Query("consult('newestestest.pl')");
        q.hasSolution();         
        String qry = "find_path(Floor, Apartment, Path).";
        q = new Query(qry);
        
 

        //mapping of the  solution when the query has been called
//        Map<String, Term>[] res = q.allSolutions(); //output of the query has been added in the map.
//
//            System.out.println(res[0]);
        
        
        Term var1 = q.getSolution().get("Floor");
        Term var2 = q.getSolution().get("Apartment");
        Term var3 = q.getSolution().get("Path");
        
        
        if (!var3.isList()) {
        // handle the case where var3 is not a list
    } else {
        // Create a new Java list to store the elements of var3
        Term[] array = var3.toTermArray();
        List<Term> javaList = new ArrayList<>(Arrays.asList(array));        
        
         int n=0;
        int chunkSize = 10; // you can adjust this value to suit your needs
        int counter = 0;
        while (n < javaList.size()) {
            // Print the elements of the Java list in chunks
            System.out.print("Path: ");
            for (int j = n; j < n + chunkSize && j < javaList.size(); j++) {
                System.out.print("(" + javaList.get(j).arg(1).intValue() + "," + javaList.get(j).arg(2).intValue() + ") ");
                counter++;
                if(counter == javaList.size()){
                    System.out.println();
                }
            }
            n += chunkSize;
        }
    }
        

        //System.out.println(var3.isList());
//        List<Term> javaList = new ArrayList<Term>();
//        
//        System.out.println("List size before loop: " + javaList.size());
//
//        while (var3.isList() == true) {
//
//        Term head = var3.arg(1);
//            // Add the element to the Java list
//        javaList.add(head);
//            // Get the rest of the list
//        var3 = var3.arg(2);}
//        
//        System.out.println("List size after loop: " + javaList.size());
//
//        
//        int n=0;
//        int chunkSize = 9000000; // you can adjust this value to suit your needs
//        while (n < javaList.size()) {
//            // Print the elements of the Java list in chunks
//            System.out.print("Path: ");
//            for (int j = n; j < n + chunkSize && j < javaList.size(); j++) {
//                System.out.print("(" + javaList.get(j).arg(1).intValue() + "," + javaList.get(j).arg(2).intValue() + ") ");
//                if((n+1) % chunkSize == 0 || n+1 == javaList.size()){
//                    System.out.println();
//                }
//            }
//            //System.out.println();
//            n += chunkSize;
//        }
    //}
        
//        System.out.print("Path: ");
//        for (Term element : javaList) {
//            System.out.print("(" + element.arg(1).intValue() + "," + element.arg(2).intValue() + ") ");
//        }
        

 /*
        // Iterate through the elements of the Prolog list
        while (var3.isList()) {
            // Get the first element of the list
            Term head = var3.arg(1);
            // Add the element to the Java list
            javaList.add(head);
            // Get the rest of the list
            var3 = var3.arg(2);
        }/
        
        // Print the elements of the Java list
        System.out.print("Path: ");
        for (Term element : javaList) {
            System.out.print("(" + element.arg(1).intValue() + "," + element.arg(2).intValue() + ") ");
        }
    }*/

    

        int javaVar1 = var1.intValue();
        int javaVar2 = var2.intValue();
        //String javaVar3 = var3.name();
        
//        List<Term> javaList = new ArrayList<Term>();
//        while(var3.isList()){
//            Term head = prologList.arg(1);
//            javaList.add(head);
//            prologList = prologList.arg(2);
//        }
//        
//        for(Term element : javaList){
//            System.out.println(element.name());
//        }
        
        
        
        

        Map<String, int[]> adjM = new HashMap<String, int[]>() {{
            put("1,1", new int[] {0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
            put("1,2", new int[] {1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0});
            put("1,3", new int[] {0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0});
            put("2,1", new int[] {1,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0});
            put("2,2", new int[] {0,1,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0});
            put("2,3", new int[] {0,0,1,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0});
            put("3,1", new int[] {0,0,0,1,0,0,0,1,0,1,0,0,0,0,0,0,0,0});
            put("3,2", new int[] {0,0,0,0,1,0,1,0,1,0,1,0,0,0,0,0,0,0});
            put("3,3", new int[] {0,0,0,0,0,1,0,1,0,0,0,1,0,0,0,0,0,0});
            put("4,1", new int[] {0,0,0,0,0,0,1,0,0,0,1,0,1,0,0,0,0,0});
            put("4,2", new int[] {0,0,0,0,0,0,0,1,0,1,0,1,0,1,0,0,0,0});
            put("4,3", new int[] {0,0,0,0,0,0,0,0,1,0,1,0,0,0,1,0,0,0});
            put("5,1", new int[] {0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,1,0,0});
            put("5,2", new int[] {0,0,0,0,0,0,0,0,0,0,1,0,1,0,1,0,1,0});
            put("5,3", new int[] {0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,1});
            put("6,1", new int[] {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0});
            put("6,2", new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,1});
            put("6,3", new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0});
        }};
        
        for (Map.Entry<String, int[]> entry : adjM.entrySet()) {
            String key = entry.getKey();
            int[] value = entry.getValue();

            String Floor=String.valueOf(javaVar1);
            String Apartment=String.valueOf(javaVar2); 

            
            String location = Floor + ","+  Apartment; 
//            System.out.println(location);

            if(key.equals(location)){
                        System.out.print("Apartment " + key + " is adjacent to: ");
                    }      
            for (int i = 0; i < 18; i++) {
                if(key.equals(location)){
                    if (value[i] == 1) {
                        int row = i / 3 + 1;
                        int col = i % 3 + 1;
                        System.out.print("(" + row + "," + col + ") ");
                    }
                }
            }
            
            System.out.println();
        }
    }
}
