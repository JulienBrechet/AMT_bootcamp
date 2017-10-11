/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.bootcamp.service;

import ch.heigvd.amt.bootcamp.model.Person;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Singleton;




@Singleton
public class pageSplitter implements pageSplitterLocal{
    
   @Override
   public List<Person> getPagePeople(List<Person> allPeople, int pageSize, int pageIndex){
      
      List<Person> pagePeople = new ArrayList<>();
      
       if(!allPeople.isEmpty()){
         int startIndex = pageIndex*pageSize;
         int possibleEndIndex = startIndex + pageSize - 1;
         int endIndex = Integer.min(possibleEndIndex, allPeople.size()-1);

         for(int i = startIndex; i <= endIndex; ++i){
            pagePeople.add(allPeople.get(i));
         }
      }
      
      return pagePeople;
   }
  
}
