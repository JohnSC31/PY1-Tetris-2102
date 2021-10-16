/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;

public class MatchList {
    
    public static final String MATCHFILEPATH = "./src/Data/Matches.txt";
    public static final Gson gson = new Gson();
    
    public static ArrayList<Match> getMatchList(){
        String matchesStr = FileManager.readFile(MATCHFILEPATH);
        ArrayList<Match> matchList = new ArrayList<>();
        if(!matchesStr.equals("")){
               matchList = gson.fromJson(matchesStr, new TypeToken<ArrayList<Match>>(){}.getType()); // se carga la lista de partidas
        }
        
        return matchList;
    }
    
    public static void saveMatch(Match match){
        ArrayList<Match> matchList = getMatchList();
        if(match.getMatchIndex() == -1){
            match.setMatchIndex(matchList.size()); 
            matchList.add(match); // se agrega la nueva
            
        }else{
            matchList.remove(match.getMatchIndex());
            matchList.add(match.getMatchIndex(), match);
        }
        
        String matchJSON = gson.toJson(matchList);
        FileManager.writeToFile(MATCHFILEPATH, matchJSON);
    }
    
    private static void saveMatchList(ArrayList<Match> matchList){
        String matchJSON = gson.toJson(matchList);
        FileManager.writeToFile(MATCHFILEPATH, matchJSON);
    }
    
    public static Match getMatch(int index){
        ArrayList<Match> matchList = getMatchList();
        return matchList.get(index);
    }
    
    public static int getMatchListLength(){
       return getMatchList().size();
    }
    
    public static void deleteMatch(int matchIndex){
        
        ArrayList<Match> matchList = getMatchList();
            
        if(matchIndex != -1){
            for(int i = 0; i < matchList.size(); i++){
                if(i >= matchIndex){
                    if(i == matchIndex) matchList.remove(matchIndex);
                    
                    if(matchList.size() > i) matchList.get(i).setMatchIndex(i);
                }
            }
            
            saveMatchList(matchList);
        }
    }
    
}
