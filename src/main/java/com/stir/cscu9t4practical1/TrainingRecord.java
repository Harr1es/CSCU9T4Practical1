// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;




import java.util.*;


public class TrainingRecord {
    private List<Entry> tr;
    
    public TrainingRecord() {
        tr = new ArrayList<Entry>();
    } //constructor
    
    // add a record to the list
   public void addEntry(Entry e){
       tr.add(e);    
   } // addClass
   
   // look up the entry of a given day and month
   public String lookupEntry (int d, int m, int y) {
       ListIterator<Entry> iter = tr.listIterator();
       String result = "No entries found";
       while (iter.hasNext()) {
          Entry current = iter.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y) 
             result = current.getEntry();
            }
       return result;
   } // lookupEntry
// This method takes in a day, month, and year as input and returns a string 
// containing all the entries in a list that have the same date as the input.

public String FindAll_by_date(int d, int m, int y) {  // Question 2// 
    // Create a new list iterator for the "tr" list
    ListIterator<Entry> iter = tr.listIterator();
    
    // Initialize an empty string to hold the result
    String result = "";
    
    // Loop through each entry in the list
    while (iter.hasNext()) {
        // Get the current entry from the iterator
        Entry current = iter.next();
        
        // Check if the current entry's day, month, and year match the input
        if (current.getDay() == d && current.getMonth() == m && current.getYear() == y) {
            // If the entry matches, add its text to the result string
            result += current.getEntry() + ' ';
        }
    }
    
    // Return the result string
    return result;
}

public void removeEntry(String n, int d, int m, int y) {
	   ListIterator<Entry> iter = tr.listIterator();
    while (iter.hasNext()) {
       Entry current = iter.next();
       if ((current.getName()).compareToIgnoreCase(n) == 0 && current.getDay()==d && current.getMonth()==m && current.getYear()==y) 
     	  iter.remove();
    }
}

   
   // Count the number of entries
   public int getNumberOfEntries(){
       return tr.size();
   }
   // Clear all entries
   public void clearAllEntries(){
       tr.clear();
   }
   
} // TrainingRecord