import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by niuyi on 2017/5/8.
 */
public class Sort {
    public static void quickSortTest(){
        List<Integer> list = getList();
        quickSort(list, 0, list.size()-1);
        System.out.println("After sort: " + mergeList(list));
    }

    private static List<Integer> getList() {
        int size = 12;
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0 ; i < size ; i++){
            list.add(i);
        }

        Collections.shuffle(list);


//        list.add(2);
//        list.add(0);
//        list.add(1);
//        list.add(3);
        System.out.println("Origin List: " + list);
        return list;
    }

    private static void quickSort(List<Integer> list, int start, int end){
        if(start >= end)
            return;

        int middle = start + (end - start)/2;

        int pivot = list.get(middle);



        //switch pivot with last one

        Integer temp = list.get(end);
        list.set(end, pivot);
        list.set(middle, temp);

        int sortIndex = start;
        for(int i = start; i < end ; i++){
            if(list.get(i) <= pivot){
                //switch current with sortIndex;
                Integer temp2 = list.get(sortIndex);
                list.set(sortIndex, list.get(i));
                list.set(i, temp2);

                sortIndex++;
            }
        }

        list.set(end, list.get(sortIndex));
        list.set(sortIndex, pivot);


        quickSort(list, start, sortIndex - 1);
        quickSort(list, sortIndex + 1, end);
    }

    private static void  bubbleTest(List<Integer> list){
        int size = list.size();

        for(int i = 0 ; i < size; i ++){
            for(int j = i + 1 ; j < size; j++){
                if(list.get(j) < list.get(i)){
                    Integer temp = list.get(j);
                    list.set(j, list.get(i));
                    list.set(i, temp);
                }
            }
        }
    }

    public static void mergeSortTest(){
        List<Integer> list = getList();
        System.out.println("After sort: " + mergeList(list));
    }

    private static List<Integer> mergeList(List<Integer> list){
        if(list.size() <= 1)
            return list;

        int mid = (list.size() - 1)/2;

        List<Integer> left = list.subList(0, mid);
        List<Integer> right = list.subList(mid + 1, list.size() - 1);

        List<Integer> leftResult = mergeList(left);
        List<Integer> rightResult = mergeList(right);
        return merge2List(leftResult, rightResult);
    }

    private static List<Integer> merge2List(List<Integer> list1, List<Integer> list2){
        List<Integer> result = new ArrayList<Integer>();

        int count = list1.size() + list2.size();

        list1.add(Integer.MAX_VALUE);
        list2.add(Integer.MAX_VALUE);

        int index1 = 0;
        int index2 = 0;

        for(int i = 0 ; i < count ; i++){
            if(list1.get(index1) < list2.get(index2)){
                result.add(list1.get(index1));
                index1++;
            }else{
                result.add(list2.get(index2));
                index2++;
            }
        }

//        while(index1 <= list1.size() - 1 && index2 <= list2.size() - 1){
//            if(list1.get(index1) < list2.get(index2)){
//                result.add(list1.get(index1));
//                index1++;
//            }else{
//                result.add(list2.get(index2));
//                index2++;
//            }
//        }

        return result;
    }
}
