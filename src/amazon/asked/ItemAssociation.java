package amazon.asked;

import java.util.*;

public class ItemAssociation {
    public static void main(String[] args) {

        List<String[]> items=Arrays.asList(new String[]{"itemD", "itemE"}, new String[]{"itemI", "itemF"}, new String[]{"itemF", "itemO"},new String[]{"itemA", "itemB"}, new String[]{"itemB", "itemC"}, new String[]{"itemI","ItemF"},new String[]{"itemI","ItemK"});

        List<String> output=findAssociation(items);
        for(String s:output)
            System.out.print(s+", ");


//        List<String> output_one=findAssociationDayOne(items);
//        for(String s:output_one)
//            System.out.print(s+", ");

    }

//    static List<String> findAssociationDayOne(List<String[]> items){
//        HashMap<String, ArrayList<String>> map = new HashMap<>();
//        for(String[] item: items){
//            boolean item1 = map.containsKey(item[0]);
//            boolean item2 = map.containsKey(item[1]);
//            if( item1 == false && item2 == false){
//                ArrayList<String> newList = new ArrayList<>();
//                newList.add(item[0]);
//                newList.add(item[1]);
//                map.put(item[0],newList);
//                map.put(item[1], newList);
//            }else if( item1 == true && item2 == false){
//                ArrayList<String> exitingList = map.get(item[0]);
//                exitingList.add(item[1]);
//                map.put(item[0], exitingList);
//                map.put(item[1], exitingList);
//            }else if( item1 == false && item2 == true){
//                ArrayList<String> existingList = map.get(item[1]);
//                existingList.add(item[0]);
//                map.put(item[0], existingList);
//                map.put(item[1], existingList);
//            }else {
//
//            }
//        }
//
//    }

    static List<String> findAssociation(List<String[]> items) {

        Map<String, ArrayList<String>> map=new HashMap<>();

        for(String[] itemAss: items){

            boolean item1=map.containsKey(itemAss[0]);
            boolean item2=map.containsKey(itemAss[1]);


            if(item1==true && item2==false){ //add to existing
                ArrayList<String> existingAss=map.get(itemAss[0]);
                existingAss.add(itemAss[1]);
                map.put(itemAss[0],existingAss);
                map.put(itemAss[1],existingAss);
            } else if(item1==false && item2==true){//add to existing
                ArrayList<String> existingAss=map.get(itemAss[1]);
                existingAss.add(itemAss[0]);
                map.put(itemAss[0],existingAss);
                map.put(itemAss[1],existingAss);
            }else if(item1==false && item2==false){ //all new entries
                ArrayList<String> newList=new ArrayList<>();
                newList.add(itemAss[0]);
                newList.add(itemAss[1]);
                map.put(itemAss[0],newList);
                map.put(itemAss[1],newList);
            }else{ //both of these items list already exists
                ArrayList<String> existingAss = map.get(itemAss[0]);
                existingAss.addAll(map.get(itemAss[1]));
                LinkedHashSet<String> hashSet = new LinkedHashSet<>(existingAss);
                ArrayList<String> union=new ArrayList<>(hashSet);
                for(String eachUnion: union){
                    map.put(eachUnion,union);
                }
            }
        }
        ArrayList<ArrayList<String>> values= new ArrayList<>(map.values());
        ArrayList<String> maxList=new ArrayList<>();
        int maxCount=0;
        for(ArrayList<String> s: values){
            if(s.size()>maxCount){ // found new set
                maxCount=s.size();
                maxList=s;
                Collections.sort(maxList);
                Collections.sort(s);
                if(s.get(0).compareTo(maxList.get(0))<0){
                    maxCount=s.size();
                    maxList=s;
                }
            }
        }
        return maxList;
    }
}